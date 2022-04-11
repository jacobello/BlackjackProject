package com.skilldistillery.blackjack.cards;

import com.skilldistillery.blackjack.BlackjackHand;

public class Player {
	private Hand hand;

	public Player() {
		hand = new BlackjackHand();
		
	}

	public Player(Hand hand) {
		super();
		this.hand = hand;
	}

	public void addCardPlayer(Card card) {
		hand.addCard(card);
	}

	public int askHandValue() {
		return hand.getHandValue();
	}

	public boolean isTwentyOne() {
		return hand.isTwentyOne();
	}

	public boolean isBlackJack() {
		return hand.isBlackJack();
	}

	public boolean isBust() {
		return hand.isBust();
	}

	public void clear() {
		hand.clear();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(hand).append("");
		return builder.toString();
	}

}
