package sample.dataModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONException;
import org.json.JSONObject;
import sample.Paths;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PaycheckList {
    private static PaycheckList instance = new PaycheckList();
    private static ObservableList<Paycheck> paychecks = FXCollections.observableArrayList();

    static {
        try(FileReader reader = new FileReader(Paths.dataPath);
            BufferedReader dataFile = new BufferedReader(reader);
            Scanner scanner = new Scanner(dataFile)){
            while(scanner.hasNext()){
                JSONObject paycheck = new JSONObject(scanner.next());
                paychecks.add(new Paycheck(paycheck));
            }
        } catch(IOException | JSONException e){
            e.printStackTrace();
        }
    }

    public ObservableList<Paycheck> getPaychecks(){
        return PaycheckList.paychecks;
    }

    public void addItem(Paycheck item){
        paychecks.add(item);
    }

    public Paycheck getLast() throws IndexOutOfBoundsException{
        return paychecks.get(paychecks.size()-1);
    }

    public void sortDesc(){
        paychecks.sort((u1, u2) -> {return u1.compareTo(u2);});
        FXCollections.reverse(paychecks);
    }

    public static PaycheckList getInstance(){
        return instance;
    }
}
