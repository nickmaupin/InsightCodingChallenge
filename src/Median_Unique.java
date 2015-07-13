import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//A program that splits a .txt file into differing tweets, finds the number of unique words, then calculates the number of median number of unique words, updating as each tweet is analyzed
public class Median_Unique {
	public static void main(String [] args) throws IOException {
		PrintStream out = new PrintStream(new FileOutputStream("tweet_output/ft2.txt", true));
        System.setOut(out);

		//puts the tweets into the string so that they can be split	
		String tweets = new Scanner(new File("tweet_input/tweets.txt")).useDelimiter("\\Z").next();
		
		//splits the tweets into different strings
		String[] tweetWords = tweets.split("\n");


		//adds the number of unique words to a set
		ArrayList<Integer> medianCount = new ArrayList();

			for(int x = 0; x < tweetWords.length; x++){
			
				String[] splitWords = tweetWords[x].split("\\s+");
				Set<String> uniqueWords = new HashSet<String>();
				int count = 0;
				for (String word : splitWords) {
					uniqueWords.add(word);	
			    	count++;
				}
			medianCount.add(count);
			}

			//prints out the number of unique words per set
			double counter = 0;
			for (int y = 0; y < medianCount.size(); y++){
				counter = counter + medianCount.get(y);
				System.out.println(counter/ (y+1));
		
			
			}
		
	
		}
}
