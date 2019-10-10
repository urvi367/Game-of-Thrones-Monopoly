package sample;

import javafx.scene.control.Label;

//jail
public class DungeonSquare extends Square {

    public DungeonSquare(String id) {
        super(id);
    }

    @Override
    void doAction(Player player, Label label) {
        label.setText("You are visiting the Dungeons!");
        if(player.getMoney()<200)
        {
            player.setMoney(0);
            try{Controller.exit_fun(Controller.playerList);}
            catch (Exception e){}
        }

        player.setInJail(true);

    }
}
