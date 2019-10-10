package sample;

import javafx.scene.control.Label;


abstract public class Square {

    String id;

    public Square(String id) {
        this.id = id;
    }

    abstract void doAction(Player player, Label label);

    public static Square[] createBoard()
    {
        String[] name={"Craster's Keep", "The Fist of The First Men", "The Nightfort", "Mole's Town", "The Inn at the Crossroads", "Vaes Dothrak", "Quarth", "Pentos", "The Eyrie", "Dragonstone", "Moat Calin", "Harrenhal", "The Dreadfort", "The Twins", "Astapor", "Yunkai", "Mereen", "Castle Black", "Pyke", "Winterfell", "Braavos", "King's Landing"};
        int[] cost={60, 60, 100, 100, 120, 140, 140, 160, 180, 180, 200, 220, 220, 240, 260, 260, 280, 300, 300, 320, 350, 400};
        int[] rent={2,  4,  6,   6,   8,   10,  10,  12,  14,  14,  16,  18,  18,  20,  22,  22,  24,  26,  26,  28,  35,  50};

        String[] houseName={"House Lannister's", "House Baratheon's", "House Targaryan's", "House Stark's"};

        Square[] squares = new Square[40];

        int j=0, k=0;
        for(int i=0; i<40; i++)
        {
            if(i==0)
                squares[i]=new IronBankSquare("Go");
            else if (i==10)
                squares[i]=new DungeonSquare("jail");
            else if (i==20)
                squares[i]=new GreatGrassSea("freeParking");
            else if (i==30)
                squares[i]=new GoToDungeon("goToJail");
            else if(i==7 || i==22 || i==36)
                squares[i]=new ValarMorghulisSquare("valarMorghulis");
            else if(i==2 || i==17 || i==33)
                squares[i]=new IronThroneSquare("ironThrone");
            else if(i==12)
                squares[i]=new UtilitySquare("utility", "The Red Wastes");
            else if(i==28)
                squares[i]=new UtilitySquare("utility", "The Wall");
            else if(i==5 || i==15 || i==25 || i==35)
            {
                squares[i]=new HouseSquare("house", houseName[k]);
                k++;
            }
            else if(i==4)
                squares[i]=new TaxSquare("tax", 200);
            else if(i==38)
                squares[i]=new TaxSquare("tax", 100);
            else
            {
                    squares[i]=new PropertySquare("property", name[j], cost[j], rent[j], i);
                    j++;
            }
        }

        return squares;
    }

    public String toString()
    {
        return "id: " +id;
    }
}
