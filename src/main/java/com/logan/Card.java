package com.logan;

public class Card {

    private int faceValue;
    private String suit;

    public Card(int faceValue, String suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public String getSuite() {
        return suit;
    }

    public void setSuite(String suite) {
        this.suit = suite;
    }
}
