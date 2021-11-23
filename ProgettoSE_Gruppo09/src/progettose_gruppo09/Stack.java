/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettose_gruppo09;

import java.util.ArrayList;

/**
 *
 * @author andrearocco
 */

public class Stack extends ArrayList<Complex>{

    private int index;
    
    public Stack() {
        super();
        this.index = 0;
    }

    /**
     * Function to push a Complex onto the stack
     * @param a complex value you want to put on the stack
     */
    public void Push(Complex a) {

        this.add(a);
        this.index++;
    }

    /**
     * Function for picking an item from the stack
     * @return item taken from the stack
     */
    public Complex Pop() {
        
        if (!this.isEmpty()) {
            Complex element = this.remove(this.index - 1);
            this.index--;
            
            return element;
        }else{
            return null;
        }
     
    }
    
    /**
     * Function to display the last element of the stack
     * @return Element that you want to check out, without deleting it, from the stack
     */
    public Complex Peek(){
        
        if (!this.isEmpty()) {
            Complex element = this.get(this.index - 1);

            return element;
        }else{
            return null;
        }
        
    }

    /**
     * Function to view the contents of the stack
     * @return String containing all stack values
     */
    @Override
    public String toString() {
        String vals = "";

        for (int i = this.size() - 1; i >= 0; i--){
            vals = vals + this.get(i).toString() + "\n";
        }
        
        return vals;
    }

}
