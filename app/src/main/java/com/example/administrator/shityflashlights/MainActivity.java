package com.example.administrator.shityflashlights;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.DrawableContainer;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private static final String TAG = "jorjMessage";
    private static final String mainLayoutBackgroundColor_tmp = "MainLayoutBackgroundColor_tmp";

    LinearLayout mainLayout;
    public int activeColorId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate() called");
        mainLayout = (LinearLayout)findViewById(R.id.mainLayout);



        //Log.i(TAG,buttons.toString());

    }

    @Override
    public void onClick(View v) {

        activeColorId = v.getId();

        switch (activeColorId){
            case R.id.redBtn: setMainLayoutBackgroundColor(Color.RED);  break;
            case R.id.greenBtn: setMainLayoutBackgroundColor(Color.GREEN);  break;
            case R.id.yellowBtn: setMainLayoutBackgroundColor(Color.YELLOW);  break;
            case R.id.whiteBtn:setMainLayoutBackgroundColor(Color.WHITE);  break;
            case R.id.blueBtn: setMainLayoutBackgroundColor(Color.BLUE);  break;
            default:  mainLayout.setBackgroundResource(R.color.mainLayoutColor);
        }
    }

    public void setMainLayoutBackgroundColor(int col)
    {
        mainLayout.setBackgroundColor(col);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
       // Log.i(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() called");
    }

    /*
    *** [start]configurations change during runtime
    */

    @Override
    protected void onSaveInstanceState(Bundle outState) {


        super.onSaveInstanceState(outState);
        ColorDrawable viewColor = (ColorDrawable) mainLayout.getBackground();
        int colorId = viewColor.getColor();
        outState.putInt(mainLayoutBackgroundColor_tmp,colorId);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        activeColorId = savedInstanceState.getInt(mainLayoutBackgroundColor_tmp);
        mainLayout = (LinearLayout)findViewById(R.id.mainLayout);
        setMainLayoutBackgroundColor(activeColorId);
    }

    /*
    *** [end]configurations change during runtime
    */
}
