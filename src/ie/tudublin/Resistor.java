package ie.tudublin;

import java.awt.print.Printable;

import com.sun.prism.shader.FillCircle_Color_AlphaTest_Loader;

public class Resistor {
	public int value;
	public int ones;
	public int tens;
	public int hundreds;

	public Resistor(int value) {
		this.value = value;
		this.hundreds = (value / 100);
		this.tens = (value - (hundreds * 100)) / 10;
		this.ones = value - ((hundreds * 100) + (tens * 10));
	}

	public String toString() {
		return hundreds + "," + tens + "," + ones;
	}

	public void render(UI ui, int index, Colour c1, Colour c2, Colour c3) {
		int startX = ui.width / 2 - 50;
		int startY = (index + 1) * 30 + index * 80;
		ui.line(startX, startY + 40, startX+20, startY+40);
		ui.line(startX+20, startY, startX+20, startY+80);
		ui.line(startX+20, startY, startX + 80, startY);
		ui.line(startX+20, startY+80, startX+80, startY+80);
		ui.line(startX+80, startY, startX+80, startY+80);
		ui.line(startX+80, startY+40, startX + 100, startY+40);

		ui.fill(c1.red, c1.green, c1.blue);
		ui.rect(startX + 25, startY, 10, 80);
		ui.fill(c2.red, c2.green, c2.blue);
		ui.rect(startX + 40, startY, 10, 80);
		ui.fill(c3.red, c3.green, c3.blue);
		ui.rect(startX + 55, startY, 10, 80);

		ui.fill(0,0,0);
		ui.textSize(50);
		ui.textAlign(ui.CENTER);
		ui.text("" + value, startX + 180, startY + 60);
	}
}
