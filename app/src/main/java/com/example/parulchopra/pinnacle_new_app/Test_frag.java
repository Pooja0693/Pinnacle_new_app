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

import java.util.ArrayList;


public class Test_frag extends Fragment {
    private RecyclerView r;
    private RecyclerView.Adapter a;
    private RecyclerView.LayoutManager l;

    OnSubjectTestClicklistener onSubjectTestClicklistener;

    public interface OnSubjectTestClicklistener{
        public void testSelected(int position,String url);
    }


    public  Test_frag newInstance( int position) {
        Test_frag f = new Test_frag();

        Bundle args = new Bundle();
        args.putInt("index", position);
        f.setArguments(args);
        return f;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_test_frag, container, false);
        ArrayList<Test_model> test_models = new ArrayList<Test_model>();

        Test_model pdf1= new Test_model("1","rumani","parul","pooja");
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);
        test_models.add(pdf1);


        r=(RecyclerView)v.findViewById(R.id.testrecyler);
        r.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        a= new TestRecyclerAdapter(getContext(),test_models);
        l=new LinearLayoutManager(getContext());
        r.setLayoutManager(l);
        r.setHasFixedSize(true);
        r.setAdapter(a);


    return v;
}
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            onSubjectTestClicklistener = (Test_frag.OnSubjectTestClicklistener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement onHeadingListener");
        }
    }

    private class TestRecyclerAdapter extends RecyclerView.Adapter<TestRecyclerAdapter.Recyclerviewholder> {
        Context context;
        ArrayList<Test_model> test_models;

        LayoutInflater inflater;
        public TestRecyclerAdapter(Context C1, ArrayList<Test_model> test_models) {
            this.context=C1;
            this.test_models=test_models;
            inflater= LayoutInflater.from(C1);

        }

        @Override
        public TestRecyclerAdapter.Recyclerviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =inflater.inflate(R.layout.test_list_item,parent,false);
            Recyclerviewholder M1= new Recyclerviewholder(view);

            return M1;
        }

        @Override
        public void onBindViewHolder(TestRecyclerAdapter.Recyclerviewholder holder, int position) {
            holder.T1.setText(test_models.get(position).getName1());
            holder.T2.setText(test_models.get(position).getName2());
            holder.T3.setText(test_models.get(position).getName3());
            holder.T4.setText(test_models.get(position).getName4());
            holder.SETONCLICKLISTENER(new CustomListener() {
                @Override
                public void onClickMethod(View v, int pos) {
                    Snackbar.make(v,"pleaseeeeeeeeeeeeeeeeeeeeeee" , Snackbar.LENGTH_LONG).setAction("action",null).show();
                    onSubjectTestClicklistener.testSelected(2,"url");
                }
            });
        }

        @Override
        public int getItemCount() {

            return test_models.size();
        }

        public class Recyclerviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView T1,T2,T3,T4;
CustomListener onclicklistener;
            public Recyclerviewholder(View itemView) {
                super(itemView);
                T1 = (TextView) itemView.findViewById(R.id.name1);
                T1.setBackgroundResource(R.drawable.circletextshape);
                T2 = (TextView) itemView.findViewById(R.id.name2);
                T3 = (TextView) itemView.findViewById(R.id.name3);
                T4 = (TextView) itemView.findViewById(R.id.name4);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                this.onclicklistener.onClickMethod(v, getLayoutPosition());
            }
            public void SETONCLICKLISTENER(CustomListener io) {
                this.onclicklistener = io;
            }
        }     }
}
