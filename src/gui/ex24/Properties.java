package gui.ex24;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Properties {
	// fontSize
	private int fontSizeIndex;
	private final String[] fontSizeName = new String[] { "50", "100", "150", "200", "250", "300" };
	private final Map<String, Integer> fontSizeMap = new LinkedHashMap<String, Integer>();

	// font
	private int fontIndex;
	private final String[] fontName;
	private final Map<String, Font> fontMap = new LinkedHashMap<String, Font>();
	private final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

	// color
	private int backColorIndex;
	private int clockColorIndex;
	private final String[] colorName = new String[] { "BLACK", "BLUE", "DARK_GRAY", "GREEN", "LIGHT_GRAY", "MAGENTA",
			"ORANGE", "PINK", "RED", "WHITE", "YELLOW" };
	private final Map<String, Color> colorMap = new LinkedHashMap<String, Color>();

	// 保存用のキーとなるもの
	final static String P000526874_FONTSIZE = "p000526874_fontSize";
	final static String P000526874_FONT = "p000526874_font";
	final static String P000526874_BACKCOLOR = "p000526874_backColor";
	final static String P000526874_CLOCKCOLOR = "p000526874_clockColor";

	private static final Properties instance = new Properties();

	private Properties() {
		// fontSize
		for (String s : fontSizeName) {
			fontSizeMap.put(s, Integer.parseInt(s));
		}

		// font
		final Font[] fonts = ge.getAllFonts();
		fontName = new String[fonts.length];
		int i = 0;
		for (Font f : fonts) {
			fontName[i] = f.getFontName();
			fontMap.put(fontName[i], f);
			i++;
		}

		// colorMap
		colorMap.put(colorName[0], Color.BLACK);
		colorMap.put(colorName[1], Color.BLUE);
		colorMap.put(colorName[2], Color.DARK_GRAY);
		colorMap.put(colorName[3], Color.GREEN);
		colorMap.put(colorName[4], Color.LIGHT_GRAY);
		colorMap.put(colorName[5], Color.MAGENTA);
		colorMap.put(colorName[6], Color.ORANGE);
		colorMap.put(colorName[7], Color.PINK);
		colorMap.put(colorName[8], Color.RED);
		colorMap.put(colorName[9], Color.WHITE);
		colorMap.put(colorName[10], Color.YELLOW);

		// プロパティの初期化
		fontSizeIndex = 0;
		fontIndex = 0;
		backColorIndex = 0;
		clockColorIndex = 1;
	}

	public static final Properties getInstance() {
		return instance;
	}

	//fontSize
	public void setFontSizeIndex(int index) {
		if (index < 0 && index >= fontSizeName.length) {
			index = 0;
		}
		fontSizeIndex = index;
	}

	public int getFontSize() {
		return getFontSize(fontSizeIndex);
	}
	
	public int getFontSize(int index) {
		if (index < 0 && index >= fontSizeName.length) {
			index = 0;
		}
		return fontSizeMap.get(fontSizeName[index]);
	}
	
	public String getFontSizeName() {
		return getFontSizeName(fontSizeIndex);
	}
	
	public String getFontSizeName(int index) {
		if (index < 0 && index >= fontSizeName.length) {
			index = 0;
		}
		return fontSizeName[index];
	}
	
	public int getFontSizeIndex() {
		return fontSizeIndex;
	}
	
	public int getFontSizeLength() {
		return fontSizeName.length;
	}

	//font
	public void setFontIndex(int index) {
		if (index < 0 && index >= fontName.length) {
			index = 0;
		}
		fontIndex = index;
	}

	public Font getFont() {
		return getFont(fontIndex);
	}
	
	public Font getFont(int index) {
		if (index < 0 && index >= fontName.length) {
			index = 0;
		}
		return fontMap.get(fontName[index]).deriveFont((float)getFontSize());
	}
	
	public String getFontName() {
		return getFontName(fontIndex);
	}
	
	public String getFontName(int index) {
		if (index < 0 && index >= fontName.length) {
			index = 0;
		}
		return fontName[index];
	}
	
	public int getFontIndex() {
		return fontIndex;
	}
	
	public int getFontLength() {
		return fontName.length;
	}

	//backColor
	public void setBackColorIndex(int index) {
		if (index < 0 && index >= colorName.length) {
			index = 0;
		}
		backColorIndex = index;
	}

	public Color getBackColor() {
		return getBackColor(backColorIndex);
	}
	
	public Color getBackColor(int index) {
		if (index < 0 && index >= colorName.length) {
			index = 0;
		}
		return colorMap.get(colorName[index]);
	}
	
	public String getBackColorName() {
		return getBackColorName(backColorIndex);
	}
	
	public String getBackColorName(int index) {
		if (index < 0 && index >= colorName.length) {
			index = 0;
		}
		return colorName[index];
	}
	
	public int getBackColorIndex() {
		return backColorIndex;
	}
	
	public int getBackColorLength() {
		return colorName.length;
	}

	//clockColor
	public void setClockColorIndex(int index) {
		if (index < 0 && index >= colorName.length) {
			index = 1;
		}
		clockColorIndex = index;
	}

	public Color getClockColor() {
		return getClockColor(clockColorIndex);
	}
	
	public Color getClockColor(int index) {
		if (index < 0 && index >= colorName.length) {
			index = 0;
		}
		return colorMap.get(colorName[index]);
	}
	
	public String getClockColorName() {
		return getClockColorName(clockColorIndex);
	}
	
	public String getClockColorName(int index) {
		if (index < 0 && index >= colorName.length) {
			index = 0;
		}
		return colorName[index];
	}
	
	public int getClockColorIndex() {
		return clockColorIndex;
	}
	
	public int getClockColorLength() {
		return colorName.length;
	}

}
