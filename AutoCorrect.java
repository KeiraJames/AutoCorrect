/* A program that compares words in a give file to those words in a dictionary file
 * and returns if any words are misspelled and on which line the error occurs. User may 
 */

import java.io.*;
import java.util.*;

class Dictionary {
    private ArrayList <String> array;

    public Dictionary(String fileName) throws Exception { 
        Scanner sc = new Scanner(new File(fileName)); 
        array = new ArrayList <String> (); 

        while (sc.hasNext()) { 
           array.add( sc.next().toLowerCase());
        }  
    }

    public boolean found(String word) throws NoSuchElementException { //method takes a word and tells you if that word is in your dictionary
        for(int i=0; i<array.size(); i++){
            if((array.get(i)).equals(word)) return true;
        }
        return false;
    }
}
public class AutoCorrect{
    public static void main(String[] a) throws Exception{
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Please enter the name of the file to be checked: ");
        String paper = keyboard.next();        
        System.out.print("Please enter the name of a dictionary reference file: ");
        String dict = keyboard.next();
        
        Dictionary d = new Dictionary(dict); 
        Scanner sc = new Scanner(new File(paper)); 

        double lineCount = 0;
        while(sc.hasNextLine()) { 
            String line = sc.nextLine(); // scan the line and store it in the variable line
            lineCount++; // count the line
            spellCheck(line, d, lineCount);
        }
        sc.close();
    }
    public static void spellCheck(String line, Dictionary d, double lineCount) throws Exception{
        Scanner sc = new Scanner(line); // read from line

        while(sc.hasNext()) { 
            String word = sc.next(); 
            if(d.found(word.toLowerCase())==false) System.out.printf("Line %4.0f: %s\n",lineCount,word);
        }	
		sc.close();
    }
}



