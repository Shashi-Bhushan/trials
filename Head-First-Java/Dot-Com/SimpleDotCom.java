public class SimpleDotCom{
	private int[] cellLocations;
	private int numberOfHits;
	private boolean isAlive = true;

	public int getNumberOfHits(){
		return this.numberOfHits;
	}

	public String checkYourself(String userGuess){
		int guess = Integer.parseInt(userGuess);

		String result = SimpleDotComConstants.MISS;

		if(this.cellLocations[guess] == SimpleDotComConstants.SENTINEL_VALUE){
			return SimpleDotComConstants.ALREADY_BEEN_HIT;
		}

		for(int location: this.cellLocations){
			if(location == guess){
				this.numberOfHits++;
				this.cellLocations[location] = SimpleDotComConstants.SENTINEL_VALUE;

				if(numberOfHits == this.cellLocations.length){
					result = SimpleDotComConstants.KILL;
				}else{
					result = SimpleDotComConstants.HIT;
				}
				break;
			}
		}
		
		return result;
	}

	public void setLocationCells(int[] cellLocations){
		this.cellLocations = cellLocations;
	}

	public boolean isAlive(){
		return this.isAlive;
	}

	public void setIsAlive(boolean isAlive){
		this.isAlive = isAlive;
	}
}