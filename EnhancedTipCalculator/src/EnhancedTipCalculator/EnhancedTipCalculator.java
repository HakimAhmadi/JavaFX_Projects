package EnhancedTipCalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EnhancedTipCalculator extends Application {
    public void start(Stage Stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("EnhancedTipCalculator.fxml"));
        Scene scene = new Scene(root);
        Stage.setTitle("Tip Calculator 2.0");
        Stage.setScene(scene);
        Stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
