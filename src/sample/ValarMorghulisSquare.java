package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.Random;

public class ValarMorghulisSquare extends Square {

    public ValarMorghulisSquare(String id) {
        super(id);
    }

    @Override
    void doAction(Player player, Label label) {
            Stage window=new Stage();
            ValarMorghulisCard valarmorghulis=new ValarMorghulisCard();
            Random random = new Random();
            int x=random.nextInt(6);
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Iron Thrones");
            window.setMinWidth(250);
            Label label1 = new Label();
            label1.setText(valarmorghulis.strings[x]);
            label1.setStyle("-fx-background-color: rgba(0,0,0,0.07);"+"-fx-text-fill: white;"+"-fx-font-family: Calibri;"+"-fx-font-size: 15;");
            Button closeButton=new Button("Ok");
            closeButton.setStyle("-fx-background-color: rgba(0,0,0,0.21);"+"-fx-text-fill: white;"+"-fx-font-family: Calibri");
            closeButton.setOnAction(w->{
                window.close();
                player.setMoney(player.getMoney()-valarmorghulis.fine[x]);
                label.setText(valarmorghulis.strings_label[x]);
            });

            VBox layout =  new VBox(10);
            try{
                String s="C:/Users/bharg/IdeaProjects/Game of thrones/res/valar_morghulis.png";
                FileInputStream f=new FileInputStream(s);
                Image image= new Image(f);
                BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                layout.setBackground(background);
            }
            catch (Exception e)
            {

            }
            layout.getChildren().addAll(label1,closeButton);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout,600,300);
            window.setScene(scene);
            window.showAndWait();



        }
}
