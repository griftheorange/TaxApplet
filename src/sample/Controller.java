package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.dataModels.Paycheck;
import sample.dataModels.PaycheckList;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class Controller {

    private static final String dataPath = "data.txt";
    private static final String historyPath = "history.txt";
    private static HashMap<String, String> history;

    @FXML
    private TextField amountField;
    @FXML
    private TextField taxPercentField;
    @FXML
    private TextField transitCostField;
    @FXML
    private TextField loanPaymentField;
    @FXML
    private TextField biweeklyBudgetField;
    @FXML
    private DatePicker dateField;
    @FXML
    private TextField currentCheckingBalanceField;
    @FXML
    private TextField currentSavingsBalanceField;
    @FXML
    private TableView<Paycheck> tableView;

    private PaycheckList paycheckList = PaycheckList.getInstance();

    public void initialize(){
        history = Controller.getHistoryToMap();
        taxPercentField.setText(history.get("taxPercent"));
        transitCostField.setText(history.get("transitCost"));
        loanPaymentField.setText(history.get("loanPayment"));
        biweeklyBudgetField.setText(history.get("biweeklyBudget"));
        dateField.setValue(LocalDate.now());
        currentCheckingBalanceField.setText(history.get("checkingBalance"));
        currentSavingsBalanceField.setText(history.get("savingsBalance"));

        tableView.setItems(paycheckList.getPaychecks());
        paycheckList.addItem(new Paycheck(20, 20, LocalDate.now(), 20, 30, 40, 50, 60));

    }

    @FXML
    public void handleSubmitPaycheck(){
        try{
            double amount = Double.parseDouble(amountField.getText());
            double taxPercent = Double.parseDouble(taxPercentField.getText());
            double transitCost = Double.parseDouble(transitCostField.getText());
            double loanPayment = Double.parseDouble(loanPaymentField.getText());
            double biweeklyBudget = Double.parseDouble(biweeklyBudgetField.getText());
            LocalDate date = dateField.getValue();
            double checkingBalance = Double.parseDouble(currentCheckingBalanceField.getText());
            double savingsBalance = Double.parseDouble(currentSavingsBalanceField.getText());

            double taxAmount = amount*(taxPercent/100.0);
            double toChecking = loanPayment + transitCost + biweeklyBudget;
            double toSavings = amount - toChecking;

            // Confirms that values fit restrictions, have to put enough into savings to cover taxes, can't budget for more money than you've made
            if(toChecking > amount){
                System.out.println("Problem: You made less money this week than you've budgeted for, reduce your budget amount");
            } else if(taxAmount > toSavings){
                System.out.println("Problem: You are putting less money into savings than you owe in taxes, reduce your budget amount");
            } else {
                double newCheckingBalance = checkingBalance + toChecking;
                double newSavingsBalance = savingsBalance + toSavings;
                currentCheckingBalanceField.setText(Double.toString(newCheckingBalance));
                currentSavingsBalanceField.setText(Double.toString(newSavingsBalance));
                saveToHistory(newCheckingBalance, newSavingsBalance);
            }
        } catch(NumberFormatException e){
            System.out.println("Improper number format");
        }

    }

    private void saveToHistory(double newCheck, double newSav){
        try(FileWriter writer = new FileWriter(historyPath);
            BufferedWriter history = new BufferedWriter(writer);){
            history.write("taxPercent:"+taxPercentField.getText()+"\n");
            history.write("transitCost:"+transitCostField.getText()+"\n");
            history.write("loanPayment:"+loanPaymentField.getText()+"\n");
            history.write("biweeklyBudget:"+biweeklyBudgetField.getText()+"\n");
            history.write("date:"+dateField.getValue().toString()+"\n");
            history.write("checkingBalance:"+newCheck+"\n");
            history.write("savingsBalance:"+newSav+"\n");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private static HashMap<String, String> getHistoryToMap(){
        HashMap<String, String> history = new HashMap<>();
        try(FileReader reader = new FileReader(historyPath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            Scanner historyScanner = new Scanner(bufferedReader)){
            while(historyScanner.hasNext()){
                String[] stringArr = historyScanner.next().split(":");
                history.put(stringArr[0], stringArr[1]);
            }
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            return history;
        }
    }
}
