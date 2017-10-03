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
            } else if (dealerSum > 21) {
                System.out.println("You've Won!");
                break;
                }
            if (dealerDraw) {
                if (dealerSum < sum) {
                    dealerHand.draw(deck);
                }
                dealerSum = 0;
                for (Card card : dealerHand.getCards()) {
                    int cardValue = card.getFaceValue();
                    dealerSum += cardValue;
                }
                System.out.println(dealerSum);
            } else if (!dealerDraw) {
                if (playerHand.getCards().isEmpty()) {
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("First Draw");

                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    for (int i = 0; i < 2; i++) {
                        playerHand.draw(deck);
                    }
                } else {
                    System.out.println("hit or stay?");
                    String drawChoice = scanner.nextLine();
                    if (drawChoice.equals("hit")) {
                        playerHand.draw(deck);
                    } else if (drawChoice.equals("stay")) {
                        dealerDraw = true;
                    }
                }
            }
            sum = 0;
            for (Card card : playerHand.getCards()) {
                int cardValue = card.getFaceValue();
                sum += cardValue;
            }
            if (sum == 21 && playerHand.getCards().size() == 2) {
                System.out.println("YOU HIT BLACKJACK!");
                break;
            }
            System.out.println("You are sitting at " + sum);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        }
    }


}
