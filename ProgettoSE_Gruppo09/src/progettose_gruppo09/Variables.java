package progettose_gruppo09;

import exceptions.VariablesNameException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class allows the use of 26 variables (from 'a' to 'z').
 *
 * @author gruppo09
 */
public class Variables {

    private HashMap<Character, Complex> variables;

    /**
     * Constructor of class Variables.
     */
    public Variables() {
        variables = new HashMap<>();
        for (char character = 'a'; character <= 'z'; character++) {
            variables.put(character, null);
        }
    }

    /**
     * This method returns the variables attribute.
     *
     * @return The variables attribute.
     */
    public HashMap<Character, Complex> getVariables() {
        return variables;
    }

    /**
     * This method returns the variable associated to the character used as key.
     *
     * @param character The key of the value to get.
     * @return The variable associated to the key or null, if the variable was
     * not instantiated.
     * @throws VariablesNameException If the character is not between 'a' and
     * 'z'.
     */
    public Complex getVariable(Character character) throws VariablesNameException {
        if (character >= 'a' && character <= 'z') {
            return variables.get(character);
        } else {
            throw new VariablesNameException();
        }
    }

    /**
     * This method takes in input a Character and a Complex and associates the
     * passed character to the passed variable.
     *
     * @param character The character to whom associate the variable.
     * @param complex The variable to associate.
     * @throws VariablesNameException If the character is not between 'a' and
     * 'z'.
     */
    public void setVariable(Character character, Complex complex) throws VariablesNameException {
        if (character >= 'a' && character <= 'z') {
            variables.put(character, complex);
        } else {
            throw new VariablesNameException();
        }
    }

    /**
     * This method returns a string representation of the object
     *
     * @return a string representation of the object
     */
    public String toString() {
        String string = "";
        for (Map.Entry<Character, Complex> entry : variables.entrySet()) {
            string += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return string;
    }
}
