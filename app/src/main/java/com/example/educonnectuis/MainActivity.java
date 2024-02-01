package com.example.educonnectuis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this, R.id.frame_layout);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

     //   Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.nav_developer) {
            Toast.makeText(this, "Developers", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.nav_video) {
            Toast.makeText(this, "Video Tutorials", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.nav_rate) {
            Toast.makeText(this, "Rate Us..!", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.nav_ebook) {
            Toast.makeText(this, "Ebooks", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.nav_theme) {
            Toast.makeText(this, "Theme", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.nav_website) {
            Toast.makeText(this, "Website", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.nav_share) {
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}