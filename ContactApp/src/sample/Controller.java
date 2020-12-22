package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {


    @FXML
    private Button Editbtn;

    @FXML
    private Button LoadContactbtn;

    @FXML
    private TextField FirstNameValue;

    @FXML
    private TextField LastNameValue;

    @FXML
    private TextField EmailValue;

    @FXML
    private TextField PhoneValue;

    @FXML
    private Button Savebtn;

    @FXML
    private Button DeleteBtn;

    @FXML
    private TextArea ContactList;

    @FXML
    void OnStart(ActionEvent event){

        try {
            File myObj = new File("/home/uca/Documents/Classes/Oop/JavaFX_Projects/ContactApp/src/sample/Contacts.txt");
            Scanner myReader = new Scanner(myObj);

            String Names = "";

            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");
                Names += data[0];
                Names += "\n";

            }

            myReader.close();
            ContactList.setText(Names);
        }
        catch (FileNotFoundException e) {
            ContactList.setText(e.getMessage());

    }

    }

    @FXML
    void DeleteContact(ActionEvent event){
        try {
            File myObj = new File("/home/uca/Documents/Classes/Oop/JavaFX_Projects/ContactApp/src/sample/Contacts.txt");
            Scanner myReader = new Scanner(myObj);

            ArrayList<String> newData = new ArrayList<>();
            while (myReader.hasNextLine()){
                newData.add(myReader.nextLine());
            }

            System.out.println(newData.toString());
            myReader.close();

            FileWriter myWriter = new FileWriter("/home/uca/Documents/Classes/Oop/JavaFX_Projects/ContactApp/src/sample/Contacts.txt");
            for (String s:newData){
                if (!FirstNameValue.getText().equals(s.split(",")[0])){
                    myWriter.write(s);
                    myWriter.write("\n");
                }
            }

            myWriter.close();

        }
        catch (FileNotFoundException e) {
            ContactList.setText(e.getMessage());} catch (IOException ee) {
            ContactList.setText(ee.getMessage());

        }

    }

    @FXML
    void SaveContact(ActionEvent event) {
        if (!FirstNameValue.getText().isEmpty() && !LastNameValue.getText().isEmpty() && !EmailValue.getText().isEmpty()&&!PhoneValue.getText().isEmpty()) {
            try {

                FileWriter myWriter = new FileWriter("/home/uca/Documents/Classes/Oop/JavaFX_Projects/ContactApp/src/sample/Contacts.txt",true);

                String newData=FirstNameValue.getText()+","+LastNameValue.getText()+","+EmailValue.getText()+","+PhoneValue.getText()+"\n";
                myWriter.write(newData);
                myWriter.close();


            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }


    }

}
