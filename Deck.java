import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	private ArrayList<Card> useCard;
	public int nUsed;

	// TODO: Please implement the constructor (30 points)
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		useCard = new ArrayList<Card>();
		openCard = new ArrayList<Card>();
		for (int f = 1; f <= nDeck; f++) {
			for (Card.Suit s : Card.Suit.values()) {
				for (int r = 1; r <= 13.; r++) {
					Card card = new Card(s, r);
					cards.add(card);
				}
			}
		}
		shuffle();
	}

	// TODO: Please implement the method to print all cards on screen (10
	// points)
	public void printDeck() {
		for (int i = 0; i < cards.size(); i++) {
			cards.get(i).printCard();

		}
		// Hint: print all items in ArrayList<Card> cards,

		// TODO: please implement and reuse printCard method in Card class (5
		// points)

	}

	public ArrayList<Card> getAllCards() {

		return cards;
	}

	public void shuffle() {
		Random r = new Random();
		for (int i = 0; i < cards.size(); i++) {
			int t1 = r.nextInt(cards.size() + 1);
			Card a = cards.get(t1);
			Card b = cards.get(i);
			Card temp = a;
			a = b;
			cards.set(t1, a);
			b = temp;
			cards.set(i, b);
			openCard.clear();
		}
		for (int i = 0; i < cards.size(); i++)

			cards.remove(i);
		nUsed = 0;
	}

	private ArrayList<Card> openCard;

	public ArrayList<Card> getOpenedCard() {
		openCard = new ArrayList<Card>();
		return openCard;
	}

	public Card getOneCard(boolean isOpened) {
		Card Z = cards.get(nUsed);
		if (nUsed < cards.size()) {
			useCard.add(Z);
			if (isOpened) {
				openCard.add(Z);
			}
			nUsed++;
		} else
			shuffle();
		return Z;
	}

}
