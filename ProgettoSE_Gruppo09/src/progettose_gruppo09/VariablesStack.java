package progettose_gruppo09;

import java.util.ArrayList;

/**
 *
 * @author gruppo09
 */
public class VariablesStack extends ArrayList<Variables> implements Stack<Variables> {

    /**
     * Construct a new VariablesStack object
     */
    public VariablesStack() {
        super();
    }

    /**
     * Function to push a Variables object onto the stack
     *
     * @param a Variables object you want to put on the stack
     */
    @Override
    public void push(Variables a) {
        this.add(a);
    }

    /**
     * Function for picking an item from the stack
     *
     * @return Item taken from the stack
     */
    @Override
    public Variables pop() {
        if (!this.isEmpty()) {
            Variables element = this.remove(this.size() - 1);
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
    public Variables peek() {
        if (!this.isEmpty()) {
            Variables element = this.get(this.size() - 1);

            return element;
        } else {
            return null;
        }
    }

}
