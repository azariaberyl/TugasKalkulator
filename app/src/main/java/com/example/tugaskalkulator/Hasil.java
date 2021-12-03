package com.example.tugaskalkulator;

import java.text.DecimalFormat;

public class Hasil {
    String num1;
    String num2;
    String result;
    String operand;
    DecimalFormat df = new DecimalFormat("###.##");

    public Hasil(String num1, String num2, String result, String operand) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.operand = operand;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getResult() {
        Double hasil = Double.parseDouble(result);
        String format = df.format(hasil);
        return format;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
