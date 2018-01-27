package javareview;

/**
 *
 * @author robincar`r
 */

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class CalculatorGame_with_Dialogs extends CalculatorGame{
    

public static void main(String[] args) {
    
 // We can freely use the existing CalculatorGame code, thanks to its structure as the super class. 
 // Construct a new game, using this subclass's constructor. 
    
 CalculatorGame_with_Dialogs myGame = new CalculatorGame_with_Dialogs();
  
// The printWelcome() method from the super class is no longer very appropriate, so we have overridden it below. 
 myGame.printWelcome();
 
  // OK, Let's play. But we will alsooverride the method playGame() so it uses dialogs and not the console window!
  // See where the method is overridden below. 
  boolean done = false; // Sentinel flag to stop the game. 
  while(!done) {
      
  myGame.playGame();  
  if (myGame.getScore() >= 100)   done = true; // User passes
  if (myGame.getScore() <= -30)   done = true; // User fails
    
  } // end of while loop

  
  
  // Finally, JavAttack announces his verdict. Do you have a highly-evolved brain or not?
  String testResults = ""; 
  ImageIcon slimeMold = new ImageIcon("images/SlimeMold2.png");
  ImageIcon evolvedBrain = new ImageIcon("images/EvolvedBrain.png");
  ImageIcon finalImage = null;
 
  
  if(myGame.getScore() >= 100) 
      {  // System.out.println("\n\nJavAttack: Awesome! Looks like you have a highly-evolved mammal brain after all!\n\n");
         testResults = "JavAttack: Awesome! Looks like you have a highly-evolved mammal brain after all!";
         finalImage =  evolvedBrain;
      
      }
  
 
  else 
      {// System.out.println("\n\nJavAttack: I see I am dealing with a primitive slime mold here. Evolve and grow a brain already!\n\n");
          testResults = "JavAttack: I see I am dealing with a primitive slime mold here.\nEvolve and grow a brain already!";
          finalImage =  slimeMold;
      }  
  
      JOptionPane.showMessageDialog(null, testResults, "Calculator Game", JOptionPane.INFORMATION_MESSAGE, finalImage); 
  
    
    
    
    
        
} // end of main
    

// Here we override the method printWelcome from the super class.
@Override
public void printWelcome() {
      
    String welcomeMessage = "Greetings! I am the vast cerebral AI known as JavAttack.\n";
    welcomeMessage += "Let's see if you have even a rudimentary intelligence \nby judging your responses to some skill-testing questions.\n  "; 
    welcomeMessage += "\nLet's start the testing, my puny, little organic lifeform!\n"; 
    welcomeMessage += "A score of 100 means you pass.\nA score of -30 or less and I stop wasting my time!"; 

    // Let's choose a fun image for the AI named JavAttack. 
    String fileName = "images/JavAttackImage.png";
    ImageIcon theEyeOfJavAttack = new ImageIcon(fileName);
    JOptionPane.showMessageDialog(null, welcomeMessage, "Calculator Game", JOptionPane.INFORMATION_MESSAGE, theEyeOfJavAttack); 
    
  }  // end of printWelcome method 
  



 // Here we override the method playGame from the super class.
@Override
  public  void playGame() {
      
     // 1. First generate three  integers a, b and c. Adjust the method getNumbers as instructed in the Homework PDF. 
      // The constants will help in error checking. 
     // These can be inserted into a symbolic expression to generate many different questions. 
      
     int [] testNumber = getNumbers();   // Variables a, b, c for each question. 
     int a = testNumber[0];  int b = testNumber[1];  int c = testNumber[2];
     
     int correctAnswer = 0, userAnswer;
     String nextQuestion = ""; // Holds the next question as a String. 
   
      // 2. Select one of these question templates.
        
        
     int equationChoice =  1 + randomGen.nextInt(7);    // Fixed !
      
      switch(equationChoice) {
          
          case 1:   // (a % b % c)
                    // System.out.printf("Find the value of the expression:  (a %% b %% c) \t if a = %d, b = %d and c = %d \n", a, b, c ); 
                    nextQuestion = String.format("Find the value of the expression:  (a %% b %% c) \t if a = %d, b = %d and c = %d \n", a, b, c ); 
                    correctAnswer = a % b % c; 
                    break;
              
          case 2:   // (++a + b++ - c++)
                    // System.out.printf("Find the value of the expression:  (++a + b++ - c++)  \t if a = %d, b = %d and c = %d \n", a, b, c ); 
                    nextQuestion = String.format("Find the value of the expression:  (++a + b++ - c++)  \t if a = %d, b = %d and c = %d \n", a, b, c ); 
                    correctAnswer = (++a + b++ - c++); 
                    break; 
         // Add more cases here. 
              
         case 3:    // (++a % b++ * c)
                    // System.out.printf("Find the value of the expression:  (++a %% b++ * c)   \t if a = %d, b = %d and c = %d \n", a, b, c ); 
                    nextQuestion = String.format("Find the value of the expression:  (++a %% b++ * c)  \t if a = %d, b = %d and c = %d \n", a, b, c ); 

                    correctAnswer = (++a % b++ * c); 
                    break;     
              
          case 4:   // (++a + b++ + b-- * c--);
                    // System.out.printf("Find the value of the expression:  (++a + b++ + b-- * c--) \t if a = %d, b = %d and c = %d \n", a, b, c ); 
                    nextQuestion = String.format("Find the value of the expression:  (++a + b++ + b-- * c--) \t if a = %d, b = %d and c = %d \n", a, b, c ); 
                    correctAnswer = (++a + b++ + b-- * c--); 
                    break;   
              
          case 5:   // (++a/2 + Math.max(++b,c--) )
                    // System.out.printf("Find the value of the expression:  (++a/2 + Math.max(++b,c--) ) \t if a = %d, b = %d and c = %d \n", a, b, c ); 
                    nextQuestion = String.format("Find the value of the expression:  (a-c) \t if a = %d and c = %d \n", a, c ); 
                    correctAnswer = (a-c ); 
                    break;    
              
          // Now make up two question templates on your own. Many possible answers here.   
              
          case 6:   // Find the max of three similar expressions.
                    // System.out.printf("Find the value of the expression:  Math.max(Math.max(a/b*c, c/a*b), b/c*a) \t if a = %d, b = %d and c = %d \n", a, b, c, c,a,b, b, c, a ); 
                    nextQuestion = String.format("Find the value of the expression: (a - b - c ) \t if a = %d, b = %d and c = %d \n", a, b, c, c,a,b, b, c, a ); 

              correctAnswer = (a - b - c );
                    break;
              
          case 7:   // Permutations - Note we humbly admit to using parallel arrays here! NAUGHTY!!!
                    String[] testWord = {"cat", "java", "dragon", "wow", "daddy"};
                    int[] numberPermutations = {6, 12, 720, 3, 20}; //  The answers
                    int N = testWord.length;
                    // Select one of these words at random. 
                    int wordChoice = randomGen.nextInt(N);
                    String nextTestWord = testWord[wordChoice];
                    
                    // System.out.printf("Find the number of distinct permutations of the word: %s\n", nextTestWord); 
                    nextQuestion = String.format("Find the number of distinct permutations of the word: %s\n", nextTestWord); 

                    correctAnswer = numberPermutations[wordChoice]; // Look up the stored answer.
                    break;       
             
              
          default:
          
      } // end of switch
      
      // Display the question using showInputDialog()
      // showInputDialog(Component parentComponent, Object message, String title, int messageType, Icon icon, Object[] selectionValues, Object initialSelectionValue)
      
    String fileName = "images/JavAttackImage.png";
    ImageIcon theEyeOfJavAttack = new ImageIcon("images/JavAttackImage.png");
     
    String userAnswerString = JOptionPane.showInputDialog(null, nextQuestion, "Calculator Game", 0, theEyeOfJavAttack, null, null).toString();
     userAnswer = Integer.parseInt(userAnswerString);
      
     ImageIcon angry_AI = new ImageIcon("images/Angry_AI.png");
     ImageIcon happy_AI = new ImageIcon("images/Correct_AI_is_Happy.png");
     ImageIcon mood_of_AI = null; 
      // Let's get an answer from the user and see if they are correct. 
      // System.out.print("Answer: "); 
      // userAnswer =  keyboard.nextInt(); 
                    
      // Check if correct and update score. +10 for each correct answer but -20 for every wrong answer.
     String feedbackMessage = "";
      if(userAnswer == correctAnswer) 
        { this.setScore(this.getScore()+10);  
         feedbackMessage = String.format("Correct! Your score is now %d.\n\n", this.getScore() ); 
         mood_of_AI =  happy_AI;
        } 
         
         
      else 
        { this.setScore(this.getScore()-20);  
         feedbackMessage = String.format("Incorrect! Looks like we have an extraordinarily primitive mammal here. \nScore is now %d.\n\n", this.getScore()); 
        mood_of_AI =  angry_AI;
        }
             
      JOptionPane.showMessageDialog(null, feedbackMessage, "Calculator Game", JOptionPane.INFORMATION_MESSAGE, mood_of_AI);
    
      
      
  }  // end of playGame method 
    
    
} // end of class
