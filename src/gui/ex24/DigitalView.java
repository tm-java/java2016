package gui.ex24;

import java.awt.Color;
import java.awt.Font;

public interface DigitalView {
	void setCurrentBackgroundColor();

	void setCurrentClockColor();

	void setCurrentClockFont();

	void matchWindow();
	
	void matchWindow(int x, int y);
}
