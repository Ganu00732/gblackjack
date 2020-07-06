package src.com.excercise.blackjack.controller;

import src.com.excercise.blackjack.service.BlackJackService;

import java.util.Scanner;

public class BlackJack {

    public static void main(String args[]){

        System.out.println("Welcome to BlackJack! ----- Initiating Program");

        double playerMoney = 100;

        Scanner userInput = new Scanner(System.in);
        BlackJackService service = new BlackJackService();
        //Game Execution
        int status = service.gamePlay( playerMoney, userInput);
        System.out.println("Game over! :(");
    }
}
