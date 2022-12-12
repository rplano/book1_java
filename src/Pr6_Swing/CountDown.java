import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: CountDown
 * 
 * A Swing program that counts down second using a JLabel.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class CountDown extends Program {

	private final int DELAY = 500;

	private JTextField tfAlarm;
	private JButton btnStart;
	private long stopTime = -1;

	public void init() {
		setSize(300, 150);

		tfAlarm = new JTextField("0");
		tfAlarm.setHorizontalAlignment(SwingConstants.RIGHT);
		tfAlarm.setFont(new Font("SansSerif", Font.PLAIN, 60));
		add(tfAlarm, CENTER);

		btnStart = new JButton("Start");
		add(btnStart, SOUTH);

		addActionListeners();
	}

	public void run() {
		while (true) {
			long time = stopTime - System.currentTimeMillis();
			if (time > -1) {
				String text = "" + time / 1000;
				tfAlarm.setText(text);
			}
			pause(DELAY);
		}
	}

	public void actionPerformed(ActionEvent e) {
		int time = Integer.parseInt(tfAlarm.getText());
		stopTime = System.currentTimeMillis() + time * 1000;
	}

}
