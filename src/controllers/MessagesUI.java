package controllers;

import java.awt.Toolkit;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import messclient.Main;
import messclient.MessageClient;


public class MessagesUI {
    
    public Button send;
    public TextField message;
    public TreeView messageTree;
    public TreeItem<String> root;
    
    @FXML
    public void initialize() {
        messageTree.setShowRoot(false);
        root = new TreeItem();
        root.setExpanded(true);
        messageTree.setRoot(root);
    }
    
    
    @FXML
    public void handleSendMessage() {
        
    }

    
    
    @FXML
    public void sendMessage() {
        MessageClient.out.println(message.getText());
    };
    
    
    public void setRoot(TreeItem root) {
        this.root = root;
        root.setExpanded(true);
        messageTree.setRoot(root);
    }
    
    
    public void addMessage(String s) {
        root.getChildren().add(new TreeItem(s));
    }
    
    
    
   
    
    

}
