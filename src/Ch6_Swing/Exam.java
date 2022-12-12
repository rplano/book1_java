import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: 6. Exam
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Exam extends Program {

	public void init() {
		setSize(300, 150);

		JLabel lbl = new JLabel("Correct:  1 + 1 = 2 ?");
		add(lbl, NORTH);

		JRadioButton yes = new JRadioButton("Yes");
		yes.setSelected(true);
		add(yes, SOUTH);

		JRadioButton no = new JRadioButton("No");
		add(no, SOUTH);

		ButtonGroup happyGrp = new ButtonGroup();
		happyGrp.add(yes);
		happyGrp.add(no);
	}
}
