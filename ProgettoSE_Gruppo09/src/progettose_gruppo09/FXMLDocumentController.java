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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.MenuItem;
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

        public MyEntry() {
            this.key = null;
            this.value = null;
        }

        public MyEntry(Character character, Complex complex) {
            this.key = character;
            this.value = complex;
        }

        public Set<MyEntry<Character, Complex>> fromEntrySet(Set<Entry<Character, Complex>> entrySet) {
            Set<MyEntry<Character, Complex>> set = new TreeSet<>();
            for (Entry<Character, Complex> entry : entrySet) {
                set.add(new MyEntry<>(entry.getKey(), entry.getValue()));
            }
            return set;
        }

        @Override
        public Character getKey() {
            return this.key;
        }

        @Override
        public Complex getValue() {
            return this.value;
        }

        @Override
        public Complex setValue(Complex value) {
            this.value = value;
            return this.getValue();
        }

        @Override
        public String toString() {
            if (this.getValue() == null) {
                return this.getKey() + ":\t...";
            }
            return this.getKey() + ":\t" + this.getValue();
        }

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
    private ComboBox<FunctionCommand> functionsComboBox;
    @FXML
    private MenuItem saveFunctionButton; // BIND!!!
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
    private Stack stack = null;
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

    // variables 
    private Variables variables = new Variables();

    // user-defined functions
    private ArrayList<FunctionCommand> functionCommands = null;
    private ObservableList<FunctionCommand> observableFunctionCommands = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // initializing stack and elementList variables
        stack = new Stack();
        elementList.setPlaceholder(new Label("No value present"));
        stackColumn.setCellValueFactory(new PropertyValueFactory<>("complex"));
        stackColumn.setSortable(false);
        observableStack = FXCollections.observableList(stack);
        elementList.setItems(observableStack);

        // initializing variables 
        MyEntry<Character, Complex> myEntry = new MyEntry<>();
        observableCharacterList = FXCollections.observableList(new ArrayList<>(myEntry.fromEntrySet(variables.getVariables().entrySet())));
        observableCharacterList.sort(null);
        variablesComboBox.setItems(observableCharacterList);
        variablesComboBox.getSelectionModel().selectFirst();

        // initializing all commands
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

        // initializing functionCommands array
        functionCommands = new ArrayList<>();
        observableFunctionCommands = FXCollections.observableArrayList(functionCommands);
        functionsComboBox.setItems(observableFunctionCommands);
        // binding the button to the combobox, if no value is selected then the button must be disabled
        executeFunctionButton.disableProperty().bind(functionsComboBox.valueProperty().isNull());
        // this method is used in order to show to the user the operations of one function when the mouse is over the name of the operation
        functionsComboBox.setCellFactory(param -> {
            return new ListCell<FunctionCommand>() {

                @Override
                public void updateItem(FunctionCommand item, boolean empty) {
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

    public Stack getStack() {
        return stack;
    }

    public Variables getVariables() {
        return variables;
    }

    public ArrayList<FunctionCommand> getFunctionCommands() {
        return functionCommands;
    }

    public void setFunctionCommands(ArrayList<FunctionCommand> functionCommands) {
        this.functionCommands = functionCommands;
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
     * Execute the clear of the stack when button "Clear" is clicked
     *
     * @param event button 'Clear' clicked
     */
    @FXML
    private void clear(ActionEvent event) {
        try {
            clearCommand.execute();
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

    @FXML
    private void selectedItemChanged(ActionEvent event) {
        updateText(inVarBtn, ">");
        updateText(outVarBtn, "<");
        updateText(sumVarBtn, "+");
        updateText(subVarBtn, "-");
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
        ExecuteFunctionCommand executeFunctionCommand = new ExecuteFunctionCommand(functionsComboBox.getValue(), stack, variables);

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
        observableFunctionCommands.clear();
        observableFunctionCommands.addAll(functionCommands);
        // set the items in the combobox
        functionsComboBox.setItems(observableFunctionCommands);
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
            saveCommand = new SaveFunctionCommands(functionCommands, file);

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
            loadCommand = new LoadFunctionsCommand(functionCommands, stack, variables, file);
            try {
                loadCommand.execute();
                refreshFunctionCommands();
            } catch (FileNotFoundException ex) {
                showError("File not found");
            } catch (IOException ex) {
                showError("Error during loading file");
            } catch (NoMatchFoundException ex) {
                showError("Not a valid input");
            } catch (FunctionNameAlreadyExistsException ex) {
                showError("Function name already exists, use a different name");
            }
        }

    }

}
