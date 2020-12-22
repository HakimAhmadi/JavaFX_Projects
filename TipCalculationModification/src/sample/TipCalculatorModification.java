package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TipCalculatorModification extends Application {
    @Override
    public void start(Stage Stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TipCalculatorModification.fxml"));
        Scene scene = new Scene(root);
        Stage.setTitle("Tip Calculator");
        Stage.setScene(scene);
        Stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
