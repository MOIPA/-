package test.oo; 

import oo.LineStorageModule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* LineStorageModule Tester. 
* 
* @author <Authors name> 
* @since <pre>??? 26, 2018</pre> 
* @version 1.0 
*/ 
public class LineStorageModuleTest { 

    private  LineStorageModule lineStorageModule;

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
* 
* Method: getLine(int index) 
* 
*/ 
@Test
public void testGetLine() throws Exception {
    Assert.assertEquals(lineStorageModule.getLine(1),"test the func");
    Assert.assertEquals(lineStorageModule.getLine(2),"123456");
} 

/** 
* 
* Method: setCharAtAnyLine(char c, int line, int index) 
* 
*/ 
@Test
public void testSetCharAtAnyLine() throws Exception {
    lineStorageModule.setCharAtAnyLine('k', 2, 3);
    Assert.assertEquals("123k456",lineStorageModule.getLine(2));
    lineStorageModule.setCharAtAnyLine('k', 2, 0);
    Assert.assertEquals("k123k456",lineStorageModule.getLine(2));
    lineStorageModule.setCharAtAnyLine('k', 2, 8);
    Assert.assertEquals("k123k456k",lineStorageModule.getLine(2));
    lineStorageModule.setCharAtAnyLine('k', 3, 8);
    }

/** 
* 
* Method: delCharAtAnyLine(char c, int line, int index) 
* 
*/ 
@Test
public void testDelCharAtAnyLine() throws Exception { 
    lineStorageModule.delCharAtAnyLine(1,1);
    Assert.assertEquals("est the func",lineStorageModule.getLine(1));
    lineStorageModule.delCharAtAnyLine(1,12);
    Assert.assertEquals("est the fun",lineStorageModule.getLine(1));
    lineStorageModule.delCharAtAnyLine(1,3);
    Assert.assertEquals("es the fun",lineStorageModule.getLine(1));
} 


/** 
* 
* Method: judgeBound(int line, int index) 
* 
*/ 
@Test
public void testJudgeBound() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = LineStorageModule.getClass().getMethod("judgeBound", int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
