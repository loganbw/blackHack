package com.logan;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private ArrayList<Card> cards = new ArrayList<Card>();

    public Hand() {

    }

    public void draw(Deck deck){
        Card newCard = deck.drawCard();
        this.cards.add(newCard);
    }


    public ArrayList<Card> getCards() {
        return this.cards;
    }




}
