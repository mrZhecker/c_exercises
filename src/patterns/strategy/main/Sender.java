package patterns.strategy.main;

import patterns.strategy.strategies.EMailInformator;
import patterns.strategy.strategies.Informator;

public class Sender {
    private Informator informStrategy;
    private String messageToSend;
    public void setInformStrategy(Informator newInformStrategy) {
        this.informStrategy = newInformStrategy;
    }
    public void setMessageToSend(String newMessageToSend) {
        this.messageToSend = newMessageToSend;
    }
    public Sender() {
        this.informStrategy = new EMailInformator();
        this.messageToSend = "Test";
    }
    public void send() {
        this.informStrategy.inform(new Message(this.messageToSend));
    }
}
