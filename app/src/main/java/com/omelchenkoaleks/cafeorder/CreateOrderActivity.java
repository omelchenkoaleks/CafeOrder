package com.omelchenkoaleks.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class CreateOrderActivity extends AppCompatActivity {
    private TextView mHelloTextView;
    private TextView mAdditionsTextView;
    private CheckBox mMilkCheckBox;
    private CheckBox mSugarCheckBox;
    private CheckBox mLemonCheckBox;
    private Spinner mTeaSpinner;
    private Spinner mCoffeeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        mHelloTextView = findViewById(R.id.hello_text_view);
        mAdditionsTextView = findViewById(R.id.additions_text_view);
        mMilkCheckBox = findViewById(R.id.milk_check_box);
        mSugarCheckBox = findViewById(R.id.sugar_check_box);
        mLemonCheckBox = findViewById(R.id.lemon_check_box);
        mTeaSpinner = findViewById(R.id.tea_spinner);
        mCoffeeSpinner = findViewById(R.id.coffee_spinner);
    }

    public void onClickChangeDrink(View view) {
    }

    public void onClickSendOrder(View view) {
    }
}
