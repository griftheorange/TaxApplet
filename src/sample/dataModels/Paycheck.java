package sample.dataModels;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.util.Date;

public class Paycheck {
    private final SimpleStringProperty checkDeposit = new SimpleStringProperty("");
    private final SimpleStringProperty savDeposit = new SimpleStringProperty("");
    private final SimpleStringProperty date = new SimpleStringProperty("");
    private final SimpleStringProperty checkBalance = new SimpleStringProperty("");
    private final SimpleStringProperty savBalance = new SimpleStringProperty("");
    private final SimpleStringProperty grossIncome = new SimpleStringProperty("");
    private final SimpleStringProperty grossTaxOwed = new SimpleStringProperty("");
    private final SimpleStringProperty amount = new SimpleStringProperty("");

    public Paycheck(double checkDeposit, double savDeposit, LocalDate date, double checkBalance, double savBalance, double grossIncome, double grossTaxOwed, double amount){
        this.checkDeposit.set(Double.toString(checkDeposit));
        this.savDeposit.set(Double.toString(savDeposit));
        this.date.set(date.toString());
        this.checkBalance.set(Double.toString(checkBalance));
        this.savBalance.set(Double.toString(savBalance));
        this.grossIncome.set(Double.toString(grossIncome));
        this.grossTaxOwed.set(Double.toString(grossTaxOwed));
        this.amount.set(Double.toString(amount));
    }
}
