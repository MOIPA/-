package test.oo;

import oo.Wasted.LineStorageModule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * LineStorageModule Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>??? 26, 2018</pre>
 */
public class LineStorageModuleTest {

    private LineStorageModule lineStorageModule;

    @Before
    public void before() throws Exception {
        lineStorageModule = new LineStorageModule();
        lineStorageModule.addLine("test the func");
        lineStorageModule.addLine("123456");
    }


    @After
    public void after() throws Exception {
    }

    /**
     * Method: getLine(int index)
     */
    @Test
    public void testGetLine() throws Exception {
        Assert.assertEquals(lineStorageModule.getLine(1), "test the func");
        Assert.assertEquals(lineStorageModule.getLine(2), "123456");
    }

    /**
     * Method: addCharAtAnyLine(char c, int line, int index)
     */
    @Test
    public void testAddCharAtAnyLine() throws Exception {
        lineStorageModule.addCharAtAnyLine('k', 2, 4);
        Assert.assertEquals("123k456", lineStorageModule.getLine(2));
        lineStorageModule.addCharAtAnyLine('k', 2, 1);
        Assert.assertEquals("k123k456", lineStorageModule.getLine(2));
        lineStorageModule.addCharAtAnyLine('k', 2, 8);
        Assert.assertEquals("k123k456k", lineStorageModule.getLine(2));
        lineStorageModule.addCharAtAnyLine('k', 3, 9);
    }

    /**
     * Method: delCharAtAnyLine(char c, int line, int index)
     */
    @Test
    public void testDelCharAtAnyLine() throws Exception {
        lineStorageModule.delCharAtAnyLine(1, 1);
        Assert.assertEquals("est the func", lineStorageModule.getLine(1));
        lineStorageModule.delCharAtAnyLine(1, 12);
        Assert.assertEquals("est the fun", lineStorageModule.getLine(1));
        lineStorageModule.delCharAtAnyLine(1, 3);
        Assert.assertEquals("es the fun", lineStorageModule.getLine(1));
    }

    @Test
    public void testGetCharAtAnyLine() throws Exception {
        Assert.assertEquals(lineStorageModule.getCharAtAnyLine(2, 1), '1');
    }

    @Test
    public void testSetCharAtAnyLine() throws Exception {
        lineStorageModule.setCharAtAnyLine('k',2,6);
        Assert.assertEquals("12345k",lineStorageModule.getLine(2));
    }
    @Test
    public void testGetCharCounts() throws Exception {
        Assert.assertEquals(6,lineStorageModule.getCharCounts(2));
    }
    @Test
    public void testGetWord() throws Exception {
        Assert.assertEquals("test",lineStorageModule.getWord(1,1));
        Assert.assertEquals("the",lineStorageModule.getWord(1,2));
        Assert.assertEquals("func",lineStorageModule.getWord(1,3));
    }
    @Test
    public void testWordCounts() throws Exception {
        Assert.assertEquals(3, lineStorageModule.getWordCounts(1));
    }

    @Test
    public void testAddWord() throws Exception {
        lineStorageModule.addWord("test",1);
        Assert.assertEquals("test the func test", lineStorageModule.getLine(1));
    }
    @Test
    public void testDelWord() throws Exception {
        lineStorageModule.addLine("1234 6 89A CD FG 1 1234");
        lineStorageModule.delWord(3,1);
        Assert.assertEquals("6 89A CD FG 1 1234",lineStorageModule.getLine(3));
        lineStorageModule.delWord(3,4);
        Assert.assertEquals("6 89A CD 1 1234",lineStorageModule.getLine(3));
        lineStorageModule.delWord(3,2);
        Assert.assertEquals("6 CD 1 1234",lineStorageModule.getLine(3));
        lineStorageModule.delWord(3,3);
        Assert.assertEquals("6 CD 1234",lineStorageModule.getLine(3));
    }


}
