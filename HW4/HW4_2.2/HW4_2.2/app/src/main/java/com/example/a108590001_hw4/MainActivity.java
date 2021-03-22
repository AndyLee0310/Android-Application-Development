package com.example.a108590001_hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.CountText);

        if(savedInstanceState != null) {
            String SavCount = savedInstanceState.getString("mCount");
            mCount =Integer.parseInt(SavCount);
            if(mShowCount != null) {
                mShowCount.setText(SavCount);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart()", "onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause()", "onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart()", "onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume()", "onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop()", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy()", "onDestroy()");
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("onSaveInstanceState()","onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putString("mCount",mShowCount.getText().toString());
    }

    public void Count(View view) {
        mCount ++;
        if(mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}