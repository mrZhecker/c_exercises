package patterns.strategy.main;

public enum SocialNetworks {
    Telegram {
        @Override
        public void send(Message m) {
            System.out.println(m);
        }
    },
    Instagram {
        @Override
        public void send(Message m) {
            System.out.println(m);
        }
    },
    VK {
        @Override
        public void send(Message m) {
            System.out.println(m);
        }
    },
    OK {
        @Override
        public void send(Message m) {
            System.out.println(m);
        }
    };

    abstract public void send(Message m);
}