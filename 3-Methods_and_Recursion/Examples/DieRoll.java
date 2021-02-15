/**
 * Examples of rolling dice
 * 
 * Key idea: Java uses parameters to distinguish between multiple methods with the same name
 * 
 * @author dmyers
 *
 */

public class DieRoll {

	/**
	 * Simulate the roll of a six-sided die
     * Wrapper method for the more general dieRoll(n)
	 * 
	 * @return the randomly generated die roll
	 */
	public static int dieRoll() {
		return dieRoll(6);
	}

	/**
	 * Parameterized die roll that takes the number of faces as input
	 * 
	 * @param faces the number of faces on the die
	 * @return the simulated roll from the range [1, faces]
	 */
	public static int dieRoll(int faces) {
		return (int) (Math.random() * faces + 1);
	}

	public static void main(String[] args) {

		// Generate some die rolls
		int d20 = dieRoll(20);
		int d100 = dieRoll(100);
		int d6 = dieRoll();

	}

}
