package patterns.observer.timewatcher.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	
	private static ServerSocket server;
	private static List<ClientConnection> connections;
	
	public static void main(String...args) {
		connections = new ArrayList<>();
		if (args.length != 1) {
			System.out.println("[x] Wrong arguments, exiting");
			System.exit(-1);
		} else { run(args[0]); }
	}

	private static void run(String portArgument) {
		try {
			try {
				int port = Integer.parseInt(portArgument);
				server = new ServerSocket(port);
				System.out.println("[x] Server is online and listening to port: " + port);
				
				CheckingThread currentUnitWatcher = new CheckingThread(CheckingTypes.SECONDS, 2, connections);
				currentUnitWatcher.start();
				ConnectionsWatcher currentConnectionsWatcher = new ConnectionsWatcher(connections, 1, currentUnitWatcher);
				currentConnectionsWatcher.start();
				while (true) {
					Socket anotherClient = server.accept();
					ClientConnection currentCon = new ClientConnection(anotherClient);
					currentCon.start();
					connections.add(currentCon);
				}
			} finally {
				System.out.println("[x] Server is closed");
				server.close();
			}
		} catch (IOException e) { e.printStackTrace(); }
	}
	
}
