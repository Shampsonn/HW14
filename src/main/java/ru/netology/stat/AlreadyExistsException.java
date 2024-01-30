package ru.netology.stat;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(int id) {
        super("Элемент с данным id: " + id + " уже существует");
    }
}
