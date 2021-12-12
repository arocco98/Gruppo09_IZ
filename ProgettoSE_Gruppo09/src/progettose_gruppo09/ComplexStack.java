package progettose_gruppo09;

import java.util.ArrayList;

/**
 * This class implements a data structure having a stack behavior
 *
 * @author gruppo09
 */
public class ComplexStack extends ArrayList<Complex> implements Stack<Complex> {

    /**
     * Construct a new Stack object
     */
    public ComplexStack() {
        super();
    }

    /**
     * Function to push a Complex onto the stack
     *
     * @param a complex value you want to put on the stack
     */
    @Override
    public void push(Complex a) {

        this.add(a);
    }

    /**
     * Function for picking an item from the stack
     *
     * @return item taken from the stack
     */
    @Override
    public Complex pop() {

        if (!this.isEmpty()) {
            Complex element = this.remove(this.size() - 1);
            return element;
        } else {
            return null;
        }

    }

    /**
     * Function to display the last element of the stack
     *
     * @return Element that you want to check out, without deleting it, from the
     * stack
     */
    @Override
    public Complex peek() {

        if (!this.isEmpty()) {
            Complex element = this.get(this.size() - 1);

            return element;
        } else {
            return null;
        }

    }

    /**
     * Function to view the contents of the stack
     *
     * @return String containing all stack values
     */
    @Override
    public String toString() {
        String vals = "";

        for (int i = this.size() - 1; i >= 0; i--) {
            vals = vals + this.get(i).toString() + "\n";
        }

        return vals;
    }

}
