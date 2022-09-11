package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackApp bja = new BlackjackApp();
		bja.run();
	}

	public void run() {
		boolean playing = true;
		while (playing) {
			newGame();
			s.nextLine();
			System.out.println("Would you like to play again? type Y/N");
			String userInput = s.nextLine();
			if (!userInput.equalsIgnoreCase("Y")) {
				playing = false;
			}
		}
		System.out.println("Thank you for playing!");
	}

	public void newGame() {
		Deck deck = new Deck();
		Player player = new Player("you");
		Dealer dealer = new Dealer("Bob");

		dealer.shuffle(deck);
		dealer.dealCard(deck);

		for (int i = 0; i < 2; i++) {
			dealer.getHand().addCard(dealer.dealCard(deck));
			player.getHand().addCard(dealer.dealCard(deck));
		}

		System.out.println("Dealers Starting Hand: [" + dealer.getHand().getHand().get(0) + "] [Hidden]");
		System.out.println(
				"Your Starting Hand: " + player.getHand() + " Your hand value: " + player.getHand().getHandValue());

		boolean keepGoing = true;

		while (keepGoing) {
			int userInput = 0;
			System.out.println("Do you want to Hit or Stand?");
			System.out.println("1. Hit");
			System.out.println("2. Stand");
			userInput = s.nextInt();

			switch (userInput) {
			case 1:
				player.hit(dealer.dealCard(deck));
				keepGoing = checkWinner(player.getHand(), dealer.getHand(), true);
				break;
			case 2:
				dealersTurns(player.getHand().getHandValue(), dealer, deck);
				keepGoing = checkWinner(player.getHand(), dealer.getHand(), false);
				break;
			}
		}
		System.out.println(
				"Your Hand: " + player.getHand().getHand() + "\n Your Hand Value: " + player.getHand().getHandValue());
		System.out.println("Dealers Hand: " + dealer.getHand().getHand() + "\n Dealers Hand Value: "
				+ dealer.getHand().getHandValue());

	}

	public void gameTurns() {

	}

	public boolean checkWinner(BlackjackHand playerHand, BlackjackHand dealerHand, boolean playerHitting) {
		if (playerHitting) {
			System.out.println("Dealers Starting Hand: [" + dealerHand.getHand().get(0) + "] [Hidden]");
			System.out.println("Your Hand: " + playerHand + " Your hand value: " + playerHand.getHandValue());
			if (playerHand.isBust()) {
				System.out.println("BUST");
				System.out.println("DEALER WON");
				return false;
			}
			if (playerHand.isBlackjack()) {
				System.out.println("BLACKJACK!");
				System.out.println("YOU WON");
				return false;
			}
		} else {
			if (dealerHand.isBust()) {
				System.out.println("DEALER BUST, YOU WON");
			} else if (dealerHand.isBlackjack()) {
				System.out.println("DEALER HIT A BLACK JACK, DEALER WON");
			} else if (dealerHand.getHandValue() > playerHand.getHandValue()) {
				System.out.println("DEALER WON");
			} else if (dealerHand.getHandValue() == playerHand.getHandValue()) {
				System.out.println("TIE");
			} else if (dealerHand.getHandValue() < playerHand.getHandValue()) {
				System.out.println("YOU WON");
			}
			return false;
		}
		return true;

	}

	public void dealersTurns(int playerHandValue, Dealer dealer, Deck deck) {
		while (dealer.getHand().getHandValue() < 17 || dealer.getHand().getHandValue() < playerHandValue) {
			dealer.getHand().addCard(dealer.dealCard(deck));
			System.out.println(
					"Dealers Hand: " + dealer.getHand() + " Dealers Value: " + dealer.getHand().getHandValue());
		}
	}

}
