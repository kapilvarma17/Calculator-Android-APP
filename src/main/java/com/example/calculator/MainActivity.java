package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double firstNumber;
    double secondNumber;
    boolean error = false;
    TextView textView;
    EditText editText1;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView3);
        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
    }

    public void read(){
        String firstNumberString = editText1.getText().toString().trim();
        String secondNumberString = editText2.getText().toString().trim();
        if (firstNumberString.matches("")&&secondNumberString.matches("")){
            firstNumber = 0;
            secondNumber = 0;
            error = true;
        }
        else if (firstNumberString.equals(".") || secondNumberString.equals(".")){
            error = true;
        }
        else if (firstNumberString.matches("")){
            firstNumber = 0;
            secondNumber = Double.parseDouble(editText2.getText().toString().trim());
        }
        else if (secondNumberString.matches("")){
            firstNumber = Double.parseDouble(editText1.getText().toString().trim());
            secondNumber = 0;
        }
        else{
            firstNumber = Double.parseDouble(editText1.getText().toString().trim());
            secondNumber = Double.parseDouble(editText2.getText().toString().trim());
        }

    }

    public void setResult(double answer){
        DecimalFormat df = new DecimalFormat("#.##");
        if (error== true){
            textView.setText("Please Enter  numbers");
        }
        else
            textView.setText("The result is: " +df.format(answer));

    }



    public void add(View view){
        read();
        double sum = firstNumber + secondNumber;
        setResult(sum);
    }
    public void sub(View view){
        read();
        double ansSub = firstNumber - secondNumber;
        setResult(ansSub);
    }

    public void mult(View view){
        read();
        double multAns = firstNumber * secondNumber;
        setResult(multAns);
    }
    public void div(View view){
        read();
        if (firstNumber == 1 && secondNumber == 0){
            textView.setText("You cannot divide by zero ");
        }
        else{
            double ansDiv = firstNumber/secondNumber;
            setResult(ansDiv);
        }
   }



}
