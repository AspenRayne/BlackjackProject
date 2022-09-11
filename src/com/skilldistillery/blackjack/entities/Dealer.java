package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private Hand hand;
	private String won;

	public Dealer(String name) {
		super(name);
		hand = new BlackjackHand();
	}

	public Card dealCard(Deck deck) {
		return deck.dealCard();
	}

	public void hit(Card card) {
		if (hand.getHandValue() < 17) {
			hand.addCard(card);
		}
	}

	public void stand() {
		if (hand.getHandValue() > 17) {
			hand.getHand();
		}
	}

	public void shuffle(Deck deck) {
		deck.shuffle();

	}

	public BlackjackHand getHand() {
		return (BlackjackHand) hand;
	}

	public void setHand(BlackjackHand hand) {
		this.hand = hand;
	}

	public void getWon() {

	}

}