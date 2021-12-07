package progettose_gruppo09;

import command.FunctionCommand;
import command.InsertFunctionCommand;
import exceptions.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gruppo09
 */
public class AddFunctionController implements Initializable {

    // Holds this controller's Stage
    private Stage thisStage;

    // Will hold a reference to the first controller, allowing us to access the methods found there.
    private FXMLDocumentController controller;
    private ArrayList<FunctionCommand> functionCommands;
    private Stack stack;
    private Variables variables;

    @FXML
    private TextField nameTxt;
    @FXML
    private TextField sequenceTxt;
    @FXML
    private Label errorLbl;

    public AddFunctionController(FXMLDocumentController controller) {
        this.controller = controller;

        // Create the new stage
        thisStage = new Stage();

        // Load the FXML file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddFunction.fxml"));

            // Set this class as the controller
            loader.setController(this);

            // Load the scene
            thisStage.setScene(new Scene(loader.load()));

            // Setup the window/stage
            thisStage.setTitle("Add A New Function");

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Show the stage that was loaded in the constructor
     */
    public void showStage() {
        thisStage.showAndWait();
    }
    
    /**
     * Shows in the GUI the string passed as argument.
     *
     * @param errorString The string passed as argument.
     */
    private void showError(String errorString) {
        
        errorLbl.textProperty().set(errorString);
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.functionCommands = controller.getFunctionCommands();
        this.stack = controller.getStack();
        this.variables = controller.getVariables();

    }

    @FXML
    private void addFunction(ActionEvent event) {

        String name = nameTxt.getText();
        String sequence = sequenceTxt.getText();
        InsertFunctionCommand insertFunctionCommand = new InsertFunctionCommand(name, sequence, functionCommands, stack, variables);
        try {
            insertFunctionCommand.execute();
            this.thisStage.close();
        } catch (NoMatchFoundException ex) {
            showError("Not a valid input");
        } catch (FunctionNameAlreadyExistsException ex) {
            showError("Function name already exists, use a different name");
        }
        
    }

}
