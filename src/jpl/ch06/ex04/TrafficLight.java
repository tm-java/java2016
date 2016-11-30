package jpl.ch06.ex04;

import java.awt.Color;

public enum TrafficLight {
	RED(Color.RED),
	YELLOW(Color.YELLOW),
	GREEN(Color.GREEN);
	
	Color color;
	
	TrafficLight(Color color) {this.color = color;}
	
	public Color getColor(){ return this.color;}
	
}
