package ru.ssau.tk.ArtKsenInc.OOP_JAVA.exceptions;

public class ArrayIsNotSortedException extends RuntimeException {
    public ArrayIsNotSortedException(){
        super();
    }
    public ArrayIsNotSortedException(String message){
        super(message);
    }
}
