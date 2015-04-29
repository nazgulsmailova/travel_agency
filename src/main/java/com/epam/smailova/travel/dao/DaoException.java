package com.epam.smailova.travel.dao;

public class DaoException extends Exception {
    public DaoException(){
        super();
    }

    public DaoException(String message){
        super(message);
    }

    public DaoException(String arg0, Throwable arg1){
        super(arg0, arg1);
    }

    public DaoException(Throwable arg0){
        super(arg0);
    }
}
