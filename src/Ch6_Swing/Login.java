
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: 4. Login
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Login extends ConsoleProgram {
	private JTextField tf;

	public void init() {
		setSize(300, 150);

		JLabel lbl = new JLabel("Name: ");
		add(lbl, SOUTH);

		tf = new JTextField(10);
		tf.addActionListener(this);
		add(tf, SOUTH);
		
		JButton btn = new JButton("Login");
		add( btn, SOUTH );
		
		addActionListeners();
	}

	public void actionPerformed(ActionEvent e) {
		println("Name: " + tf.getText());
	}

}
