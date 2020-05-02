package com.bridgelabz.IPLAnalyser;

import com.google.gson.Gson;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyser {

    private static final IPLAnalyserException.ExceptionType FILE_PROBLEM = null;
    Map<String, IPLCricketDAO> IPLDataMap;

    Comparator<IPLCricketDAO> censusComparator = null;
    public enum Cricketer {BATSMAN, BOWLER;}

    public IPLAnalyser() {
        this.IPLDataMap = new HashMap<>();
    }

    public int loadIPLdata(Cricketer cricketer, String... csvFilePath) throws IPLAnalyserException, CSVBuilderException, IOException {
        IPLDataMap = IPLAdapterFactory.getCricketDetails(cricketer, csvFilePath);
        return IPLDataMap.size();
    }
    public String sort(Comparator<IPLCricketDAO> censusComparator){
        ArrayList RunList =  IPLDataMap.values().stream().sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(RunList);
        String sortedJsonData = new Gson().toJson(RunList);
        return sortedJsonData;
    }
    public String getAverageWiseSortedData() {
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.AvgBat);
        // return this.sort(censusComparator);
        return sort(censusComparator);
    }
    public String strikeRateSortedData()  {
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.SRBat);
        return sort(censusComparator);
    }
    public String MaxSixAndFourSortedData()  {
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.six).thenComparing(variable -> variable.four);
        return sort(censusComparator);
    }
    public String BestStrikingRatesWith6And4s() {
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.SRBat).thenComparing(variable -> variable.six).thenComparing(variable -> variable.four);
        return sort(censusComparator);
    }
    public String GreatAvgAndBestStrikingRates()  {
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.AvgBat).thenComparing(variable -> variable.SRBat);
        return sort(censusComparator);
    }
    public String MaxRunsAndBestAvg()  {
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.Runs).thenComparing(variable -> variable.AvgBat);
        return sort(censusComparator);
    }
    public String TopBowlingAvg()  {
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.Avg);
        return sort(censusComparator);
    }
    public String TopStrikingRates() {
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.SR);
        return sort(censusComparator);
    }
    public String BestEconomyRates() {
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.Econ);
        return sort(censusComparator);
    }
    public String BestStrikingRatesWith5wAnd4w() {
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.SR).thenComparing(variable -> variable.fourW)
                .thenComparing(variable -> variable.fiveW);
        return sort(censusComparator);
    }
    public String MaxWicketsWithGreatBowlingAvg() {
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.wkts).thenComparing(variable -> variable.SR);
        return sort(censusComparator);
    }
    public String BestBowlingAvgWithStrikeRate() {
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.Avg).thenComparing(variable -> variable.SR);
        return sort(censusComparator);
    }
    public String BestBattingAndBowlingAvg() {
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.AvgBat).thenComparing(variable -> variable.Avg);
        return sort(censusComparator);
    }
    public String WithMaxRunsAndWickets() {
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.Runs).thenComparing(variable -> variable.wkts);
        return sort(censusComparator);
    }
}