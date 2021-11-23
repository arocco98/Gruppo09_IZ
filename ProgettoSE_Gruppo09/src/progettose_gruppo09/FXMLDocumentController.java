/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package progettose_gruppo09;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author gruppo09
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ListView<Complex> elementList;
    @FXML
    private TextField elementTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void insert(ActionEvent event) {
        System.out.println("Hello World!");
    }

    @FXML
    private void sum(ActionEvent event) {
    }

    @FXML
    private void subtraction(ActionEvent event) {
    }

    @FXML
    private void product(ActionEvent event) {
    }

    @FXML
    private void division(ActionEvent event) {
    }

    @FXML
    private void squareRoot(ActionEvent event) {
    }

    @FXML
    private void inversionSign(ActionEvent event) {
    }
    
}
