import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: StopWatch
 * 
 * A Swing program set a time to create an alarm.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class StopWatch extends Program {
	private final int SIZE = 300;
	private final int WIDTH = SIZE;
	private final int HEIGHT = 150;

	private final int DELAY = 20;

	private JLabel face;
	private JButton btnStart;
	private JButton btnPause;

	private long startTime = -1;
	private boolean shouldPause = false;

	public void init() {
		setSize(WIDTH, HEIGHT);

		face = new JLabel("00:000");
		face.setFont(new Font("SansSerif", Font.PLAIN, 60));
		add(face, NORTH);

		btnStart = new JButton("Start");
		add(btnStart, SOUTH);

		btnPause = new JButton("Pause");
		add(btnPause, SOUTH);

		addActionListeners();
	}

	public void run() {
		while (true) {
			if (startTime > -1 && !shouldPause) {
				long time = System.currentTimeMillis() - startTime;
				String text = "";
				text += String.format("%02d", time / 1000);
				text += ":";
				text += String.format("%03d", time % 1000);
				face.setText(text);
			}
			pause(DELAY);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStart) {
			if (startTime > -1) {
				btnStart.setText("Start");
				startTime = -1;
			} else {
				btnStart.setText("Stop");
				startTime = System.currentTimeMillis();
			}
		} else {
			shouldPause = !shouldPause;
		}
	}
}
