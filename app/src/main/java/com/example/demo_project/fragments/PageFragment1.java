package com.example.demo_project.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.demo_project.ProfileActivity;
import com.example.demo_project.SubscribeActivity;
import com.example.demo_project.MainActivity;
import com.example.demo_project.R;
import com.example.demo_project.onSwipeTouchListener;

public class PageFragment1 extends Fragment{

    VideoView view;
    ViewGroup rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.page_1, container, false);

        rootView.setOnTouchListener(new onSwipeTouchListener(getContext()){
            public void onSwipeRight() {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                intent.putExtra("Id", 1);
                intent.putExtra("Name", "John Nidas");
                startActivity(intent);
            }
            public void onSwipeLeft() {
                Intent intent = new Intent(getContext(), SubscribeActivity.class);
                intent.putExtra("Id", 1);
                startActivity(intent);
            }
        });



        view = (VideoView)rootView.findViewById(R.id.videoView1);
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.a;
        view.setVideoURI(Uri.parse(path));
        if (getUserVisibleHint()){
            view.start();
        }

        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(this.isVisible()) {
            if (isVisibleToUser) {
                view.seekTo(0);
                view.start();
            } else {
                MainActivity.i=1;
                view.pause();
            }
        }
    }
}
