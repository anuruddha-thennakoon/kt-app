package com.variant.ktapp.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

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

        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        }, 4000);
    }
}
