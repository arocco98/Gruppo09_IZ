package command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import progettose_gruppo09.Function;

/**
 * This class implements Command interface and execute the store in file of each
 * FunctionCommand that has been used in a user-defined Operation
 *
 * @author gruppo09
 */
public class SaveFunctionCommands implements Command {

    private ArrayList<Function> functions;
    private File file;

    /**
     * Construct a new SaveFunctionCommands object that operates on a file and
     * on a FunctionCommands list
     *
     * @param functions the list of FunctionCommands that you want to save
     * @param file the file in which you want to save a user-defined Operation
     */
    public SaveFunctionCommands(ArrayList<Function> functions, File file) {
        this.functions = functions;
        this.file = file;
    }

    /**
     * Execute the save in file operation of a FunctionCommands list that
     * compose the user-defined Operation
     *
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {

        //creating a stream in order to write the file
        FileWriter writer = new FileWriter(file);

        for (Function f : functions) {
            //writing on the file
            writer.write(f.getName() + '\n');
            writer.write(f.getSequenceString() + '\n');
        }

        //closing the stream
        writer.close();
    }

}
