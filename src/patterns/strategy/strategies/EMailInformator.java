package patterns.strategy.strategies;

import patterns.strategy.main.Message;

public class EMailInformator implements Informator {
    @Override
    public void inform(Message information) {
        System.out.println("EMAIL INFORMATOR IS ACTIVE");
        System.out.println("[x] Message payload: " + information);
        System.out.println("[x] Establishing smtp server connection");
        System.out.println("[x] Sending information via email");
        System.out.println();

    }
}
