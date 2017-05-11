package gui.ex21;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.util.Map.Entry;

public class DigitalClock extends JFrame implements DigitalView{
	// 各種設定
	private final Properties p = Properties.getInstance();
	private Preferences prefs;
	
	//メインパネル
	private JPanel mainPanel;
	
	//時計のラベル
	private JLabel clock;

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
	DigitalClock() {
		prefs = Preferences.userNodeForPackage(this.getClass());
		load();

		// ウィンドウの設定
		this.setSize(p.getFontSize() * 10, p.getFontSize() * 3);
		this.setLocation(windowX, windowY);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// ダイアログ
		SettingDialog settingDialog = new SettingDialog(this);
		settingDialog.setVisible(false);

		// バツボタンで閉じる
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//パネル
		mainPanel = new JPanel();
		//ウィンドウの変更に対して、mainPanelのサイズも変更
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				DigitalClock.this.matchWindow();
			}
		});
		this.add(mainPanel);

		// メニューバーの設定
		JMenuBar mb = new JMenuBar();
		JMenu menu = mb.add(new JMenu("Menu"));
		JMenuItem settings = new JMenuItem("settings");
		settings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				settingDialog.setVisible(true);
			}
		});
		menu.add(settings);
		this.setJMenuBar(mb);

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
				DigitalClock.this.matchWindow();
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
		
		//label
		clock = new JLabel();
		mainPanel.add(clock);

		// timer
		format = new SimpleDateFormat("HH:mm:ss");
		setTime();
		Timer t = new Timer();
		t.schedule(new TimerLabelTask(), 0, 1000);

		//property
		this.setCurrentBackgroundColor();
		this.setCurrentClockColor();
		this.setCurrentClockFont();
		this.matchWindow();
		
		this.setVisible(true);

	}

	public void setTime() {
		Calendar calendar = Calendar.getInstance(Locale.JAPAN);
		clockTime = format.format(calendar.getTime());
		clock.setText(clockTime);
	}

	class TimerLabelTask extends TimerTask {
		public void run() {
			setTime();
			//repaint();
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

	@Override
	public void setCurrentClockColor() {
		clock.setForeground(p.getClockColor());	
	}

	@Override
	public void setCurrentClockFont() {
		clock.setFont(p.getFont());
	}

	@Override
	public void setCurrentBackgroundColor() {
		mainPanel.setBackground(p.getBackColor());
	}

	@Override
	public void matchWindow() {
		int x = p.getFontSize() * 4;
		int y = p.getFontSize() + 50;
		Dimension d = this.getSize();
		if (x < d.width) {
			x = d.width;
		}
		if (y < d.height) {
			y = d.height;
		}
		this.setSize(x, y);
		mainPanel.setPreferredSize(new Dimension(x + 20, y + 20));
	}

	@Override
	public void matchWindow(int x, int y) {
		this.setSize(x, y);
		mainPanel.setPreferredSize(new Dimension(x + 20, y + 20));
	}
}
