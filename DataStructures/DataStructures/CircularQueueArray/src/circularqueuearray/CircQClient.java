/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circularqueuearray;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shruthi Chari
 */
public class CircQClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        int length = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of the queue you want :");
        length = in.nextInt();
        CircQueue cq = new CircQueue(length);
        int choice = 0;
        while(choice >= 0 && (choice <= 3))
        {
            System.out.println("Enter \n 1. Push request onto Queue \n 2. Pull request from the front end \n 3. Display");
            choice = in.nextInt();
            switch(choice)
            {
                case 1:
                {
                    
                    try 
                    {
                        cq.insert();
                    } 
                    catch (Full ex)
                    {

                    } 
                    catch (InputMismatchException ex) 
                    {
                        System.out.println("Sorry Wrong Type entered not an integer");
                    }
                    break;
                }
                case 2:
                {
                    try 
                    {
                        System.out.println("Servicing request:" + cq.delete());
                    } 
                    catch (Empty ex)
                    {
                        
                    }
                    break;
                }
                case 3:
                {
                    try 
                    {
                        cq.display();
                    }
                    catch (Empty ex)
                    {

                    }
                    break;
                }
                 
            }
        }
        
    }
}
