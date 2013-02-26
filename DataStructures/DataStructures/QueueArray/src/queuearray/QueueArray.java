/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queuearray;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shruthi Chari
 */
public class QueueArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of your queue");
        int len = in.nextInt();
        Queue q = new Queue(len);
        int choice = 0;
        while(choice >= 0 && (choice <= 3))
        {
            System.out.println("Enter \n 1.Add request from end \n 2.Service initial request \n. 3.Peep ");
            choice = in.nextInt();
            switch(choice)
            {
                case 1:
                {
                    try {
                        q.insert();
                    } catch (Full ex) {

                    } catch (InputMismatchException ex) {
                        System.out.println("NaI");
                    }
                    break;
                
                }
                case 2:
                {
                    try {
                        System.out.println("Request being serviced is : " + q.delete());
                    } catch (Empty ex) {
                        
                    }
                    break;
                }
                case 3:
                {
                    System.out.println("The contents of the queue still are");
                    try {
                        q.display();
                    } catch (Empty ex) {
                        
                    }
                    break;
                }
            }
                
        }
    }
}
