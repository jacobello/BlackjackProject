package com.skilldistillery.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackjackApplication {
	public static void main(String[] args) {
		BlackjackApplication app = new BlackjackApplication();
		app.run();

	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		gameMenu(scanner);
	}

	public void gameMenu(Scanner scanner) {
		System.out.println("***********************************************************");
		System.out.println("Welcome to Blackjack game night $$$$$");
		System.out.println("Please read following rules carefully!");
		System.out.println("\t* Aces will have a value of 11.");
		System.out.println("\t* Jacks, Queens, and Kings are each worth 10 points.");
		System.out.println("\t* All other cards are face value.");
		System.out.println("Press [1] to Play BackJack.");
		System.out.println("Press [2] to exit.");
		System.out.println("***********************************************************");
		int selection = 0;

		try {
			selection = scanner.nextInt();
		} catch (InputMismatchException e) {
		}

		switch (selection) {
		case 1:
			Game game = new Game();
			game.startBlackJack(scanner);
			break;
		case 2:
			System.out.println("Goodbye. At least one of us had fun!");
			System.exit(0);
			break;
		default:
			System.err.println("Invalid option. Please, try again!");
			run();
		}
	}
}
