package com.bridgelabz.IPLAnalyser;

public class IPLdataDAO {
    private final double SRBat;
    public double SR ;
    public String PLAYER;
    public double AvgBat;
    public int six;
    public int four;
    public int Runs;


    public IPLdataDAO(IPLdataCSV iplDataCSV) {
        this.PLAYER = iplDataCSV.PLAYER;
        this.AvgBat = iplDataCSV.AvgBat;
        this.SRBat = iplDataCSV.SRBat;
        this.six = iplDataCSV.six;
        this.four = iplDataCSV.four;
        this.Runs = iplDataCSV.Runs;



    }
}