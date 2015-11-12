package KingOfTokyoModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

import Main.Client;

public class ServerListener extends Thread {
    private final Logger logger = Logger.getLogger("");
    Socket clientSocket;
    BufferedReader sInput;
    ClientModel clientmodel;

    public ServerListener(ClientModel clientmodel,Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        this.clientmodel=clientmodel;
        this.sInput=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    /**
     * Process messages until the client says "Goodbye"
     */
    
    public void run() {
    listen();
    }
    public void listen(){
    	String s;
    	
    try {
    	while((s=sInput.readLine())!=null){
    		 logger.info("Request from client " + clientSocket.getInetAddress().toString()
                + " for server " + clientSocket.getLocalAddress().toString());
    	}
    }
    catch(Exception e){}
    }
    
    
}
