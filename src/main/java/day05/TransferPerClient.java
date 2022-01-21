package day05;

public class TransferPerClient {
    private String ClientId;
    private long sum;
    private long numberOfTransaction;

    public TransferPerClient(String clientId, long sum, long numberOfTransaction) {
        ClientId = clientId;
        this.sum = sum;
        this.numberOfTransaction = numberOfTransaction;
    }

    public String getClientId() {
        return ClientId;
    }

    public long getSum() {
        return sum;
    }

    public long getNumberOfTransaction() {
        return numberOfTransaction;
    }
}

