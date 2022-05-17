/**
 * The Player class creates a object of type player with a playerposition and a dicevalue
 * @param name a string for the player's name
 * @return the position of a player as an int, the value of the rolled dice as an int
 * @author Kevin Duong(40209877) and Paul Touma (40210678)
 *@version1.0
 */
public class Player  {
	int playerposition;
	int dicevalue;
	String name;

	Player(String name) {
		playerposition = 0;
		this.dicevalue = dicevalue;
		this.name=name;
	}
/**
 * 
 * @return the player's position
 */
	public int getposition() {
		return this.playerposition;
	}
/**
 * 
 * @param playerposition A int that sets the player's position to that value
 */
	public void setposition(int playerposition) {
		this.playerposition = playerposition;
	}
/**
 * Gets the player's dice value
 * @return An int representing the rolled dice value
 */
	public int getdicevalue() {
		return this.dicevalue;

	}
	
	public void setdicevalue() {
		double ArandomDouble = Math.random();
		ArandomDouble = ArandomDouble * 6 + 1;
		int ArandomInt = (int) ArandomDouble;
		this.dicevalue=ArandomInt;
	}


}
