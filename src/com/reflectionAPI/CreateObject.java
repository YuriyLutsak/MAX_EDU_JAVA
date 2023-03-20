package com.reflectionAPI;

import java.lang.reflect.InvocationTargetException;

/**
 *  В тому ж методі main зробити наступні дії:
 *  * Створити об’єкт класу Library не використовуючи конструктор.
 *  * Створити ще один об’єкт використовуючи конструктор.
 *  * В обох об’єктів замінити значення всіх полів, які мають модифікатор доступу private або final за допомогою інструментів reflection APІ.
 */
public class CreateObject {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        var objectDefaultConstructor = Library.class.getConstructor().newInstance();
        System.out.println(objectDefaultConstructor);
        var instance = Library.class.getConstructor(String.class, int.class, boolean.class, String.class).newInstance("name", 1, true, "address");
        Library library = new Library(7777);
        System.out.println(library);

    }
}
