package controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import messclient.Connection;
import messclient.Main;


public class ConnectButton {
    public Button conna;
    public TextField ip;
    public TextField port;
    
    @FXML
    public void handleButtonClick() throws IOException {
        Main.curConnection = new Connection(
                ip.getText(), 
                Integer.valueOf(port.getText())
        );
        
    }
    
    
 
    
    

    
  

}
