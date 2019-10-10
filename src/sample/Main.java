package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

import java.io.File;
import java.util.ArrayList;

public class Main extends Application {
    private int n = 2;
    public final int WIDTH=980;
    public final int HEIGHT=690;
    private ArrayList<Player> playerArrayList = new ArrayList<Player>(n);
    private ArrayList<Dice> diceArrayList = new ArrayList<Dice>(n);
    Scene scene1,scene2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        String path = "D:/JavaProject/gotmonopoly.mp4";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        Button exit_button=new Button("X");
        exit_button.setLayoutX(WIDTH - 30);
        exit_button.setLayoutY(10);
        exit_button.setStyle("-fx-background-color: rgb(0,0,0);"+"-fx-text-fill: white;"+"-fx-font-family: Droidiga");
        exit_button.setOnAction(event ->
        {
            try{primaryStage.close();
                Controller.exit_fun(Controller.playerList);

            }
            catch (Exception e){}
        });
        Button exit_button_start=new Button("X");
        exit_button_start.setLayoutX(WIDTH - 30);
        exit_button_start.setLayoutY(10);
        exit_button_start.setStyle("-fx-background-color: rgb(0,0,0);"+"-fx-text-fill: white;"+"-fx-font-family: Droidiga");
        exit_button_start.setOnAction(event ->primaryStage.close());
        Button button=new Button("Start");
        button.setLayoutX(WIDTH/2);
        button.setLayoutY(HEIGHT-100);
        button.setStyle("-fx-background-color: rgba(0,0,0,0.21);"+"-fx-text-fill: white;"+"-fx-font-family: Droidiga");
        button.setOnAction(event -> {primaryStage.setScene(scene2);
            primaryStage.setTitle("GOT Monopoly");
            mediaPlayer.stop();
        }
        );
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                primaryStage.setScene(scene2);
                primaryStage.setTitle("GOT Monopoly");
                mediaPlayer.stop();
            }
        });
        Group root1 = new Group();
        root1.getChildren().addAll(mediaView,button,exit_button_start);
        scene1 = new Scene(root1,WIDTH,HEIGHT);
        Parent root2 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Group root = new Group();
        root.getChildren().addAll(root2,exit_button);
        scene2=new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle("Game of Thrones");
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Welcome to GOT");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }

}


