package command;

import exceptions.FunctionNameAlreadyExistsException;
import exceptions.NoMatchFoundException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import progettose_gruppo09.Stack;
import progettose_gruppo09.Variables;

/**
 * This class implements Command interface and execute the insertion of a
 * FunctionCommand checking if the name and the string passed as parameters in
 * the constructor are valid.
 *
 * @author gruppo09
 */
public class InsertFunctionCommand implements Command {

    private String name;
    private String sequence;
    private ArrayList<FunctionCommand> functionCommands;
    private Stack stack;
    private Variables variables;

    /**
     * The constructor of InsertFunctionCommand
     *
     * @param name The name of the new FunctionCommand.
     * @param sequence The sequence to check.
     * @param functionCommands The FunctionCommand array that contains all the
     * previously created function command defined by the user.
     * @param stack The stack that contains all the complex numbers.
     * @param variables The variables Object that contains all the variables.
     */
    public InsertFunctionCommand(String name, String sequence, ArrayList<FunctionCommand> functionCommands, Stack stack, Variables variables) {
        this.name = name.toLowerCase();
        this.sequence = sequence;
        this.functionCommands = functionCommands;
        this.stack = stack;
        this.variables = variables;
    }

    /**
     * This method checks if the name of the new Function is not taken and
     * checks if the string passed as parameter contains only valid operation.
     *
     * @throws NoMatchFoundException
     * @throws FunctionNameAlreadyExistsException
     */
    @Override
    public void execute() throws NoMatchFoundException, FunctionNameAlreadyExistsException {
        // checking if the function name already exists, if so throw a FunctionNameAlreadyExistsException
        for (FunctionCommand functionCommand : functionCommands) {
            if (functionCommand.getName().toLowerCase().equals(name.trim())) {
                throw new FunctionNameAlreadyExistsException();
            }
        }

        // splitting the sequence string and creating an array of Commands
        String[] splittedSequence = sequence.toLowerCase().split("\\s+");
        ArrayList<Command> commands = new ArrayList<>();

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
            } else if (isAValidComplex(string)) { // the string is a insertion operation
                commands.add(new InsertCommand(stack, string));
            } else if (isAFunctionCommand(string, functionCommands)) { // the string is a user-defined function
                for (FunctionCommand functionCommand : functionCommands) {
                    if (string.equals(functionCommand.getName().toLowerCase())) {
                        commands.add(functionCommand);
                    }
                }

            } else { // the string is invalid, so throw a NoMatchFoundException exception
                throw new NoMatchFoundException();
            }

        }

        // if no exceptions were thrown, add a new FunctionCommand to the functionCommands array
        functionCommands.add(new FunctionCommand(name.toLowerCase().trim(), sequence.toLowerCase().replaceAll("\\s+", " "), commands));
    }

    /**
     * Checks if the string name passed as parameter is a user-defined function
     * name
     *
     * @param name The name of the user-defined function to find.
     * @param functionCommands The array of FunctionCommand containing all the
     * user-defined functions.
     * @return true if the name exists, otherwise false.
     */
    private boolean isAFunctionCommand(String name, ArrayList<FunctionCommand> functionCommands) {
        for (FunctionCommand functionCommand : functionCommands) {
            if (name.equals(functionCommand.getName().toLowerCase())) {
                return true;
            }
        }

        return false;
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
}
