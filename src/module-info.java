module JuliaApplet {
    requires javafx.fxml;
    requires javafx.controls;
    requires org.json;

    opens sample;
    opens sample.dataModels;
}