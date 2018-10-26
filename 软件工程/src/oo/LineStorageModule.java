package oo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * only care the management of the lines by offering interfaces like set get initialize
 */
public class LineStorageModule {
    private List<String> lines;

    public LineStorageModule() {
        lines = new ArrayList<String>();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public String getLine(int index) {
        return lines.get(index - 1);
    }

    public void setCharAtAnyLine(char c, int line, int index) {
        if(!judgeBound(line, index))return;
        line--;
        String s = lines.get(line);
        String temp;
        if (index == s.length())
            temp = s + c;
        else temp = s.substring(0, index) + c + s.substring(index, s.length());
        lines.remove(line);
        lines.add(line, temp);
    }

    private boolean judgeBound(int line, int index) {
        if (line > lines.size()) {
                System.out.println("error : line out the bound...");
            return false;
        }
        if (index > lines.get(line-1).length()){
            System.out.println("error : line out the bound...");
            return false;
        }
        return true;
    }

    public void delCharAtAnyLine(int line, int index) {
        if(!judgeBound(line, index))return;
        line--;
        String s = lines.get(line);
        String temp;
        if (index == s.length())
            temp = s.substring(0, index - 1);
        else if (index == 1)
            temp = s.substring(1, s.length());
        else temp = s.substring(0, index - 1) + s.substring(index, s.length());
        lines.remove(line);
        lines.add(line, temp);
    }

}
