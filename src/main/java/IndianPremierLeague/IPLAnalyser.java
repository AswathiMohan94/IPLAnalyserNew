package IndianPremierLeague;

import com.google.gson.Gson;
import com.opencsv.CSVReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static IndianPremierLeague.IPLAnalyserException.ExceptionType.FILE_PROBLEM;
import static java.util.stream.Collectors.toCollection;

public class IPLAnalyser {


    static Map<String, IPLdataDAO> IPLdataMap = null;
    static Map<String, IPLWktsDAO> IPLWktMap = null;


    public IPLAnalyser() {
        this.IPLdataMap = new HashMap<>();
        this.IPLWktMap = new HashMap<>();

    }


    public int loadIPLdata(String csvFilePath) throws IPLAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IPLdataCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLdataCSV.class);
            int count = 0;
            while (csvFileIterator.hasNext()) {
                IPLdataDAO ipl = new IPLdataDAO(csvFileIterator.next());
                this.IPLdataMap.put(ipl.PLAYER, ipl);
               /* for (Map.Entry<String, IPLdataDAO> entry : IPLdataMap.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }*/
            }
            return this.IPLdataMap.size();
        } catch (IOException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new IPLAnalyserException(e.getMessage(), e.type.name());
        }
    }

    public int loadBowlingdata(String csvFilePath) throws IPLAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IPLWktsCSV> csvWktFileIterator = csvBuilder.getCSVFileIterator(reader, IPLWktsCSV.class);
            int count = 0;
            while (csvWktFileIterator.hasNext()) {
                IPLWktsDAO Wkts = new IPLWktsDAO(csvWktFileIterator.next());
                this.IPLWktMap.put(Wkts.PLAYER, Wkts);
               /* for (Map.Entry<String, IPLdataDAO> entry : IPLdataMap.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }*/
            }
            return this.IPLdataMap.size();
        } catch (IOException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new IPLAnalyserException(e.getMessage(), e.type.name());
        }
    }


    public String getAverageWiseSortedData() throws IPLAnalyserException {
        if (IPLdataMap == null || IPLdataMap.size() == 0)
            throw new IPLAnalyserException("No Census Data", FILE_PROBLEM);
        Comparator<Map.Entry<String, IPLdataDAO>> averageComparator = Comparator.comparing(average -> average.getValue().Avg);
        LinkedHashMap<String, IPLdataDAO> sortedByValue = this.SortAvg(averageComparator);
        ArrayList<IPLdataDAO> list1 = new ArrayList<>(sortedByValue.values()); //for getting the state which having the hightest area, the order need to be reversed into descending order
        Collections.reverse(list1);
        String sortedStateCodeJson = new Gson().toJson(list1);
        System.out.println("1" + sortedStateCodeJson);
        return sortedStateCodeJson;
    }

    private <E extends IPLdataDAO> LinkedHashMap<String, IPLdataDAO> SortAvg(Comparator averageComparator) {
        Set<Map.Entry<String, IPLdataDAO>> entries = IPLdataMap.entrySet();
        List<Map.Entry<String, IPLdataDAO>> listOfEntries = new ArrayList<>(entries);
        Collections.sort(listOfEntries, averageComparator);
        LinkedHashMap<String, IPLdataDAO> sortedByValue = new LinkedHashMap<>(listOfEntries.size());
        for (Map.Entry<String, IPLdataDAO> entry : listOfEntries) {
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        return sortedByValue;
    }

    public String getStrikingRates() throws IPLAnalyserException {
        if (IPLdataMap == null || IPLdataMap.size() == 0)
            throw new IPLAnalyserException("No Census Data", FILE_PROBLEM);
        Comparator<Map.Entry<String, IPLdataDAO>> strikingComparator = Comparator.comparing(average -> average.getValue().SR);
        LinkedHashMap<String, IPLdataDAO> sortedByValue = this.SortStrikingRates(strikingComparator);
        ArrayList<IPLdataDAO> list1 = new ArrayList<>(sortedByValue.values()); //for getting the state which having the hightest area, the order need to be reversed into descending order
        Collections.reverse(list1);
        String sortedStateCodeJson = new Gson().toJson(list1);
        System.out.println("1" + sortedStateCodeJson);
        return sortedStateCodeJson;
    }


    private <E extends IPLdataDAO> LinkedHashMap<String, IPLdataDAO> SortStrikingRates(Comparator strikingComparator) {
        Set<Map.Entry<String, IPLdataDAO>> entries = IPLdataMap.entrySet();
        List<Map.Entry<String, IPLdataDAO>> listOfEntries = new ArrayList<>(entries);
        Collections.sort(listOfEntries, strikingComparator);
        LinkedHashMap<String, IPLdataDAO> sortedByValue = new LinkedHashMap<>(listOfEntries.size());
        for (Map.Entry<String, IPLdataDAO> entry : listOfEntries) {
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        return sortedByValue;
    }

    public  String Max_six_four(String csvFilepath) {
        double six = 0;
        double four = 0;
        String batsman = "";
        List<String[]> records;
        int count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilepath))) {
            CSVReader csvReader = new CSVReader(bufferedReader);
            records = csvReader.readAll();
            for (String[] record : records) {
                if (count > 0) {
                    Double individualSix = Double.parseDouble(record[13]);
                    Double individualfour = Double.parseDouble(record[12]);

                    if (four <= individualSix) {
                        if (six < individualSix) {
                            six = individualSix;
                            four = individualfour;
                            batsman = record[1];
                        }
                    }
                }
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return batsman;
        }

    }
    public String BestStrikeRate_Six(String csvFilepath) {
        double six = 0;
        double strike = 0;
        String player = "";
        List<String[]> records;
        int count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilepath))) {
            CSVReader csvReader = new CSVReader(bufferedReader);
            records = csvReader.readAll();
            for (String[] record : records) {
                if (count > 0) {
                    Double individualsix = Double.parseDouble(record[13]);
                    Double individualstrike = Double.parseDouble(record[9]);

                    if (six <= individualstrike) {
                        if (strike < individualstrike) {
                            strike = individualstrike;
                            six = individualsix;
                            player = record[1];
                        }
                    }
                }
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return player;
        }
    }
    public String BestStrikeRate_four(String csvFilepath) {
        double four = 0;
        double strike = 0;
        String player = "";
        List<String[]> records;
        int count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilepath))) {
            CSVReader csvReader = new CSVReader(bufferedReader);
            records = csvReader.readAll();
            for (String[] record : records) {
                if (count > 0) {
                    Double individualfour = Double.parseDouble(record[12]);
                    Double individualstrike = Double.parseDouble(record[9]);

                    if (four <= individualstrike) {
                        if (strike < individualstrike) {
                            strike = individualstrike;
                            four = individualfour;
                            player = record[1];
                        }
                    }
                }
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return player;
        }
    }
    public  String Max_Runs_BestAvg(String csvFilepath) {
        double runs = 0;
        double avg = 0;
        String batsman = "";
        List<String[]> records;
        int count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilepath))) {
            CSVReader csvReader = new CSVReader(bufferedReader);
            records = csvReader.readAll();
            for (String[] record : records) {
                if (count > 0) {
                    Double individualRun = Double.parseDouble(record[5]);
                    Double individualAvg = Double.parseDouble(record[7]);

                    if (runs <= individualAvg) {
                        if (avg < individualAvg) {
                            avg = individualAvg;
                            runs = individualRun;
                            batsman = record[1];
                        }
                    }
                }
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return batsman;
        }
    }

        public String BestAvg_StrikingRate (String csvFilepath){
            double strike = 0;
            double average = 0;
            String player = "";
            List<String[]> records;
            int count = 0;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilepath))) {
                CSVReader csvReader = new CSVReader(bufferedReader);
                records = csvReader.readAll();
                for (String[] record : records) {
                    if (count > 0) {
                        Double individualstrikeRate = Double.parseDouble(record[9]);
                        Double individualAverage = Double.parseDouble(record[7]);

                        if (strike <= individualAverage) {
                            if (average < individualAverage) {
                                average = individualAverage;
                                strike = individualstrikeRate;
                                player = record[1];
                            }
                        }
                    }
                    count++;
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                return player;
            }

        }


        public String getMaxBowling_Avg () throws IPLAnalyserException {
            if (IPLWktMap == null || IPLWktMap.size() == 0)
                throw new IPLAnalyserException("No Census Data", FILE_PROBLEM);
            Comparator<Map.Entry<String, IPLWktsDAO>> AvgComparator = Comparator.comparing(Avg -> Avg.getValue().Avg);
            LinkedHashMap<String, IPLWktsDAO> sortedByBowlingValue = this.SortMaxAvg(AvgComparator);
            ArrayList<IPLWktsDAO> list2 = new ArrayList<>(sortedByBowlingValue.values()); //for getting the state which having the hightest area, the order need to be reversed into descending order
            Collections.reverse(list2);
            String sortedStateCodeJson = new Gson().toJson(list2);
            System.out.println("1" + sortedStateCodeJson);
            return sortedStateCodeJson;
        }

        private <E extends IPLWktsDAO > LinkedHashMap < String, IPLWktsDAO > SortMaxAvg(Comparator AvgComparator) {
            Set<Map.Entry<String, IPLWktsDAO>> entries = IPLWktMap.entrySet();
            List<Map.Entry<String, IPLWktsDAO>> listOfEntries = new ArrayList<>(entries);
            Collections.sort(listOfEntries, AvgComparator);
            LinkedHashMap<String, IPLWktsDAO> sortedByBowlingValue = new LinkedHashMap<>(listOfEntries.size());
            for (Map.Entry<String, IPLWktsDAO> entry : listOfEntries) {
                sortedByBowlingValue.put(entry.getKey(), entry.getValue());
            }
            return sortedByBowlingValue;
        }


    public String getStrikingRates_bowlers() throws IPLAnalyserException {
        if (IPLWktMap == null || IPLWktMap.size() == 0)
            throw new IPLAnalyserException("No Census Data", FILE_PROBLEM);
        Comparator<Map.Entry<String, IPLWktsDAO>> SRComparator = Comparator.comparing(SR -> SR.getValue().SR);
        LinkedHashMap<String, IPLWktsDAO> sortedByBowlingValue = this.SortStrikeRates_Bowlers(SRComparator);
        ArrayList<IPLWktsDAO> list2 = new ArrayList<>(sortedByBowlingValue.values()); //for getting the state which having the hightest area, the order need to be reversed into descending order
        Collections.reverse(list2);
        String sortedStateCodeJson = new Gson().toJson(list2);
        System.out.println("1" + sortedStateCodeJson);
        return sortedStateCodeJson;
    }

    private <E extends IPLWktsDAO> LinkedHashMap<String, IPLWktsDAO> SortStrikeRates_Bowlers(Comparator SRComparator) {
        Set<Map.Entry<String, IPLWktsDAO>> entries = IPLWktMap.entrySet();
        List<Map.Entry<String, IPLWktsDAO>> listOfEntries = new ArrayList<>(entries);
        Collections.sort(listOfEntries, SRComparator);
        LinkedHashMap<String, IPLWktsDAO> sortedByBowlingValue = new LinkedHashMap<>(listOfEntries.size());
        for (Map.Entry<String, IPLWktsDAO> entry : listOfEntries) {
            sortedByBowlingValue.put(entry.getKey(), entry.getValue());
        }
        return sortedByBowlingValue;
    }

    public String BestEconomyRates_Bowlers() throws IPLAnalyserException {
        if (IPLWktMap == null || IPLWktMap.size() == 0)
            throw new IPLAnalyserException("No Census Data", FILE_PROBLEM);
        Comparator<Map.Entry<String, IPLWktsDAO>> EconComparator = Comparator.comparing(Econ -> Econ.getValue().Econ);
        LinkedHashMap<String, IPLWktsDAO> sortedByBowlingValue = this.SortEconomyRates_Bowlers(EconComparator);
        ArrayList<IPLWktsDAO> list2 = new ArrayList<>(sortedByBowlingValue.values()); //for getting the state which having the hightest area, the order need to be reversed into descending order
        Collections.reverse(list2);
        String sortedStateCodeJson = new Gson().toJson(list2);
        System.out.println("1" + sortedStateCodeJson);
        return sortedStateCodeJson;
    }

    private <E extends IPLWktsDAO> LinkedHashMap<String, IPLWktsDAO> SortEconomyRates_Bowlers(Comparator EconComparator) {
        Set<Map.Entry<String, IPLWktsDAO>> entries = IPLWktMap.entrySet();
        List<Map.Entry<String, IPLWktsDAO>> listOfEntries = new ArrayList<>(entries);
        Collections.sort(listOfEntries, EconComparator);
        LinkedHashMap<String, IPLWktsDAO> sortedByBowlingValue = new LinkedHashMap<>(listOfEntries.size());
        for (Map.Entry<String, IPLWktsDAO> entry : listOfEntries) {
            sortedByBowlingValue.put(entry.getKey(), entry.getValue());
        }
        return sortedByBowlingValue;
    }

    public String BestStrikingRates_5w(String csvFilepath) {
        double strikeRate = 0;
        double fourW = 0;
        String bowler = "";
        List<String[]> records;
        int count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilepath))) {
            CSVReader csvReader = new CSVReader(bufferedReader);
            records = csvReader.readAll();
            for (String[] record : records) {
                if (count > 0) {
                    Double individualStrikeRate = Double.parseDouble(record[10]);
                    Double individualfourW = Double.parseDouble(record[11]);

                    if (fourW <= individualStrikeRate) {
                        if (strikeRate < individualfourW) {
                            strikeRate = individualStrikeRate;
                            fourW = individualfourW;
                            bowler = record[1];
                        }
                    }
                }
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return bowler;
        }

    }

    public  String BowlingAverages_StrikingRates(String csvFilepath) {
        double average = 0;
        double strikeRate = 0;
        String bowler = "";
        List<String[]> records;
        int count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilepath))) {
            CSVReader csvReader = new CSVReader(bufferedReader);
            records = csvReader.readAll();
            for (String[] record : records) {
                if (count > 0) {
                    Double individualStrikeRate = Double.parseDouble(record[10]);
                    Double individualAverage = Double.parseDouble(record[8]);

                    if (strikeRate <= individualAverage) {
                        if (average < individualAverage) {
                            average = individualAverage;
                            strikeRate = individualStrikeRate;
                            bowler = record[1];
                        }

                    }

                }
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return bowler;
        }
    }


    public String Wickets_BestAvg(String csvFilepath) {
        double wicket = 0;
        double average = 0;
        String bowler = "";
        List<String[]> records;
        int count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilepath))) {
            CSVReader csvReader = new CSVReader(bufferedReader);
            records = csvReader.readAll();
            for (String[] record : records) {
                if (count > 0) {
                    Double individualWicket = Double.parseDouble(record[6]);
                    Double individualAverage = Double.parseDouble(record[8]);

                    if (average <= individualWicket) {
                        if (wicket < individualWicket) {
                            wicket = individualWicket;
                            average = individualAverage;
                            bowler = record[1];
                        }
                    }
                }
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return bowler;
        }

    }

    public String Best_Batting_Bowling_Avg(String csvFilepath, String csvFilepath1) {
        double batting = 0;
        double bowling = 0;
        String player = "";
        List<String[]> battingAvg;
        List<String[]> bowlingAvg;
        int count = 0;
        int count1 = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilepath))) {
            CSVReader csvReader = new CSVReader(bufferedReader);
            battingAvg = csvReader.readAll();
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(csvFilepath1));
            CSVReader csvReader1 = new CSVReader(bufferedReader1);
            bowlingAvg = csvReader1.readAll();

            for (String[] record1 : bowlingAvg) {
                if (count1> 0) {
                    for (String[] record : battingAvg) {
                        if (count > 0) {
                            Double individualbatting = Double.parseDouble(record[7]);
                            Double individualbowling = Double.parseDouble(record1[8]);

                            if (bowling <= individualbatting) {
                                if (batting < individualbowling) {
                                    batting = individualbatting;
                                    bowling = individualbowling;
                                    player = record[1];

                                }
                            }
                        }
                        count++;
                    }
                }count1++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return player;
        }

    }

    public String Best_Runs_wickets(String csvFilepath1, String csvFilepath) {
        int runs = 0;
        int wicket = 0;
        String player = "";
        List<String[]> batting;
        List<String[]> bowling;
        int count = 0;
        int count1 = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilepath))) {
            CSVReader csvReader = new CSVReader(bufferedReader);
            batting = csvReader.readAll();
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(csvFilepath1));
            CSVReader csvReader1 = new CSVReader(bufferedReader1);
            bowling = csvReader1.readAll();

            for (String[] record1 : bowling) {
                if (count1> 0) {
                    for (String[] record : batting) {
                        if (count > 0) {

                            Integer individualruns = Integer.parseInt(record[5]);
                            Integer individualwicket = Integer.parseInt(record1[6]);

                            if (wicket <= individualruns) {
                                if (runs < individualwicket) {
                                    runs = individualruns;
                                    wicket = individualwicket;
                                    player = record[1];

                                }
                            }
                        }
                        count++;
                    }
                }count1++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return player;
        }

    }
}
