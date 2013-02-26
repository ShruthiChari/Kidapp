/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prioun;

import java.util.Scanner;

/**
 *
 * @author Shruthi Chari
 */
public class PrioUn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);        
        PrioQu list = new PrioQu();
        int choice = 0;
        while(choice >= 0 && choice <= 3)
        {
            System.out.println("Enter 1. Insert \n 2. Del \n");
            choice = in.nextInt();
            switch(choice)
            {
                case 1:
                {
                    list.frontins();
                    break;
                }
                case 2:
                {
                    System.out.println("Being serviced" + list.priodel());
                    //b.display();
                    break;
                }
                case 3:
                {
                    list.display();
                    break;
                }
            }
        }
        //list.reverse();
        
    }
}
