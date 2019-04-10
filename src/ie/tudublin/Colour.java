package ie.tudublin;

import processing.data.TableRow;

public class Colour {
	public int red;
	public int green;
	public int blue;
	public int value;
	private String colour;

	public Colour() {
		red = 255;
		green = 255;
		blue = 255;
		value = 0;
		setColour("white");
	}
	public Colour(TableRow row) {
		red = row.getInt("r");
		green = row.getInt("g");
		blue = row.getInt("b");
		value = row.getInt("value");
		setColour(row.getString("colour"));
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String toString() {
		String value = "Color:" + this.colour + "\tR=" + this.red + "\tG=" + this.green + "\tB=" + this.blue + "\tValue="
				+ this.value;
		return value;
	}

}
