import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;

import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: Clock
 * 
 * A Swing program that displays the time in big letters using a JLabel.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Clock extends Program {
	private final int WIDTH = 300;
	private final int HEIGHT = 150;

	private final int DELAY = 500;

	private JLabel face;

	public void init() {
		setSize(WIDTH, HEIGHT);

		face = new JLabel("88:88:88");
		face.setFont(new Font("SansSerif", Font.PLAIN, 60));
		add(face, NORTH);
	}

	public void run() {
		while (true) {
			face.setText(getTime());
			pause(DELAY);
		}
	}

	private String getTime() {
		Date time = new Date();
		String text = "";
		text += time.getHours();
		text += ":";
		text += padWithChars("" + time.getMinutes(), '0', 2);
		text += ":";
		text += padWithChars("" + time.getSeconds(), '0', 2);
		return text;
	}

	private String padWithChars(String s, char c, int length) {
		while (s.length() < length) {
			s = c + s;
		}
		return s;
	}

}
