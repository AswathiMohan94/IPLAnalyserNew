package IndianPremierLeague;

public class IPLdataDAO {
    public double SR ;
    public String PLAYER;
    public double Avg;



    public IPLdataDAO(IPLdataCSV iplDataCSV) {
        this.PLAYER = iplDataCSV.PLAYER;
        this.Avg = iplDataCSV.Avg;
        this.SR = iplDataCSV.SR;

    }
}