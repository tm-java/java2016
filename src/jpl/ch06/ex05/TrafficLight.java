package jpl.ch06.ex05;

import java.awt.Color;

public enum TrafficLight {
	RED {
		public Color getColor(){return Color.RED;}
	},
	YELLOW {
		public Color getColor(){return Color.YELLOW;}
	},
	GREEN{
		public Color getColor(){return Color.GREEN;}
	};
		
	abstract public Color getColor();
	

}
