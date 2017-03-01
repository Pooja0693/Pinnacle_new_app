package com.example.parulchopra.pinnacle_new_app;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

    public class DisplayActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display);

Intent i = getIntent();

 int pos=i.getIntExtra("position",0);


            switch (pos){
                case 0:
                    Fragment f1;
                    f1 = new PdfDisplayFragment();
                    FragmentManager fn = getSupportFragmentManager();
                    FragmentTransaction ft = fn.beginTransaction();
                    ft.replace(R.id.displayframe, f1);
                    ft.commit();
                    break;
                case 1:
                    Fragment f2;
                    f2 = new VideoDisplayFragment();
                    FragmentManager fn2 = getSupportFragmentManager();
                    FragmentTransaction ft2 = fn2.beginTransaction();
                    ft2.replace(R.id.displayframe, f2);
                    ft2.commit();
                    break;
                case 2:
                    Fragment f3;
                    f3 = new TestDisplayFragment();
                    FragmentManager fn3 = getSupportFragmentManager();
                    FragmentTransaction ft3 = fn3.beginTransaction();
                    ft3.replace(R.id.displayframe, f3);
                    ft3.commit();
                    break;


            }







        }

    }