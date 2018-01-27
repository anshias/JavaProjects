/*
 A quick lesson in how the modulus works if any of the arguments in a % b are negative. 
 */
package javareview;


public class Mod_with_negative_arguments {
    
    public static void main(String[] args) {
        
   
    System.out.println("Finding a%b when one of the arguments is negative."); // Note we do not need to double % here because it is not a  format string. 
    System.out.println("In a%b, just as in a/b;  a is the dividend, and b is the divisor."); 

    
    System.out.println("\nRule 1. The sign of the result equals the sign of the dividend.");
    System.out.print("\tExample   i. -2 % 3 = - (2 % 3) = -2");      System.out.println("\tCheck:  -2 % 3 = " +  (-2) % 3 );
    System.out.print("\tExample  ii. -5 % 3 = - (5 %3 ) = -2");      System.out.println("\tCheck:  -5 % 3 = " +  (-5) % 3 );

    
    System.out.println("\nRule 2. The sign of the divisor has no effect on the result. ");
    System.out.print("\tExample   i. 2 % -3 = 2 % 3 = 2");      System.out.println("\t\tCheck:  2 % -3 = " +  (2 %(-3) ) );
    System.out.print("\tExample  ii. -2 % -3 = -2 % 3 = -2");      System.out.println("\tCheck:  -2 % -3 = " +  (-2) % (-3)  );


    System.out.println("\nRule 3. The divisor cannot be zero.");
    System.out.println("Attempting 2 % 0.");
    int result;
    try 
        { result = 2 % 0; 
        System.out.println("The result for (2 % 0) is: " + result ) ;
        }
    catch(ArithmeticException e) 
        {   System.out.println( "Could not compute! The error message is: " + e.getMessage() );   }
    
  
    } // end of main
   
} // end of class
