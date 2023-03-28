import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class WPM {
    static String[] words = {"feather" , "novel" , "thermos" , "nation" , "thread" , "paragraph" , "path" , "wine" , 
    "bell" , "pirate" , "iron"};

    public static void main(String[] args) throws InterruptedException {
        // give you the prompt and the countdown
        System.out.println("type the words that appear after the countdown in...");
        Thread.sleep(1000);
        System.out.println("3...");
        Thread.sleep(1000);
        System.out.println("2...");
        Thread.sleep(1000);
        System.out.println("1!");
        Thread.sleep(1000);

        // give you the words in a random order - no repeats!
        Random r = new Random();
        List<String> wordsList = new ArrayList<>(Arrays.asList(words));
        for (int i = 0 ; i < words.length ; i++) {
            int index = r.nextInt(wordsList.size());
            String word = wordsList.get(index);
            wordsList.remove(index);
            System.out.print(word + " ");
        }

        double startTime = LocalTime.now().toNanoOfDay();

        Scanner s = new Scanner(System.in);
        String inputString = s.nextLine();
        double endTime = LocalTime.now().toNanoOfDay();
        System.out.println(inputString);

        double elapsedTime = endTime - startTime;
        int numChars = inputString.length();
        double seconds = toSeconds(elapsedTime);

        int wpm = (int) (((double) numChars / 5) * 60);
        // int wordsCorrect = spellcheck(inputString , words); 
        System.out.println("Your words per minute is " + wpm);  
        
        System.out.println("You spelled words " + spellcheck(inputString , words) + " correctly!");  
        
    }

    public static double toSeconds(double time) {
        return time / 1000000000;
    }

    // IN: the words you typed and the words you were given
    // OUT: the number of words that you were typed correctly
    public static int spellcheck(String in , String[] words) {
        int count = 0;

        for (String word : words) {
            if (in.contains(word)) {
                count++;
            }
        }

        return count;
    }
}
