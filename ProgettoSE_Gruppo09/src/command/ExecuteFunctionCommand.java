package command;

import java.util.ArrayList;
import java.util.HashMap;
import progettose_gruppo09.Complex;
import progettose_gruppo09.Function;
import progettose_gruppo09.Stack;
import progettose_gruppo09.Variables;

/**
 * This class implements Command interface and performs the execution of the
 * FunctionCommand object passed in the constructor.
 *
 * @author gruppo09
 */
public class ExecuteFunctionCommand implements Command {

    private Function function;
    private Stack stack;
    private Variables variables;

    /**
     * Constructor of ExecuteFunctionCommand class.
     *
     * @param function The function command to execute.
     * @param stack The stack to restore if errors occur.
     * @param variables The variables to restore if errors occur.
     */
    public ExecuteFunctionCommand(Function function, Stack stack, Variables variables) {
        this.function = function;
        this.stack = stack;
        this.variables = variables;
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
            throw exception;
        }
    }

}
