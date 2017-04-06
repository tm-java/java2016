package interpret;

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
	private JList objList;
	DefaultListModel objModel;
	private JList mthList;
	DefaultListModel mthModel = new DefaultListModel();
	private JList fldList;
	DefaultListModel fldModel = new DefaultListModel();
	private InterpretMediator im;
	private Object selectedCls;
	/**
	 * 配列の時、その配列が選択されたかされていないか確認するためのMap
	 * objListに配列を追加する時は、必ずこのマップにもfalseで追加してください。 false : 選択されていない true :
	 * 選択されている
	 */
	Map<Object, Boolean> arraySelectedMap = new HashMap<Object, Boolean>();
	private JPopupMenu pm;

	public MainPanel(InterpretMediator im) {
		this.im = im;
		this.setName("interpret");
		this.setBounds(0, 0, 1050, 520);

		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		objModel = new DefaultListModel();
		objList = new JList(objModel);
		objList.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					selectedCls = objList.getSelectedValue();
					if (selectedCls != null) {
						upDateMainPanel(selectedCls);
					}
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
				// 右クリックでポップアップメニュー表示
				if (btn == MouseEvent.BUTTON3) {
					Object selected = objList.getSelectedValue();
					if (selected.getClass().isArray()) {
						if (pm != null) {
							MainPanel.this.remove(pm);
						}
						pm = makeJPopupMenu(selected);
						MainPanel.this.add(pm);
						pm.show((Component)e.getSource(), e.getX(), e.getY());
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

		mthList = new JList(mthModel);
		mthList.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
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

		fldList = new JList(fldModel);
		fldList.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
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

	public void upDateMainPanel(Object obj) {
		Class<?> cls = obj.getClass();

		mthModel.clear();
		for (Method m : cls.getMethods()) {
			mthModel.addElement(m);
		}
		fldModel.clear();
		for (Field f : cls.getDeclaredFields()) {
			try {
				f.setAccessible(true);
				fldModel.addElement(new AbstractMap.SimpleEntry(f, f.get(obj)));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

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
	
	public JPopupMenu makeJPopupMenu(Object ary){
		JPopupMenu pm = new JPopupMenu();
		JMenu arrayMenu = new JMenu("setElemet");
		for (int i = 0; i < Array.getLength(ary); i++) {
			
			JMenuItem arrayItem = new JMenuItem("[" + i + "]");
			arrayItem.addActionListener(new ActionListener() {
				private int index;
				@Override
				public void actionPerformed(ActionEvent e) {
					ExecuteFrame ef = new ExecuteFrame(im, ary, index);
					ef.setVisible(true);
				}
				public ActionListener setIndex(int i) {
					this.index = i;
					return this;
				}
			}.setIndex(i));
			arrayMenu.add(arrayItem);
		}
		pm.add(arrayMenu);
		return pm;
	}

	private void mthListDoubleClicked(Object cls, Object mth) {
		ExecuteFrame ef = new ExecuteFrame(im, cls, (Method) mth);
		ef.setVisible(true);
	}

	private void fldListDoubleClicked(Object cls, Object fld) {
		ExecuteFrame ef = new ExecuteFrame(im, cls, (Field) fld);
		ef.setVisible(true);
	}

	public Object selectedObject() {
		return selectedCls;
	}

}
