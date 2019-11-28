package patterns.observer.timewatcher.sockets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientConnection extends Thread {
	private BufferedReader inputStream;
	private BufferedWriter outputStream;
	private Socket clientSocket;
	private boolean activeStatus;
	private String clientName;
	private String clientAddr;
	
	public ClientConnection(Socket cs) {
		this.clientSocket = cs;
		this.activeStatus = true;
	}
	
	public void run() {
		try {
			this.inputStream = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
			this.outputStream = new BufferedWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()));
			this.clientAddr = this.clientSocket.getInetAddress().toString().substring(1) + ":" + this.clientSocket.getPort();	
			this.clientName = this.inputStream.readLine();
			System.out.println("[x] New client connection: " + this.clientName + " from " + this.clientAddr);
		} catch (Exception e) {
			System.out.println("[x] An error occured with the following client: " + this.getNameAndAddress() + " disconnected");
			this.close();
		}
	}
	
	public boolean getActiveStatus() {
		return this.activeStatus;
	} 
	
	public void send(String messageToClient) {	
		try {
			this.outputStream.write(messageToClient + "\n");
			this.outputStream.flush();
		} catch (IOException e) {
			System.out.println("[x] Client " + this.getNameAndAddress() + " disconnected");
			this.close();
		}
	}
	
	public void close() {
		try {
			this.activeStatus = false;
			this.inputStream.close();
			this.outputStream.close();
			this.clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getNameAndAddress() {
		return this.clientName + " from addr " + this.clientAddr; 
	}
	
}