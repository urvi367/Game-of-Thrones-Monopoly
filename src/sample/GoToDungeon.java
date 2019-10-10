package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;

//go to jail
public class GoToDungeon extends Square {

    public GoToDungeon(String id) {
        super(id);
    }

    @Override
    void doAction(Player player, Label label) {

        label.setText("You have been thrown into the Dungeons!");
        AlertBox.display("Shame !","You have been thrown into the Dungeons!");
        player.setInJail(true);
    }
}
