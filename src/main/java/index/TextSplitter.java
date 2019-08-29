package index;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextSplitter {

    public List<String> split(String text) {
        String[] wordsArray = convertToLowerCaseLettersOnly(text).split(" ");
        return new ArrayList<>(Arrays.asList(wordsArray));
    }

    private String convertToLowerCaseLettersOnly(String text) {
        return text.toLowerCase().replaceAll("[^\\w\\s]","");
    }
}
