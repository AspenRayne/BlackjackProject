package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		deck = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(suit, rank);
				deck.add(card);
			}
		}
	}

	public int checkDeckSize() {
		return deck.size();
	}

	public Card dealCard() {
		return deck.remove(0);
	}
	
	public void dealCard(Hand hand) {
		hand.addCard(deck.remove(0));
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	@Override
	public String toString() {
		return "Deck [deck=" + deck + "]";
	}
	
	

}
