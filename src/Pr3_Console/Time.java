import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: Time
 * 
 * A Console program that prints the time in hour, minutes and seconds. For
 * testing purposes you should try the following test entries: 5, 61, 85, 3600,
 * 3601.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Time extends ConsoleProgram {
	private final int MAX_NUM = 10;

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		int secondsSinceMidnight = readInt("Enter time in seconds since midnight: ");
		int seconds = secondsSinceMidnight % 60;
		int minutesSinceMidnight = secondsSinceMidnight / 60;
		int hours = minutesSinceMidnight / 60;
		int minutes = minutesSinceMidnight % 60;
		String time = "" + padWithZeros("" + hours) + ":"
				+ padWithZeros("" + minutes) + ":" + padWithZeros("" + seconds);
		println("Time is: " + time);
	}

	private String padWithZeros(String s) {
		while (s.length() < 2) {
			s = '0' + s;
		}
		return s;
	}
}