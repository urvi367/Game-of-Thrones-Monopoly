package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Optional;

public class PropertySquare extends Square {

    public int num;
    private String name;
    private int price;
    public int owner;
    private int rent;
    private String colour;  //add houses and colour wala thing, change rent if nearby service owned
    private int numOfHouses;

    /*public PropertySquare(String id, String name, int price, int rent) {
        super(id);
        this.name = name;
        this.price = price;
        this.owner = -1;
        this.rent = rent;
    }*/

    public PropertySquare(String id, String name, int price, int rent, int num) {
        super(id);
        this.name = name;
        this.price = price;
        this.owner = -1;
        this.rent = rent;
        this.num=num;
    }

    public PropertySquare(String id) {
        super(id);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    void doAction(Player player, Label label) {
        if(owner==-1 && player.getMoney()>price) //if no owner, then
        {
            Stage window=new Stage();

            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("GameOfThrones");
            window.setMinWidth(250);
            Label label1 = new Label();
            label1.setText("Do You wish to buy "+name+ " for "+ Integer.toString(price)+" gold dragons ?");
            Label label2 = new Label();
            label1.setStyle("-fx-background-color: rgba(0,0,0,0.07);"+"-fx-text-fill: white;"+"-fx-font-family: Calibri;"+"-fx-font-size: 15;");
            label2.setStyle("-fx-background-color: rgba(0,0,0,0.07);"+"-fx-text-fill: white;"+"-fx-font-family: Calibri;"+"-fx-font-size: 15;");
            label2.setText("You would get rent of "+rent+" gold dragons ..!");
            Button closeButton=new Button("Ok");
            closeButton.setStyle("-fx-background-color: rgba(0,0,0,0.21);"+"-fx-text-fill: white;"+"-fx-font-family: Calibri");
            closeButton.setOnAction(w->{
                    window.close();
                    owner=Controller.turn;
                    player.setMoney(player.getMoney()-price);
                    player.propertyOwned.add(new PropertySquare(id,name,price,rent, num));
                    label.setText("You bought " + name+" for "+Integer.toString(price)+" gold dragons!");

                });

            VBox layout =  new VBox(10);
            try{
                String s="C:/Users/bharg/IdeaProjects/Game of thrones/res/images.jpg";
                FileInputStream f=new FileInputStream(s);
                Image image= new Image(f);
                BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);
                layout.setBackground(background);
            }
            catch (Exception e)
            {

            }
            layout.getChildren().addAll(label1,label2,closeButton);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout,600,300);
            window.setScene(scene);
            window.showAndWait();

        }
        else
        {
            if(owner!=Controller.turn && player.getMoney()>rent) //if owner is != current player, pay rent
            {
                player.setMoney(player.getMoney()-rent);
                Controller.playerList[owner].setMoney(Controller.playerList[owner].getMoney()+rent);
                label.setText("You paid "+ Integer.toString(rent)+" gold dragons to "+ Controller.playerList[owner].getName()+ " as rent!");
            }
            else if(player.getMoney()<=rent)
                player.setMoney(0);
            else
                label.setText("");
        }
    }

}
