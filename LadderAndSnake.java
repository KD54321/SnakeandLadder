/*Assignment 0
 * Part 1
  Written By Kevin Duong (40209877) and Paul Touma  (40210678)
*/

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Represents a Ladder And Snake game
 * 
 * @author Kevin Duong (40209877) and Paul Touma (40210678)
 * @version 1.0
 */
public class LadderAndSnake {
	int numplayers;
	int board[];
	Player players[];

	LadderAndSnake() {
		this.numplayers = getnumplayers();
		board = new int[101];
		players = new Player[numplayers];
	}

	/**
	 * Creates a Snake and ladder game that takes the number of players that was
	 * inputed by the user
	 * 
	 * @param numberofplayers the number of players playing the game
	 */
	LadderAndSnake(int numberofplayers) {
		this.numplayers = numberofplayers;
		board = new int[101];
		players = new Player[numplayers];
	}

	/**
	 * gets the number of players
	 * 
	 * @return the number of players
	 */
	public int getnumplayers() {
		return numplayers;
	}

	/**
	 * sets the number of players to the number entered by the user
	 * 
	 * @param numplayers the number of players playing the game
	 */
	public void setnumplayers(int numplayers) {
		this.numplayers = numplayers;

	}

	/**
	 * generates a random number between 1 and 6
	 * 
	 * @return a random integer number between 1 and 6
	 */
	public int flipDice() {
		double ArandomDouble = Math.random();
		ArandomDouble = ArandomDouble * 6 + 1;
		int ArandomInt = (int) ArandomDouble;
		return ArandomInt;
	}

	/**
	 * Stores the order of players in an array
	 * 
	 * @param orderList List of players in order
	 * @return the turn order of players
	 */
	public String orderListToString(ArrayList<Player> orderList) {
		String s = "";

		for (Player p : orderList) {
			s += p.name + ",";
		}
		return s;
	}

	/**
	 * rolls the dice for all players in the game
	 * 
	 */
	public void rollAllPlayerOrder() {
		for (int i = 0; i < numplayers; i++) {
			players[i].dicevalue = flipDice();
			System.out.println(players[i].name + " rolled " + players[i].dicevalue);
		}
	}

	/**
	 * rolls the dice for a player p
	 * 
	 * @param p a player
	 */
	public void rollPlayerDice(Player p) {
		p.dicevalue = flipDice();
		System.out.println(p.name + " rolled " + p.dicevalue);
	}

	/**
	 * An array list that stores the player order
	 * 
	 * @return the sorted order of players after rolling the dice for turn order
	 */
	public ArrayList<Player> setplayerorder() {
		rollAllPlayerOrder();
		final Comparator<Player> DiceRoll = (Player p1, Player p2) -> Integer.compare(p1.dicevalue, p2.dicevalue);
		ArrayList<Player> orderList = new ArrayList<Player>(Arrays.asList(players));
		Collections.sort(orderList, DiceRoll);
		Collections.reverse(orderList);
		Player previous = orderList.get(0);
		for (int i = 1; i < orderList.size(); i++) {
			if (orderList.get(i).dicevalue == previous.dicevalue) {
				System.out.println(orderList.get(i).name + " and " + previous.name
						+ " have same dice roll ATTEMPTING TO RESOLVE THE PROBLEM");
				while (orderList.get(i).dicevalue == previous.dicevalue) {
					rollPlayerDice(orderList.get(i));
					rollPlayerDice(previous);
					System.out.println("...");
				}
				System.out.println("PROBLEM RESOLVED");
				if (previous.dicevalue < orderList.get(i).dicevalue) {
					Collections.swap(orderList, i - 1, i);
					orderList.get(i).dicevalue = 0;
					previous.dicevalue = 0;
				}
			}
			previous = orderList.get(i);
		}

		return orderList;
	}

	/**
	 * Starts the game of Ladder and Snake
	 * 
	 */
	public void play() {
		int startposition = 0;
		ArrayList<Player> PlayerOrder;
		int SnakesArray[] = new int[8];
		int LadderArray[] = new int[9];
		SnakesArray[0] = 16;
		SnakesArray[1] = 48;
		SnakesArray[2] = 64;
		SnakesArray[3] = 79;
		SnakesArray[4] = 93;
		SnakesArray[5] = 95;
		SnakesArray[6] = 97;
		SnakesArray[7] = 98;
		LadderArray[0] = 1;
		LadderArray[1] = 4;
		LadderArray[2] = 9;
		LadderArray[3] = 21;
		LadderArray[4] = 28;
		LadderArray[5] = 36;
		LadderArray[6] = 51;
		LadderArray[7] = 71;
		LadderArray[8] = 80;

		for (int i = 0; i < numplayers; i++) {
			players[i] = new Player("Player " + (i + 1));

		}

		System.out.println("Game is played by " + numplayers + " players");
		System.out.println("Flipping to determine turn order...");
		PlayerOrder = setplayerorder();
		System.out.println("Player Order Determined: " + orderListToString(PlayerOrder));
		do {
			for (int i = 0; i < PlayerOrder.size(); i++) {
				PlayerOrder.get(i).setdicevalue();
				PlayerOrder.get(i).setposition(PlayerOrder.get(i).getposition() + PlayerOrder.get(i).getdicevalue());
				System.out.println(PlayerOrder.get(i).name + " rolled a " + PlayerOrder.get(i).getdicevalue()
						+ " and is now at square " + PlayerOrder.get(i).getposition());

				if (PlayerOrder.get(i).getposition() == SnakesArray[0]) {
					PlayerOrder.get(i).setposition(6);
					System.out.println(PlayerOrder.get(i).name + " got bit by a snake! Go down to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == SnakesArray[1]) {
					PlayerOrder.get(i).setposition(30);
					System.out.println(PlayerOrder.get(i).name + " got bit by a snake! Go down to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == SnakesArray[2]) {
					PlayerOrder.get(i).setposition(60);
					System.out.println(PlayerOrder.get(i).name + " got bit by a snake! Go down to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == SnakesArray[3]) {
					PlayerOrder.get(i).setposition(19);
					System.out.println(PlayerOrder.get(i).name + " got bit by a snake! Go down to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == SnakesArray[4]) {
					PlayerOrder.get(i).setposition(68);
					System.out.println(PlayerOrder.get(i).name + " got bit by a snake! Go down to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == SnakesArray[5]) {
					PlayerOrder.get(i).setposition(24);
					System.out.println(PlayerOrder.get(i).name + " got bit by a snake! Go down to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == SnakesArray[6]) {
					PlayerOrder.get(i).setposition(76);
					System.out.println(PlayerOrder.get(i).name + " got bit by a snake! Go down to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == SnakesArray[7]) {
					PlayerOrder.get(i).setposition(78);
					System.out.println(PlayerOrder.get(i).name + " got bit by a snake! Go down to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == LadderArray[0]) {
					PlayerOrder.get(i).setposition(38);
					System.out.println(PlayerOrder.get(i).name + " found a ladder! Go up to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == LadderArray[1]) {
					PlayerOrder.get(i).setposition(14);
					System.out.println(PlayerOrder.get(i).name + " found a ladder! Go up to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == LadderArray[2]) {
					PlayerOrder.get(i).setposition(31);
					System.out.println(PlayerOrder.get(i).name + " found a ladder! Go up to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == LadderArray[3]) {
					PlayerOrder.get(i).setposition(42);
					System.out.println(PlayerOrder.get(i).name + " found a ladder! Go up to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == LadderArray[4]) {
					PlayerOrder.get(i).setposition(84);
					System.out.println(PlayerOrder.get(i).name + " found a ladder! Go up to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == LadderArray[5]) {
					PlayerOrder.get(i).setposition(44);
					System.out.println(PlayerOrder.get(i).name + " found a ladder! Go up to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == LadderArray[6]) {
					PlayerOrder.get(i).setposition(67);
					System.out.println(PlayerOrder.get(i).name + " found a ladder! Go up to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == LadderArray[7]) {
					PlayerOrder.get(i).setposition(91);
					System.out.println(PlayerOrder.get(i).name + " found a ladder! Go up to square "
							+ PlayerOrder.get(i).getposition());
				} else if (PlayerOrder.get(i).getposition() == LadderArray[8]) {
					PlayerOrder.get(i).setposition(100);
					System.out.println(PlayerOrder.get(i).name + " found a ladder! Go up to square "
							+ PlayerOrder.get(i).getposition());
				}

				if (PlayerOrder.get(i).getposition() > 100) {
					PlayerOrder.get(i).setposition(100 - (PlayerOrder.get(i).getposition() - 100));
				}
				if (PlayerOrder.get(i).getposition() == 100) {
					System.out
							.println("Congratulation! Player " + (i + 1) + " is the winner!\nGame will now terminate.");
					System.exit(0);
				}
			}
		} while (players[0].getposition() != 100 || players[1].getposition() != 100 || players[2].getposition() != 100
				|| players[3].getposition() != 100);

	}

}
