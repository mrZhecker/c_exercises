package patterns.strategy.strategies;

import patterns.strategy.main.Message;

public class IVRInformator implements Informator {
    @Override
    public void inform(Message information) {
        System.out.println("IVR INFORMATOR IS ACTIVE");
        System.out.println("[x] Message payload: " + information);
        System.out.println("[x] SpeechKit decoding");
        System.out.println("[x] Establishing sip-rtp call");
        System.out.println("[x] Playing");
        System.out.println();
    }
}
