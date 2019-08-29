package index;

import java.util.*;

public class TextIndexer {
    public static Map<Character, List<String>> indexLetters(String text) {

        List<String> words = TextSplitter.split(text);
        Map<Character, List<String>> indexMap = new TreeMap<>();

        for (int i = 97; i <= 122; i++) {
            List<String> mapValue = searchForWordsContainingCharacterAndSort(words, (char) i);
            if(!mapValue.isEmpty()) {
                indexMap.put((char) i, mapValue);
            }
        }
        return indexMap;
    }

    private static List<String> searchForWordsContainingCharacterAndSort (List<String> listOfWords, Character character) {
        List<String> listOfWordsContainingCharacter = new ArrayList<>();
        for (String word : listOfWords) {
            if (checkIfWordContainsCharacter(word, character)) {
                addToListIfContainsNot(listOfWordsContainingCharacter, word);
            }
        }
        Collections.sort(listOfWordsContainingCharacter);
        return listOfWordsContainingCharacter;
    }

    private static void addToListIfContainsNot(List<String> list, String word) {
        if (!list.contains(word))
            list.add(word);
    }

    private static boolean checkIfWordContainsCharacter(String word, Character character) {
        if (word.indexOf(character) >= 0) {
            return true;
        }
        return false;
    }


}
