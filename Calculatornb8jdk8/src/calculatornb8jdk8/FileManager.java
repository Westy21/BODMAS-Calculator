package calculatornb8jdk8;

import javax.swing.*;
import java.io.*;

public class FileManager {
    private final static String strFilename = "calculated.txt";
    private static BufferedReader brReader = null;

    private static File getFile(){
        File flTemp = new File(strFilename);
        if(flTemp.exists()){
            return flTemp;
        }
        try {
            flTemp.createNewFile();
        } catch (IOException e) {}
        return flTemp;
    }

    public static boolean writeToFile(String strVar){
        try {
            FileWriter frWritter = new FileWriter(getFile(),false);
            frWritter.write(strVar);
            frWritter.close();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Failed to write to file");
        }
        return false;
    }

    public static String retreiveFromFile(){
        try {
            FileManager.brReader = new BufferedReader(new InputStreamReader(new FileInputStream(getFile())));
            String strLine;
            if((strLine=brReader.readLine())!=null){
                return strLine;
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Failed to read file");
        } catch (IOException e) {
        }finally {
            try {
                FileManager.brReader.close();
            } catch (IOException e) {}
        }
        return null;
    }
    public static void clearFile(){
        try {
            new FileWriter(getFile(),false);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Failed to write to file");
        }
    }
}
