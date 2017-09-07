package gui.exFinal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JWindow;

import java.util.Map.Entry;
import java.util.Random;

public class DigitalClock extends JWindow {
	// 各種設定
	private final Properties p = Properties.getInstance();

	// メインパネル
	private JPanel mainPanel;

	// 時計のラベル
	private JLabel clock;

	// ポップアップメニュー
	private JPopupMenu pm;
	// private int size;//フォントサイズ

	// クリックした座標 ドラッグでウィンドウ移動させる用
	private int pointX;
	private int pointY;

	// 時間
	private DateFormat format;
	private String clockTime = "00:00:00";

	// ボール
	private final Balls bolls = new Balls();
	Image azarashiI, kumaI, usagiI, toriI;
	private final List<Image> imgs = new ArrayList<>();

	// main
	public static void main(String[] args) {
		new DigitalClock(new JFrame());
	}

	DigitalClock(JFrame parent) throws HeadlessException {
		super(parent);
		//this.setSize(p.getFontSize() * 10, p.getFontSize() * 3);
		this.setSize(300, 400);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		// パネル
		mainPanel = new MainPanel(bolls);
		mainPanel.setPreferredSize(new Dimension(300, 400));
		// ウィンドウの変更に対して、mainPanelのサイズも変更
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				//DigitalClock.this.matchWindow();
			}
		});
		this.add(mainPanel);

		// ポップアップメニュー
		pm = new JPopupMenu();
		// メニューフォントサイズ
		// JMenu clockSize = new JMenu("Clock Size");
		// for(int size: p.sizeList){
		// JMenuItem mi = new JMenuItem(Integer.toString(size));
		// //選択されたサイズに変更
		// mi.addActionListener(e -> {
		// p.setFontSize(size);
		// this.setCurrentClockFont();
		// this.matchWindow();
		// });
		// clockSize.add(mi);
		// }
		// pm.add(clockSize);
		// //メニューフォント名
		// JMenu clockFont = new JMenu("Clock Font");
		// for(Font f: p.fontList){
		// JMenuItem mi = new JMenuItem(f.getFontName());
		// //選択されたフォントに変更
		// mi.addActionListener( e -> {
		// p.setFont(f);
		// this.setCurrentClockFont();
		// });
		// clockFont.add(mi);
		// }
		// pm.add(clockFont);
		// //メニューフォントカラー
		// JMenu clockColor = new JMenu("Clock Color");
		// for(Entry<String, Color> entry : Properties.colorMap.entrySet()){
		// JMenuItem mi = new JMenuItem(entry.getKey());
		// //選択された色に変更
		// mi.addActionListener( e -> {
		// p.setClockColor(entry.getValue());
		// this.setCurrentClockColor();
		// });
		// clockColor.add(mi);
		// }
		// pm.add(clockColor);
		// //メニュー背景色
		// JMenu backColor = new JMenu("Backgraound Color");
		// for(Entry<String, Color> entry : Properties.colorMap.entrySet()){
		// JMenuItem mi = new JMenuItem(entry.getKey());
		// //選択された色に変更
		// mi.addActionListener( e -> {
		// p.setBackColor(entry.getValue());
		// this.setCurrentBackgroundColor();
		// });
		// backColor.add(mi);
		// }
		// pm.add(backColor);
		// メニューExit (システムを終了させる)
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		pm.add(exit);
		this.add(pm);

		// image
		URL azarashi = this.getClass().getClassLoader().getResource("azarashi.png");
		URL kuma = this.getClass().getClassLoader().getResource("kuma.png");
		URL usagi = this.getClass().getClassLoader().getResource("usagi.png");
		URL tori = this.getClass().getClassLoader().getResource("tori.png");
		try {
			azarashiI = this.createImage((ImageProducer) azarashi.getContent());
			kumaI = this.createImage((ImageProducer) kuma.getContent());
			usagiI = this.createImage((ImageProducer) usagi.getContent());
			toriI = this.createImage((ImageProducer) tori.getContent());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		imgs.add(azarashiI);
		imgs.add(kumaI);
		imgs.add(usagiI);
		imgs.add(toriI);

		// マウスクリック
		mainPanel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				bolls.add(new CircleBall(x, y, 20, 100, imgs.get(new Random().nextInt(4))));
				// System.out.println("click x: " + x + ", y: "+ y);
				repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// ウィンドウを移動させるための始点
				pointX = e.getXOnScreen();
				pointY = e.getYOnScreen();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				int btn = e.getButton();
				// 右クリックでポップアップメニュー表示
				if (btn == MouseEvent.BUTTON3) {
					pm.show((Component) e.getSource(), e.getX(), e.getY());
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});

		mainPanel.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				// ウィンドウの移動を行う
				int getX = e.getXOnScreen();
				int getY = e.getYOnScreen();// 現在の座標
				int dx = getX - pointX;
				int dy = getY - pointY; // 前の座標との差分をとって、どの程度移動したか計算
				// System.out.println("Xloc="+DigitalClock2.this.getLocation().x+"
				// Yloc="+DigitalClock2.this.getLocation().y);
				// System.out.println("x="+getX+" pointX="+pointX+" y="+getY+"
				// pointY="+pointY);

				pointX = getX;
				pointY = getY; // 座標を更新
				DigitalClock.this.setLocation(dx + DigitalClock.this.getLocation().x,
						dy + DigitalClock.this.getLocation().y);
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
			}
		});

		// label
		clock = new JLabel();
		mainPanel.add(clock);

		// timer
		format = new SimpleDateFormat("HH:mm:ss");
		setTime();
		Timer t = new Timer();
		t.schedule(new TimerLabelTask(), 0, 100);

		// property
		this.setCurrentBackgroundColor();
		this.setCurrentClockColor();
		this.setCurrentClockFont();
		//this.matchWindow();

		this.setVisible(true);
	}

	public void setTime() {
		// bolls
		bolls.move();

		// time
		Calendar calendar = Calendar.getInstance(Locale.JAPAN);
		clockTime = format.format(calendar.getTime());
		clock.setText(clockTime);
		repaint();
	}

	class TimerLabelTask extends TimerTask {
		public void run() {
			setTime();
		}
	}

	public void setCurrentClockColor() {
		clock.setForeground(p.getClockColor());
	}

	public void setCurrentClockFont() {
		clock.setFont(p.getFont());
	}

	public void setCurrentBackgroundColor() {
		mainPanel.setBackground(p.getBackColor());
	}

	public void matchWindow() {
		int x = p.getFontSize() * 5;
		int y = p.getFontSize();
		this.setSize(x, y);
		mainPanel.setPreferredSize(new Dimension(x, y));
	}

}
