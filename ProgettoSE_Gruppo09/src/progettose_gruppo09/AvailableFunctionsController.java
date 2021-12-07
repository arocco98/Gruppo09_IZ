package progettose_gruppo09;

import command.FunctionCommand;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gruppo09
 */
public class AvailableFunctionsController implements Initializable {

    // Holds this controller's Stage
    private Stage thisStage;

    // Will hold a reference to the first controller, allowing us to access the methods found there.
    private FXMLDocumentController controller;

    private ObservableList<FunctionCommand> functionCommands;

    @FXML
    private TableView<FunctionCommand> functionsTable;
    @FXML
    private TableColumn<FunctionCommand, String> nameClm;
    @FXML
    private TableColumn<FunctionCommand, String> sequenceClm;
    @FXML
    private Button modifyButton;
    @FXML
    private Button deleteButton;

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
        thisStage.showAndWait();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.functionCommands = FXCollections.observableArrayList();

        this.functionCommands.addAll(controller.getFunctionCommands());

        nameClm.setCellValueFactory(new PropertyValueFactory<FunctionCommand, String>("name"));
        sequenceClm.setCellValueFactory(new PropertyValueFactory<FunctionCommand, String>("sequenceString"));

        functionsTable.setItems(functionCommands);
        functionsTable.setPlaceholder(new Label("No functions available"));

        modifyButton.disableProperty().bind(functionsTable.getSelectionModel().selectedItemProperty().isNull());
        deleteButton.disableProperty().bind(functionsTable.getSelectionModel().selectedItemProperty().isNull());
    }

    @FXML
    private void modifyFunction(ActionEvent event) {
    }

    @FXML
    private void deleteFunction(ActionEvent event) {
    }

}
