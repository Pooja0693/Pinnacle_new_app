package com.example.parulchopra.pinnacle_new_app.Adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.parulchopra.pinnacle_new_app.CustomListener;
import com.example.parulchopra.pinnacle_new_app.Pdf_model;
import com.example.parulchopra.pinnacle_new_app.R;
import com.example.parulchopra.pinnacle_new_app.Test_frag;

import java.util.ArrayList;

/**
 * Created by Ideal on 2/15/2017.
 */

public class PdfRecyclerAdapter extends RecyclerView.Adapter<PdfRecyclerAdapter.Recyclerviewholder> {
    private int SubPostion;
    private OnSubjectPdfClicklistener onSubjectPdfClicklistener;
    public interface OnSubjectPdfClicklistener{
        public void pdfSelected(int subPosition,int itemPostion);
    }
    Context context;

    LayoutInflater inflater;
    ArrayList<Pdf_model> pdf_models;
    public PdfRecyclerAdapter(Context C1, ArrayList<Pdf_model> pdf_models,OnSubjectPdfClicklistener onSubjectTestClicklistener,int SubPosition) {
        this.SubPostion = SubPosition;
        this.context=C1;
        this.pdf_models=pdf_models;
        inflater= LayoutInflater.from(C1);
        this.onSubjectPdfClicklistener = onSubjectTestClicklistener;

    }
    @Override
    public PdfRecyclerAdapter.Recyclerviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.pdf_list_item,parent,false);
        Recyclerviewholder M1= new Recyclerviewholder(view);

        return M1;
    }

    @Override
    public void onBindViewHolder(PdfRecyclerAdapter.Recyclerviewholder holder, final int position) {
        holder.T1.setText(pdf_models.get(position).getName1());
        holder.T2.setText(pdf_models.get(position).getName2());
        holder.T3.setText(pdf_models.get(position).getName3());
    }

    @Override
    public int getItemCount() {
        return pdf_models.size();
    }




    public class Recyclerviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView T1,T2,T3;
        CustomListener onclicklistener;
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
            //Snackbar.make(v,"hellloooooooo" , Snackbar.LENGTH_LONG).setAction("action",null).show();
            onSubjectPdfClicklistener.pdfSelected(SubPostion,getAdapterPosition());//change required.....
        }
    }
}
