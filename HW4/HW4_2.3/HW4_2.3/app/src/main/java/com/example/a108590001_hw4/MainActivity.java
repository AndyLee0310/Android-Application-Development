package com.example.a108590001_hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsitText;
    private EditText mLocationText;
    private EditText mShareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsitText = findViewById(R.id.webSite_EditText);
        mLocationText = findViewById(R.id.Location_EditText);
        mShareText = findViewById(R.id.ShareText_EditText);
    }

    public void openWebsite(View view) {
        String url = mWebsitText.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents","Can't handle this intent!");
        }
    }

    public void openLocation(View view) {
        String loc = mLocationText.getText().toString();
        Log.d("test",loc);
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents","Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        String txt = mShareText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with:")
                .setText(txt)
                .startChooser();
    }

    public void takePicture(View view) {
        Intent camIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (camIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(camIntent);
        } else {
            Log.d("ImplicitIntents","Can't handle this intent!");
        }
    }
}