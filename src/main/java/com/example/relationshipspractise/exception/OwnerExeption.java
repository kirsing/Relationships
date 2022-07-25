package com.example.relationshipspractise.exception;

public class OwnerExeption extends RuntimeException{
    public OwnerExeption(String message) {
        super(message);
    }
}


/// для каждой ентити свои кастомные исключения + обработчики, файнд бай айди