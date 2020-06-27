package sample.dataModels;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PaycheckList {
    private static PaycheckList instance = new PaycheckList();
    private ObservableList<Paycheck> paychecks = FXCollections.observableArrayList();

    private PaycheckList(){
    }

    public ObservableList<Paycheck> getPaychecks(){
        return this.paychecks;
    }

    public void addItem(Paycheck item){
        paychecks.add(item);
    }

    public static PaycheckList getInstance(){
        return instance;
    }
}
