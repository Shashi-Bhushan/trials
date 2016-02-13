import java.util.Random;

public class SimpleDotComInitializer{
	private static final Random random = new Random();
	private static final GameInputHelper helper = new GameInputHelper();

	// TODO : whether to use Math.random() or Random object
	public static void main(String... arg){
		SimpleDotCom game = new SimpleDotCom();
		int numOfGuesses = 0;

		int startingLocation = random.nextInt(5);

		int[] cellLocations = {startingLocation, startingLocation+1, startingLocation+2};

		game.setLocationCells(cellLocations);

		while(game.isAlive()){
			String userGuess = helper.getUserInput("Enter the Location : ");
			String result = game.checkYourself(userGuess);

			numOfGuesses++;

			if(result.equals(SimpleDotComConstants.KILL)){
				game.setIsAlive(false);
				System.out.println("You Took " + numOfGuesses + " Shots to kill SimpleDotCom.");
				System.out.println("Percentage is : " + ((float)numOfGuesses / 7 * 100));
			}else{
				System.out.println("Result is : " + result);
			}
		}
	}
}