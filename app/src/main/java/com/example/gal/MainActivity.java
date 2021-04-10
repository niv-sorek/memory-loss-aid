package com.example.gal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "pttt";
    private RelativeLayout main_VIEW_home1;
    private RelativeLayout main_VIEW_home2;
    private RelativeLayout main_VIEW_home3;
    private RelativeLayout main_VIEW_home4;
    private RelativeLayout main_VIEW_home5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initViews();
    }

    private void initViews() {
        main_VIEW_home1.setOnClickListener(v -> Clicked(0));
        main_VIEW_home2.setOnClickListener(v -> Clicked(1));
        main_VIEW_home3.setOnClickListener(v -> Clicked(2));
        main_VIEW_home4.setOnClickListener(v -> Clicked(3));
        main_VIEW_home5.setOnClickListener(v -> Clicked(4));
    }

    private void Clicked(int home) {
        Log.d(TAG, "Clicked: HELLO" + home);
        switch (home) {
            case 0:
                Intent i = new Intent(this, ShowHome.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;

        }
    }

    private void findViews() {
        main_VIEW_home1 = findViewById(R.id.main_VIEW_home1);
        main_VIEW_home2 = findViewById(R.id.main_VIEW_home2);
        main_VIEW_home3 = findViewById(R.id.main_VIEW_home3);
        main_VIEW_home4 = findViewById(R.id.main_VIEW_home4);
        main_VIEW_home5 = findViewById(R.id.main_VIEW_home5);

    }
}