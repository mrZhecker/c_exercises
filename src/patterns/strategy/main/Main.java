package patterns.strategy.main;

import patterns.strategy.strategies.IVRInformator;
import patterns.strategy.strategies.SMSInformator;
import patterns.strategy.strategies.SocNetworksInformator;

import java.util.ArrayList;

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

        ArrayList<SocialNetworks> destinationNetworks = new ArrayList<SocialNetworks>();
        destinationNetworks.add(SocialNetworks.Telegram);
        destinationNetworks.add(SocialNetworks.Instagram);
        destinationNetworks.add(SocialNetworks.VK);
        destinationNetworks.add(SocialNetworks.OK);
        mySender.setInformStrategy(new SocNetworksInformator(destinationNetworks));
        mySender.setMessageToSend("Hi, social network user!");
        mySender.send();
    }
}
