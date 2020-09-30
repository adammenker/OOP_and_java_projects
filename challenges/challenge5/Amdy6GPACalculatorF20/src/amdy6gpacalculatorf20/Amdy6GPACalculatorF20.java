/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amdy6gpacalculatorf20;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.GridPane.setColumnSpan;
import static javafx.scene.layout.GridPane.setRowSpan;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author adammenker
 */
public class Amdy6GPACalculatorF20 extends Application {
    public String title = "GPA Calculator";
    public int width = 400;
    public int height = 400;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title);
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.BASELINE_CENTER);
        root.setHgap(8);
        root.setVgap(8);
        
        Label Course1 = new Label("Course 1: ");
        root.add(Course1, 0, 0);     
        
        TextField score1 = new TextField();
        score1.setPrefWidth(300);
        root.add(score1, 1, 0);
        
        Label Course2 = new Label("Course 2: ");       
        root.add(Course2, 0, 1);
        
        TextField score2 = new TextField();
        score2.setPrefWidth(300);
        root.add(score2, 1, 1);
        
        Label Course3 = new Label("Course 3: ");
        root.add(Course3, 0, 2);
        
        TextField score3 = new TextField();
        score3.setPrefWidth(300);
        root.add(score3, 1, 2);
        
        Label Course4 = new Label("Course 4: ");
        root.add(Course4, 0, 3);
        
        TextField score4 = new TextField();
        score4.setPrefWidth(300);
        root.add(score4, 1, 3);
        
        Label FinalGPA = new Label("Final GPA: ");       
        root.add(FinalGPA, 0, 4);
        
        TextArea finalScore = new TextArea();
        root.add(finalScore, 1, 4);
        finalScore.setPrefWidth(300);
        finalScore.setPrefRowCount(2);
        finalScore.setWrapText(true);
        finalScore.setEditable(false);
        
        Button emulateGPA = new Button("Emulate GPA");
        emulateGPA.setMaxWidth(Double.MAX_VALUE);
        Button calculateGPA = new Button("Calculate GPA");
        calculateGPA.setMaxWidth(Double.MAX_VALUE);
        Button clearAll = new Button("Clear All");
        clearAll.setMaxWidth(Double.MAX_VALUE);
        Button alert = new Button("Alert");
        alert.setMaxWidth(Double.MAX_VALUE);    
        
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/VBox.html found out how to use vbox
        VBox vbox = new VBox();
        root.add(vbox, 0, 5);
        vbox.getChildren().addAll(emulateGPA, calculateGPA, clearAll, alert);
        vbox.setPadding(new Insets(10,0,10,0));
        vbox.setSpacing(15);
        setColumnSpan(vbox, 2);
        setRowSpan(vbox, 1);
        
        
        calculateGPA.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                double numOfScores = 0;
                
                int processError = 0;
                double SCORE1 = processScore(score1);
                if(SCORE1 == -1){
                    SCORE1 = 0;
                    processError = -1;
                } else if(SCORE1 != 0){                   
                        numOfScores++;                   
                }
                
                double SCORE2 = processScore(score2);
                if(SCORE2 == -1){
                    SCORE2 = 0;
                    processError = -1;
                } else if(SCORE2 != 0){                   
                        numOfScores++;                   
                }
                
                double SCORE3 = processScore(score3);
                if(SCORE3 == -1){
                    SCORE3 = 0;
                    processError = -1;
                } else if(SCORE3 != 0){                   
                        numOfScores++;                   
                }
                
                double SCORE4 = processScore(score4);
                if(SCORE4 == -1){
                    SCORE4 = 0;
                    processError = -1;
                } else if(SCORE4 != 0){                   
                        numOfScores++;                   
                }

                double finalValue = ((SCORE1 + SCORE2 + SCORE3 + SCORE4) / numOfScores) / 100;
                
                // https://www.javatpoint.com/java-int-to-string learned how to convert an int to a string
                
                if(processError != -1 && numOfScores != 0){
                    finalScore.setText("My final GPA should be ((" + SCORE1 + "+" + SCORE2 + "+" + SCORE3 + "+" + SCORE4 + ")/" + numOfScores + ")/100 = " + convertScoreToLetterGrade(finalValue));
                } else if(numOfScores == 0){
                    Alert alert = new Alert(AlertType.ERROR, "Please enter only valid scores, only numbers 0-100 are accepted");
                    alert.show();
                } else{
                    Alert alert = new Alert(AlertType.ERROR, "Please enter only valid scores, only numbers 0-100 are accepted");
                    alert.show();
                }
            }       
        });
        
        emulateGPA.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                // https://o7planning.org/en/11537/javafx-textinputdialog-tutorial how to make a text input dialogue
                TextInputDialog dialog = new TextInputDialog("");
 
                dialog.setTitle("GPA");
                dialog.setHeaderText("Calculate Desired GPA");
                dialog.setContentText("Please enter your desired GPA (0-4):");
                dialog.showAndWait();
                String desiredGPA = dialog.getResult();
                // System.out.println(desiredGPA);
                 
                //https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html how to throw an error
                try{
                    double doubleDesiredGPA = Double.parseDouble(desiredGPA);
                    if(doubleDesiredGPA != 0 && doubleDesiredGPA != 1 && doubleDesiredGPA != 2 && doubleDesiredGPA != 3 && doubleDesiredGPA != 4){
                        score1.setText("");
                        score2.setText("");
                        score3.setText("");
                        score4.setText("");                        
                        throw new NumberFormatException();
                    }
                    setScoresFromEmulateGPA(doubleDesiredGPA, score1, score2, score3, score4, finalScore);
                    finalScore.setText("");
                } catch(NumberFormatException numberFormatError){
                    Alert alert = new Alert(AlertType.ERROR, "Please enter a valid number from 0-4");
                    alert.show();
                } catch(NullPointerException nullPointerException){} // do nothing on "cancel"
                
                // ******** 
                // I chose to implement this to not put any output into the finalScore text area, 
                // because functionality already existed in calculate GPA, but if I wanted to I would set 
                // the text content of the finalScore in the switch statement in "setScoresFromEmulateGPA()" 
                // ******** 
                
                // https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html#empty-- used this for context but didnt actually use code                            
            }
        });
        
        clearAll.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                score1.setText("");
                score2.setText("");
                score3.setText("");
                score4.setText("");
                finalScore.setText("");
            }
        });
        
        alert.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {            
                
                
                // https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java how to compare strings
                // doesnt pop up if no relevent content to show
                if(finalScore.getText() != null && !(finalScore.getText().isEmpty())){
                    Alert alert = new Alert(AlertType.INFORMATION, finalScore.getText());
                    alert.show();
                } else {
                    Alert alert = new Alert(AlertType.ERROR, "You have not calculated any data");
                    alert.show();
                }
                
            }
        });
        
        root.setPadding(new Insets(10,0,10,0));
        Scene scene = new Scene(root, width, height);
        
        primaryStage.setScene(scene);
        primaryStage.show();       
    }
    
    
    // custom methods below
    
    // https://www.tutorialspoint.com/how-to-check-that-a-string-is-parse-able-to-a-double-in-java how to use try catch
    public double processScore(TextField score){
        if(score.getText() != null && !(score.getText().isEmpty())){
            try{
                double numScore = Double.parseDouble(score.getText()); 
                if(numScore > 100 || numScore < 0){
                    throw new NumberFormatException();
                }
                return numScore;
            }catch(NumberFormatException ex){                 
                // System.out.printf("Error: please enter a valid number for all Courses\n");
                return -1;
            }
        }
        return 0;
    }
    
    // I left this open ended to any numbers above 100 and below 0 
    // just for versatility and the fact that not all grades are confined 
    // to the 0 - 100 scale, but if I were to implement it to bound the 
    // grade on that scale, I would assign all values over 100 to 100, and 
    // all values below 0 to 0
    public String convertScoreToLetterGrade(double score){
        if(score <= 100 && score >= 0.98){
            return "A+";
        }else if(score < 0.98 && score >= 0.93){
            return "A";
        }else if(score < 0.93 && score >= 0.90){
            return "A-";
        }else if(score < 0.90 && score >= 0.88){
            return "B+";
        }else if(score < 0.88 && score >= 0.83){
            return "B";
        }else if(score < 0.83 && score >= 0.80){
            return "B-";
        }else if(score < 0.80 && score >= 0.78){
            return "C+";
        }else if(score < 0.78 && score >= 0.73){
            return "C";
        }else if(score < 0.73 && score >= 0.70){
            return "C-";
        }else if(score < 0.70 && score >= 0.68){
            return "D+";
        }else if(score < 0.68 && score >= 0.63){
            return "D";
        }else if(score < 0.63 && score >= 0.60){
            return "D-";
        } else if(score <.60 && score >= 0){
            return "F";
        }
        return "F"; // processScore() handles scores out of Range
    }
    
    public void setScoresFromEmulateGPA(double desiredGPA, TextField score1, TextField score2, TextField score3, TextField score4, TextArea finalScore){
        switch ((int)(desiredGPA)) {
            case 0:
                score1.setText("0");
                score2.setText("0");
                score3.setText("0");
                score4.setText("0");               
                break;
            case 1:
                score1.setText("63");
                score2.setText("63");
                score3.setText("63");
                score4.setText("63");
                break;
            case 2:
                score1.setText("73");
                score2.setText("73");
                score3.setText("73");
                score4.setText("73");
                break;
            case 3:
                score1.setText("83");
                score2.setText("83");
                score3.setText("83");
                score4.setText("83");
                break;
            case 4:
                score1.setText("100");
                score2.setText("100");
                score3.setText("100");
                score4.setText("100");
                break;
            default:
                break;
        }
    }
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
