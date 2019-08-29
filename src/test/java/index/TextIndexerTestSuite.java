package index;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TextIndexerTestSuite {

    @Before
    public void before() {
        System.out.println("-------------------Test Case Begins--------------------");
    }

    @After
    public void after() {
        System.out.println("--------------------Test Case Ends---------------------");
    }

    @Test
    public void testIndexLettersOneWordsLowerCase() {
        //Given
        TextIndexer textIndexer = new TextIndexer();
        IndexDisplayer indexDisplayer = new IndexDisplayer();
        String testedText = "abc";
        //When
        Map<Character, List<String>> testedMap = textIndexer.indexLetters(testedText);
        //Then
        Assert.assertEquals(3, testedMap.entrySet().size());
        Assert.assertEquals(1, testedMap.get('a').size());
        Assert.assertEquals(1, testedMap.get('b').size());
        Assert.assertEquals(1, testedMap.get('c').size());

        indexDisplayer.displayIndexedMap(testedMap);
    }

    @Test
    public void testIndexLettersMoreWordsLowerCase() {
        //Given
        TextIndexer textIndexer = new TextIndexer();
        IndexDisplayer indexDisplayer = new IndexDisplayer();
        String testedText = "abc ac bca abc";
        //When
        Map<Character, List<String>> testedMap = textIndexer.indexLetters(testedText);
        //Then
        Assert.assertEquals(3, testedMap.entrySet().size());
        Assert.assertEquals(3, testedMap.get('a').size());
        Assert.assertEquals(2, testedMap.get('b').size());
        Assert.assertEquals(3, testedMap.get('c').size());

        indexDisplayer.displayIndexedMap(testedMap);
    }

    @Test
    public void testIndexLettersMoreWordsLowerCaseComplicated() {
        //Given
        TextIndexer textIndexer = new TextIndexer();
        IndexDisplayer indexDisplayer = new IndexDisplayer();
        String testedText = "abc ac bca abc cccc cbaa bbc";
        //When
        Map<Character, List<String>> testedMap = textIndexer.indexLetters(testedText);
        //Then
        Assert.assertEquals(3, testedMap.entrySet().size());
        Assert.assertEquals(4, testedMap.get('a').size());
        Assert.assertEquals(4, testedMap.get('b').size());
        Assert.assertEquals(6, testedMap.get('c').size());

        indexDisplayer.displayIndexedMap(testedMap);
    }

    @Test
    public void testIndexLettersOneWordUpperCase() {
        //Given
        TextIndexer textIndexer = new TextIndexer();
        IndexDisplayer indexDisplayer = new IndexDisplayer();
        String testedText = "aBc";
        //When
        Map<Character, List<String>> testedMap = textIndexer.indexLetters(testedText);
        //Then
        Assert.assertEquals(3, testedMap.entrySet().size());
        Assert.assertEquals(1, testedMap.get('a').size());
        Assert.assertEquals(1, testedMap.get('b').size());
        Assert.assertEquals(1, testedMap.get('c').size());

        indexDisplayer.displayIndexedMap(testedMap);
    }

    @Test
    public void testIndexLettersMoreWordsUpperCase() {
        //Given
        TextIndexer textIndexer = new TextIndexer();
        IndexDisplayer indexDisplayer = new IndexDisplayer();
        String testedText = "aBc Ac bca";
        //When
        Map<Character, List<String>> testedMap = textIndexer.indexLetters(testedText);
        //Then
        Assert.assertEquals(3, testedMap.entrySet().size());
        Assert.assertEquals(3, testedMap.get('a').size());
        Assert.assertEquals(2, testedMap.get('b').size());
        Assert.assertEquals(3, testedMap.get('c').size());

        indexDisplayer.displayIndexedMap(testedMap);
    }

    @Test
    public void testIndexLettersMoreWordsUpperCaseComplicated() {
        //Given
        TextIndexer textIndexer = new TextIndexer();
        IndexDisplayer indexDisplayer = new IndexDisplayer();
        String testedText = "aBc Ac bca abc cCCc cbAa bbc";
        //When
        Map<Character, List<String>> testedMap = textIndexer.indexLetters(testedText);
        //Then
        Assert.assertEquals(3, testedMap.entrySet().size());
        Assert.assertEquals(4, testedMap.get('a').size());
        Assert.assertEquals(4, testedMap.get('b').size());
        Assert.assertEquals(6, testedMap.get('c').size());

        indexDisplayer.displayIndexedMap(testedMap);
    }

    @Test
    public void testIndexLettersMoreWordsUpperCaseSpecial() {
        //Given
        TextIndexer textIndexer = new TextIndexer();
        IndexDisplayer indexDisplayer = new IndexDisplayer();
        String testedText = "aBc, Ac bca? abc";
        //When
        Map<Character, List<String>> testedMap = textIndexer.indexLetters(testedText);
        //Then
        Assert.assertEquals(3, testedMap.entrySet().size());
        Assert.assertEquals(3, testedMap.get('a').size());
        Assert.assertEquals(2, testedMap.get('b').size());
        Assert.assertEquals(3, testedMap.get('c').size());

        indexDisplayer.displayIndexedMap(testedMap);
    }

    @Test
    public void testIndexLettersMoreWordsUpperCaseComplicatedSpecial() {
        //Given
        TextIndexer textIndexer = new TextIndexer();
        IndexDisplayer indexDisplayer = new IndexDisplayer();
        String testedText = "aBc, Ac bca? abc cCCc cbAa! bbc";
        //When
        Map<Character, List<String>> testedMap = textIndexer.indexLetters(testedText);
        //Then
        Assert.assertEquals(3, testedMap.entrySet().size());
        Assert.assertEquals(4, testedMap.get('a').size());
        Assert.assertEquals(4, testedMap.get('b').size());
        Assert.assertEquals(6, testedMap.get('c').size());

        indexDisplayer.displayIndexedMap(testedMap);
    }

    @Test
    public void testIndexLettersSentence() {
        //Given
        TextIndexer textIndexer = new TextIndexer();
        IndexDisplayer indexDisplayer = new IndexDisplayer();
        String testedText = "ala ma kota, kot koduje w Javie Kota";
        //When
        Map<Character, List<String>> testedMap = textIndexer.indexLetters(testedText);
        //Then
        Assert.assertEquals(13, testedMap.entrySet().size());
        Assert.assertEquals(4, testedMap.get('a').size());
        Assert.assertEquals(2, testedMap.get('j').size());
        Assert.assertEquals(1, testedMap.get('w').size());

        indexDisplayer.displayIndexedMap(testedMap);
    }

    @Test
    public void testIndexLettersSentenceComplex() {
        //Given
        TextIndexer textIndexer = new TextIndexer();
        IndexDisplayer indexDisplayer = new IndexDisplayer();
        String testedText = "ala ma kota, kot kodu!#$@je w Javie Kota";
        //When
        Map<Character, List<String>> testedMap = textIndexer.indexLetters(testedText);
        //Then
        Assert.assertEquals(13, testedMap.entrySet().size());
        Assert.assertEquals(4, testedMap.get('a').size());
        Assert.assertEquals(2, testedMap.get('j').size());
        Assert.assertEquals(1, testedMap.get('w').size());

        indexDisplayer.displayIndexedMap(testedMap);
    }
}
