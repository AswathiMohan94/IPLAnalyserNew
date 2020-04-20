package IndianPremierLeague;

public class IPLCricketDAO {
    public double SR ;
    public String PLAYER;
    public double Avg;
    public int six;
    public int four;
    public int Runs;
    public double Ov;
    public String fourW;
    public String fiveW;
    public int MAT;
    public int Inns;
    public double BBI;
    public double Econ;




    public IPLCricketDAO(IPLdataCSV iplDataCSV) {
        this.PLAYER = iplDataCSV.PLAYER;
        this.Avg = iplDataCSV.Avg;
        this.SR = iplDataCSV.SR;
        this.six = iplDataCSV.six;
        this.four = iplDataCSV.four;
        this.Runs = iplDataCSV.Runs;

    }
    public IPLCricketDAO(IPLWktsCSV iplWktsCSV) {
        this.PLAYER = iplWktsCSV.PLAYER;
        this.Avg = iplWktsCSV.Avg;
        this.SR = iplWktsCSV.SR;
        this.fiveW = iplWktsCSV.fiveW;
        this.fourW = iplWktsCSV.fourW;
        this.Runs = iplWktsCSV.Runs;
        this.Ov = iplWktsCSV.Ov;
        this.MAT = iplWktsCSV.MAT;
        this.Inns=iplWktsCSV.Inns;
        this.BBI=iplWktsCSV.BBI;
        this.Econ = iplWktsCSV.Econ;

    }
    public IPLCricketDAO(String PLAYER, int Runs, double SR, double Avg, int fours, int six, int wkts, int fourWkts, int fiveWkts) {
    }
}
