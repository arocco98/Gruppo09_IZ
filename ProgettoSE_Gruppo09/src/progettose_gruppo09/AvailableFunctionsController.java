package progettose_gruppo09;

import command.Command;
import command.FunctionCommand;
import exceptions.FunctionNameAlreadyExistsException;
import exceptions.NoMatchFoundException;
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
import javafx.stage.Modality;
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

        functionsTable.setItems(functions);
        functionsTable.setPlaceholder(new Label("No functions available"));

        modifyButton.disableProperty().bind(functionsTable.getSelectionModel().selectedItemProperty().isNull());
        deleteButton.disableProperty().bind(functionsTable.getSelectionModel().selectedItemProperty().isNull());
    }

    private void refreshFunctions() {
        functions.clear();
        functions.addAll(controller.getFunctions());

    }
    
    @FXML
    private void modifyFunction(ActionEvent event) {
        Function fc = functionsTable.getSelectionModel().getSelectedItem();
        ModifyFunctionController modifyFunctionController = new ModifyFunctionController(this, fc);

        modifyFunctionController.showStage();
        refreshFunctions();
    }

    @FXML
    private void deleteFunction(ActionEvent event) {
        Function selectedFunction = functionsTable.getSelectionModel().getSelectedItem();
        ArrayList<Command> arr = selectedFunction.getSequenceCommands();
        String[] splitter;

        for (Function function : controller.getFunctions()) {
            if (function.getSequenceCommands().contains(new FunctionCommand(selectedFunction))) {
                splitter = function.getSequenceString().split("\\s");
                for (int i = 0; i < splitter.length; i++) {
                    if (selectedFunction.getName().compareTo(splitter[i]) == 0) {
                        splitter[i] = selectedFunction.getSequenceString();
                    }
                }
                try {
                    function.setSequenceString(String.join(" ", splitter));
                } catch (NoMatchFoundException ex) {
                }
            }
        }
        controller.getFunctions().remove(selectedFunction);
        functions.clear();
        functions.addAll(controller.getFunctions());

    }
}
