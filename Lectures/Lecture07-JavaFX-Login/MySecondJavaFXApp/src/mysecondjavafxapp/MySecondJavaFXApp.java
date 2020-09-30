/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysecondjavafxapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author adammenker
 */
public class MySecondJavaFXApp extends Application {
      
    public String appName = "My Second JavaFX App";
    public int width = 600;
    public int height = 400;
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25,25,25,25));
        root.setGridLinesVisible(true);
        
        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, 20));
        root.add(sceneTitle, 0, 0);
        
        Label infoLabel = new Label();
        root.add(infoLabel, 0, 1);
        
        Button button = new Button("Hello World!");
        button.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                infoLabel.setText("Hello World from button click");
            }
        });
        root.add(button, 1, 1);
        
        
        
        
        Scene scene = new Scene(root, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle(appName);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
