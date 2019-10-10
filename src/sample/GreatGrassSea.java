package sample;

import javafx.scene.control.Label;

//free parking
public class GreatGrassSea extends Square {

    public GreatGrassSea(String id) {
        super(id);
    }

    @Override
    void doAction(Player player, Label label) {
        label.setText("Enjoy your time as a wanderer in the Great Grass Sea!");
    }
}
