package com.example.mother_pls_help;

import com.example.mother_pls_help.VideoController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public  class Answer2_1 {
    @FXML

    private MediaView mediaView;

    @FXML
    private Button playButton;

    @FXML
    private RadioButton Milk_button, Eurasia_button, Antar_button;

    @FXML
    private Button pauseButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button nextButton;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    public void getAnimal(javafx.event.ActionEvent actionEvent) {
        if (Milk_button.isSelected()) {
            openNewScene("Answer2_1video.fxml");
        }

    }




    private void openNewScene(String window) {
        // nextQuestion().getScene.getWindow().hide();

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


    public void playMedia(){
        mediaPlayer.play();
    }
}





