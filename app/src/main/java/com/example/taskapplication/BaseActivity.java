package com.example.taskapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.taskapplication.fragments.HomeFragment;
import com.example.taskapplication.fragments.ServicesFragment;
import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity {

    public Toolbar mToolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        mToolbar = findViewById(R.id.mainAppBar);
        //Toolbar
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //drawer layout code....
        drawerLayout = (DrawerLayout) findViewById(R.id.drawable_layout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(BaseActivity.this,drawerLayout,mToolbar,  R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        actionBarDrawerToggle.setDrawerIndicatorEnabled(false);
        actionBarDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        actionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        navigationView.inflateMenu(R.menu.main_menu);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                UserMenuSelector(item);

                return false;
            }
        });

        View navView = navigationView.inflateHeaderView(R.layout.navigation_header);


        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                new HomeFragment()).commit();

    }


    private void UserMenuSelector(MenuItem item)
    {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.nav_home:
                selectedFragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                        selectedFragment).commit();
                mToolbar.setTitle("Home");
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_services:
                selectedFragment = new ServicesFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                        selectedFragment).commit();
                mToolbar.setTitle("Government Services");
                drawerLayout.closeDrawers();
                break;


        }
    }
}