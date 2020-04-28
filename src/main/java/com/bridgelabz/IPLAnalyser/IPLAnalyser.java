package com.bridgelabz.IPLAnalyser;

import com.google.gson.Gson;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyser {

    private static final IPLAnalyserException.ExceptionType FILE_PROBLEM = null;
    Map<String, IPLCricketDAO> IPLDataMap;

    public enum Cricketer {BATSMAN, BOWLER;}

    public IPLAnalyser() {
        this.IPLDataMap = new HashMap<>();
    }
    public int loadIPLdata(Cricketer cricketer, String... csvFilePath) throws IPLAnalyserException, CSVBuilderException, IOException {
        IPLDataMap = IPLAdapterFactory.getCricketDetails(cricketer, csvFilePath);
        return IPLDataMap.size();
    }
    public String getAverageWiseSortedData() throws IPLAnalyserException {
        Comparator<IPLCricketDAO> censusComparator = null;
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.AvgBat);
        ArrayList RunList = IPLDataMap.values().stream().sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(RunList);
        String sortedJsonData = new Gson().toJson(RunList);
        return sortedJsonData;
    }
    public String strikeRateSortedData() throws IPLAnalyserException {
        Comparator<IPLCricketDAO> censusComparator = null;
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.SRBat);
        ArrayList RunList = IPLDataMap.values().stream().sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(RunList);
        String sortedJsonData = new Gson().toJson(RunList);
        return sortedJsonData;
    }
    public String MaxSixAndFourSortedData() throws IPLAnalyserException {
        Comparator<IPLCricketDAO> censusComparator = null;
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.six).thenComparing(variable -> variable.four);
        ArrayList RunList = IPLDataMap.values().stream().sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(RunList);
        String sortedJsonData = new Gson().toJson(RunList);
        return sortedJsonData;
    }
    public String BestStrikingRatesWith6And4s() throws IPLAnalyserException {
        Comparator<IPLCricketDAO> censusComparator = null;
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.SRBat).thenComparing(variable -> variable.six).thenComparing(variable -> variable.four);
        ArrayList RunList = IPLDataMap.values().stream().sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(RunList);
        String sortedJsonData = new Gson().toJson(RunList);
        return sortedJsonData;
    }
    public String GreatAvgAndBestStrikingRates() throws IPLAnalyserException {
        Comparator<IPLCricketDAO> censusComparator = null;
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.AvgBat).thenComparing(variable -> variable.SRBat);
        ArrayList RunList = IPLDataMap.values().stream().sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(RunList);
        String sortedJsonData = new Gson().toJson(RunList);
        return sortedJsonData;
    }
    public String MaxRunsAndBestAvg() throws IPLAnalyserException {
        Comparator<IPLCricketDAO> censusComparator = null;
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.Runs).thenComparing(variable -> variable.AvgBat);
        ArrayList RunList = IPLDataMap.values().stream().sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(RunList);
        String sortedJsonData = new Gson().toJson(RunList);
        return sortedJsonData;
    }
    public String TopBowlingAvg() throws IPLAnalyserException {
        Comparator<IPLCricketDAO> censusComparator = null;
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.Avg);
        ArrayList RunList = IPLDataMap.values().stream().sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(RunList);
        String sortedJsonData = new Gson().toJson(RunList);
        return sortedJsonData;
    }
    public String TopStrikingRates() throws IPLAnalyserException {
        Comparator<IPLCricketDAO> censusComparator = null;
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.SR);
        ArrayList RunList = IPLDataMap.values().stream().sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(RunList);
        String sortedJsonData = new Gson().toJson(RunList);
        return sortedJsonData;
    }
    public String BestEconomyRates() throws IPLAnalyserException {
        Comparator<IPLCricketDAO> censusComparator = null;
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.Econ);
        ArrayList RunList = IPLDataMap.values().stream().sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(RunList);
        String sortedJsonData = new Gson().toJson(RunList);
        System.out.println(sortedJsonData);
        return sortedJsonData;
    }
    public String BestStrikingRatesWith5wAnd4w() throws IPLAnalyserException {
        Comparator<IPLCricketDAO> censusComparator = null;
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.SR).thenComparing(variable -> variable.fourW)
                .thenComparing(variable -> variable.fiveW);
        ArrayList RunList = IPLDataMap.values().stream().sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(RunList);
        String sortedJsonData = new Gson().toJson(RunList);
        return sortedJsonData;
    }

    public String MaxWicketsWithGreatBowlingAvg() throws IPLAnalyserException {
        Comparator<IPLCricketDAO> censusComparator = null;
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.wkts).thenComparing(variable -> variable.SR);
        ArrayList RunList = IPLDataMap.values().stream().sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(RunList);
        String sortedJsonData = new Gson().toJson(RunList);
        return sortedJsonData;
    }
    public String BestBowlingAvgWithStrikeRate() throws IPLAnalyserException {
        Comparator<IPLCricketDAO> censusComparator = null;
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.Avg).thenComparing(variable -> variable.SR);
        ArrayList RunList = IPLDataMap.values().stream().sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(RunList);
        String sortedJsonData = new Gson().toJson(RunList);
        return sortedJsonData;
    }
    public String BestBattingAndBowlingAvg() throws IPLAnalyserException {
        Comparator<IPLCricketDAO> censusComparator = null;
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.AvgBat).thenComparing(variable -> variable.Avg);
        ArrayList RunList = IPLDataMap.values().stream().sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(RunList);
        String sortedJsonData = new Gson().toJson(RunList);
        return sortedJsonData;
    }
    public String WithMaxRunsAndWickets() throws IPLAnalyserException {
        Comparator<IPLCricketDAO> censusComparator = null;
        censusComparator = Comparator.comparing((IPLCricketDAO variable) -> variable.Runs).thenComparing(variable -> variable.wkts);
        ArrayList RunList = IPLDataMap.values().stream().sorted(censusComparator).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(RunList);
        String sortedJsonData = new Gson().toJson(RunList);
        return sortedJsonData;
    }
}