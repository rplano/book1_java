import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: CounterTester
 * 
 * This class tests the Counter class.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class CounterTester extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");
		
		Counter cntr1 = new Counter();
		cntr1.incrementCounter();
		println("Value of cntr1: "+cntr1.getValue());
		
		Counter cntr2 = new Counter();
		cntr2.incrementCounter();
		cntr2.incrementCounter();
		cntr2.incrementCounter();
		println("Value of cntr2: "+cntr2.getValue());

		println("Value of cntr1: "+cntr1.getValue());
	}

}
