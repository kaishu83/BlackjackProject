package com.skilldistillery.blackjack;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import com.skilldistillery.common.Deck;

public class DealingTable {

	Scanner input = new Scanner(System.in);

	Player peter = new Player();
	Dealer dealer = new Dealer();

//	public static void main(String[] args) {
//		DealingTable dt = new DealingTable();
//
//		dt.play();
//	}

	public int play() {

		dealer.blackjackHand.clear();
		peter.blackjackHand.clear();
		int playerValue = 0;
		int dealerValue = 0;

		dealer.newDeck();	// There's a bug here. In current version, dealer will wash card every time you bet. It won't effect running one round.

		dealer.giveCard(peter);
		dealer.giveCard(peter);

		dealer.giveCard(dealer);
		dealer.giveCard(dealer);

		dealer.printFirstCard(dealer);

		showCards();

		playerCurrentHand();
		if (peter.blackjackHand.isBlackjack()) {
			System.out.println("You had black Jack");
			if (dealer.blackjackHand.getHandValue() != 21) {
				dealerFinalCards();
				System.out.println("You win!!!!!!!!!!!!!!\n");
				return 1;
			} else {
				dealerFinalCards();
				System.out.println("Wash!!!!!!!!!!!!!!!!!\n");
				return 0;
			}
		} else {
			String option = "";
			do {
				printHitOrStand();
				option = input.next();

				if (!option.equals("H")) {
					playerValue = peter.blackjackHand.getHandValue();
					dealer.to17(dealer);
					dealerValue = dealer.blackjackHand.getHandValue();
					if (dealer.blackjackHand.isBust()) {
						dealerFinalCards();
						System.out.println("Dealer has " + dealerValue);
						System.out.println("Dealer Busted, you Win!!!!!!!!!!!\n");

						return 1;
					} else {

						dealerFinalCards();

						return whoWind(playerValue, dealerValue);

					}
				} else {
					dealer.giveCard(peter);

					playerCurrentHand();

					if (peter.blackjackHand.isBust()) {
						System.out.println("You busted, you lose!!!!!!!!!!!!!!\n");

						return -1;
					}

				}
			} while (option.equals("H"));
		}
		return -100;

	}

	public int whoWind(int playerValue, int dealerValue) {
		System.out.println("You have " + playerValue + ", and dealer has " + dealerValue);
		if (playerValue > dealerValue) {
			System.out.println("You win!!!!!!!!!!!!!\n");
			return 1;
		}

		else if (playerValue < dealerValue) {
			System.out.println("You lose!!!!!!!!!!!!\n");
			return -1;
		} else {
			System.out.println("Wash!!!!!!!!!!!!!!!!!\n");
			return 0;

		}
	}

	public void printHitOrStand() {
		System.out.println("Hit or Stand?");
		System.out.println("Enter \"H\" for hit, enter anything else if you want to stay");
	}

	public void playerCurrentHand() {
		System.out.println("Your cards are: ");
		System.out.print(peter.blackjackHand.toString());
		System.out.println("You total value is: " + peter.blackjackHand.getHandValue());
		System.out.println();
	}

	public void dealerFinalCards() {
		System.out.println("Dealer's cards are: ");
		System.out.println(dealer.blackjackHand.toString());

	}

	public void showCards() {
		if (dealer.blackjackHand.showCard().getValue() == 10) {
			if (dealer.blackjackHand.isBlackjack()) {
				System.out.println("Dealer got blackjack!!!!!!!!!");
				System.out.println(dealer.blackjackHand.toString());
			}
		}
	}

}
