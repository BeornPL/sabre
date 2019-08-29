package index;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TextSplitterTestSuite {

    @Test
    public void testSplitTextSimpleLowerCase() {
        //Given
        TextSplitter textSplitter = new TextSplitter();
        String testedText = "abc ab a cba bc cb";
        //When
        List<String> result = textSplitter.split(testedText);
        //Then
        Assert.assertEquals(6, result.size());
        Assert.assertEquals("abc", result.get(0));
        Assert.assertEquals("cba", result.get(3));
    }

    @Test
    public void testSplitTextSimpleUpperCase() {
        //Given
        TextSplitter textSplitter = new TextSplitter();
        String testedText = "aBc ab a cBa bc cb ABC";
        //When
        List<String> result = textSplitter.split(testedText);
        //Then
        Assert.assertEquals(7, result.size());
        Assert.assertEquals("abc", result.get(0));
        Assert.assertEquals("cba", result.get(3));
    }

    @Test
    public void testSplitTextSpecialUpperCase() {
        //Given
        TextSplitter textSplitter = new TextSplitter();
        String testedText = "aBc, ab! a cBa.. bc cb ABC??";
        //When
        List<String> result = textSplitter.split(testedText);
        //Then
        Assert.assertEquals(7, result.size());
        Assert.assertEquals("abc", result.get(0));
        Assert.assertEquals("cba", result.get(3));
    }

    @Test
    public void testSplitTextSpecialUpperCaseMixed() {
        //Given
        TextSplitter textSplitter = new TextSplitter();
        String testedText = "aBc, ab! a cBa..asasc bc cb ABC??";
        //When
        List<String> result = textSplitter.split(testedText);
        //Then
        Assert.assertEquals(7, result.size());
        Assert.assertEquals("abc", result.get(0));
        Assert.assertEquals("cbaasasc", result.get(3));
    }
}
