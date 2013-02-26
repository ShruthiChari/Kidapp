/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infixpostfix;

import java.util.Scanner;

/**
 *
 * @author Shruthi Chari
 */
public class InPosConvert
{
    //character stack,integer stack
    String infix;
    char[] exstack;
    int[] evstack;
    int tosexp;
    int toseva;
    char[] output;
    private int out;
    public InPosConvert(String  infix)
    {
        this.infix = infix;
        exstack = new char[infix.length()];
        evstack = new int[infix.length()];
        tosexp  = toseva =  -1; 
        output = new char[infix.length()]; 
        
        
    }
    public void pushex(char ch)
    {
        if(tosexp <= (infix.length() -1))
        {
            exstack[++tosexp] = ch;
            
        }
        else
        {
            System.out.println("Stack Overflow");
        }
    }
    public char popex()
    {
        if(tosexp != -1)
        {
            return exstack[tosexp--];
        }
        else
        {
           return '\n';
        }
    }
    public void pushev(int ch)
    {
        if(toseva <= (infix.length() -1))
        {
            evstack[++toseva] = ch;
            
        }
        else
        {
            System.out.println("Stack Overflow");
        }
    }
    public int popev()
    {
        if(toseva != -1)
        {
            return evstack[toseva--];
        }
        else
        {
           return -1;
        }
    }
    public void convert()
    {
        char inf[] = infix.toCharArray();
        
        for(int i = 0; i < inf.length; i++)
        {
            if(isAlpha(inf[i]))
            {
                output[out++] = inf[i];
            }
            else if(isNum(inf[i]))
            {
                output[out++] = inf[i];
            }
            else if(isOpeningParantheses(inf[i]))
            {
                pushex(inf[i]);
            }
            else if(isOperator(inf[i]))
            {
                char ch = 'a';
                if(tosexp == -1)
                {
                    pushex(inf[i]);
                }
                else if((precedence(inf[i]) >= precedence(exstack[tosexp])) || (isOpeningParantheses(exstack[tosexp])))
                {
                         pushex(inf[i]);   
                 }
                else
                {
                    while((tosexp != -1) && ((ch = popex()) != '\n') && (precedence(inf[i]) < precedence(exstack[tosexp])) || (!isOpeningParantheses(exstack[tosexp])) )
                    {
                        output[out++] = ch;
                    }
                    pushex(inf[i]);
                }
            }
            else if(isClosingParantheses(inf[i]))
            {
                char ch ='a';
                while((ch = popex()) != paramatch(inf[i]))
                {
                    output[out++] = ch;
                }
                
                    
            }
        }
        if(tosexp != -1)
        {
            char ch = 'b';
            while((ch = popex()) != '\n')
            {
                output[out++] = ch;
            }
        }
        
    }
    private int precedence(char ch)
    {
        if(ch == '+' || ch == '-')
            return 1;
        else if(ch == '*')
            return 2;
        else if(ch == '/')
            return 3;
        else if(ch == '%')
            return 4;
        else
            return 0;
    }
    private boolean isAlpha(char c)
    {
        if((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A'))
        {
            return true;
        }
        return false;
    }

    private boolean isOpeningParantheses(char c) 
    {
        if(c == '(' || c == '{' || c == '[')
            return true;
        return false;
    }
    private boolean isOperator(char c) 
    {
       if(c == '*' || c == '+' || c == '+' || c == '-' || c == '/' || c == '%')
           return true;
       return false;
        
    }

    private boolean isClosingParantheses(char c) 
    {
        if(c == ')' || c == '}' || c == ']')
            return true;
        return false;
        
    }

    private char paramatch(char c)
    {
        if(c == ')')
            return '(';
        else if(c == ']')
            return '[';
        else if(c == '}')
            return '{';
        else
            return 'a';
    }
    public void display()
    {
        convert();
        for(int i = 0; i < out;i++)
        {
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }

    private boolean isNum(char c) 
    {
        if(c <= '9' && c >= '0')
            return true;
        return false;
        
    }
    public void evaluate()
    {
        
        //convert();
        Scanner in = new Scanner(System.in);
        int store = 0;
        int result = 0;
        for(int i = 0; i < out;i++)
        {
            if(isAlpha(output[i]))
            {
                System.out.println("Enter the value for" + output[i]);
                store = in.nextInt();
                pushev(store);
            }
            else if(isNum(output[i]))
            {
                store = Character.digit(output[i],10);
                pushev(store);
            }
            else if(isOperator(output[i]))
            {
                int a = 0;                
                
                    a = popev();
                
                    store = popev();
                result = operation(store,a,output[i]);
                pushev(result);
                
                
            }
        }
        System.out.println("The result of the expression is" + popev());
    }

    private int operation(int store, int a, char c)
    {
        int res = 0;
        if(c == '+')
        {
            res = store + a;
        }
        else if(c == '-')
        {
               res = store - a;
        }
        else if(c == '/')
        {
            if(a != 0)
            {
                res = store/a;
            }
            else
                System.out.println("Division by zero ");
        }
        else if(c == '%')
        {
            if(a != 0)
            {
                res = store%a;
            }
            else
                System.out.println("Division by zero ");
        }
        else if(c == '*')
        {
            res = store*a;
            
        }
        return res;
            
    }
    
            
}
