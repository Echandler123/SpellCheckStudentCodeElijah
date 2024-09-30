import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [Elijah Chandler]
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {
        String[] mispelledwords = new String[text.length];
        int i =0;
        for(String word : text){
            i++;
            if(word.length() > 45){
                mispelledwords[i] = word;
            }
        }
        for(int j = 0; j < dictionary.length; j++){
            for(int k = 0; k < text.length; k++){

            }
        }
        return mispelledwords;
    }
}
