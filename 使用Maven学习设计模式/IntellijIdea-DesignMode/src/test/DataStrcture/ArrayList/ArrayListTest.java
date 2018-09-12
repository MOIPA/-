package test.DataStrcture.ArrayList; 

import DataStrcture.ArrayList.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/** 
* ArrayList Tester. 
* 
* @author <唐锐>
* @since <pre>九月 13, 2018</pre> 
* @version 1.0 
*/ 
public class ArrayListTest {

    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = new ArrayList(20);

@Before
public void before() throws Exception {
    arrayList1.getTheList()[0]=0;arrayList1.getTheList()[1]=1;arrayList1.getTheList()[2]=2;
    arrayList1.getTheList()[3]=3;arrayList1.getTheList()[4]=4;
} 

@After
public void after() throws Exception { 
} 

@Test
public void testInitial()throws Exception{
    Assert.assertEquals(5, arrayList1.getTheList().length);
    Assert.assertEquals(20, arrayList2.getTheList().length);
}

@Test
public void testPutValue() throws Exception {
    //应该自动扩容了
    arrayList1.putValue(-1);
    arrayList1.putValue(-2);
    arrayList1.putValue(-3);
    arrayList1.putValue(-4);
    arrayList1.putValue(-5);
    arrayList1.putValue(-6);
    arrayList1.putValue(-1);
    arrayList1.putValue(-2);
    arrayList1.putValue(-3);
    arrayList1.putValue(-4);
//    arrayList1.putValue(-5);
//    arrayList1.putValue(-6);
//    for (int a :
//            arrayList1.getTheList()) {
//        System.out.print(a);
//    }
    arrayList1.insertList(7,777);
    arrayList1.insertList(2,222);
    arrayList1.deletValByPos(1);
    for(int i=0;i<arrayList1.getArrayLength();i++) {
        System.out.print(arrayList1.getTheList()[i]+"_");
    }
//    System.out.print(arrayList1.getValByPos(1));
}

@Test
public void testArrayAdd() throws Exception {
    for (int a :
            arrayList1.getTheList()) {
        System.out.print(a);
    }
    System.out.println("orign Length:"+arrayList1.getTheList().length);
    arrayList1.arrayAdd();
    for (int a :
            arrayList1.getTheList()) {
        System.out.print(a);
    }
    System.out.println("extended Length:"+arrayList1.getTheList().length);
}


@Test
public void testCopyElement() throws Exception {

    arrayList2.copyElement(arrayList2.getTheList(), arrayList1.getTheList());
    for (int a :
            arrayList2.getTheList()) {
        System.out.print(a);
    }
    arrayList2.copyElement(arrayList1.getTheList(), arrayList2.getTheList());

}

} 
