package com.nikola.bmi.calculator;

public class HealthsCalculator {
    private String errorMessage;


    public String getErrorMessage() {
        return errorMessage;
    }
    public double calculateBMI(double heightCm,double weightKg){
        double bmiIndex = -1;
        if (heightCm<=0 && weightKg<=0) {
            errorMessage = "Height and weight cannot be zero or less";
        }else{
            bmiIndex = weightKg / ((heightCm/100)*(heightCm/100));
        }
        return bmiIndex;
    }
    public String determineBMICateory(double bmiIndex){
        String bmiCategory = "";
        if (bmiIndex<16) {
            bmiCategory = "Severe thiness";
        }else if(bmiIndex>=17 && bmiIndex< 18.5){
            bmiCategory = "Moderate thiness";
        }else if (bmiIndex>=18.5 && bmiIndex<25){
            bmiCategory = "Normal";
        }else if (bmiIndex>=25 && bmiIndex<35){
            bmiCategory = "Overweight";
        }
        return bmiCategory;
    }
}
