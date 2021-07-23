package com.nikola.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.nikola.bmi.calculator.HealthsCalculator;

public class MainActivity extends AppCompatActivity {
    private NumberPicker heightNumberPicker;
    private NumberPicker weightNumberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heightNumberPicker = findViewById(R.id.heightNumberPicker);
        weightNumberPicker = findViewById(R.id.weightNumberPicker);
        heightNumberPicker.setMinValue(100);
        heightNumberPicker.setMaxValue(300);
        heightNumberPicker.setValue(175);
        heightNumberPicker.setWrapSelectorWheel(false);
        weightNumberPicker.setMinValue(20);
        weightNumberPicker.setMaxValue(400);
        weightNumberPicker.setValue(70);
        weightNumberPicker.setWrapSelectorWheel(false);

    }
    public void calculateBtnClick(View view) {
        double height = 0;
        double weight = 0;
        if (heightNumberPicker!=null){
            height = heightNumberPicker.getValue();
        }
        if (weightNumberPicker!=null) {
            weight = weightNumberPicker.getValue();
        }
        HealthsCalculator health = new HealthsCalculator();
        double bmiResult = health.calculateBMI(height,weight);
        TextView resultTextView = findViewById(R.id.resultTextView);
        if (bmiResult == -1) {
            resultTextView.setText(health.getErrorMessage());
        }else{
            String bmiCategory = health.determineBMICateory(bmiResult);
            String message = "Your bmi index is:" + String.format(".2f",bmiResult);
            message += System.lineSeparator();
            message += "BMI Category: " + bmiCategory;
            resultTextView.setText(message);
        }
    }
}