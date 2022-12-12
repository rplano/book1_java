import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: AlarmClock
 * 
 * A Swing program that can set a time to create an alarm.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class AlarmClock extends Program {
	private final int SIZE = 300;
	private final int WIDTH = SIZE;
	private final int HEIGHT = 150;

	private final int DELAY = 500;

	private JLabel face;
	private JTextField tfAlarm;
	private JButton btnStart;

	private long alarmTime = -1;
	private boolean alarmStarted = false;

	public void init() {
		setSize(WIDTH, HEIGHT);

		face = new JLabel("0:00:00");
		face.setFont(new Font("SansSerif", Font.PLAIN, 60));
		add(face, NORTH);

		tfAlarm = new JTextField(10);
		tfAlarm.setHorizontalAlignment(SwingConstants.RIGHT);
		tfAlarm.addActionListener(this);
		add(tfAlarm, SOUTH);

		btnStart = new JButton("Set Alarm");
		add(btnStart, SOUTH);

		addActionListeners();
	}

	public void run() {
		while (true) {
			if (alarmStarted) {
				long remainingTime = alarmTime - System.currentTimeMillis();
				face.setText(convertSecondsInTime(remainingTime));
				if (remainingTime <= 0) {
					alarmStarted = false;
				}
			}
			pause(DELAY);
		}
	}

	public void actionPerformed(ActionEvent e) {

		String time = tfAlarm.getText();

		int deltaTime = convertTimeInSeconds(time);
		alarmTime = System.currentTimeMillis() + deltaTime;
		alarmStarted = true;
	}

	/**
	 * converts a time given in hours:minutes:seconds into seconds
	 * 
	 * @param time
	 * @return
	 */
	private int convertTimeInSeconds(String time) {
		int hours = 0;
		int minutes = 0;
		int seconds = 0;
		if (time.length() == 0) {
			time = "0";
		}
		String[] times = time.split(":");

		if (times.length == 1) {
			hours = 0;
			minutes = 0;
			seconds = Integer.parseInt(times[0]);
		} else if (times.length == 2) {
			hours = 0;
			minutes = Integer.parseInt(times[0]);
			seconds = Integer.parseInt(times[1]);
		} else if (times.length == 3) {
			hours = Integer.parseInt(times[0]);
			minutes = Integer.parseInt(times[1]);
			seconds = Integer.parseInt(times[2]);
		} else {
			println("we should never get here!");
		}

		int deltaTime = hours * 3600000 + minutes * 60000 + seconds * 1000;
		return deltaTime;
	}

	/**
	 * converts a time given in seconds into a time given in
	 * hours:minutes:seconds
	 * 
	 * @param time
	 * @return
	 */
	private String convertSecondsInTime(long time) {
		long hours = time / 3600000;
		long minutes = (time % 3600000) / 60000;
		long seconds = ((time % 3600000) % 60000) / 1000;
		String text = "";
		text += hours;
		text += ":";
		text += padWithChars("" + minutes, '0', 2);
		text += ":";
		text += padWithChars("" + seconds, '0', 2);
		return text;
	}

	private String padWithChars(String s, char c, int length) {
		while (s.length() < length) {
			s = c + s;
		}
		return s;
	}
}