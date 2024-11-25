package com.example.test;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Exercise3Activity extends AppCompatActivity {

    private EditText editTextA, editTextB;
    private Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);

        // Ánh xạ giao diện
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        textViewResult = findViewById(R.id.textViewResult);

        // Xử lý nút Cộng
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("+");
            }
        });

        // Xử lý nút Trừ
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("-");
            }
        });

        // Xử lý nút Nhân
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("*");
            }
        });

        // Xử lý nút Chia
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("/");
            }
        });
    }

    // Hàm xử lý các phép toán
    private void performOperation(String operation) {
        String aStr = editTextA.getText().toString();
        String bStr = editTextB.getText().toString();

        if (TextUtils.isEmpty(aStr) || TextUtils.isEmpty(bStr)) {
            Toast.makeText(Exercise3Activity.this, "Vui lòng nhập cả hai số!", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);
        double result = 0;

        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b != 0) {
                    result = a / b;
                } else {
                    Toast.makeText(Exercise3Activity.this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }

        textViewResult.setText("Kết quả: " + result);
    }
}
