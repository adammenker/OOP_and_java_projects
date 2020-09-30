/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynewstopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author adammenker
 */
public class AnalogStopWatch {
    private double secondsElapsed;
    private double tickTimeInSeconds;
    private double angleDeltaPerSeconds;
    
    private Timeline timeline;
    private KeyFrame keyFrame;
    
    StackPane rootContainer;
    ImageView dialImageView;
    ImageView handImageView;
    Image dialImage;
    Image handImage;
    private String dialImageName;
    private String handImageName;
    
    public AnalogStopWatch(){
        secondsElapsed = 0.0;
        tickTimeInSeconds = 0.01;
        angleDeltaPerSeconds = 6.0;
        handImageName = "hand.png";
        dialImageName = "clockface.png";
        setupUI();
        setupTimer();
    }
    
    public void setupUI(){
        rootContainer = new StackPane();
        dialImageView = new ImageView();
        handImageView = new ImageView();
        
        dialImage = new Image(getClass().getResourceAsStream(dialImageName));
        handImage = new Image(getClass().getResourceAsStream(handImageName));

        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        
        HBox controlButtons = new HBox();
        Button start = new Button("Start");
        Button stop = new Button("Stop");
        Button reset = new Button("Reset");
        start.setMaxWidth(Double.MAX_VALUE);
        stop.setMaxWidth(Double.MAX_VALUE);
        reset.setMaxWidth(Double.MAX_VALUE);
        
        reset.setOnAction((ActionEvent event) -> {
            if(isRunning()){
                this.setTickTimeInSeconds(0.01);
                reset.setText("1.0");
                // stop();
            } else{
                this.setTickTimeInSeconds(1.0);
                reset.setText("0.01");
                // start();
            }
        });
        
        controlButtons.setSpacing(10);
        controlButtons.setAlignment(Pos.BOTTOM_CENTER);
        controlButtons.setPadding(new Insets(25, 25, 25, 25));
        
        controlButtons.getChildren().addAll(stop, reset, start);
        
        rootContainer.getChildren().addAll(controlButtons, dialImageView, handImageView);
        
        controlButtons.toFront();
    }
    
    public void setupTimer(){
        if(isRunning()){
            timeline.stop();
        }
        keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 1000), (ActionEvent event) -> {
            update();
        });
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        
        if(!isRunning()){
            timeline.play();
        }
    }
    
    private void update(){
        secondsElapsed += tickTimeInSeconds;
        double rotation = secondsElapsed * angleDeltaPerSeconds;
        handImageView.setRotate(rotation);
    }
    
    public boolean isRunning(){
        if(timeline != null){
            if(timeline.getStatus() == Animation.Status.RUNNING){
                return true;
            }
        }
        return false;
    }
    
    public Parent getRootContainer(){
        return rootContainer;
    }
    
    public Double getWidth(){
        if(dialImage != null) return dialImage.getWidth();
        else return 0.0;
    }
    
    public Double getHeight(){
        if(dialImage != null) return dialImage.getHeight();
        else return 0.0;
    }
    
    public void start(){
        timeline.play();
    }
    
    public void setTickTimeInSeconds(Double tickTimeInSeconds){
        this.tickTimeInSeconds = tickTimeInSeconds;
        setupTimer();
    }
}
