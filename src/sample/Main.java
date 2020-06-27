package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONObject;
import sample.dataModels.Paycheck;
import sample.dataModels.PaycheckList;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {
    private PaycheckList paycheckList = PaycheckList.getInstance();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Julia's Tax Calculator");
        primaryStage.setScene(new Scene(root, 1000, 400));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        try(FileWriter writer = new FileWriter(Paths.dataPath);
            BufferedWriter dataFile = new BufferedWriter(writer);){
            for(int i = 0; i < paycheckList.getPaychecks().size(); i++){
                JSONObject map = new JSONObject();
                Paycheck paycheck = paycheckList.getPaychecks().get(i);
                map.put("checkingDeposit", paycheck.getCheckDeposit());
                map.put("savingsDeposit", paycheck.getSavDeposit());
                map.put("date", paycheck.getDate());
                map.put("checkingBalance", paycheck.getCheckBalance());
                map.put("savingsBalance", paycheck.getSavBalance());
                map.put("grossIncome", paycheck.getGrossIncome());
                map.put("taxOwed", paycheck.getTaxOwed());
                map.put("grossTaxOwed", paycheck.getGrossTaxOwed());
                map.put("amount", paycheck.getAmount());
                dataFile.write(map.toString() + ",\n");
            }
        }
    }

    public static void main(String[] args) {
        File dataFile = new File(Paths.dataPath);
        File preferencesFile = new File(Paths.historyPath);
        if(!dataFile.exists()){
            initFile(dataFile);
        }
        if(!preferencesFile.exists()){
            initFile(preferencesFile);
        }
        launch(args);
    }

    private static void initFile(File fileInstance){
        try{
            fileInstance.createNewFile();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
