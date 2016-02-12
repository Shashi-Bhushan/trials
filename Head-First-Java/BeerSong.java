public class BeerSong{
	public static void main(String... arg){
		int beerNum = 3;
		String word = "bottles";

		while(beerNum >0){
			System.out.println(beerNum + " " + word + " of beer on the wall.");
			System.out.println(beerNum + " " + word + " of beer.");
			System.out.println("Take one down.");
			System.out.println("Pass it around.");
			beerNum--;

			if(beerNum == 1){
				word = "bottle";	// Singular as in one Bottle
			}
			if(beerNum > 0){
				System.out.println(beerNum + " " + word + " of beer on the wall.");
			}else{
				System.out.println("No More Bottle of beer on the wall.");
			}
		}	// end while	
	}
}