package ua.edu.dnu.fpm.calc.main;

import ua.edu.dnu.fpm.calc.core.CalcImpl;

public class App {
    public static void main(String[] args) {
        System.out.println("Received arguments:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("Arg " + i + ": '" + args[i] + "'");
        }

        if (args.length < 3) {
            System.out.println("Please provide at least three arguments: number1 number2 operator");
            return;
        }

        try {
            double number1;
            double number2;
            try {
                number1 = Double.parseDouble(args[0]);
                number2 = Double.parseDouble(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: One or both of the first two arguments are not valid numbers. Error: " + e.getMessage());
                return;
            }

            String operator = args[2].trim();

            CalcImpl calc = new CalcImpl();

            double result;
            switch (operator) {
                case "+":
                case "add":
                    result = calc.addition(number1, number2);
                    break;
                case "-":
                case "subtract":
                    result = calc.subtraction(number1, number2);
                    break;
                case "*":
                case "multiply":
                    result = calc.multiplication(number1, number2);
                    break;
                case "/":
                case "divide":
                    try {
                        result = calc.division(number1, number2);
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid operator: '" + operator + "'");
                    return;
            }

            System.out.printf("number1=%.0f number2=%.0f operator=%s result=%.0f%n", number1, number2, operator, result);

            String taskResult = calc.task(args);
            System.out.println(taskResult);

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
