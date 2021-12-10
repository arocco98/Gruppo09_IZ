package command;

import java.util.ArrayList;
import java.util.Objects;
import progettose_gruppo09.Function;

/**
 * This class implements Command interface and performs the execution of the
 * commands present in the the Function object passed in the constructor.
 *
 * @author gruppo09
 */
public class FunctionCommand implements Command {

    private Function function;

    /**
     * Constructor of FunctionCommand class.
     *
     * @param function The function to execute commands.
     */
    public FunctionCommand(Function function) {
        this.function = function;
    }

    /**
     * Execute all the commands present in the function object.
     *
     * @throws Exception When a command throws an exception.
     */
    @Override
    public void execute() throws Exception {
        ArrayList<Command> commands = function.getSequenceCommands();
        for (Command command : commands) {
            command.execute();
        }
    }

    /**
     * Equals method of FunctionCommand class, it returns true if the object
     * passed as parameter has the same name of the function attribute.
     *
     * @param obj The object to check the name.
     * @return True if the names are equal, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FunctionCommand other = (FunctionCommand) obj;
        return Objects.equals(this.function.getName(), other.function.getName());
    }

}
