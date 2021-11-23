/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package progettose_gruppo09;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        if(elementTextField.textProperty().isNotEmpty().get()) {
            
            // pattern for real and imaginary part
            Pattern p1 = Pattern.compile("(.*)([+-].*)j");
            // pattern for only real part
            Pattern p2 = Pattern.compile("(.*)[^j]");
            // pattern for only imaginary part
            Pattern p3 = Pattern.compile("(.*)j");
            
            double real = 0.0, imaginary = 0.0;
            
            // matcher for real and imaginary part
            Matcher m1 = p1.matcher(elementTextField.getText().replaceAll("\\s+",""));
            // matcher for only real part
            Matcher m2 = p2.matcher(elementTextField.getText().replaceAll("\\s+",""));
            // matcher for only imaginary part
            Matcher m3 = p3.matcher(elementTextField.getText().replaceAll("\\s+",""));
            try {
                if (m1.matches()) { // if the user input matches the required pattern
                real = Double.parseDouble(m1.group(1)); // extract the real part
                imaginary = Double.parseDouble(m1.group(2)); // extract the imaginary part
                Complex c = new Complex(real, imaginary);
                elementTextField.clear();
                System.out.println(c);
                }
                else if(m2.matches()) {
                    real = Double.parseDouble(m2.group(1)); // extract the real part
                    Complex c = new Complex(real, imaginary);
                    System.out.println(c);
                }
                else if(m3.matches()) {
                    imaginary = Double.parseDouble(m3.group(1)); // extract the imaginary part
                    Complex c = new Complex(real, imaginary);
                    System.out.println(c);
                }
            } catch(Exception e) {
                elementTextField.setText("Use the notation: a + bj");
            }
            
        }
        else {
            elementTextField.setText("Invalid input!");
        }
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
