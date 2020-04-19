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
}
