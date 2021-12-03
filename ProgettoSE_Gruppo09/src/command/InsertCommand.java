package command;

import exceptions.NoMatchFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import progettose_gruppo09.Complex;
import progettose_gruppo09.Stack;

/**
 * This class implements Command interface and execute the insertion of a
 * Complex number by analyzing the string passed as parameter and pushing the
 * number, if the string represent a Complex number, into the stack
 *
 * @author gruppo09
 */
public class InsertCommand implements Command {

    Stack stack;
    String patternString;

    /**
     * Constructor of InsertCommand class, it takes two parameters: a Stack
     * object and a String object.
     *
     * @param stack The stack to push the element into.
     * @param patternString The string to check.
     */
    public InsertCommand(Stack stack, String patternString) {
        this.stack = stack;
        this.patternString = patternString;
    }

    /**
     * Checks if the string matches a pattern, if so it pushes the just created
     * element into the stack, else it throws a NoMatchFoundException.
     *
     * @throws NoMatchFoundException The Exception throwed when patternString doesn't match any pattern.
     */
    @Override
    public void execute() throws NoMatchFoundException {
        // pattern for real and imaginary part
        Pattern patternRI = createPattern("([+|-]?\\d+(\\.\\d+)?)([+|-]\\d+(\\.\\d+)?)j$");
        // pattern for imaginary and real part
        Pattern patternIR = createPattern("([+|-]?\\d+(\\.\\d+)?)j([+|-]\\d+(\\.\\d+)?)$");
        // pattern for only real part
        Pattern patternR = createPattern("([+|-]?\\d+(\\.\\d+)?)$");
        // pattern for only imaginary part
        Pattern patternI = createPattern("([+|-]?\\d+(\\.\\d+)?)j$");
        // pattern for real and imaginary part using only 'j'
        Pattern patternRJ = createPattern("([+|-]?\\d+(\\.\\d+)?)([+|-]j)$");
        // pattern for imaginary and real part using only 'j'
        Pattern patternJR = createPattern("([+|-]?j)([+|-]\\d+(\\.\\d+)?)$");
        // pattern for imaginary part using only 'j'
        Pattern patternJ = createPattern("([+|-]?j)$");

        // defining real and imaginary variable
        double real = 0.0, imaginary = 0.0;

        // matcher for real and imaginary part
        Matcher matcherRI = createMatcher(patternRI);
        // matcher for imaginary and real part
        Matcher matcherIR = createMatcher(patternIR);
        // matcher for only real part
        Matcher matcherR = createMatcher(patternR);
        // matcher for only imaginary part
        Matcher matcherI = createMatcher(patternI);
        // matcher for real and imaginary part using only 'j'
        Matcher matcherRJ = createMatcher(patternRJ);
        // matcher for imaginary and real part using only 'j'
        Matcher matcherJR = createMatcher(patternJR);
        // matcher for imaginary part using only 'j'
        Matcher matcherJ = createMatcher(patternJ);

        if (matcherRI.matches()) { // if the user input matches the first pattern
            real = Double.parseDouble(matcherRI.group(1)); // extract the real part
            imaginary = Double.parseDouble(matcherRI.group(3)); // extract the imaginary part

            Complex c = new Complex(real, imaginary);

            // pushing the just created element into the stack
            stack.push(c);
        } else if (matcherIR.matches()) { // if the user input matches the second pattern
            real = Double.parseDouble(matcherIR.group(3)); // extract the real part
            imaginary = Double.parseDouble(matcherIR.group(1)); // extract the imaginary part

            Complex c = new Complex(real, imaginary);

            // pushing the just created element into the stack
            stack.push(c);
        } else if (matcherR.matches()) { // if the user input matches the third pattern
            real = Double.parseDouble(matcherR.group(1)); // extract the real part

            Complex c = new Complex(real, 0.0);

            // pushing the just created element into the stack
            stack.push(c);
        } else if (matcherI.matches()) { // if the user input matches the fourth pattern
            imaginary = Double.parseDouble(matcherI.group(1)); // extract the imaginary part

            Complex c = new Complex(0.0, imaginary);

            // pushing the just created element into the stack
            stack.push(c);
        } else if (matcherRJ.matches()) { // if the user input matches the fifth pattern
            real = Double.parseDouble(matcherRJ.group(1)); // extract the real part

            // extracting the imaginary part
            char firstChar = matcherRJ.group(3).charAt(0);
            if (firstChar == '-') {
                imaginary = -1.0;
            } else {
                imaginary = 1.0;
            }

            Complex c = new Complex(real, imaginary);

            // pushing the just created element into the stack
            stack.push(c);
        } else if (matcherJR.matches()) { // if the user input matches the sixth pattern
            real = Double.parseDouble(matcherJR.group(2)); // extract the real part

            // extracting the imaginary part
            char firstChar = matcherJR.group(1).charAt(0);
            if (firstChar == '-') {
                imaginary = -1.0;
            } else {
                imaginary = 1.0;
            }

            Complex c = new Complex(real, imaginary);

            // pushing the just created element into the stack
            stack.push(c);
        } else if (matcherJ.matches()) { // if the user input matches the seventh pattern
            // extracting the imaginary part
            char firstChar = matcherJ.group(1).charAt(0);
            if (firstChar == '-') {
                Complex c = new Complex(0.0, -1.0);
                stack.push(c);
            } else {
                Complex c = new Complex(0.0, 1.0);
                stack.push(c);
            }
        } else {
            throw new NoMatchFoundException();
        }

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
     * @return A Matcher object created by using the "matcher" method of Pattern
     * and by passing the text contained in the text field (spaces excluded).
     */
    private Matcher createMatcher(Pattern pattern) {
        return pattern.matcher(patternString.replaceAll("\\s+", ""));
    }

}
