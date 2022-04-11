package com.skilldistillery.blackjack;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Hand;

public class BlackjackHand extends Hand {
	private final int twentyOne = 21;

	public BlackjackHand() {

	}

	public int getHandValue() {
		int value = 0;

		for (Card card : cards) {
			value += card.getValue();
		}
		return value;
	}

	public boolean isBlackJack() {
		if (getHandValue() == twentyOne) {
			return true;
		}
		return false;
	}

	public boolean isTwentyOne() {
		if (getHandValue() == twentyOne) {
			return true;
		}
		return false;
	}

	public boolean isBust() {
		if (getHandValue() > twentyOne) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("").append(cards).append("");
		return builder.toString();
	}

}
