package controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import messclient.Connection;
import messclient.Main;
import messclient.MessageClient;
import messclient.NameTakenException;


public class ConnectButton {
    public Button conna;
    public TextField ip;
    public TextField name;
    public TextField port;
    
    
    @FXML
    public void handleButtonClick() {
        try {
//            Main.curConnection = new Connection(
//                    ip.getText(), 
//                    Integer.valueOf(port.getText())
//            );
            Main.curConnection = new Connection(
                    "192.168.1.7", 9001);
            Main.mc = new MessageClient(name.getText());
            if (MessageClient.in.readLine().equals("DENIED")) 
                throw new NameTakenException();
        } catch (IllegalArgumentException e) {
            new Alert(AlertType.ERROR, "Something went wrong... Check the input >.<").showAndWait();
            return;
        } catch (IOException ex) {
            new Alert(AlertType.ERROR, "Cannot connect to the server").showAndWait();
            return;     
        } catch (NameTakenException ex) {
            new Alert(AlertType.ERROR, "Name is already taken").showAndWait();
            return;
        }
        Main.connectionStage.close();
    }
}
