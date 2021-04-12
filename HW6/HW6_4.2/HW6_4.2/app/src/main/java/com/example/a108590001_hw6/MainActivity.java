package com.example.a108590001_hw6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button Show;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private CheckBox check4;
    private CheckBox check5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Show = (Button)findViewById(R.id.ShowToast);
        check1 = (CheckBox)findViewById(R.id.check1);
        check2 = (CheckBox)findViewById(R.id.check2);
        check3 = (CheckBox)findViewById(R.id.check3);
        check4 = (CheckBox)findViewById(R.id.check4);
        check5 = (CheckBox)findViewById(R.id.check5);
    }

    public void ShowMessage(View view) {
        String msg = "Toppings: ";
        if(check1.isChecked()){
            msg = msg + check1.getText().toString() + " ";
            Log.d("msgs", msg);
        }
        if(check2.isChecked()){
            msg = msg + check2.getText().toString() + " ";
            Log.d("msgs", msg);
        }
        if(check3.isChecked()){
            msg = msg + check3.getText().toString() + " ";
            Log.d("msgs", msg);
        }
        if(check4.isChecked()){
            msg = msg + check4.getText().toString() + " ";
            Log.d("msgs", msg);
        }
        if(check5.isChecked()){
            msg = msg + check5.getText().toString() + " ";
            Log.d("msgs", msg);
        }
        Log.d("msgs", msg);
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}