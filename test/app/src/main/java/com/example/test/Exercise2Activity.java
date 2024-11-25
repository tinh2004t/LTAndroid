package com.example.test;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Exercise2Activity extends AppCompatActivity {

    private EditText editTextName, editTextHeight, editTextWeight;
    private Button buttonCalculateBMI;
    private TextView textViewBMI, textViewDiagnosis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);

        // Ánh xạ giao diện
        editTextName = findViewById(R.id.editTextName);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        buttonCalculateBMI = findViewById(R.id.buttonCalculateBMI);
        textViewBMI = findViewById(R.id.textViewBMI);
        textViewDiagnosis = findViewById(R.id.textViewDiagnosis);

        // Logic tính BMI
        buttonCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightStr = editTextHeight.getText().toString();
                String weightStr = editTextWeight.getText().toString();

                if (TextUtils.isEmpty(heightStr) || TextUtils.isEmpty(weightStr)) {
                    Toast.makeText(Exercise2Activity.this, "Vui lòng nhập thông tin!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double height = Double.parseDouble(heightStr);
                double weight = Double.parseDouble(weightStr);
                double bmi = weight / (height * height);

                textViewBMI.setText(String.format("BMI= %.2f", bmi));
                String diagnosis = getBMIDiagnosis(bmi);
                textViewDiagnosis.setText("Chẩn đoán: " + diagnosis);
            }
        });
    }

    private String getBMIDiagnosis(double bmi) {
        if (bmi < 18) return "Bạn gầy";
        if (bmi < 25) return "Bạn bình thường";
        if (bmi < 30) return "Bạn béo phì độ I";
        if (bmi < 35) return "Bạn béo phì độ II";
        return "Bạn béo phì độ III";
    }
}
