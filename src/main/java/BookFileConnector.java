import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by 708 on 9/14/2018.
 */
public class BookFileConnector implements Connectable{
    private static final String fileName = "tmp.txt";
    private static String line = null;

    private static final BookFileConnector instance = new BookFileConnector();

    static public BookFileConnector getInstance() {
        return instance;
    }

    private BookFileConnector() {}

    public ObservableList<Information> viewHistory() {
        ObservableList<Information> informations = FXCollections.observableArrayList();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] tmp = line.split(" ");
                informations.add(new Information(tmp[0], tmp[1] + " " + tmp[2], tmp[3]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return informations;
    }

    public void add(String type, String detail, String amount) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(type + " " + detail + " " + amount);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    static public void edit(String lists) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(lists);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
