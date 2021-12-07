package command;

import java.util.ArrayList;

/**
 * This class implements Command interface and execute the execution of a
 * user-defined function.
 *
 * @author gruppo09
 */
public class FunctionCommand implements Command {

    private String name;
    private String sequenceString;
    private ArrayList<Command> sequenceCommands;

    /**
     * Constructor of FunctionCommand class, it takes in input the name of the
     * function, the sequence string and an array of Commands.
     *
     * @param name The name of the function.
     * @param sequenceString The string representing all the command.
     * @param sequenceCommands The array of Commands created by analyzing the
     * sequence string.
     */
    public FunctionCommand(String name, String sequenceString, ArrayList<Command> sequenceCommands) {
        this.name = name;
        this.sequenceString = sequenceString;
        this.sequenceCommands = sequenceCommands;
    }

    /**
     * Execute all the commands present in sequenceCommands array.
     *
     * @throws Exception When one of the command throws an Exception.
     */
    @Override
    public void execute() throws Exception {
        for (Command command : sequenceCommands) {
            command.execute();
        }
    }

    /**
     * This method is used to get the name of the function.
     *
     * @return The name of the function.
     */
    public String getName() {
        return name;
    }

    /**
     * This method is used to set the name of the function.
     *
     * @param name The value you want to set as name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method is used to get the sequence string of the function.
     *
     * @return The sequenceString attribute.
     */
    public String getSequenceString() {
        return sequenceString;
    }

    /**
     * This method is used to set the sequenceString attribute of the function.
     *
     * @param sequenceString The value you want to set as sequenceString.
     */
    public void setSequenceString(String sequenceString) {
        this.sequenceString = sequenceString;
    }

    /**
     * This method is used to get the sequenceCommands attribute.
     *
     * @return The sequenceCommands attribute.
     */
    public ArrayList<Command> getSequenceCommands() {
        return sequenceCommands;
    }

    /**
     * This method is used to set the sequenceCommand attribute of the function.
     *
     * @param sequenceCommands The value you want to set as sequenceCommands.
     */
    public void setSequenceCommands(ArrayList<Command> sequenceCommands) {
        this.sequenceCommands = sequenceCommands;
    }

    /**
     * This method is used to get a String representation of the FunctionCommand
     * object.
     *
     * @return A String representing the FunctionCommand object.
     */
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
