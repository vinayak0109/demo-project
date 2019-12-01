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
import com.example.demo_project.R;
import com.example.demo_project.onSwipeTouchListener;

public class PageFragment3 extends Fragment {

    VideoView view;
    ViewGroup rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.page_3, container, false);

        rootView.setOnTouchListener(new onSwipeTouchListener(getContext()){
            public void onSwipeRight() {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                intent.putExtra("Id", 3);
                intent.putExtra("Name", "Peter England");
                startActivity(intent);
            }
            public void onSwipeLeft() {
                Intent intent = new Intent(getContext(), SubscribeActivity.class);
                intent.putExtra("Id", 3);
                startActivity(intent);
            }
        });

        view = (VideoView)rootView.findViewById(R.id.videoView3);
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.c;
        view.setVideoURI(Uri.parse(path));

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
                view.pause();
            }
        }
    }

}
