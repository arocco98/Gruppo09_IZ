package command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class implements Command interface and execute the store in file of each FunctionCommand
 * that has been used in a user-defined Operation
 * 
 * @author gruppo09
 */
public class SaveFunctionCommands implements Command{
    
    private ArrayList<FunctionCommand> functions;
    private File file;
    
    /**
     * Construct a new SaveFunctionCommands object that operates on a file and on a FunctionCommands list
     * 
     * @param functions the list of FunctionCommands that you want to save
     * @param file the file in which you want to save a user-defined Operation
     */
    public SaveFunctionCommands(ArrayList<FunctionCommand> functions, File file) {
        this.functions = functions;
        this.file = file;
    }
    
    /**
     * Execute the save in file operation of a FunctionCommands list that compose the user-defined Operation
     * 
     * @throws IOException 
     */
    @Override
    public void execute() throws IOException {

        //creo uno stream per scrivere su file
        FileWriter writer = new FileWriter(file);

        for (FunctionCommand f : functions) {
            //scrivo su file
            writer.write(f.getName() + '\n');
            writer.write(f.getSequenceString() + '\n');
        }

        //chiudo lo stream
        writer.close();
    }
    
}
