package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class DealingApp {
	Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		DealingApp d = new DealingApp();
		d.run();
	}

	public void run() {
		dealDeck();
	}

	public void dealDeck() {
		Deck deck = new Deck();
		deck.shuffle();
		System.out.println("Please enter how many cards you would like to view: ");

		try {
			int userInput = s.nextInt();
			if (userInput > 52) {
				throw new InputMismatchException();
			}

			List<Card> userDeck = new ArrayList<>(userInput);
			int total = 0;

			for (int i = 0; i < userInput; i++) {
				Card card = deck.dealCard();
				total += card.getValue();
				userDeck.add(card);
			}
			printDeck(userDeck, total);
			System.out.println(deck.checkDeckSize() + " Cards left");

		} catch (InputMismatchException e) {
			System.err.println("Invalid Entry");

		}
	}

	public void printDeck(List<Card> list, int value) {
		for (Card card : list) {
			System.out.println(card);
		}
		System.out.println("Total value: " + value);
	}
}
