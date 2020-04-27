package com.bridgelabz.IPLAnalyser;

public class IPLAnalyserException extends Throwable {
    public ExceptionType type;

   public IPLAnalyserException(String message, String name) {

    }


    public enum ExceptionType {
        FILE_PROBLEM,
        TYPE_EXTENSION_WRONG,WRONG_FILE_TYPE_OR_INVALID_FILE,UNABLE_TO_PARSE,WRONG_DETAILS;

    }

//    ExceptionType type;

    public IPLAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

  }
