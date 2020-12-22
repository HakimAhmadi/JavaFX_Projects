package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TargetHeartRate extends Application {
    public void start(Stage Stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TargetHeartRate.fxml"));
        Scene scene = new Scene(root);
        Stage.setTitle("AHA Target Heart Rate");
        Stage.setScene(scene);
        Stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
