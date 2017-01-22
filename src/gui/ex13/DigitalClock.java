package gui.ex13;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Menu;
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
import java.util.Map.Entry;


public class DigitalClock extends Window{
	//各種設定
	private Properties p;
	//ポップアップメニュー
	private PopupMenu pm;
	//private int size;//フォントサイズ
	
	//ダブルバッファリング用
	private Graphics gBuf;
	private Image imgBuf;
	
	//クリックした座標 ドラッグでウィンドウ移動させる用
	private int pointX;
	private int pointY;
	
	//時間
	private DateFormat format;
	private String clockTime = "00:00:00";
	
	//main
	public static void main(String[] args){
		new DigitalClock(new Frame());
	}

	DigitalClock(Frame parent) throws HeadlessException {
		super(parent);
		p = Properties.getInstance();
		this.setSize(p.getFontSize()*10,p.getFontSize()*3);
		this.setBackground(p.getBackColor());
		
		//ダブルバッファリング
		
		
		
		//ポップアップメニュー
		pm = new PopupMenu();		
		//メニューフォントサイズ
		Menu clockSize = new Menu("Clock Size");
		for(int size: p.sizeList){
			MenuItem mi = new MenuItem(Integer.toString(size));
			//選択されたサイズに変更
			mi.addActionListener(
					new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							p.setFontSize(size);
							repaint();
						}
					});
			clockSize.add(mi);
		}
		pm.add(clockSize);
		//メニューフォント名
		Menu clockFont = new Menu("Clock Font");
		for(Font f: p.fontList){
			MenuItem mi = new MenuItem(f.getFontName());
			//選択されたフォントに変更
			mi.addActionListener(
					new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							p.setFont(f);
							repaint();
						}
					});
			clockFont.add(mi);
		}
		pm.add(clockFont);
		//メニューフォントカラー
		Menu clockColor = new Menu("Clock Color");
		for(Entry<String, Color> entry : Properties.colorMap.entrySet()){
			MenuItem mi = new MenuItem(entry.getKey());
			//選択された色に変更
			mi.addActionListener(
					new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							p.setClockColor(entry.getValue());
							repaint();
						}
			});
			clockColor.add(mi);
		}
		pm.add(clockColor);
		//メニュー背景色後でメソッドにして可読性あげる
		Menu backColor = new Menu("Backgraound Color");
		for(Entry<String, Color> entry : Properties.colorMap.entrySet()){
			MenuItem mi = new MenuItem(entry.getKey());
			//選択された色に変更
			mi.addActionListener(
					new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							p.setBackColor(entry.getValue());
							repaint();
						}
			});
			backColor.add(mi);
		}
		pm.add(backColor);
		//メニューExit (システムを終了させる)
				MenuItem exit = new MenuItem("Exit");
				exit.addActionListener(
						new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent e){
								System.exit(0);
							}
						});
		pm.add(exit);
		this.add(pm);
		
		
		//マウスクリック
		this.addMouseListener(
				new MouseListener(){
					@Override
					public void mouseClicked(MouseEvent e) {}

					@Override
					public void mousePressed(MouseEvent e) {
						//ウィンドウを移動させるための始点
						pointX = e.getXOnScreen();
						pointY = e.getYOnScreen();
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						int btn = e.getButton();
						//右クリックでポップアップメニュー表示
						if(btn == MouseEvent.BUTTON3){
							pm.show((Component)e.getSource(), e.getX(), e.getY());
						}
					}

					@Override
					public void mouseEntered(MouseEvent e) {}

					@Override
					public void mouseExited(MouseEvent e) {}
 
				});
		
		this.addMouseMotionListener(
				new MouseMotionListener(){
					@Override
					public void mouseDragged(MouseEvent e) {
						//ウィンドウの移動を行う
						int getX = e.getXOnScreen();	int getY = e.getYOnScreen();//現在の座標
						int dx = getX - pointX;	int dy = getY - pointY;	//前の座標との差分をとって、どの程度移動したか計算
						//System.out.println("Xloc="+DigitalClock2.this.getLocation().x+" Yloc="+DigitalClock2.this.getLocation().y);
						//System.out.println("x="+getX+" pointX="+pointX+" y="+getY+" pointY="+pointY);
						
						pointX = getX;	pointY = getY; //座標を更新
						DigitalClock.this.setLocation(dx + DigitalClock.this.getLocation().x, dy + DigitalClock.this.getLocation().y);
						repaint();
					}

					@Override
					public void mouseMoved(MouseEvent e) {}
				});
		
		//timer
		format = new SimpleDateFormat("HH:mm:ss");
		setTime();
		Timer t = new Timer();
		t.schedule(new TimerLabelTask(), 0,1000);
		
		
		
		this.setVisible(true);
		
		
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	
	public void paint(Graphics g){
		//ダブルバッファリング
		imgBuf = createImage(p.getFontSize()*10,p.getFontSize()*3);
		gBuf = imgBuf.getGraphics();
		
		gBuf.setColor(p.getBackColor());
		gBuf.fillRect(0, 0,p.getFontSize()*10,p.getFontSize()*3);
		//System.out.println(p.getFontSize()*10+" "+this.getWidth());
		gBuf.setColor(p.getClockColor());
		gBuf.setFont(p.getFont());
		gBuf.drawString(clockTime, getWidth()/4,getHeight()/2+20);
		
		
		
		
		this.setSize(p.getFontSize()*10,p.getFontSize()*3);
		g.drawImage(imgBuf, 0, 0, this);
	}

	public void setTime(){
		Calendar calendar = Calendar.getInstance(Locale.JAPAN);
		clockTime = format.format(calendar.getTime());
	}
	
	class TimerLabelTask extends TimerTask{
		public void run(){
			setTime();
			repaint();
		}
	}

	
}
