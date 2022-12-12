import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;

import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: 8. LayoutExample
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class LayoutExample extends Program {

	public void init() {
		setSize(300, 150);
		showBorderLayout();
		// showFlowLayout();
		// showGridLayout();
	}

	private void showGridLayout() {
		setLayout(new GridLayout(2, 3));
		add(new JButton("0"));
		add(new JButton("1"));
		add(new JButton("2"));
		add(new JButton("3"));
		add(new JButton("4"));
		add(new JButton("5"));
	}

	private void showFlowLayout() {
		setLayout(new FlowLayout());
		add(new JButton("0"));
		add(new JButton("1"));
		add(new JButton("2"));
		add(new JButton("3"));
		add(new JButton("4"));
		add(new JButton("5"));
		add(new JButton("6"));
	}

	private void showBorderLayout() {
		setLayout(new BorderLayout());
		add(new JButton("EAST"), EAST);
		add(new JButton("WEST"), WEST);
		add(new JButton("NORTH"), NORTH);
		add(new JButton("SOUTH"), SOUTH);
		add(new JButton("CENTER"), CENTER);
	}
}
