package com.reflectionAPI;
import java.lang.reflect.InvocationTargetException;

/**-
 * В тому ж методі main зробити наступні дії:
 * * Створити об’єкт класу Library не використовуючи конструктор.
 * * Створити ще один об’єкт використовуючи конструктор.
 * * В обох об’єктів замінити значення всіх полів, які мають модифікатор доступу private або final за допомогою інструментів reflection APІ.
 */
public class CreateObject {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        var instance = Library.class
                .getConstructor(String.class, int.class, boolean.class, String.class)
                .newInstance("name", 1, true, "address");

        System.out.println(instance + " before change");
        var fields = Library.class.getDeclaredFields();
            fields[0].set(instance, "change name");
            fields[1].setAccessible(true);
            fields[1].set(instance, 131313);
            fields[2].set(instance, false);
            fields[3].set(instance, "change address");
        System.out.println(instance + " changed fields");

        Library library = new Library(11);

        System.out.println(library + " before change");
        var field = Library.class.getDeclaredField("name");
        field.set(library, "change name");

        var numberOfBooks = Library.class.getDeclaredField("numberOfBooks");
        numberOfBooks.setAccessible(true);
        numberOfBooks.set(library, 99999);

        var isOpen = Library.class.getDeclaredField("isOpen");
        isOpen.setAccessible(true);
        isOpen.set(library, true);

        var address = Library.class.getDeclaredField("address");
        address.setAccessible(true);
        address.set(library, "change address");
        System.out.println(library + " changed fields");
    }
}
