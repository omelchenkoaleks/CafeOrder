package com.omelchenkoaleks.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText mNameEditText;
    private EditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mNameEditText = findViewById(R.id.name_edit_text);
        mPasswordEditText = findViewById(R.id.password_edit_text);
    }

    public void onClickCreateOrder(View view) {
        String name = mNameEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();

        // если наше имя не пустое и наш пароль не пустой
        if (!name.isEmpty() && !password.isEmpty()) {
            Intent intent = new Intent(this, CreateOrderActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("password", password);
            startActivity(intent);
        } else {
            Toast.makeText(this,
                    (R.string.message_fill_in_all_the_fields), Toast.LENGTH_SHORT).show();
        }
    }
}
