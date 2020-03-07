package com.variant.ktapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.variant.ktapp.R;
import com.variant.ktapp.ui.doctor.DoctorDashboardFragment;
import com.variant.ktapp.widgets.ToolBar;

public class MainActivity extends AppCompatActivity {

    private ToolBar toolbar;
    private DoctorDashboardFragment doctorDashboardFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.toolBar);
        if (view != null) {
            if (view instanceof ToolBar) {
                toolbar = (ToolBar) view;
                toolbar.setOnMenuClickListener(v -> openMenu());
            }
        }
        toolbar.setDots(false);
        showDoctorDashboardFragment();
    }

    private void openMenu() {
    }

    public void showDoctorDashboardFragment() {
        try {
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        } catch (Exception e) {
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(doctorDashboardFragment == null) {
            doctorDashboardFragment = DoctorDashboardFragment.newInstance();
            doctorDashboardFragment.setRetainInstance(true);
        }
        transaction.replace(R.id.fragmentHolder, doctorDashboardFragment);
        transaction.commit();
    }

}
