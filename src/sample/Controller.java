package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label amt;
    @FXML
    private Label name;
    @FXML
    private Label textView;
    @FXML
    private ImageView board;
    @FXML
    private Button dice;
    @FXML
    private Button end;
    @FXML
    private Button sell;
    @FXML
    private ImageView dice1;
    @FXML
    private ImageView dice2;
    @FXML
    private ImageView square0;
    @FXML
    private ImageView square1;
    @FXML
    private ImageView square2;
    @FXML
    private ImageView square3;
    @FXML
    private ImageView square4;
    @FXML
    private ImageView square5;
    @FXML
    private ImageView square6;
    @FXML
    private ImageView square7;
    @FXML
    private ImageView square8;
    @FXML
    private ImageView square9;
    @FXML
    private ImageView square10;
    @FXML
    private ImageView square11;
    @FXML
    private ImageView square12;
    @FXML
    private ImageView square13;
    @FXML
    private ImageView square14;
    @FXML
    private ImageView square15;
    @FXML
    private ImageView square16;
    @FXML
    private ImageView square17;
    @FXML
    private ImageView square18;
    @FXML
    private ImageView square19;
    @FXML
    private ImageView square20;
    @FXML
    private ImageView square21;
    @FXML
    private ImageView square22;
    @FXML
    private ImageView square23;
    @FXML
    private ImageView square24;
    @FXML
    private ImageView square25;
    @FXML
    private ImageView square26;
    @FXML
    private ImageView square27;
    @FXML
    private ImageView square28;
    @FXML
    private ImageView square29;
    @FXML
    private ImageView square30;
    @FXML
    private ImageView square31;
    @FXML
    private ImageView square32;
    @FXML
    private ImageView square33;
    @FXML
    private ImageView square34;
    @FXML
    private ImageView square35;
    @FXML
    private ImageView square36;
    @FXML
    private ImageView square37;
    @FXML
    private ImageView square38;
    @FXML
    private ImageView square39;

    private static int n=2;  //n=number of players. Probably make starting page to ask thisss and namesss. 2 to 6 onlyyyyyy
    public static Player[] playerList=new Player[n];
    private ArrayList<Dice> diceArrayList = new ArrayList<Dice>(n);
    static Square[] squares;
    static int turn=0;
    private Dice d;
    private ImageView img;
    private File file;
    private Image image;
    private Alert a=new Alert(Alert.AlertType.NONE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setStyle("-fx-text-fill: white;"+"-fx-font-family: Droidiga");
        dice.setStyle("-fx-background-color: rgba(242,241,249,0.38);"+"-fx-text-fill: white;"+"-fx-font-family: Droidiga");
        end.setStyle("-fx-background-color: rgba(242,241,249,0.38);"+"-fx-text-fill: white;"+"-fx-font-family: Droidiga");
        sell.setStyle("-fx-background-color: rgba(242,241,249,0.38);"+"-fx-text-fill: white;"+"-fx-font-family: Droidiga");
        //set board ka image
        file = new File("res/monopoly-GOT-1.jpg");
        image = new Image(file.toURI().toString());
        board.setImage(image);

        //create board
        squares=Square.createBoard();
        diceArrayList=Dice.createDices(n);
        for(int i=0; i<n; i++)
        {
            playerList[i]=new Player("Player " + i+1);
        }

        name.setText("Player " + Integer.toString(turn+1));
        amt.setText(Integer.toString(playerList[turn].getMoney()));
        end.setDisable(true);
    }

    public void endTurnClick(ActionEvent actionEvent) throws Exception{
        dice2.setImage(null);
        dice1.setImage(null);
        textView.setText("");
        if(playerList[turn].getMoney()<=0){
            Stage s=(Stage) end.getScene().getWindow();
            s.close();
            exit_fun(playerList);
        }
        turn=(turn+1)%n;
        dice.setDisable(false);
        name.setText("Player " + Integer.toString(turn+1));
        amt.setText(Integer.toString(playerList[turn].getMoney()));
        end.setDisable(true);
    }

    //roll dice button click
    public void handleButtonClick(ActionEvent actionEvent) throws Exception {
        end.setDisable(false);
        if(playerList[turn].isInJail())
        {
            textView.setText("You are in jail. You can not move.");
            img = (ImageView) getClass().getDeclaredField("square" + Integer.toString(10)).get(this);
            file = new File("res/marker" + Integer.toString(turn + 1) + ".png");
            image = new Image(file.toURI().toString());
            img.setImage(image);

            getOutOfJail(playerList[turn],diceArrayList.get(turn));

            //do: alert dialogue to ask to use get of jail card or pay 50 to get out
        }
        else {
            int num_dice1 = roll_dice();
            int num_dice2 = roll_dice();

            setImage(dice1, num_dice1);
            setImage(dice2, num_dice2);

            d = diceArrayList.get(turn);
            d.setDice(num_dice1, num_dice2);
            diceArrayList.set(turn, d);
            playerList[turn].setDiceTotal(num_dice1 + num_dice2);

            if (d.isDoublesThrice())
            {

                //remove purana marker for player
                img = (ImageView) getClass().getDeclaredField("square" + Integer.toString(playerList[turn].getPosition())).get(this);
                img.setImage(null);
                playerList[turn].setInJail(true);
                playerList[turn].setPosition(10);

                //put marker at new position
                img = (ImageView) getClass().getDeclaredField("square" + 10).get(this);
                file = new File("res/marker" + Integer.toString(turn + 1) + ".png");
                image = new Image(file.toURI().toString());
                img.setImage(image);
                textView.setText("You drew doubles thrice and hence will be thrown in the dungeons!");
            }
            else {
                    int cur_pos = playerList[turn].getPosition() + num_dice1 + num_dice2;
                    if (cur_pos > 39) {
                        playerList[turn].setMoney(playerList[turn].getMoney() + 200);
                        cur_pos = cur_pos % 40;
                        AlertBox.display("GoT","You passed the Iron Bank. We give you another 200 gold dragons!");
                    }

                    //remove purana marker for player
                    img = (ImageView) getClass().getDeclaredField("square" + Integer.toString(playerList[turn].getPosition())).get(this);
                    img.setImage(null);

                    playerList[turn].setPosition(cur_pos);

                    //put marker at new position
                    img = (ImageView) getClass().getDeclaredField("square" + Integer.toString(cur_pos)).get(this);
                    file = new File("res/marker" + Integer.toString(turn + 1) + ".png");
                    image = new Image(file.toURI().toString());
                    img.setImage(image);
                    int temp=cur_pos;
                    squares[cur_pos].doAction(playerList[turn], textView);

                    if (squares[temp].id.equals("ironThrone")) {


                        img = (ImageView) getClass().getDeclaredField("square" + Integer.toString(temp)).get(this);
                        img.setImage(null);
                        //put marker at new position
                        img = (ImageView) getClass().getDeclaredField("square" + Integer.toString(playerList[turn].getPosition())).get(this);
                        file = new File("res/marker" + Integer.toString(turn + 1) + ".png");
                        image = new Image(file.toURI().toString());
                        img.setImage(image);
                    }
                    else if(squares[temp].id.equals("jail")){
                        playerList[turn].setInJail(true);

                    }
                    else if (squares[temp].id.equals("goToJail"))
                    {
                        playerList[turn].setInJail(true);
                        playerList[turn].setPosition(10);
                        img = (ImageView) getClass().getDeclaredField("square" + Integer.toString(temp)).get(this);
                        img.setImage(null);
                        //put marker at new position
                        img = (ImageView) getClass().getDeclaredField("square" + Integer.toString(playerList[turn].getPosition())).get(this);
                        file = new File("res/marker" + Integer.toString(turn + 1) + ".png");
                        image = new Image(file.toURI().toString());
                        img.setImage(image);
                    }
                }
            amt.setText(Integer.toString(playerList[turn].getMoney()));
            dice.setDisable(true);
        }
    }

    //sell land button click
    public void onClickSell(ActionEvent actionEvent)  {
        System.out.println(playerList[turn].getPropertyOwned());
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Sell the Forts");
        window.setMinWidth(250);
        window.setMinHeight(250);
        Label label1 = new Label();
        label1.setText("Select the House you want to sell:");
        label1.setStyle("-fx-background-color: rgba(0,0,0,0);"+"-fx-text-fill: #FFFFFF;"+"-fx-font-family: Calibri;"+"-fx-font-size: 15;");
        try {
            ArrayList<PropertySquare> propertie = playerList[turn].getPropertyOwned();
            System.out.println(propertie.size());
            VBox layout = new VBox(10);
            layout.getChildren().add(label1);
            if (propertie.size() == 0) {
                Label label2 = new Label();
                label2.setText("No house found !");
                label2.setStyle("-fx-background-color: rgba(0,0,0,0);" + "-fx-text-fill: #FFFFFF;" + "-fx-font-family: Calibri;" + "-fx-font-size: 10;");
                layout.getChildren().add(label2);
            } else {
                final int x = 0;
                ArrayList<Button> b = new ArrayList<>();
                for (int i = 0; i < propertie.size(); i++) {
                    b.add(new Button(propertie.get(i).getName()));
                    b.get(i).setStyle("-fx-background-color: rgba(237,237,237,0.99);" + "-fx-text-fill: #FFFFFF;" + "-fx-font-family: Calibri");
                    int finalI = i;
                    b.get(i).setOnAction(e ->
                    {
                        playerList[turn].setMoney(playerList[turn].getMoney()+propertie.get(finalI).getPrice());
                       squares[propertie.get(finalI).num]= new PropertySquare("property", propertie.get(finalI).getName(),propertie.get(finalI).getPrice(),propertie.get(finalI).getRent(),propertie.get(finalI).num);
                        b.remove(finalI);
                        propertie.remove(finalI);
                        window.close();
                    });
                    layout.getChildren().add(b.get(i));
                }
                playerList[turn].setPropertyOwned(propertie);

            }

            layout.setAlignment(Pos.CENTER);
            layout.setStyle("-fx-background-color: rgba(0,0,0,1)");
            Scene scene = new Scene(layout, 600, 300);
            window.setScene(scene);
            window.showAndWait();
        }
        catch (Exception e){

        }
    }

    private int roll_dice()
    {
       Random rand = new Random();
       return rand.nextInt(6)+1;
    }

    public void setImage(ImageView image, int num)
    {
        File file;

        if(num==1)
            file=new File("res/Alea_1.png");
        else if(num==2)
            file=new File("res/Alea_2.png");
        else if(num==3)
            file=new File("res/Alea_3.png");
        else if(num==4)
            file=new File("res/Alea_4.png");
        else if(num==5)
            file=new File("res/Alea_5.png");
        else
            file=new File("res/Alea_6.png");

        Image img=new Image(file.toURI().toString());
        image.setImage(img);
    }
    public static void getOutOfJail(Player player,Dice s){
        AlertBox.display("Shame ","200 Dragon Coins to get out !");
        player.setMoney(player.getMoney()-200);
        s.setDice(0,0);
        player.setInJail(false);
    }
    public static void exit_fun(Player []player) throws Exception
    {
        int pos=0;
        int max=player[pos].getMoney();
        for(int i=1;i<player.length;i++)
        {
            if(max<player[i].getMoney())
            {
                max=player[i].getMoney();
                pos=i;
            }
            else if(max==player[i].getMoney())
                pos=-1;
        }

        Stage stage = new Stage();
        stage.setTitle("Game Over");
        stage.setMinWidth(150);
        Label label1 = new Label();
        if(pos>=0)
        label1.setText("! Player "+(pos+1)+" won !");
        else
            label1.setText("Game Draw");
        label1.setStyle("-fx-background-color: rgba(0,0,0,0.07);"+"-fx-text-fill: white;"+"-fx-font-family: Droidiga;"+"-fx-font-size: 25;");
        VBox layout =  new VBox(10);
        try{
            String s="C:/Users/bharg/IdeaProjects/Game of thrones/res/throne.jpg";
            FileInputStream f=new FileInputStream(s);
            Image image= new Image(f);
            BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background background = new Background(backgroundImage);
            layout.setBackground(background);
        }
        catch (Exception e)
        {

        }
        layout.getChildren().addAll(label1);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,600,300);
        stage.setScene(scene);
        stage.show();

    }

}

