package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.dataModels.Paycheck;
import sample.dataModels.PaycheckList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {

    private static final String dataPath = "data.txt";
    private static final String historyPath = "history.txt";
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
        try(FileWriter writer = new FileWriter(dataPath);
            BufferedWriter dataFile = new BufferedWriter(writer);){
            paycheckList.getPaychecks().forEach((paycheck) -> {
                System.out.println("Checking Deposit: " + paycheck.getCheckDeposit());
                System.out.println("Savings Deposit: " + paycheck.getCheckDeposit());
                System.out.println("Checking: " + paycheck.getCheckDeposit());
                System.out.println("Checking: " + paycheck.getCheckDeposit());
                System.out.println("Checking: " + paycheck.getCheckDeposit());
                System.out.println("Checking: " + paycheck.getCheckDeposit());
                System.out.println("Checking: " + paycheck.getCheckDeposit());
                System.out.println("Checking: " + paycheck.getCheckDeposit());
            });
        }
    }

    public static void main(String[] args) {
        File dataFile = new File(dataPath);
        File preferencesFile = new File(historyPath);
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
