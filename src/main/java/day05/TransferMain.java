package day05;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransferMain {

    public static void main(String[] args) {
        TransferAggregator transferAggregator = new TransferAggregator();
        List<TransferPerClient> list = new ArrayList<>();
        list = transferAggregator.aggregator();
        for (int i = 0; i < list.size(); i++) {
            TransferPerClient t = list.get(i);
            System.out.printf("%2d   %s %12d %5d\n", i+1, t.getClientId(), t.getSum(), t.getNumberOfTransaction());
        }
    }
}
