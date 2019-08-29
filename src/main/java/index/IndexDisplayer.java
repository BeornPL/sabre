package index;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IndexDisplayer {
    public void displayIndexedMap(Map<Character, List<String>> map) {
        for (Map.Entry<Character, List<String>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            System.out.println(entry.getValue().stream().collect(Collectors.joining(", ")));
        }
    }
}
