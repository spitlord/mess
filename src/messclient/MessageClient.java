package messclient;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;


public class MessageClient {
    
    public static BufferedReader in;
    public static PrintWriter out;
    public static Connection con;
    public static String name;

    public MessageClient(String name) throws IOException {
        MessageClient.name = name;
        con = Main.curConnection;
        in = new BufferedReader(new InputStreamReader(con.socket.getInputStream()));
        out = new PrintWriter(con.socket.getOutputStream(), true);
        out.println(name);
    }
    
    
    public void run() throws IOException, ConnectException {
        while(true) {
            String line = in.readLine();
            Toolkit.getDefaultToolkit().beep();
            Main.controller.addMessage(line);
        }
    }
    

}
