/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queuearray;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Shruthi Chari
 */
public class Queue 
{
    int len;
    int size;
    int[] queue;
    int front,rear;
    public Queue(int len)
    {
        this.len = len;
        queue = new int[len];
        size = 0;
        front = rear = -1;
    }
    public boolean isFull()
    {
        if((rear == (len - 1)))// && (front == 0))
            return true;
        return false;
    }
    public boolean isEmpty()
    {
        if(front > rear)
            return true;
        return false;
    }
    public void insert()throws Full,InputMismatchException
    {
        if(isFull())
        {
            throw new Full();
        }
        else
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter a key");
            int key = in.nextInt();
            if(front == -1 && rear == -1)
            {
                front++;
                rear++;
                queue[rear] = key;
                size++;
            }
            else
            {
                queue[++rear] = key;
                size++;
            }
                    
        }
    }
    public int delete()throws Empty
    {
        if(isEmpty())
            throw new Empty();
        else
        {
            size--;
            return queue[front++];
        }
    }
    public void display()throws Empty
    {
        if(isEmpty())
            throw new Empty();
        else
        {
            for(int i = front; i <= rear; i++)
                System.out.print(queue[i] + " ");
            System.out.println();
        }
            
        
    }
    
}
