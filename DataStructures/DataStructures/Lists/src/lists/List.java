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
public class List 
{
    Node head;
    Node traverse;
    public List()
    {
        head = null;
    }
    int count = 0;
    public int counttrav(Node temp)
    {
        while(temp != null)
        {
            System.out.print(count++);
            
            counttrav(temp.next);
         
            
        }
        if(temp == null)
             return 0;
        else
            return count;
    }
    public Node create()
    {
        Scanner in = new Scanner(System.in);
        System.out.append("Enter the info");
        int info = in.nextInt();
        Node add = new Node(info);
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
    public void reverse()
    {
        List rev = new List();
        Node temp = this.head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        rev.head = rev.traverse = temp;
        Node rem = temp;
        //temp = this.head;
        while(rem != null && rem != this.head )
        {
            Node tra = this.head;
            while(tra.next != rem)
            {
                tra = tra.next;
            }
            rev.traverse.next = tra;
            rev.traverse = tra;
            rem = tra;
        }
        rev.traverse.next = rem;
        rev.traverse.next.next = null;
        rev.display();
    }

    public void display() {
        if(head == null)
            System.out.println("Empty List");
        else
        {
            Node temp = head;
            while(temp != null)
            {
                System.out.print(temp.info + " ");
                temp = temp.next;
            }
        }
    }
        
}
