package index;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextSplitter {

    public static List<String> split(String text) {
        String[] wordsArray = convertToLowerCaseLettersOnly(text).split(" ");
        return new ArrayList<>(Arrays.asList(wordsArray));
    }

    private static String convertToLowerCaseLettersOnly(String text) {
        return text.toLowerCase().replaceAll("[^\\w\\s]","");
    }
}
