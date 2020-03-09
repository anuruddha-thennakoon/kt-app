package com.variant.ktapp.ui.doctor;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.variant.ktapp.R;

public class DoctorDashboardFragment extends Fragment {

    private ImageView profileImage;

    public DoctorDashboardFragment() {
    }

    public static DoctorDashboardFragment newInstance() {
        Bundle args = new Bundle();
        DoctorDashboardFragment fragment = new DoctorDashboardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        profileImage = view.findViewById(R.id.profile_image);
        try {
            String imgUrl ="https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60";
            ImageLoader.getInstance().displayImage(imgUrl, profileImage);
        } catch (Exception e) {
        }
        return view;
    }

}
