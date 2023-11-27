package com.example.bmi_calculatore;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText text1,text2,text3;
Button btn1;
TextView result,suggestion;
LinearLayout desing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.edit1);
        text2 = findViewById(R.id.edit2);
        text3 = findViewById(R.id.edit3);
        btn1 = findViewById(R.id.button);
        result = findViewById(R.id.resultView);
        desing = findViewById(R.id.linear);
        suggestion=findViewById(R.id.suggestion);

        btn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(text1.getText().toString());//75
                int ft = Integer.parseInt(text2.getText().toString());//6
                int in = Integer.parseInt(text3.getText().toString());//1
                int totalIn = ft * 12 + in;//73
                double totalCm = totalIn * 2.53;//184.69
                double totalM = totalCm / 100;//1.8469
                double bmi = wt / (totalM * totalM);
                if (bmi > 25) {
                    result.setText("you are overweight");
                    suggestion.setText("loss your weight 5 to 8 kg");
                    desing.setBackgroundColor(getResources().getColor(R.color.red));

                } else if (bmi < 18) {
                    result.setText("You are underweight");
                    suggestion.setText("gain your weight 3 to 5 kg ");
                    desing.setBackgroundColor(getResources().getColor(R.color.yellow));
                } else {
                    result.setText("You are healthy");
                    desing.setBackgroundColor(getResources().getColor(R.color.green));
                }
            }

        });
    }
}