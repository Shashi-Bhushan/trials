public class SimpleDotCom{
	private int[] cellLocations;
	private int numberOfHits;

	public int getNumberOfHits(){
		return this.numberOfHits;
	}

	public String checkYourself(String userGuess){
		int guess = Integer.parseInt(userGuess);

		String result = "Miss";

		for(int location: this.cellLocations){
			if(location == guess){
				this.numberOfHits++;

				if(numberOfHits == this.cellLocations.length){
					result = "Kill";
				}else{
					result = "Hit";
				}
				break;
			}
		}
		
		return result;
	}

	public void setLocationCells(int[] cellLocations){
		this.cellLocations = cellLocations;
	}
}