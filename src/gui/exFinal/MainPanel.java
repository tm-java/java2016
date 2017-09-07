package gui.exFinal;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.util.List;

import javax.swing.JPanel;

public class MainPanel extends JPanel {
	private final Balls balls;
	private Image img;

	public MainPanel(Balls balls) {
		super();
		this.balls = balls;
//		URL url = this.getClass().getClassLoader().getResource("azarashi.png");
//		try {
//			img = this.createImage((ImageProducer) url.getContent());
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Ball b : balls.getArray()) {
			//g.setColor(b.getColor());
			g.drawImage(b.getImage(), b.getX() - b.getR(), b.getY() - b.getR(), this);
			// g.fillOval(b.getX() - b.getR(), b.getY() - b.getR(), b.getR() *
			// 2, b.getR() * 2);
			// System.out.println("print x: " + (b.getX() - b.getR()) + ", y: "
			// + (b.getY() - b.getR()));
		}

	}

}
