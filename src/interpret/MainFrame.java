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

public class MainFrame extends JFrame implements InterpretMediator {
	private Objects userObj = new Objects();
	private MainPanel mp;
	
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
	}

	public MainFrame() {
		this.setName("interpret");
		this.setBounds(0, 0, 1250, 520);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JMenuBar mb = initMenuBar();
		mp = new MainPanel(this);
		this.add(mp);
		this.setJMenuBar(mb);
		this.setVisible(true);
	}

	private JMenuBar initMenuBar() {
		JMenuBar mb = new JMenuBar();
		JMenu menu = mb.add(new JMenu("menu"));
		JMenu create = new JMenu("new");
		JMenuItem classItem = new JMenuItem("Class");
		classItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchFrame sf = new SearchFrame(MainFrame.this);
				sf.setVisible(true);
			}
		});
		JMenuItem arrayItem = new JMenuItem("Array");
		arrayItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
		return userObj.objects();
	}

	@Override
	public Object[] arrays() {
		return userObj.arrays();
	}

	@Override
	public Object newObject(Constructor c, Object... args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object newObj = userObj.newObject(c, (Object[]) args);
		mp.objModel.addElement(newObj);
		return newObj;
	}

	@Override
	public Object newArray(Class<?> componentType, int length)
			throws IllegalArgumentException, NegativeArraySizeException {
		Object newAry = userObj.newArray(componentType, length);
		mp.objModel.addElement(newAry);
		mp.arraySelectedMap.put(newAry, false);
		return newAry;
	}

	@Override
	public Vector matchObjects(java.lang.reflect.Type type) {
		return userObj.matchObjects(type);
	}

	@Override
	public Object parsePrimitive(Class<?> cls, String in) {
		return userObj.parsePrimitive(cls, in);
	}

}
