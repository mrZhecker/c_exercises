package patterns.strategy.strategies;

import patterns.strategy.main.Message;

public class SMSInformator implements Informator {
    @Override
    public void inform(Message information) {
        System.out.println("SMS INFORMATOR IS ACTIVE");
        System.out.println("[x] Message payload: " + information);
        System.out.println("[x] Establishing smpp server connection");
        System.out.println("[x] Sending information via SMS");
        System.out.println();
    }
}
