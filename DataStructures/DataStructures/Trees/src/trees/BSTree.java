/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author Shruthi Chari
 */
import java.util.Scanner;
public class BSTree 
{
    Node root;
    int number = 0;
    int leaves = 0;
    public BSTree()
    {
        root = null;
    }
    public Node create()
    {
        Scanner in = new Scanner(System.in);
        int key = 0;
        System.out.println("Enter a number");
        key = in.nextInt();
        Node add = new Node(key);
        return add;
    }
    public void insert()
    {
         Node add = create();
         if(root == null)
         {
             root = add;
         }
         else
         {
             Node temp = root;
             int found = 1;
             while(found == 1)
             {
                 if(add.key <= temp.key)
                 {
                     if(temp.left == null)
                     {
                         found = 0;
                         temp.left = add;
                     }
                     else
                     {
                        temp = temp.left;
                     }
                 }
                 else
                 {
                     if(temp.right == null)
                     {
                         found = 0;
                         temp.right = add;
                     }
                     else
                     {
                        temp = temp.right;
                     }
                 }
                 
             }
         }
    }    
    public void no_node(Node root)
    {
            if(root != null)
            {
                  no_node(root.left);
                  number++;
                  no_node(root.right);
            }
    }
    public void no_leafs(Node root)
    {
            if(root != null)
            {
                  no_leafs(root.left);
                  if((root.left == null) && (root.right == null))
                      leaves++;
                  no_leafs(root.right);
            }
    }
    public void display(Node root)
    {
            if(root != null)
            {
                  display(root.left);
                  System.out.print(root.key + " ");
                  display(root.right);
            }
    }
    int maxDepth(Node node)
    {
        if (node == null)
        {
            return (0);
        }
        else
        {
            // compute the depth of each subtree
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
            // use the larger one
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
}
