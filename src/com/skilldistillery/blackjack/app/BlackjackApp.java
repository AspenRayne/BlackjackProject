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
		Player player = new Player();
		Dealer dealer = new Dealer();

		dealer.shuffle(deck);
		dealer.dealCard(deck);

		for (int i = 0; i < 2; i++) {
			dealer.getHand().addCard(dealer.dealCard(deck));
			player.getHand().addCard(dealer.dealCard(deck));
		}

		checkWinner(player.getHand(), dealer.getHand(), true);

		boolean keepGoing = true;

		while (keepGoing) {
			int userInput = 0;
			System.out.println();
			System.out.println("Do you want to Hit or Stand?");
			System.out.println("1. Hit");
			System.out.println("2. Stand");
			userInput = s.nextInt();

			switch (userInput) {
			case 1:
				System.out.println();
				player.hit(dealer.dealCard(deck));
				keepGoing = checkWinner(player.getHand(), dealer.getHand(), true);
				break;
			case 2:
				System.out.println();
				dealersTurns(player.getHand().getHandValue(), dealer, deck);
				keepGoing = checkWinner(player.getHand(), dealer.getHand(), false);
				break;
			}
		}
		endGameHands(player.getHand(), dealer.getHand());
	}

	public void gameTurns() {

	}

	public boolean checkWinner(BlackjackHand playerHand, BlackjackHand dealerHand, boolean playerHitting) {
		if (playerHitting) {
			System.out.println("Dealers Starting Hand: [" + dealerHand.getHand().get(0) + "] [Hidden]");
			System.out.println("Your Hand: " + playerHand + " Your Hand Value: " + playerHand.getHandValue());
			if (playerHand.isBust()) {
				System.out.println("------------------------");
				System.out.println("\tWINNER\n------------------------");
				System.out.println("YOU BUSTED, DEALER WON");
				return false;
			}
			if (playerHand.isBlackjack()) {
				System.out.println("------------------------");
				System.out.println("\tWINNER\n------------------------");
				System.out.println("YOU HIT A BLACKJACK! YOU WON");
				return false;
			}
		} else {
			System.out.println("------------------------");
			System.out.println("\tWINNER\n------------------------");

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
		while (dealer.getHand().getHandValue() < 17) {
			dealer.getHand().addCard(dealer.dealCard(deck));
			System.out.println(
					"Dealers Hand: " + dealer.getHand() + " Dealers Value: " + dealer.getHand().getHandValue());
		}
	}

	public void endGameHands(BlackjackHand playerHand, BlackjackHand dealerHand) {
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("\tEnd Game Hands\n--------------------------------");
		System.out.println("Your End Game Hand: " + playerHand.getHand() + "\nYour End Game Hand Value: "
				+ playerHand.getHandValue());
		System.out.println();
		System.out.println("Dealers End Game Hand: " + dealerHand.getHand() + "\nDealers End Game Hand Value: "
				+ dealerHand.getHandValue());
		System.out.println("--------------------------------------");
	}

}
