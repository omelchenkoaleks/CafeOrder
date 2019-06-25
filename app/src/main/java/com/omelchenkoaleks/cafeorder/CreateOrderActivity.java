package com.omelchenkoaleks.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
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

    // хранит название выбранного напитка
    private String mDrink;

    private String mName;
    private String mPassword;

    // для формирования списка добавок
    private StringBuilder mAdditionsStringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        Intent intent = getIntent();
        if (intent.hasExtra("name") && intent.hasExtra("password")) {
            mName = intent.getStringExtra("name");
            mPassword = intent.getStringExtra("password");
        } else {
            mName = getString(R.string.default_name);
            mPassword = getString(R.string.default_password);
        }

        mDrink = getString(R.string.tea);

        mHelloTextView = findViewById(R.id.hello_text_view);
        // %s - это место для заполнения (имени)
        String hello = String.format(getString(R.string.hello_user_text_view), mName);
        mHelloTextView.setText(hello);

        // %s - это место для заполнения (название напитка)
        mAdditionsTextView = findViewById(R.id.additions_text_view);
        String additions = String.format(getString(R.string.additions_text_view), mDrink);
        mAdditionsTextView.setText(additions);

        mMilkCheckBox = findViewById(R.id.milk_check_box);
        mSugarCheckBox = findViewById(R.id.sugar_check_box);
        mLemonCheckBox = findViewById(R.id.lemon_check_box);
        mTeaSpinner = findViewById(R.id.tea_spinner);
        mCoffeeSpinner = findViewById(R.id.coffee_spinner);

        mAdditionsStringBuilder = new StringBuilder();
    }

    public void onClickChangeDrink(View view) {
        // получаем нажатую кнопку
        RadioButton button = (RadioButton) view;

        // получаем id этой нажатой кнопки в переменную
        int id = button.getId();

        // теперь в зависимости какая кнопка была нажата мы можем проводит действия
        if (id == R.id.tea_radio_button) {
            mDrink = getString(R.string.tea);
            mTeaSpinner.setVisibility(View.VISIBLE);
            mCoffeeSpinner.setVisibility(View.INVISIBLE);
            mLemonCheckBox.setVisibility(View.VISIBLE);
        } else if (id == R.id.coffee_radio_button) {
            mDrink = getString(R.string.coffee);
            mCoffeeSpinner.setVisibility(View.VISIBLE);
            mTeaSpinner.setVisibility(View.INVISIBLE);
            mLemonCheckBox.setVisibility(View.INVISIBLE);
        }

        // %s - это место для заполнения (название напитка)
        String additions = String.format(getString(R.string.additions_text_view), mDrink);
        mAdditionsTextView.setText(additions);
    }

    public void onClickSendOrder(View view) {
        // если объект уже содержал какие-то значения его нужно очистить
        mAdditionsStringBuilder.setLength(0);

        if (mMilkCheckBox.isChecked()) {
            mAdditionsStringBuilder.append(getString(R.string.milk)).append(" ");
        }

        if (mSugarCheckBox.isChecked()) {
            mAdditionsStringBuilder.append(getString(R.string.sugar)).append(" ");
        }

        if (mLemonCheckBox.isChecked() && mDrink.equals(getString(R.string.tea))) {
            mAdditionsStringBuilder.append(getString(R.string.lemon)).append(" ");
        }

        // вид напитка получаем из спинера
        String optionOfDrink = "";
        if (mDrink.equals(getString(R.string.tea))) {
            optionOfDrink = mTeaSpinner.getSelectedItem().toString().trim();
        } else {
            optionOfDrink = mCoffeeSpinner.getSelectedItem().toString().trim();
        }

        String order = String.format(getString(R.string.order),
                mName, mPassword, mDrink, optionOfDrink);

        String additions;
        if (mAdditionsStringBuilder.length() > 0) {
            additions = "\n" + getString(R.string.need_additions) + mAdditionsStringBuilder.toString();
        } else {
            additions = "";
        }

        String fullOrder = order + additions;

        Intent intent = new Intent(this, OrderDetailActivity.class);
        intent.putExtra("order", fullOrder);
        startActivity(intent);
    }
}
