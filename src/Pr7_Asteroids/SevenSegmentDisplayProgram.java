import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: SevenSegmentDisplayProgram
 * 
 * A GraphicsProgram that uses SevenSegmentDisplay.
 * 
 * @see https://en.wikipedia.org/wiki/Seven-segment_display
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class SevenSegmentDisplayProgram extends GraphicsProgram {
	private final int LED_WIDTH = 6;
	private final int X_OFFSET = 50;

	public void run() {
		setSize(200, 150);

		SevenSegmentDisplay ssd1 = new SevenSegmentDisplay(40, 80, LED_WIDTH);
		add(ssd1, X_OFFSET + LED_WIDTH, LED_WIDTH);
		SevenSegmentDisplay ssd2 = new SevenSegmentDisplay(40, 80, LED_WIDTH);
		add(ssd2, X_OFFSET + 40 + 3 * LED_WIDTH, LED_WIDTH);

		for (int i = 0; i < 100; i++) {
			char tens = (char) ('0' + i / 10);
			ssd1.displayNumber(tens);
			char ones = (char) ('0' + i % 10);
			ssd2.displayNumber(ones);
			pause(500);
		}
	}
}

class SevenSegmentDisplay extends GCompound {
	private int width;
	private int height;
	private int ledWidth;
	private Color colorOn = Color.RED;
	private Color colorOff = Color.WHITE;

	private GRect upperHorizontal;
	private GRect middleHorizontal;
	private GRect lowerHorizontal;

	private GRect upperFrontVertical;
	private GRect upperBackVertical;
	private GRect lowerFrontVertical;
	private GRect lowerBackVertical;

	public SevenSegmentDisplay(int width, int height, int ledWidth) {
		super();
		this.width = width - 2 * ledWidth;
		this.height = height - 4 * ledWidth;
		this.ledWidth = ledWidth;
		addSegments();
	}

	// 4 A
	// 0 1 F B
	// 5 G
	// 2 3 E C
	// 6 D
	public void displayNumber(char c) {
		turnAllSegmentsOff();
		switch (c) {
		case '0':
			int[] code0 = { 1, 1, 1, 1, 1, 0, 1 };
			turnSegmentsOn(code0);
			break;
		case '1':
			int[] code1 = { 0, 1, 0, 1, 0, 0, 0 };
			turnSegmentsOn(code1);
			break;
		case '2':
			int[] code2 = { 0, 1, 1, 0, 1, 1, 1 };
			turnSegmentsOn(code2);
			break;
		case '3':
			int[] code3 = { 0, 1, 0, 1, 1, 1, 1 };
			turnSegmentsOn(code3);
			break;
		case '4':
			int[] code4 = { 1, 1, 0, 1, 0, 1, 0 };
			turnSegmentsOn(code4);
			break;
		case '5':
			int[] code5 = { 1, 0, 0, 1, 1, 1, 1 };
			turnSegmentsOn(code5);
			break;
		case '6':
			int[] code6 = { 1, 0, 1, 1, 0, 1, 1 };
			turnSegmentsOn(code6);
			break;
		case '7':
			int[] code7 = { 0, 1, 0, 1, 1, 0, 0 };
			turnSegmentsOn(code7);
			break;
		case '8':
			int[] code8 = { 1, 1, 1, 1, 1, 1, 1 };
			turnSegmentsOn(code8);
			break;
		case '9':
			int[] code9 = { 1, 1, 2, 1, 1, 1, 2 };
			turnSegmentsOn(code9);
			break;

		default:
			break;
		}
	}

	private void turnAllSegmentsOff() {
		upperFrontVertical.setColor(colorOff);
		upperBackVertical.setColor(colorOff);
		lowerFrontVertical.setColor(colorOff);
		lowerBackVertical.setColor(colorOff);
		upperHorizontal.setColor(colorOff);
		middleHorizontal.setColor(colorOff);
		lowerHorizontal.setColor(colorOff);
	}

	// 4
	// 0 1
	// 5
	// 2 3
	// 6
	private void turnSegmentsOn(int[] code) {
		if (code[0] == 1) {
			upperFrontVertical.setColor(colorOn);
		}
		if (code[1] == 1) {
			upperBackVertical.setColor(colorOn);
		}
		if (code[2] == 1) {
			lowerFrontVertical.setColor(colorOn);
		}
		if (code[3] == 1) {
			lowerBackVertical.setColor(colorOn);
		}
		if (code[4] == 1) {
			upperHorizontal.setColor(colorOn);
		}
		if (code[5] == 1) {
			middleHorizontal.setColor(colorOn);
		}
		if (code[6] == 1) {
			lowerHorizontal.setColor(colorOn);
		}
	}

	private void addSegments() {
		upperFrontVertical = new GRect(ledWidth, height / 2);
		upperFrontVertical.setFilled(true);
		add(upperFrontVertical, 0, ledWidth);

		upperBackVertical = new GRect(ledWidth, height / 2);
		upperBackVertical.setFilled(true);
		add(upperBackVertical, width + ledWidth, ledWidth);

		lowerFrontVertical = new GRect(ledWidth, height / 2);
		lowerFrontVertical.setFilled(true);
		add(lowerFrontVertical, 0, height / 2 + 2 * ledWidth);

		lowerBackVertical = new GRect(ledWidth, height / 2);
		lowerBackVertical.setFilled(true);
		add(lowerBackVertical, width + ledWidth, height / 2 + 2 * ledWidth);

		upperHorizontal = new GRect(width, ledWidth);
		upperHorizontal.setFilled(true);
		add(upperHorizontal, ledWidth, 0);

		middleHorizontal = new GRect(width, ledWidth);
		middleHorizontal.setFilled(true);
		add(middleHorizontal, ledWidth, height / 2 + ledWidth);

		lowerHorizontal = new GRect(width, ledWidth);
		lowerHorizontal.setFilled(true);
		add(lowerHorizontal, ledWidth, height + 2 * ledWidth);
	}

}
