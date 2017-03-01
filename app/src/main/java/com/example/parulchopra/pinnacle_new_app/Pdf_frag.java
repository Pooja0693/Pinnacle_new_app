package com.example.parulchopra.pinnacle_new_app;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.parulchopra.pinnacle_new_app.Adapters.PdfRecyclerAdapter;

import java.util.ArrayList;


public class Pdf_frag extends Fragment {
    private PdfRecyclerAdapter.OnSubjectPdfClicklistener pdfClicklistener;
    private int SubPosition;
    public  Pdf_frag newInstance(int position) {
        Pdf_frag f = new Pdf_frag();
        SubPosition = position;
        Bundle args = new Bundle();
        args.putInt("index", position);
        f.setArguments(args);
        return f;

    }

    private RecyclerView r;
    private RecyclerView.Adapter a;
    private RecyclerView.LayoutManager l;


        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_pdf_frag, container, false);
            ArrayList<Pdf_model> pdf_models = new ArrayList<Pdf_model>();

            Pdf_model pdf1= new Pdf_model("1","rumani","parul");
            pdf_models.add(pdf1);


            Pdf_model pdf2= new Pdf_model("2","rumani","parul");
            pdf_models.add(pdf2);


            Pdf_model pdf3= new Pdf_model("3","rumani","parul");
            pdf_models.add(pdf3);
            Pdf_model pdf5= new Pdf_model("4","rumani","parul");
            pdf_models.add(pdf5);


            Pdf_model pdf6= new Pdf_model("1","rumani","parul");
            pdf_models.add(pdf6);


            Pdf_model pdf7= new Pdf_model("1","rumani","parul");
            pdf_models.add(pdf7);


            pdf_models.add(pdf1);



            pdf_models.add(pdf2);



            pdf_models.add(pdf3);

            pdf_models.add(pdf5);



            pdf_models.add(pdf6);



            pdf_models.add(pdf7);


        pdfClicklistener = new PdfRecyclerAdapter.OnSubjectPdfClicklistener() {
            @Override
            public void pdfSelected(int subPosition, int itemPostion) {

            }
        };
        r=(RecyclerView)v.findViewById(R.id.Recycler1);
        r.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        a= new PdfRecyclerAdapter(getContext(),pdf_models,pdfClicklistener,SubPosition);
        l=new LinearLayoutManager(getContext());
        r.setLayoutManager(l);
        r.setHasFixedSize(true);
        r.setAdapter(a);
        return v;
    }

}




