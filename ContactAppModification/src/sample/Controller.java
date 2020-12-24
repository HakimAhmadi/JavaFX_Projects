package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Comparator;

public class Controller {

    @FXML
    private ListView<Contact> contactListView;
    @FXML
    private TextField fNameTextField;
    @FXML
    private TextField lNameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TextField phoneTextField;
    @FXML
    private ImageView imageView;

    String pathSaver=null;

    private final ObservableList<Contact> contacts =
            FXCollections.observableArrayList();

    static class sortByLast implements Comparator<Contact> {
        public int compare(Contact i1, Contact i2) {
            return i1.getLastName().compareTo(i2.getLastName());
        }
    }


    @FXML
    private void addButtonPressed(ActionEvent event) {
        try {
            if (fNameTextField.getText().equals("") || fNameTextField.getText().equals("fill this field") || lNameTextField.getText().equals("")){
                throw new Exception();
            }
            Contact newOne = new Contact(fNameTextField.getText(), lNameTextField.getText(),
                    (phoneTextField.getText()), emailTextField.getText());

            contacts.removeIf(i -> i.getFirstName().equals(newOne.getFirstName()) && i.getLastName().equals(newOne.getLastName()));

            contacts.add(newOne);

            contactListView.setItems(contacts);
            fNameTextField.setText("");
            lNameTextField.setText("");
            phoneTextField.setText("");
            emailTextField.setText("");

        }
        catch (Exception ex) {
            fNameTextField.setText("fill this field");
            lNameTextField.setText("fill this field");
            phoneTextField.setText("fill this field");
            emailTextField.setText("fill this field");
        }
    }

    @FXML
    private void deleteButtonPressed(ActionEvent event) {
        try {
            Contact newOne = new Contact(fNameTextField.getText(), lNameTextField.getText(),
                    (phoneTextField.getText()), emailTextField.getText());

            contacts.removeIf(i -> i.getFirstName().equals(newOne.getFirstName()) && i.getLastName().equals(newOne.getLastName()));
            contactListView.setItems(contacts);
            fNameTextField.setText("");
            lNameTextField.setText("");
            phoneTextField.setText("");
            emailTextField.setText("");

        }
        catch (NumberFormatException ex) {
            fNameTextField.setText("did not found in the directory");
            lNameTextField.setText("did not found in the directory");

        }
    }

    public void onUploadButtonPressed(javafx.event.ActionEvent actionEvent){
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        String path = null;

        if(selectedFile != null)
        {
            path= "C:/"+selectedFile.getPath();
            pathSaver = path;
            imageView.setImage(new Image(path));
        }
    }

    // initialize controller
    public void initialize() {
        // populate the ObservableList<Book>
        Contact one = new Contact("jawad", "khan", "012345678", "email.com", "sample/Images/01.jpg");
        contacts.add(one);
        Contact two = new Contact("menez", "hashim", "0987654321", "hotmail.com", "sample/Images/02.jpg");
        contacts.add(two);
        Contact three = new Contact("tokyo", "ghoul", "93492678369", "gmail.com", "sample/Images/03.jpg");
        contacts.add(three);


        sortByLast lastNameSort = new sortByLast();
        contacts.sort(lastNameSort);

        contactListView.setItems(contacts); // bind booksListView to books

        contactListView.getSelectionModel().selectedItemProperty().
                addListener(
                        new ChangeListener<Contact>() {
                            @Override
                            public void changed(ObservableValue<? extends Contact> ov,
                                                Contact oldValue, Contact newValue) {
                                imageView.setImage(null);
                                fNameTextField.setText(newValue.getFirstName());
                                lNameTextField.setText(newValue.getLastName());
                                phoneTextField.setText((newValue.getPhoneNumber()));
                                emailTextField.setText(newValue.getEmail());
                                imageView.setImage(new Image(newValue.getImage()));

                            }
                        }
                );
    }
}