package com.example.parulchopra.pinnacle_new_app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class OnSunjectSelectedActivity extends AppCompatActivity implements Video_frag.OnSubjectClicklistener,Test_frag.OnSubjectTestClicklistener{

    ViewPager v11;
    TabLayout t11;
    int position;
    Window window;
    private Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onsubject_click);
        position = getIntent().getIntExtra("PASSPOSITION",-1);

        toolbar=(Toolbar)findViewById(R.id.T1op);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
        {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        v11=(ViewPager) findViewById(R.id.v1);
        v11.setAdapter(new CustomAdapter(getSupportFragmentManager(),getApplicationContext()));
        t11=(TabLayout) findViewById(R.id.t1);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.BLACK);


        switch(position){

            case 0:
                t11.setBackgroundColor(getResources().getColor(R.color.holo_purple));
                toolbar.setBackgroundColor(getResources().getColor(R.color.holo_purple));

                Toast.makeText(getApplicationContext(),"Case 0 clicked",Toast.LENGTH_LONG).show();
                break;
            case 1:
                t11.setBackgroundColor(getResources().getColor(R.color.holo_blue));
                toolbar.setBackgroundColor(getResources().getColor(R.color.holo_blue));

                Toast.makeText(getApplicationContext(),"Case 1 clicked",Toast.LENGTH_LONG).show();
                break;
            case 2:
                t11.setBackgroundColor(getResources().getColor(R.color.holo_red));
                toolbar.setBackgroundColor(getResources().getColor(R.color.holo_red));

                Toast.makeText(getApplicationContext(),"Case 2 clicked",Toast.LENGTH_LONG).show();
                break;
            case 3:
                t11.setBackgroundColor(getResources().getColor(R.color.holo_green));
                toolbar.setBackgroundColor(getResources().getColor(R.color.holo_green));

                Toast.makeText(getApplicationContext(),"Case 3 clicked",Toast.LENGTH_LONG).show();
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

         @Override
          public void videoSelected(int position, String url) {
          Intent i = new Intent(this,DisplayActivity.class);

            // i.putExtra("url",url);
            i.putExtra("position",position);
            startActivity(i);

             }


    public void pdfSelected(int position, String url) {
        Intent i = new Intent(this,DisplayActivity.class);

        // i.putExtra("url",url);
        i.putExtra("position",position);
        startActivity(i);
    }

    @Override
    public void testSelected(int position, String url) {

        Intent i = new Intent(this,DisplayActivity.class);

        // i.putExtra("url",url);
        i.putExtra("position",position);
        startActivity(i);
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
                    return new Pdf_frag().newInstance(OnSunjectSelectedActivity.this.position);
                case 1:
                    return new Video_frag().newInstance(OnSunjectSelectedActivity.this.position);
                case 2:
                    return new Test_frag().newInstance(OnSunjectSelectedActivity.this.position);
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

