package com.bridgelabz.IPLAnalyser;
import com.bridgelabz.IPLAnalyser.IPLAnalyser;
import java.io.Reader;
import java.util.Iterator;

public class CSVBuilderFactory {
        public static ICSVBuilder createCSVBuilder(){
            OpenCSVBuilder openCSVBuilder = new OpenCSVBuilder() {
                @Override
                public Iterator getWktCSVFileIterator(Reader reader, Class csvClass) throws CSVBuilderException {
                    return null;
                }
            };
            return openCSVBuilder;

        }
    }
