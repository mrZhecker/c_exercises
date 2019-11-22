package patterns.strategy.main;

import patterns.strategy.strategies.IVRInformator;
import patterns.strategy.strategies.SMSInformator;
import patterns.strategy.strategies.SocNetworksInformator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Sender mySender = new Sender();

        mySender.setMessageToSend("Hi, email user!");
        mySender.send();

        mySender.setInformStrategy(new SMSInformator());
        mySender.setMessageToSend("Hi, SMS user!");
        mySender.send();

        mySender.setInformStrategy(new IVRInformator());
        mySender.setMessageToSend("Hi, phone user!");
        mySender.send();

        List<SocialNetworks> destinationNetworks = new ArrayList<>(Arrays.asList(SocialNetworks.values()));
        mySender.setInformStrategy(new SocNetworksInformator(destinationNetworks));
        mySender.setMessageToSend("Hi, social network user!");
        mySender.send();
    }
}
