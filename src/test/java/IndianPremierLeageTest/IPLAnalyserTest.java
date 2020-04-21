package IndianPremierLeageTest;

import IndianPremierLeague.*;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class IPLAnalyserTest {

    private static final String IPL_CSV = "./src/test/resources/IPL2019FactsheetMostRuns.csv";

    @Test
    public void TopBattingAveragesOfCricketers() throws IPLAnalyserException {
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
}
    @Test
    public void BestAvg_StrikeRate()  {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        String Data = iplAnalyser.BestAvg_StrikingRate(IPL_CSV);
        Assert.assertEquals("David Warner", Data);
    }
      
}
