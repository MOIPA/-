package DataStrcture.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * arraylist 自动扩容的数组链表
 * arraylist的指针永远指向下一个
 * 修改每次自动增加的数量可以修改addNumber
 * 目前只能存放int类型数据  后期改下变成对象数组把
 */
public class ArrayList implements IArrayList {

    //日志
    Logger logger = Logger.getLogger("arrayList Class");
    private static final int ADDNUMBER = 5;
    //表的定义 使用array  指针初始化后指在第一个位置 0
    int[] arrayList = null;
    int currentPos = 0;

    //使用用户定义的大小初始化,也是基本构造函数
    public ArrayList(int size) {
        arrayList = new int[size];
        logger.setLevel(Level.INFO);
        logger.info("arrayList initial succeed...");
    }

    //在构造函数中初始化
    public ArrayList() {
        //默认初始化为5 超过5以后可以自动增加5每次
        this(5);
    }

    //方便junit单元测试使用
    public int[] getTheList() {
        return arrayList;
    }

    //是类中的array扩容，通过构造一个数组，将原来的值全都拷贝进去
    public boolean arrayAdd() {
        logger.info("arrayList is adding...");
        if (arrayList != null) {
            int [] save = arrayList;
            arrayList = new int[arrayList.length+ ADDNUMBER];
            return copyElement(arrayList,save);
        }
        return false;
    }

    //复制元素  然而可以直接使用系统的System.arrayCopy
    public boolean copyElement(int[]targetArr,int[] orignArr){
        logger.info("arrayList is copying...");
        if (targetArr.length <= orignArr.length||null==targetArr||null==orignArr) {
            logger.info("arrayList copy failed... origianArrLength:"+orignArr.length+"\n targetArrLength:"+targetArr.length);
            return false;
        }
        for(int i=0;i<orignArr.length;i++) {
            targetArr[i] = orignArr[i];
        }
        logger.info("arrayList copy succeed...");
        return true;
    }

    @Override
    public void putValue(int val) {
        doPutVal(val);
    }

    private boolean doPutVal(int val) {
        //判断是否满了
        if (arrayList.length-1 < currentPos) {
            logger.info("put failed need extend array...");
            //扩容自身
            this.arrayAdd();
        }
        //真正的赋值操作
        arrayList[currentPos] = val;
        //移动指针
        currentPos++;
        logger.info("put succeed need to extend array...");
        return true;
    }

    @Override
    public void clearList() {
        currentPos=0;
        arrayList[0]=0;
    }

    @Override
    public void insertList(int pos,int val) {
        //从最后一个开始移动 每一个往后移动一位，直到留出目标地点,如果发现数组满了 先扩容
//        System.out.print(arrayList.length+"|||"+currentPos);
        if(arrayList.length-1<currentPos)
            arrayAdd();
        for(int i=currentPos-1;i>=pos-1;i--) { //pos-1存放目标数值
            arrayList[i + 1] = arrayList[i];
        }
        arrayList[pos - 1] = val;
        currentPos++;
    }

    @Override
    public void deletValByPos(int pos) {

        //从被删的那个开始 把后面一个往前挪 覆盖即可 简单一些把
        for(int i=pos-1;i<=currentPos-2;i++) {
            arrayList[i]=arrayList[i+1];
        }
        currentPos--;
    }

    @Override
    public int getValByPos(int pos) {
        return arrayList[pos - 1];
    }

    @Override
    public int getArrayLength() {
        return this.currentPos;
    }


}
