package com.example.android.droidcafeoptions;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.widget.ImageView;
    import android.widget.TextView;

public class OrderIceCream extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView message = findViewById(R.id.textView);
        message.setText(R.string.ice_cream_sandwiches);

        ImageView image = findViewById(R.id.imageView);
        image.setImageResource(R.drawable.icecream_circle);
    }
}