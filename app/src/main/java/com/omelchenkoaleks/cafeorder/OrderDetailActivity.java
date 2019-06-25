package com.omelchenkoaleks.cafeorder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderDetailActivity extends AppCompatActivity {
    private TextView mOrderTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        mOrderTextView = findViewById(R.id.order_text_view);

        Intent intent = getIntent();
        if (intent.hasExtra("order")) {
            String order = intent.getStringExtra("order");
            mOrderTextView.setText(order);
        } else {
            Intent backToLogin = new Intent(this, LoginActivity.class);
            startActivity(backToLogin);
        }
    }
}
