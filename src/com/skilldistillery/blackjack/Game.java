package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Dealer;
import com.skilldistillery.blackjack.cards.Player;

public class Game {

	private Dealer dealer;
	private Player player;
//	private BlackjackApplication app = new BlackjackApplication();
	private final int MIN_DECK_SIZE = 13;
	private final int DEALER_HIT_MIN = 17;

	public void startBlackJack(Scanner scanner) {
		System.out.println("Here we go!");
	

		dealer = new Dealer();
		player = new Player();

		play(scanner);
	}

	private void play(Scanner scanner) {

		System.out.println();
		player.addCardPlayer(dealer.dealCards());
		System.out.println("\t\tYour cards:" + player);

		dealer.addCardPlayer(dealer.dealCards());
		dealer.firstCardDown();

		player.addCardPlayer(dealer.dealCards());
		System.out.println("\t\tYour cards:" + player);

		dealer.addCardPlayer(dealer.dealCards());
		dealer.firstCardDown();

		printPlayerCurrentValue();

		checkForBlackJack(scanner);
		hitOrStand(scanner);
	}

	private void hitOrStand(Scanner scanner) {

		System.out.println("Hit or Stand?");
		String input = scanner.next().toLowerCase();

		if (input.equals("h") || input.equals("hit")) {
			hit(scanner);

		}
		if (input.equals("s") || input.equals("stand")) {
			stand(scanner);
		} else {
			System.out.println("\"" + input + "\"" + " is an invalid input! \nPlease try again.");
			hitOrStand(scanner);
		}
	}

	private void printPlayerCurrentValue() {
		System.out.println();
		System.out.println("\t\tYou got " + player.askHandValue());
		System.out.println();

	}

	private void printDealerCurrentValue() {
		System.out.println();
		System.out.println("\tDealer got " + dealer.askHandValue());
		System.out.println();

	}

	private void hit(Scanner scanner) {
		player.addCardPlayer(dealer.dealCards());
		System.out.println("\t\tYour cards: " + player);
		printPlayerCurrentValue();

		checkValues(scanner);
		playersTurn(scanner);
	}

	private void stand(Scanner scanner) {
		dealerPlayAfterStand(scanner);
	}

	private void playersTurn(Scanner scanner) {
		if (player.askHandValue() < 21) {
			hitOrStand(scanner);
		} else {
			checkValues(scanner);
			checkPush(scanner);
		}
	}

	private void dealerPlayAfterStand(Scanner scanner) {
		if (dealer.askHandValue() < DEALER_HIT_MIN) {
			dealer.addCardPlayer(dealer.dealCards());
			dealer.firstCardDown();
		} else {
			checkValues(scanner);
			checkPush(scanner);
		}
		dealerPlayAfterStand(scanner);
	}

	private void checkPush(Scanner scanner) {
		if (player.askHandValue() == dealer.askHandValue()) {
			dealerShowsAllCards();
			System.out.println("It is a tie!");
			playAgain(scanner);
		}
		checkHighest(scanner);
	}

	private void checkHighest(Scanner scanner) {
		if (player.askHandValue() > dealer.askHandValue()) {
			dealerShowsAllCards();
			System.out.println("You got higher value. YOU WON!");
			playAgain(scanner);
		} else {
			dealerShowsAllCards();
			System.out.println("Dealer got higher value. YOU LOST!");
			playAgain(scanner);
		}
	}

	private void checkValues(Scanner scanner) {
		if (player.isTwentyOne()) {
			dealerShowsAllCards();
			System.out.println("You won with 21! Great job!");
			playAgain(scanner);
		}
		if (dealer.isTwentyOne()) {
			dealerShowsAllCards();
			System.out.println("Dealer got 21. You lost!");
			playAgain(scanner);
		}
		if (dealer.isBust()) {
			dealerShowsAllCards();
			System.out.println("Dealer busted. You WON!");
			playAgain(scanner);
		}
		if (player.isBust()) {
			dealerShowsAllCards();
			System.out.println("You busted. Dealer won.");
			playAgain(scanner);
		}
	}

	private void checkForBlackJack(Scanner scanner) {
		if (player.isBlackJack() && dealer.isBlackJack()) {
			dealerShowsAllCards();
			System.out.println("Both of you got BLACKJACK. It's a tie ");
			playAgain(scanner);
		}
		if (player.isBlackJack()) {
			dealerShowsAllCards();
			System.out.println("BlackJack! You won!");
			playAgain(scanner);
		}
		if (dealer.isBlackJack()) {
			dealerShowsAllCards();
			System.out.println("Dealer got BlackJack. You lost!");
			playAgain(scanner);
		}
	}

	private void dealerShowsAllCards() {
		System.out.println("Dealer turns over first card...");
		System.out.println("\tDealer's " + dealer);
		printDealerCurrentValue();
	}

	private void playAgain(Scanner scanner) {
		System.out.println();
		System.out.println("Another round of Blackjack?");

		String pl = scanner.next().toLowerCase();
		switch (pl) {
		case "yes" :
			if (dealer.checkCurrentDeckSize() >= MIN_DECK_SIZE) {
				player.clear();
				dealer.clear();
				play(scanner);
			} else {
				player.clear();
				dealer.clear();
				dealer.callNewDeck();
				System.out.println();
				System.out.println("[New deck of cards]");
				play(scanner);
			}
			break;
		case "y":
			if (dealer.checkCurrentDeckSize() >= MIN_DECK_SIZE) {
				player.clear();
				dealer.clear();
				play(scanner);
			} else {
				player.clear();
				dealer.clear();
				dealer.callNewDeck();
				System.out.println();
				System.out.println("It's a new deck of cards...");
				play(scanner);
			}
			break;
		case "no":
			System.out.println("Goodbye, it was fun!");
			System.exit(0);
			break;
		case "n":
			System.out.println("Goodbye, it was fun!");
			System.exit(0);
			break;
		default:
			System.out.println("\nPlease try again." + pl);
			playAgain(scanner);
			break;
		}
	}
}
