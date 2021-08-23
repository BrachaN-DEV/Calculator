package com.rest.calculator.controller;


import com.rest.calculator.exceptions.ArithmeticCombinationException;
import com.rest.calculator.exceptions.MissingHeaderInfoException;
import com.rest.calculator.model.CalculatorModel;
import org.apache.juli.logging.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.apache.juli.logging.LogFactory.getLog;

@RestController
@RequestMapping("/calculator")
public class CalculatorController{

    @ExceptionHandler
    @PostMapping(path = "/", consumes = "application/json")
    public ResponseEntity<String> calculate(@RequestBody CalculatorModel calculatorModel) throws ArithmeticException {
        Integer res = null;
        String result = null;
        String operator = calculatorModel.getOperator();

        try {
            Integer left = Integer.parseInt(calculatorModel.getLeft());
            Integer right = Integer.parseInt(calculatorModel.getRight());

            if(operator.equals("plus")){
                res = Integer.sum(left, right);
                result = left.intValue() + "+" + right.intValue() + "=";
            }
            else if(operator.equals("minus")){
                res = left - right;
                result = left.intValue() + "-" + right.intValue() + "=";
            }
            else if(operator.equals("multiply")){
                res = left * right;
                result = left.intValue() + "*" + right.intValue() + "=";
            }
            else if(operator.equals("divide")){
                res = left / right;
                result = left.intValue() + "/" + right.intValue() + "=";
            }else{
                throw new MissingHeaderInfoException ("operator NOT OK.");
            }
        }catch(Exception e){
            throw new ArithmeticCombinationException("The combination with the params & operator not OK" +
            "like divide with Zero");
        }

        result = res != null ? result.concat(res.toString()) : null;
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
