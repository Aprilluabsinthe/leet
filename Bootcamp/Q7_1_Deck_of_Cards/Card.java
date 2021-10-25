package Q7_1_Deck_of_Cards;

public abstract class Card {
    private boolean available = true;
    protected int faceValue;  
    protected Suit suit;

    public Card(int c, Suit s){
        this.faceValue = c;
        this.suit = s;
    }

    public abstract int value();

    public Suit suit(){return suit;}

    public boolean isAvailable() {
        return this.available;
    }

    public void markUnavailable(){
        this.available = false;
    }

    public void markAvailable(){
        this.available = true;
    }


}
