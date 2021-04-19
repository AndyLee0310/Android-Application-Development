package com.example.android.recyclerview;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Recipe_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        Intent intent = getIntent();
        Bundle ext = intent.getExtras();
        String item = null;
        ImageView img = null;
        TextView text = null;


        if(ext != null) {
            item = ext.getString(Recyclerview.EXTRA_NAME);
            TextView title = findViewById(R.id.TitleView);
            img = findViewById(R.id.imageView);
            text = findViewById(R.id.textView);
            title.setText(item);
        }

        if(item != null) {
            switch (item) {
                case "Bun":
                    img.setImageResource(R.drawable.img_bun);
                    text.setText(R.string.bun);
                    break;
                case "Dumplings":
                    img.setImageResource(R.drawable.img_dumplings);
                    text.setText(R.string.Dumplings);
                default:
                    break;
            }
        }
    }
}
