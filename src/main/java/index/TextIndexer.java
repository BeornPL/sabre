package index;

import java.util.*;

public class TextIndexer {
    public Map<Character, List<String>> indexLetters(String text) {

        TextSplitter textSplitter = new TextSplitter();
        List<String> words = textSplitter.split(text);
        Map<Character, List<String>> indexMap = new TreeMap<>();

        for (int i = 97; i <= 122; i++) {
            List<String> mapValue = searchForWordsContainingCharacterAndSort(words, (char) i);
            if(!mapValue.isEmpty()) {
                indexMap.put((char) i, mapValue);
            }
        }
        return indexMap;
    }

    private List<String> searchForWordsContainingCharacterAndSort (List<String> listOfWords, Character character) {
        List<String> listOfWordsContainingCharacter = new ArrayList<>();
        for (String word : listOfWords) {
            if (checkIfWordContainsCharacter(word, character)) {
                addToListIfContainsNot(listOfWordsContainingCharacter, word);
            }
        }
        Collections.sort(listOfWordsContainingCharacter);
        return listOfWordsContainingCharacter;
    }

    private void addToListIfContainsNot(List<String> list, String word) {
        if (!list.contains(word))
            list.add(word);
    }

    private boolean checkIfWordContainsCharacter(String word, Character character) {
        if (word.indexOf(character) >= 0) {
            return true;
        }
        return false;
    }


}
