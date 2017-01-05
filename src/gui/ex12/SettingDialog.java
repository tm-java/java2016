package gui.ex12;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.Vector;

public class SettingDialog extends Dialog implements ActionListener,ItemListener,TextListener{
	
	//private Dialog settingDialog;
	private Properties p = Properties.getInstance();
	
	//フォントプルダウン用
	private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private Font [] fonts = ge.getAllFonts();
	private Vector<String> fontNames = new Vector<String>();
	private Choice ch_font;
	
	//textField
	private TextField tf_fontSize;
	private TextField tf_fontColorR;
	private TextField tf_fontColorG;
	private TextField tf_fontColorB;
	private TextField tf_fontColorA;
	private TextField tf_backgroundColorR;
	private TextField tf_backgroundColorG;
	private TextField tf_backgroundColorB;	
	private TextField tf_backgroundColorA;
	
	//button
	Button btn_ok;
	
	public SettingDialog(Frame parent){
		super(parent);
		setSize(400,400);
		setBackground(Color.WHITE);
		
		//font
		//label
		Label l_font = new Label("font");
		l_font.setBounds(50,50,30,30);
		add(l_font);
		
		//物理フォント名の取得
		for(int i=0;i<fonts.length;i++){
			fontNames.addElement(fonts[i].getName());
		}
		//プルダウンに追加
		ch_font = new Choice();
		for(String fontName: fontNames){
			ch_font.add(fontName);
		}
		ch_font.select(p.getFont().getFontName());
		ch_font.setBounds(100, 50, 200, 30);
		ch_font.addItemListener(this);
		add(ch_font);
		
	
		
		
		//fontSize
		//label
		Label l_fontSize = new Label("font size");
		l_fontSize.setBounds(50,80,60,30);
		add(l_fontSize);
		//textField
		tf_fontSize = new TextField(String.valueOf(p.getFontSize()),4);
		tf_fontSize.setBounds(150, 80, 80, 30);
		tf_fontSize.addTextListener(this);
		add(tf_fontSize);
		
		//fontColor
		Label l_fontColor = new Label("font color");
		l_fontColor.setBounds(50,110,90,30);
		add(l_fontColor);
		
		//R
		Label l_fontColorR = new Label("R");
		l_fontColorR.setBounds(140,110,10,30);
		add(l_fontColorR);
		tf_fontColorR = new TextField(String.valueOf(p.getClockColor().getRed()),3);
		tf_fontColorR.setBounds(150, 110, 40, 30);
		tf_fontColorR.addTextListener(this);
		add(tf_fontColorR);
		
		//G
		Label l_fontColorG = new Label("G");
		l_fontColorG.setBounds(190,110,10,30);
		add(l_fontColorG);
		tf_fontColorG = new TextField(String.valueOf(p.getClockColor().getGreen()),3);
		tf_fontColorG.setBounds(200, 110, 40, 30);
		tf_fontColorG.addTextListener(this);
		add(tf_fontColorG);
		
		//B
		Label l_fontColorB = new Label("B");
		l_fontColorB.setBounds(240,110,10,30);
		add(l_fontColorB);
		tf_fontColorB = new TextField(String.valueOf(p.getBackColor().getBlue()),3);
		tf_fontColorB.setBounds(250, 110, 40, 30);
		tf_fontColorB.addTextListener(this);
		add(tf_fontColorB);
		
		//backgroundColor
		Label l_backgroundColor = new Label("background color");
		l_backgroundColor.setBounds(50,140,150,30);
		add(l_backgroundColor);
		//R
		Label l_backgroundColorR = new Label("R");
		l_backgroundColorR.setBounds(140,170,10,30);
		add(l_backgroundColorR);
		tf_backgroundColorR = new TextField(String.valueOf(p.getBackColor().getRed()),3);
		tf_backgroundColorR.setBounds(150, 170, 40, 30);
		tf_backgroundColorR.addTextListener(this);
		add(tf_backgroundColorR);
		//G
		Label l_backgroundColorG = new Label("G");
		l_backgroundColorG.setBounds(190,170,10,30);
		add(l_backgroundColorG);
		tf_backgroundColorG = new TextField(String.valueOf(p.getBackColor().getGreen()),3);
		tf_backgroundColorG.setBounds(200, 170, 40, 30);
		tf_backgroundColorG.addTextListener(this);
		add(tf_backgroundColorG);
		//B
		Label l_backgroundColorB = new Label("B");
		l_backgroundColorB.setBounds(240,170,10,30);
		add(l_backgroundColorB);
		tf_backgroundColorB = new TextField(String.valueOf(p.getBackColor().getBlue()),3);
		tf_backgroundColorB.setBounds(250, 170, 40, 30);
		tf_backgroundColorB.addTextListener(this);
		add(tf_backgroundColorB);
		
		//ok button
		btn_ok = new Button("ok");
		btn_ok.setBounds(200, 250, 60, 30);
		btn_ok.addActionListener(this);
		add(btn_ok);
		
		
		
		
		addWindowListener(
				new java.awt.event.WindowAdapter(){
					public void windowClosing(java.awt.event.WindowEvent e){
					setVisible(false);
				}
			});
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_ok){
			p.setFontSize(Integer.parseInt(tf_fontSize.getText()));
			p.setFont(new Font(ch_font.getSelectedItem(),Font.PLAIN,p.getFontSize()));
			p.setClockColor(new Color(Integer.parseInt(tf_fontColorR.getText()),Integer.parseInt(tf_fontColorG.getText()),Integer.parseInt(tf_fontColorB.getText())));
			p.setBackColor(new Color(Integer.parseInt(tf_backgroundColorR.getText()),Integer.parseInt(tf_backgroundColorG.getText()),Integer.parseInt(tf_backgroundColorB.getText())));
			setVisible(false);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}

	@Override
	public void textValueChanged(TextEvent e) {
		if(e.getSource()==tf_fontSize){
			if(tf_fontSize.getText().length()==0)tf_fontSize.setText("1");
			if(Integer.parseInt(tf_fontSize.getText())>300)tf_fontSize.setText("300");
		} else if(e.getSource()==tf_fontColorR){
			if(tf_fontColorR.getText().length()==0)tf_fontColorR.setText("0");
			if(Integer.parseInt(tf_fontColorR.getText())>256)tf_fontColorR.setText("255");
		}else if(e.getSource()==tf_fontColorG){
			if(tf_fontColorG.getText().length()==0)tf_fontColorG.setText("0");
			if(Integer.parseInt(tf_fontColorG.getText())>256)tf_fontColorG.setText("255");
		}else if(e.getSource()==tf_fontColorB){
			if(tf_fontColorB.getText().length()==0)tf_fontColorB.setText("0");
			if(Integer.parseInt(tf_fontColorB.getText())>256)tf_fontColorB.setText("255");
		}else if(e.getSource()==tf_backgroundColorR){
			if(tf_backgroundColorR.getText().length()==0)tf_backgroundColorR.setText("0");
			if(Integer.parseInt(tf_backgroundColorR.getText())>256)tf_backgroundColorR.setText("255");
		}else if(e.getSource()==tf_backgroundColorG){
			if(tf_backgroundColorG.getText().length()==0)tf_backgroundColorG.setText("0");
			if(Integer.parseInt(tf_backgroundColorG.getText())>256)tf_backgroundColorG.setText("255");
		}else if(e.getSource()==tf_backgroundColorB){
			if(tf_backgroundColorB.getText().length()==0)tf_backgroundColorB.setText("0");
			if(Integer.parseInt(tf_backgroundColorB.getText())>256)tf_backgroundColorB.setText("255");
		}
		
	}

	

}
