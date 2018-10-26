package oo.Wasted;

import java.io.BufferedReader;
import java.io.FileReader;

public class InputModule {

    private BufferedReader bufferedReader;
    private LineStorageModule lineStorageModule;
    private String fileL;

    public InputModule(String fileName,LineStorageModule lineStorageModule){
        fileL = fileName;
        this.lineStorageModule =lineStorageModule;
    }
    public void parse() throws Exception {
        bufferedReader = new BufferedReader(new FileReader(fileL));
        String temp="";
        while ((temp = bufferedReader.readLine()) != null) {
            lineStorageModule.addLine(temp);
        }
    }
}
