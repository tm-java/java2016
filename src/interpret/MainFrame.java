package interpret;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * interpretのメインフレーム。このメイン関数を起動するとアプリが動きます。
 * Mediatorパターンを採用して、オブジェクトの操作と、ビューを分離している。
 * 各フレームは、このMainFrameを通して、Objectsクラスのメソッドを実行している。
 * @author matsuitomomi
 *
 */
public class MainFrame extends JFrame implements InterpretMediator {
	/**
	 * ユーザが作成するオブジェクトを格納する
	 */
	private Objects userObj = new Objects();
	/**
	 * メインフレームに載せるメインパネル
	 */
	private MainPanel mp;
	
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
	}

	public MainFrame() {
		this.setName("interpret");
		this.setBounds(0, 0, 1250, 520);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JMenuBar mb = initMenuBar();
		//メインパネルに自クラスを設定
		mp = new MainPanel(this);
		this.add(mp);
		this.setJMenuBar(mb);
		this.setVisible(true);
	}

	/**
	 * メニュバーを設定する
	 * Classを選択すると、SearchFrameを起動する
	 * Arrayを選択すると、SearchFrameArrayを起動する
	 * 
	 * @return　初期設定が終了したJMenuBar
	 */
	private JMenuBar initMenuBar() {
		JMenuBar mb = new JMenuBar();
		JMenu menu = mb.add(new JMenu("menu"));
		JMenu create = new JMenu("new");
		
		//Classを作成するメニュー
		JMenuItem classItem = new JMenuItem("Class");
		classItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//作成したいクラスを検索するSearchFrameを起動
				//コンストラクタにMainFrameオブジェクトを指定
				SearchFrame sf = new SearchFrame(MainFrame.this);
				sf.setVisible(true);
			}
		});
		//Arrayを作成するメニュー
		JMenuItem arrayItem = new JMenuItem("Array");
		arrayItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//作成したいクラスと、配列の長さを指定するSearchFrameArrayを起動
				//コンストラクタにMainFrameオブジェクトを指定
				SearchFrameArray sfa = new SearchFrameArray(MainFrame.this);
				sfa.setVisible(true);
			}
		});
		create.add(classItem);
		create.add(arrayItem);
		menu.add(create);
		return mb;
	}

	@Override
	public Object[] objests() {
		//Objectsクラスのobjectsメソッドを実行
		return userObj.objects();
	}

	@Override
	public Object[] arrays() {
		//Objectsクラスのarraysメソッドを実行
		return userObj.arrays();
	}

	@Override
	public Object newObject(Constructor c, Object... args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//ObjectsクラスのnewObjectメソッドを実行
		Object newObj = userObj.newObject(c, (Object[]) args);
		//作成したオブジェクトをオブジェクト一覧に追加
		mp.objModel.addElement(newObj);
		return newObj;
	}

	@Override
	public Object newArray(Class<?> componentType, int length)
			throws IllegalArgumentException, NegativeArraySizeException {
		//ObjectsクラスのnewArrayメソッドを実行
		Object newAry = userObj.newArray(componentType, length);
		//作成したオブジェクトをオブジェクト一覧に追加
		mp.objModel.addElement(newAry);
		//配列のアコーディオンは閉じておく設定
		mp.arraySelectedMap.put(newAry, false);
		return newAry;
	}

	@Override
	public Vector matchObjects(java.lang.reflect.Type type) {
		//ObjectsクラスのmachObjectsメソッドを実行
		return userObj.matchObjects(type);
	}

	@Override
	public Object parsePrimitive(Class<?> cls, String in) {
		//ObjectsクラスのparsePrimitiveメソッドを実行
		return userObj.parsePrimitive(cls, in);
	}

}
