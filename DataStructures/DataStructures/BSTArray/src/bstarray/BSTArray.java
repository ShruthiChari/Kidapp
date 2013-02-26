/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bstarray;

import java.util.Scanner;

/**
 *
 * @author Shruthi Chari
 */
public class BSTArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of the tree");
        int len = in.nextInt();
        BArray b = new BArray(len);
        int choice = 0;
        while(choice >= 0 && choice <= 2)
        {
            System.out.println("Enter 1. Insert \n 2. Display \n");
            choice = in.nextInt();
            switch(choice)
            {
                case 1:
                {
                    b.insert();
                    break;
                }
                case 2:
                {
                    b.inorder(0);
                    //b.display();
                    break;
                }
            }
        }
        
    }
}
