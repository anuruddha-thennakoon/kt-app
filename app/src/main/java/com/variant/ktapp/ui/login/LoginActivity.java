package com.variant.ktapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.variant.ktapp.R;
import com.variant.ktapp.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout loginContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginContainer = findViewById(R.id.loginContainer);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginContainer:
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
