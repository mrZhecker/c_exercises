package patterns.strategy.strategies;

import patterns.strategy.main.Message;
import patterns.strategy.main.SocialNetworks;

import java.util.ArrayList;

public class SocNetworksInformator implements Informator {
    private ArrayList<SocialNetworks> destinations;
    public SocNetworksInformator(ArrayList<SocialNetworks> networks) {
        this.destinations = networks;
    }
    @Override
    public void inform(Message information) {
        System.out.println("SOCIAL NETWORKS INFORMATOR IS ACTIVE");
        System.out.println("[x] Message payload: " + information);
        for (SocialNetworks d: destinations) {
            if (d == SocialNetworks.Telegram) {
                System.out.println("[x] Searching for a funny sticker to add to the payload");
                System.out.println("[x] Establishing Telegram API connection and sending a message");
            }
            if (d == SocialNetworks.Instagram) {
                System.out.println("[x] Establishing Instagram API connection and sending a message");
                System.out.println("[x] Liking all recipient photos");
            }
            if (d == SocialNetworks.VK) {
                System.out.println("[x] Establishing VK API connection and sending a message");
                System.out.println("[x] Liking all recipient posts");
            }
            if (d == SocialNetworks.OK) {
                System.out.println("[x] Establishing OK API connection and sending a message");
                System.out.println("[x] KLASS!'ing all recipient posts");
                System.out.println("[x] Crying in a shower feeling dirty after OK");
            }
        }
        System.out.println();
    }
}
