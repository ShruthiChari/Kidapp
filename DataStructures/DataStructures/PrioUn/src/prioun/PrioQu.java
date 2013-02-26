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
public class PrioQu
{
    Node head;
    public PrioQu()
    {
        head = null;
    }
    public Node create()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the priority and info");
        int prio = in.nextInt();
        int info = in.nextInt();
        Node add = new Node(prio, info);
        return add;
    }
    public void frontins()
    {
        Node add = create();
        if(head == null)
            head = add;
        else
        {
            add.next = head;
            head = add;
        }
            
    }
    public int priodel()
    {
        Node temp = head;
        if(temp == null)
        {
            System.out.println("Enp");
            return -1;
        }
        else
        {
            int found = 0; 
            Node check = temp;
            temp = temp.next;
            Node prev = temp;            
            while(temp != null)
            {
                if(temp.prio <= check.prio)
                {
                    check = temp;
                }
                temp = temp.next;
            }
            if(check == head)
            {
                head = head.next;
                return check.info;
                
                
            }
            else
            {
                temp = head;
                Node pre = check;
                while(temp != check)
                {
                    prev = temp;
                    temp = temp.next;
                }
                prev.next = check.next;
                temp = null;                
                return check.info;
            } 
                   
        }
        
            
            
    }
    public void display()
    {
        if(head == null)
            System.out.println("E");
        else
        {
            Node temp = head;
            while(temp != null)
            {
                System.out.println(temp.info + "Prio " + temp.prio);
                temp = temp.next;
            }
        }
    }
    
}
