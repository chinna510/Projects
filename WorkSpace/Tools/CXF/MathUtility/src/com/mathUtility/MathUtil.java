package com.mathUtility;

import javax.jws.WebService;

@WebService(targetNamespace = "http://mathUtility.com/", portName = "MathUtilPort", serviceName = "MathUtilService")
public class MathUtil {
	public int addIntegers(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }    

    public int factorial(int n) {
        int result = 1;        
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }        
        return result;
    }
}
