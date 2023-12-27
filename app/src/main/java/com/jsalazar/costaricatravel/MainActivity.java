package com.jsalazar.costaricatravel;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.ads.MobileAds;
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
import com.jsalazar.costaricatravel.utils.ViewDialog;


public class MainActivity extends AppCompatActivity implements fragmentInit {

    private AppBarConfiguration mAppBarConfiguration;

    private Menu MainMenu;
    private fragmentId lastFragment;

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
        }
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
        }
        return super.onOptionsItemSelected(item);
    }
}