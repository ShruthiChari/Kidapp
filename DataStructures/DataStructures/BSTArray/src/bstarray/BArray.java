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
public class BArray 
{
    int n;
    Node[] treearr;
    private int ctr = 0;
    public BArray(int n)
    {
        this.n = n;
        treearr = new Node[n];
        for(int i = 0; i < treearr.length; i++)
        {
            treearr[i] = new Node();
        }  
          
    }
    public Node create()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number that the node holds");
        int num = in.nextInt();
        Node add = new Node(num);
        return add;
    }
    public void insert()
    {
        
        Node add = create();        
        if(ctr == 0)
        {
            treearr[ctr] = add;
            treearr[ctr].used = true;
            ctr++;
        }
        else if(ctr != treearr.length)
        {
            boolean set = true;
            int p = 0;
            while(set)
            {
                if(add.info <= treearr[p].info)
                {
                    if(treearr[(2*p) + 1].used == false)
                    {
                        p = (2*p) + 1;
                        treearr[p] = add;
                        treearr[p].used = true;
                        set = false;
                        ctr++;
                    }
                    else
                    {
                        p = (2*p) + 1;
                    }
                }
                else
                {
                    if(treearr[(2*p) + 2].used == false)
                    {
                        p = (2*p) + 2;
                        treearr[p] = add;
                        treearr[p].used = true;
                        set = false;
                        ctr++;
                    }
                    else
                    {
                        p = (2*p) + 2;
                    }
                }
            }
        }
    }
    public void inorder(int t)
    {
        while((t <= (treearr.length - 1)) && (treearr[t].used != false))
        {
            inorder((t*2) + 1);
            System.out.println(treearr[t].info);
            inorder((t*2) + 2);
        }
    }
    public void display()
    {
        for(int i = 0; i < treearr.length;i++)
        {
            System.out.println(treearr[i].info);
        }
    }
    
    
}
