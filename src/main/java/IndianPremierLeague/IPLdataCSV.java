package IndianPremierLeague;

import com.opencsv.bean.CsvBindByName;

public class IPLdataCSV {

    @CsvBindByName(column = "PLAYER",required = true)
    public String PLAYER;

    @CsvBindByName(column = "Avg",required = true)
    public double Avg;


    @Override
    public String toString() {
        System.out.println("8");
        return "IPLdataCSV{" +
                "PLAYER='" + PLAYER + '\'' +
                ", Avg='" + Avg + '\'' +
                '}';
    }
}
