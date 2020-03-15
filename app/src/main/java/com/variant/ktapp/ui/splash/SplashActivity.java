package com.variant.ktapp.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.variant.ktapp.BuildConfig;
import com.variant.ktapp.R;
import com.variant.ktapp.ui.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    private TextView tvVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tvVersion = findViewById(R.id.tvVersion);
        tvVersion.setText("ver: "+ BuildConfig.VERSION_NAME);

        if (isTablet()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }, 4000);
        }else {
            Toast.makeText(this,"Sorry this application is not supported to mobile devices,Please use a tablet for run this application.",Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    finish();
                }
            }, 4000);
        }
    }

    private boolean isTablet() {
        if (Boolean.parseBoolean(getApplicationContext().getResources().getString(R.string.is_supported_screen))) {
            return true;
        } else {
            return false;
        }
    }
}
