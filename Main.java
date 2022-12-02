import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.lang.Math;
/**
 * <h1>ing search</h1>
 * <p>
 * This program finds where in the dictionary a certain -ing word is
 * </p>
 *
 * @author Eli Wood
 * @version v100
 */
public class Main
{
    public static void main()
    {
        try {
            File text = new File("words.txt");
            
            Scanner reader = new Scanner(text);
            
            ArrayList<String> words = new ArrayList<String>();
            
            String target;
            
            int location;
            
            while (reader.hasNextLine()) {
                words.add(reader.nextLine().toLowerCase());
            }
            
            target = Tools.askForString("What ing word are you looking for?").toLowerCase();
            
            long start = System.nanoTime();
            location = linearSearch(words, target);
            long finish = System.nanoTime();
            
            double elapsedTime = ((double)start - (double)finish) / 1000000000;
            System.out.printf("The location of the word (-1 means not found): %d\n\n", location);
            
            System.out.printf("Time elapsed in seconds: %f\n\n", Math.abs(elapsedTime));
        } catch (Exception e) {
            System.out.printf("Error: File not found");
        }
    }
    
    /**
     * <h1>linear search</h1>
     * <p>
     * This function finds where the target is in the text file
     * </p>
     * 
     * @author Eli Wood
     * @version v100
     */
    public static int linearSearch(ArrayList list, String target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                return i;
            }
        }
        
        return -1;
    }
}
