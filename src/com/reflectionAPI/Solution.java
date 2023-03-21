package com.reflectionAPI;

import java.lang.reflect.*;
import java.util.Arrays;

/**-
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
        System.out.println("CLASS NAME: " + Library.class.getSimpleName());
        System.out.println("MODIFIERS OF CLASS: " + Modifier.toString(Library.class.getModifiers()));
        System.out.printf("SUPER CLASS: %s, INTERFACES: %s%n", Library.class.getSuperclass().getSimpleName(), Arrays.toString(Library.class.getInterfaces()));
        System.out.println("CLASS FIELDS, THERE NAMES, MODIFIERS, TYPES:");
        fieldsOfClass();
        System.out.println("CLASS CONSTRUCTORS, MODIFIERS, PARAMETERS:");
        constructorsOfClass();
        System.out.println("CLASS METHODS, NAMES, MODIFIERS, RETURN TYPES AND PARAMETERS: ");
        methodsOfClass();
    }

    private static void methodsOfClass() {
        var methods = Library.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("NAME: " + method.getName() +
                    ",  MODIFIERS: " + Modifier.toString(method.getModifiers()) +
                    ", RETURN TYPES: " + method.getReturnType() +
                    ", PARAMETERS: " + Arrays.toString(method.getParameters()));
        }
    }

    private static void constructorsOfClass() {
        var constructors = Library.class.getConstructors();
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            System.out.println("CLASS CONSTRUCTOR: " + constructor.getName() +
                    ", MODIFIERS: " + Modifier.toString(constructor.getModifiers()) +
                    ", PARAMETERS: " + Arrays.toString(constructor.getParameterTypes()));
        }
    }

    private static void fieldsOfClass() {
        var fields = Library.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("NAME: " + field.getName() +
                    ", MODIFIERS: " + (field.getModifiers() == 0 ? "default" : Modifier.toString(field.getModifiers())) +
                    ", TYPE: " + field.getType().getSimpleName());
        }
    }

}
