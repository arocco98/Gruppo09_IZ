package progettose_gruppo09;

import command.DeleteFunctionCommand;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * AvailableFunctions Controller class
 *
 * @author gruppo09
 */
public class AvailableFunctionsController implements Initializable {

    // Holds this controller's Stage
    private Stage thisStage;

    // Will hold a reference to the first controller, allowing us to access the methods found there.
    private FXMLDocumentController controller;

    private ObservableList<Function> functions;

    @FXML
    private TableView<Function> functionsTable;
    @FXML
    private TableColumn<Function, String> nameClm;
    @FXML
    private TableColumn<Function, String> sequenceClm;
    @FXML
    private Button modifyButton;
    @FXML
    private Button deleteButton;

    /**
     * Construct a new AvailableFunctionsController object
     *
     * @param controller The calling controller
     */
    public AvailableFunctionsController(FXMLDocumentController controller) {
        this.controller = controller;

        // Create the new stage
        thisStage = new Stage();

        // Load the FXML file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AvailableFunctions.fxml"));

            // Set this class as the controller
            loader.setController(this);

            // Load the scene
            thisStage.setScene(new Scene(loader.load()));

            // Setup the window/stage
            thisStage.setTitle("Available User Defined Functions");

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

        this.functions = FXCollections.observableArrayList();

        this.functions.addAll(controller.getFunctions());

        nameClm.setCellValueFactory(new PropertyValueFactory<>("name"));
        sequenceClm.setCellValueFactory(new PropertyValueFactory<>("sequenceString"));

        //setting the items of the table with the current list of functions
        functionsTable.setItems(functions);
        functionsTable.setPlaceholder(new Label("No functions available"));

        //disabling modifyButton and deleteButton when no function is selected
        modifyButton.disableProperty().bind(functionsTable.getSelectionModel().selectedItemProperty().isNull());
        deleteButton.disableProperty().bind(functionsTable.getSelectionModel().selectedItemProperty().isNull());
    }

    /**
     * Refreshes the user-defined functions into the current list
     */
    private void refreshFunctions() {
        functions.clear();
        functions.addAll(controller.getFunctions());

    }

    /**
     * Opens a new window in which modify the sequenceString of the selected
     * function
     *
     * @param event Button "Modify" clicked
     */
    @FXML
    private void modifyFunction(ActionEvent event) {
        Function fc = functionsTable.getSelectionModel().getSelectedItem();
        ModifyFunctionController modifyFunctionController = new ModifyFunctionController(this, fc);

        modifyFunctionController.showStage();
        refreshFunctions();
    }

    /**
     * Deletes the selected function
     *
     * @param event Button "Delete" clicked
     */
    @FXML
    private void deleteFunction(ActionEvent event) {

        //takes the selected function to be deleted
        Function selectedFunction = functionsTable.getSelectionModel().getSelectedItem();

        ArrayList<Function> arrFunctions = controller.getFunctions();
        DeleteFunctionCommand deleteFunctionCommand = new DeleteFunctionCommand(selectedFunction, arrFunctions);

        try {
            //instantiating an Alert popup to confirm the deletion
            Alert dialog = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this function?", ButtonType.YES, ButtonType.CANCEL);
            //showing the Alert popup
            dialog.showAndWait();

            if (dialog.getResult() == ButtonType.YES) {
                //deleting the function after the user's confirmation
                deleteFunctionCommand.execute();
            }
        } catch (Exception ex) {
        }

        refreshFunctions();
    }
}
