package gui.ex23;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Properties {
	private int fontSize;
	private Font font;
	private Color backColor;
	private Color clockColor;
	private int screenWidth;
	private int screenHeight;
	
	//サイズの一覧
	static final List<Integer> sizeList = new ArrayList<Integer>();
	//色の一覧
	static final Map<String,Color> colorMap = new HashMap<String, Color>();
	//フォントの一覧
	private GraphicsEnvironment ge;
	private final Font[] fonts;
	List<Font> fontList = new ArrayList<Font>();
	
	private static final Properties instance = new Properties();
	
	private Properties(){
		
		//fontList
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fonts = ge.getAllFonts();
		fontList = Arrays.asList(fonts);
		
		//sizeList
		for(int i=50;i<=300;i+=50){
			sizeList.add(i);
		}
		
		//colorMap
		colorMap.put("BLACK",Color.BLACK);
		colorMap.put("BLUE",Color.BLUE);
		colorMap.put("DARK_GRAY",Color.DARK_GRAY);
		colorMap.put("GREEN",Color.GREEN);
		colorMap.put("LIGHT_GRAY",Color.LIGHT_GRAY);
		colorMap.put("MAGENTA",Color.MAGENTA);
		colorMap.put("ORANGE",Color.ORANGE);
		colorMap.put("PINK",Color.PINK);
		colorMap.put("RED",Color.RED);
		colorMap.put("WHITE",Color.WHITE);
		colorMap.put("YELLOW",Color.YELLOW);
		
		
		
		//プロパティの初期化
		fontSize = sizeList.get(1);
		font = fontList.get(0);
		font = font.deriveFont((float)fontSize);
		backColor = colorMap.get("BLACK");
		clockColor = colorMap.get("WHITE");
	}
	
	public static final Properties getInstance(){
		return instance;
	}
	
	public void setFontSize(int size){
		if(0 >= size)fontSize = 1;
		else if(300 < size) fontSize = 300;
		else fontSize = size;
		
		font = font.deriveFont((float)fontSize);
		
	}
	
	public int getFontSize(){
		return fontSize;
	}
	
	public void setFont(Font f){
		font = f.deriveFont((float)fontSize);	
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
