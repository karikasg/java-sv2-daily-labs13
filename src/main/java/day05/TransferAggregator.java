package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TransferAggregator {

    public List<TransferPerClient> aggregator () {
        List<TransferPerClient> list = new ArrayList<>();
        TreeMap<String, Transfers>  transferList = new TreeMap<>();
        List<Transfer> lines = readFile(Path.of("src/main/resources/transfers.csv"));
        Transfers transfers;
        for (Transfer t : lines) {

            if (transferList.containsKey(t.uuidFrom)) {
                transfers = transferList.get(t.uuidFrom);
                transfers.amount -= t.amount;
                transfers.count++;
                transferList.put(t.uuidFrom, transfers);
            } else {
                transferList.put(t.uuidFrom, new Transfers(-1 * t.amount, 1));
            }
            if (transferList.containsKey(t.uuidTo)) {
                transfers = transferList.get(t.uuidTo);
                transfers.amount += t.amount;
                transfers.count++;
                transferList.put(t.uuidTo, transfers);
            } else {
                transferList.put(t.uuidTo, new Transfers(t.amount, 1));
            }
        }
        for (Map.Entry<String, Transfers> e : transferList.entrySet()) {
            list.add(new TransferPerClient(e.getKey(), e.getValue().amount, e.getValue().count));
        }
        return list;
    }

    public List<Transfer> readFile(Path path) {
        List<Transfer> lines = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String[] elements;
            String line;
            while ((line = br.readLine()) != null) {
                elements = line.split(",");
                lines.add(new Transfer(elements[0], elements[1], Integer.parseInt(elements[2])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File beolvasási hiba", ioe);
        }
        return lines;
    }
}

