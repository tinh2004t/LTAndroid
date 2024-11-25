package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Exercise56Activity extends AppCompatActivity {

    private EditText edtName, edtMSSV, edtAge;
    private RadioGroup radioGroupGender;
    private CheckBox chkFootball, chkGaming;
    private Button btnSave;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise56);

        // Ánh xạ các thành phần
        edtName = findViewById(R.id.edtName);
        edtMSSV = findViewById(R.id.edtMSSV);
        edtAge = findViewById(R.id.edtAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        chkFootball = findViewById(R.id.chkFootball);
        chkGaming = findViewById(R.id.chkGaming);
        btnSave = findViewById(R.id.btnSave);
        tvResult = findViewById(R.id.tvResult);

        // Xử lý khi nhấn nút LƯU
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String mssv = edtMSSV.getText().toString();
                String age = edtAge.getText().toString();

                // Lấy giới tính
                String gender = "";
                int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
                if (selectedGenderId == R.id.radioMale) {
                    gender = "Nam";
                } else if (selectedGenderId == R.id.radioFemale) {
                    gender = "Nữ";
                }

                // Lấy sở thích
                String hobbies = "";
                if (chkFootball.isChecked()) {
                    hobbies += "Đá bóng ";
                }
                if (chkGaming.isChecked()) {
                    hobbies += "Chơi game ";
                }

                // Hiển thị kết quả
                String result = "Tôi tên: " + name + "\n"
                        + "MSSV: " + mssv + "\n"
                        + "Tuổi: " + age + "\n"
                        + "Giới tính: " + gender + "\n"
                        + "Sở thích: " + hobbies;

                tvResult.setText(result);
            }
        });
    }
}
