package patterns.strategy.main;

public class Message {
    private String payload;
    public Message(String mes) {
        this.payload = mes;
    }

    @Override
    public String toString() {
        return this.payload;
    }
}
