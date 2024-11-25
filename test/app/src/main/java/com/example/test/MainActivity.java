package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonExercise1, buttonExercise2, buttonExercise3, buttonExercise4, buttonExercise56;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các nút
        buttonExercise1 = findViewById(R.id.buttonExercise1);
        buttonExercise2 = findViewById(R.id.buttonExercise2);
        buttonExercise3 = findViewById(R.id.buttonExercise3);
        buttonExercise4 = findViewById(R.id.buttonExercise4);
        buttonExercise56 = findViewById(R.id.buttonExercise56);


        // Xử lý khi nhấn nút Bài 1
        buttonExercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exercise1Activity.class);
                startActivity(intent);
            }
        });

        // Xử lý khi nhấn nút Bài 2
        buttonExercise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exercise2Activity.class);
                startActivity(intent);
            }
        });
        buttonExercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exercise3Activity.class);
                startActivity(intent);
            }
        });
        buttonExercise4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exercise4Activity.class);
                startActivity(intent);
            }
        });
        buttonExercise56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exercise56Activity.class);
                startActivity(intent);
            }
        });
    }
}
