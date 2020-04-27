package com.bridgelabz.IPLAnalyser;


public class CSVBuilderException extends Exception {
    public CSVBuilderException(String message, IPLAnalyserException.ExceptionType unableToParse) {
    }


    // public ExceptionType;

    enum ExceptionType{
        UNABLE_TO_PARSE;
    }
   // public static Object ExceptionType;
   public  ExceptionType type;
    public CSVBuilderException(String message, ExceptionType unableToParse){
        super(message);
        this.type = type;

    }

}
