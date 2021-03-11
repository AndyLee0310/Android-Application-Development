package com.example.helloconstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button setZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView)findViewById(R.id.textView);
        setZero = (Button)findViewById(R.id.zeroBtn);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        setZero.setBackgroundColor(Color.GREEN);
        //Color.parseColor("#aa66cc")
        if(mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
            if(mCount % 2 == 0) {
                view.setBackgroundColor(Color.CYAN);
            }else{
                view.setBackgroundColor(Color.RED);
            }
        }
    }

    public void numToZero(View view) {
        mCount = 0;
        mShowCount.setText(Integer.toString(mCount));
        view.setBackgroundColor(Color.GRAY);
    }
}