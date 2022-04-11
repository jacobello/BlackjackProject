package com.skilldistillery.blackjack.cards;

import java.util.List;

import com.skilldistillery.blackjack.BlackjackHand;

public class Dealer {
	private Hand dealer;
	private Deck deck;
	
	public Dealer() {
		dealer = new BlackjackHand();
		deck = new Deck();
		deck.shuffle();
	}

	public Dealer(Hand dealer) {
		super();
		this.dealer = dealer;
	}


	public Card dealCards() {
		System.out.println("Dealing...");
		Card card = deck.dealCard();
		return card;
	}

	public void firstCardDown() {
		List<Card> dealerCards = dealer.getCards();

		System.out.print("\tDealer's cards: [First card face down");
		for (int i = 1; i < dealerCards.size(); i++) {
			System.out.print(", " + dealerCards.get(i));
		}
		System.out.println("]");
	}

	public int checkCurrentDeckSize() {
		return deck.checkDeckSize();
	}

	public void callNewDeck() {
		deck.newDeck();
	}

	public void addCardPlayer(Card card) {
		dealer.addCard(card);
	}

	public int askHandValue() {
		return dealer.getHandValue();
	}

	public boolean isTwentyOne() {
		return dealer.isTwentyOne();
	}

	public boolean isBlackJack() {
		return dealer.isBlackJack();
	}

	public boolean isBust() {
		return dealer.isBust();
	}

	public void clear() {
		dealer.clear();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("cards: ").append(dealer).append("");
		return builder.toString();
	}

}
