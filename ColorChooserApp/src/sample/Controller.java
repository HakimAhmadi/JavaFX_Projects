package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {

    @FXML
    private Slider redSlider;

    @FXML
    private Slider greenSlider;

    @FXML
    private Slider blueSlider;

    @FXML
    private Slider alphaSlider;

    @FXML
    private TextField redTextField;

    @FXML
    private TextField greenTextField;

    @FXML
    private TextField blueTextField;

    @FXML
    private TextField alphaTextField;

    @FXML
    private Rectangle colorRectangle;


    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;

    @FXML
    void initialize(MouseEvent event) {
        redSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        red = newValue.intValue();
                        redTextField.setText(String.valueOf(red));
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));

                    }
                });

        greenSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        green = newValue.intValue();
                        greenTextField.setText(String.valueOf(green));
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));

                    }
                });

        blueSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        blue = newValue.intValue();
                        blueTextField.setText(String.valueOf(blue));
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));

                    }
                }
        );
        alphaSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        alpha = newValue.doubleValue();
                        alphaTextField.setText(String.valueOf(alpha));
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));

                    }
                }
        );
        redTextField.textProperty().addListener(((args,old,newvalue) -> {
            int Value;
            try {Value = Integer.parseInt(newvalue.trim());}
            catch (Exception e) {Value = 0;}

            redSlider.setValue(Value);
            red= Value;
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        }));
        greenTextField.textProperty().addListener(((args,old,newvalue) -> {
            int Value;
            try {Value = Integer.parseInt(newvalue.trim());}
            catch (Exception e) {Value = 0;}
            greenSlider.setValue(Value);
            green= Value;
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        }));
        blueTextField.textProperty().addListener(((args,old,newvalue) -> {
            int Value;
            try {Value = Integer.parseInt(newvalue.trim());}
            catch (Exception e) {Value = 0;}
            blueSlider.setValue(Value);
            blue= Value;
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        }));
        alphaTextField.textProperty().addListener(((args,old,newvalue) -> {
            double Value;
            try {
                Value =Double.parseDouble(newvalue.trim());

                if (Value>1){
                    Value=1;
                }
                else if (Value<0){
                    Value=0;
                }
            }
            catch (Exception e) {Value = 0;}
            alphaSlider.setValue(Value);
            alpha= Value;
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        }));

    }

}
