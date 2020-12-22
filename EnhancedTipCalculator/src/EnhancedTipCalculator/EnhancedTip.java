package EnhancedTipCalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.NumberFormat;

public class EnhancedTip {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    int amount;
    int people;

    @FXML
    private Label AmountLabel;

    @FXML
    private Label PeopleLabel;

    @FXML
    private Label EachLabel;

    @FXML
    private TextField AmountValue;

    @FXML
    private TextField PeopleValue;

    @FXML
    private TextField EachValue;

    @FXML
    private Button CalculateBtn;

    @FXML
    void CalculatingAmount(ActionEvent event) {
        try{
            amount = Integer.parseInt(AmountValue.getText());
            people = Integer.parseInt(PeopleValue.getText());
            EachValue.setText(currency.format(amount/people));
        }catch (NumberFormatException e){
            AmountValue.setText("Enter amount");
            AmountValue.selectAll();
            AmountValue.requestFocus();
        }
    }

}
