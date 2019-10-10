package sample;

import java.util.*;

public class Player {
    private String name;
    private int money;
    private int position;
    public ArrayList<PropertySquare> propertyOwned;
    private boolean inJail;
    private int outOfJailCards;
    private int utiliesOwned;
    private int numRailRoads; //housesquare
    private int diceTotal;

    public Player() {
        this.name = "Player";
        this.money = 1500;
        this.position = 0;
        this.inJail = false;
        this.outOfJailCards = 0;
        this.utiliesOwned=0;
        this.numRailRoads=0;
        this.diceTotal=0;
        propertyOwned=new ArrayList<>();
    }

    public Player(String name) {
        this.name = name;
        this.money = 1500;
        this.position = 0;
        this.inJail = false;
        this.outOfJailCards = 0;
        this.utiliesOwned=0;
        this.numRailRoads=0;
        this.diceTotal=0;
        propertyOwned=new ArrayList<>();
    }

    public int getDiceTotal() {
        return diceTotal;
    }

    public void setDiceTotal(int diceTotal) {
        this.diceTotal = diceTotal;
    }

    public int getOutOfJailCards() {
        return outOfJailCards;
    }

    public void setOutOfJailCards(int outOfJailCards) {
        this.outOfJailCards = outOfJailCards;
    }

    public int getUtiliesOwned() {
        return utiliesOwned;
    }

    public void setUtiliesOwned(int utiliesOwned) {
        this.utiliesOwned = utiliesOwned;
    }

    public int getNumRailRoads() {
        return numRailRoads;
    }

    public void setNumRailRoads(int numRailRoads) {
        this.numRailRoads = numRailRoads;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ArrayList<PropertySquare> getPropertyOwned() {
        return propertyOwned;
    }

    public void setPropertyOwned(ArrayList<PropertySquare> propertyOwned) {
        this.propertyOwned = propertyOwned;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

}
