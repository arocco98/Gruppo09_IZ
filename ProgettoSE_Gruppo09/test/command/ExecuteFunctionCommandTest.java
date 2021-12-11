package command;

import exceptions.VariablesNameException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import progettose_gruppo09.Complex;
import progettose_gruppo09.Function;
import progettose_gruppo09.ComplexStack;
import progettose_gruppo09.Variables;
import progettose_gruppo09.VariablesStack;

/**
 *
 * @author gruppo09
 */
public class ExecuteFunctionCommandTest {
    
    private ComplexStack stack = null;
    private Variables variables = null;
    private ArrayList<Function> functions;
    private VariablesStack savedVariables;
    
    @Before
    public void setUp() {
        // instantiating stack and variables attributes
        stack = new ComplexStack();
        variables = new Variables();
        functions = new ArrayList<>();

        // populating stack and variables attributes
        stack.push(new Complex(1.23, 4.56));
        stack.push(new Complex(1.23, 0.0));
        stack.push(new Complex(0.0, 4.56));
        stack.push(new Complex(-1.23, 4.56));
        stack.push(new Complex(1.23, -4.56));

        try {
            variables.setVariable('a', new Complex(4.56, 7.89));
            variables.setVariable('i', new Complex(0.0, 7.89));
            variables.setVariable('z', new Complex(4.56, 0.0));
        } catch (VariablesNameException ex) {
        }

        savedVariables = new VariablesStack();
        
        Function.setStack(this.stack);
        Function.setVariables(this.variables);
        Function.setFunctions(this.functions);
        Function.setVariablesStack(savedVariables);
    }

    /**
     * Test of execute method, of class ExecuteFunctionCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        
        ExecuteFunctionCommand instance = new ExecuteFunctionCommand(new Function("function", "+ drop dup dup"), stack, variables, savedVariables);
        instance.execute();
    }
    
    /**
     * Test of execute method, of class ExecuteFunctionCommand, when it throws an exception.
     */
    @Test (expected = Exception.class)
    public void testExecuteWhenItThrowsException() throws Exception {
        System.out.println("execute when it throws a Exception");
        
        ExecuteFunctionCommand instance = new ExecuteFunctionCommand(new Function("function", "+ - * / drop sqrt"), stack, variables, savedVariables);
        instance.execute();
    }
}
