/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: 4a. Student
 * 
 * Shows how to write a class.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Student {
	private String name;
	private int id;
	private double credits;

	public Student(String name, int id, double credits) {
		super();
		this.name = name;
		this.id = id;
		this.credits = credits;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public double getCredits() {
		return credits;
	}

	public void setName(String n) {
		name = n;
	}

	public void incrementCredits(double c) {
		if (c >= 0) {
			credits += c;
		}
	}

	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", credits=" + credits
				+ "]";
	}

}
