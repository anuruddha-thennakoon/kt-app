package com.variant.ktapp.ui.register_patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.variant.ktapp.R;

public class RegisteringPatientMedicalHistory extends AppCompatActivity implements View.OnClickListener {

    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registering_patient_medical_history);

        btnContinue = findViewById(R.id.btnContinue);
    }

    @Override
    public void onClick(View view) {
        if(view == btnContinue){
            startActivity(new Intent(this,RegisteringPatientWound.class));
        }
    }
}
