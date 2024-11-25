package com.example.test;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Exercise4Activity extends AppCompatActivity {

    private EditText editTextName;
    private RadioGroup radioGroupEducation;
    private RadioButton radioCollege, radioUniversity;
    private CheckBox checkBoxC, checkBoxJava, checkBoxJavaScript;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise4);

        // Ánh xạ giao diện
        editTextName = findViewById(R.id.editTextName);
        radioGroupEducation = findViewById(R.id.radioGroupEducation);
        radioCollege = findViewById(R.id.radioCollege);
        radioUniversity = findViewById(R.id.radioUniversity);
        checkBoxC = findViewById(R.id.checkBoxC);
        checkBoxJava = findViewById(R.id.checkBoxJava);
        checkBoxJavaScript = findViewById(R.id.checkBoxJavaScript);
        buttonSave = findViewById(R.id.buttonSave);

        // Xử lý khi nhấn nút Lưu dữ liệu
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    // Hàm lưu dữ liệu
    private void saveData() {
        String name = editTextName.getText().toString();

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(Exercise4Activity.this, "Vui lòng nhập họ tên!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Lấy hệ học
        String education = "";
        int selectedId = radioGroupEducation.getCheckedRadioButtonId();
        if (selectedId == R.id.radioCollege) {
            education = "Cao đẳng";
        } else if (selectedId == R.id.radioUniversity) {
            education = "Đại học";
        } else {
            Toast.makeText(Exercise4Activity.this, "Vui lòng chọn hệ học!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Lấy ngôn ngữ yêu thích
        StringBuilder languages = new StringBuilder();
        if (checkBoxC.isChecked()) languages.append("Lập trình C ");
        if (checkBoxJava.isChecked()) languages.append("Java ");
        if (checkBoxJavaScript.isChecked()) languages.append("Javascript ");

        if (languages.toString().isEmpty()) {
            Toast.makeText(Exercise4Activity.this, "Vui lòng chọn ít nhất một ngôn ngữ yêu thích!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Hiển thị kết quả
        String result = "Tên: " + name + "\nHệ học: " + education + "\nNgôn ngữ yêu thích: " + languages.toString();
        Toast.makeText(Exercise4Activity.this, result, Toast.LENGTH_LONG).show();
    }
}
