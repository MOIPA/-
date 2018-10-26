package ms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * main/subroutine architectural style of kwic system written by tr
 */
public class kwic_ms {
    public static void main(String[] args) {
        doInput("C:\\Users\\tassa\\Documents\\GitHub\\MyStudy\\软件工程\\assests\\test.txt");
        doShift();
        sortLines();
        outPut();
    }

    //define datastruct to store character
    private static List<String> lines;
    private static List<String> outLines;
    private static List<String> wordsList;
    private static int[] indexs;

    private static void doInput(String fileLocation) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
            String line;
            lines = new ArrayList<String>();
            outLines = new ArrayList<String>();
            wordsList = new ArrayList<String>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void doShift() {
        //do shift words ,shift one line once then return the result to invoking function
        for (String line : lines) {
            shiftOneLine(line);
        }
    }

    private static void shiftOneLine(String line) {
        getWordsList(line);
        String temp = "";
        int wc = wordsList.size();
        for (int i = 0; i < wc; i++) {
            for(int j=i;j<wordsList.size();j++)
                temp+=wordsList.get(j)+" "; //get the phrases
            outLines.add(temp);
            temp="";
            wordsList.add(wordsList.get(i));
        }
        wordsList.clear(); //when one line used it should be cleared
    }

    private static void getWordsList(String line) {
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
    }

    private static void sortLines() {
        indexs = new int[outLines.size()];
        char[] firstChars = new char[outLines.size()];
        for(int i=0;i<indexs.length;i++){
            indexs[i]=i;
            firstChars[i]=outLines.get(i).charAt(0);
        }
        for(int i=0;i<indexs.length;i++){
            for(int j=0;j<indexs.length;j++){
                if(firstChars[i]<firstChars[j]){
                    char tempChar = firstChars[i];
                    firstChars[i]=firstChars[j];
                    firstChars[j]=tempChar;
                    int temp = indexs[i];
                    indexs[i]=indexs[j];
                    indexs[j]=temp;
                }
            }
        }
    }

    private static void outPut() {
        for(int i=0;i<indexs.length;i++){
            System.out.println(outLines.get(indexs[i]));
        }
    }

}
