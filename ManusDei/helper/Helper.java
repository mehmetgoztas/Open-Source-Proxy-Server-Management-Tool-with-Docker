package ManusDei.helper;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Helper {
    File file;

    public Helper(File file) {
        this.file = file;
    }

    public void appendToFile(String text) {
        try{
            FileWriter writer = new FileWriter(this.file, true);
            writer.append(text + "\n");
            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String text) {
        try{
            FileWriter writer = new FileWriter(this.file);
            writer.write(text+"\n");
            writer.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public String readFromFile() {
        try {
            String result = "";
            Scanner scanFile = new Scanner(this.file);
            while(scanFile.hasNextLine()) {
                String temp = scanFile.nextLine();
                result += temp + "\n";
            }
            scanFile.close();
            return result;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}
