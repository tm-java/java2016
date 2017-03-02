package gui.ex14;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map.Entry;

public class SettingDialog extends Frame {
	private final Properties p = Properties.getInstance();
	private final String[] settingName = new String[] { "font", "font size", "font color", "background color" };
	private final List[] lists;
	private final int[] selectedIndex;

	public SettingDialog() {
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		this.setSize(400, 500);

		// ラベル
		Label[] labels = new Label[settingName.length];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new Label(settingName[i]);
		}
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx = 20;
		gbc.anchor = GridBagConstraints.EAST;
		for (int i = 0; i < labels.length; i++) {
			layout.addLayoutComponent(labels[i], gbc);
			gbc.gridy++;
			this.add(labels[i]);
		}

		// リスト
		lists = new List[settingName.length];
		selectedIndex = new int[settingName.length];
		for (int i = 0; i < lists.length; i++) {
			lists[i] = new List();
		}
		// フォント
		for (int i = 0; i < p.getFontLength(); i++) {
			lists[0].add(p.getFontName(i));
		}
		lists[0].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		// フォントサイズ
		for (int i = 0; i < p.getFontSizeLength(); i++) {
			lists[1].add(p.getFontSizeName(i));
		}
		lists[1].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		// 文字色
		for (int i = 0; i < p.getClockColorLength(); i++) {
			lists[2].add(p.getClockColorName(i));
		}
		lists[2].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		// 背景色
		for (int i = 0; i < p.getBackColorLength(); i++) {
			lists[3].add(p.getBackColorName(i));
		}
		lists[3].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		for (int i = 0; i < lists.length; i++) {
			layout.addLayoutComponent(lists[i], gbc);
			gbc.gridy++;
			this.add(lists[i]);
		}

		// okボタン
		Button okBtn = new Button("ok");
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < selectedIndex.length; i++) {
					selectedIndex[i] = lists[i].getSelectedIndex();
				}
				if (selectedIndex[0] != -1) {
					p.setFontIndex(selectedIndex[0]);
				}
				if (selectedIndex[1] != -1) {
					p.setFontSizeIndex(selectedIndex[1]);
				}
				if (selectedIndex[2] != -1) {
					p.setClockColorIndex(selectedIndex[2]);
				}
				if (selectedIndex[3] != -1) {
					p.setBackColorIndex(selectedIndex[3]);
				}
				SettingDialog.this.setVisible(false);
			}
		});
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.EAST;
		layout.addLayoutComponent(okBtn, gbc);
		this.add(okBtn);

		// キャンセルボタン
		Button cancelBtn = new Button("cancel");
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 何もせず
				SettingDialog.this.setVisible(false);
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		layout.addLayoutComponent(cancelBtn, gbc);
		this.add(cancelBtn);

		// バツボタン
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				SettingDialog.this.setVisible(false);
			}
		});
	}

	private class GridParts {
		private final Label label;
		private final List list = new List();
		GridBagConstraints gbc = new GridBagConstraints();

		private GridParts(String text, String[] listNames) {
			this.label = new Label(text);
			for (String listName : listNames) {
				this.list.add(listName);
			}
			this.list.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
				}
			});
		}

		private int selectedIndex() {
			return this.list.getSelectedIndex();
		}
	}
}
