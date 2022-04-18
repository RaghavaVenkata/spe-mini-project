package calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class Calculator {
    // creating a public class of the calculator function.
    
    public static final Logger logger = LogManager.getLogger(Calculator.class);
    // creating a public caluclator
    
    public Calculator() {}

    public static void main(String[] args) 
    {
        Calculator cal = new Calculator();   
        Scanner scanner = new Scanner(System.in); 
        double a, b; // double a (for first input ), and b (for second input)

        do{
            System.out.println("Calcuator");
            // printing calculator
            System.out.println("Ava functions\n1 - Sqr Root of x\n2 - Fact of x\n3 - N Log of x\n4 - x Power b\nAny other number to exit");
            //print avalible function ,square root,factorial,natrual log  
            int function;

            try
            {
                function = scanner.nextInt();
            } catch (InputMismatchException error) 
            
            {   // checking weather input is correct or wrong
                return;
            }

            if (function < 1 || function > 4)
            {   // checking function range
                return;
            }

            try
            {   // entering the first value 
                System.out.println("Enter value x");
                a = scanner.nextDouble();
            } catch (InputMismatchException error) 
            {   // checking weather input is correct or wrong
                return;
            }

            if(function == 1)
            {   // Square root of the x
                System.out.println("Sqr root of x = " + cal.sqt(a));
                break;
            }
            
            else if(function == 2)
            {   // Factorial root of the x 
                System.out.println("Fact of x =" + cal.factorial(a));
                break;
            }
            
            else if(function == 3)
            {   // Natural log of the x 
                System.out.println("N log of x =" + cal.log(a));
                break;
            }
            
            else if(function == 4)
            {
                try 
                {   // entering the second value
                    System.out.print("Enter b");
                    b = scanner.nextDouble();
                } catch (InputMismatchException error)
                {   // checking weather input is correct or wrong
                    return;
                }
                System.out.println("x power b = " + cal.power(a, b));
                break;
            }
            else
            {   // printing closing
                System.out.print("Closing");
                return;
            }
        }while(true);
    }


    public static double sqt(double i){
        
        double temp = 0;
        
        try {
            logger.info("[SQRT] - " + i);
            // if the value is less than 1
            if (i < 0) 
            { //printing Cannot find sqrt of -ve numbers
                temp = Double.NaN;
                throw new ArithmeticException("ERROR of find square root of -ve numbers");
            } 
            else 
            {
                temp = Math.sqrt(i);
            }
        } catch (ArithmeticException error)
        { //printing error Cannot find sqrt of -ve numbers
            logger.error("[EXCEPTION - SQRT] - ERROR Cannot find sqrt of -ve numbers");
        } finally 
        { // printing results
            logger.info("[RESULT - SQRT] = " + temp);
        }
        return temp;
    }

    public static double factorial(double i)
    {
        logger.info("[FACTORIAL] - " + i );
        double temp = 1.0;
        for (int t = 1; t<= i; t++)
        {
            temp *= t;
        }
        logger.info("[RESULT - FACTORIAL] = " + temp); // printing the factorial results
        return temp;
    }
    public static double log(double i)
    {
        Double temp = 0.0;
        try {
            logger.info("[LOG] - " + i);
            if (i < 0)
            {   //printing Cannot find N Log of -ve numbers
                temp = Double.NaN;
                throw new ArithmeticException("ERROR: Can't find log of negative numbers");
            }
            else if (i == 0)
            {   //printing Cannot find N Log of 0 numbers
                temp = Double.NEGATIVE_INFINITY;
                throw new ArithmeticException("Log of 0 is negative infinity");
            }
            else 
            {
                temp = Math.log(i);
            }
        } catch (ArithmeticException error)
        {   //printing ERROR Cannot find N Log  of lessthan or equal to zero numbers
            logger.error("[EXCEPTION - log] - ERROR :inout is less than or equal to zero");
        } finally 
        {   // printing the Result
            logger.info("[RESULT - LOG] = " + temp);
        }
        return temp;
    }
    public static double power(double i, double j)
    {   // checking the power of given input
        logger.info("[POWER] - " + i + ", " + j );
        double temp = Math.pow(i,j);
        logger.info("[RESULT - POWER] = " + temp);
        return temp;
    }

}
