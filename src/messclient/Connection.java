package messclient;

import java.io.IOException;
import java.net.Socket;


public class Connection {
    Socket socket;
    
    public Connection(String host, int port) throws IOException {
            System.out.println(host);
            System.out.println(port);
            this.socket = new Socket(host, port);
            Main.curConnection = this;
        }
    }

