package gui.ex24;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.util.Map.Entry;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

import com.sun.scenario.Settings;

public class SettingDialog extends JFrame {
	private final Properties p = Properties.getInstance();
	private final String[] settingName = new String[] { "font", "font size", "font color", "background color" };
	private final JList[] lists;
	private final DefaultListModel[] model;
	private final int[] selectedIndex;
	private final DigitalView dv;

	public SettingDialog(DigitalView dv) {
		this.dv = dv;
		this.setSize(400, 500);
		GridBagLayout layout = new GridBagLayout();
		//this.setLayout(layout);
		
		// ラベル
		JLabel[] labels = new JLabel[settingName.length];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(settingName[i]);
			labels[i].setMaximumSize(new Dimension(50,30));
		}

		// リスト
		lists = new JList[settingName.length];
		model = new DefaultListModel[settingName.length];
		JScrollPane[] sp = new JScrollPane[settingName.length];
		selectedIndex = new int[settingName.length];
		for (int i = 0; i < lists.length; i++) {
			model[i] = new DefaultListModel();
			lists[i] = new JList(model[i]);
			sp[i] = new JScrollPane();
			sp[i].getViewport().setView(lists[i]);
			sp[i].setPreferredSize(new Dimension(200, 100));
		}
		
		// フォント
		for (int i = 0; i < p.getFontLength(); i++) {
			model[0].addElement(p.getFontName(i));
		}
		// フォントサイズ
		for (int i = 0; i < p.getFontSizeLength(); i++) {
			model[1].addElement(p.getFontSizeName(i));
		}
		// 文字色
		lists[2].setCellRenderer(new ColorRenderer());
		for (int i = 0; i < p.getClockColorLength(); i++) {
			String c = p.getClockColorName(i);
			Image im=null;
			URL url=this.getClass().getClassLoader().getResource(c +".png");
			try {
				im=this.createImage((ImageProducer) url.getContent());
			}catch(Exception ex){
				ex.printStackTrace();
			}
			model[2].addElement(new ComboLabel(c, new ImageIcon(im)));
		}
		// 背景色
		lists[3].setCellRenderer(new ColorRenderer());
		for (int i = 0; i < p.getBackColorLength(); i++) {
			String c = p.getBackColorName(i);
			Image im=null;
			URL url=this.getClass().getClassLoader().getResource(c +".png");
			try {
				im=this.createImage((ImageProducer) url.getContent());
			}catch(Exception ex){
				ex.printStackTrace();
			}
			model[3].addElement(new ComboLabel(c, new ImageIcon(im)));
		}
		
		//パネル
		JPanel panel = new JPanel();
		panel.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		for (int i = 0 ; i < settingName.length ; i++) {
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.anchor = GridBagConstraints.EAST;
			layout.setConstraints(labels[i], gbc);
			panel.add(labels[i]);
			gbc.gridx = 1;
			gbc.gridy = i;
			layout.setConstraints(sp[i], gbc);
			panel.add(sp[i]);
		}

		// okボタン
		JButton okBtn = new JButton("ok");
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < selectedIndex.length; i++) {
					selectedIndex[i] = lists[i].getSelectedIndex();
				}
				if (selectedIndex[0] != -1) {
					p.setFontIndex(selectedIndex[0]);
					dv.setCurrentClockFont();
				}
				if (selectedIndex[1] != -1) {
					p.setFontSizeIndex(selectedIndex[1]);
					dv.setCurrentClockFont();
					dv.matchWindow(p.getFontSize() * 4, p.getFontSize() + 50);
				}
				if (selectedIndex[2] != -1) {
					p.setClockColorIndex(selectedIndex[2]);
					dv.setCurrentClockColor();
				}
				if (selectedIndex[3] != -1) {
					p.setBackColorIndex(selectedIndex[3]);
					dv.setCurrentBackgroundColor();
				}
				SettingDialog.this.setVisible(false);
			}
		});
		gbc.gridx = 1;
		gbc.gridy = settingName.length;
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(okBtn, gbc);
		panel.add(okBtn);

		// キャンセルボタン
		JButton cancelBtn = new JButton("cancel");
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 何もせず
				SettingDialog.this.setVisible(false);
			}
		});
		gbc.gridx = 2;
		gbc.gridy = settingName.length;
		gbc.anchor = GridBagConstraints.WEST;
		layout.setConstraints(cancelBtn, gbc);
		panel.add(cancelBtn);

		getContentPane().add(panel, BorderLayout.CENTER);
		// バツボタン
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	
	private class ComboLabel{
		  String text;
		  Icon icon;

		  ComboLabel(String text, Icon icon){
		    this.text = text;
		    this.icon = icon;
		  }

		  public String getText(){
		    return text;
		  }

		  public Icon getIcon(){
		    return icon;
		  }
		}
	
	private class ColorRenderer extends JLabel implements ListCellRenderer {
		ColorRenderer() {
			super();
			setOpaque(true);
		}

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			ComboLabel data = (ComboLabel)value;
		    setText(data.getText());
		    setIcon(data.getIcon());
		    setBackground(isSelected ? Color.BLUE : Color.WHITE);
			setForeground(isSelected ? Color.WHITE : Color.BLACK);
			return this;
		}
	}

}
