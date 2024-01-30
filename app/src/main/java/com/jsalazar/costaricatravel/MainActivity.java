package com.jsalazar.costaricatravel;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.jsalazar.costaricatravel.constants.adsValues;
import com.jsalazar.costaricatravel.constants.fragmentId;
import com.jsalazar.costaricatravel.databinding.ActivityMainBinding;
import com.jsalazar.costaricatravel.interfaces.fragmentInit;
import com.jsalazar.costaricatravel.utils.ViewDialog;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements fragmentInit {

    private AppBarConfiguration mAppBarConfiguration;

    private Menu MainMenu;
    private fragmentId lastFragment;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,
                R.id.nav_places,
                R.id.nav_food,
                R.id.nav_settings)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        List<String> testDeviceIds = Arrays.asList("beeae8b9-85d2-4b6f-807f-b4c3e540dc6a","a0135c0b-dbd5-4269-aa9d-f94dd55705fd","00000000-0000-0000-0000-000000000000");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);
        MobileAds.initialize(this, initializationStatus -> {
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.MainMenu = menu;
        this.MainMenu.clear();
        if(!adsValues.PREMIUM_APP){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.premium_option_menu, this.MainMenu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onFragmentInteraction(fragmentId fragment) {
        lastFragment = fragment;
        if(MainMenu == null){
            return;
        }
        this.MainMenu.clear();
        MenuInflater inflater = getMenuInflater();
        if (lastFragment == fragmentId.FOOD) {
            inflater.inflate(R.menu.help_option_menu, this.MainMenu);
        }else if (lastFragment == fragmentId.PLACES) {
            inflater.inflate(R.menu.filter_option_menu, this.MainMenu);
        } else if (lastFragment == fragmentId.HOME && !adsValues.PREMIUM_APP) {
            inflater.inflate(R.menu.premium_option_menu, this.MainMenu);
        }

        int randomValue = new Random().nextInt(101);
        if (mInterstitialAd != null && randomValue< adsValues.ADS_PERCENTAGE) {
            mInterstitialAd.show(this);
        }
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,getString(R.string.interstitial_ads), adRequest,
        new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                mInterstitialAd = interstitialAd;
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                mInterstitialAd = null;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.help_modal){
            if(lastFragment == fragmentId.FOOD){
                ViewDialog.showDialog(this,R.string.info_modal_food);
            }
        }else if(item.getItemId() == R.id.filter_modal){
            if(lastFragment == fragmentId.PLACES){
                ViewDialog.showDialog(this,R.string.food_1_description);
            }
        } else if(item.getItemId() == R.id.premium_modal){
            if(lastFragment == fragmentId.HOME && !adsValues.PREMIUM_APP){
                ViewDialog.showAdsFreeDialog(this);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}