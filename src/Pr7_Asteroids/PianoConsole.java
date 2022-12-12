import java.applet.AudioClip;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: PianoConsole
 * 
 * A simple ConsoleProgram that plays a simple tune.
 * 
 * @see Music and mathematics,
 *      en.wikipedia.org/wiki/Mathematics_of_musical_scales
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class PianoConsole extends ConsoleProgram {

	private String[] tune = { "C", "D", "E", "F", "G", "G", "A", "A", "A", "A",
			"G" };

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		for (int i = 0; i < tune.length; i++) {
			print(tune[i] + ", ");
			AudioClip audioClip = getAudioClip(getCodeBase(), "music/"
					+ tune[i] + "4.wav");
			audioClip.play();
			pause(500);
			audioClip.stop();
		}

	}
}
