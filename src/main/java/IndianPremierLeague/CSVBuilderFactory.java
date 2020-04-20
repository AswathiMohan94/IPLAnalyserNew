package IndianPremierLeague;

import java.io.Reader;
import java.util.Iterator;

public class CSVBuilderFactory {
    public static ICSVBuilder createCSVBuilder() {
        return new OpenCSVBuilder() {
            @Override
            public Iterator getWktCSVFileIterator(Reader reader, Class csvClass) throws CSVBuilderException {
                return null;
            }
        };
    }
}
