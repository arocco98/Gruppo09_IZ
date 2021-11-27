/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package progettose_gruppo09;

import command.*;
import exceptions.StackSizeException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    @FXML
    private Label errorLabel;

    // elements stack
    private Stack stack = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stack = new Stack();
    }

    /**
     * Creates and returns a Pattern object by using the string passed as argument.
     * @param stringPattern The string that contains the pattern.
     * @return A Pattern object created by using the string passed as argument.
     */
    private Pattern createPattern(String stringPattern) {
        return Pattern.compile(stringPattern);
    }
    
    /**
     * Creates and returns a Matcher object using the Pattern object passed as argument.
     * @param pattern The pattern with which to create the matcher.
     * @return A Matcher object created by using the "matcher" method of Pattern and by passing the text contained in the text field (spaces excluded).
     */
    private Matcher createMatcher(Pattern pattern){
        return pattern.matcher(elementTextField.getText().replaceAll("\\s+", ""));
    }
    
    /**
     * Clears the text field and sets the error label to an empty string.
     */
    private void clear() {
        elementTextField.clear();
        errorLabel.textProperty().set("");
    }
    
    /**
     * Shows in the GUI the string passed as argument and cleans the text field.
     * @param errorString The string passed as argument.
     */
    private void showError(String errorString) {
        elementTextField.clear();
        errorLabel.textProperty().set(errorString);
    }
    
    /**
     * Checks if the user input is valid, then inserts the element into the stack.
     * @param event The event passed as argument.
     */
    @FXML
    private void insert(ActionEvent event) {
        if (elementTextField.textProperty().isNotEmpty().get()) {
            // pattern for real and imaginary part
            Pattern patternRI = createPattern("([+|-]?\\d+(\\.\\d+)?)([+|-]\\d+(\\.\\d+)?)j$");
            // pattern for imaginary and real part
            Pattern patternIR = createPattern("([+|-]?\\d+(\\.\\d+)?)j([+|-]\\d+(\\.\\d+)?)$");
            // pattern for only real part
            Pattern patternR = createPattern("([+|-]?\\d+(\\.\\d+)?)$");
            // pattern for only imaginary part
            Pattern patternI = createPattern("([+|-]?\\d+(\\.\\d+)?)j$");         
            
            // defining real and imaginary variable
            double real = 0.0, imaginary = 0.0;
            
            // matcher for real and imaginary part
            Matcher matcherRI = createMatcher(patternRI);
            // matcher for imaginary and real part
            Matcher matcherIR = createMatcher(patternIR);
            // matcher for only real part
            Matcher matcherR = createMatcher(patternR);
            // matcher for only imaginary part
            Matcher matcherI = createMatcher(patternI);
            
            try {
                if (matcherRI.matches()) { // if the user input matches the first pattern
                    real = Double.parseDouble(matcherRI.group(1)); // extract the real part
                    imaginary = Double.parseDouble(matcherRI.group(3)); // extract the imaginary part
                    
                    Complex c = new Complex(real, imaginary);
                    
                    // clearing textField and setting to empty string the errorLabel
                    clear();
                    
                    // pushing the just created element into the stack
                    stack.push(c);
                } else if (matcherIR.matches()) { // if the user input matches the second pattern
                    real = Double.parseDouble(matcherIR.group(3)); // extract the real part
                    imaginary = Double.parseDouble(matcherIR.group(1)); // extract the imaginary part
                    
                    Complex c = new Complex(real, imaginary);
                    
                    // clearing textField and setting to empty string the errorLabel
                    clear();
                    
                    // pushing the just created element into the stack
                    stack.push(c);
                } else if (matcherR.matches()) { // if the user input matches the third pattern
                    real = Double.parseDouble(matcherR.group(1)); // extract the real part
                    
                    Complex c = new Complex(real, 0.0);
                    
                    // clearing textField and setting to empty string the errorLabel
                    clear();
                    
                    // pushing the just created element into the stack
                    stack.push(c);
                } else if (matcherI.matches()) { // if the user input matches the fourth pattern
                    imaginary = Double.parseDouble(matcherI.group(1)); // extract the imaginary part
                    
                    Complex c = new Complex(0.0, imaginary);
                    
                    // clearing textField and setting to empty string the errorLabel
                    clear();
                    
                    // pushing the just created element into the stack
                    stack.push(c);
                } else {
                    showError("Use the notation: a+bj");
                    
                }
            } catch (NumberFormatException e) {
                showError("Use the notation: a+bj");
            }
        } else {
            showError("Text field must not be empty");
        }
    }
    
    @FXML
    private void sum(ActionEvent event) throws StackSizeException {
        SumCommand sc = new SumCommand(this.stack);
        sc.execute();
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
