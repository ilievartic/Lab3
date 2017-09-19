/*
 * hey
 */
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @param url url to retrieve contents from
 * @return the contents from the url as a string, or an empty string on error
 */
public class mainSS {
    public static String urlToString(final String url) {
    Scanner urlScanner;
    try {
        urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
    } catch (IOException e) {
        return "";
    }
    String contents = urlScanner.useDelimiter("\\A").next();
    urlScanner.close();
    return contents;
}
    public static int countWords(final String url) {
        int fin = 0;
        String words = urlToString(url);
        int length = words.length();
        for(int i = 1; i < length - 2; i++) {
            if(words.substring(i,i+1).equals(" ") && !words.substring(i-1,i).equals(" ") && !words.substring(i+1,i+2).equals(" ")) {
                fin ++;
            }
        }
        return fin;
    }

    public static int findWord(final String url, String word) {
        int fin = 0;
        String words = urlToString(url);
        int length = words.length();
        int wordlength = word.length();

        for(int i = 0; i < length - wordlength; i++) {
            if(words.substring(i,i+wordlength).equals(word)) {
                fin ++;
            }
        }
        return fin;
    }
    public static void main(String[] args) {
        System.out.print(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println("Total number of words: "+countWords("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println("Total number of \"the\": "+findWord("http://erdani.com/tdpl/hamlet.txt","the"));

    }
}
