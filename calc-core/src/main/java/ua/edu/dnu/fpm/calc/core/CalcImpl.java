package ua.edu.dnu.fpm.calc.core;

import ua.edu.dnu.fpm.calc.api.Calc;
import java.util.ArrayList;
import java.util.List;

public class CalcImpl implements Calc {
    @Override
    public double addition(double a, double b) {
        return a + b;
    }

    @Override
    public double subtraction(double a, double b) {
        return a - b;
    }

    @Override
    public double multiplication(double a, double b) {
        return a * b;
    }

    @Override
    public double division(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    @Override
    public String task(String[] args) {
        int totalParams = args.length;
        int numberParams = 0;
        List<Integer> integerParams = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            if (i == 2) continue; 

            if (isInteger(args[i])) {
                numberParams++;
                int num = Integer.parseInt(args[i]);
                integerParams.add(num);
            }
        }

        Integer maxNumber = findMaxNumber(integerParams);
        String maxNumberStr = (maxNumber != null) ? String.valueOf(maxNumber) : "None";
        return String.format("Total args: %d, Number args: %d, Max number: %s", totalParams, numberParams, maxNumberStr);
    }

    private boolean isInteger(String arg) {
        if (arg == null || arg.isEmpty()) return false;
        char firstChar = arg.charAt(0);
        int startIndex = (firstChar == '+' || firstChar == '-') ? 1 : 0;

        for (int i = startIndex; i < arg.length(); i++) {
            if (!Character.isDigit(arg.charAt(i))) return false;
        }
        return true;
    }

    private Integer findMaxNumber(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return null;
        }
        Integer max = numbers.get(0);
        for (Integer num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
