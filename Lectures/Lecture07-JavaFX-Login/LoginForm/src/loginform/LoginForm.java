/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginform;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author adammenker
 */
public class LoginForm extends Application {
    
    public String title = "My JavaFX Login Form";
    public int width = 600;
    public int height = 400;
    public String fontStyle = "Comic Sans MS";
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title);
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(20);
        root.setVgap(20);
        root.setPadding(new Insets(25,25,25,25));
        
        Text sceneTitle = new Text("Welcome Please Login");
        sceneTitle.setFont(Font.font(fontStyle, FontWeight.BOLD, 26));
//        root.add(sceneTitle, 0, 0);
        root.add(sceneTitle, 0, 0, 2, 1);
        
        Label userName = new Label("Username: ");
        userName.setFont(Font.font(fontStyle, FontWeight.NORMAL, 18));
        root.add(userName, 0, 1);
        
        TextField userNameText = new TextField();
        root.add(userNameText, 1, 1);
        
        Label password = new Label("Password: ");
        password.setFont(Font.font(fontStyle, FontWeight.NORMAL, 18));
        root.add(password, 0, 2);
        
        PasswordField passField = new PasswordField();
        root.add(passField, 1, 2);
        
        root.setGridLinesVisible(true);
        
        Button button = new Button("Sign In");
        HBox hboxForButton = new HBox(10);
        hboxForButton.setAlignment(Pos.BOTTOM_RIGHT);
        hboxForButton.getChildren().add(button);
        root.add(hboxForButton, 1, 4);
        
        Text actionTarget = new Text();
        GridPane.setColumnIndex(actionTarget, 1);
        GridPane.setRowIndex(actionTarget, 6);
        root.getChildren().add(actionTarget);
        
        button.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Sign in button pressed");
                
                if(userNameText.getText().length() < 1){
                    System.out.println("ERROR: Username length must be at least one character");
                }
                else {
                    System.out.println("Username: " + userNameText.getText());
                }
                
                if(passField.getText().length() < 1){
                    System.out.println("ERROR: Username length must be at least one character");
                }
                else {
                    System.out.println("Password: " + passField.getText());
                }
            }
        });
        
        
        
        Scene scene = new Scene(root, width, height);
        
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
