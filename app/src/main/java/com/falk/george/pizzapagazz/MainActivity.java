package com.falk.george.pizzapagazz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ShareActionProvider shareActionProvider;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
//
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.pizza_nav:
                        makeToast("We have a large choice of pizza");
                        break;
                    case R.id.drinks_nav:
                        makeToast("We have a large choice of drinks");
                        break;
                    case R.id.pasta_nav:
                        makeToast("We have a large choice of pasta");
                }
                return false;
            }
        });

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout layout = findViewById(R.id.drawer_layout);
        if (layout.isDrawerOpen(GravityCompat.START)) {
            layout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Want to join some pizza?");
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent(String s) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, s);
        shareActionProvider.setShareIntent(intent);
    }

    public void makeToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);

            case R.id.action_share:
        }

        return super.onOptionsItemSelected(item);
    }

    public void locationClicked(View view) {

        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);

    }

    public void makeSnackbar(String s) {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator), s, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    public void onCallClicked(View view) {
        Uri number = Uri.parse("tel:0546358158");
        Intent intent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(intent);
    }

    public void onEmailClicked(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "contact@georgefalk.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "I want some pizza!");
        intent.putExtra(Intent.EXTRA_TEXT, "May i reserve a table at 8 PM?");
        startActivity(intent);
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TopFragment();
                case 1:
                    return new PizzaFragment();
                case 2:
                    return new DrinkFragment();
                case 3:
                    return new StoresFragment();

            }

            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "HOME";
                case 1:
                    return "PIZZA";
                case 2:
                    return "DRINKS";
                case 3:
                    return "BRANCHES";

            }

            return null;
        }
    }
}
