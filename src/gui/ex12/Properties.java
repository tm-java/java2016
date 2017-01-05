package gui.ex12;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;

public class Properties {
	private int fontSize;
	private Font font;
	private Color backColor;
	private Color clockColor;
	
	private static final Properties instance = new Properties();
	
	private Properties(){
		fontSize = 100;
		font = new Font("Copperplate Light", Font.PLAIN, fontSize);

		backColor = new Color(90,65,40);
		clockColor = new Color(255,255,240); 
	}
	
	public static final Properties getInstance(){
		return instance;
	}
	
	public void setFontSize(int size){
		if(0 >= size)fontSize = 1;
		else if(1000 < size) fontSize = 1000;
		else fontSize = size;
	}
	
	public int getFontSize(){
		return fontSize;
	}
	
	public void setFont(Font f){
		font = f;	
	}
	
	public Font getFont(){
		return font;
	}
	
	public void setBackColor(Color c){
		backColor = c;
	}
	
	public Color getBackColor(){
		return backColor;
	}
	
	public void setClockColor(Color c){
		clockColor = c;
	}
	
	public Color getClockColor(){
		return clockColor;
	}

}
