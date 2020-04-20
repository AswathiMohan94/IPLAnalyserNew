package IndianPremierLeague;

import com.opencsv.bean.CsvBindByName;

public class IPLWktsCSV {

    @CsvBindByName(column = "PLAYER",required = true)
    public String PLAYER;

    @CsvBindByName(column = "MAT", required = true)
    public int MAT;

    @CsvBindByName(column = "Inns", required = true)
    public int Inns;

    @CsvBindByName(column = "Ov", required = true)
    public double Ov;

    @CsvBindByName(column = "Runs", required = true)
    public int Runs;

    @CsvBindByName(column = "Wkts", required = true)
    public String Wkts;

    @CsvBindByName(column = "Avg",required = true)
    public double Avg;

    @CsvBindByName(column = "BBI", required = true)
    public double BBI;

    @CsvBindByName(column = "Econ", required = true)
    public double Econ;

    @CsvBindByName(column = "SR", required = true)
    public double SR;

    @CsvBindByName(column = "4W", required = true)
    public String fourW;

    @CsvBindByName(column = "5W", required = true)
    public String fiveW;


    @Override
    public String toString() {
        return "IPLdataCSV{" +
                "PLAYER='" + PLAYER + '\'' +
                ", Avg=" + Avg +
                ", SR=" + SR +
                ", MAT=" + MAT +
                ", Inns=" + Inns +
                ", Ov=" + Ov +
                ", Wkts=" + Wkts +
                ", Runs=" + Runs +
                ", BBI=" + BBI +
                ", Econ=" + Econ +
                ", 4W=" + fourW +
                ", 5W=" + fiveW+
                '}';
    }

}
