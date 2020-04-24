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
    private static final String MOCKITO_TEST_CSV="./src/test/resources/csvToTest.csv";
    IPLAnalyser iplAnalyser = null;

    @Mock
        IPLAnalyser iplAnalyserMock;
    getAverageWiseSortedData dataMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    Map<String, Player> battingMap;
    Map<String,IPLWktsDAO> bowlingMap;


    @Before
    public void setUp() throws Exception, IPLAnalyserException {
        iplAnalyser = new IPLAnalyser();
        this.iplAnalyserMock = mock(IPLAnalyser.class);
       /* this.dataMock=mock(IPLAnalyser.getAverageWiseSortedData());
        this.dataMock=mock(IPLAnalyser.getAverageWiseSortedData());
        this.battingMap=new HashMap<String, Player>();
        this.battingMap.put("xyz",new Player("xyz",123,20));
        this.battingMap.put("pqr",new Player("pqr",200,23));
        this.battingMap.put("abc",new Player("abc",150,35));*/

    }
    @Test
    public void TopBattingAveragesOfCricketers()  {
        try {
            iplAnalyser.loadIPLdata(MOCKITO_TEST_CSV);
            when(iplAnalyserMock.getAverageWiseSortedData()).thenReturn("xyz");
            Assert.assertEquals("xyz",iplAnalyserMock.getAverageWiseSortedData());
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
            Assert.assertEquals("uvw",iplAnalyserMock.getStrikingRates());
            verify(iplAnalyserMock).getStrikingRates();
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void Max_6s_4s()  {              //mockito 3

        when(iplAnalyserMock.Max_six_four(MOCKITO_TEST_CSV)).thenReturn("xyz");
        Assert.assertEquals("xyz",iplAnalyserMock.Max_six_four(MOCKITO_TEST_CSV));
        verify(iplAnalyserMock).Max_six_four(MOCKITO_TEST_CSV);
    }
    @Test
    public void BestStrikeRate_with_6s()  {     //mockito 4
        when(iplAnalyserMock.BestStrikeRate_Six(MOCKITO_TEST_CSV)).thenReturn("uvw");
        Assert.assertEquals("uvw",iplAnalyserMock.BestStrikeRate_Six(MOCKITO_TEST_CSV));
        verify(iplAnalyserMock).BestStrikeRate_Six(MOCKITO_TEST_CSV);
    }
    @Test

    public void BestStrikeRate_with_4s()  { //mockito 5
        when(iplAnalyserMock.BestStrikeRate_four(MOCKITO_TEST_CSV)).thenReturn("uvw");
        Assert.assertEquals("uvw",iplAnalyserMock.BestStrikeRate_four(MOCKITO_TEST_CSV));
        verify(iplAnalyserMock).BestStrikeRate_four(MOCKITO_TEST_CSV);
    }
    @Test
    public void BestAvg_StrikeRate() {      //mockito 6
        when(iplAnalyserMock.BestAvg_StrikingRate(MOCKITO_TEST_CSV)).thenReturn("xyz");
        Assert.assertEquals("xyz", iplAnalyserMock.BestAvg_StrikingRate(MOCKITO_TEST_CSV));
        verify(iplAnalyserMock).BestAvg_StrikingRate(MOCKITO_TEST_CSV);
    }
    @Test
    public void Max_Runs_BestAvg()  {
        String Data = iplAnalyser.Max_Runs_BestAvg(IPL_CSV);
        Assert.assertEquals("David Warner", Data);
    }
    @Test
    public void Bowling_Best_Avg()  {
        try {
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
        String Data = iplAnalyser.BestStrikingRates_5w(IPL_CSV_WICKETS);
        Assert.assertEquals("Imran Tahir", Data);
    }
    @Test
    public void BestAverages_with_StrikingRates_Bowlers()  {
        String Data = iplAnalyser.BowlingAverages_StrikingRates(IPL_CSV_WICKETS);
        Assert.assertEquals("Krishnappa Gowtham", Data);
    }
    @Test
    public void Wickets_BestAvg_Bowlers()  {
        String Data = iplAnalyser.Wickets_BestAvg(IPL_CSV_WICKETS);
        Assert.assertEquals("Imran Tahir", Data);
    }

    @Test
    public void Best_Batting_Bowling_Avg() {
        String Data = iplAnalyser.Best_Batting_Bowling_Avg(IPL_CSV_WICKETS,IPL_CSV);
        Assert.assertEquals("Imran Tahir", Data);
    }
    @Test
    public void Best_Runs_wickets() {
        String Data = iplAnalyser.Best_Runs_wickets(IPL_CSV_WICKETS,IPL_CSV);
        Assert.assertEquals("David Warner", Data);
    }


    private class getAverageWiseSortedData {
    }
}
