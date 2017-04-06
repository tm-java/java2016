package gui.ex14;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import java.util.Map.Entry;

public class DigitalClock extends Frame {
	// 各種設定
	private final Properties p = Properties.getInstance();
	private Preferences prefs;

	// ダブルバッファリング用
	private Graphics gBuf;
	private Image imgBuf;

	// クリックした座標 ドラッグでウィンドウ移動させる用
	private int pointX;
	private int pointY;

	// 時間
	private DateFormat format;
	private String clockTime = "00:00:00";

	// ウィンドウの座標
	private int windowX;
	private int windowY;
	private final static String P000526874_WINDOWX = "p000526874_windowX";
	private final static String P000526874_WINDOWY = "p000526874_windowY";

	// main
	public static void main(String[] args) {
		new DigitalClock();
	}

	// コンストラクタ
	DigitalClock() throws HeadlessException {
		prefs = Preferences.userNodeForPackage(this.getClass());
		load();

		// ウィンドウの設定
		this.setSize(p.getFontSize() * 10, p.getFontSize() * 3);
		this.setBackground(p.getBackColor());
		this.setLocation(windowX, windowY);

		// ダイアログ
		SettingDialog settingDialog = new SettingDialog();
		settingDialog.setVisible(false);

		// バツボタンで閉じる
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				save();
				System.exit(0);
			}
		});

		// メニューバーの設定
		MenuBar mb = new MenuBar();
		Menu settings = mb.add(new Menu("Menu"));
		settings.add(new MenuItem("settings"));
		settings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				settingDialog.setVisible(true);
			}
		});
		this.setMenuBar(mb);

		// マウスクリック
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// ウィンドウを移動させるための始点
				pointX = e.getXOnScreen();
				pointY = e.getYOnScreen();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});

		this.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				// ウィンドウの移動を行う
				int getX = e.getXOnScreen();
				int getY = e.getYOnScreen();// 現在の座標
				int dx = getX - pointX;
				int dy = getY - pointY; // 前の座標との差分をとって、どの程度移動したか計算
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

		// timer
		format = new SimpleDateFormat("HH:mm:ss");
		setTime();
		Timer t = new Timer();
		t.schedule(new TimerLabelTask(), 0, 1000);

		this.setVisible(true);

	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		// ダブルバッファリング
		imgBuf = createImage(p.getFontSize() * 10, p.getFontSize() * 3);
		gBuf = imgBuf.getGraphics();

		gBuf.setColor(p.getBackColor());
		gBuf.fillRect(0, 0, p.getFontSize() * 10, p.getFontSize() * 3);
		// System.out.println(p.getFontSize()*10+" "+this.getWidth());
		gBuf.setColor(p.getClockColor());
		gBuf.setFont(p.getFont());
		gBuf.drawString(clockTime, getWidth() / 4, getHeight() / 2 + 20);

		this.setSize(p.getFontSize() * 10, p.getFontSize() * 3);
		g.drawImage(imgBuf, 0, 0, this);
	}

	public void setTime() {
		Calendar calendar = Calendar.getInstance(Locale.JAPAN);
		clockTime = format.format(calendar.getTime());
	}

	class TimerLabelTask extends TimerTask {
		public void run() {
			setTime();
			repaint();
		}
	}

	public void save() {
		prefs.put(p.P000526874_FONT, String.valueOf(p.getFontIndex()));
		prefs.put(p.P000526874_FONTSIZE, String.valueOf(p.getFontSizeIndex()));
		prefs.put(p.P000526874_BACKCOLOR, String.valueOf(p.getBackColorIndex()));
		prefs.put(p.P000526874_CLOCKCOLOR, String.valueOf(p.getClockColorIndex()));
		prefs.put(P000526874_WINDOWX, String.valueOf(this.getX()));
		prefs.put(P000526874_WINDOWY, String.valueOf(this.getY()));
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		p.setFontSizeIndex(Integer.parseInt(prefs.get(p.P000526874_FONTSIZE, "0")));
		p.setFontIndex(Integer.parseInt(prefs.get(p.P000526874_FONT, "0")));
		p.setBackColorIndex(Integer.parseInt(prefs.get(p.P000526874_BACKCOLOR, "0")));
		p.setClockColorIndex(Integer.parseInt(prefs.get(p.P000526874_CLOCKCOLOR, "1")));
		windowX = Integer.parseInt(prefs.get(P000526874_WINDOWX, "0"));
		windowY = Integer.parseInt(prefs.get(P000526874_WINDOWY, "0"));
	}
}
