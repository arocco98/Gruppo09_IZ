package command;

import java.util.ArrayList;

/**
 *
 * @author gruppo09
 */
public class FunctionCommand implements Command {

    private String name;
    private String sequenceString;
    private ArrayList<Command> sequenceCommands;

    public FunctionCommand(String name, String sequenceString, ArrayList<Command> sequenceCommands) {
        this.name = name;
        this.sequenceString = sequenceString;
        this.sequenceCommands = sequenceCommands;
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

    @Override
    public String toString() {
        return this.name + ": " + this.sequenceString;
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof FunctionCommand))
            return false;
       
        if(this == object)
            return true;
       
        FunctionCommand other = (FunctionCommand) object;
       
        if(!this.getName().equals(other.getName()))
            return false;
       
        if(!this.getSequenceString().equals(other.sequenceString))
            return false;
       
        return true;
    }
}
