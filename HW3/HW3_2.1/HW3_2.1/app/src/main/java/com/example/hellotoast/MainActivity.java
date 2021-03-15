package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCounts;
    public static final String EXTRA_MESSAGE = "com.example.hellotoast.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCounts = (TextView)findViewById(R.id.textView);
    }

    public void SayHello(View view) {
        Log.d("MainActivity", "Button clicked!");

        Intent intent = new Intent(this, SecondActivity.class);
        String message = mShowCounts.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void Count(View view) {
        mCount++;
        if(mShowCounts != null) {
            mShowCounts.setText(Integer.toString(mCount));
        }
    }
}
