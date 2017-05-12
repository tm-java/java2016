package interpret;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainPanel extends JPanel {
	/**
	 * オブジェクト一覧を表示するリスト
	 */
	private JList objList;
	/**
	 * 作成したオブジェクトを格納しているモデル
	 */
	DefaultListModel objModel;
	/**
	 * ユーザのダブルクリックで選択したオブジェクトに関連したメソッド一覧を表示するリスト
	 */
	private JList mthList;
	/**
	 * mthListに表示するメソッド一覧を格納しているモデル
	 */
	DefaultListModel mthModel = new DefaultListModel();
	/**
	 * ユーザのダブルクリックで選択したオブジェクトに関連したフィールド一覧を表示するリスト
	 */
	private JList fldList;
	/**
	 * fldListに表示するフィールド一覧を格納しているモデル
	 */
	DefaultListModel fldModel = new DefaultListModel();
	/**
	 * Objects操作を行うためのインターフェース
	 */
	private InterpretMediator im;
	/**
	 * ユーザのクリック操作で選択されたオブジェクトを格納する
	 */
	private Object selectedCls;
	/**
	 * 配列の時、その配列が選択されたかされていないか確認するためのMap。
	 * objListに配列を追加する時は、必ずこのマップにもfalseで追加してください。<br>
	 *  false : 選択されていない <br> 
	 *  true : 選択されている <br>
	 */
	Map<Object, Boolean> arraySelectedMap = new HashMap<Object, Boolean>();
	/**
	 * 配列要素を操作するためのポップアップメニュー
	 */
	private JPopupMenu pm;

	public MainPanel(InterpretMediator im) {
		this.im = im;
		this.setName("interpret");
		this.setBounds(0, 0, 1050, 520);

		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		//オブジェクト一覧
		objModel = new DefaultListModel();
		objList = new JList(objModel);
		//リストの表示方法を指定
		objList.setCellRenderer(new ObjListRenderer());
		objList.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//ダブルクリックでそのオブジェクトに関するメソッド一覧とフィールド一覧を表示させる
				if (e.getClickCount() == 2) {
					selectedCls = objList.getSelectedValue();
					if (selectedCls != null) {
						upDateMainPanel(selectedCls);
					}
				//クリック一回の時は、それが配列オブジェクトの時のみ、アコーディオンエフェクトを行う	
				} else if (e.getClickCount() == 1) {
					selectedCls = objList.getSelectedValue();
					if (selectedCls != null) {
						if (selectedCls.getClass().isArray()) {
							arrayClicked(selectedCls, objList.getSelectedIndex());
						}
					}
					selectedCls = null;
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				int btn = e.getButton();
				// 右クリックで、それが配列オブジェクトの時のみ、ポップアップメニュー表示
				if (btn == MouseEvent.BUTTON3) {
					Object selected = objList.getSelectedValue();
					if (selected != null && selected.getClass().isArray()) {
						if (pm != null) {
							MainPanel.this.remove(pm);
						}
						pm = makeJPopupMenu(selected);
						MainPanel.this.add(pm);
						pm.show((Component) e.getSource(), e.getX(), e.getY());
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});
		JScrollPane objSp = new JScrollPane();
		objSp.getViewport().setView(objList);
		objSp.setPreferredSize(new Dimension(300, 420));
		JLabel objLabel = new JLabel("Object (ダブルクリックで詳細.配列は左クリックで要素一覧表示.右クリックで要素を変更.)");
		JPanel objPanel = new JPanel();
		objPanel.setLayout(new BoxLayout(objPanel, BoxLayout.Y_AXIS));
		objPanel.add(objLabel);
		objPanel.add(objSp);

		//メソッド一覧
		mthList = new JList(mthModel);
		mthList.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//ダブルクリックで、そのメソッドを実行させるフレームを表示する
				if (e.getClickCount() == 2) {
					Object selectedMethod = mthList.getSelectedValue();
					if (selectedMethod != null) {
						mthListDoubleClicked(selectedCls, selectedMethod);
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
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
		JScrollPane mthSp = new JScrollPane();
		mthSp.getViewport().setView(mthList);
		mthSp.setPreferredSize(new Dimension(400, 200));
		JLabel mthLabel = new JLabel("Method (ダブルクリックでメソッドの実行.)");
		JPanel mthPanel = new JPanel();
		mthPanel.setLayout(new BoxLayout(mthPanel, BoxLayout.Y_AXIS));
		mthPanel.add(mthLabel);
		mthPanel.add(mthSp);

		//フィールド一覧
		fldList = new JList(fldModel);
		fldList.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//ダブルクリックでそのフィールドを操作するためのフレームを表示する
				if (e.getClickCount() == 2) {
					SimpleEntry selectedFieldEntry = (SimpleEntry) fldList.getSelectedValue();
					if (selectedFieldEntry != null) {
						fldListDoubleClicked(selectedCls, selectedFieldEntry.getKey());
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
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

		JScrollPane fldSp = new JScrollPane();
		fldSp.getViewport().setView(fldList);
		fldSp.setPreferredSize(new Dimension(400, 200));
		JLabel fldLabel = new JLabel("Field (ダブルクリックでフィールドの変更.)");
		JPanel fldPanel = new JPanel();
		fldPanel.setLayout(new BoxLayout(fldPanel, BoxLayout.Y_AXIS));
		fldPanel.add(fldLabel);
		fldPanel.add(fldSp);

		//レイアウト
		layout.putConstraint(SpringLayout.NORTH, objPanel, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, objPanel, 20, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, mthPanel, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, mthPanel, 40, SpringLayout.EAST, objPanel);
		layout.putConstraint(SpringLayout.WEST, fldPanel, 40, SpringLayout.EAST, objPanel);
		layout.putConstraint(SpringLayout.NORTH, fldPanel, 0, SpringLayout.SOUTH, mthPanel);

		this.add(objPanel);
		this.add(mthPanel);
		this.add(fldPanel);
	}

	/**
	 * 指定されたオブジェクトに関して、メソッド一覧とフィールド一覧を表示させるようメインパネルを更新する。
	 * @param obj メソッド一覧やフィールド一覧を表示させたいオブジェクト
	 */
	public void upDateMainPanel(Object obj) {
		Class<?> cls = obj.getClass();

		//メソッド一覧の更新
		mthModel.clear();
		for (Method m : cls.getMethods()) {
			mthModel.addElement(m);
		}
		//フィールド一覧の更新
		fldModel.clear();
		for (Field f : cls.getDeclaredFields()) {
			try {
				//finalフィールドのアクセスを可能にする
				f.setAccessible(true);
				fldModel.addElement(new AbstractMap.SimpleEntry(f, f.get(obj)));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 指定された配列オブジェクトのアコーディオン操作を行う
	 * arraySelectMapに配列オブジェクトのアコーディオン開閉状態が格納されているので、それを見て判断を行う
	 * @param ary 配列オブジェクト
	 * @param index オブジェクト一覧中にあるaryのインデックス
	 */
	public void arrayClicked(Object ary, int index) {
		// trueならば、アコーディオンをしまう
		if (arraySelectedMap.get(ary)) {
			objModel.removeRange(index + 1, index + Array.getLength(ary));
			arraySelectedMap.put(ary, false);
		} else {
			// falseならば、アコーディオンを開く
			for (int i = 0; i < Array.getLength(ary); i++) {
				objModel.add(index + 1 + i, Array.get(ary, i));
			}
			arraySelectedMap.put(ary, true);
		}
	}

	/**
	 * 配列の要素を操作するポップアップメニューを作成する
	 * @param ary 配列オブジェクト
	 * @return 設定済みのJPopupMenu
	 */
	public JPopupMenu makeJPopupMenu(Object ary) {
		JPopupMenu pm = new JPopupMenu();
		JMenu arrayMenu = new JMenu("setElemet");
		//配列の要素数分、JMenuIconを用意
		for (int i = 0; i < Array.getLength(ary); i++) {

			JMenuItem arrayItem = new JMenuItem("[" + i + "]");
			arrayItem.addActionListener(new ActionListener() {
				private int index;

				@Override
				public void actionPerformed(ActionEvent e) {
					//ary[i]を変更するための実行フレームの表示
					ExecuteFrame ef = new ExecuteFrame(im, ary, index);
					ef.setVisible(true);
				}
				/**
				 * for文の変数を内部クラスにセットするためのメソッド
				 */
				public ActionListener setIndex(int i) {
					this.index = i;
					return this;
				}
			}.setIndex(i));//for文のiをセット
			arrayMenu.add(arrayItem);
		}
		pm.add(arrayMenu);
		return pm;
	}

	/**
	 * 指定されたメソッドを実行するための実行フレームを表示する
	 * @param cls 実行したいメソッドを持つオブジェクト
	 * @param mth 実行したいメソッド
	 */
	private void mthListDoubleClicked(Object cls, Object mth) {
		ExecuteFrame ef = new ExecuteFrame(im, cls, (Method) mth);
		ef.setVisible(true);
	}

	/**
	 * 指定されたフィールドを操作するための実行フレームを表示する
	 * @param cls 実行したいメソッドを持つオブジェクト
	 * @param fld 実行したいフィールド
	 */
	private void fldListDoubleClicked(Object cls, Object fld) {
		ExecuteFrame ef = new ExecuteFrame(im, cls, (Field) fld);
		ef.setVisible(true);
	}

	/**
	 * ユーザが選択中のオブジェクトを返す
	 * @return 選択中のオブジェクト
	 */
	public Object selectedObject() {
		return selectedCls;
	}

	/**
	 * オブジェクト一覧の
	 * @author matsuitomomi
	 *
	 */
	private class ObjListRenderer extends JLabel implements ListCellRenderer {
		ObjListRenderer() {
			super();
			setOpaque(true);
		}

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			if (value == null) {
				setText("null");
			} else if (value.getClass().isArray()) {
				setText(value.getClass().getComponentType().getName() + "[]");
			} else {
				setText(value.toString());
			}
			
			setBackground(isSelected ? Color.BLUE : Color.WHITE);
			setForeground(isSelected ? Color.WHITE : Color.BLACK);
			return this;
		}
	}

}
