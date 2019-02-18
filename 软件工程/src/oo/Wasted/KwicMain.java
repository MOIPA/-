package oo.Wasted;


public class KwicMain {
    public static void main(String[] args) {
        //do the control
        LineStorageModule lineStorageModule = new LineStorageModule();
        try {
            InputModule inputModule = new InputModule("C:\\Users\\tassa\\Documents\\GitHub\\MyStudy\\软件工程\\assests\\test.txt",lineStorageModule);
            inputModule.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
