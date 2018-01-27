
package javareview;

import java.util.ArrayList;
import java.util.Random;


public class IdempotentMatrixExperiment {
    
 public static void main(String[] args) {
 System.out.println("NUMERICAL EXPERIMENT TO FIND IDEMPOTENT MATRICES!\n");
  
 // Find   all the 2x2 matrices  of the form specified in the PDF which are idempotent. 
 // Find the total number of these so-called idempotent matrices.   

// Use a for loop to do this. 
// Drop each "find" into an ArrayList as a String! 
// Don't add it if it is already there!  No repeats. 
      
   ArrayList<String> foundMatrices = new ArrayList<>(); // Holds one copy of each matrix that has been discovered. 
   int numberFound = 0; 
   
   // Let's add an outer for loop, so we can perform many experiments at teh same time. 

   
   for( int n = 0; n <=10; n++)  {
       
    System.out.println("\nStarting next larger rectangular region, with max n equal to: " + n);

   for(int k = 0; k<1000000; k++) {  // Upgraded to two million iterations per experiment.
         
     //   int[][] A =genMatrix(); // Generates a random matrix of specified form. 
     int[][] A =genMatrix(-n, n); // Generates a random matrix with corefficients from -n to +n. 
     
     
     
       int[][] B =  matrixMultiply(A, A); // Find its square. 
       
       // The matrix is idempotent if and only if A*A = A. That is, A = B
       
       boolean isIdempotent = (A[0][0]== B[0][0]) && (A[0][1]== B[0][1]) && (A[1][0]== B[1][0]) && (A[1][1]== B[1][1]) ;
      
       if(isIdempotent) 
           {    
               // Add the idempotent matrix, but only if it has not already been added. No duplicates!
              if( ! foundMatrices.contains( matrixToString(A)) ) 
                  { numberFound++;
                    System.out.println("Matrix # " + numberFound); printMatrix(A); 
                    foundMatrices.add( matrixToString(A) ) ;}
           } // end of if block 


   } // end of for loop
            
// System.out.println("The total number of idempotent matrices found was: " + foundMatrices.size() );
System.out.printf("\nWith coefficients from %3d to %3d, the number of idempotent matrices found was %3d\n", -n, n, foundMatrices.size() );



   } // end of added outer for loop. 
   
   
// This added method summarizes the results of the experiment. 
printSummary();

      
  }  // end of main
   
  
    
  public static int[][] genMatrix() {
   int[][] A = new int[2][2]; 
   Random rg = new Random(); // Use rg and the nextInt command, to adjust the values below so they are random. 
   
   // These values are just default stub values.
   //a. Adjust so the elements are randomly chosen from the three values {-1, 0, 1}. 
   A[0][0] = +1;
   A[0][1] = 0;
   A[1][0] = 0;
   A[1][1] = +1;
   // Let's replace the above stubs with these three random values. 
   A[0][0] = -1 + rg.nextInt(3);
   A[0][1] = -1 + rg.nextInt(3);
   A[1][0] = -1 + rg.nextInt(3);
   A[1][1] = -1 + rg.nextInt(3);
  
 
   
   // b. Comment out the above values. Then adjust so the elements are randomly chosen from the five values {-2, -1, 0, 1, 2}. 
   // You can comment out the previous code, so it will remain ready for later. 
   A[0][0] = -2 + rg.nextInt(5);
   A[0][1] = -2 + rg.nextInt(5);
   A[1][0] = -2 + rg.nextInt(5);
   A[1][1] = -2 + rg.nextInt(5);
   
   // c. Adjust so the elements are randomly chosen from the seven values {-3, -2, -1, 0, 1, 2, 3}. 
   // You can comment out the previous code, so it will remain ready for later. 
   A[0][0] = -3 + rg.nextInt(7);
   A[0][1] = -3 + rg.nextInt(7);
   A[1][0] = -3 + rg.nextInt(7);
   A[1][1] = -3 + rg.nextInt(7);
   
   // d. Adjust so the elements are randomly chosen from the seven values {-4, -3, -2, -1, 0, 1, 2, 3, 4}. 
   A[0][0] = -4 + rg.nextInt(9);
   A[0][1] = -4 + rg.nextInt(9);
   A[1][0] = -4 + rg.nextInt(9);
   A[1][1] = -4 + rg.nextInt(9);
   
   // e. Adjust so the elements are randomly chosen from the seven values {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5}. 
   A[0][0] = -5 + rg.nextInt(11);
   A[0][1] = -5 + rg.nextInt(11);
   A[1][0] = -5 + rg.nextInt(11);
   A[1][1] = -5 + rg.nextInt(11);
   
     
    return A;  
  }  // end of method

  
// A new version that generates random integers from firstInteger up to lastInteger. 
// This way we can perform multiple experiments using a for loop. 
   public static int[][] genMatrix(int firstInteger, int lastInteger) {
   int[][] A = new int[2][2]; 
   Random rg = new Random(); // Use rg and the nextInt command, to adjust the values below so they are random. 
   
   int N = lastInteger - firstInteger +1; // The total number of random integers. 
   A[0][0] = firstInteger + rg.nextInt(N);
   A[0][1] = firstInteger + rg.nextInt(N);
   A[1][0] = firstInteger + rg.nextInt(N);
   A[1][1] = firstInteger + rg.nextInt(N);
      
    return A;  
  }  // end of method
  
  
  
// Add your completed matrixMultiply() method here. 
  
public static int[][] matrixMultiply(int[][] A, int[][] B) throws RuntimeException {
// Record the matrix dimensions.
    
    int rowsA= A.length;
    int columnsA= A[0].length;
    int rowsB= B.length;
    int columnsB= B[0].length;

    if (columnsA !=  rowsB)   throw new RuntimeException("The inner matrix dimensions must match.");

    
    /* Declare but do not initialize C.
     Specify its dimensions using those of A and B. */
    int[][] C = new int[rowsA][columnsB] ;
    
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
    
    


// Prints a matrix of integers. 
public static void printMatrix(int [][] C) {
    
int rowsC= C.length;
    for ( int i = 0; i < rowsC; i++ ) {
        System.out.printf("| ");
        for ( int number : C[ i ] )
            System.out.printf( "%2d", number );
        System.out.println(" |");
} // end of printing for loop block
    
} // end of method printMatrix.


public static String matrixToString(int [][] C) {
String result = ""; 
int rowsC= C.length;
    for ( int i = 0; i < rowsC; i++ ) 
     {
        result +="| ";
            for ( int number : C[ i ] )   {result += String.format("%2d", number);}
        result +=" |\n";
      } // end of outer for loop block
    
    return result;
} // end of method    
    
    
 // A method to summarize the results of the numerical experiment. 

public static void printSummary() {

 System.out.println("\nSUMMARY OF RESULTS.");
 System.out.println("When the  coefficients are random from -1 to +1 we found  12 idempotent matrices. ");
 System.out.println("When the  coefficients are random from -2 to +2 we found  28 idempotent matrices. ");
 System.out.println("When the  coefficients are random from -3 to +3 we found  44 idempotent matrices. ");
 System.out.println("When the  coefficients are random from -4 to +4 we found  60 idempotent matrices. ");
 System.out.println("When the  coefficients are random from -5 to +5 we found  76 idempotent matrices. ");
 System.out.println("When the  coefficients are random from -6 to +6 we found 108 idempotent matrices. ");
 System.out.println("When the  coefficients are random from -7 to +7 we found 124 idempotent matrices. ");
 System.out.println("When the  coefficients are random from -8 to +8 we found 140 idempotent matrices. ");
 System.out.println("When the  coefficients are random from -9 to +9 we found 156 idempotent matrices. ");
 System.out.println("When the  coefficients are random from -10 to +10 we found 188 idempotent matrices. ");

}
    
    
} // end of class
