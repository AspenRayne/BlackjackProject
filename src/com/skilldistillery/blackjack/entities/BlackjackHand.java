package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	public BlackjackHand() {

	}

	@Override
	public int getHandValue() {
		int sum = 0;
		for (Card card : hand) {
			sum += card.getValue();
		}
		return sum;
	}

	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			return true;
		}
		return false;
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		}
		return false;
	}

	public boolean isHard() {
		return true;
	}

	public boolean isSoft() {
		return true;
	}

}
