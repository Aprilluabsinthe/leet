package Q7_1_Deck_of_Cards;

public class BlackJackCard extends Card{
    public BlackJackCard(int c, Suit s){super(c,s);}

    public int value(){
        if(isAce()) return 1;
        else if(isFaceCard()) return 10;
        else return faceValue;
    }

    public int minValue(){
        if(isAce()) return 1;
        else return value();
    }

    public int maxValue(){
        if(isAce()) return 11;
        else return value();
    }

    public boolean isAce(){
        return faceValue == 1;
    }

    public boolean isFaceCard(){
        return faceValue >= 10 && faceValue <= 13;
    }
}
