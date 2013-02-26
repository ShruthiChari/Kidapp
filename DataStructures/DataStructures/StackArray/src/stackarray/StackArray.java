/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackarray;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shruthi Chari
 */
public class StackArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner  in = new Scanner(System.in);
        System.out.println("Enter the size of the stack");
        int len = in.nextInt();
        Stack sc = new Stack(len);
        int choice = 0;
        while(choice >= 0 && choice <= 3)
        {
            System.out.println("Enter \n 1.Push \n 2.Pop \n 3.Peek");
            choice = in.nextInt();
            switch(choice)
            {
                case 1:
                {
                try {
                    sc.insert();
                } catch (Full ex) {
                    
                } catch (InputMismatchException ex) {
                    System.out.println("not an integer");
                }
                    break;
                }
                case 2:
                {
                try {
                        System.out.println("Element popped" + sc.pop());
                } catch (Empty ex) {
                    
                }
                break;
                    
                }
                case 3:
                {
                try {
                    sc.display();
                } catch (Empty ex) {
                    
                }
                break;
                }
            }
        }
    }
}
