package patterns.observer.timewatcher.sockets;

import java.util.Calendar;
import java.util.List;

public class CheckingThread extends Thread {
	private CheckingTypes type;
	private int recheckDelay;
	private List<ClientConnection> connections;
	private boolean activeStatus;
	
	public CheckingThread(CheckingTypes typeArg, int recheckDelayArg, List<ClientConnection> connectionsArg) {
		this.recheckDelay = recheckDelayArg;
		this.type = typeArg;
		this.connections = connectionsArg;
		this.activeStatus = false;
	}
	
	public void run() {
		while (true) {
			int currentUnit;
			switch (this.type) {
				case SECONDS: {
					currentUnit = Calendar.getInstance().get(Calendar.SECOND);
					while (this.getActiveStatus()) {
						int newCurrentUnit = Calendar.getInstance().get(Calendar.SECOND);
						if (newCurrentUnit != currentUnit) {
							currentUnit = newCurrentUnit;
							System.out.println("Current clients:");
							for (ClientConnection con : this.connections) {
								System.out.println(con.getNameAndAddress());							
								con.send("Attention, the second has changed");
							}
						}
						System.out.println("[x] Checking second again");
						try {
							sleep(1000 * this.recheckDelay);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;
				}
				case MINUTES: {
					currentUnit = Calendar.getInstance().get(Calendar.MINUTE);
					while (this.getActiveStatus()) {
						int newCurrentUnit = Calendar.getInstance().get(Calendar.MINUTE);
						if (newCurrentUnit != currentUnit) {
							currentUnit = newCurrentUnit;
							for (ClientConnection con : this.connections) {
								con.send("Attention, the minute has changed");
							}
						}
						System.out.println("[x] Checking minute again");
						try {
							sleep(1000 * this.recheckDelay);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;
				}
				case HOURS: {
					currentUnit = Calendar.getInstance().get(Calendar.HOUR);
					while (this.getActiveStatus()) {
						int newCurrentUnit = Calendar.getInstance().get(Calendar.HOUR);
						if (newCurrentUnit != currentUnit) {
							currentUnit = newCurrentUnit;
							for (ClientConnection con : this.connections) {
								con.send("Attention, the hour has changed");
							}
						}
						System.out.println("[x] Checking hour again");
						if (this.connections.size() < 1) this.activeStatus = false;
						try {
							sleep(1000 * this.recheckDelay);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;
				}
			}
		}
	}
	
	public boolean getActiveStatus() {
		return this.activeStatus;
	}
	
	public void setActive(boolean newState) {
		this.activeStatus = newState;
	}
}
