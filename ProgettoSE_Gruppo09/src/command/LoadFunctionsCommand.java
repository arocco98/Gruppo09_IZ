package command;

import exceptions.FunctionNameAlreadyExistsException;
import exceptions.NoMatchFoundException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import progettose_gruppo09.*;


/**
 * This class implements Command interface and execute the loading from file of each FunctionCommand
 * that it contains
 * 
 * @author gruppo09
 */
public class LoadFunctionsCommand implements Command{
    
    private ArrayList<FunctionCommand> functionCommands;
    private Stack stack;
    private Variables variables;
    private File file;

    /**
     * Construct a new LoadFunctionCommands object that operates on a file and on a FunctionCommands list
     * 
     * @param functionCommands the list of FunctionCommands in which you want to save the user-defined operations read.
     * @param stack The stack that contains all the complex numbers.
     * @param variables The variables Object that contains all the variables.
     * @param file the file from which you want to read the user-defined Operation.
     */
    public LoadFunctionsCommand(ArrayList<FunctionCommand> functionCommands, Stack stack, Variables variables, File file) {
        this.functionCommands = functionCommands;
        this.stack = stack;
        this.variables = variables;
        this.file = file;
    }

    /**
     * Execute the load of user-defined operations from file
     * 
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NoMatchFoundException
     * @throws FunctionNameAlreadyExistsException 
     */
    @Override
    public void execute() throws FileNotFoundException, IOException, NoMatchFoundException, FunctionNameAlreadyExistsException {
        
        //creo uno stream per leggere da file
        FileReader reader = new FileReader(file);

        //questo mi permette di leggere linee intere
        BufferedReader lineReader = new BufferedReader(reader);

        //Leggo una linea alla volta
        String linea = lineReader.readLine();
        
        ArrayList<String> str = new ArrayList<>();

        while (linea != null) {
            
            str.add(linea);
            linea = lineReader.readLine();
        }
        
        for (int i = 0; i < str.size(); i += 2){
            InsertFunctionCommand insert = new InsertFunctionCommand(str.get(i), str.get(i+1), functionCommands, stack, variables);
            insert.execute();;
        }

        //chiudo lo stream
        lineReader.close();
        reader.close();
    }
    
    
}
