package com.bridgelabz.IPLAnalyser;

public class IPLWktsDAO {
    public double SR;
    public String PLAYER;
    public double Avg;
    public String fiveW;
    public String fourW;
    public int Runs;
    public double Ov;
    public int MAT;
    public int Inns;
    public double BBI;
    public double Econ;





    public IPLWktsDAO(IPLWktsCSV iplWktsCSV) {
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
}
