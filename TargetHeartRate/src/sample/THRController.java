package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class THRController {

    @FXML
    private Label AmountLabel;

    @FXML
    private Label PeopleLabel;

    @FXML
    private Label EachLabel;

    @FXML
    private TextField AgeValue;

    @FXML
    private TextField MaxHearValue;

    @FXML
    private TextField THRrValue;

    @FXML
    private Button CalculateBtn;

    @FXML
    void CalculatingRate(ActionEvent event) {
        try{
            int age = Integer.parseInt(AgeValue.getText());
            int max = 220 - age;
            MaxHearValue.setText(String.format("%d", max));
            THRrValue.setText(String.format("%d-%d bpm", Math.round(max * 0.5), Math.round(max * 0.85)));
        }
        catch (NumberFormatException e){
            AgeValue.setText("Enter Age");
            AgeValue.selectAll();
            AgeValue.requestFocus();
        }
    }

}
