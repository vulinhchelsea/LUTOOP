package com.example.week8calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputFirstNumber;
    private EditText inputSecondNumber;
    private TextView calculateResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        calculateResult = findViewById(R.id.calculateResult);
        calculateResult.setTextSize(30);
    }

    public void plus (View view) {
        int sumResult;
        sumResult = Integer.parseInt(inputFirstNumber.getText().toString()) + Integer.parseInt(inputSecondNumber.getText().toString());
        calculateResult.setText(inputFirstNumber.getText().toString() + " + " + inputSecondNumber.getText().toString() + " = " + String.valueOf(sumResult));
    }

    public void minus (View view) {
        int subResult;
        subResult = Integer.parseInt(inputFirstNumber.getText().toString()) - Integer.parseInt(inputSecondNumber.getText().toString());
        calculateResult.setText(inputFirstNumber.getText().toString() + " - " + inputSecondNumber.getText().toString() + " = " + String.valueOf(subResult));
    }

    public void multiply (View view) {
        int mulResult;
        mulResult = Integer.parseInt(inputFirstNumber.getText().toString()) * Integer.parseInt(inputSecondNumber.getText().toString());
        calculateResult.setText(inputFirstNumber.getText().toString() + " * " + inputSecondNumber.getText().toString() + " = " + String.valueOf(mulResult));
    }

    public void divide (View view) {
        float divResult;
        if (inputSecondNumber.getText().toString().equals("0")) {
            calculateResult.setText("Cannot divide by zero");
        }
        else {
            divResult = (Float.parseFloat(inputFirstNumber.getText().toString()))/(Float.parseFloat(inputSecondNumber.getText().toString()));
            calculateResult.setText(inputFirstNumber.getText().toString() + " / " + inputSecondNumber.getText().toString() + " = " + String.valueOf(divResult));
        }
    }
}