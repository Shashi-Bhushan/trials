import java.util.Scanner;

public class GameInputHelper{
	private static final Scanner input = new Scanner(System.in);

	public String getUserInput(String textToDisplay){
		System.out.print(textToDisplay);

		return input.nextLine();
	}
}