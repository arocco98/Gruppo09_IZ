package progettose_gruppo09;

import command.*;
import exceptions.StackSizeException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ObservableList<Complex> observableStack = null;

    // Command variables
    private SumCommand sumCommand = null;
    private SubCommand subCommand = null;
    private ProdCommand prodCommand = null;
    private DivCommand divCommand = null;
    private InversionSignCommand inversionSignCommand = null;
    private ClearCommand clearCommand = null;
    private DropCommand dropCommand = null;
    private DupCommand dupCommand = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // initializing stack and elementList variables
        stack = new Stack();
        observableStack = FXCollections.observableList(stack);
        elementList.setItems(observableStack);

        // initializing all commands
        sumCommand = new SumCommand(this.stack);
        subCommand = new SubCommand(this.stack);
        prodCommand = new ProdCommand(this.stack);
        divCommand = new DivCommand(this.stack);
        inversionSignCommand =new InversionSignCommand(this.stack);
        clearCommand = new ClearCommand(this.stack);
        dropCommand = new DropCommand(this.stack);
        dupCommand = new DupCommand(this.stack);
    }

    /**
     * Creates and returns a Pattern object by using the string passed as
     * argument.
     *
     * @param stringPattern The string that contains the pattern.
     * @return A Pattern object created by using the string passed as argument.
     */
    private Pattern createPattern(String stringPattern) {
        return Pattern.compile(stringPattern);
    }

    /**
     * Creates and returns a Matcher object using the Pattern object passed as
     * argument.
     *
     * @param pattern The pattern with which to create the matcher.
     * @return A Matcher object created by using the "matcher" method of Pattern
     * and by passing the text contained in the text field (spaces excluded).
     */
    private Matcher createMatcher(Pattern pattern) {
        return pattern.matcher(elementTextField.getText().replaceAll("\\s+", ""));
    }

    /**
     * Clears the text field and sets the error label to an empty string.
     */
    private void clearTextField() {
        elementTextField.clear();
        errorLabel.textProperty().set("");
    }

    /**
     * Shows in the GUI the string passed as argument and cleans the text field.
     *
     * @param errorString The string passed as argument.
     */
    private void showError(String errorString) {
        elementTextField.clear();
        errorLabel.textProperty().set(errorString);
    }

    /**
     * Sets elementList's items to a new observablArrayList obtained by
     * reverting the stack elements.
     */
    private void refresh() {
        ArrayList<Complex> tmpStack = new ArrayList<>(stack);
        Collections.reverse(tmpStack);
        elementList.setItems(FXCollections.observableArrayList(tmpStack));
    }

    /**
     * Checks if the user input is valid, then inserts the element into the
     * stack.
     *
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
                    clearTextField();

                    // pushing the just created element into the stack
                    stack.push(c);
                } else if (matcherIR.matches()) { // if the user input matches the second pattern
                    real = Double.parseDouble(matcherIR.group(3)); // extract the real part
                    imaginary = Double.parseDouble(matcherIR.group(1)); // extract the imaginary part

                    Complex c = new Complex(real, imaginary);

                    // clearing textField and setting to empty string the errorLabel
                    clearTextField();

                    // pushing the just created element into the stack
                    stack.push(c);
                } else if (matcherR.matches()) { // if the user input matches the third pattern
                    real = Double.parseDouble(matcherR.group(1)); // extract the real part

                    Complex c = new Complex(real, 0.0);

                    // clearing textField and setting to empty string the errorLabel
                    clearTextField();

                    // pushing the just created element into the stack
                    stack.push(c);
                } else if (matcherI.matches()) { // if the user input matches the fourth pattern
                    imaginary = Double.parseDouble(matcherI.group(1)); // extract the imaginary part

                    Complex c = new Complex(0.0, imaginary);

                    // clearing textField and setting to empty string the errorLabel
                    clearTextField();

                    // pushing the just created element into the stack
                    stack.push(c);
                } else {
                    showError("Use the notation: a+bj");

                }
            } catch (NumberFormatException e) {
                showError("Use the notation: a+bj");
            }
            // refreshing the listView
            refresh();
        } else {
            showError("Text field must not be empty");
        }
    }

    /**
     * Execute the sum of the last two complex numbers in the stack when button
     * "+" is clicked
     *
     * @param event button '+' clicked
     */
    @FXML
    private void sum(ActionEvent event) {
        try {
            sumCommand.execute();
        } catch (StackSizeException ex) {
            showError("Cannot perform sum with only one element");
        }
        // refreshing the listView
        refresh();
    }

    /**
     * Execute the subtraction of the last two complex numbers in the stack when
     * button "-" is clicked
     *
     * @param event button '-' clicked
     */
    @FXML
    private void subtraction(ActionEvent event) {
        try {
            subCommand.execute();
        } catch (StackSizeException ex) {
            showError("Cannot perform subtraction with only one element");
        }
        // refreshing the listView
        refresh();
    }

    /**
     * Execute the product of the last two complex numbers in the stack when
     * button "*" is clicked
     *
     * @param event button '*' clicked
     */
    @FXML
    private void product(ActionEvent event) {
        try {
            prodCommand.execute();
        } catch (StackSizeException ex) {
            showError("Cannot perform product with only one element");
        }
        // refreshing the listView
        refresh();
    }

    /**
     * Execute the division of the last two complex numbers in the stack when
     * button "/" is clicked
     *
     * @param event button '/' clicked
     */
    @FXML
    private void division(ActionEvent event) {
        try {
            divCommand.execute();
        } catch (StackSizeException ex) {
            showError("Cannot perform division with only one element");
        }
        // refreshing the listView
        refresh();
    }

    @FXML
    private void squareRoot(ActionEvent event) {
    }

    @FXML
    private void inversionSign(ActionEvent event) {
        try {
            inversionSignCommand.execute();
        } catch (StackSizeException ex) {
            showError("Cannot perform inversion sign with empty stack");
        }
        // refreshing the listView
        refresh();
    }

    /**
     * Execute the clear of the stack when button "Clear" is clicked
     *
     * @param event button 'Clear' clicked
     */
    @FXML
    private void clear(ActionEvent event) {
        try {
            clearCommand.execute();
        } catch (Exception ex) {}
        // refreshing the listView
        refresh();
    }
    
    /**
     * Execute the removal of the last element of the stack, if non-empty
     * @param event button "Drop" clicked
     */
    @FXML
    private void drop(ActionEvent event) {
        try {
            dropCommand.execute();
        } catch(StackSizeException ex) {
            showError("To perform drop, stack must be non-empty");
        }
        // refreshing the listView
        refresh();
    }

    /**
     * Execute the push of a copy of the last element onto the stack when button
     * "Dup" is clicked
     *
     * @param event button 'Dup' clicked
     */
    @FXML
    private void dup(ActionEvent event) {
        try {
            dupCommand.execute();
        } catch (Exception ex) {
            showError("To perform dup, stack must be non-empty");
        }
        // refreshing the listView
        refresh();
    }

    @FXML
    private void swap(ActionEvent event) {
    }

    @FXML
    private void over(ActionEvent event) {
    }

}
