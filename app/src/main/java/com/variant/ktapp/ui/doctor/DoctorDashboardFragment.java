package com.variant.ktapp.ui.doctor;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.variant.ktapp.R;

public class DoctorDashboardFragment extends Fragment {


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
        return view;
    }

}
