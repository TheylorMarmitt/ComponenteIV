package br.edu.unoesc.crud.exception;

public class BestBooksException extends RuntimeException {

    public BestBooksException(String msg, Throwable throwable){
        throw new RuntimeException(msg, throwable);
    }

    public BestBooksException(String msg){
        throw new RuntimeException(msg);
    }
}
