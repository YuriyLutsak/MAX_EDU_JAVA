package com.reflectionAPI;

import java.io.Serializable;

/**
 * * Створити клас Library який містить наступні елементи:
 * Чотири поля з різними модифікаторами доступу: name (public), numberOfBooks (private), isOpen (protected) та address (default).
 * * Конструктор з чотирма параметрами.
 * * Три методи з різними модифікаторами доступу: addBook() (private), openLibrary() (protected) та closeLibrary() (default).
 * * Два public методи для отримання значень приватних полів: getNumberOfBooks() та getAddress().
 */
public class Library implements Serializable {

    public String name;
    public int numberOfBooks;
    protected boolean isOpen;
    String address;

    public Library() {
    }

    protected Library(int numberOfBooks) {
        this.numberOfBooks = 13;
        this.name = " qwerty";
    }

    public Library(String name, int numberOfBooks, boolean isOpen, String address) {
        this.name = name;
        this.numberOfBooks = numberOfBooks;
        this.isOpen = isOpen;
        this.address = address;
    }

    private void addBook() {
    }

    protected void openLibrary() {
    }

    void address() {
    }

    public int getNumberOfBooks(int numbers) {
        return numberOfBooks;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", numberOfBooks=" + numberOfBooks +
                ", isOpen=" + isOpen +
                ", address='" + address + '\'' +
                '}';
    }
}
