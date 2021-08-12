package com.example.a108590001_hw10;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>, AdapterView.OnItemSelectedListener {

    private EditText URLInput;
    private TextView SourceCodeView;
    private String mSValue;

    private static final String QUERY = "queryStrint";
    private static final String PROTOCOL = "transferProtocol";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URLInput = findViewById(R.id.editTextTextPersonName);
        SourceCodeView = findViewById(R.id.source_code);

        ArrayAdapter<CharSequence> arrAdapSpn = ArrayAdapter.createFromResource(MainActivity.this, R.array.protocol, android.R.layout.simple_spinner_item);
        arrAdapSpn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinners = (Spinner) findViewById(R.id.spinner);

        if (spinners != null) {
            spinners.setOnItemSelectedListener(this);
            spinners.setAdapter(arrAdapSpn);
        }

        if (getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String queryString = "";
        String transferProtocol = "";

        if (args != null) {
            queryString = args.getString(QUERY);
            transferProtocol = args.getString(PROTOCOL);
        }

        return new Source_Code_Loader(this, queryString, transferProtocol);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            SourceCodeView.setText(data);
        } catch (Exception e) {
            e.printStackTrace();
            SourceCodeView.setText(R.string.NoResponse);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
        //this is empty method
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mSValue = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        String[] values = getResources().getStringArray(R.array.protocol);
        mSValue = values[0];
    }

    public void getCode(View view) {
        InputMethodManager inMtdManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inMtdManager != null) {
            inMtdManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }

        String qString = URLInput.getText().toString();

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;

        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected() && (qString.length() != 0)) {
            Bundle qBundle = new Bundle();
            qBundle.putString(QUERY, qString);
            qBundle.putString(PROTOCOL, mSValue);

            getSupportLoaderManager().restartLoader(0, qBundle, this);
            SourceCodeView.setText(R.string.GetSourceCode);
        } else {
            if (qString.length() == 0) {
                Toast.makeText(this, R.string.NoUrlProvided, Toast.LENGTH_LONG).show();
            }
            else if(!URLUtil.isValidUrl(qString)){
                Toast.makeText(this, R.string.InvalidUrl, Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this, R.string.NoConnection, Toast.LENGTH_LONG).show();
            }
        }
    }
}