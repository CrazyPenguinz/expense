import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by 708 on 9/14/2018.
 */
public class BookFileConnector {
    private static final String fileName = "tmp.txt";
    private static String line = null;


    static public ArrayList<String> viewHistory() {
        ArrayList<String> informations = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                informations.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return informations;
    }

    static public void add(String detail) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(detail);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    static public void edit(String[] lists) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(lists[0] + " " + lists[1] + " " + lists[2]);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
