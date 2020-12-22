package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class BMIController {
    @FXML
    private Button CalculateBtn;

    @FXML
    private CheckBox EnglishBox;

    @FXML
    private CheckBox MatricBox;

    @FXML
    private TextField WeightValue;

    @FXML
    private TextField HeightValue;

    @FXML
    private TextField BmiValue;

    @FXML
    void Calculate(ActionEvent event) {
        try{
            Double w = Double.parseDouble(WeightValue.getText());
            Double h = Double.parseDouble(HeightValue.getText());
            Double bmi;


            if(EnglishBox.isSelected()) {
                bmi = w /(h*h);
                BmiValue.setText(String.format("%.2f",bmi));
            }
            else if(MatricBox.isSelected()){
                bmi = (w * 703.0)/(h*h);
                BmiValue.setText(String.format("%.2f",bmi));
            }

        }catch(NumberFormatException e){
            WeightValue.setText("Enter valid value");
            WeightValue.selectAll();
            WeightValue.requestFocus();
            HeightValue.setText("Enter valid value");
            HeightValue.selectAll();
            HeightValue.requestFocus();
        }

    }

    @FXML
    void EnglishPressed(ActionEvent event) {
        MatricBox.setSelected(false);
    }

    @FXML
    void MatricPressed(ActionEvent event) {
        EnglishBox.setSelected(false);
    }

}
