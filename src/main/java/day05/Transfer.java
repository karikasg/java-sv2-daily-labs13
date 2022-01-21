package day05;

public class Transfer {
    String uuidFrom;
    String uuidTo;
    long amount;

    public Transfer(String uuidFrom, String uuidTo, long amount) {
        this.uuidFrom = uuidFrom;
        this.uuidTo = uuidTo;
        this.amount = amount;
    }
}
