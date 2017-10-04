package com.logan;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();
        deck.shuffle();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Lets play Black Jack");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        boolean dealerDraw = false;
        int sum = 0;
        int dealerSum = 0;

        Scanner scanner = new Scanner(System.in);

        while(true) {
            if (sum > 21) {
                System.out.println("you loss!");
                break;
            }  if (dealerSum > 21) {
                System.out.println("You've Won!");
                break;
                }

            if (dealerDraw) {
                // the dealer draws if he is lower that the player
                if (dealerSum < 17) {
                    dealerHand.draw(deck);
                    dealerSum = 0;
                    for (Card card : dealerHand.getCards()) {
                        Integer cardValue = card.getFaceValue();
                        if (card.getFaceValue()  == 1 && sum <= 10){
                            cardValue = 11;
                        }
                        if (card.getFaceValue()  == 11 && sum >= 11){
                            cardValue = 1;
                        }

                        if (card.getFaceValue() == 11
                                || card.getFaceValue()  == 12
                                || card.getFaceValue()  == 13){
                            cardValue = 10;
                        }
                        System.out.println("dealer drew " + cardValue);
                        dealerSum += cardValue;
                        System.out.println( "the sum of the dealers cards are " + dealerSum + " " + card.getSuite());
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

                    }
                }
                if (dealerSum >= sum && sum != 0 && dealerSum < 22 ){
                    System.out.println("the dealer wins");
                    break;
                }
            }
            if (!dealerDraw) {
                if (playerHand.getCards().isEmpty() && dealerHand.getCards().isEmpty()) {
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("First Draw");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    for (int i = 0; i < 2; i++) {
                        playerHand.draw(deck);
                        //this for loop checks for ace's and jack queen's and king's
                        for (Card card : playerHand.getCards()) {
                            Integer cardValue = card.getFaceValue();
                            if (card.getFaceValue()  == 1 && sum <= 10){
                                cardValue = 11;
                            }
                            if (card.getFaceValue()  == 11 && sum >= 11){
                                cardValue = 1;
                            }

                            if (card.getFaceValue() == 11
                                    || card.getFaceValue()  == 12
                                    || card.getFaceValue()  == 13){
                                cardValue = 10;
                            }

                            sum += cardValue;
                        }
                    }
                    dealerHand.draw(deck);
                    for (Card card : dealerHand.getCards()) {
                        Integer cardValue = card.getFaceValue();
                        if (card.getFaceValue()  == 1 && sum <= 10){
                            cardValue = 11;
                        }
                        if (card.getFaceValue()  == 11 && sum >= 11){
                            cardValue = 1;
                        }

                        if (card.getFaceValue() == 11
                                || card.getFaceValue()  == 12
                                || card.getFaceValue()  == 13){
                            cardValue = 10;
                        }
                        System.out.println("dealer drew " + cardValue);
                        dealerSum += cardValue;
                        System.out.println("the dealer has " + dealerSum + " " + card.getSuite() );
                    }

                }

                else {
                    System.out.println("hit or stay?");
                    String drawChoice = scanner.nextLine();
                    if (drawChoice.equals("hit")) {
                        playerHand.draw(deck);
                    }  else if (drawChoice.equals("stay")) {
                        dealerDraw = true;
                    }
                }

            sum = 0;
            for (Card card : playerHand.getCards()) {
                Integer cardValue = card.getFaceValue();
                    if (card.getFaceValue()  == 1 && sum <= 10){
                        cardValue = 11;
                    }
                if (card.getFaceValue()  == 11 && sum >= 11){
                    cardValue = 1;
                }

                    if (card.getFaceValue() == 11
                        || card.getFaceValue()  == 12
                        || card.getFaceValue()  == 13){
                        cardValue = 10;
                    }

                sum += cardValue;
                System.out.println("you have " + cardValue + " " + card.getSuite() + " in your hand");
            }
                System.out.println("You are sitting at " + sum);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            if (sum == 21 && playerHand.getCards().size() == 2) {
                System.out.println("YOU HIT BLACKJACK!");
                break;
            }

        }
    }}


}
