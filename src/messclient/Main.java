/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messclient;

import controllers.MessagesUI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author spitlord
 */
public class Main extends Application {
    
    public static Connection curConnection;
    public static MessagesUI controller;
    public static Stage connectionStage;
    public static Stage primaryStage;
    public static MessageClient mc;
    
    @Override
    public void start(Stage primaryStage) throws IOException, InterruptedException {
       this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/controllers/suka.fxml"));
        Scene connectionScene = new Scene(root, 300, 600);
        connectionStage = new Stage();
        connectionStage.setTitle("SukaMessage");
        connectionStage.setScene(connectionScene);
        connectionStage.showAndWait();
        

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/controllers/messages.fxml"));
        root = (Parent) loader.load();
        this.controller = (MessagesUI) loader.getController();
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("messages.fxml");
        primaryStage.setScene(scene);
        primaryStage.show();
                
        mc = new MessageClient();
        new T().start();
        
        
        
    }
    
    class T extends Thread {
        

       
        @Override
        public void run() {
            mc = new MessageClient();
            try {
                mc.run();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
