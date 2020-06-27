package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    private static final String dataPath = "data.txt";
    private static final String historyPath = "history.txt";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Julia's Tax Calculator");
        primaryStage.setScene(new Scene(root, 1000, 400));
        primaryStage.show();
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
