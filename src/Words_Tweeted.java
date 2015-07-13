import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//a program that uploads tweets from a .txt file and shows how many times each word in those tweets show up

public class Words_Tweeted {
	

	public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("ft1.txt", true));
        System.setOut(out);
        
        Map<String, Integer> tweetWords = new HashMap<String, Integer>();
        //Read words from tweets and calculates the frequency
        Scanner tweetScanner = new Scanner(new File("tweet_input/tweets.txt"));
        tweetScanner.useDelimiter("\\s+");
        while (tweetScanner.hasNext()) {
            String tweet = tweetScanner.next();
            Integer count = tweetWords.get(tweet);
            if(count == null)
            	tweetWords.put(tweet, 1);
            else
            	tweetWords.put(tweet, count + 1);
        }
            tweetScanner.close();
            
        //alphabetizes the tweets
        ArrayList<Map.Entry<String, Integer>> tweetEntry =
                new ArrayList<Map.Entry<String, Integer>>(tweetWords.entrySet());
        Collections.sort(tweetEntry, new Comparator<Map.Entry<String, Integer>>() 
        {
            public int compare(Map.Entry<String, Integer> tweet1, Map.Entry<String, Integer> tweet2) {
                return (tweet1.getKey().compareTo(tweet2.getKey()));
            }
        });

        //Show the words alphabetically with the frequency
        for (Map.Entry<String, Integer> ent : tweetEntry) {
          System.out.printf("%s: %d \n", ent.getKey(), ent.getValue());
            
        }
    }
}



