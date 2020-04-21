package IndianPremierLeageTest;

import IndianPremierLeague.*;
import com.google.gson.Gson;
import com.opencsv.CSVReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class IPLAnalyserTest {

    private static final String IPL_CSV = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_CSV_WICKETS = "./src/test/resources/IPL2019FactsheetMostWkts.csv";


    @Test
    public void TopBattingAveragesOfCricketers()  {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLdata(IPL_CSV);
            String sortedData = iplAnalyser.getAverageWiseSortedData();
            System.out.println(sortedData);

            IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
            Assert.assertEquals("MS Dhoni", iplCSV[0].PLAYER);
        } catch (IPLAnalyserException e) {

            e.printStackTrace();
        }
    }

    @Test
    public void StrikingRates_Batsman() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLdata(IPL_CSV);
            String sortedData = iplAnalyser.getStrikingRates();
            IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
            Assert.assertEquals("Ishant Sharma", iplCSV[0].PLAYER);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void Max_6s_4s()  {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        String Data = iplAnalyser.Max_six_four(IPL_CSV);
        Assert.assertEquals("David Warner", Data);
    }
    @Test
    public void BestStrikeRate_with_6s()  {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        String Data = iplAnalyser.BestStrikeRate_Six(IPL_CSV);
        Assert.assertEquals("Ishant Sharma", Data);
    }
    @Test
    public void BestStrikeRate_with_4s()  {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        String Data = iplAnalyser.BestStrikeRate_four(IPL_CSV);
        Assert.assertEquals("Ishant Sharma", Data);
    }
    @Test
    public void BestAvg_StrikeRate()  {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        String Data = iplAnalyser.BestAvg_StrikingRate(IPL_CSV);
        Assert.assertEquals("David Warner", Data);
    }

    @Test
    public void Max_Runs_BestAvg()  {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        String Data = iplAnalyser.Max_Runs_BestAvg(IPL_CSV);
        Assert.assertEquals("David Warner", Data);
    }
    @Test
    public void Bowling_Best_Avg()  {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadBowlingdata(IPL_CSV_WICKETS);
            String sortedData = iplAnalyser.getMaxBowling_Avg();
            System.out.println(sortedData);
            IPLWktsCSV[] iplCSV = new Gson().fromJson(sortedData, IPLWktsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", iplCSV[0].PLAYER);
        } catch (IPLAnalyserException e) {

            e.printStackTrace();
        }
    }
    @Test
    public void TopStrikingRates_Bowlers()  {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadBowlingdata(IPL_CSV_WICKETS);
            String sortedData = iplAnalyser.getStrikingRates_bowlers();
            System.out.println(sortedData);

            IPLWktsCSV[] iplCSV = new Gson().fromJson(sortedData, IPLWktsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", iplCSV[0].PLAYER);
        } catch (IPLAnalyserException e) {

            e.printStackTrace();
        }
    }
    @Test
    public void BestEconomyRates_Bowlers()  {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadBowlingdata(IPL_CSV_WICKETS);
            String Data = iplAnalyser.BestEconomyRates_Bowlers();
            System.out.println(Data);

            IPLWktsCSV[] iplCSV = new Gson().fromJson(Data, IPLWktsCSV[].class);
            Assert.assertEquals("Ben Cutting", iplCSV[0].PLAYER);
        } catch (IPLAnalyserException e) {

            e.printStackTrace();
        }
    }  @Test
    public void BestStrikingRates_4w_Bowlers()  {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        String Data = iplAnalyser.BestStrikingRates_5w(IPL_CSV_WICKETS);
        Assert.assertEquals("Imran Tahir", Data);
    }
    @Test
    public void BestAverages_with_StrikingRates_Bowlers()  {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        String Data = iplAnalyser.BowlingAverages_StrikingRates(IPL_CSV_WICKETS);
        Assert.assertEquals("Krishnappa Gowtham", Data);
    }
    @Test
    public void Wickets_BestAvg_Bowlers()  {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        String Data = iplAnalyser.Wickets_BestAvg(IPL_CSV_WICKETS);
        Assert.assertEquals("Imran Tahir", Data);
    }
    @Test
    public void Best_Batting_Bowling_Avg() {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        String Data = iplAnalyser.Best_Batting_Bowling_Avg(IPL_CSV_WICKETS,IPL_CSV);
        Assert.assertEquals("Imran Tahir", Data);
    }
    @Test
    public void Best_Runs_wickets() {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        String Data = iplAnalyser.Best_Runs_wickets(IPL_CSV_WICKETS,IPL_CSV);
        Assert.assertEquals("Imran Tahir", Data);
    }

}
