package sample;

import java.security.PublicKey;
import java.util.ArrayList;

public class Dice {
    private int num1;
    private int num2;
    private int prev_num1;
    private int prev_num2;
    private int prev_prev_num1;
    private int prev_prev_num2;

    Dice()
    {
        prev_prev_num1=0;
        prev_prev_num2=0;
        prev_num1 = 0;
        prev_num2 = 0;
        num1=0;
        num2=0;
    }

    public boolean isDoublesThrice()
    {
        if(num1==num2 && num1!=0 && num2!=0 && prev_num2!=0 && prev_num1!=0 && prev_num2==prev_num1 && prev_prev_num1!=0 && prev_prev_num2!=0 && prev_prev_num1==prev_prev_num2)
            return true;
        else
            return false;
    }

    public void setDice(int a, int b) {
        this.prev_prev_num2 = this.prev_num2;
        this.prev_prev_num1 = this.prev_num1;
        this.prev_num2 = this.num2;
        this.prev_num1 = this.num1;
        this.num1=a;
        this.num2=b;
    }

    public static ArrayList<Dice> createDices(int n)
    {
        ArrayList<Dice> diceArrayList = new ArrayList<Dice>(n);
        for(int i=0; i<n; i++)
        {
            diceArrayList.add(new Dice());
        }
        return diceArrayList;
    }
}
