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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class Video_frag extends Fragment {

    private RecyclerView r;
    private RecyclerView.Adapter a;
    private RecyclerView.LayoutManager l;

    OnSubjectClicklistener onSubjectClicklistener;

    public interface OnSubjectClicklistener{
        public void videoSelected(int position,String url);
    }

    public Video_frag newInstance(int position) {
        Video_frag f = new Video_frag();

        Bundle args = new Bundle();
        args.putInt("index",position);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_video_frag, container, false);
        ArrayList<Video_model> video_models = new ArrayList<Video_model>();

        Video_model video1= new Video_model("1","rumani","parul",R.drawable.b1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);
        video_models.add(video1);

        r=(RecyclerView)v.findViewById(R.id.videorecyler);
        r.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        a= new VideoRecyclerAdapter(getContext(),video_models);
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
            onSubjectClicklistener = (Video_frag.OnSubjectClicklistener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement onHeadingListener");
        }
    }


    private class VideoRecyclerAdapter extends RecyclerView.Adapter<VideoRecyclerAdapter.Recyclerviewholder> {
        Context context;
        ArrayList<Video_model> video_models;

        LayoutInflater inflater;
        public VideoRecyclerAdapter(Context C1,ArrayList<Video_model> video_models ) {
            this.context=C1;
           this.video_models = video_models;

            inflater= LayoutInflater.from(C1);
        }

        @Override
        public Recyclerviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =inflater.inflate(R.layout.video_list_item,parent,false);
            Recyclerviewholder M1= new Recyclerviewholder(view);

            return M1;
        }

        @Override
        public void onBindViewHolder(Recyclerviewholder holder, final int position) {
            holder.T1.setText(video_models.get(position).getName1());
            holder.T2.setText(video_models.get(position).getName2());
            holder.T3.setText(video_models.get(position).getName3());
            holder.I1.setImageResource(video_models.get(position).getImage());




            holder.SETONCLICKLISTENER(new CustomListener() {
                @Override
                public void onClickMethod(View v, int pos) {
                    Snackbar.make(v,"byeeeeeeeeeeeeeeeee" , Snackbar.LENGTH_LONG).setAction("action",null).show();
                    onSubjectClicklistener.videoSelected(1,"url");

                }
            });
        }



        @Override
        public int getItemCount() {
            return video_models.size();
        }

        public class Recyclerviewholder extends RecyclerView.ViewHolder  implements View.OnClickListener  {
            TextView T1,T2,T3;
            ImageView I1;
            CustomListener onclicklistener;
            public Recyclerviewholder(View itemView) {
                super(itemView);
                T1=(TextView)itemView.findViewById(R.id.name1);
                T1.setBackgroundResource(R.drawable.circletextshape);
                T2=(TextView)itemView.findViewById(R.id.name2);
                T3=(TextView)itemView.findViewById(R.id.name3);
                I1=(ImageView)itemView.findViewById(R.id.Image1);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                this.onclicklistener.onClickMethod(v, getLayoutPosition());
            }
            public void SETONCLICKLISTENER(CustomListener io) {
                this.onclicklistener = io;
            }
        }
    }
}
