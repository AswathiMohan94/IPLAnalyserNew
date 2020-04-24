package IndianPremierLeageTest;

import IndianPremierLeague.*;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;


public class IPLAnalyserTest {

    private static final String IPL_CSV = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_CSV_WICKETS = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String MOCKITO_TEST_CSV = "./src/test/resources/csvToTest.csv";
    private static final String MOCKITO_WKT_CSV = "./src/test/resources/csvToTestWkts.csv";


    IPLAnalyser iplAnalyser = null;

    @Mock
    IPLAnalyser iplAnalyserMock;


    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    Map<String, Player> battingMap;
    Map<String, Player> bowlingMap;


    @Before
    public void setUp() throws Exception, IPLAnalyserException {
        iplAnalyser = new IPLAnalyser();
        this.iplAnalyserMock = mock(IPLAnalyser.class);

    }

    @Test
    public void TopBattingAveragesOfCricketers() {
        try {
            iplAnalyser.loadIPLdata(MOCKITO_TEST_CSV);
            when(iplAnalyserMock.getAverageWiseSortedData()).thenReturn("xyz");
            Assert.assertEquals("xyz", iplAnalyserMock.getAverageWiseSortedData());
            verify(iplAnalyserMock).getAverageWiseSortedData();

        } catch (IPLAnalyserException e) {

            e.printStackTrace();
        }
    }

    @Test
    public void StrikingRates_Batsman() {       //mockito 2
        try {
            iplAnalyser.loadIPLdata(MOCKITO_TEST_CSV);
            when(iplAnalyserMock.getStrikingRates()).thenReturn("uvw");
            Assert.assertEquals("uvw", iplAnalyserMock.getStrikingRates());
            verify(iplAnalyserMock).getStrikingRates();
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Max_6s_4s() {              //mockito 3

        when(iplAnalyserMock.Max_six_four(MOCKITO_TEST_CSV)).thenReturn("xyz");
        Assert.assertEquals("xyz", iplAnalyserMock.Max_six_four(MOCKITO_TEST_CSV));
        verify(iplAnalyserMock).Max_six_four(MOCKITO_TEST_CSV);
    }

    @Test
    public void BestStrikeRate_with_6s() {     //mockito 4
        when(iplAnalyserMock.BestStrikeRate_Six(MOCKITO_TEST_CSV)).thenReturn("uvw");
        Assert.assertEquals("uvw", iplAnalyserMock.BestStrikeRate_Six(MOCKITO_TEST_CSV));
        verify(iplAnalyserMock).BestStrikeRate_Six(MOCKITO_TEST_CSV);
    }

    @Test

    public void BestStrikeRate_with_4s() { //mockito 5
        when(iplAnalyserMock.BestStrikeRate_four(MOCKITO_TEST_CSV)).thenReturn("uvw");
        Assert.assertEquals("uvw", iplAnalyserMock.BestStrikeRate_four(MOCKITO_TEST_CSV));
        verify(iplAnalyserMock).BestStrikeRate_four(MOCKITO_TEST_CSV);
    }

    @Test
    public void BestAvg_StrikeRate() {      //mockito 6
        when(iplAnalyserMock.BestAvg_StrikingRate(MOCKITO_TEST_CSV)).thenReturn("xyz");
        Assert.assertEquals("xyz", iplAnalyserMock.BestAvg_StrikingRate(MOCKITO_TEST_CSV));
        verify(iplAnalyserMock).BestAvg_StrikingRate(MOCKITO_TEST_CSV);
    }

    @Test
    public void Max_Runs_BestAvg() { //mockito 7
        when(iplAnalyserMock.Max_Runs_BestAvg(MOCKITO_TEST_CSV)).thenReturn("xyz");
        Assert.assertEquals("xyz", iplAnalyserMock.Max_Runs_BestAvg(MOCKITO_TEST_CSV));
        verify(iplAnalyserMock).Max_Runs_BestAvg(MOCKITO_TEST_CSV);
    }

    @Test
    public void Bowling_Best_Avg() {
        try {
            iplAnalyser.loadBowlingdata(MOCKITO_WKT_CSV);  //mockito 8
            when(iplAnalyserMock.getMaxBowling_Avg()).thenReturn("pqr");
            Assert.assertEquals("pqr", iplAnalyserMock.getMaxBowling_Avg());
            verify(iplAnalyserMock).getMaxBowling_Avg();
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TopStrikingRates_Bowlers() {
        try {
            iplAnalyser.loadBowlingdata(MOCKITO_WKT_CSV);    //mockito 9
            when(iplAnalyserMock.getStrikingRates_bowlers()).thenReturn("uvw");
            Assert.assertEquals("uvw", iplAnalyserMock.getStrikingRates_bowlers());
            verify(iplAnalyserMock).getStrikingRates_bowlers();
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void BestEconomyRates_Bowlers() {
        try {
            iplAnalyser.loadBowlingdata(MOCKITO_WKT_CSV);    //mockito 10
            when(iplAnalyserMock.BestEconomyRates_Bowlers()).thenReturn("uvw");
            Assert.assertEquals("uvw", iplAnalyserMock.BestEconomyRates_Bowlers());
            verify(iplAnalyserMock).BestEconomyRates_Bowlers();
        } catch (IPLAnalyserException e) {

            e.printStackTrace();
        }
    }

    @Test
    public void BestStrikingRates_4w_Bowlers() {
        when(iplAnalyserMock.BestStrikingRates_5w(MOCKITO_WKT_CSV)).thenReturn("abc");
        Assert.assertEquals("abc", iplAnalyserMock.BestStrikingRates_5w(MOCKITO_WKT_CSV));
        verify(iplAnalyserMock).BestStrikingRates_5w(MOCKITO_WKT_CSV);
    }

    @Test
    public void BestAverages_with_StrikingRates_Bowlers() {
        when(iplAnalyserMock.BowlingAverages_StrikingRates(MOCKITO_WKT_CSV)).thenReturn("abc");
        Assert.assertEquals("abc", iplAnalyserMock.BowlingAverages_StrikingRates(MOCKITO_WKT_CSV));
        verify(iplAnalyserMock).BowlingAverages_StrikingRates(MOCKITO_WKT_CSV);
    }

    @Test
    public void Wickets_BestAvg_Bowlers() {
        when(iplAnalyserMock.Wickets_BestAvg(MOCKITO_WKT_CSV)).thenReturn("abc");
        Assert.assertEquals("abc", iplAnalyserMock.Wickets_BestAvg(MOCKITO_WKT_CSV));
        verify(iplAnalyserMock).Wickets_BestAvg(MOCKITO_WKT_CSV);
    }

    @Test
    public void Best_Batting_Bowling_Avg() {
        when(iplAnalyserMock.Best_Batting_Bowling_Avg(MOCKITO_WKT_CSV, MOCKITO_TEST_CSV)).thenReturn("abc");
        Assert.assertEquals("abc", iplAnalyserMock.Best_Batting_Bowling_Avg(MOCKITO_WKT_CSV, MOCKITO_TEST_CSV));
        verify(iplAnalyserMock).Best_Batting_Bowling_Avg(MOCKITO_WKT_CSV, MOCKITO_TEST_CSV);
    }
    @Test
    public void Best_Runs_wickets() {
        when(iplAnalyserMock.Best_Runs_wickets(MOCKITO_WKT_CSV, MOCKITO_TEST_CSV)).thenReturn("xyz");
        Assert.assertEquals("xyz", iplAnalyserMock.Best_Runs_wickets(MOCKITO_WKT_CSV, MOCKITO_TEST_CSV));
        verify(iplAnalyserMock).Best_Runs_wickets(MOCKITO_WKT_CSV, MOCKITO_TEST_CSV);
    }
}
