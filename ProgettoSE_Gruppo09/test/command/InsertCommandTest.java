package command;

import exceptions.NoMatchFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.Stack;

/**
 *
 * @author gruppo09
 */
public class InsertCommandTest {

    Stack stack;
    String patternString;
    
    /**
     * Method for setting up all the used variables.
     */
    @Before
    public void setUp() {
        stack = new Stack();
        patternString = "";
    }

    /**
     * Test of execute method, of class InsertCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        InsertCommand instance = null;
        instance.execute();
    }
    
    @Test(expected = NoMatchFoundException.class)
    public void testExecuteThrowsException() throws NoMatchFoundException {
        
    }

}
