package patterns.observer.timewatcher.sockets;

import java.io.*;
import java.net.Socket;

public class Client {
	
	private static Socket clientSocket;
	private static BufferedReader in;
	private static BufferedWriter out;
	
	public static void main(String...args) {
		if (args.length < 2) {
			System.out.println("[x] wrong argument number, exiting");
			System.exit(-1);
		}
		try {
			try {
				clientSocket = new Socket(args[0], Integer.parseInt(args[1]));
				//
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
				//
				if (args.length >= 3) {
					out.write(args[2] + "\n");
				} else {
					out.write("Anonymous\n");
				}
				out.flush();
				while (true) {
					String serverResponse = in.readLine();
					System.out.println("[x] Server message: " + serverResponse);
				}
			} finally {
				System.out.println("[x] Client is closed");
				clientSocket.close();
				in.close();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
