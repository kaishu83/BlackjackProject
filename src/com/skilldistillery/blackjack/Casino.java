package com.skilldistillery.blackjack;

import java.util.Scanner;

public class Casino {
	Scanner input = new Scanner(System.in);
	DealingTable dt = new DealingTable();
	
	public static void main(String[] args) {
		Casino c = new Casino();
		c.run();
	}

	public void run() {
		System.out.println("Welcome. This table is H17");
		System.out.println("How much chips do you want to purchase?");
		int money = input.nextInt();
		Player p = new Player(money);
		int bet;
		do {
			if (money < 5) {
				System.out.println("You are running out of chips, game over");
				break;
			}
			System.out.println("You currently have " + money);
			System.out.println("What's your betting for this game, at least 5,enter 0 to quit");

			bet = input.nextInt();
			if(bet==0) break;
			while (bet > money) {
				System.out.println("You don't have " + bet + " of chips");
				bet = input.nextInt();
			}

			money = money + dt.play() * bet;
		
		} while (bet != 0);
		System.out.println("Good bye");
	}
}
