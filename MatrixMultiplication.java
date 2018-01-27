/*
 * Reviews multi-dimensional arrays. See chapter 7. 
 */
package javareview;

import java.util.Scanner;
import java.util.Random; // To be used later


public class MatrixMultiplication {
// Some class variables.   
public static Scanner keyboard = new Scanner(System.in);
    
  public static void main(String[] args) {
      
     printIntroduction();
     
     boolean done = false; 
     while( ! done ) {  // While loop allows repeated matrix multiplications. 
         
      System.out.println("\nReady to select two matrices to multiply. Or, type Q to quit program.");
      System.out.print("Multiply more matrices (any key) or Quit (Q)? : ");

     String sentinelValue = "Q";
     String userTerminationInput =  keyboard.nextLine().toUpperCase(); // Type Q to quit. 
     
     if ( userTerminationInput.equals(sentinelValue) )  
         { System.out.println("OK, Done with matrix multiplication. Bye!");  System.exit(0); } // Done and bye!
     
     
     // MANUAL ENTRY OR PRESET??
     // Once your matrix multiplication method is working, add if statement here to allow manual or preset matrices. 
     System.out.println("Type M is you wish to enter the matrices MANUALLY. Any other key selects the PRESET matrices A and B.");
     System.out.printf("Use PRESET matrices (any key) or enter MANUALLY (M)? :");

     String userResponse =  keyboard.nextLine(); // MANUAL entry or PRESET matrices. 
     
     // Declare, but do not initialize, two matrices A and B. These are actually 2D arrays. 
     double [][] A ;
     double [][] B ;

      
     // Manual entry of matrices has been chosen. 
  
     if( userResponse.toUpperCase().equals("M") )  {
     
    
      // 1. Enter the matrix A. 
     System.out.println("First enter the m*n matrix A.");
     A = enterMatrix();
    
     System.out.println("\nYou have entered the following matrix.");
     printMatrix(A);
     
      // 2. Enter the matrix B. 
     System.out.println("\nNow enter the n*p matrix B.");
     B = enterMatrix();
     
     System.out.println("\nYou have entered the following matrix.");
     printMatrix(B);
     } // end of if block for MANUAL entry
     
     // Otherwise, use default PRESET matrices A and B defined here. 
     else{
           // Preset matrices for Part c. 
           A = new double[][] { {1, 2, 3}, {4, 5, 6} }; // Note the new keyword and declaration on the RHS is needed!
           B = new double[][] { {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1} } ;
           
           // Preset matrices for Part d.  (Product is undefined.)
           // A = new double[][] { {1, 2, 3}, {4, 5, 6} };
           // B = new double[][] { {1, 2, 3}, {4, 5, 6} };    // A = B so we attempt a square.      
     } // end of else block for PRESETS
     
     
     
     // 3. Find and print out the product matrix C = A * B.
     // Insert missing code here. 
     
     // Checks if inner dimensions match.
     try {   double[][] C = matrixMultiply(A,B);   
             System.out.println("\nThe matrix product AB is:\n");
             printMatrix(C);}   
    
     catch (RuntimeException e) {  System.out.println("\n\nSorry, A*B is not defined.");
        System.out.println(e.getMessage());  }

   
    
     } // end of while loop to enable multiple matrix products.   
      
  }  // end of main
  
  
  
  
  // Prints an initial message when the program first starts. 
public static void   printIntroduction() {
    System.out.println("\nThis program finds the product of two matrices A and B.");
    System.out.println("Matrix multiplication is only defined if the inner dimensions match.\n");
} // end of printIntroduction
  
 
// A method to enter a rectangular matrix at the keyboard. 
public static double[][] enterMatrix() {
    System.out.println("How many rows does this matrix have?");
    System.out.print("Number of rows: ");
    int numberOfRows = keyboard.nextInt();
    
    System.out.println("How many columns does this matrix have?");
    System.out.print("Number of columns: ");
    int numberOfColumns = keyboard.nextInt();
    
    double[] nextRow = new double[numberOfColumns]; // Not used.
    double[][] myMatrix = new double[numberOfRows][numberOfColumns];

    
    System.out.println("OK, we will enter one row at a time starting at the top. Example: 1.1 2.0 3.1");

    for( int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) {
        
    System.out.printf("Enter row %d: ", rowNumber );
    
    for(int columnNumber =1; columnNumber <= numberOfColumns; columnNumber++ ) {
        double nextElement = keyboard.nextDouble();
        nextRow[columnNumber-1]  = nextElement; // Build up the next row. 
        myMatrix[rowNumber-1][columnNumber-1] = nextElement;
    } // end of inner for loop
        
    } // end of outer for loop
    
   // Please add this line of code just before the return myMatrix statement.  
   String cleanUp = keyboard.nextLine(); // Cleanup any remaining newLine character. 

   return myMatrix; // Returns the matrix the user has entered
    
} // end of enterMatrix


// Prints a matrix of doubles.
public static void printMatrix(double [][] C) {
    
int rowsC= C.length;
    for ( int i = 0; i < rowsC; i++ ) {
        System.out.printf("| ");
        for ( double number : C[ i ] )
            System.out.printf( "%6.2f", number );
        System.out.println(" |");
} // end of printing for loop block
    
} // end of method printMatrix.



// Prints a matrix of integers. Not used
public static void printMatrix(int [][] C) {
    
int rowsC= C.length;
    for ( int i = 0; i < rowsC; i++ ) {
        System.out.printf("| ");
        for ( int number : C[ i ] )
            System.out.printf( "%3d", number );
        System.out.println(" |");
} // end of printing for loop block
    
} // end of method printMatrix.




// Generates a random matrix of integers. Not used. 
public static int[][] randomMatrix(int m, int n) {
/* Returns an mxn rectangular matrix  whose elements
 are given by the following random generator. 
 Each element is equally likely to be -1, 0 or +1. 
*/
    Random randomGenerator = new Random();
    int[][] theRandomMatrix = new int[m][n];
    for(int i=0;i<m;i++) for(int j=0;j<m;j++)
        theRandomMatrix[i][j] =-1 + randomGenerator.nextInt(3);
    return theRandomMatrix;
} // end of method randomMatrix




// Complete this method to multiply two matrices. 
// Warning this method is just a stub. You must add triple-nested for loops. 
public static double[][] matrixMultiply(double[][] A, double[][] B) throws RuntimeException {
// Record the matrix dimensions.
    
    int rowsA= A.length;
    int columnsA= A[0].length;
    int rowsB= B.length;
    int columnsB= B[0].length;

    if (columnsA !=  rowsB)   throw new RuntimeException("The inner matrix dimensions must match.");

    
    /* Declare but do not initialize C.
     Specify its dimensions using those of A and B. */
    double[][] C = new double[rowsA][columnsB] ;
    
    // ADD CODE HERE
    // Insert a triple-nested for loop here.
    
  
   for ( int i = 0; i < rowsA; i++ )
        for ( int j = 0; j < columnsB; j++ )
            
            // 4. Set Cij to zero.
        {
            C[i][j] = 0;
            for ( int k = 0; k < columnsA; k++ )
                
                //5. Multiply the two matrices by correcting the line below.
                
                C[i][j] += A[i][k] * B[k][j];
        } // end of for loop block
    
    return C;
    
    
    
    

} // end of method matrixMultiply


    
}  // end of class
