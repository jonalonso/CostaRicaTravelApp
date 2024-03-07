package com.jsalazar.costaricatravel;


import static com.jsalazar.costaricatravel.constants.adsValues.PREMIUM_APP;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.jsalazar.costaricatravel.constants.fragmentId;
import com.jsalazar.costaricatravel.databinding.ActivityMainBinding;
import com.jsalazar.costaricatravel.interfaces.fragmentInit;
import com.jsalazar.costaricatravel.utils.AdsController;
import com.jsalazar.costaricatravel.utils.ViewDialog;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity implements fragmentInit{

    private AppBarConfiguration mAppBarConfiguration;

    private AdView actualBanner;

    private Menu MainMenu;
    private fragmentId lastFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                if(MainActivity.this.actualBanner!=null){
                    AdsController.destroyBanner(MainActivity.this.actualBanner);
                }
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                if(MainActivity.this.actualBanner!=null){
                    AdsController.displayBanner(MainActivity.this.actualBanner);
                }
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,
                R.id.nav_places,
                R.id.nav_bus,
                R.id.nav_food,
                R.id.nav_settings)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        List<String> testDeviceIds = Arrays.asList("777d67ae-1180-456d-ba84-d8bd503515de","beeae8b9-85d2-4b6f-807f-b4c3e540dc6a");
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
        if(!PREMIUM_APP){
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
        if (lastFragment == fragmentId.FOOD || lastFragment == fragmentId.BUS) {
            inflater.inflate(R.menu.help_option_menu, this.MainMenu);
        }else if (lastFragment == fragmentId.PLACES) {
            inflater.inflate(R.menu.filter_option_menu, this.MainMenu);
        } else if (lastFragment == fragmentId.HOME && !PREMIUM_APP) {
            inflater.inflate(R.menu.premium_option_menu, this.MainMenu);
        }

        AdsController.displayInterstitial(this);
    }

    @Override
    public void setBannerAdView(AdView view) {
        this.actualBanner = view;
        AdsController.displayBanner(this.actualBanner);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.help_modal){
            if(lastFragment == fragmentId.FOOD){
                ViewDialog.showDialog(this,R.string.info_modal_food);
            } else if(lastFragment == fragmentId.BUS){
                ViewDialog.showDialog(this,R.string.info_modal_bus);
            }
        }else if(item.getItemId() == R.id.filter_modal){
            if(lastFragment == fragmentId.PLACES){
                ViewDialog.showDialog(this,R.string.food_1_description);
            }
        } else if(item.getItemId() == R.id.premium_modal){
            if(lastFragment == fragmentId.HOME && !PREMIUM_APP){
                ViewDialog.showAdsFreeDialog(this);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}