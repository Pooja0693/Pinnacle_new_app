package com.example.parulchopra.pinnacle_new_app;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Frag_cardview_showsubjects.MainListener {
private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView  navigationView;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();
        drawerLayout.addDrawerListener(drawerToggle);

        Fragment f1;
        f1 = new Frag_cardview_showsubjects();
        FragmentManager fn = getSupportFragmentManager();
        FragmentTransaction ft = fn.beginTransaction();
        ft.replace(R.id.frame1, f1);
        ft.commit();

    }

    @Override
    public void subjectSelected(int position) {

        Intent i= new Intent(this,OnsubjectClick.class);
        i.putExtra("PASSPOSITION",position);
        startActivity(i);
        }




    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.

        drawerToggle.syncState();
    }



    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }


    public boolean onOptionItemSelected(MenuItem item){
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void doubt(MenuItem item){
        Toast.makeText(getApplicationContext(),"heloooo",Toast.LENGTH_SHORT).show();
    }
}
