package progettose_gruppo09;

import command.FunctionCommand;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author memol
 */

public class UserDefinedFunctionsController implements Initializable {

    private ObservableList<FunctionCommand> functions;
    @FXML
    private TableView<FunctionCommand> functionsTable;
    @FXML
    private TableColumn<FunctionCommand, String> functionsClm;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //functions = FXMLDocumentController.readFunctions();
        functions = FXCollections.observableArrayList();
        
        functionsTable.setItems(functions);
        //readFunctions();
    }    

    @FXML
    private void addFunction(ActionEvent event) {
    }

    @FXML
    private void modifyFunction(ActionEvent event) {
    }

    @FXML
    private void deleteFunction(ActionEvent event) {
        FunctionCommand fc = functionsTable.getSelectionModel().getSelectedItem();
        functions.remove(fc);
    }

    private void readFunctions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
