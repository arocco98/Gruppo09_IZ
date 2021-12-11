package command;

import java.util.ArrayList;
import java.util.HashMap;
import progettose_gruppo09.Complex;
import progettose_gruppo09.Function;
import progettose_gruppo09.ComplexStack;
import progettose_gruppo09.Variables;
import progettose_gruppo09.VariablesStack;

/**
 * This class implements Command interface and performs the execution of the
 * FunctionCommand object passed in the constructor.
 *
 * @author gruppo09
 */
public class ExecuteFunctionCommand implements Command {

    private Function function;
    private ComplexStack stack;
    private Variables variables;
    private VariablesStack savedVariables;

    /**
     * Constructor of ExecuteFunctionCommand class.
     *
     * @param function The function command to execute.
     * @param stack The stack to restore if errors occur.
     * @param variables The variables to restore if errors occur.
     * @param savedVariables The stack variables to restore if errors occur.
     */
    public ExecuteFunctionCommand(Function function, ComplexStack stack, Variables variables, VariablesStack savedVariables) {
        this.function = function;
        this.stack = stack;
        this.variables = variables;
        this.savedVariables = savedVariables;
    }

    /**
     * Execute the function command operations and restore the stack and
     * variables attributes if error occurs.
     *
     * @throws Exception When an operation throws an exception.
     */
    @Override
    public void execute() throws Exception {
        // creating a temporary stack for restoring the principal stack attribute if error occurs
        ArrayList<Complex> tmpStack = new ArrayList<>(stack);
        // creating a temporary variables for restoring the principal variables attribute if error occurs
        HashMap<Character, Complex> tmpVariables = new HashMap<>(variables.getVariables());
        
        // creating the size of the variablesStack before the execution
        int tmpSize = savedVariables.size();
        
        try { // executing the user-defined function
            FunctionCommand functionCommand = new FunctionCommand(function);
            functionCommand.execute();
        } catch (Exception exception) {
            // restoring stack
            stack.clear();
            stack.addAll(tmpStack);
            // restoring variables
            variables.getVariables().clear();
            variables.getVariables().putAll(tmpVariables);
            
            while(tmpSize < savedVariables.size()) {
                savedVariables.pop();
            }
            throw exception;
        }
    }

}
