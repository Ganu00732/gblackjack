package src.com.excercise.blackjack.model;

import src.com.excercise.blackjack.constants.Value;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    //instance variable - cards
    private ArrayList<Card> cards;

    //constructor
    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    public void createFullDeck(){
        //Generate cards
        //iterating over all suit
        for(Suit cardSuit: Suit.values()){
            //iterating over all the values
            for(Value cardValue: Value.values()){
                cards.add(new Card(cardSuit,cardValue));
            }
        }
    }

    public void shuffleDeck(){
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        //Using Random to shuffle card
        Random rand = new Random();
        int randomCardIndex = 0;
        int originalDeckSize = this.cards.size();

        for(int i=0; i< originalDeckSize; i++){
            //Generate random index
            randomCardIndex = rand.nextInt((this.cards.size()-1 - 0) + 1) + 0;
            tempDeck.add(this.cards.get(randomCardIndex));
            //remove cards from the actual deck
            this.cards.remove(randomCardIndex);
        }
        this.cards = tempDeck;
    }

    public void removeCard(int i){
        this.cards.remove(i);
    }

    public void addCard(Card addCard){
        this.cards.add(addCard);
    }

    public Card getCard(int i){
        return this.cards.get(i);
    }

    //Draw card from the Deck
    public void draw(Deck commingFrom){
        this.cards.add(commingFrom.getCard(0));
        commingFrom.removeCard(0);
    }

    public int cardsValue(){
        int totalValue = 0;
        int aces = 0;

        for(Card aCard: this.cards){
            switch(aCard.getValue()){
                case TWO: totalValue+=2; break;
                case THREE: totalValue+=3; break;
                case FOUR: totalValue+=4; break;
                case FIVE: totalValue+=5; break;
                case SIX: totalValue+=6; break;
                case SEVEN: totalValue+=7; break;
                case EIGHT: totalValue+=8; break;
                case NINE: totalValue+=9; break;
                case TEN: totalValue+=10; break;
                case JACK: totalValue+=10; break;
                case QUEEN: totalValue+=10; break;
                case KING: totalValue+=10; break;
                case ACE: aces+=1; break;
            }
        }

        for(int i=0; i <aces; i++ ){
            //If totalvalue is > 10 we need ace to 1 and will bust
            // otherwise we add 10 to stay within game or bust
            if(totalValue > 10){
                totalValue+=1;
            }else {
                totalValue+=11;
            }
        }
        return totalValue;
    }

    //returns deck size
    public int deckSize(){
        return this.cards.size();
    }

    public void moveAllToDeck(Deck moveToDeck){
        int fullDeckSize = this.cards.size();
        //Put cards to moveToDeck
        for(int i=0 ; i < fullDeckSize; i++){
            moveToDeck.addCard(this.getCard(i));
        }
        for(int i=0 ; i < fullDeckSize; i++){
            this.removeCard(0);
        }
    }

    public String toString(){
        String cardListOutput = "";

        for(Card card: this.cards){
            cardListOutput += "\n" + card.toString();
        }
        return cardListOutput;
    }
}
