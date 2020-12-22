package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BMICalculator extends Application {

    @Override
    public void start(Stage Stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("BMICalculator.fxml"));
        Scene scene = new Scene(root);
        Stage.setTitle("Tip Calculator 2.0");
        Stage.setScene(scene);
        Stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
