package com.rest.calculator.model;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

public class CalculatorModel implements CalculatorModelIfc {
    public CalculatorModel() {

    }

    public CalculatorModel(String operator, String left, String right) {
        super();
        this.operator = operator;
        this.left = left;
        this.right = right;
    }


    private String operator;
    private String left;
    private String right;

    //Getters and setters:


    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator){
        this.operator = operator;
    }

    public String getLeft(){
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }



}
