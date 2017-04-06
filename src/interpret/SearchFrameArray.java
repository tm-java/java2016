package interpret;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SearchFrameArray extends JFrame {
	private SearchPanel schp = new SearchPanel();
	private Object ary; 
	InterpretMediator im;

	public SearchFrameArray(InterpretMediator im) {
		this.im = im;
		this.setName("Search for Class");
		this.setBounds(0, 0, 400, 100);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(schp);
	}

	/**
	 * 指定されたクラス名からコンストラクタ一覧を返す。
	 * 
	 * @param className
	 *            クラスの完全名
	 * @return コンストラクタオブジェクトの配列
	 * @throws ClassNotFoundException
	 *             指定されたクラス名が検索結果になかった時
	 */
	private Constructor[] getConstructors(String className) throws ClassNotFoundException {
		Class<?> cls = Class.forName(className);
		return cls.getConstructors();
	}

	/**
	 * 引数のクラスを検索して、なければ結果ダイアログを表示する。自身のダイアログを消す。 あれば、コンストラクタ一覧を表示させるパネルに画面遷移する。
	 * 
	 * @param className
	 *            クラスの完全名
	 */
	private void sarchPanelNextActionPerformed(String className, String arraySize) {
		List<String> errorMsg = new LinkedList<String>();

		Class<?> cls = null;
		Constructor[] constructors = null;
		try {
			cls = Class.forName(className);
			constructors = getConstructors(className);
		} catch (ClassNotFoundException e) {
			errorMsg.add("Class cannot be found\n");
		}

		int size = 1;
		try {
			size = Integer.parseInt(arraySize);
		} catch (NumberFormatException e) {
			errorMsg.add("Please input the number\n");
		}
		
		if (cls != null) {
			try {
				ary = im.newArray(cls, size);
			} catch (IllegalArgumentException e) {
				errorMsg.add(e.getMessage());
			} catch (NegativeArraySizeException e) {
				errorMsg.add(e.getMessage());
			}
		}
		
		if (errorMsg.size() > 0) {
			ResultFrame rf = new ResultFrame(errorMsg.toArray(new String[0]));
			rf.setVisible(true);
			this.dispose();
			return;
		}

		SelectPanel sctp = new SelectPanel(cls, constructors, size);
		this.add(sctp);
		this.setSize(sctp.getMaximumSize());
		sctp.setVisible(true);
		schp.setVisible(false);
	}

	/**
	 * 指定されたコンストラクタを実行する実行画面を表示する 自身を削除する。
	 * 
	 * @param selected
	 *            コンストラクタ
	 */
	private void selectPanelOkActionPerformed(Constructor selected, int index) {
		ExecuteFrame ef = new ExecuteFrame(im, selected, ary, index);
		ef.setVisible(true);
	}
	
	private void selectPanelFinishActionPerformed() {
		this.dispose();
	}

	/**
	 * クラス名の完全名の入力を受け付ける画面
	 * 
	 * @author matsuitomomi
	 *
	 */
	private class SearchPanel extends JPanel {
		private SearchPanel() {
			JTextField className = new JTextField(30);
			JTextField arraySize = new JTextField(5);
			JButton next = new JButton("next >>");
			next.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String input = className.getText();
					String size = arraySize.getText();
					sarchPanelNextActionPerformed(input, size);
				}
			});
			this.add(className);
			this.add(arraySize);
			this.add(next);
		}
	}

	/**
	 * 指定されたクラス名から、コンストラクタ一覧を表示する画面
	 * 
	 * @author matsuitomomi TODO複数選択不可
	 */
	private class SelectPanel extends JPanel {
		private SelectPanel(Class<?> cls, Constructor[] cons, int arraySize) {
			
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			for (int index = 0; index < arraySize; index++) {
				JPanel conPanel = new JPanel();
				JLabel message = new JLabel(cls.getCanonicalName() + " [" + index + "] ");
				JComboBox conBox = new JComboBox(cons);
				JButton ok = new JButton("ok");
				ok.addActionListener(new ActionListener() {
					private int index;
					
					public ActionListener setIndex(int i) {
						this.index = i;
						return this;
					}
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Constructor selected = (Constructor) conBox.getSelectedItem();
						if (selected != null) {
							selectPanelOkActionPerformed(selected, index);
						}
					}
				}.setIndex(index));
				conPanel.setLayout(new BoxLayout(conPanel, BoxLayout.X_AXIS));
				conPanel.add(message);
				conPanel.add(conBox);
				conPanel.add(ok);
				this.add(conPanel);
			}
			
			JButton finish = new JButton("finish");
			finish.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					selectPanelFinishActionPerformed();
				}
			});
			this.add(finish);
			this.setMaximumSize(new Dimension(750, 50 + 50 * arraySize));
		}
	}

}
