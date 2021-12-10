package progettose_gruppo09;

import command.FunctionCommand;
import exceptions.NoMatchFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author memol
 */
public class ModifyFunctionController implements Initializable {

    // Holds this controller's Stage
    private Stage thisStage;

    // Will hold a reference to the first controller, allowing us to access the methods found there.
    private AvailableFunctionsController controller;
    private Function f;
    
    @FXML
    private Label errorLbl;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField sequenceTxt;
    
        
    public ModifyFunctionController(AvailableFunctionsController controller, Function f) {
        this.controller = controller;
        this.f = f;

        // Create the new stage
        thisStage = new Stage();

        // Load the FXML file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyFunction.fxml"));

            // Set this class as the controller
            loader.setController(this);

            // Load the scene
            thisStage.setScene(new Scene(loader.load()));

            // Setup the window/stage
            thisStage.setTitle("Modify The Selected Function");

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Show the stage that was loaded in the constructor
     */
    public void showStage() {
        thisStage.initModality(Modality.APPLICATION_MODAL);
        thisStage.setResizable(false);
        thisStage.showAndWait();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.nameTxt.setText(this.f.getName());  
        this.sequenceTxt.setText(this.f.getSequenceString()); 
        
    }    

    /**
     * Shows in the GUI the string passed as argument and cleans the text field.
     *
     * @param errorString The string passed as argument.
     */
    private void showError(String errorString) {
        errorLbl.textProperty().set(errorString);
    }
    
    @FXML
    private void cancelFunction(ActionEvent event) {
        
        this.thisStage.close();
        
    }

    @FXML
    private void modifyFunction(ActionEvent event) {
        
        try {
            errorLbl.setText("");
            f.setSequenceString(this.sequenceTxt.getText());
            this.thisStage.close();
        } catch (NoMatchFoundException ex) {
            showError("Not a valid input");
        }

    }
    
}
