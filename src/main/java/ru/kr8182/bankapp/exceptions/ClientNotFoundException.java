package ru.kr8182.bankapp.exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(Long id) {
        super("Клиент с таким id не найден");
    }
}
