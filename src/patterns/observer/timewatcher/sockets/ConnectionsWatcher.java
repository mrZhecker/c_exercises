package patterns.observer.timewatcher.sockets;

import java.util.List;

public class ConnectionsWatcher extends Thread {
	private List<ClientConnection> connectionsToWatch;
	private int recheckDelay;
	private CheckingThread jobToManage;
	
	public ConnectionsWatcher(List<ClientConnection> connectionsArgument, int recheckDelayArgument, CheckingThread jobToManageArgument) {
		this.connectionsToWatch = connectionsArgument;
		this.recheckDelay = recheckDelayArgument;
		this.jobToManage = jobToManageArgument;
	}
	
	public void run() {
		while (true) {
			jobToManage.setActive(!connectionsToWatch.isEmpty());
			try {
				sleep(1000 * recheckDelay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			connectionsToWatch.removeIf(con -> !con.getActiveStatus());
		}
	}
	
}
