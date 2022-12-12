import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: PointTester
 * 
 * This class tests the Point class.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class PointTester extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");
		
		Point p1 = new Point(2,3);
		println("p1: "+p1);

		Point p2 = new Point(-1,1);
		println("p2: "+p2);

		Point p3 = new Point(3,2);
		println("p3: "+p3);
		
		p3.add(p2);
		println("p3+p2 == p1?: "+p3.equals(p1));
		
		
	}

}
