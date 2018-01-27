/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;



// I have added these imports to demonstrate using JFileChooser
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;



public class ASCII_Art {

public static void main(String[] args) {
    
// Examples of ASCII Art: 
// 1. Flag with Cheerful Message
        
System.out.println("\n\nHappy July Fourth!\n");
System.out.println("¸.¤*¨¨*¤.¸¸...¸.¤\\");
System.out.println("\\¸.   ♥U.S.A♥   .,\\");
System.out.println(" \\¸.¤*¨¨*¤.¸¸.¸.¤ *\\");
System.out.println("  \\");
System.out.println(" ☻/");
System.out.println("/▌");
System.out.println("/ \\");
       
 
// 2. Here is a cute little polar bear. 
// On a PC, the nose might look odd. 
// This can usually be fixed by changing the terminal output font to a monospaced one.  
// On some platforms you can click on the console window to do this. On others, use the Preferences. 

System.out.println("\nHere is an awesome polar bear using only one line of symbols!");
String polarBear = "ˁ˚ᴥ˚ˀ";
System.out.println(polarBear);  System.out.println("\n");


// 3. Here is a a little garden snake. 
// Let's draw the snake now. This time we will concatenate the characters all into one super big String!
// Notice the new line character \n at the end of each row of characters. 

System.out.println("\n\nEveryone likes snakes! Especially cute ones like this little fellow!\n"); 

String  snake  = "                    /^\\/^\\\n"; // line 1
        snake += "                  _|__|  O|\n"; // line 2
        snake += "         \\/     /~     \\_/ \\\n"; // line 3
        snake += "          \\____|__________/  \\\n"; // line 4
        snake += "                 \\_______      \\\n"; // line 5
        snake += "                         `\\     \\                 \\\n"; // line 6
        snake += "                           |     |                  \\\n"; // line 7
        snake += "                          /      /                    \\\n"; // line 8
        snake += "                         /     /                       \\\n"; // line 9
        snake += "                       /      /                         \\ \\\n"; // line 10
        snake += "                      /     /                            \\  \\\n"; // line 11
        snake += "                    /     /             _----_            \\   \\\n"; // line 12
        snake += "                   /     /           _-~      ~-_         |   |\n"; // line 13
        snake += "                  (      (        _-~    _--_    ~-_     _/   |\n"; // line 14
        snake += "                   \\      ~-____-~    _-~    ~-_    ~-_-~    /\n"; // line 15
        snake += "                     ~-_           _-~          ~-_       _-~\n"; // line 16
        snake += "                        ~--______-~                ~-___-~\n"; // line 17
        snake += "                                  DON'T STEP ON ME!!"; // line 18

System.out.println(snake); 
  

// 4. Here's a Dragon who has come to visit Mario the Magnificent . 
System.out.println("\n\nFerocious fire-breathing dragon! Looks hungry!\n"); 
  
String  dragon  = "                                                 /===-_---~~~~~~~~~------____\n"; // line 1
        dragon += "                                                |===-~___                _,-'\n"; // line 2
        dragon += "                 -==\\\\                         `//~\\\\   ~~~~`---.___.-~~\n"; // line 3
        dragon += "             ______-==|                         | |  \\\\           _-~`\n"; // line 4
        dragon += "       __--~~~  ,-/-==\\\\                        | |   `\\        ,'\n"; // line 5
        dragon += "    _-~       /'    |  \\\\                      / /      \\      /\n"; // line 6
        dragon += "  .'        /       |   \\\\                   /' /        \\   /'\n"; // line 7
        dragon += " /  ____  /         |    \\`\\.__/-~~ ~ \\ _ _/'  /          \\/'\n"; // line 8
        dragon += "/-'~    ~~~~~---__  |     ~-/~         ( )   /'        _--~`\n"; // line 9
        dragon += "                  \\_|      /        _)   ;  ),   __--~~\n"; // line 10
        dragon += "                    '~~--_/      _-~/-  / \\   '-~ \\\n"; // line 11
        dragon += "                   {\\__--_/}    / \\\\_>- )<__\\      \\\n"; // line 12
        dragon += "                   /'   (_/  _-~  | |__>--<__|      | \n"; // line 13
        dragon += "                  |0  0 _/) )-~     | |__>--<__|      |\n"; // line 14
        dragon += "                  / /~ ,_/       / /__>---<__/      |  \n"; // line 15
        dragon += "                 o o _//        /-~_>---<__-~      /\n"; // line 16      
        dragon += "                 (^(~          /~_>---<__-      _-~              \n"; // line 17      
        dragon += "                ,/|           /__>--<__/     _-~                 \n"; // line 18      
        dragon += "             ,//('(          |__>--<__|     /                  .----_ \n"; // line 19      
        dragon += "            ( ( '))          |__>--<__|    |                 /' _---_~\\\n"; // line 20      
        dragon += "         `-)) )) (           |__>--<__|    |               /'  /     ~\\`\\\n"; // line 21      
        dragon += "        ,/,'//( (             \\__>--<__\\    \\            /'  //        ||\n"; // line 22
        dragon += "      ,( ( ((, ))              ~-__>--<_~-_  ~--____---~' _/'/        /'\n"; // line 23
        dragon += "    `~/  )` ) ,/|                 ~-_~>--<_/-__       __-~ _/ \n"; // line 24
        dragon += "  ._-~//( )/ )) `                    ~~-'_/_/ /~~~~~~~__--~ \n"; // line 25
        dragon += "   ;'( ')/ ,)(                              ~~~~~~~~~~ \n"; // line 26
        dragon += "  ' ') '( (/\n"; // line 27
        dragon += "    '   '  `   \n"; // line 28
    
String myASCII_Art = "" + dragon;        
System.out.println(myASCII_Art); 

// * * * * * * * * COOL DRAGON * * * * * * * * 

// Here is a sneak peek ahead at reading from files. 
// Read in ASCII art lines of text for the CoolDragon and save each line in an ArrayList of Strings. 
// We use both the File and Scanner classes to read from a text file. 
// Requires use of try/catch blocks to catch the exception that can be thrown if the file can't be found. 

File coolDragonFile = new File("./ASCII_text/CoolDragon.txt"); // Provides path to file as a String. 
Scanner reader = null;
ArrayList<String> coolDragon = new ArrayList<>(); // Will old the ASCII art. 

try { reader = new Scanner(coolDragonFile);
     while( reader.hasNextLine() ) { coolDragon.add(   reader.nextLine() ); }  
    } // end of try block
catch(Exception e)  
    {System.exit(0);} // Just exit the program. We'll have to reprogram if there is a problem.     
reader.close();


 System.out.println( "\nHere is the Cool Dragon image before reflection.\n");
 
// Draw the dragon for part D here. See PDF file with instructions. 
// Note all the lines of text are in the ArrayList named coolDragon. 
// You can do it all with one for loop and a single line.  
// Add code here. Draw the cool dragon. 

 for(String line : coolDragon) {System.out.println( line );}
 
 
 

// E. Add code here to reflect the dragon. It should now face to the right instead of the left. 
// This part is a little tricky. 
// You will need to pad each line with spaces first, so that the dragon in Part D has the same number of characters per line. 

// 1. OK, let's first find the maximum length of the lines that form the ASCII Cool Dragon Image. 
 int maxLength = 0;
  for(String line : coolDragon) {    maxLength = Math.max( line.length(),  maxLength);      } // You could also use an if statement. 
System.out.println("The longest row in the Cool Dragon image has length: " + maxLength); // Turns out it is 64. 

// 2. Next, pad each line with spaces " " in the Cool Dragon image until it has length (64 = maxLength). 
// method 1

/*
  for(String line : coolDragon) 
   {  String temp = line;
      while( temp.length() < maxLength )  { temp += " ";}  
      coolDragon.set( coolDragon.indexOf(line) , temp);
   } // All lines have the same length now. 
  
        */


  // Method 2: Here is an alternative which uses a classical for loop instead. 
  
  for(int k = 0; k < coolDragon.size(); k++) 
   {  String temp = coolDragon.get(k);
      while( temp.length() < maxLength )  { temp += " ";}  
      coolDragon.set( k , temp);
   }
  
  
  
  // Method 3: Email from  Nick. Pads AND reflects the dragon
   System.out.println("Using Nick's method to reflect the dragon. Uses format() method and StringBuilder method reverse().");
    for(String myLine : coolDragon) 
       { myLine=String.format("%1$-" + maxLength + "s",myLine);  // Specify the total  width must be maxLength, which is 64. 
         String reversedLine = new StringBuilder(myLine).reverse().toString(); // Reverse the current line with StringBuilder
         System.out.println(reversedLine);
       } // Pad the right side of each line to 64 characters.

  
  
  
// Line below was used to test each line now has 64 characters.
// for(String line : coolDragon) {System.out.println( line.length() );}

 // 3. Let's now create an ArrayList for the Mirror of the Cool Dragon. 
  
  ArrayList<String>  mirrorOfCoolDragon = new ArrayList<>();
  for(String line : coolDragon) 
   {  String mirrorLine = "";
      for(int i = 0; i < line.length(); i++) {  mirrorLine = line.charAt(i) + mirrorLine;    } // Notice we rebuild the line in the reverse order. 
      mirrorOfCoolDragon.add(mirrorLine);
   } // The mirror image has been created.
  
  // Print out the reflected dragon image. 
  System.out.println("\nHere is the mirror image of the cool dragon.\n");
  for(String line : mirrorOfCoolDragon) {System.out.println( line );}

  
 
 

// F. Can you draw a composite featuring both the original dragon anfd the reflected image? 
 
 // OK, let's print them both out seperated by 8 spaces. 
    System.out.println("\nHere are both dragons facing each other.\n");

  String rowOfSpaces = "        "; // 8 spaces
  
  
  for(int i = 0; i< coolDragon.size(); i++)
    {
      System.out.println( mirrorOfCoolDragon.get(i) + rowOfSpaces + coolDragon.get(i) );
    }
  
  
 
 
 // G. Add code here to draw your own example of ASCII art. Look online for fun examples. 
 // Ascii World has many examples. 
 
 // Check the provided ASCII_text folder to see if any of these additional images interest you. 
 // There's more dragons, a castle and several versions of the Eiffel Tower. 

  
  // We'll take this opportunity to demonstrate using JFileChooser
  
   JFileChooser chooser = new JFileChooser("./ASCII_text");
   FileNameExtensionFilter filter = new FileNameExtensionFilter( "Text file", "txt"); // Only show txt files
   chooser.setFileFilter(filter);
   chooser.setDialogTitle("Choose one of these ASCII ART files.");
   File file1 = null;
   
if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
      {
          file1 = chooser.getSelectedFile();
          System.out.println("Reading ASCII art from this file: " +
            chooser.getSelectedFile().getName() + "\n");
      }
  
  // OK, now we have identified a file. 

// Read in the ASCII art image and print it!
reader = null; String nextLine ;

try { reader = new Scanner(file1);
     while( reader.hasNextLine() ) 
         {
             nextLine = reader.nextLine();
             System.out.println(nextLine);
         }
      
    } // end of try block
catch(Exception e)  
    {System.exit(0);}
       
reader.close();

  
} // end of main


} // end of class
