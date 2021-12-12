package progettose_gruppo09;

import command.*;
import exceptions.FunctionNameAlreadyExistsException;
import exceptions.NoMatchFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represent a user-defined function.
 *
 * @author gruppo09
 */
public class Function {

    private String name;
    private String sequenceString;
    private ArrayList<Command> sequenceCommands;
    static private ArrayList<Function> functions = new ArrayList<>();
    static private ComplexStack stack = new ComplexStack();
    static private Variables variables = new Variables();
    static private VariablesStack variablesStack = new VariablesStack();

    /**
     * Constructor of class Function, it throws a
     * FunctionNameAlreadyExistsException if the function name is not valid.
     *
     * @param name The name to assign to the function.
     * @throws FunctionNameAlreadyExistsException When the name is not valid.
     */
    public Function(String name) throws FunctionNameAlreadyExistsException {
        if (isAValidName(name) && !isAValidComplex(name)) {
            this.name = name;
        } else {
            throw new FunctionNameAlreadyExistsException();
        }
        sequenceString = "";
    }

    /**
     * Constructor of class Function.It takes two arguments, the function name
     * and the sequence string. It throws a FunctionNameAlreadyExistsException
     * if the function name is not valid, a NoMatchFoundException if the
     * sequenceString is not a valid sequence.
     *
     * @param name The name to assign to the function.
     * @param sequenceString The sequence of commands the function have to
     * perform.
     * @throws FunctionNameAlreadyExistsException When the name is not valid.
     * @throws exceptions.NoMatchFoundException When the sequence string is not
     * a valid sequence of commands.
     */
    public Function(String name, String sequenceString) throws FunctionNameAlreadyExistsException, NoMatchFoundException {
        if (isAValidName(name) && !isAValidComplex(name)) {
            this.name = name;
        } else {
            throw new FunctionNameAlreadyExistsException();
        }
        this.setSequenceString(sequenceString);
    }

    /**
     * Static setter of functions attribute.
     *
     * @param functions The new value of functions attribute.
     */
    public static void setFunctions(ArrayList<Function> functions) {
        Function.functions = functions;
    }

    /**
     * Static setter of stack attribute.
     *
     * @param stack The new value of stack attribute.
     */
    public static void setStack(ComplexStack stack) {
        Function.stack = stack;
    }

    /**
     * Static setter of variables attribute.
     *
     * @param variables The new value of variables attribute.
     */
    public static void setVariables(Variables variables) {
        Function.variables = variables;
    }

    /**
     * Static setter of variablesStack attribute.
     *
     * @param variablesStack The new value of variablesStack attribute.
     */
    public static void setVariablesStack(VariablesStack variablesStack) {
        Function.variablesStack = variablesStack;
    }

    /**
     * This method generates the commands by analyzing the string passed as
     * argument. If the string is not valid, it throws a NoMatchFoundException.
     *
     * @param sequenceString The string containing the sequence of operations.
     * @throws NoMatchFoundException When the string of operations is not valid.
     */
    public void generateCommands(String sequenceString) throws NoMatchFoundException {
        // creating a new array of commands that will be setted
        ArrayList<Command> commands = new ArrayList<>();

        String[] splittedSequence = sequenceString.trim().split("\\s+");

        // for each string in the splitted sequence check if is a valid command 
        // and, if so, creating and adding a new command to commands.
        for (String string : splittedSequence) {
            if (string.matches("\\+$")) { // the string is a sum operation
                commands.add(new SumCommand(stack));
            } else if (string.matches("-$")) { // the string is a subtraction operation
                commands.add(new SubCommand(stack));
            } else if (string.matches("\\*$")) { // the string is a product operation
                commands.add(new ProdCommand(stack));
            } else if (string.matches("/$")) { // the string is a division operation
                commands.add(new DivCommand(stack));
            } else if (string.matches("sqrt$")) { // the string is a square root operation
                commands.add(new SqrtCommand(stack));
            } else if (string.matches("\\+-$")) { // the string is an inversion sign operation
                commands.add(new InversionSignCommand(stack));
            } else if (string.matches("mod$")) { // the string is an modulus operation
                commands.add(new ModCommand(stack));
            } else if (string.matches("arg$")) { // the string is an argument operation
                commands.add(new ArgCommand(stack));
            } else if (string.matches("pow$")) { // the string is an power operation
                commands.add(new PowCommand(stack));
            } else if (string.matches("exp$")) { // the string is an exponential operation
                commands.add(new ExpCommand(stack));
            } else if (string.matches("log$")) { // the string is an natural logarithm operation
                commands.add(new LogCommand(stack));
            } else if (string.matches("sin$")) { // the string is an sin operation
                commands.add(new SinCommand(stack));
            } else if (string.matches("cos$")) { // the string is an cosine operation
                commands.add(new CosCommand(stack));
            } else if (string.matches("tan$")) { // the string is an tangent operation
                commands.add(new TanCommand(stack));
            } else if (string.matches("arcsin$")) { // the string is an arc sine operation
                commands.add(new ArcsinCommand(stack));
            } else if (string.matches("arccos$")) { // the string is an arc cosine operation
                commands.add(new ArccosCommand(stack));
            } else if (string.matches("arctan$")) { // the string is an arc tangent operation
                //commands.add(new ArctanCommand(stack));
            } else if (string.matches("clear$")) { // the string is a clear operation
                commands.add(new ClearCommand(stack));
            } else if (string.matches("drop$")) { // the string is a drop operation
                commands.add(new DropCommand(stack));
            } else if (string.matches("dup$")) { // the string is a dup operation
                commands.add(new DupCommand(stack));
            } else if (string.matches("swap$")) { // the string is a swap operation
                commands.add(new SwapCommand(stack));
            } else if (string.matches("over$")) { // the string is a over operation
                commands.add(new OverCommand(stack));
            } else if (string.matches(">[a-z]$")) { // the string is a inVariable operation
                commands.add(new InVariableCommand(string.charAt(1), stack, variables));
            } else if (string.matches("<[a-z]$")) { // the string is a outVariable operation
                commands.add(new OutVariableCommand(stack, variables, string.charAt(1)));
            } else if (string.matches("\\+[a-z]$")) { // the string is a sumVariable operation
                commands.add(new SumVariableCommand(stack, variables, string.charAt(1)));
            } else if (string.matches("-[a-z]$")) { // the string is a subVariable operation
                commands.add(new SubVariableCommand(stack, variables, string.charAt(1)));
            } else if (string.matches("save$")) { // the string is a saveVariables operation
                commands.add(new SaveVariablesCommand(variables, variablesStack));
            } else if (string.matches("restore$")) { // the string is a restoreVariables operation
                commands.add(new RestoreVariablesCommand(variables, variablesStack));
            } else if (isAValidComplex(string)) { // the string is a insertion operation
                commands.add(new InsertCommand(stack, string));
            } else if (isAFunction(string)) { // the string is a user-defined function
                if (name.equalsIgnoreCase(string)) {
                    throw new NoMatchFoundException();
                }

                for (Function function : Function.functions) {
                    if (string.equalsIgnoreCase(function.getName())) {
                        commands.add(new FunctionCommand(function));
                    }
                }

            } else { // the string is invalid, so throw a NoMatchFoundException exception
                throw new NoMatchFoundException();
            }

        }

        this.sequenceCommands = commands;
    }

    /**
     * Checks if the name passed as parameter is a valid name.
     *
     * @param name The name of the function.
     * @return True if the name is valid, otherwise false.
     */
    public static boolean isAValidName(String name) {
        // checking if the string is empty and if it is composed by only one word
        if (name.trim().isEmpty() || name.replaceAll("\\s+", " ").split(" ").length != 1) {
            return false;
        }

        // checking if the name is not already used by another function
        for (Function function : functions) {
            if (name.equalsIgnoreCase(function.getName())) {
                return false;
            }
        }

        // This array of strings contains all the default operation names, except the operation on the variables
        String[] defaultCommandNames = {"+", "-", "*", "/", "sqrt", "+-", "clear", "drop", "dup", "swap", "over", "save", "restore", "mod", "arg", "pow", "exp", "log", "sin", "cos", "tan", "arcsin", "arccos", "arctan"};
        // checking if the function name is a default operation name
        for (String commandName : defaultCommandNames) {
            if (name.equals(commandName)) {
                return false;
            }
        }

        // checking if the function name is a variable name operation
        if (name.matches(">[a-z]$")) {
            return false;
        }
        if (name.matches("<[a-z]$")) {
            return false;
        }
        if (name.matches("\\+[a-z]$")) {
            return false;
        }
        if (name.matches("-[a-z]$")) {
            return false;
        }

        return true;
    }

    /**
     * Checks if the string is a valid complex number pattern.
     *
     * @param string The string to check.
     * @return true if the string is a valid complex number pattern, otherwise
     * false.
     */
    private boolean isAValidComplex(String string) {
        // pattern for real and imaginary part: a+bj
        Pattern patternRI = createPattern("([+|-]?\\d+(\\.\\d+)?)([+|-]\\d+(\\.\\d+)?)j$");
        // pattern for real and imaginary part: a+jb
        Pattern patternRI2 = createPattern("([+|-]?\\d+(\\.\\d+)?)([+|-]j\\d+(\\.\\d+)?)$");
        // pattern for imaginary and real part: bj+a
        Pattern patternIR = createPattern("([+|-]?\\d+(\\.\\d+)?)j([+|-]\\d+(\\.\\d+)?)$");
        // pattern for imaginary and real part: jb+a
        Pattern patternIR2 = createPattern("([+|-]?j\\d+(\\.\\d+)?)([+|-]\\d+(\\.\\d+)?)$");
        // pattern for only real part: a
        Pattern patternR = createPattern("([+|-]?\\d+(\\.\\d+)?)$");
        // pattern for only imaginary part: bj
        Pattern patternI = createPattern("([+|-]?\\d+(\\.\\d+)?)j$");
        // pattern for only imaginary part: jb
        Pattern patternI2 = createPattern("([+|-]?j\\d+(\\.\\d+)?)$");
        // pattern for real and imaginary part using only 'j': a+j
        Pattern patternRJ = createPattern("([+|-]?\\d+(\\.\\d+)?)([+|-]j)$");
        // pattern for imaginary and real part using only 'j': j+a
        Pattern patternJR = createPattern("([+|-]?j)([+|-]\\d+(\\.\\d+)?)$");
        // pattern for imaginary part using only 'j': j
        Pattern patternJ = createPattern("([+|-]?j)$");

        // matcher for real and imaginary part: a+bj
        Matcher matcherRI = createMatcher(patternRI, string);
        // matcher for real and imaginary part: a+jb
        Matcher matcherRI2 = createMatcher(patternRI2, string);
        // matcher for imaginary and real part: bj+a
        Matcher matcherIR = createMatcher(patternIR, string);
        // matcher for imaginary and real part: jb+a
        Matcher matcherIR2 = createMatcher(patternIR2, string);
        // matcher for only real part: a
        Matcher matcherR = createMatcher(patternR, string);
        // matcher for only imaginary part: bj
        Matcher matcherI = createMatcher(patternI, string);
        // matcher for only imaginary part: jb
        Matcher matcherI2 = createMatcher(patternI2, string);
        // matcher for real and imaginary part using only 'j': a+j
        Matcher matcherRJ = createMatcher(patternRJ, string);
        // matcher for imaginary and real part using only 'j': j+a
        Matcher matcherJR = createMatcher(patternJR, string);
        // matcher for imaginary part using only 'j': j
        Matcher matcherJ = createMatcher(patternJ, string);

        ArrayList<Matcher> matchers = new ArrayList<>();
        matchers.add(matcherRI);
        matchers.add(matcherRI2);
        matchers.add(matcherIR);
        matchers.add(matcherIR2);
        matchers.add(matcherR);
        matchers.add(matcherI);
        matchers.add(matcherI2);
        matchers.add(matcherRJ);
        matchers.add(matcherJR);
        matchers.add(matcherJ);

        // if the string matches at least one Pattern, return true
        for (Matcher matcher : matchers) {
            if (matcher.matches()) {
                return true;
            }
        }

        // the string doesn't matches any pattern
        return false;
    }

    /**
     * Creates and returns a Pattern object by using the string passed as
     * argument.
     *
     * @param stringPattern The string that contains the pattern.
     * @return A Pattern object created by using the string passed as argument.
     */
    private Pattern createPattern(String stringPattern) {
        return Pattern.compile(stringPattern);
    }

    /**
     * Creates and returns a Matcher object using the Pattern object passed as
     * argument.
     *
     * @param pattern The pattern with which to create the matcher.
     * @param patternString The string to analyze.
     * @return A Matcher object created by using the "matcher" method of Pattern
     * and by passing the text contained in the text field (spaces excluded).
     */
    private Matcher createMatcher(Pattern pattern, String patternString) {
        return pattern.matcher(patternString.replaceAll("\\s+", ""));
    }

    /**
     * Checks if the string name passed as parameter is a user-defined function
     * name
     *
     * @param name The name of the user-defined function to find.
     * @return true if the name exists, otherwise false.
     */
    private boolean isAFunction(String name) {
        for (Function function : functions) {
            if (name.equalsIgnoreCase(function.getName())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Getter method of name attribute.
     *
     * @return The attribute name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method of sequenceString attribute.
     *
     * @return The sequenceString attribute.
     */
    public String getSequenceString() {
        return sequenceString;
    }

    /**
     * Setter method of sequenceString attribute, before changing the value of
     * sequenceStirng, it checks if the passed argument is a valid sequence
     * string and generates all the new commands.
     *
     * @param sequenceString The new value of sequenceString.
     * @throws NoMatchFoundException If the new sequenceString is not a valid
     * sequence.
     */
    public void setSequenceString(String sequenceString) throws NoMatchFoundException {
        generateCommands(sequenceString.trim());
        this.sequenceString = sequenceString.trim().replaceAll("\\s+", " ");
    }

    /**
     * Getter method of sequenceCommands attribute.
     *
     * @return The sequenceCommands attribute.
     */
    public ArrayList<Command> getSequenceCommands() {
        return sequenceCommands;
    }

    /**
     * This method generate a string representation of the object.
     *
     * @return The string representation of the object.
     */
    public String toString() {
        return name;
    }

    /**
     * Equals method of the Function class, it checks if the name of the object
     * passed as argument is equals to the name of the instance.
     *
     * @param obj The object to check if it is equal.
     * @return True if the name are equals, otherwise false.
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
        final Function other = (Function) obj;
        return Objects.equals(this.name, other.name);
    }

}
