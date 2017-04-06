package jpl.ch06.ex04;

import java.awt.Color;

//TODO
//ちょっと冗長。newはコンストラクタでやる
public enum TrafficLight {
	RED(Color.RED),
	YELLOW(Color.YELLOW),
	GREEN(Color.GREEN);
	
	final Color color;//2/2 final追加。
	
	TrafficLight(Color color) {this.color = color;}
	
	public Color getColor(){ return this.color;}
	
}
