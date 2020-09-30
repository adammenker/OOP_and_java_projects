/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author adammenker
 */
public class MyStopWatch extends Application {
    public double secondsElapsed = 0.0;
    public double tickTimeInSeconds = 1.0;
    public double angleDeltaPerSeconds = 6.0;
    public Timeline timeline;
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("StopWatch");
        
        StackPane root = new StackPane();
        ImageView dialImageView = new ImageView();
        ImageView handImageView = new ImageView();
        
        Image dialImage = new Image(getClass().getResourceAsStream("clockface.png"));
        Image handImage = new Image(getClass().getResourceAsStream("hand.png"));

        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        
        HBox controlButtons = new HBox();
        Button start = new Button("Start");
        Button stop = new Button("Stop");
        Button reset = new Button("Reset");
        start.setMaxWidth(Double.MAX_VALUE);
        stop.setMaxWidth(Double.MAX_VALUE);
        reset.setMaxWidth(Double.MAX_VALUE);
        
        controlButtons.setSpacing(10);
        controlButtons.setAlignment(Pos.BOTTOM_CENTER);
        controlButtons.setPadding(new Insets(25, 25, 25, 25));
        
        controlButtons.getChildren().addAll(stop, reset, start);

        
        stop.setOnAction((ActionEvent event) -> {
            timeline.pause();
        });
        reset.setOnAction((ActionEvent event) -> {
            timeline.stop();
            handImageView.setRotate(0);
            secondsElapsed = 0.0;
        });
        start.setOnAction((ActionEvent event) -> {
            timeline.play();
        });

        
        root.getChildren().addAll(dialImageView, handImageView, controlButtons);
        
        double width = dialImage.getWidth();
        double height = dialImage.getHeight();
        
        
        Scene scene = new Scene(root, width, height + 100);
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), (ActionEvent event) -> {
            System.out.println("Timeline Event!");
            
            secondsElapsed += tickTimeInSeconds;
            double rotation = secondsElapsed * angleDeltaPerSeconds;
            handImageView.setRotate(rotation);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        // timeline.play();
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
