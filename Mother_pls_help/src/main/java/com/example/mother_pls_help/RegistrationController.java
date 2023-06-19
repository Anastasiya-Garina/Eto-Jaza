package com.example.mother_pls_help;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class RegistrationController  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private TextField SignUpCodeword;

    @FXML
    private Button SignUpButtonRegistration;

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

//    @FXML
//    void initialize() {
//
//    SignUpButtonRegistration.setOnAction(event ->{
//
//            signUpNewUser();
//            openNewScene("/com/example/mother_pls_help/Login.fxml");
//
//    });
//
//    }
//    @FXML
//    public void signUpJust(ActionEvent event) throws IOException {
//
//        openNewScene("Login.fxml");
//    }
    @FXML
    private void signUpNewUser(ActionEvent event) throws IOException{
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
        openNewScene("Login.fxml");
    }




    public void openNewScene(String window){
        //SignUpButtonRegistration.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
        stage.close();

    }
}



