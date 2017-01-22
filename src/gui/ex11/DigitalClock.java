package gui.ex11;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class DigitalClock extends Frame{
	private DateFormat format;
	private DateFormat format_;
	private String clockTime = "00:00";
	private String clockTime_ = ":00";
	private Font fontL;
	private Font fontS;
	private Color backColor = new Color(90,65,40,200);
	private Color clockColor = new Color(255,255,240,150);
	private Menu menu;
	
	private Dialog dialog;
	
	public static void main(String[] args){
		new DigitalClock();
	}
	
	public DigitalClock(){
		this.setSize(250,250);
		this.setVisible(true);
		this.addWindowListener(
			new java.awt.event.WindowAdapter(){
				public void windowClosing(java.awt.event.WindowEvent e){
				System.exit(0);
			}
		});
		
		//timer
		format = new SimpleDateFormat("HH:mm");
		format_ = new SimpleDateFormat(":ss");
		Timer t = new Timer();
		t.schedule(new TimerLabelTask(), 0,1000);
		
		//font
		fontL = new Font("Copperplate Light", Font.PLAIN, 30);
		fontS = new Font("Copperplate Light", Font.PLAIN, 15);
	}
	
	public void setTime(){
		Calendar calendar = Calendar.getInstance(Locale.JAPAN);
		clockTime = format.format(calendar.getTime());
		clockTime_ = format_.format(calendar.getTime());
	}
	
	class TimerLabelTask extends TimerTask{
		public void run(){
			setTime();
			repaint();
		}
	}
	
	
	public void paint(Graphics g){
		//描画する内容をかく
		g.setColor(backColor);
		g.fillRect(0, 0, getWidth(), getWidth());
		g.setColor(clockColor);
		g.setFont(fontL);
		g.drawString(clockTime, 50, 140);
		g.setFont(fontS);
		g.drawString(clockTime_, 140, 140);
	
	}


}
