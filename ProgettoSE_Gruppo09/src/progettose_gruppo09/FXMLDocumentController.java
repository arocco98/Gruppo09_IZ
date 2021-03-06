package progettose_gruppo09;

import command.*;
import exceptions.FunctionNameAlreadyExistsException;
import exceptions.NoMatchFoundException;
import exceptions.OperationDenied;
import exceptions.StackSizeException;
import exceptions.VariablesNameException;
import exceptions.VariablesValueException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

/**
 *
 * @author gruppo09
 */
public class FXMLDocumentController implements Initializable {

    /**
     * This inner class has been created in order to change the classic Entry
     * toString.
     *
     * @param <Character> The key of MyEntry.
     * @param <Complex> The value of MyEntry.
     */
    private class MyEntry<Character, Complex> implements Map.Entry<Character, Complex>, Comparable<Character> {

        private Character key;
        private Complex value;

        /**
         * Constructor of MyEntry class
         */
        public MyEntry() {
            this.key = null;
            this.value = null;
        }

        /**
         * Constructor of MyEntry class
         */
        public MyEntry(Character character, Complex complex) {
            this.key = character;
            this.value = complex;
        }

        /**
         * Returns a set of MyEntry created using the set of entry passed as
         * argument.
         *
         * @param entrySet The entry set.
         * @return A set of MyEntry objects containing the same element as
         * entrySet.
         */
        public Set<MyEntry<Character, Complex>> fromEntrySet(Set<Entry<Character, Complex>> entrySet) {
            Set<MyEntry<Character, Complex>> set = new TreeSet<>();
            for (Entry<Character, Complex> entry : entrySet) {
                set.add(new MyEntry<>(entry.getKey(), entry.getValue()));
            }
            return set;
        }

        /**
         * Getter of the key attribute.
         *
         * @return The key of MyEntry object.
         */
        @Override
        public Character getKey() {
            return this.key;
        }

        /**
         * Getter of the value attribute.
         *
         * @return The value of MyEntry object.
         */
        @Override
        public Complex getValue() {
            return this.value;
        }

        /**
         * Setter of Value attribute.
         *
         * @param value The new value of value attribute.
         * @return The new value inserted.
         */
        @Override
        public Complex setValue(Complex value) {
            this.value = value;
            return this.getValue();
        }

        /**
         * String representation of the object.
         *
         * @return A string representation of the object.
         */
        @Override
        public String toString() {
            if (this.getValue() == null) {
                return this.getKey() + ":\t...";
            }
            return this.getKey() + ":\t" + this.getValue();
        }

        /**
         * Compare the object to the one passed as parameter.
         *
         * @param o The object to compare.
         * @return 0, if the key are equals; a value greater than 0 if the
         * object key is alphabetically greater than the object key; otherwise a
         * value less than 0.
         */
        @Override
        public int compareTo(Character o) {
            return this.key.toString().compareTo(o.toString());
        }

    }

    @FXML
    private TableView<Complex> elementList;
    @FXML
    private TableColumn<Complex, Complex> stackColumn;
    @FXML
    private TextField elementTextField;
    @FXML
    private Label errorLabel;
    @FXML
    private ComboBox<Entry<Character, Complex>> variablesComboBox;
    @FXML
    private ComboBox<Function> functionsComboBox;
    @FXML
    private Button sumButton;
    @FXML
    private Button subtractionButton;
    @FXML
    private Button productButton;
    @FXML
    private Button divisionButton;
    @FXML
    private Button squareRootButton;
    @FXML
    private Button inversionSignButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button dropButton;
    @FXML
    private Button dupButton;
    @FXML
    private Button swapButton;
    @FXML
    private Button overButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button restoreButton;
    @FXML
    private Button modulusButton;
    @FXML
    private Button argumentButton;
    @FXML
    private Button powerButton;
    @FXML
    private Button exponentialButton;
    @FXML
    private Button logButton;
    @FXML
    private Button sineButton;
    @FXML
    private Button cosineButton;
    @FXML
    private Button tangentButton;
    @FXML
    private Button arcsineButton;
    @FXML
    private Button arccosineButton;
    @FXML
    private Button arctangentButton;
    @FXML
    private Button inVarBtn;
    @FXML
    private Button outVarBtn;
    @FXML
    private Button sumVarBtn;
    @FXML
    private Button subVarBtn;
    @FXML
    private Button executeFunctionButton;

    // elements stack
    private ComplexStack stack = null;
    private ObservableList<Complex> observableStack = null;
    private ObservableList<Entry<Character, Complex>> observableCharacterList = null;

    // Command variables
    private SumCommand sumCommand = null;
    private SubCommand subCommand = null;
    private ProdCommand prodCommand = null;
    private DivCommand divCommand = null;
    private SqrtCommand sqrtCommand = null;
    private InversionSignCommand inversionSignCommand = null;
    private ClearCommand clearCommand = null;
    private DropCommand dropCommand = null;
    private DupCommand dupCommand = null;
    private SwapCommand swapCommand = null;
    private OverCommand overCommand = null;
    private ModCommand modCommand = null;
    private ArgCommand argCommand = null;
    private PowCommand powCommand = null;
    private ExpCommand expCommand = null;
    private LogCommand logCommand = null;
    private SinCommand sinCommand = null;
    private CosCommand cosCommand = null;
    private TanCommand tanCommand = null;
    private ArcsinCommand asinCommand = null;
    private ArccosCommand acosCommand = null;
    private ArctanCommand atanCommand = null;

    // variables 
    private Variables variables = new Variables();
    private VariablesStack savedVariables = new VariablesStack();

    // user-defined functions
    private ArrayList<Function> functions = null;
    private ObservableList<Function> observableFunctions = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // setting up buttons tooltip
        setupButtons();

        // initializing stack and elementList variables
        initializeStack();

        // initializing variables 
        initializeVariables();

        // initializing all commands
        initializeCommands();

        // initializing functions array
        initializeFunctions();
    }

    /**
     * Initialize the stack structure and the observable list that will contain
     * all the elements.
     */
    private void initializeStack() {
        stack = new ComplexStack();
        elementList.setPlaceholder(new Label("No value present"));
        stackColumn.setCellValueFactory(new PropertyValueFactory<>("complex"));
        stackColumn.setSortable(false);
        observableStack = FXCollections.observableList(stack);
        elementList.setItems(observableStack);
    }

    /**
     * Sets up all the tooltip of all the buttons
     */
    private void setupButtons() {
        sumButton.setTooltip(new Tooltip("Sum the first two elements of the stack"));
        subtractionButton.setTooltip(new Tooltip("Subtract the first element in the stack from the second one"));
        productButton.setTooltip(new Tooltip("Multiply the firts two elements of the stack"));
        divisionButton.setTooltip(new Tooltip("Divide the second element in the stack by the first one"));
        squareRootButton.setTooltip(new Tooltip("Perform the square root of the first element of the stack"));
        inversionSignButton.setTooltip(new Tooltip("Perform the inversion of sign of the first element of the stack"));
        modulusButton.setTooltip(new Tooltip("Execute the modulus of the first element of the stack"));
        argumentButton.setTooltip(new Tooltip("Execute the argument of the first element of the stack"));
        powerButton.setTooltip(new Tooltip("Execute the power of the second element of the stack elevated by the first one"));
        exponentialButton.setTooltip(new Tooltip("Elevate the constant 'e' to the power of the first element of the stack"));
        logButton.setTooltip(new Tooltip("Execute the natural logarithm of the first element of the stack"));
        sineButton.setTooltip(new Tooltip("Execute the sine of the first element of the stack"));
        cosineButton.setTooltip(new Tooltip("Execute the cosine of the first element of the stack"));
        tangentButton.setTooltip(new Tooltip("Execute the tangent of the first element of the stack"));
        arcsineButton.setTooltip(new Tooltip("Execute the arc sine of the first element of the stack"));
        arccosineButton.setTooltip(new Tooltip("Execute the arc cosine of the first element of the stack"));
        arctangentButton.setTooltip(new Tooltip("Execute the arc tangent of the first element of the stack"));
        clearButton.setTooltip(new Tooltip("Clear the stack by removing all the elements"));
        dropButton.setTooltip(new Tooltip("Remove the first element of the stack"));
        dupButton.setTooltip(new Tooltip("Duplicate the first element of the stack"));
        swapButton.setTooltip(new Tooltip("Swap the first two elements of the stack"));
        overButton.setTooltip(new Tooltip("Insert in the stack the second elements of the stack"));
        saveButton.setTooltip(new Tooltip("Save a copy of the actual variables"));
        restoreButton.setTooltip(new Tooltip("Restore a copy of the last saved variables"));
        inVarBtn.setTooltip(new Tooltip("Remove the first element of the stack and push it into the selected variable"));
        outVarBtn.setTooltip(new Tooltip("Insert a copy of the element present in the selected variable into the stack"));
        sumVarBtn.setTooltip(new Tooltip("Sum the first element of the stack to the value present in the selected variable"));
        subVarBtn.setTooltip(new Tooltip("Subtract the first element of the stack from the value present in the selected variable"));
    }

    /**
     * Initialize the variables structure and the observable list.
     */
    private void initializeVariables() {

        MyEntry<Character, Complex> myEntry = new MyEntry<>();
        observableCharacterList = FXCollections.observableList(new ArrayList<>(myEntry.fromEntrySet(variables.getVariables().entrySet())));
        observableCharacterList.sort(null);
        variablesComboBox.setItems(observableCharacterList);
        variablesComboBox.getSelectionModel().selectFirst();
        Function.setVariablesStack(savedVariables);
    }

    /**
     * Initialize all the commands.
     */
    private void initializeCommands() {
        sumCommand = new SumCommand(this.stack);
        subCommand = new SubCommand(this.stack);
        prodCommand = new ProdCommand(this.stack);
        divCommand = new DivCommand(this.stack);
        sqrtCommand = new SqrtCommand(this.stack);
        inversionSignCommand = new InversionSignCommand(this.stack);
        clearCommand = new ClearCommand(this.stack);
        dropCommand = new DropCommand(this.stack);
        dupCommand = new DupCommand(this.stack);
        swapCommand = new SwapCommand(this.stack);
        overCommand = new OverCommand(this.stack);
        modCommand = new ModCommand(stack);
        argCommand = new ArgCommand(stack);
        powCommand = new PowCommand(stack);
        expCommand = new ExpCommand(stack);
        logCommand = new LogCommand(stack);
        sinCommand = new SinCommand(stack);
        cosCommand = new CosCommand(stack);
        tanCommand = new TanCommand(stack);
        asinCommand = new ArcsinCommand(stack);
        acosCommand = new ArccosCommand(stack);
        atanCommand = new ArctanCommand(stack);
    }

    /**
     * Initialize functions array and other attributes for the GUI.
     */
    private void initializeFunctions() {
        functions = new ArrayList<>();
        // setting the static attributes of Function class
        Function.setFunctions(functions);
        Function.setStack(stack);
        Function.setVariables(variables);

        observableFunctions = FXCollections.observableArrayList(functions);
        functionsComboBox.setItems(observableFunctions);
        // binding the button to the combobox, if no value is selected then the button must be disabled
        executeFunctionButton.disableProperty().bind(functionsComboBox.valueProperty().isNull());
        // this method is used in order to show to the user the operations of one function when the mouse is over the name of the operation
        functionsComboBox.setCellFactory(param -> {
            return new ListCell<Function>() {

                @Override
                public void updateItem(Function item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item != null) {
                        setText(item.getName());

                        // Add the Tooltip with the image of the current item
                        Tooltip tt = new Tooltip();
                        tt.setText(item.getSequenceString());

                        setTooltip(tt);
                    } else {
                        setText(null);
                        setTooltip(null);
                    }
                }
            };
        });
    }

    /**
     * Getter method of the stack attribute.
     *
     * @return The stack attribute.
     */
    public ComplexStack getStack() {
        return stack;
    }

    /**
     * Getter method of the variables attribute.
     *
     * @return The variables attribute.
     */
    public Variables getVariables() {
        return variables;
    }

    /**
     * Getter method of the functions attribute.
     *
     * @return The functions attribute.
     */
    public ArrayList<Function> getFunctions() {
        return functions;
    }

    /**
     * Setter method of the functions attribute.
     *
     * @param functions The new functions value.
     */
    public void setFunctions(ArrayList<Function> functions) {
        this.functions = functions;
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
    private void refreshStack() {
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
            InsertCommand insertCommand = new InsertCommand(stack, elementTextField.getText());
            try {
                insertCommand.execute();
                refreshStack();
                clearTextField();
            } catch (NoMatchFoundException ex) {
                clearTextField();
                showError("Use the notation a+bj or bj+a");
            }
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
            showError("Cannot perform sum, insufficient number of elements");
        }
        // refreshing the listView
        refreshStack();
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
            showError("Cannot perform subtraction, insufficient number of elements");
        }
        // refreshing the listView
        refreshStack();
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
            showError("Cannot perform product, insufficient number of elements");
        }
        // refreshing the listView
        refreshStack();
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
            showError("Cannot perform division, insufficient number of elements");
        } catch (OperationDenied od) {
            showError("Cannot divide a number by zero");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the square root of the last complex number in the stack when
     * button "sqrt" is clicked
     *
     * @param event button 'sqrt' clicked
     */
    @FXML
    private void squareRoot(ActionEvent event) {
        try {
            sqrtCommand.execute();
        } catch (StackSizeException ex) {
            showError("Cannot perform square root with empty stack");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the inversion sign of the last complex number in the stack when
     * button "+-" is clicked
     *
     * @param event button '+-' clicked
     */
    @FXML
    private void inversionSign(ActionEvent event) {
        try {
            inversionSignCommand.execute();
        } catch (StackSizeException ex) {
            showError("Cannot perform inversion sign with empty stack");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the modulus of the last complex number in the stack when "mod" is
     * clicked.
     *
     * @param event Button 'mod' clicked.
     */
    @FXML
    private void modulus(ActionEvent event) {
        try {
            modCommand.execute();
        } catch (Exception ex) {
            showError("Cannot perform modulus with empty stack");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the argument of the last complex number in the stack when "mod"
     * is clicked.
     *
     * @param event Button 'arg' clicked.
     */
    @FXML
    private void arg(ActionEvent event) {
        try {
            argCommand.execute();
        } catch (Exception ex) {
            showError("Cannot perform argument with empty stack");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the power of the second complex number in the stack elevated by
     * the first element when "pow" is clicked.
     *
     * @param event Button 'pow' clicked.
     */
    @FXML
    private void power(ActionEvent event) {
        try {
            powCommand.execute();
        } catch (Exception ex) {
            showError("Cannot perform power, insufficient number of elements");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the exponential of the last complex number in the stack when
     * "exp" is clicked.
     *
     * @param event Button 'exp' clicked.
     */
    @FXML
    private void exponential(ActionEvent event) {
        try {
            expCommand.execute();
        } catch (Exception ex) {
            showError("Cannot perform exponential with empty stack");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the natural logarithm of the last complex number in the stack
     * when "log" is clicked.
     *
     * @param event Button 'log' clicked.
     */
    @FXML
    private void naturalLogarithm(ActionEvent event) {
        try {
            logCommand.execute();
        } catch (Exception ex) {
            showError("Cannot perform natural logarithm with empty stack");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the sine of the last complex number in the stack when "sin" is
     * clicked.
     *
     * @param event Button 'sin' clicked.
     */
    @FXML
    private void sine(ActionEvent event) {
        try {
            sinCommand.execute();
        } catch (Exception ex) {
            showError("Cannot perform sine with empty stack");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the cosine of the last complex number in the stack when "cos" is
     * clicked.
     *
     * @param event Button 'cos' clicked.
     */
    @FXML
    private void cosine(ActionEvent event) {
        try {
            cosCommand.execute();
        } catch (Exception ex) {
            showError("Cannot perform cosine with empty stack");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the tangent of the last complex number in the stack when "tan" is
     * clicked.
     *
     * @param event Button 'tan' clicked.
     */
    @FXML
    private void tangent(ActionEvent event) {
        try {
            tanCommand.execute();
        } catch (Exception ex) {
            showError("Cannot perform tangent with empty stack");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the arc sine of the last complex number in the stack when
     * "arcsin" is clicked.
     *
     * @param event Button 'arcsin' clicked.
     */
    @FXML
    private void arcsin(ActionEvent event) {
        try {
            asinCommand.execute();
        } catch (Exception ex) {
            showError("Cannot perform arc sine with empty stack");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the arc cosine of the last complex number in the stack when
     * "arccos" is clicked.
     *
     * @param event Button 'arccos' clicked.
     */
    @FXML
    private void arccos(ActionEvent event) {
        try {
            acosCommand.execute();
        } catch (Exception ex) {
            showError("Cannot perform arc cosine with empty stack");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the arc tangent of the last complex number in the stack when
     * "arctan" is clicked.
     *
     * @param event Button 'arctan' clicked.
     */
    @FXML
    private void arctan(ActionEvent event) {
        try {
            atanCommand.execute();
        } catch (Exception ex) {
            showError("Cannot perform arc tangent with empty stack");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the clear of the stack when button "Clear" is clicked
     *
     * @param event button 'Clear' clicked
     */
    @FXML
    private void clear(ActionEvent event) {
        try {
            Alert dialog = new Alert(AlertType.CONFIRMATION, "Are you sure you want to clear the stack?", ButtonType.YES, ButtonType.CANCEL);
            dialog.setTitle("Confirm");
            dialog.showAndWait();

            if (dialog.getResult() == ButtonType.YES) {
                clearCommand.execute();
            }
        } catch (Exception ex) {
        }

        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the removal of the last element of the stack, if non-empty
     *
     * @param event button "Drop" clicked
     */
    @FXML
    private void drop(ActionEvent event) {
        try {
            dropCommand.execute();
        } catch (StackSizeException ex) {
            showError("To perform drop, stack must be non-empty");
        }
        // refreshing the listView
        refreshStack();
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
        } catch (StackSizeException ex) {
            showError("To perform dup, stack must be non-empty");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the swap of the last two elements in the stack when the button
     * "Swap" is clicked
     *
     * @param event button 'Swap' clicked
     */
    @FXML
    private void swap(ActionEvent event) {
        try {
            swapCommand.execute();
        } catch (StackSizeException ex) {
            showError("To perform swap, stack must have at least two elements");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * Execute the push of a copy of the second last element into the stack when
     * button "Over" is clicked
     *
     * @param event button 'Over' clicked
     */
    @FXML
    private void over(ActionEvent event) {
        try {
            overCommand.execute();
        } catch (Exception ex) {
            showError("To perform over, stack must have at least two elements");
        }
        // refreshing the listView
        refreshStack();
    }

    /**
     * This function update the button's text.
     *
     * @param button The button to change the text to.
     * @param string The string representing the operation of the button.
     */
    private void updateText(Button button, String string) {
        if (variablesComboBox.getValue() != null) {
            button.setText(string + variablesComboBox.getValue().getKey());
        }
    }

    /**
     * This function update in the GUI the combo box showing the latest updates.
     */
    private void refreshVariables() {
        // instantiating a new one observableList in order to insert the new variables changes
        MyEntry<Character, Complex> myEntry = new MyEntry<>();
        observableCharacterList = FXCollections.observableList(new ArrayList<>(myEntry.fromEntrySet(variables.getVariables().entrySet())));
        int index = variablesComboBox.getSelectionModel().getSelectedIndex();

        // setting items to null and then to observableCharacterList in order to refresh the variables list
        variablesComboBox.setItems(null);
        variablesComboBox.setItems(observableCharacterList);

        // setting the selected cell to the previous one selected
        variablesComboBox.getSelectionModel().select(index);
    }

    /**
     * Method of combobox, it is called when the user select a variable. This
     * method update the view of the variables button.
     *
     * @param event When a combo item is selected.
     */
    @FXML
    private void selectedItemChanged(ActionEvent event) {
        updateText(inVarBtn, ">");
        updateText(outVarBtn, "<");
        updateText(sumVarBtn, "+");
        updateText(subVarBtn, "-");
    }

    /**
     * Save the instance of variables in savedStack
     *
     * @param event When button "Save" is clicked
     */
    @FXML
    private void saveVariables(ActionEvent event) {
        SaveVariablesCommand saveVariablesCommand = new SaveVariablesCommand(variables, savedVariables);
        try {
            errorLabel.setText("");
            saveVariablesCommand.execute();
            Alert dialog = new Alert(AlertType.INFORMATION, "Variables saved correctly", ButtonType.OK);
            dialog.setTitle("Information");
            dialog.setHeaderText("Save completed");
            dialog.showAndWait();
        } catch (Exception ex) {
            showError("Error during save the variables");
        }
    }

    /**
     * Restore the variables attribute by getting the last element in savedStack
     *
     * @param event When button "Restore" is clicked
     */
    @FXML
    private void restoreVariables(ActionEvent event) {
        RestoreVariablesCommand restoreVariablesCommand = new RestoreVariablesCommand(variables, savedVariables);
        try {
            errorLabel.setText("");
            restoreVariablesCommand.execute();
            Alert dialog = new Alert(AlertType.INFORMATION, "Variables restored correctly", ButtonType.OK);
            dialog.setTitle("Information");
            dialog.setHeaderText("Restore completed");
            dialog.showAndWait();
        } catch (StackSizeException ex) {
            Alert dialog = new Alert(AlertType.ERROR, "No variables to restore", ButtonType.OK);
            dialog.setTitle("Error");
            dialog.setHeaderText("Error during the restore operation");
            dialog.show();
        } catch (VariablesNameException ex) {
        }

        refreshVariables();
    }

    /**
     * Takes the top of the stack and saves it into a selected variable
     *
     * @param event Button ">x" clicked
     */
    @FXML
    private void saveInVariable(ActionEvent event) {
        Character variable = variablesComboBox.getValue().getKey();
        InVariableCommand inVC = new InVariableCommand(variable, this.stack, this.variables);
        try {
            inVC.execute();
            refreshVariables();
            refreshStack();
            clearTextField();
        } catch (VariablesNameException ex) {
        } catch (StackSizeException ex) {
            showError("To perform >" + variablesComboBox.getValue().getKey() + ", stack must have at least one elements");
        }

    }

    /**
     * Pushes into the stack the value associated with the selected variable
     *
     * @param event Button "<x" clicked
     */
    @FXML
    private void saveInStack(ActionEvent event) {
        Character key = variablesComboBox.getValue().getKey();
        OutVariableCommand ovc = new OutVariableCommand(stack, variables, key);
        try {
            ovc.execute();
            refreshStack();
            clearTextField();
        } catch (VariablesNameException ex) {
        } catch (VariablesValueException ex) {
            showError("No value associated with the variable");
        }
    }

    /**
     * Takes the top of the stack and sums its value with the value associated
     * with the selected variable saving the result into the variable
     *
     * @param event Button "+x" clicked
     */
    @FXML
    private void sumVariable(ActionEvent event) {
        Character key = variablesComboBox.getValue().getKey();
        SumVariableCommand sum_vc = new SumVariableCommand(stack, variables, key);
        try {
            sum_vc.execute();
            refreshVariables();
            refreshStack();
            clearTextField();
        } catch (VariablesValueException ex) {
            showError("No value associated with the variable");
        } catch (VariablesNameException ex) {
            showError("Chosen variable not present");
        } catch (StackSizeException ex) {
            showError("To perform this action, stack must be non-empty");
        }
    }

    /**
     * Takes the top of the stack and subtracts its value from the value
     * associated with the selected variable saving the result into the variable
     *
     * @param event Button "-x" clicked
     */
    @FXML
    private void subVariable(ActionEvent event) {
        Character key = variablesComboBox.getValue().getKey();
        SubVariableCommand sub_vc = new SubVariableCommand(stack, variables, key);
        try {
            sub_vc.execute();
            refreshVariables();
            refreshStack();
            clearTextField();
        } catch (VariablesValueException ex) {
            showError("No value associated with the variable");
        } catch (VariablesNameException ex) {
            showError("Chosen variable not present");
        } catch (StackSizeException ex) {
            showError("To perform this action, stack must be non-empty");
        }
    }

    /**
     * Execute the selected user-defined function. If errors occurs, restore the
     * previous state of stack and variables.
     *
     * @param event Button "Execute" clicked.
     */
    @FXML
    private void executeFunction(ActionEvent event) {
        // creating the new executeFunctionCommand object
        ExecuteFunctionCommand executeFunctionCommand = new ExecuteFunctionCommand(functionsComboBox.getValue(), stack, variables, savedVariables);

        clearTextField();
        try { // try executing all the commands
            executeFunctionCommand.execute();
        } catch (Exception ex) { // if errors occurs, show a new error    
            // showing an error label
            showError("Error during the execution of the function");
        }

        // refresh stack and variables in order to get the update visible in the gui
        refreshStack();
        refreshVariables();
    }

    /**
     * Refresh in the GUI the visualization of the available function commands
     * in the combo box.
     */
    private void refreshFunctionCommands() {
        // clear the selected item in the combo box
        functionsComboBox.getSelectionModel().clearSelection();
        // refresh the observable array list
        observableFunctions.clear();
        observableFunctions.addAll(functions);
        // set the items in the combobox
        functionsComboBox.setItems(observableFunctions);
    }

    /**
     * Opens a window in which it is possible to add a new user-defined
     * operation
     *
     * @param event MenuIem "Add" clicked
     */
    @FXML
    private void addFunction(ActionEvent event) {

        AddFunctionController addFunctionController = new AddFunctionController(this);

        addFunctionController.showStage();
        refreshFunctionCommands();
    }

    /**
     * Opens a window in which it is possible to see the available user-defined
     * operations
     *
     * @param event MenuIem "Available" clicked
     */
    @FXML
    private void availableFunctions(ActionEvent event) {

        AvailableFunctionsController availableFunctionsController = new AvailableFunctionsController(this);

        availableFunctionsController.showStage();

        refreshFunctionCommands();
    }

    /**
     * Opens a window where it is possible to choose a file in which to save the
     * available user-defined operations
     *
     * @param event MenuIem "Save" clicked
     */
    @FXML
    private void saveFunctions(ActionEvent event) {

        SaveFunctionCommands saveCommand = null;
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(this.inVarBtn.getScene().getWindow());
        if (file != null) {
            saveCommand = new SaveFunctionCommands(functions, file);

            try {
                saveCommand.execute();
            } catch (IOException ex) {
                showError("Error during save to the file");
            }
        }

    }

    /**
     * Opens a window where it is possible to choose a file from which to load
     * user-defined operations
     *
     * @param event MenuIem "Load" clicked
     */
    @FXML
    private void loadFunctions(ActionEvent event) {

        LoadFunctionsCommand loadCommand = null;
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(this.inVarBtn.getScene().getWindow());
        if (file != null) {
            ArrayList<Function> tmpFunctions = new ArrayList<>();
            loadCommand = new LoadFunctionsCommand(tmpFunctions, stack, variables, file);
            try {
                Function.setFunctions(tmpFunctions);
                loadCommand.execute();
                errorLabel.setText("");
                Function.setFunctions(functions);
                functions.clear();
                functions.addAll(tmpFunctions);
                refreshFunctionCommands();
                Alert dialog = new Alert(AlertType.INFORMATION, "Functions loaded correctly", ButtonType.OK);
                dialog.setTitle("Load functions");
                dialog.setHeaderText("Functions loaded");
                dialog.show();
            } catch (FileNotFoundException ex) {
                Alert dialog = new Alert(AlertType.ERROR, "File not found", ButtonType.OK);
                dialog.setTitle("Error");
                dialog.setHeaderText("Error during loading the file");
                dialog.show();
            } catch (IOException ex) {
                Alert dialog = new Alert(AlertType.ERROR, "During loading file", ButtonType.OK);
                dialog.setTitle("Error");
                dialog.setHeaderText("Error during loading the file");
                dialog.show();
            } catch (NoMatchFoundException ex) {
                Alert dialog = new Alert(AlertType.ERROR, "File content not valid", ButtonType.OK);
                dialog.setTitle("Error");
                dialog.setHeaderText("Error during loading the file");
                dialog.show();
            } catch (FunctionNameAlreadyExistsException ex) {
                Alert dialog = new Alert(AlertType.ERROR, "Function name already exists, use a different name", ButtonType.OK);
                dialog.setTitle("Error");
                dialog.setHeaderText("Error during loading the file");
                dialog.show();
            }
        }

    }

}
