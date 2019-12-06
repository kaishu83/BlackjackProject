package com.skilldistillery.common;

import java.io.IOException;
import java.util.Scanner;

public class Dealing {
	Deck d = new Deck();
	Scanner input = new Scanner(System.in);

	public void deal() {
		System.out.println("How many cards do you want?");

		try {
			int option = input.nextInt();

			if (option > d.checkDeckSize()) {
				System.out.println("Not enough card");
			} else {
				for (int i = 0; i < option; i++) {

					System.out.println(d.dealCard());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Wrong Input");
		}
	}
}
