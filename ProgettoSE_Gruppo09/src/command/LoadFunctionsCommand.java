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
 * This class implements Command interface and execute the loading from file of
 * each Function that it contains
 *
 * @author gruppo09
 */
public class LoadFunctionsCommand implements Command {

    private ArrayList<Function> functions;
    private Stack stack;
    private Variables variables;
    private File file;

    /**
     * Construct a new LoadFunctionCommands object that operates on a file and
     * on a FunctionCommands list
     *
     * @param functionCommands the list of FunctionCommands in which you want to
     * save the user-defined operations read.
     * @param stack The stack that contains all the complex numbers.
     * @param variables The variables Object that contains all the variables.
     * @param file the file from which you want to read the user-defined
     * Operation.
     */
    public LoadFunctionsCommand(ArrayList<Function> functionCommands, Stack stack, Variables variables, File file) {
        this.functions = functionCommands;
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

        // creating a stream in order to read the file
        FileReader reader = new FileReader(file);

        // creating a bufferReader in order to read all the lines
        BufferedReader lineReader = new BufferedReader(reader);

        // reading one line at a time
        String line = lineReader.readLine();

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> stringSequences = new ArrayList<>();

        while (line != null) {

            names.add(line);
            line = lineReader.readLine();
            stringSequences.add(line);
            line = lineReader.readLine();
        }

        for (String name : names) {
            functions.add(new Function(name));
        }

        int i = 0;
        for (String stringSequence : stringSequences) {
            functions.get(i).setSequenceString(stringSequence);
            i++;
        }

        // closing the stream
        lineReader.close();
        reader.close();
    }

}
