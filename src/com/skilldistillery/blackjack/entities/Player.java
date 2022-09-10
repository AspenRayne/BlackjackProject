package com.skilldistillery.blackjack.entities;

public class Player {
	private Hand hand;
	private String name;

	public Player(String name) {
		this.name = name;
		hand = new BlackjackHand();
	}

	public void hit(Card card) {
		hand.addCard(card);
	}

	public void stand(boolean stand) {
		hand.getHandValue();
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
