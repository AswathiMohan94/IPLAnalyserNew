package IndianPremierLeague;

public class IPLAnalyserException extends Throwable {
    public ExceptionType type;

   public IPLAnalyserException(String message, String name) {

    }


    public enum ExceptionType {
        FILE_PROBLEM;
    }

//    ExceptionType type;

    public IPLAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

  }
