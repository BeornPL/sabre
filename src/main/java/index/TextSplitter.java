package index;

import java.util.ArrayList;
import java.util.List;

public class TextSplitter {

    public static List<String> split(String text) {
        List<String> words = new ArrayList<>();
        text = text.toLowerCase();
        text = text.replaceAll("[^\\w\\s]","");
        String[] wordsArray = text.split(" ");
        for(int i = 0; i<wordsArray.length; i++) {
            words.add(wordsArray[i]);
        }
        return words;
    }
}
