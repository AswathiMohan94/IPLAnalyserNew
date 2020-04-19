package IndianPremierLeague;

public class IPLdataDAO {
    public double SR ;
    public String PLAYER;
    public double Avg;
    public int six;
    public int four;



    public IPLdataDAO(IPLdataCSV iplDataCSV) {
        this.PLAYER = iplDataCSV.PLAYER;
        this.Avg = iplDataCSV.Avg;
        this.SR = iplDataCSV.SR;
        this.six = iplDataCSV.six;
        this.four = iplDataCSV.four;



    }
}