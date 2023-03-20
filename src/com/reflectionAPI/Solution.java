package com.reflectionAPI;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * В методі main вивести на екран наступну інформацію:
 * * Ім'я класу.+
 * * Модифікатори класу (public, private, protected, abstract, final тощо).
 * * Батьківський клас та інтерфейси, які він реалізує.
 * * Поля класу, їх імена, модифікатори, типи.
 * * Конструктори класу, модифікатори та параметри.
 * * Методи класу, їх імена, модифікатори, типи повернення та параметри.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("Ім'я класу: ".toUpperCase() + Library.class.getSimpleName());
        System.out.println("Модифікатори класу: ".toUpperCase() + Modifier.toString(Library.class.getModifiers()));
        System.out.printf("Батьківський клас: %s та інтерфейси, які він реалізує: %s%n", Library.class.getSuperclass().getSimpleName(), Arrays.toString(Library.class.getInterfaces()));
        System.out.println("Поля класу, їх імена, модифікатори, типи:".toUpperCase());
        fieldsOfClass();
        System.out.println("Конструктори класу, модифікатори та параметри:".toUpperCase());
        constructorsOfClass();
        System.out.println("Методи класу, їх імена, модифікатори, типи повернення та параметри: ".toUpperCase());
        methodsOfClass();


    }

    private static void methodsOfClass() {
        var methods = Library.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Ім'я: " +  method.getName() +
                    ",  модифікатори: " + Modifier.toString(method.getModifiers()) +
                    ", типи повернення: " + method.getReturnType() +
                    ", параметри: " + Arrays.toString(method.getParameters()));
        }
    }

    private static void constructorsOfClass() {
        var constructors = Library.class.getConstructors();
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            System.out.println("Конструктор класу: " + constructor.getName() +
                    ", модифікатор: " + Modifier.toString(constructor.getModifiers()) +
                    ", параметри: " + Arrays.toString(constructor.getParameterTypes()));
        }
    }

    private static void fieldsOfClass() {
        var fields = Library.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("iм'я: " + field.getName() +
                    ", модифікатор: " + (field.getModifiers() == 0 ? "default" : Modifier.toString(field.getModifiers())) +
                    ", тип: " + field.getType().getSimpleName() + " ");
        }
    }

}
