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

	public BlackjackHand getHand() {
		return (BlackjackHand) this.hand;
	}

	public void setHand(BlackjackHand hand) {
		this.hand = hand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
