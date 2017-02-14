package com.example.parulchopra.pinnacle_new_app;


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

import java.util.ArrayList;


public class Pdf_frag extends Fragment {






    public  Pdf_frag newInstance(int position) {
        Pdf_frag f = new Pdf_frag();

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

        r=(RecyclerView)v.findViewById(R.id.Recycler1);
        r.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        a= new PdfRecyclerAdapter(getContext(),pdf_models);
        l=new LinearLayoutManager(getContext());
        r.setLayoutManager(l);
        r.setHasFixedSize(true);
        r.setAdapter(a);
        return v;
    }




    private class PdfRecyclerAdapter extends RecyclerView.Adapter<PdfRecyclerAdapter.Recyclerviewholder> {

        Context context;

        LayoutInflater inflater;
        ArrayList<Pdf_model> pdf_models;
        public PdfRecyclerAdapter(Context C1, ArrayList<Pdf_model> pdf_models) {
            this.context=C1;
            this.pdf_models=pdf_models;
            inflater= LayoutInflater.from(C1);

        }
        @Override
        public PdfRecyclerAdapter.Recyclerviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =inflater.inflate(R.layout.pdflistview,parent,false);
            Recyclerviewholder M1= new Recyclerviewholder(view);

            return M1;
        }

        @Override
        public void onBindViewHolder(PdfRecyclerAdapter.Recyclerviewholder holder, int position) {
            holder.T1.setText(pdf_models.get(position).getName1());
            holder.T2.setText(pdf_models.get(position).getName2());
            holder.T3.setText(pdf_models.get(position).getName3());
            holder.SETONCLICKLISTENER(new ONCLICKLISTENER() {
                @Override
                public void parul(View v, int pos) {
                    Snackbar.make(v,"hellloooooooo" , Snackbar.LENGTH_LONG).setAction("action",null).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return pdf_models.size();
        }




        public class Recyclerviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView T1,T2,T3;
            ONCLICKLISTENER onclicklistener;
            public Recyclerviewholder(View itemView) {
                super(itemView);
                T1=(TextView)itemView.findViewById(R.id.name1);
                T1.setBackgroundResource(R.drawable.circletextshape);
                T2=(TextView)itemView.findViewById(R.id.name2);
                T3=(TextView)itemView.findViewById(R.id.name3);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                this.onclicklistener.parul(v, getLayoutPosition());
            }
            public void SETONCLICKLISTENER(ONCLICKLISTENER io) {
                this.onclicklistener = io;
            }
        }
        }




        }




