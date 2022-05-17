
import java.util.Scanner;

public class PlayLadderAndSnake {

	public static void main(String[] args) {
		// Welcomes the user
		System.out.println("Welcome to the Snake And Ladder Prorgram!");
		Scanner keyboard = new Scanner(System.in);
		int counter = 0;
		while (true) {
			// takes the number of players input from the user
			System.out.println("Enter the # of players for your game - Number must be between 2 and 4 inclusively:");
			int numplayers = keyboard.nextInt();
			counter += 1;
			// starts the game if the number of players inputed by user >2 and <4
			if (numplayers >= 2 && numplayers <= 4) {
				LadderAndSnake game = new LadderAndSnake(numplayers);
				game.play();
			} else if (counter == 3) {
				System.out.println("Bad attempt " + counter + " invalid# of players. THIS IS YOUR LAST ATTEMPT!");
			} else if (counter == 4) {
				System.out.println("Bad attempt " + counter + " invalid# of players."
						+ "You have exhausted all your chances program will now terminate");
				System.exit(0);
			}

			else {
				System.out.println("Bad attempt " + counter + " invalid# of players.");
			}

		}
	}

}
