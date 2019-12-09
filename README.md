# BlackjackProject
##  Skill Distillery Week 5 Project

### Overview
  Creating a blackjack game that would allow player to play with the machine(dealer).
  
### Tech & Method
1.  Java 8
2.  Using enum to create constant Cards
3.  Using different class such as table deck player dealer and hand to mimic the real game

### Highlight- The implenment of Strach goal- soft ace
  #### Using the code below to set up money system
	money = money + dt.play() * bet;
	// dt.play() would return either 1 for win, -1 for lose and 0 for wash.

  #### Using the code below to implement soft ace
  
  	public int hasSoftAce() {
		int a = 0;
		for (Card card : cardsInHand) {
			if (card.getValue() == 11) {
				a++;
			}
		}

		return a;
	}
  -------------------
  	public int getHandValue() {
		int aces = hasSoftAce();
		int totalValue = 0;
		for (Card card : cardsInHand) {
			totalValue += card.getValue();
		}
		if (aces == 1 && totalValue > 21) {
			totalValue = totalValue - 10;
		}

		else if (aces == 2 && totalValue - 10 > 21) {
			totalValue = totalValue - 20;
		} else if (aces == 3 && totalValue - 20 > 21) {
			totalValue = totalValue - 30;
		} else if (aces == 4 && totalValue - 30 > 21) {
			totalValue = totalValue - 40;
		}
		return totalValue;
	}
###  Lesson Learned
1.	Better understanding of Object Oriented Programing
2.	Pay attention to folders and packages when I code, don't use other file of same name from different location
