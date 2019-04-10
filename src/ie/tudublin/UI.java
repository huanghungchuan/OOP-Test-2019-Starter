package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet {
	public ArrayList<Colour> colours = new ArrayList<>();
	public ArrayList<Resistor> resistors = new ArrayList<>();

	public void loadColours() {
		Table table = loadTable("colours.csv", "header");
		for (TableRow row : table.rows()) {
			Colour colour = new Colour(row);
			colours.add(colour);
		}
	}

	public void loadResistors() {
		Table table = loadTable("resistors.csv");
		for (TableRow row : table.rows()) {
			Resistor resistor = new Resistor(row.getInt(0));
			resistors.add(resistor);
			println(resistor.toString());
		}
	}

	public void printColours() {
		for (Colour colour : colours) {
			println(colour.toString());
		}
		println(colours.get(9).toString());
	}

	public Colour findColor(int value) {
		for (Colour colour : colours) {
			if (colour.value == value)
				return colour;
		}
		println("No collour found.");
		return null;
	}

	public void separate(int value) {
		int hundreds = (value / 100);
		int tens = (value - (hundreds * 100)) / 10;
		int ones = value - ((hundreds * 100) + (tens * 10));
		print(hundreds + ",");
		print(tens + ",");
		println(ones);
	}

	public void settings() {
		size(500, 800);
		separate(381);
		separate(1);
		separate(92);
	}

	public void setup() {
		loadColours();
		loadResistors();
	}

	public void draw() {
		for(int i = 0; i < resistors.size(); i++) {
			Colour c1 = findColor(resistors.get(i).hundreds);
			Colour c2 = findColor(resistors.get(i).tens);
			Colour c3 = findColor(resistors.get(i).ones);
			resistors.get(i).render(this, i, c1, c2, c3);
		}

	}
}
