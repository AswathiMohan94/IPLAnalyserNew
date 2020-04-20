package IndianPremierLeague;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder {
    Iterator getCSVFileIterator(Reader reader,
                                Class csvClass) throws CSVBuilderException;

    Iterator getWktCSVFileIterator(Reader reader,
                                   Class csvClass) throws CSVBuilderException;

    List getCSVFileList(Reader reader, Class csvClass) throws CSVBuilderException;
}
