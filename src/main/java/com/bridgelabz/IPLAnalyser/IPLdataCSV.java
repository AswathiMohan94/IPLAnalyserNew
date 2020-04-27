package com.bridgelabz.IPLAnalyser;

import com.opencsv.bean.CsvBindByName;

public class IPLdataCSV {

    @CsvBindByName(column = "PLAYER",required = true)
    public String PLAYER;

    @CsvBindByName(column = "Avg",required = true)
    public double AvgBat;

    @CsvBindByName(column = "SR", required = true)
    public double SR;

    @CsvBindByName(column = "MAT", required = true)
    public int MAT;

    @CsvBindByName(column = "Inns", required = true)
    public int Inns;

    @CsvBindByName(column = "NO", required = true)
    public int NO;

    @CsvBindByName(column = "HS", required = true)
    public String HS;

    @CsvBindByName(column = "Runs", required = true)
    public int Runs;

    @CsvBindByName(column = "BF", required = true)
    public int BF;

    @CsvBindByName(column = "100", required = true)
    public int centuary;

    @CsvBindByName(column = "50", required = true)
    public int halfCentuary;

    @CsvBindByName(column = "4s", required = true)
    public int four;

    @CsvBindByName(column = "6s", required = true)
    public int six;



    @Override
    public String toString() {
        return "IPLdataCSV{" +
                "PLAYER='" + PLAYER + '\'' +
                ", Avg=" + AvgBat +
                ", SR=" + SR +
                ", MAT=" + MAT +
                ", Inns=" + Inns +
                ", NO=" + NO +
                ", HS=" + HS +
                ", Runs=" + Runs +
                ", BF=" + BF +
                ", centuary=" + centuary +
                ", halfCentuary=" + halfCentuary +
                ", four=" + four +
                ", six=" + six +
                '}';
    }
}



