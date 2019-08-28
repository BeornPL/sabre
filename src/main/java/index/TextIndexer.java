package index;

import java.util.*;

public class TextIndexer {
    public static Map<Character, List<String>> indexLetters(String text) {
        List<String> words = TextSplitter.split(text);
        Map<Character, List<String>> indexMap = new TreeMap<>();

        boolean found;
        for (int i = 97; i <= 122; i++) {
            List<String> mapValue = new ArrayList<>();
            mapValue.clear();
            found = false;
            for (int j = 0; j<words.size(); j++) {
                String word = words.get(j);
                if (word.indexOf((char) i) >= 0) {
                    found = true;
                    if (!mapValue.contains(word.toLowerCase()))
                        mapValue.add(word.toLowerCase());
                }
            }
            Collections.sort(mapValue, String.CASE_INSENSITIVE_ORDER);
            if(found) {
                indexMap.put((char) i, mapValue);
            }
        }
        return indexMap;
    }
}
