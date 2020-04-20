package IndianPremierLeague;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static IndianPremierLeague.IPLAnalyserException.ExceptionType.FILE_PROBLEM;
import static java.util.stream.Collectors.toCollection;

public class IPLAnalyser {

    Map<String, IPLdataDAO> IPLdataMap = null;
    Map<String, IPLWktsDAO> IPLWktMap = null;


    public IPLAnalyser() {
        this.IPLdataMap = new HashMap<>();
        this.IPLWktMap = new HashMap<>();

    }


    public int loadIPLdata(String csvFilePath) throws IPLAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IPLdataCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLdataCSV.class);
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

    public String getMaxSix() throws IPLAnalyserException {
        if (IPLdataMap == null || IPLdataMap.size() == 0)
            throw new IPLAnalyserException("No Census Data", FILE_PROBLEM);
        Comparator<Map.Entry<String, IPLdataDAO>> sixComparator = Comparator.comparing(six -> six.getValue().six);
        LinkedHashMap<String, IPLdataDAO> sortedByValue = this.SortMaxSix(sixComparator);
        ArrayList<IPLdataDAO> list1 = new ArrayList<>(sortedByValue.values()); //for getting the state which having the hightest area, the order need to be reversed into descending order
        Collections.reverse(list1);
        String sortedStateCodeJson = new Gson().toJson(list1);
        System.out.println("1" + sortedStateCodeJson);
        return sortedStateCodeJson;
    }


    private <E extends IPLdataDAO> LinkedHashMap<String, IPLdataDAO> SortMaxSix(Comparator sixComparator) {
        Set<Map.Entry<String, IPLdataDAO>> entries = IPLdataMap.entrySet();
        List<Map.Entry<String, IPLdataDAO>> listOfEntries = new ArrayList<>(entries);
        Collections.sort(listOfEntries, sixComparator);
        LinkedHashMap<String, IPLdataDAO> sortedByValue = new LinkedHashMap<>(listOfEntries.size());
        for (Map.Entry<String, IPLdataDAO> entry : listOfEntries) {
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        return sortedByValue;
    }

    public String getMaxfour() throws IPLAnalyserException {
        if (IPLdataMap == null || IPLdataMap.size() == 0)
            throw new IPLAnalyserException("No Census Data", FILE_PROBLEM);
        Comparator<Map.Entry<String, IPLdataDAO>> fourComparator = Comparator.comparing(four -> four.getValue().four);
        LinkedHashMap<String, IPLdataDAO> sortedByValue = this.SortMaxfour(fourComparator);
        ArrayList<IPLdataDAO> list1 = new ArrayList<>(sortedByValue.values()); //for getting the state which having the hightest area, the order need to be reversed into descending order
        Collections.reverse(list1);
        String sortedStateCodeJson = new Gson().toJson(list1);
        System.out.println("1" + sortedStateCodeJson);
        return sortedStateCodeJson;
    }


    private <E extends IPLdataDAO> LinkedHashMap<String, IPLdataDAO> SortMaxfour(Comparator fourComparator) {
        Set<Map.Entry<String, IPLdataDAO>> entries = IPLdataMap.entrySet();
        List<Map.Entry<String, IPLdataDAO>> listOfEntries = new ArrayList<>(entries);
        Collections.sort(listOfEntries, fourComparator);
        LinkedHashMap<String, IPLdataDAO> sortedByValue = new LinkedHashMap<>(listOfEntries.size());
        for (Map.Entry<String, IPLdataDAO> entry : listOfEntries) {
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        return sortedByValue;
    }

    public String getMaxRuns() throws IPLAnalyserException {
        if (IPLdataMap == null || IPLdataMap.size() == 0)
            throw new IPLAnalyserException("No Census Data", FILE_PROBLEM);
        Comparator<Map.Entry<String, IPLdataDAO>> RunComparator = Comparator.comparing(six -> six.getValue().Runs);
        LinkedHashMap<String, IPLdataDAO> sortedByValue = this.SortMaxRuns(RunComparator);
        ArrayList<IPLdataDAO> list1 = new ArrayList<>(sortedByValue.values()); //for getting the state which having the hightest area, the order need to be reversed into descending order
        Collections.reverse(list1);
        String sortedStateCodeJson = new Gson().toJson(list1);
        System.out.println("1" + sortedStateCodeJson);
        return sortedStateCodeJson;
    }


    private <E extends IPLdataDAO> LinkedHashMap<String, IPLdataDAO> SortMaxRuns(Comparator RunComparator) {
        Set<Map.Entry<String, IPLdataDAO>> entries = IPLdataMap.entrySet();
        List<Map.Entry<String, IPLdataDAO>> listOfEntries = new ArrayList<>(entries);
        Collections.sort(listOfEntries, RunComparator);
        LinkedHashMap<String, IPLdataDAO> sortedByValue = new LinkedHashMap<>(listOfEntries.size());
        for (Map.Entry<String, IPLdataDAO> entry : listOfEntries) {
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        return sortedByValue;
    }
    public String getMaxBowling_Avg() throws IPLAnalyserException {
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

    private <E extends IPLWktsDAO> LinkedHashMap<String, IPLWktsDAO> SortMaxAvg(Comparator AvgComparator) {
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


}