package ua.edu.dnu.fpm.calc.api;

public interface Calc {
    double addition(double a, double b);
    double subtraction(double a, double b);
    double multiplication(double a, double b);
    double division(double a, double b);
    String task(String[] args);
}
