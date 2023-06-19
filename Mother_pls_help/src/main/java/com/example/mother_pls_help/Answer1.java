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


public  class Answer1 implements Initializable{
    @FXML

    private MediaView mediaView;

    @FXML
    private Button playButton;

    @FXML
    private RadioButton Africa_button, Eurasia_button, Antar_button;

    @FXML
    private Button pauseButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button nextButton;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    public void getContinent(javafx.event.ActionEvent actionEvent) {
        if (Africa_button.isSelected()) {
            openNewScene("Answer1video.fxml");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        file = new File("C:\\Users\\Полина\\OneDrive\\Рабочий стол\\Eto-Jaza-main\\Mother_pls_help\\src\\main\\resources\\com\\example\\mother_pls_help\\videos_java_app\\mebib.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
    }
    public void playMedia(){
        mediaPlayer.play();
    }
}





