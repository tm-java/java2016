package gui.exFinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Balls {
	private final List<Ball> balls = new ArrayList<>();

	public boolean add(Ball b) {
		return balls.add(b);
	}

	public List<Ball> getArray() {
		return new ArrayList(balls);
	}

	public void move() {
		for (int i = 0; i < balls.size(); i++) {
			for (int j = i + 1; j < balls.size(); j++) {
				checkCollision(balls.get(i), balls.get(j));
			}
			balls.get(i).gravity();
			balls.get(i).move();
		}
	}

	private void checkCollision(Ball a, Ball b) {
		int diffx = b.getX() - a.getX();
		int diffy = b.getY() - a.getY();
		int diff = diffx * diffx + diffy * diffy;
		int diffr = a.getR() * a.getR() + 2 * a.getR() * b.getR() + b.getR() * b.getR();
		// 衝突している
		if (diff < diffr) {
			double radian = Math.atan2(diffy, diffx);
			double sin = Math.sin(radian);
			double cos = Math.cos(radian);
			// 位置の回転
			Point p0 = new Point(0.0, 0.0);
			// 位置の回転
			Point p1 = rotate(diffx, diffy, sin, cos, true);
			// 速度の回転
			Point p0v = rotate(a.getVX(), a.getVY(), sin, cos, true);
			// 速度の回転
			Point p1v = rotate(b.getVX(), b.getVY(), sin, cos, true);
			// 衝突反応
			double vxTotal = (p0v.x - p1v.x);
			// 運動量の保存
			p0v.x = ((a.getM() - b.getM()) * p0v.x + 2 * b.getM() * p0v.x) / (a.getM() + b.getM());
			p1v.x = (vxTotal + p0v.x);

			// 位置の更新
			double absV = Math.abs(p0v.x) + Math.abs(p1v.x);
			double overlap = (a.getR() + b.getR()) - Math.abs(p0.x - p1.x);
			p0.x += (p0v.x / absV) * overlap * 0.1;
			p1.x += (p1v.x / absV) * overlap * 0.1;

			// 位置の回転、元へ戻す
			Point aFinal = rotate(p0.x, p0.y, sin, cos, false);
			Point bFinal = rotate(p1.x, p1.y, sin, cos, false);

			// 速度の回転、元の位置へ戻す
			Point avFinal = rotate(p0v.x, p0v.y, sin, cos, false);
			Point bvFinal = rotate(p1v.x, p1v.y, sin, cos, false);

			/*
			 * 衝突判定の予測分だけ速度を加算する
			 */
			//if ((int) Math.round(bFinal.x) > b.getM()) {
				b.setVX(bvFinal.x);
				b.setX(a.getX() + (int) Math.round(bFinal.x));
			//}
			
				b.setVY(bvFinal.y);
				b.setY(a.getY() + (int) Math.round(bFinal.y));
			//if ((int) Math.round(aFinal.x) > a.getM()) {
				a.setVX(avFinal.x);
				a.setX(a.getX() + (int) Math.round(aFinal.x));
			//}
				a.setVY(avFinal.y);
				a.setY(a.getY() + (int) Math.round(aFinal.y));

			
			System.out.println("x:" + b.getX() + " y:" + b.getY() + " vx:" + b.getVX() + " vy:" + b.getVY());
		}
	}

	/*
	 * 回転行列
	 */
	private Point rotate(double x, double y, double sin, double cos, boolean reverse) {
		Point result = new Point(x, y);
		if (reverse) {
			result.x = x * cos + y * sin;
			result.y = y * cos - x * sin;
		} else {
			result.x = x * cos - y * sin;
			result.y = y * cos + x * sin;
		}
		return result;
	}

	private class Point {
		double x;
		double y;

		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
}
