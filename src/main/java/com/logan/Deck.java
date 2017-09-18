package com.logan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private String[] suits = {"spade", "club", "heart", "diamond"};
    private int deckSize = 0;

    public Deck() {
        for (String suit : suits){
            for (int i = 1; i <= 13; i++) {
                cards.add(new Card(i,suit));
                deckSize++;
            }
        }
    }

    public int getDeckSize() {
        return deckSize;
    }
    public int _getDeckSize(){
        return cards.size();
    }


    public Card drawCard() {
        deckSize--;
        return cards.remove(0);
    }

    public void shuffle(){
        Collections.shuffle(cards);
        }

    }

