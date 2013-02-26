/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circularqueuearray;

/**
 *
 * @author Shruthi Chari
 */
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class CircQueue
{
    int n;
    int size;
    int[] cqueue;
    int front,rear;
    public CircQueue(int n)
    {
        this.n = n;
        size = 0;
        cqueue = new int[n];
        rear = front = -1;
    }
    public boolean isFull()
    {
        if((front == ((rear + 1)%n)) && (size != 0))
            return true;
        return false;
    }
    public boolean isEmpty()
    {
        if((size == 0) || (front == -1 && rear == -1))
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
            System.out.println("Enter a integer");
            Scanner in = new Scanner(System.in);
            int key = in.nextInt();
            if((front == -1) && (rear == -1))
            {
                front++;
                rear++;
                cqueue[front] = key;
                size++;
            }
            else
            {
                rear = (rear + 1)%n;
                cqueue[rear] = key;
                size++;
                
            }
        }
    }
    public int delete()throws Empty
    {
        if(isEmpty())
        {
            throw new Empty();
        }
        else
        {
            int temp = cqueue[front];
            front = (front + 1)%n;
            size--;
            return temp;
        }
    }
    public void display()throws Empty
    {
        if(isEmpty())
            throw new Empty();
        else
        {
            int i = 0;
            System.out.println("The requests with us");
            int ctr = 0;
            for(i = front; ctr < size;i = ((i + 1)%n))
            {
                System.out.print(cqueue[i] + " ");
                ctr++;
            }
            System.out.println();
        }
    }
}
