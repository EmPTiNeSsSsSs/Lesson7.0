package com.example.lesson70;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Boolean isOperation;
    private TextView tvOutput;
    private Integer first, second, result;
    private char operation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOutput = findViewById(R.id.tv_output);
    }

    @SuppressLint("NonConstantResourceId")
    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;
            case R.id.btn_three:
                setNumber("3");
                break;
            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;
            case R.id.btn_six:
                setNumber("6");
                break;
            case R.id.btn_seven:
                setNumber("7");
                break;
            case R.id.btn_eight:
                setNumber("8");
                break;
            case R.id.btn_nine:
                setNumber("9");
                break;
            case R.id.btn_zero:
                setNumber("0");
        }
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ac:
                tvOutput.setText("0");
                first = 0;
                second = 0;
                break;
            case R.id.btn_plus:
                setOperation('+');
                break;
            case R.id.btn_minus:
                setOperation('-');
                break;
            case R.id.btn_multiplication:
                setOperation('*');
                break;
            case R.id.btn_division:
                setOperation('/');
                break;
            case R.id.btn_equal:
                second = Integer.parseInt(tvOutput.getText().toString());
                switch (operation) {
                    case '+':
                        result = first + second;
                        break;
                    case '-':
                        result = first - second;
                        break;
                    case '*':
                        result = first * second;
                        break;
                    case '/':
                        result = first / second;
                        break;
                }
                tvOutput.setText(result.toString());
                isOperation = true;
                break;
        }
    }

    private void setNumber(String number) {
        if (tvOutput.getText().toString().equals("0")) {
            tvOutput.setText(number);
        } else if (isOperation) {
            tvOutput.setText(number);
        } else {
            tvOutput.append(number);
        }
        isOperation = false;
    }

    private void setOperation(char operation1) {
        first = Integer.parseInt(tvOutput.getText().toString());
        tvOutput.setText("0");
        isOperation = true;
        operation = operation1;
    }

}