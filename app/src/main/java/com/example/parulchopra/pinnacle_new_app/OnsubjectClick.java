package com.example.parulchopra.pinnacle_new_app;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class OnsubjectClick extends AppCompatActivity {

    ViewPager v11;
    TabLayout t11;
    int GETPOSITION;

private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onsubject_click);
        GETPOSITION = getIntent().getIntExtra("PASSPOSITION",-1);


        toolbar=(Toolbar)findViewById(R.id.T1);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
        {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

       v11=(ViewPager) findViewById(R.id.v1);
        v11.setAdapter(new CustomAdapter(getSupportFragmentManager(),getApplicationContext()));
        t11=(TabLayout) findViewById(R.id.t1);
        switch(GETPOSITION){

            case 0:
                t11.setBackgroundColor(getResources().getColor(R.color.holo_purple));
                toolbar.setBackgroundColor(getResources().getColor(R.color.holo_purple));

                Toast.makeText(getApplicationContext(),"helohdvh",Toast.LENGTH_LONG).show();
                break;
            case 1:
                t11.setBackgroundColor(getResources().getColor(R.color.holo_blue));
                toolbar.setBackgroundColor(getResources().getColor(R.color.holo_blue));

                Toast.makeText(getApplicationContext(),"gdyfuihdsjfhujd",Toast.LENGTH_LONG).show();
                break;
            case 2:
                t11.setBackgroundColor(getResources().getColor(R.color.holo_red));
                toolbar.setBackgroundColor(getResources().getColor(R.color.holo_red));

                Toast.makeText(getApplicationContext(),"gdgfdhguyfdhg8uioje4ri",Toast.LENGTH_LONG).show();
                break;
            case 3:
                t11.setBackgroundColor(getResources().getColor(R.color.holo_green));
                toolbar.setBackgroundColor(getResources().getColor(R.color.holo_green));

                Toast.makeText(getApplicationContext(),"hgdiufyufjdh",Toast.LENGTH_LONG).show();
                break;
        }
        t11.setupWithViewPager(v11);
        t11.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                v11.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                v11.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                v11.setCurrentItem(tab.getPosition());
            }
        });
    }


    private class CustomAdapter extends FragmentPagerAdapter {
        String[] a={"PDF","VIDEOS","PRACTICE TEST"};
        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new Pdf_frag().newInstance(GETPOSITION);
                case 1:
                    return new Video_fragment().newInstance(GETPOSITION);
                case 2:
                    return new Test_frag().newInstance(GETPOSITION);
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return a.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return a[position];
        }


    }












    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            finish();
        }



        return super.onOptionsItemSelected(item);
    }
}

