/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackarray;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Shruthi Chari
 */
public class Stack 
{
    int n;
    int[] stack;
    int tos;
    public Stack(int n)
    {
        this.n = n;
        stack = new int[n];
        tos = -1;
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
            System.out.println("Enter an element to push:");
            int key = in.nextInt();
            stack[++tos] = key;
            
        }
    }
    public boolean isFull()
    {
        if(tos == (n-1))
            return true;
        return false;
    }
    public boolean isEmpty()
    {
        if(tos == -1)
            return true;
        return false;
    }
    public int pop()throws Empty
    {
        if(isEmpty())
        {
            throw new Empty();
        }
        else
        {
            return stack[tos--];
        }
    }
    public void display()throws Empty
    {
        if(tos == -1)
        {
            throw new Empty();
        }
        else
        {
            int i = 0;
            System.out.println("Gosh I have to still pop these many elements :(");
            for(i = 0; i <= tos;i++)
            {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
    
}
