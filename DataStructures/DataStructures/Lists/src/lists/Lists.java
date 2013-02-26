/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.util.Scanner;

/**
 *
 * @author Shruthi Chari
 */
public class Lists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);        
        List list = new List();
        int choice = 0;
        while(choice >= 0 && choice <= 2)
        {
            System.out.println("Enter 1. Insert \n 2. Display \n");
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
                    list.display();
                    //System.out.println("The number of nodes  are:" + list.counttrav(list.head));
                    list.count = 0;
                    //b.display();
                    break;
                }
            }
        }
        list.reverse();
        
    }
    int count = 0;
    
}
