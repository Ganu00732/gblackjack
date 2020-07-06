package src.com.excercise.blackjack.service;

import src.com.excercise.blackjack.model.Deck;
import java.util.Scanner;

public class BlackJackService {
    public void gamePlay(Deck playingDeck, Deck playerDeck, Deck dealerDeck,
                                 double playerMoney, Scanner userInput) {
        while(playerMoney > 0){
            //play on!
            //Take the players bet
            System.out.println("You have $" + playerMoney + ", how much would you like to bet?");
            double playerBet = userInput.nextDouble();
            if(playerBet > playerMoney){
                System.out.println("You cannot bet more than you have. Please check");
                break;
            }

            boolean endRound = false;

            //Start Dealing
            //Player gets two cards
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);

            //Dealer gets two cards
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            while(true){
                //Display Player hand
                System.out.println("Cards you have");
                System.out.println(playerDeck.toString());
                System.out.println("Your hand is valued at: " + playerDeck.cardsValue());

                //Display Dealer hand
                System.out.println("Dealer Hand : " + dealerDeck.getCard(0) + " and [Hidden]");

                //What does the player want to do?
                System.out.println("Would like to Hit (enter 1) or Stand (enter 2)?:");
                int response = userInput.nextInt();
                //Hit
                if(response == 1){
                    playerDeck.draw(playerDeck);
                    System.out.println("You Drew card: " + playerDeck.
                            getCard(playerDeck.deckSize() - 1).toString());
                    //Bust if > 21
                    if(playerDeck.cardsValue() > 21){
                        System.out.println("Bust.. Currently valued at : " + playerDeck.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        break;
                    }
                }
                //Stand
                if(response == 2){
                    break;
                }
            }
            //Reveal Dealer Cards
            if((dealerDeck.cardsValue() > playerDeck.cardsValue()) && endRound == false){
                System.out.println("Dealer Beats you!");
                playerMoney -= playerBet;
                endRound = true;
            }

            //Dealer Draws at 16, stands at 17
            while((dealerDeck.cardsValue() < 17) && endRound == false){
                dealerDeck.draw(playerDeck);
                System.out.println("Dealer Draws : " + dealerDeck.
                        getCard(dealerDeck.deckSize() - 1).toString());
            }

            //Display Total value for Dealer
            System.out.println("Dealder Hand is valued at: " + dealerDeck.cardsValue());

            //Determine dealer busted
            if(dealerDeck.cardsValue() > 21 && endRound == false){
                System.out.println("Dealer Busted!  You Win!!!");
                playerMoney += playerBet;
                endRound = true;
            }

            //Determine push
            if((dealerDeck.cardsValue() == playerDeck.cardsValue()) && endRound == false){
                System.out.println("Push");
                endRound = true;
            }

            //Determine player win
            if((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false){
                System.out.println("You Win the hand!!! ");
                playerMoney += playerBet;
                endRound = true;
            }else if(endRound == false){
                System.out.println("You lose the hand");
                playerMoney-= playerBet;
                endRound = true;
            }

            //moving back all to Deck player and dealer
            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);
            System.out.println("End of hand..");

        }
    }
}
