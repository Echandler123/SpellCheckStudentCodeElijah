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
        // TSTS's for the diconary and mispelled words
        TST test = new TST();
        TST misspelled = new TST();
        // Adds every word form diconary to TST
        for (int i = 0; i < dictionary.length; i++) {
            test.insert(dictionary[i]);
        }
        // Arraylist of mispelled words
        ArrayList<String> Words = new ArrayList<String>();
        // Loop through each word in the text
        for (int i = 0; i < text.length; i++) {
            // Check if the word is in the dictonary TST and if it is already in the mispelled TST
            if (test.lookup(text[i]) == false) {
                if (misspelled.lookup(text[i]) == false) {
                    // Adds word to mispelled TST
                    misspelled.insert(text[i]);
                    Words.add(text[i]);
                }
            }
        }
        String[] Final = new String[Words.size()];
        // Makes array from arraylist of mispelled words
        for(int i = 0; i < Words.size(); i++) {
            Final[i] = Words.get(i);
        }
        System.out.println(Words.size());
        for(int i = 0; i < Final.length; i ++){
            System.out.println(Final[i]);
        }
        return Final;
    }
}
