package os.jlxy.tr.rewrite;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import os.jlxy.tr.rewrite.service.ComTabFrm;
import os.jlxy.tr.rewrite.view.InitFrame;

/**
 * 主函数
 *
 */
public class Main 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
    	System.setOut(new PrintStream("D:/tmp.txt"));
    	new ComTabFrm();
    }
}
