/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author adammenker
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextArea textArea;
    @FXML
    private VBox root;
    FileChooser fileChooser;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleOpen(ActionEvent event) {
        fileChooser = new FileChooser();
        
        Stage stage = (Stage)root.getScene().getWindow();
        
        fileChooser.showOpenDialog(stage);
    }
    
    @FXML
    private void handleSave(ActionEvent event) {
        
    }
}
