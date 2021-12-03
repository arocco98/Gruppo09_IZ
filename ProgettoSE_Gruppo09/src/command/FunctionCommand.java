package command;

import java.util.ArrayList;
import progettose_gruppo09.Stack;

/**
 *
 * @author gruppo09
 */
public class FunctionCommand implements Command {

    private String name;
    private String sequenceString;
    private ArrayList<Command> sequenceCommands;

    public FunctionCommand(String name, String sequenceString) {
        this.name = name;
        this.sequenceString = sequenceString;
        sequenceCommands = new ArrayList<>();
    }

    public FunctionCommand(String name, String sequenceString, Stack stack) {
        this.name = name;
        this.sequenceString = sequenceString;
    }

    @Override
    public void execute() throws Exception {
        for (Command command : sequenceCommands) {
            command.execute();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSequenceString() {
        return sequenceString;
    }

    public void setSequenceString(String sequenceString) {
        this.sequenceString = sequenceString;
    }

    public ArrayList<Command> getSequenceCommands() {
        return sequenceCommands;
    }

    public void setSequenceCommands(ArrayList<Command> sequenceCommands) {
        this.sequenceCommands = sequenceCommands;
    }

}
