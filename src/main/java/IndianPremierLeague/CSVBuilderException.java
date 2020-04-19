package IndianPremierLeague;


public class CSVBuilderException extends Exception {

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
