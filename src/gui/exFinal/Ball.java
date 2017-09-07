package gui.exFinal;

import java.awt.Color;
import java.awt.Image;

public interface Ball {
	void gravity();
	void move();
	int getX();
	void setX(int x);
	int getY();
	void setY(int y);
	int getR();
	double getVX();
	void setVX(double vx);
	double getVY();
	void setVY(double vy);
	double getM();
	Image getImage();
}
