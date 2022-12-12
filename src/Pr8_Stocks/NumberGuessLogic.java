/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: NumberGuessLogic
 * 
 * This is the interface describing the contract between two developers.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public interface NumberGuessLogic {

	/**
	 * guess should be number between 0 and 99 <br/>
	 * return 0 if guess was correct <br/>
	 * return +1 if guess was higher <br/>
	 * return -1 if guess was lower
	 * 
	 * @param guess
	 * @return
	 */
	public int makeGuess(int guess);
}
