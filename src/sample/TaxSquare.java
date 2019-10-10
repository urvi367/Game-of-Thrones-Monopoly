package sample;

import javafx.scene.control.Label;

public class TaxSquare extends Square {

    private int tax;

    public TaxSquare(String id, int tax) {
        super(id);
        this.tax=tax;
    }

    @Override
    void doAction(Player player, Label label) {
        player.setMoney(player.getMoney()-tax);
        label.setText("Pay "+Integer.toString(tax)+" gold dragons to the Crown!");
    }
}
