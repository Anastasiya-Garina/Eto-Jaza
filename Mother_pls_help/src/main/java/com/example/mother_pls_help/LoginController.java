package com.example.mother_pls_help;

import java.io.IOException;
import java.net.URL;
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
import java.sql.ResultSet;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private TextField SignInCodeword;

    @FXML
    private TextField SignInLoginField;

    @FXML
    private Button SignInButton;

    @FXML
    private Button SignUpButtonLogin;

    @FXML
    void initialize() {

        SignInButton.setOnAction(event ->{
            String loginText = SignInLoginField.getText().trim();
            String loginPassword = PasswordField.getText().trim();
            String codeword = SignInCodeword.getText().trim();
            
            if(!loginText.equals("") && !loginPassword.equals("") && !codeword.equals("")){
            loginUser(loginText,loginPassword,codeword);
            }
            else{
                System.out.println("Login or password is empty");
            }
        });

//        SignUpButtonLogin.setOnAction(actionEvent -> {
//            SignUpButtonLogin.getScene().getWindow().hide();
//
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/com/example/mother_pls_help/Registration.fxml"));
//
//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
//
//        });

    }

    private void loginUser(String loginText, String loginPassword, String codeword) {
    DatabaseHandler dbHandler = new DatabaseHandler();
    User user = new User();
    user.setNickname(loginText);
    user.setPassword(loginPassword);
    user.setCodeword(codeword);

    ResultSet result = dbHandler.getUser(user);

    int counter = 0;

    try {
        while(result.next()){
            counter++;
        }
    }
    catch (SQLException e) {
        e.printStackTrace();
    }
    if(counter >=1){
        openNewScene("/com/example/mother_pls_help/VideoPlot.fxml");
    }

    }
    @FXML
    public void signUpClick(ActionEvent event) throws IOException {
        openNewScene("Registration.fxml");
    }

    private void openNewScene(String window) {

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



    }

//    public void openNewScene(String window){
//        //SignUpButtonLogin.getScene().getWindow().hide();
//
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource(window));
//
//        try {
//            loader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Parent root = loader.getRoot();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root));
//        stage.showAndWait();
//
//
//    }
}
