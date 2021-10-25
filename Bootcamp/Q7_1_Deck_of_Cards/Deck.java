package Q7_1_Deck_of_Cards;

import java.util.ArrayList;

public class Deck <T extends Card> {
    private ArrayList<T> cards;
    private int dealtIndex = 0;
    
    public void setDeckOfCards(ArrayList<T> deckOfCards){
        this.cards = (ArrayList<T>) deckOfCards.clone();
    }

    public void shuffle(){}

    public int remainingCards(){
        return cards.size();
    }

    public T[] dealHand(int number){
        return null;}
    
    public T[] dealCard(){
        return null;}

    
    
}
