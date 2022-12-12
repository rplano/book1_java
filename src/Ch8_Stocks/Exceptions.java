import java.awt.Color;

import acm.graphics.GRect;
import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: 3. Exceptions
 * 
 * ConsoleProgram that demos the most common exceptions.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Exceptions extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		// NullPointerException
		try {
			GRect fritz = null;
			fritz.setColor(Color.RED);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		// ArithmeticException
		try {
			int x = 5 / 0;

		} catch (ArithmeticException e) {
			e.printStackTrace();
		}

		// NumberFormatException
		try {
			int x = Integer.parseInt("five");

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		// ArrayIndexOutOfBoundsException
		try {
			int[] eggs = { 0, 1, 2, 3 };
			println(eggs[4]);

		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		/*
		 * int[] arr = new int[10]; for (int i = 0; i < arr.length; i++) {
		 * arr[i] = i*i; }
		 * 
		 * try { println( arr[11] ); } catch (ArrayIndexOutOfBoundsException e)
		 * { println("An error occurred 1:" + e); } try { int y = 5 / 0; } catch
		 * (ArithmeticException e) { println("An error occurred 2:" + e); }
		 * 
		 * String hans = null; try { println( hans.length() );
		 * 
		 * } catch (Exception e) { println("An error occurred 3:" + e); }
		 */
	}
}
