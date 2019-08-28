package index;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IndexDisplayerTestSuite {

    @Test
    public void testDisplay() {
        //Given
        Map<Character, List<String>> testedMap = new TreeMap<>();
        List<String> arrayList1 = new ArrayList<>();
        List<String> arrayList2 = new ArrayList<>();
        List<String> arrayList3 = new ArrayList<>();

        arrayList1.add("abc");
        arrayList1.add("cba");
        arrayList1.add("bac");

        arrayList2.add("csdsd");
        arrayList2.add("few");
        arrayList2.add("wesdf");

        arrayList3.add("sca");
        arrayList3.add("scx");
        //When
        testedMap.put('a',arrayList1);
        testedMap.put('v',arrayList2);
        testedMap.put('#',arrayList3);
        IndexDisplayer.displayIndexedMap(testedMap);
        //Then

    }
}
