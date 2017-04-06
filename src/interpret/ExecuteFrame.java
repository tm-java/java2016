package interpret;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExecuteFrame extends JFrame {
	private java.lang.reflect.Type[] parameters;
	private InterpretMediator im;

	public ExecuteFrame(InterpretMediator im, Constructor con) {
		this.im = im;
		parameters = con.getGenericParameterTypes();
		OkAction action = new OkAction() {
			@Override
			public void okActionPerformed(Object[] args) {
				try {
					im.newObject(con, (Object[]) args);
				} catch (InstantiationException e) {
					ResultFrame rf = new ResultFrame(e.getMessage(), "抽象クラスはインスタンス化できません");
					rf.setVisible(true);
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					ResultFrame rf = new ResultFrame(e.getMessage(), "アクセスできないコンストラクタです");
					rf.setVisible(true);
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					ResultFrame rf = new ResultFrame(e.getMessage(), "引数が代入可能ではありません");
					rf.setVisible(true);
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					ResultFrame rf = new ResultFrame(con.getName(), "throws ", e.getCause().toString());
					rf.setVisible(true);
					e.printStackTrace();
				}
				ExecuteFrame.this.dispose();
			}
		};
		initExecuteFrame(action);
	}
	
	public ExecuteFrame(InterpretMediator im, Object array, int index) {
		this.im = im;
		parameters = new java.lang.reflect.Type[1];
		parameters[0] = array.getClass().getComponentType();
		OkAction action = new OkAction() {
			@Override
			public void okActionPerformed(Object[] args) {
				if (args[0] != null) {
					Array.set(array, index, args[0]);
				}
				
				ExecuteFrame.this.dispose();
				return;
			}
		};
		initExecuteFrame(action);
	}
	
	public ExecuteFrame(InterpretMediator im, Constructor con, Object array, int index) {
		this.im = im;
		parameters = con.getGenericParameterTypes();
		OkAction action = new OkAction() {
			Object value = null;
			@Override
			public void okActionPerformed(Object[] args) {
				try {
					value = con.newInstance(args);
				} catch (InstantiationException e) {
					ResultFrame rf = new ResultFrame(e.getMessage(), "抽象クラスはインスタンス化できません");
					rf.setVisible(true);
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					ResultFrame rf = new ResultFrame(e.getMessage(), "アクセスできないコンストラクタです");
					rf.setVisible(true);
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					ResultFrame rf = new ResultFrame(e.getMessage(), "引数が代入可能ではありません");
					rf.setVisible(true);
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					ResultFrame rf = new ResultFrame(con.getName(), "throws ", e.getCause().toString());
					rf.setVisible(true);
					e.printStackTrace();
				}
				
				if (value != null) {
					Array.set(array, index, value);
				}
				
				ExecuteFrame.this.dispose();
				return;
			}
		};
		initExecuteFrame(action);
	}


	public ExecuteFrame(InterpretMediator im, Object cls, Method mth) {
		this.im = im;

		parameters = mth.getGenericParameterTypes();
		OkAction action = new OkAction() {
			@Override
			public void okActionPerformed(Object[] args) {
				Object rtn = null;
				ResultFrame rf = null;
				try {
					rtn = mth.invoke(cls, args);
					rf = new ResultFrame(mth.getName(), "returns", (rtn == null) ? "null" : rtn.toString());

				} catch (IllegalAccessException e) {
					rf = new ResultFrame(e.getMessage(), "引数へのアクセス権がありません");
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					rf = new ResultFrame(e.getMessage(), "オブジェクトとメソッドがあっていません");
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					rf = new ResultFrame(mth.getName(), "throws ", e.getCause().toString());
					e.printStackTrace();
				}
				rf.setVisible(true);
				ExecuteFrame.this.dispose();
			}
		};
		initExecuteFrame(action);
	}

	public ExecuteFrame(InterpretMediator im, Object cls, Field fld) {
		this.im = im;

		parameters = new java.lang.reflect.Type[1];
		parameters[0] = fld.getType();
		OkAction action = new OkAction() {
			@Override
			public void okActionPerformed(Object[] args) {
				Object rtn = null;
				ResultFrame rf = new ResultFrame("値を更新しました\n","メイン画面の\'Update\'メニューを押して画面の更新をしてください");

				try {
					fld.setAccessible(true);
					fld.set(cls, args[0]);
				} catch (IllegalArgumentException e) {
					rf = new ResultFrame(e.getMessage(), "入力が不正な可能性があります。");
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					rf = new ResultFrame(e.getMessage(), "フィールドのアクセス制御が強制されているため、このフィールドの書き換えはできません\n");
					e.printStackTrace();
				}

				rf.setVisible(true);
				ExecuteFrame.this.dispose();
			}
		};
		initExecuteFrame(action);

	}

	private void initExecuteFrame(OkAction action) {
		this.setName("Execute");
		this.setBounds(0, 0, 400, 100 + 50 * parameters.length);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JPanel jp = new JPanel();
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));

		JComboBox[] box = new JComboBox[parameters.length];
		JLabel[] label = new JLabel[parameters.length];
		for (int i = 0; i < parameters.length; i++) {
			label[i] = new JLabel(parameters[i].getTypeName());
			box[i] = new JComboBox(im.matchObjects(parameters[i]));
			box[i].setEditable(true);
			JPanel panel = new JPanel(new FlowLayout());
			panel.add(label[i]);
			panel.add(box[i]);
			jp.add(panel);
		}

		JButton ok = new JButton("ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] args = new Object[box.length];
				for (int i = 0; i < box.length; i++) {
					if (((Class<?>) parameters[i]).isPrimitive()) {
						args[i] = im.parsePrimitive((Class<?>) parameters[i], (String) box[i].getSelectedItem());
					} else {
						args[i] = box[i].getSelectedItem();
					}
				}
				action.okActionPerformed(args);
			}
		});

		jp.add(ok);
		Container contentPane = this.getContentPane();
		contentPane.add(jp, BorderLayout.CENTER);

	}

	interface OkAction {
		public void okActionPerformed(Object[] args);
	}
}
