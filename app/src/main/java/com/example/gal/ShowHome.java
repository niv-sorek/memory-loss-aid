package com.example.gal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import com.google.gson.Gson;

public class ShowHome extends AppCompatActivity {
    private static final String DEBUG_TAG ="pttt" ;
    private TextView home_TXT_description;
    private TextView home_TXT_name;
    private TextView home_TXT_number;
    private RelativeLayout home_VIEW_top;
    private RelativeLayout home_VIEW_bottom;
    private int id;
    private Home[] homes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_home);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();



        String homesJson = getIntent().getStringExtra("home");
        id = getIntent().getIntExtra("home_id", 0);
        homes = new Gson().fromJson(homesJson, Home[].class);
        Log.d("pttt", "onCreate: "+ id);

        findViews();
        initViews();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
//            hideSystemUI();
        }
    }

/*    public boolean onTouchEvent(MotionEvent event){

        int action = MotionEventCompat.getActionMasked(event);

        switch(action) {
            case (MotionEvent.ACTION_DOWN) :
                Log.d(DEBUG_TAG,"Action was DOWN");
                return true;
            case (MotionEvent.ACTION_MOVE) :
                Log.d(DEBUG_TAG,"Action was MOVE");
                return true;
            case (MotionEvent.ACTION_UP) :
                Log.d(DEBUG_TAG,"Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL) :
                Log.d(DEBUG_TAG,"Action was CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE) :
                Log.d(DEBUG_TAG,"Movement occurred outside bounds " +
                        "of current screen element");
                return true;
            default :
                return super.onTouchEvent(event);
        }
    }*/
    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                         View.SYSTEM_UI_FLAG_LAYOUT_STABLE
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

        this.home_TXT_number.setText(String.format("%d", homes[id].getNumber()));
        this.home_TXT_name.setText(homes[id].getName());
        this.home_TXT_description.setText(homes[id].getDescription());
        this.home_VIEW_top.setVisibility(id < 4 ? View.VISIBLE : View.INVISIBLE);
        this.home_VIEW_bottom.setVisibility(id > 0 ? View.VISIBLE : View.INVISIBLE);
        this.home_VIEW_bottom.setOnClickListener(v -> {
            if (id > 0) {
                Activity mCurrentActivity = this;
                Intent intent = getIntent();
                intent.putExtra("home_id", id - 1);
                mCurrentActivity.finish();
                mCurrentActivity.overridePendingTransition(R.anim.slide_up_in, R.anim.slide_up_out);
                mCurrentActivity.startActivity(intent);
            }
        });
        this.home_VIEW_top.setOnClickListener(v -> {
            if (id < 4) {

                Activity mCurrentActivity = this;
                Intent intent = getIntent();
                intent.putExtra("home_id", id + 1);
                mCurrentActivity.finish();

                mCurrentActivity.overridePendingTransition(R.anim.slide_down_in, R.anim.slide_down_out);
                mCurrentActivity.startActivity(intent);

            }
        });
    }

    private void findViews() {
        this.home_TXT_description = findViewById(R.id.home_TXT_description);
        this.home_TXT_name = findViewById(R.id.home_TXT_name);
        this.home_TXT_number = findViewById(R.id.home_TXT_number);
        this.home_VIEW_top = findViewById(R.id.home_VIEW_top);
        this.home_VIEW_bottom = findViewById(R.id.home_VIEW_bottom);
    }

}