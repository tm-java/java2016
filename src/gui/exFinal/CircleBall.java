package gui.exFinal;

import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;

public class CircleBall implements Ball {
	
	private int x;//中心
	private int dx;
	private int y;//中心
	private int dy;
	private int r;
	private Color color;
	
	private final double g = 9.8;//重力加速度　した方向が、プラス
	private final int buttom = 380;
	private final int d;//落下時間　単位：ms
	private double vy;
	private double vx;
	private Image icon;
	
	public CircleBall(int x, int y, int r, int d, Image img) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.d = d;
		this.vy = 0;
		this.dx = 0;
		this.dy = 0;
		this.vx = 0;
		this.vy = 0;
		this.icon = img;
	}
	
	public void gravity() {
		vy += g * (d / 500.0);
		//床にぶつかったら
		if ((y + (int)Math.round(vy * (d /500.0))) > buttom) {
			vy *= - 0.3;
			vx *= 0.7;
		}
		int newX = x + (int) Math.round(vx * (d/500.0));
		if (newX < 20 || newX > 280) {
			vx = -0.7 * vx;
		}
		dy = (int) Math.round(vy * (d/500.0));
		dx = (int) Math.round(vx * (d/500.0));
	}
	
	@Override
	public void move() {
		y += dy;
		x += dx;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public int getR() {
		return this.r;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}


	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public double getVX() {
		return this.vx;
	}

	@Override
	public void setVX(double vx) {
		this.vx = vx;
	}

	@Override
	public double getVY() {
		return this.vy;
	}

	@Override
	public void setVY(double vy) {
		this.vy = vy;
	}

	@Override
	public double getM() {
		return 5.0;
	}

	@Override
	public Image getImage() {
		return icon;
	}

}
