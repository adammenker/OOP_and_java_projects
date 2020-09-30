/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amdy6timerstopwatchf20;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author adammenker
 */
public class Amdy6TimerStopwatchF20 extends Application {
    
    private String appName = "Amdy6TimerStopWatchF20";
    
    @Override
    public void start(Stage primaryStage) {
        
        AnalogStopWatch analogStopWatch = new AnalogStopWatch();
        
        Scene scene = new Scene(analogStopWatch.getRootContainer(), 400, 500);

        primaryStage.setTitle(appName);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
