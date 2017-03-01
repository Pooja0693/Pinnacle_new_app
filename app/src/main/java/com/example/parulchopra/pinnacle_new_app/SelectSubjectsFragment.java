package com.example.parulchopra.pinnacle_new_app;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SelectSubjectsFragment extends Fragment {


    SubjectSelectListener listenerobject;

         public interface SubjectSelectListener {
         public void subjectSelected(int position);
         }


       @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.subjectselectedfragment, container, false);

        CardView b1 = (CardView) view.findViewById(R.id.cardview1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Button id headline1 in fragment_headline is pressed
                listenerobject.subjectSelected(0);
            }
        });
        CardView b2 = (CardView) view.findViewById(R.id.cardview2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Button id headline1 in fragment_headline is pressed
                listenerobject.subjectSelected(1);
            }
        });
        CardView b3 = (CardView) view.findViewById(R.id.cardview3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Button id headline1 in fragment_headline is pressed
                listenerobject.subjectSelected(2);
            }
        });
        CardView b4 = (CardView) view.findViewById(R.id.cardview4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Button id headline1 in fragment_headline is pressed
                listenerobject.subjectSelected(3);
            }
        });

        return view;

     }
        @Override
        public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            listenerobject = (SubjectSelectListener) activity;
        } catch (ClassCastException e) {};
        }
    }


