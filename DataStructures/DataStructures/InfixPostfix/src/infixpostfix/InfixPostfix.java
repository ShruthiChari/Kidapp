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
public class InfixPostfix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter expression");
        String exp = in.next();
        InPosConvert pos = new InPosConvert(exp);
        pos.display();
        pos.evaluate();
    }
}
