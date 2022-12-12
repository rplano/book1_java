import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: DrawingEditor
 * 
 * A Swing program that draws geometric shapes.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class DrawingEditor extends ConsoleProgram {
	private JComboBox cBoxColorPicker;
	private JRadioButton rBtnRect;
	private JRadioButton rBtnOval;
	private JCheckBox cBtnFilled;

	public void init() {
		setSize(300, 150);

		initShapeSelector();
		initFillSelector();
		initColorSelector();

		addActionListeners();
	}

	private void initShapeSelector() {
		rBtnRect = new JRadioButton("Rect");
		rBtnRect.setSelected(true);
		add(rBtnRect, SOUTH);

		rBtnOval = new JRadioButton("Oval");
		add(rBtnOval, SOUTH);

		ButtonGroup shapeGrp = new ButtonGroup();
		shapeGrp.add(rBtnRect);
		shapeGrp.add(rBtnOval);
	}

	private void initFillSelector() {
		cBtnFilled = new JCheckBox("Filled");
		add(cBtnFilled, SOUTH);
	}

	private void initColorSelector() {
		cBoxColorPicker = new JComboBox();
		cBoxColorPicker.addItem("Red");
		cBoxColorPicker.addItem("Green");
		cBoxColorPicker.addItem("Blue");
		add(cBoxColorPicker, SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		println("Color:" + cBoxColorPicker.getSelectedItem());
		println("Rect:" + rBtnRect.isSelected());
		println("Oval:" + rBtnOval.isSelected());
		println("Filled:" + cBtnFilled.isSelected());
	}
}
