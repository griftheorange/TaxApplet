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

    public String getCheckDeposit() {
        return checkDeposit.get();
    }

    public SimpleStringProperty checkDepositProperty() {
        return checkDeposit;
    }

    public String getSavDeposit() {
        return savDeposit.get();
    }

    public SimpleStringProperty savDepositProperty() {
        return savDeposit;
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public String getCheckBalance() {
        return checkBalance.get();
    }

    public SimpleStringProperty checkBalanceProperty() {
        return checkBalance;
    }

    public String getSavBalance() {
        return savBalance.get();
    }

    public SimpleStringProperty savBalanceProperty() {
        return savBalance;
    }

    public String getGrossIncome() {
        return grossIncome.get();
    }

    public SimpleStringProperty grossIncomeProperty() {
        return grossIncome;
    }

    public String getGrossTaxOwed() {
        return grossTaxOwed.get();
    }

    public SimpleStringProperty grossTaxOwedProperty() {
        return grossTaxOwed;
    }

    public String getAmount() {
        return amount.get();
    }

    public SimpleStringProperty amountProperty() {
        return amount;
    }
}
