package gui.ex12;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;


public class DegitalClock extends Frame implements ActionListener {
	private Properties p;
	private DateFormat format;
	private String clockTime = "00:00:00";
	private Menu menu;
	
	private Dialog settingDialog;
	
	Graphics gBuf;
	Image imgBuf;
	
	public static void main(String[] args){
		new DegitalClock();
	}
	
	public DegitalClock(){
		p = Properties.getInstance();
		
		this.setSize(p.getFontSize()*10,p.getFontSize()*3);
		this.setVisible(true);
		this.addWindowListener(
			new java.awt.event.WindowAdapter(){
				public void windowClosing(java.awt.event.WindowEvent e){
				System.exit(0);
			}
		});
		
		//ダブルバッファリング
		imgBuf = createImage(p.getFontSize()*10,p.getFontSize()*3);
		gBuf = imgBuf.getGraphics();
		
		//menu bar
		MenuBar mb = new MenuBar();
		menu = mb.add(new Menu("Menu"));
		menu.add(new MenuItem("settings"));
		menu.addActionListener(this);
		this.setMenuBar(mb);
		
		//dialog
		settingDialog = new SettingDialog(this);
		settingDialog.setVisible(false);//後でfalseにする
		
		
		//timer
		format = new SimpleDateFormat("HH:mm:ss");
		Timer t = new Timer();
		t.schedule(new TimerLabelTask(), 0,1000);
		
		
				
	}
	
	public void setTime(){
		Calendar calendar = Calendar.getInstance(Locale.JAPAN);
		clockTime = format.format(calendar.getTime());
	}
	
	class TimerLabelTask extends TimerTask{
		public void run(){
			//ダブルバッファリング
			drawBackImage(gBuf);
			
			setTime();
			repaint();
		}
	}
	
	private void drawBackImage(Graphics g){
		this.setSize(p.getFontSize()*10,p.getFontSize()*3);
		g.setColor(p.getBackColor());
		g.fillRect(0, 0,this.getWidth()*2,this.getHeight()*2);
		//System.out.println(p.getFontSize()*10+" "+this.getWidth());
		g.setColor(p.getClockColor());
		g.setFont(p.getFont());
		g.drawString(clockTime, getWidth()/4,getHeight()/2+20);
	}

	
	
	public void update(Graphics g){
		paint(g);
	}
	
	
	public void paint(Graphics g){
		//描画する内容をかく
		/*this.setSize(p.getFontSize()*10,p.getFontSize()*3);
		g.setColor(p.getBackColor());
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(p.getClockColor());
		g.setFont(p.getFont());
		g.drawString(clockTime, getWidth()/4,getHeight()/2+20);
		*/
		g.drawImage(imgBuf, 0, 0, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="settings"){
			settingDialog.setVisible(true);
		}
		
	}

}
