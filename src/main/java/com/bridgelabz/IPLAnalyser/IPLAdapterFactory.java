package com.bridgelabz.IPLAnalyser;
import com.bridgelabz.IPLAnalyser.IPLAnalyser;

import java.io.IOException;
import java.util.Map;

public abstract class IPLAdapterFactory {
        public static Map getCricketDetails(IPLAnalyser.Cricketer cricketer, String ...csvFilepath) throws IPLAnalyserException, CSVBuilderException, IOException {
            if(cricketer.equals(IPLAnalyser.Cricketer.BATSMAN))
                return new IPLAdapter().loadBattingData(csvFilepath);
            if(cricketer.equals(IPLAnalyser.Cricketer.BOWLER))
                return new IPLAdapter().loadBowlerData(csvFilepath);
            throw new IPLAnalyserException("Invalid details",IPLAnalyserException.ExceptionType.WRONG_DETAILS);
        }
    }

