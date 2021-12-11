package command;

import exceptions.NoMatchFoundException;
import java.util.ArrayList;
import progettose_gruppo09.Function;

/**
 * This class implements Command interface and deletes a selected function and,
 * where it is used in other functions, it is replaced with the sequence of
 * operation it performs
 *
 * @author gruppo09
 */
public class DeleteFunctionCommand implements Command {

    private Function selectedFunction;
    private ArrayList<Function> functions;

    /**
     * Construct a new DeleteFunctionCommand object that operates on a function
     * to be deleted from the current list
     *
     * @param selectedFunction The function to be deleted
     * @param functions The current user-defined functions list
     */
    public DeleteFunctionCommand(Function selectedFunction, ArrayList<Function> functions) {
        this.selectedFunction = selectedFunction;
        this.functions = functions;
    }

    /**
     * Executes the elimination of the selected function replacing its sequence
     * of operations into the other user-defined functions that uses it
     *
     * @throws Exception
     */
    @Override
    public void execute() throws Exception {

        for (Function function : functions) {
            //controlling that the function to be deleted is used in other functions
            if (function.getSequenceCommands().contains(new FunctionCommand(selectedFunction))) {
                String[] splitter = function.getSequenceString().split("\\s");
                for (int i = 0; i < splitter.length; i++) {
                    //finding the position in which the operation to be deleted is used into the other function
                    if (selectedFunction.getName().compareTo(splitter[i]) == 0) {
                        //replacing in place of the name of the function to be deleted its sequence of operations
                        splitter[i] = selectedFunction.getSequenceString();
                    }
                }
                try {
                    //setting the updated sequence of operations into the function
                    function.setSequenceString(String.join(" ", splitter));
                } catch (NoMatchFoundException ex) {
                    System.out.println("Not a valid input");
                }
            }
        }

        //removing the selected function from the list
        functions.remove(selectedFunction);

    }

}
