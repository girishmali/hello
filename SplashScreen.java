package com.infowave.redstar.eazylo.activity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.infowave.redstar.eazylo.MainActivity;
import com.infowave.redstar.eazylo.R;
import com.infowave.redstar.eazylo.fragment.LoginFrgment;

import static android.R.attr.id;

public class SplashScreen extends AppCompatActivity {

    ImageView img_logo;
    Context context;
    int layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        img_logo =(ImageView)findViewById(R.id.img_splas_logo);

        Thread time = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(5*1000);

                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {

                }

            }
        };
        time.start();
    }
}
