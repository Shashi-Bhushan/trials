public class SimpleDotComTest{
	public static void main(String... arg){
		String userInput = "3";

		int[] cellLocations = {4,5,6};

		SimpleDotCom testClass = new SimpleDotCom();
		testClass.setLocationCells(cellLocations);

		checkTest(testClass, "3", "Miss");
		checkTest(testClass, "4", "Hit");
		checkTest(testClass, "6", "Hit");
		checkTest(testClass, "5", "Kill");
	}

	public static void checkTest(SimpleDotCom testClass, String userInput, String expectedOutput){
		String result = testClass.checkYourself(userInput);

		if(expectedOutput.equals(result)){
			System.out.println("Passed Test");
		}else{
			System.out.println("Failed Test");
		}
	}
}