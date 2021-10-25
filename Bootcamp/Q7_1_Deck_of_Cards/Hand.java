package Q7_1_Deck_of_Cards;

public class Hand<T extends Card> {
    protected ArrayList<T> cards = new ArrayList<T>();

    public int score(){
        int score = 0;
        for(T card : cards){
            score += card.value();
        }
        return score;
    }

    public void addCard(T card){
        cards.add(card);
    }
}
