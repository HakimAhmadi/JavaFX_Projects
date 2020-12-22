package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class TipCalculatorController {

    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    private BigDecimal tipPercentage = new BigDecimal("0.15");


    @FXML
    private Label AmountView;

    @FXML
    private Label SliderView;

    @FXML
    private Label TipView;

    @FXML
    private Label TotalView;

    @FXML
    private TextField AmountField;

    @FXML
    private Slider SliderBar;

    @FXML
    private TextField TipField;

    @FXML
    private TextField TotalField;

    @FXML
    private Button CalculateBtn;

    @FXML
    public void CalculatingAmount(ActionEvent event) {
        try {

            BigDecimal amount = new BigDecimal(AmountField.getText());
            BigDecimal tip = amount.multiply(tipPercentage);
            BigDecimal total = amount.add(tip);

            TipField.setText(currency.format(tip));
            TotalField.setText(currency.format(total));
        }
        catch (NumberFormatException e){
            AmountField.setText("Enter amount");
            AmountField.selectAll();
            AmountField.requestFocus();
        }
    }
    public void initialize(){
        currency.setRoundingMode(RoundingMode.HALF_UP);
        SliderBar.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                        tipPercentage= BigDecimal.valueOf(t1.intValue()/100.0);
                        SliderView.setText(percent.format(tipPercentage));
                        continous(AmountField.getText());
                    }
                }
        );
        AmountField.textProperty().addListener(((args, old, newv) -> {
            continous(newv);

        }));
    }

    void continous(String newv){
        if (Integer.parseInt(newv)>0) {
            try {

                BigDecimal amount = new BigDecimal(newv);
                BigDecimal tip = amount.multiply(tipPercentage);
                BigDecimal total = amount.add(tip);

                TipField.setText(currency.format(tip));
                TotalField.setText(currency.format(total));
            } catch (NumberFormatException e) {
                AmountField.setText("Enter amount");
                AmountField.selectAll();
                AmountField.requestFocus();
                initialize();
            }
        }
        else {
            AmountField.setText("0");
            AmountField.selectAll();
            AmountField.requestFocus();
            TotalField.setText("0");
            initialize();

        }
    }

}
