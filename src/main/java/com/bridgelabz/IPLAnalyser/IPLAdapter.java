package com.bridgelabz.IPLAnalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

    public class IPLAdapter {
        static Map<String, IPLCricketDAO> IPLBallMap = null;

        public IPLAdapter() {
            this.IPLBallMap = new HashMap<String, IPLCricketDAO>();

            this.IPLdataMap = new HashMap<String, IPLCricketDAO>();
        }
            static Map<String, IPLCricketDAO> IPLBatMap = null;
            static Map<String, IPLCricketDAO> IPLdataMap = null;


    public Map<String, IPLCricketDAO> loadBattingData(String... csvFilePath) throws IPLAnalyserException, IOException {

         try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath[0]));) {

             ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
             Iterator<IPLdataCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLdataCSV.class);
             int count = 0;
                    while (csvFileIterator.hasNext()) {
                        IPLCricketDAO ipl = new IPLCricketDAO(csvFileIterator.next());

                        this.IPLdataMap.put(ipl.PLAYER, ipl);
               /* for (Map.Entry<String, IPLdataDAO> entry : IPLdataMap.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }*/
            }
            return IPLdataMap;


        } catch (IOException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new IPLAnalyserException(e.getMessage(), e.type.name());
         }
    }
    public Map<String, IPLCricketDAO> loadBowlerData(String... csvFilepath) throws IPLAnalyserException, IOException, CSVBuilderException {
            try (Reader reader = Files.newBufferedReader(Paths.get(csvFilepath[0]));) {
                ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
                Iterator<IPLWktsCSV> csvWktFileIterator = csvBuilder.getCSVFileIterator(reader, IPLWktsCSV.class);
                int count = 0;
                while (csvWktFileIterator.hasNext()) {
                    IPLCricketDAO Wkts = new IPLCricketDAO(csvWktFileIterator.next());
                    this.IPLBallMap.put(Wkts.PLAYER, Wkts);
                }
           return IPLBallMap;
        } catch (IOException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new IPLAnalyserException(e.getMessage(), e.type.name());
        }
    }

}
