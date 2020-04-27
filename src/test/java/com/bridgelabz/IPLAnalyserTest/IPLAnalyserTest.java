package com.bridgelabz.IPLAnalyserTest;

import com.bridgelabz.IPLAnalyser.CSVBuilderException;
import com.bridgelabz.IPLAnalyser.IPLAnalyser;
import com.bridgelabz.IPLAnalyser.IPLAnalyserException;
import com.bridgelabz.IPLAnalyser.IPLdataCSV;
import com.google.gson.Gson;
import com.opencsv.CSVReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class IPLAnalyserTest {

    private static final String IPL_CSV = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_CSV_WICKETS = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    IPLAnalyser iplAnalyser = null;

    @Before
    public void setUp() throws Exception {
        iplAnalyser = new IPLAnalyser();

    }
    IPLAnalyser batsman;
    IPLAnalyser bowler;

    @Test
    public void TopBattingAveragesOfCricketers() throws IPLAnalyserException, IOException, CSVBuilderException {
        iplAnalyser.loadIPLdata(IPLAnalyser.Cricketer.BATSMAN, IPL_CSV);
        String sortedData = iplAnalyser.getAverageWiseSortedData();
        System.out.println(sortedData);
        IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
        Assert.assertEquals("MS Dhoni", iplCSV[0].PLAYER);

    }

    @Test
    public void getTopStrikingRates_OfCricketers_ShouldReturnName() throws IPLAnalyserException, IOException, CSVBuilderException {
        iplAnalyser.loadIPLdata(IPLAnalyser.Cricketer.BATSMAN, IPL_CSV);
        String sortedData = iplAnalyser.strikeRateSortedData();
        System.out.println(sortedData);
        IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
        Assert.assertEquals("Ishant Sharma", iplCSV[0].PLAYER);

    }

    @Test
    public void getCricketers_WithMax6sAnd4s_ReturnName() throws IPLAnalyserException, IOException, CSVBuilderException {
        iplAnalyser.loadIPLdata(IPLAnalyser.Cricketer.BATSMAN, IPL_CSV);
        String sortedData = iplAnalyser.MaxSixAndFourSortedData();
        System.out.println(sortedData);
        IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
        Assert.assertEquals("Andre Russell", iplCSV[0].PLAYER);
    }
    @Test
    public void getCricketers_WithBestStrikingRates_WithMax6sAnd4s_ReturnName() throws IPLAnalyserException, IOException, CSVBuilderException {
        iplAnalyser.loadIPLdata(IPLAnalyser.Cricketer.BATSMAN, IPL_CSV);
        String sortedData = iplAnalyser.BestStrikingRatesWith6And4s();
        IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
        Assert.assertEquals("Ishant Sharma", iplCSV[0].PLAYER);
    }
    @Test
    public void getCricketers_WithGreatAvgAndBestStrikingRates_ReturnName() throws IPLAnalyserException, IOException, CSVBuilderException {
        iplAnalyser.loadIPLdata(IPLAnalyser.Cricketer.BATSMAN, IPL_CSV);
        String sortedData = iplAnalyser.GreatAvgAndBestStrikingRates();
        IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
        Assert.assertEquals("MS Dhoni", iplCSV[0].PLAYER);
    }
    @Test
    public void getCricketers_WithMaxRunsAndBestAvg_ReturnName() throws IPLAnalyserException, IOException, CSVBuilderException {
        iplAnalyser.loadIPLdata(IPLAnalyser.Cricketer.BATSMAN, IPL_CSV);
        String sortedData = iplAnalyser.MaxRunsAndBestAvg();
        IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
        Assert.assertEquals("David Warner", iplCSV[0].PLAYER);
    }
    @Test
    public void getCricketers_TopBowlingAvg_ReturnName() throws IPLAnalyserException, IOException, CSVBuilderException {
        iplAnalyser.loadIPLdata(IPLAnalyser.Cricketer.BOWLER, IPL_CSV_WICKETS);
        String sortedData = iplAnalyser.TopBowlingAvg();
        IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplCSV[0].PLAYER);
    }
    @Test
    public void getCricketers_TopStrikingRates_ReturnName() throws IPLAnalyserException, IOException, CSVBuilderException {
        iplAnalyser.loadIPLdata(IPLAnalyser.Cricketer.BOWLER, IPL_CSV_WICKETS);
        String sortedData = iplAnalyser.TopStrikingRates();
        IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplCSV[0].PLAYER);
    }
    @Test
    public void getCricketers_BestEconomy_ReturnName() throws IPLAnalyserException, IOException, CSVBuilderException {
        iplAnalyser.loadIPLdata(IPLAnalyser.Cricketer.BOWLER, IPL_CSV_WICKETS);
        String sortedData = iplAnalyser.BestEconomyRates();
        IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
        Assert.assertEquals("Ben Cutting", iplCSV[0].PLAYER);
    }
    @Test
    public void getCricketers_BestStrikeRatesWith4wAnd5w_ReturnName() throws IPLAnalyserException, IOException, CSVBuilderException {
        iplAnalyser.loadIPLdata(IPLAnalyser.Cricketer.BOWLER, IPL_CSV_WICKETS);
        String sortedData = iplAnalyser.BestEconomyRates();
        IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
        Assert.assertEquals("Ben Cutting", iplCSV[0].PLAYER);
    }
    @Test
    public void getCricketers_withGreatBowlingAvgWithBestStrikingRates_ReturnName() throws IPLAnalyserException, IOException, CSVBuilderException {
        iplAnalyser.loadIPLdata(IPLAnalyser.Cricketer.BOWLER, IPL_CSV_WICKETS);
        String sortedData = iplAnalyser.BestEconomyRates();
        IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
        Assert.assertEquals("Ben Cutting", iplCSV[0].PLAYER);
    }
    @Test
    public void getCricketers_MaxWicketsWithGreatBowlingAvg_ReturnName() throws IPLAnalyserException, IOException, CSVBuilderException {
        iplAnalyser.loadIPLdata(IPLAnalyser.Cricketer.BOWLER, IPL_CSV_WICKETS);
        String sortedData = iplAnalyser.MaxWicketsWithGreatBowlingAvg();
        IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
        Assert.assertEquals("Imran Tahir", iplCSV[0].PLAYER);
    }
    @Test
    public void getCricketers_WithBestBattingAndBowlingBowlingAvg_ReturnName() throws IPLAnalyserException, IOException, CSVBuilderException {
        iplAnalyser.loadIPLdata(IPLAnalyser.Cricketer.BOWLER, IPL_CSV_WICKETS);
        String sortedData = iplAnalyser.BestBattingAndBowlingAvg();
        IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplCSV[0].PLAYER);
    }
    @Test
    public void getCricketers_WithMaxRunsAndWickets_ReturnName() throws IPLAnalyserException, IOException, CSVBuilderException {
        iplAnalyser.loadIPLdata(IPLAnalyser.Cricketer.BOWLER, IPL_CSV_WICKETS);
        String sortedData = iplAnalyser.WithMaxRunsAndWickets();
        IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
        Assert.assertEquals("Deepak Chahar", iplCSV[0].PLAYER);
    }
}
