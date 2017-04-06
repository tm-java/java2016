package interpret;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

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

public class SearchFrame extends JFrame {
	private SearchPanel schp = new SearchPanel();
	InterpretMediator im;
	public SearchFrame(InterpretMediator im){
		this.im = im;
		this.setName("Search for Class");
		this.setBounds(0, 0, 400, 100);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(schp);
	}
	
	/**
	 * 指定されたクラス名からコンストラクタ一覧を返す。
	 * @param className クラスの完全名
	 * @return コンストラクタオブジェクトの配列
	 * @throws ClassNotFoundException 指定されたクラス名が検索結果になかった時
	 */
	private Constructor[] getConstructors(String className) throws ClassNotFoundException {
		Class<?> cls = Class.forName(className);
		return cls.getConstructors();
	}
	
	/**
	 * 引数のクラスを検索して、なければ結果ダイアログを表示する。自身のダイアログを消す。
	 * あれば、コンストラクタ一覧を表示させるパネルに画面遷移する。
	 * @param className　クラスの完全名
	 */
	private void sarchPanelNextActionPerformed(String className) {
		Constructor[] constructors = null;
		try {
			constructors = getConstructors(className);
		} catch (ClassNotFoundException e) {
			ResultFrame rf = new ResultFrame("Class cannot be found");
			rf.setVisible(true);
			this.dispose();
		}
		
		SelectPanel sctp = new SelectPanel(className, constructors);
		this.add(sctp);
		this.setSize(sctp.getMaximumSize());
		sctp.setVisible(true);
		schp.setVisible(false);
	}
	
	/**
	 * 指定されたコンストラクタを実行する実行画面を表示する
	 * 自身を削除する。
	 * @param selected コンストラクタ
	 */
	private void selectPanelOkActionPerformed(Constructor selected) {
		ExecuteFrame ef = new ExecuteFrame(im, selected);
		ef.setVisible(true);
		this.dispose();
	}
	
	/**
	 * クラス名の完全名の入力を受け付ける画面
	 * @author matsuitomomi
	 *
	 */
	private class SearchPanel extends JPanel {
		private SearchPanel() {
			JTextField className = new JTextField(30);
			JButton next = new JButton("next >>");
			next.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String input = className.getText();
					sarchPanelNextActionPerformed(input);
				}
			});
			this.add(className);
			this.add(next);
		}
	}
	
	/**
	 * 指定されたクラス名から、コンストラクタ一覧を表示する画面
	 * @author matsuitomomi
	 * TODO複数選択不可
	 */
	private class SelectPanel extends JPanel {
		private SelectPanel(String className, Constructor[] cons) {
			JLabel message = new JLabel(className);
			JList conList = new JList(cons);
			conList.addListSelectionListener(new ListSelectionListener(){
				@Override
				public void valueChanged(ListSelectionEvent e) {
				}
			});
			JScrollPane conSp = new JScrollPane();
			conSp.getViewport().setView(conList);
			conSp.setPreferredSize(new Dimension(400, 300));

			JButton ok = new JButton("ok");
			ok.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Constructor selected = (Constructor)conList.getSelectedValue();
					if (selected != null) {
						selectPanelOkActionPerformed(selected);
					}
				}
			});
			
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.add(message);
			this.add(conSp);
			this.add(ok);
			this.setMaximumSize(new Dimension(400,450));

		}
	}


}
