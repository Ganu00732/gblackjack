package src.com.excercise.blackjack.controller;

import src.com.excercise.blackjack.model.Deck;
import src.com.excercise.blackjack.service.BlackJackService;
import java.util.Scanner;

public class BlackJack {

    public static void main(String args[]){

        System.out.println("Welcome to BlackJack! ----- Initiating Program");

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffleDeck();

        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();

        double playerMoney = 100;

        Scanner userInput = new Scanner(System.in);
        BlackJackService service = new BlackJackService();
        //Game Execution
        service.gamePlay(playingDeck, playerDeck, dealerDeck, playerMoney, userInput);
        System.out.println("Game over! :(");
    }
}
