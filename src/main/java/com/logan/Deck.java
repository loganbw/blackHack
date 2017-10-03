package com.logan;

import java.util.*;

public class Deck {
    protected ArrayList<Card> cards = new ArrayList<Card>();
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

    public Deck(ArrayList<Card> cards) {
        this.cards = cards;
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
        Random rng = new Random();

        Collections.shuffle(cards, rng);
        // isn't joel cute?
    }

    public void showCard() {
//        List<Card> hand = new ArrayList<Card>();
//        Card thisCard = drawCard();
//        hand.add(thisCard);
//        hand.add(thisCard);
//        hand.add(thisCard);
//        System.out.println("drawn card: " + hand.get(thisCard.getFaceValue()));

    }



}

