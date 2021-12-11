package command;

import exceptions.NoMatchFoundException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import progettose_gruppo09.Function;

/**
 *
 * @author gruppo09
 */
public class DeleteFunctionCommand implements Command {
    
    private Function selectedFunction;
    private ArrayList<Function> functions;

    public DeleteFunctionCommand(Function selectedFunction, ArrayList<Function> functions) {
        
        this.selectedFunction = selectedFunction;
        this.functions = functions;
        
    }


    @Override
    public void execute() throws Exception {

        ArrayList<Command> arr = selectedFunction.getSequenceCommands();
        String[] splitter;

        for (Function function : functions) {
            if (function.getSequenceCommands().contains(new FunctionCommand(selectedFunction))) {
                splitter = function.getSequenceString().split("\\s");
                for (int i = 0; i < splitter.length; i++) {
                    if (selectedFunction.getName().compareTo(splitter[i]) == 0) {
                        splitter[i] = selectedFunction.getSequenceString();
                    }
                }
                try {
                    function.setSequenceString(String.join(" ", splitter));
                } catch (NoMatchFoundException ex) {
                    System.out.println("Not a valid input");
                }
            }
        }
        
        functions.remove(selectedFunction);
        

    }

}
