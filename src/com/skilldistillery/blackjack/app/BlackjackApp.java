package com.skilldistillery.blackjack.app;


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
		System.out.println("Your Starting Hand: [" + player.getHand() + "]");
	}

}
