package sample.dataModels;

import javafx.beans.property.SimpleStringProperty;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;

public class Paycheck implements Comparable<Paycheck> {
    private final SimpleStringProperty checkDeposit = new SimpleStringProperty("");
    private final SimpleStringProperty savDeposit = new SimpleStringProperty("");
    private final SimpleStringProperty date = new SimpleStringProperty("");
    private final SimpleStringProperty checkBalance = new SimpleStringProperty("");
    private final SimpleStringProperty savBalance = new SimpleStringProperty("");
    private final SimpleStringProperty grossIncome = new SimpleStringProperty("");
    private final SimpleStringProperty taxOwed = new SimpleStringProperty("");
    private final SimpleStringProperty grossTaxOwed = new SimpleStringProperty("");
    private final SimpleStringProperty amount = new SimpleStringProperty("");

    public Paycheck(JSONObject json){
        try {
            this.checkDeposit.set(json.get("checkingDeposit").toString());
            this.savDeposit.set(json.get("savingsDeposit").toString());
            this.date.set(json.get("date").toString());
            this.checkBalance.set(json.get("checkingBalance").toString());
            this.savBalance.set(json.get("savingsBalance").toString());
            this.grossIncome.set(json.get("grossIncome").toString());
            this.taxOwed.set(json.get("taxOwed").toString());
            this.grossTaxOwed.set(json.get("grossTaxOwed").toString());
            this.amount.set(json.get("amount").toString());
        } catch(JSONException e){
            e.printStackTrace();
        }
    }

    public Paycheck(double checkDeposit, double savDeposit, LocalDate date, double checkBalance, double savBalance, double grossIncome, double taxOwed, double grossTaxOwed, double amount){
        this.checkDeposit.set(Double.toString(checkDeposit));
        this.savDeposit.set(Double.toString(savDeposit));
        this.date.set(date.toString());
        this.checkBalance.set(Double.toString(checkBalance));
        this.savBalance.set(Double.toString(savBalance));
        this.grossIncome.set(Double.toString(grossIncome));
        this.taxOwed.set(Double.toString(taxOwed));
        this.grossTaxOwed.set(Double.toString(grossTaxOwed));
        this.amount.set(Double.toString(amount));
    }

    public String getCheckDeposit() {
        return checkDeposit.get();
    }

    public SimpleStringProperty checkDepositProperty() {
        return checkDeposit;
    }

    public String getSavDeposit() {
        return savDeposit.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getCheckBalance() {
        return checkBalance.get();
    }

    public String getSavBalance() {
        return savBalance.get();
    }

    public String getGrossIncome() {
        return grossIncome.get();
    }

    public String getTaxOwed(){
        return taxOwed.get();
    }

    public String getGrossTaxOwed() {
        return grossTaxOwed.get();
    }

    public String getAmount() {
        return amount.get();
    }

    @Override
    public int compareTo(Paycheck o) {
        int dateCompare = this.getDate().compareTo(o.getDate());
        if(dateCompare == 0){
            return this.getSavBalance().compareTo(o.getSavBalance());
        } else {
            return dateCompare;
        }
    }
}
