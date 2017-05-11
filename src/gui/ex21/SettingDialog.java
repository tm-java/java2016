package gui.ex21;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map.Entry;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
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
			sp[i].setPreferredSize(new Dimension(50, 50));
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
		for (int i = 0; i < p.getClockColorLength(); i++) {
			model[2].addElement(p.getClockColorName(i));
		}
		// 背景色
		for (int i = 0; i < p.getBackColorLength(); i++) {
			model[3].addElement(p.getBackColorName(i));
		}
		
		//パネル
		JPanel[] panel = new JPanel[settingName.length];
		for (int i = 0 ; i < settingName.length ; i++) {
			panel[i] = new JPanel();
			panel[i].setLayout(new BoxLayout(panel[i], BoxLayout.X_AXIS));
			panel[i].add(labels[i]);
			panel[i].add(sp[i]);
			this.add(panel[i]);
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
		this.add(okBtn);

		// キャンセルボタン
		JButton cancelBtn = new JButton("cancel");
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 何もせず
				SettingDialog.this.setVisible(false);
			}
		});
		this.add(cancelBtn);

		// バツボタン
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
}
