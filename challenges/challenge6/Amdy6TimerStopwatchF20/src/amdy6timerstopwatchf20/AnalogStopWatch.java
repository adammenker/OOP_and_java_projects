/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amdy6timerstopwatchf20;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
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
    
    GridPane rootContainer;
    StackPane clockContainer;
    GridPane digitalContainer;
    GridPane timerContainer;
    GridPane recordBoard;
    ImageView dialImageView;
    ImageView handImageView;
    Image dialImage;
    Image handImage;
    private String dialImageName;
    private String handImageName;
    int timerInput;
    
    Label digitalClock;
    Label timer;
    
    Label recordOne;
    Label recordTwo;
    Label recordThree;
    
    int recordNum = 0;
    double lastRecordVal = 0;
    
    public AnalogStopWatch(){
        secondsElapsed = 0.0;
        tickTimeInSeconds = 0.01;
        angleDeltaPerSeconds = 6.0;
        handImageName = "hand.png";
        dialImageName = "clockface.png";
        this.timerInput = getStartTimeInput();
        setupUI();
        setupTimer();
    }
    
    public void setupUI(){
        // root
        rootContainer = new GridPane();
        rootContainer.setAlignment(Pos.BASELINE_CENTER);
        rootContainer.setHgap(10);
        rootContainer.setVgap(10);
        
        // analog clock
        clockContainer = new StackPane();
        rootContainer.add(clockContainer, 0, 0);
        
        dialImageView = new ImageView();
        handImageView = new ImageView();
        dialImage = new Image(getClass().getResourceAsStream(dialImageName));
        handImage = new Image(getClass().getResourceAsStream(handImageName));
        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        
        clockContainer.getChildren().addAll(dialImageView, handImageView);
        
        
        //digital clock
        timerContainer = new GridPane();
        digitalClock = new Label("00:00.0");
        digitalClock.setFont(new Font(30));
        digitalClock.setMaxWidth(200);
        digitalClock.setMinWidth(200);
        timerContainer.add(digitalClock, 0, 0);
        timer = new Label("Timer:  " + formatSeconds(timerInput));
        timer.setFont(new Font(15));
        timerContainer.add(timer, 0, 1);
        

        // record board
        recordBoard = new GridPane();
        recordOne = new Label("Rec 0: 00:00.0");
        recordBoard.add(recordOne, 0, 0);
        recordTwo = new Label("Rec 0: 00:00.0");
        recordBoard.add(recordTwo, 0, 1);
        recordThree = new Label("Rec 0: 00:00.0");
        recordBoard.add(recordThree, 0, 2);
        
        digitalContainer = new GridPane();
        digitalContainer.setAlignment(Pos.BASELINE_CENTER);
        digitalContainer.setVgap(10);
        digitalContainer.setHgap(30);
        digitalContainer.add(timerContainer, 0, 0);
        digitalContainer.add(recordBoard, 1, 0);
        rootContainer.add(digitalContainer, 0, 1);
        
        
        // buttons
        HBox controlButtons = new HBox();
        rootContainer.add(controlButtons, 0, 2);
        
        Button startStop = new Button("Start");
        Button resetRecord = new Button("Record");
        startStop.setMaxWidth(Double.MAX_VALUE);
        resetRecord.setMaxWidth(Double.MAX_VALUE);
        
        controlButtons.setSpacing(10);
        controlButtons.setAlignment(Pos.BOTTOM_CENTER);
        controlButtons.setPadding(new Insets(25, 25, 25, 25));
        
        controlButtons.getChildren().addAll(resetRecord, startStop);

        
        startStop.setOnAction((ActionEvent event) -> {
            if(!isRunning()){
                startStop.setText("Stop");
                resetRecord.setText("Record");
                timeline.play();
                
            } else{
                startStop.setText("Start");
                resetRecord.setText("Reset");
                timeline.pause();
            }
        });
        resetRecord.setOnAction((ActionEvent event) -> {
            if(!isRunning()){
                timeline.stop();
                handImageView.setRotate(0);
                secondsElapsed = 0.0;
                timer.setText("Timer:  " + formatSeconds(timerInput));
                digitalClock.setText(formatSeconds(0));
                recordOne.setText("Rec 0: " + formatSeconds(0));
                recordTwo.setText("Rec 0: " + formatSeconds(0));
                recordThree.setText("Rec 0: " + formatSeconds(0));
                lastRecordVal = 0;
                recordNum = 0;
            } else{
                addRecord();
            }
        });
    }
    
    public void setupTimer(){
        if(isRunning()){
            timeline.stop();
        }
        keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 1000), (ActionEvent event) -> {
            update();
            updateDigital();
            updateTimer();
        });
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    
    private void update(){
        secondsElapsed += tickTimeInSeconds;
        double rotation = secondsElapsed * angleDeltaPerSeconds;
        handImageView.setRotate(rotation); 
    }
    
    public void updateDigital(){
        String clockOutput = formatSeconds(secondsElapsed);
        digitalClock.setText(clockOutput);
    }
    
    public void updateTimer(){
        double seconds = (double)timerInput - secondsElapsed;
        if(seconds >= 0){
            String timerVal = formatSeconds(seconds);
            timer.setText("Timer:  " + timerVal);
        } else if(seconds < 0 && seconds > -0.01){
            timer.setText("Time's up!");
        }
    }
    
    public void addRecord(){
        if(!(secondsElapsed > timerInput)){
            if(recordNum % 3 == 0){
                System.out.println(lastRecordVal);

                recordNum++;
                double currentTime = secondsElapsed - lastRecordVal;
                String recordTime = formatSeconds(currentTime);
                recordOne.setText("Rec " + String.valueOf(recordNum) + ": " + recordTime);
                lastRecordVal = secondsElapsed;
            } else if(recordNum % 3 == 1){
                System.out.println(lastRecordVal);

                recordNum++;
                double currentTime = secondsElapsed - lastRecordVal;
                String recordTime = formatSeconds(currentTime);
                recordTwo.setText("Rec " + String.valueOf(recordNum) + ": " + recordTime);
                lastRecordVal = secondsElapsed;
            } else if(recordNum % 3 == 2){
                System.out.println(lastRecordVal);

                recordNum++;
                double currentTime = secondsElapsed - lastRecordVal;
                String recordTime = formatSeconds(currentTime);
                recordThree.setText("Rec " + String.valueOf(recordNum) + ": " + recordTime);
                lastRecordVal = secondsElapsed;
            }
        }
        else{
            displayTimesUp();
        }
    }
    
    public String formatSeconds(double inputSeconds){
        int mins = (int)(inputSeconds / 60);
        int seconds = (int)(inputSeconds % 60);
        int milliseconds = (int)((inputSeconds - seconds) * 100);
        
        String stringMins = String.valueOf(mins);
        String stringSeconds = String.valueOf(seconds);
        String stringMilliseconds = String.valueOf(milliseconds);
        
        if(stringMins.length() < 2){
            stringMins = "0" + stringMins;
        }
        if(stringSeconds.length() < 2){
            stringSeconds = "0" + stringSeconds;
        }
        
        return (stringMins + ":" + stringSeconds + "." + stringMilliseconds);
    }
    
    public boolean isRunning(){
        if(timeline != null){
            if(timeline.getStatus() == Animation.Status.RUNNING){
                return true;
            }
        }
        return false;
    } 
    
    public void resetTimer(){
        timeline.stop();
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
    
    public int getStartTimeInput(){
        TextInputDialog dialog = new TextInputDialog("");
        dialog.getDialogPane().setMaxWidth(400);
        dialog.getDialogPane().setMinHeight(500);
        dialog.setTitle("Timer Start Time Set Up");
        dialog.setHeaderText("Set up the start time:");
        dialog.setContentText("Please set up the start time, only integers greater than 0 are accepted:");
        dialog.showAndWait();
        String startTimeInput = dialog.getResult();
        
        try{
            int integerStartTime = Integer.parseInt(startTimeInput);
            if(integerStartTime <= 0 ){                      
                throw new NumberFormatException();
            }
            return integerStartTime;
        } catch(NumberFormatException numberFormatError){
            //getStartTimeInput();
        } catch(NullPointerException nullPointerException){
            //getStartTimeInput();
        }
        return getStartTimeInput();
    }
    
    public void displayTimesUp(){
        timer.setText("Time's Up!");
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Time is up!!!");
        alert.setHeaderText("Time's Up!");
        alert.setContentText("Time is up... No more records...");

        alert.show();
    }
    
}


