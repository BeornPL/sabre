package index;

import java.util.ArrayList;
import java.util.List;

public class TextSplitter {

    public static List<String> split(String text) {
        List<String> words = new ArrayList<>();
        String[] wordsArray = text.split("\\W+");
        for(int i = 0; i<wordsArray.length; i++) {
            words.add(wordsArray[i].toLowerCase());
        }
        return words;
    }
}
