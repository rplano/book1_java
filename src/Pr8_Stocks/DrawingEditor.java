import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import acm.graphics.GFillable;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: DrawingEditor
 * 
 * A Swing program that draws geometric shapes. In addition it can load and save
 * graphics.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class DrawingEditor extends GraphicsProgram {

	private final int SIZE = 20;
	private final String FILE_NAME = "DrawingEditor.ser";

	private JComboBox cBoxColorPicker;
	private JRadioButton rBtnRect;
	private JRadioButton rBtnOval;
	private JCheckBox cBtnFilled;
	
	private ArrayList<GObject> objects = new ArrayList<GObject>();

	public void init() {
		setSize(300, 300);

		initShapeSelector();
		initFillSelector();
		initColorSelector();

		JButton btnOpen = new JButton("Load");
		add(btnOpen, SOUTH);
		JButton btnSave = new JButton("Save");
		add(btnSave, SOUTH);

		addMouseListeners();
		addActionListeners();
	}

	private void initShapeSelector() {
		rBtnRect = new JRadioButton("Rect");
		rBtnRect.setSelected(true);
		add(rBtnRect, NORTH);

		rBtnOval = new JRadioButton("Oval");
		add(rBtnOval, NORTH);

		ButtonGroup shapeGrp = new ButtonGroup();
		shapeGrp.add(rBtnRect);
		shapeGrp.add(rBtnOval);
	}

	private void initFillSelector() {
		cBtnFilled = new JCheckBox("Filled");
		add(cBtnFilled, NORTH);
	}

	private void initColorSelector() {
		cBoxColorPicker = new JComboBox();
		cBoxColorPicker.addItem("Red");
		cBoxColorPicker.addItem("Green");
		cBoxColorPicker.addItem("Blue");
		add(cBoxColorPicker, NORTH);
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		// select rect or oval
		GObject obj;
		if (rBtnRect.isSelected()) {
			obj = new GRect(SIZE, SIZE);
		} else {
			obj = new GOval(SIZE, SIZE);
		}

		// set color
		Color[] colors = { Color.RED, Color.GREEN, Color.BLUE };
		obj.setColor(colors[cBoxColorPicker.getSelectedIndex()]);

		// make filled
		if (cBtnFilled.isSelected()) {
			GFillable flbl = (GFillable) obj;
			flbl.setFilled(true);
		}

		add(obj, x, y);
		objects.add(obj);
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Load")) {
			openFile(FILE_NAME);
		} else if (cmd.equals("Save")) {
			saveFile(FILE_NAME);
		}
	}

	private void saveFile(String fileName) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(objects);
			oos.close();
			println("Save success.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void openFile(String fileName) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
			objects = (ArrayList<GObject>)ois.readObject();
			ois.close();
			println("Load success.");
			
			// add objects to canvas:
			removeAll();
			for (GObject obj : objects) {
				add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
