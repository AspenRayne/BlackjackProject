package com.skilldistillery.blackjack.entities;

public class Player {
	private Hand hand;

	public Player() {
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

}
