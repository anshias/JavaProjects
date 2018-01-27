// Illustrates inheritance concepts and the substitution principle. 
package javareview;

public class Person {
    
/* A person has a first and last name, a certain number of teeth 
 and a weight in pounds. */

    private String firstName;
    private String lastName;
    private int numberOfTeeth; // <= 32

    private double weight; // Weight in pounds

// Constructor
public Person(String first, String last, int numberTeeth, double theWeight) {    firstName = first; lastName = last;
    numberOfTeeth = numberTeeth; weight = theWeight;
    } // end of constructor
    
public Person() {    firstName = null; lastName = null;
        numberOfTeeth = 32; weight = 100; // default  weight
    } // end of constructor
    
public void setFirstName(String first) {firstName = first;}
public String getFirstName() {return firstName;}
public void setLastName(String last) {lastName = last;}
public String getLastName() {return lastName;}
    
public void setNumberOfTeeth(int numberTeeth) {numberOfTeeth = numberTeeth;}
public int getNumberOfTeeth() {return numberOfTeeth;}

public void setWeight(double theWeight) {weight = theWeight;}
public double getWeight() {return weight;}
  
    
// A person can go on a diet and loose weight. 
public void looseWeight(double weightLoss) {weight -= weightLoss;}
public void gainWeight(double weightGain)  {weight += weightGain;}


} // end of Person class
