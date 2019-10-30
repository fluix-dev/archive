
public class RockPile {

	public static void main(String[] args) {
		
		//Number of rocks and statement to print when finished
		int rocks = 14;
		String lastStatement = "Finished moving all " + rocks + " rocks.";
		
		System.out.println("Let's begin moving!");
		
		while (rocks > 0) {
			if (rocks > 1) { // Plural "rocks" if more than one
				System.out.println(rocks + " rocks to go!");
			} else { // Singular "rock" if one left
				System.out.println(rocks + " rock to go!");
			}
			
			rocks --;
		}
		
		System.out.println(lastStatement);
	}

}
