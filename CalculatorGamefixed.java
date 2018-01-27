package javareview;

import java.util.Random;
import java.util.Scanner;

/**
 * @author robincarr
 */
public class CalculatorGame {
    
private  int  score ;  // Tracks your score in the game.   
  
public CalculatorGame() {score = 0;} // Constructs a new Calculator Game object

public int getScore() {return score;}                    // Return the score of the game
public void setScore(int newScore) { score = newScore; } // Change the score of the game

    
// Class (or static) variables.
public static Random randomGen = new Random(1776); // Note fixed seed makes random numbers deterministic. 
public static Scanner keyboard = new Scanner(System.in);

    
public  static void main(String[] args) {
    
  // Construct a new game. 
  CalculatorGame myGame = new CalculatorGame();
  
  myGame.printWelcome(); // Explain what the program does. 

  
  boolean done = false; // Sentinel flag to stop the game. 
  while(!done) {
      
  myGame.playGame();  
  if (myGame.getScore() >= 100)   done = true; // User passes
  if (myGame.getScore() <= -30)   done = true; // User fails
    
  } // end of while loop

    
  if(myGame.getScore() >= 100) System.out.println("\n\nJavAttack: Awesome! Looks like you have a highly-evolved mammal brain after all!\n\n");
    
  else {System.out.println("\n\nJavAttack: I see I am dealing with a primitive slime mold here. Evolve and grow a brain already!\n\n");}  
  
}   // end of main  
    
    
  public  void printWelcome() {
      
     System.out.println("Greetings! I am the vast cerebral AI known as JavAttack.");
     System.out.println("Let's see if you have even a rudimentary intelligence \nby judging your responses to some skill-testing questions."); 
     System.out.println("Let's start the testing, my puny, little organic lifeform!"); 
     System.out.println("A score of 100 means you pass. A score of -30 and I stop wasting my time!\n\n"); 

    
  }  // end of printWelcome method 
  
  
  public  void playGame() {
      
     // 1. First generate three  integers a, b and c. Adjust the method getNumbers as instructed in the Homework PDF. 
      // The constants will help in error checking. 
     // These can be inserted into a symbolic expression to generate many different questions. 
      
     int [] testNumber = getNumbers();   // Variables a, b, c for each question. 
     int a = testNumber[0];  int b = testNumber[1];  int c = testNumber[2];
     
     int correctAnswer = 0, userAnswer;
        
      // 2. Select one of these question templates.
        
        
      int equationChoice =  1 + randomGen.nextInt(7);    // Fixed !
      
      
      switch(equationChoice) {
          
          case 1:   // (a % b % c)
                    System.out.printf("Find the value of the expression:  (a %% b %% c) \t if a = %d, b = %d and c = %d \n", a, b, c ); 

                    correctAnswer = a % b % c; 
                    break;
              
          case 2:   // (++a + b++ - c++)
                    System.out.printf("Find the value of the expression:  (++a + b++ - c++)  \t if a = %d, b = %d and c = %d \n", a, b, c ); 
                    correctAnswer = (++a + b++ - c++); 
                    break; 
         // Add more cases here. 
              
         case 3:    // (++a % b++ * c)
                    System.out.printf("Find the value of the expression:  (++a %% b++ * c)   \t if a = %d, b = %d and c = %d \n", a, b, c ); 
                    correctAnswer = (++a % b++ * c); 
                    break;     
              
          case 4:   // (++a + b++ + b-- * c--);
                    System.out.printf("Find the value of the expression:  (++a + b++ + b-- * c--) \t if a = %d, b = %d and c = %d \n", a, b, c ); 
                    correctAnswer = (++a + b++ + b-- * c--); 
                    break;   
              
          case 5:   // (++a/2 + Math.max(++b,c--) )
                    System.out.printf("Find the value of the expression:  (a-c ) \t if a = %d, b = %d and c = %d \n", a, b, c ); 
                    correctAnswer = (a-c  ); 
                    break;    
              
          // Now make up two question templates on your own. Many possible answers here.   
              
          case 6:   // Find the max of three similar expressions.
                    System.out.printf("Find the value of the expression:  (a - b - c) \t if a = %d, b = %d and c = %d \n", a, b, c, c,a,b, b, c, a ); 
                    correctAnswer = (a - b - c);
                    break;
              
          case 7:   // Permutations - Note we humbly admit to using parallel arrays here! NAUGHTY!!!
                    String[] testWord = {"cat", "java", "dragon", "wow", "daddy"};
                    int[] numberPermutations = {6, 12, 720, 3, 20}; //  The answers
                    int N = testWord.length;
                    // Select one of these words at random. 
                    int wordChoice = randomGen.nextInt(N);
                    String nextTestWord = testWord[wordChoice];
                    
                    System.out.printf("Find the number of distinct permutations of the word: %s\n", nextTestWord); 
                    correctAnswer = numberPermutations[wordChoice]; // Look up the stored answer.
                    break;       
             
              
          default:
          
      } // end of switch
      
      // Let's get an answer from the user and see if they are correct. 
      System.out.print("Answer: "); 
      userAnswer =  keyboard.nextInt(); 
                    
      // Check if correct and update score. +10 for each correct answer but -20 for every wrong answer.
      if(userAnswer == correctAnswer) 
        { this.setScore(this.getScore()+10);  System.out.printf("Correct! Your score is now %d.\n", this.getScore() );  } 
                        
      else 
        { this.setScore(this.getScore()-20);  System.out.printf("Incorrect! Looks like we have an extraordinarily primitive mammal here. Score is now %d.\n ", this.getScore()); }
             
      
      
      
  }  // end of playGame method  
  
  
 public static int[] getNumbers() {
     int a, b, c;
     int [] numbers = new int[3];    // Will hold the values {a, b, c}
     
     boolean useConstants = randomGen.nextInt(2)==0;  // We'll use the contasnts if this equals 0. 
      
     // Add if/else blocks here
     // 50% of the time, use these fixed constants.     
     if(useConstants) {  a=1; b=2; c=3; }  
   
     
     // The other 50% of the time, use random numbers from -10 up to +10. 
     else {
         a = -10 + randomGen.nextInt(21);
         b = -10 + randomGen.nextInt(21);
         c = -10 + randomGen.nextInt(21);
     } // end of else block
     
     
     numbers[0] = a; numbers[1] = b; numbers[2] = c; 
     return  numbers;
     
 }  // end of method
  
    
    
} // end of main
