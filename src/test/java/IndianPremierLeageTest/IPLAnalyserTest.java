package IndianPremierLeageTest;

import IndianPremierLeague.*;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

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
    public void Batsman_MaxSix() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLdata(IPL_CSV);
            String sortedData = iplAnalyser.getMaxSix();
            IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
            Assert.assertEquals("Andre Russell", iplCSV[0].PLAYER);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void Batsman_Maxfour() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLdata(IPL_CSV);
            String sortedData = iplAnalyser.getMaxfour();
            IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
            Assert.assertEquals("Shikhar Dhawan", iplCSV[0].PLAYER);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void BestAvg_GreatStrikigRates() {
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
    public void UC5_BestAvg_GreatStrikigRates() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLdata(IPL_CSV);
            String sortedData = iplAnalyser.getAverageWiseSortedData();
            IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
            Assert.assertEquals("MS Dhoni", iplCSV[0].PLAYER);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void MaxRunsOfCricketers()  {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLdata(IPL_CSV);
            String sortedData = iplAnalyser.getMaxRuns();
            System.out.println(sortedData);

            IPLdataCSV[] iplCSV = new Gson().fromJson(sortedData, IPLdataCSV[].class);
            Assert.assertEquals("David Warner", iplCSV[0].PLAYER);
        } catch (IPLAnalyserException e) {

            e.printStackTrace();
        }
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
}
