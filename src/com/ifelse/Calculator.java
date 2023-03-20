package com.ifelse;

/**
 * Умовна конструкція if - else.
 * Створити клас Calculator і в ньому створити метод public void calculate (int number),
 * який в залежності від того парна чи не парна цифра передана в нього буде виводити різні повідомлення у консоль.
 */

public class Calculator {

    public static void main(String[] args) {
        calculate(4);
    }

    public static void calculate(int number) {
        if (number % 2 == 0) System.out.println("number is even");
        else System.out.println("number is odd");
    }
}
