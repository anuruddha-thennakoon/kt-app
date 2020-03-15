package com.variant.ktapp.ui.doctor;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.variant.ktapp.R;
import com.variant.ktapp.model.Patients;
import com.variant.ktapp.ui.register_patient.RegisteringPatientInfo;

import java.util.ArrayList;
import java.util.Date;

public class DoctorDashboardFragment extends Fragment implements DoctorsPatientsAdapter.ItemClickListener {

    private ImageView profileImage;
    private RelativeLayout addNewPatientsContainer;
    private RecyclerView patientsRecyclerView;
    private LinearLayoutManager layoutManager;
    private ArrayList<Patients> patientsArrayList;
    private DoctorsPatientsAdapter doctorsPatientsAdapter;

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
        patientsRecyclerView = view.findViewById(R.id.patientsRecyclerView);
        addNewPatientsContainer = view.findViewById(R.id.addNewPatientsContainer);
        addNewPatientsContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RegisteringPatientInfo.class);
                startActivity(intent);
            }
        });
        try {
            String imgUrl ="https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60";
            ImageLoader.getInstance().displayImage(imgUrl, profileImage);
        } catch (Exception e) {
        }

        setPatientsDetails();
        return view;
    }

    private void setPatientsDetails() {
        patientsArrayList = new ArrayList<>();
        Patients patients;

        for (int i = 0 ;i<8;i++){
            if (i == 0) {
                patients = new Patients(i, "Mr. Asanka Fonseka "+i, 2 + i, System.currentTimeMillis(), 10, true);
            }else if (i == 4) {
                patients = new Patients(i, "Mr. Asanka Fonseka "+i, 2 + i, System.currentTimeMillis(), 10, true);
            }else {
                patients = new Patients(i, "Mr. Asanka Fonseka "+i, 2 + i, System.currentTimeMillis(), 10, false);
            }
            patientsArrayList.add(patients);
            layoutManager = new LinearLayoutManager(getActivity());
            patientsRecyclerView.setLayoutManager(layoutManager);
            doctorsPatientsAdapter = new DoctorsPatientsAdapter(getActivity(), this, patientsArrayList);
            patientsRecyclerView.setAdapter(doctorsPatientsAdapter);
            patientsRecyclerView.setHasFixedSize(true);

        }


    }

    @Override
    public void onItemClick(int position) {

    }
}
