package com.example.mother_pls_help;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;

public class RegistrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private TextField SignUpCodeword;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField SignUpEmail;

    @FXML
    private TextField SignUpBirth;

    @FXML
    private TextField SignUpFirstName;

    @FXML
    private TextField SignUpLastName;

    @FXML
    private TextField SignUpMiddleName;

    @FXML
    private TextField SignUpNickname;

    @FXML
    void initialize() {

    SignUpButton.setOnAction(event ->{
        signUpNewUser();

    });

    }
    private void signUpNewUser(){
        DatabaseHandler dbHandler = new DatabaseHandler();

        String first_name = SignUpFirstName.getText();
        String last_name = SignUpLastName.getText();
        String middle_name = SignUpMiddleName.getText();
        String nickname = SignUpNickname.getText();
        String email = SignUpEmail.getText();
        String password = PasswordField.getText();
        String codeword = SignUpCodeword.getText();
        String date_birth = SignUpBirth.getText();

        User user = new User(first_name,last_name,middle_name,nickname,email,password,
                codeword,date_birth);
        dbHandler.signUpUser(user);
    }
}

