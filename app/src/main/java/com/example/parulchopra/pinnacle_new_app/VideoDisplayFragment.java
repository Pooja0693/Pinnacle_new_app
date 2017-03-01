package com.example.parulchopra.pinnacle_new_app;


import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;



public class VideoDisplayFragment extends Fragment {


    VideoView videoView;

    String url = "https://firebasestorage.googleapis.com/v0/b/kuch-hee.appspot.com/o/220%20Android%20Navigation%20Drawer%20Tutorial%20Part%203%20-%20coursetro.com.mp4?alt=media&token=a4703569-e291-4da9-bede-931d5c5c9039";




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_video_display, container, false);
        videoView = (VideoView)v.findViewById(R.id.myVideo);
        Uri vidUri = Uri.parse(url);
        videoView.setVideoURI(vidUri);
        MediaController vidControl = new MediaController(getContext());
        vidControl.setAnchorView(videoView);
        videoView.setMediaController(vidControl);
        videoView.start();
        return v;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}





