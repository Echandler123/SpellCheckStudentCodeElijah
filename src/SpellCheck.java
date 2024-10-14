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
        TST test = new TST();
        for (int i = 0; i < dictionary.length; i++) {
            test.insert(dictionary[i]);
        }
        ArrayList<String> Words = new ArrayList<String>();
        TST misspelled = new TST();
        for (int i = 0; i < text.length; i++) {
            if (test.lookup(text[i]) == false) {
                if (misspelled.lookup(text[i]) == false) {
                    misspelled.insert(text[i]);
                    Words.add(text[i]);
                }
            }
        }
        String[] Final = new String[Words.size()];
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
