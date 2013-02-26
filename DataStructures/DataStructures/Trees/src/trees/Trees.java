/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.Scanner;

/**
 *
 * @author Shruthi Chari
 */
public class Trees {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        BSTree tree = new BSTree();
        Scanner in = new Scanner(System.in);
        int choice = 0;
        while(choice <= 4 && choice >= 0)
        {
            System.out.println("Enter \n 1. Insert \n 2. Count leaves \n 3. Count nodes \n 4. Depth \n");
            choice = in.nextInt();
            switch(choice)
            {
                case 1:
                {
                    System.out.println("Inserting");
                    tree.insert();
                    break;
                }
                case 2:
                {
                    System.out.println("The number of enders are:");
                     tree.no_leafs(tree.root);
                     System.out.println(tree.leaves);
                     tree.display(tree.root);
                     System.out.println("\n");
                     tree.leaves = 0;
                     break;
                }
                case 3:
                {
                    System.out.println("The number of nodes are:");
                    tree.no_node(tree.root);
                    System.out.println(tree.number);
                    tree.number = 0;
                    break;
                }
                case 4:
                {
                    System.out.println("The maximum depth of the tree is:" + tree.maxDepth(tree.root));
                    break;
                }
            }
        }
    }
}
