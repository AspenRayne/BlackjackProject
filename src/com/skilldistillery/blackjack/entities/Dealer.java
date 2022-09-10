package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private Hand hand;

	public Dealer(String name) {
		super(name);
		hand = new BlackjackHand();
	}

	public Card dealCard(Deck deck) {
		return deck.dealCard();
	}

	public void hit() {
		hand.addCard(null);
	}

	public void shuffle(Deck deck) {
		deck.shuffle();
		
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	
}