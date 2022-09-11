package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp bja = new BlackjackApp();
		bja.run();
	}

	public void run() {
		newGame();
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

		Scanner s = new Scanner(System.in);
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
				System.out.println(player.getHand() + " New Value: " + player.getHand().getHandValue());
				if (player.getHand().isBust()) {
					System.out.println("BUST");
					keepGoing = false;
					System.out.println("DEALER WON");
				}
				if (player.getHand().isBlackjack()) {
					System.out.println("BLACKJACK!");
					keepGoing = false;
					System.out.println("YOU WON");
				}
				break;
			case 2:
				keepGoing = false;
				dealersTurns(player.getHand().getHandValue(), dealer, deck);
				checkWinner(player.getHand(), dealer.getHand());
				break;
			}
		}

	}

	public void gameTurns() {

	}

	public void checkWinner(BlackjackHand playerHand, BlackjackHand dealerHand) {
		System.out.println("Your Hand: " + playerHand.getHand() + "\n Your Hand Value: " + playerHand.getHandValue());
		System.out.println(
				"Dealers Hand: " + dealerHand.getHand() + "\n Dealers Hand Value: " + dealerHand.getHandValue());
		if (dealerHand.isBust()) {
			System.out.println("DEALER BUST, YOU WON");
		} else if (dealerHand.isBlackjack()) {
			System.out.println("DEALER HIT A BLACK JACK, DEALER WON");
		} else if (dealerHand.getHandValue() > playerHand.getHandValue()) {
			System.out.println("DEALER WON");
		}
		if (dealerHand.getHandValue() > playerHand.getHandValue()) {
			System.out.println("DEALER WON");
		} else {
			System.out.println("YOU WON");
		}
		if (dealerHand.getHandValue() == playerHand.getHandValue()) {
			System.out.println("TIE");
		}
		if (dealerHand.getHandValue() < playerHand.getHandValue()) {
			System.out.println("YOU WON");
		}

	}

	public void dealersTurns(int playerHandValue, Dealer dealer, Deck deck) {
		while (dealer.getHand().getHandValue() < 17 || dealer.getHand().getHandValue() < playerHandValue) {
			dealer.getHand().addCard(dealer.dealCard(deck));
			System.out.println(
					"Dealers Hand: " + dealer.getHand() + " Dealers Value: " + dealer.getHand().getHandValue());
		}
	}

}
