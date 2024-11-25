package com.example.test;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Exercise1Activity extends AppCompatActivity {

    private EditText editTextFahrenheit, editTextCelsius;
    private Button buttonToCelsius, buttonToFahrenheit, buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);

        // Ánh xạ giao diện
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        editTextCelsius = findViewById(R.id.editTextCelsius);
        buttonToCelsius = findViewById(R.id.buttonToCelsius);
        buttonToFahrenheit = findViewById(R.id.buttonToFahrenheit);
        buttonClear = findViewById(R.id.buttonClear);

        // Logic chuyển đổi nhiệt độ
        buttonToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fahrenheitStr = editTextFahrenheit.getText().toString();
                if (!TextUtils.isEmpty(fahrenheitStr)) {
                    double fahrenheit = Double.parseDouble(fahrenheitStr);
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    editTextCelsius.setText(String.format("%.2f", celsius));
                } else {
                    Toast.makeText(Exercise1Activity.this, "Nhập giá trị Fahrenheit!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsiusStr = editTextCelsius.getText().toString();
                if (!TextUtils.isEmpty(celsiusStr)) {
                    double celsius = Double.parseDouble(celsiusStr);
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    editTextFahrenheit.setText(String.format("%.2f", fahrenheit));
                } else {
                    Toast.makeText(Exercise1Activity.this, "Nhập giá trị Celsius!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextFahrenheit.setText("");
                editTextCelsius.setText("");
            }
        });
    }
}
