package com.example.gal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "pttt";
    private static Home[] homes = {
            new Home().setNumber(1).setName("Self-actualization needs").setDescription("This level of need refers to the realization of one's full potential."),
            new Home().setNumber(2).setName("Esteem needs").setDescription("Most people have a need for a stable esteem, meaning which is soundly based on real capacity or achievement."),
            new Home().setNumber(3).setName("Love needs").setDescription("the third level of human needs is interpersonal and involves feelings of love and belongingness."),
            new Home().setNumber(4).setName("Safety needs ").setDescription("Once a person's physiological needs are relatively satisfied, their safety needs take precedence and dominate behavior."),
            new Home().setNumber(5).setName("The physiological needs").setDescription("The physiological needs is a concept that was derived to explain and cultivate the foundation for motivation.")
    };
    private RelativeLayout main_VIEW_home1;
    private RelativeLayout main_VIEW_home2;
    private RelativeLayout main_VIEW_home3;
    private RelativeLayout main_VIEW_home4;
    private RelativeLayout main_VIEW_home5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        findViews();
        initViews();
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }
    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    private void initViews() {
        main_VIEW_home1.setOnClickListener(v -> Clicked(4));
        main_VIEW_home2.setOnClickListener(v -> Clicked(3));
        main_VIEW_home3.setOnClickListener(v -> Clicked(2));
        main_VIEW_home4.setOnClickListener(v -> Clicked(1));
        main_VIEW_home5.setOnClickListener(v -> Clicked(0));
    }

    private void Clicked(int home) {
        Gson gson = new Gson();
        Log.d(TAG, "Clicked: HELLO " + homes[home].getDescription());

        Intent i = new Intent(this, ShowHome.class);
        i.putExtra("home", gson.toJson(homes));
        i.putExtra("home_id", home);

        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


    }

    private void findViews() {
        this.main_VIEW_home1 = findViewById(R.id.main_VIEW_home1);
        this.main_VIEW_home2 = findViewById(R.id.main_VIEW_home2);
        this.main_VIEW_home3 = findViewById(R.id.main_VIEW_home3);
        this.main_VIEW_home4 = findViewById(R.id.main_VIEW_home4);
        this.main_VIEW_home5 = findViewById(R.id.main_VIEW_home5);

    }
}