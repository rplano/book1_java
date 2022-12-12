import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: Swap
 * 
 * A simple ConsoleProgram that swaps two entries in an array of int.
 * 
 * @see Music and mathematics,
 *      en.wikipedia.org/wiki/Mathematics_of_musical_scales
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Swap extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		int[] arr = { 0, 2, 4, 6 };
		swap(arr);

		for (int i = 0; i < arr.length; i++) {
			print(arr[i] + ", ");
		}
	}

	private void swap(int[] arr) {
		int tmp = arr[1];
		arr[1] = arr[2];
		arr[2] = tmp;
	}
}
