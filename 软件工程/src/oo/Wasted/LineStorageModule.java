package oo.Wasted;

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
    private List<String> wordsList; //temporary things

    public LineStorageModule() {
        lines = new ArrayList<String>();
        wordsList = new ArrayList<String>();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public void delLine(int index){
        lines.remove(index-1);
    }

    public void setLine(String line, int index) {
        delLine(index);
        lines.add(index-1,line);
    }

    public String getLine(int index) {
        return lines.get(index - 1);
    }

    public void addCharAtAnyLine(char c, int line, int index) {
        if(!judgeBound(line, index))return;
        line--;
        String s = lines.get(line);
        String temp;
        if (index == s.length())
            temp = s + c;
        else temp = s.substring(0, index-1) + c + s.substring(index-1, s.length());
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

    public char getCharAtAnyLine(int line,int index){
        if(!judgeBound(line,index)) return ' ';
        line--;
        String s = lines.get(line);
        return s.charAt(index-1);
    }

    public void setCharAtAnyLine(char c , int line,int index){
        delCharAtAnyLine(line, index);
        if(index==lines.get(line-1).length()+1)index--;
        addCharAtAnyLine(c,line,index);
    }

    public int getCharCounts(int line){
        if(!judgeBound(line,0)) return -1;
        return lines.get(line-1).length();
    }

    public String getWord(int line,int index){
        if(!judgeBound(line,0)) return "";
        return getWordsList(lines.get(line-1)).get(index-1);
    }

    public int getWordCounts(int line){
        return getWordsList(lines.get(line-1)).size();
    }

    public void addWord(String word,int line){
        String s = lines.get(line - 1);
        s += " " + word;
        lines.remove(line-1);
        lines.add(line-1,s);
    }

    public void delWord(int line, int index) {
        line--;
        int count=0,realStart=0,end=-1,start=-1,realEnd=0;
        String s = lines.get(line);
        for(int i =0;i<s.length()-1;i++){
            if(s.charAt(i)!=' '){
                if(start==-1)start=i;
                if (s.charAt(i + 1) == ' '||i==s.length()-2) {
                    if(end==-1)end=i;
                    count++;
                    if(index==count){
                        realStart = start;
                        realEnd = end;
                        if(i==s.length()-2)realEnd++;
                    }
                        //the word was found record the index
                    start=-1;end=-1;
                }
            }
        }
        //after got the record realStart and realEnd ,split the String
//        System.out.println(realStart+"=="+realEnd);
        String temp;
        if(realEnd==s.length()-1) temp = s.substring(0, realStart-1);  //delete the last word
        else if(realStart==0) temp = s.substring(realEnd + 2, s.length());//delete the first word
        else temp = s.substring(0, realStart-1)+s.substring(realEnd+1,s.length());//delete the middle word
        lines.remove(line);
        lines.add(line, temp);
    }

    public List<String> getWordsList(String line) {
        //find the first char ,if the next char is not space combine it to temp,
        //when the next word is detected as space which means the current character is the ending of the world,
        //the world should be put to the list and temp string will be reset.
        String temp = "";
        for (int i = 0; i < line.length() - 1; i++) {
            if (line.charAt(i) != ' ') {
                temp += line.charAt(i);
                if (line.charAt(i + 1) == ' ' || i == line.length() - 2) {
                    if (i == line.length() - 2) temp += line.charAt(i + 1);
                    wordsList.add(temp);
                    temp = "";
                }
            }
        }
        return wordsList;
    }


}
