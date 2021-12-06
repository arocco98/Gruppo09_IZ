package command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.Complex;
import progettose_gruppo09.Stack;

/**
 *
 * @author gruppo09
 */
public class SaveFunctionCommandsTest {
    private ArrayList<FunctionCommand> functions;
    private ArrayList<Command> sequenceCommands;
    private ArrayList<Command> sequenceCommands2;
    private Stack stack;
    private Complex n1;
    private Complex n2;
    private Complex n3;
    private Complex n4;
    private SumCommand sum;
    private SubCommand sub;
    private ProdCommand prod;
    private File file1;
    
    
    public SaveFunctionCommandsTest() {
    }
    
    @Before
    public void setUp() {
        functions = new ArrayList<>();
        sequenceCommands = new ArrayList<>();
        sequenceCommands2 = new ArrayList<>();
        stack = new Stack();
        n1 = new Complex (1.0, 1.0);
        n2 = new Complex (2.0, 2.0);
        n3 = new Complex (1.0, 1.0);
        n4 = new Complex (1.0, 1.0);
        stack.push(n1);
        stack.push(n2);
        stack.push(n3);
        stack.push(n4);
        sum = new SumCommand(stack);
        sub = new SubCommand(stack);
        prod = new ProdCommand(stack);
        sequenceCommands.add(sum);
        sequenceCommands.add(sub);
        sequenceCommands.add(prod);
        sequenceCommands2.add(sub);
        sequenceCommands2.add(sum);
        sequenceCommands2.add(prod);
    }

    /**
     * Test of execute method, of class SaveFunctionCommands.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("Save Test");
        
        file1 = new File("file1");
        FunctionCommand fun1 = new FunctionCommand("op1", "+ - *", sequenceCommands);
        FunctionCommand fun2 = new FunctionCommand("op2", "- + *", sequenceCommands2);
        functions.add(fun1);
        functions.add(fun2);
        
        SaveFunctionCommands instance = new SaveFunctionCommands(functions, file1);
        instance.execute();

        try {
            //creo uno stream per leggere da file
            FileReader reader = new FileReader(file1);

            //questo mi permette di leggere linee intere
            BufferedReader lineReader = new BufferedReader(reader);

            //Leggo una linea alla volta e la stampo finchè non arrivo alla fine del file
            String linea = lineReader.readLine();

            ArrayList<String> result = new ArrayList<>();

            while (linea != null) {
                result.add(linea);
                linea = lineReader.readLine();
            }

            int size = result.size();
            int i = 0;

            for (FunctionCommand f : functions) {
                assertEquals(f.getName(), result.get(i));
                assertEquals(f.getSequenceString(), result.get(i + 1));
                i += 2;
            }

            assertEquals(size, i);
        } catch (IOException e) {
            System.out.println("Errore durante la lettura: " + e);
        }
    }
    
    /**
     * Test of execute method, of class SaveFunctionCommands, that generate an IOException
     * 
     * @throws IOException 
     */
    @Test(expected = IOException.class)
    public void testExecute2() throws IOException {
        System.out.println("Save Test 2");
        
        file1 = new File("src");
        FunctionCommand fun1 = new FunctionCommand("op1", "+ - *", sequenceCommands);
        FunctionCommand fun2 = new FunctionCommand("op2", "- + *", sequenceCommands2);
        functions.add(fun1);
        functions.add(fun2);
        
        SaveFunctionCommands instance = new SaveFunctionCommands(functions, file1);
        instance.execute();
    }
    
}
