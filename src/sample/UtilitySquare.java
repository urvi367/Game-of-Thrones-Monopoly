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


public class UtilitySquare extends Square {

    private String name;
    private int cost;
    private int owner;
    //red dessert wala thingggg
    public UtilitySquare(String id, String name)
    {
        super(id);
        this.name=name;
        this.cost=150;
        this.owner=-1;
    }

    @Override
    void doAction(Player player, Label label) {
        if(owner==-1)
        {
            Stage window=new Stage();

            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("GameOfThrones");
            window.setMinWidth(250);
            Label label1 = new Label();
            label1.setText("Do You wish to buy "+name+ " for "+ Integer.toString(cost)+" gold dragons ?");
            label1.setStyle("-fx-background-color: rgba(0,0,0,0.07);"+"-fx-text-fill: white;"+"-fx-font-family: Calibri;"+"-fx-font-size: 15;");
            Button closeButton=new Button("Ok");
            closeButton.setStyle("-fx-background-color: rgba(0,0,0,0.21);"+"-fx-text-fill: white;"+"-fx-font-family: Calibri");
            closeButton.setOnAction(w->{
                window.close();
                owner=Controller.turn;
                player.setMoney(player.getMoney()-150);
                label.setText("You bought " + name +" for 150 gold dragons!");
                player.setUtiliesOwned(player.getUtiliesOwned()+1);

            });

            VBox layout =  new VBox(10);
            try{
                String s="C:/Users/bharg/IdeaProjects/Game of thrones/res/utility_square.jpg";
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
        else
        {
            if(owner!=Controller.turn)
            {
                int rent;
                if(Controller.playerList[owner].getUtiliesOwned()==2)
                    rent=10*player.getDiceTotal();
                else
                    rent=4*player.getDiceTotal();
                player.setMoney(player.getMoney()-rent);
                Controller.playerList[owner].setMoney(Controller.playerList[owner].getMoney()+rent);
                label.setText("You paid "+ Integer.toString(rent)+" to "+ Controller.playerList[owner].getName());
            }
            else
                label.setText("");
        }
    }
}
