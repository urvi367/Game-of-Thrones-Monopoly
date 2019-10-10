package sample;

import javafx.scene.control.Label;

//go
public class IronBankSquare extends Square {

    public IronBankSquare(String id) {
        super(id);
    }

    @Override
    void doAction(Player player, Label label) {
        label.setText("You are at the Iron Bank of Bravoos!");
    }
}
