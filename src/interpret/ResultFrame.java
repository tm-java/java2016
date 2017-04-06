package interpret;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultFrame extends JFrame{
	public ResultFrame(String... msgs) {
		this.setName("Result");
		this.setBounds(0, 0, 400, 50 + 50 * msgs.length);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel jp = new JPanel();
		
		JLabel[] results = new JLabel[msgs.length];
		for(String msg : msgs) {
			jp.add(new JLabel(msg));
		}
		
		JButton ok = new JButton("ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultFrame.this.dispose();
			}
		});
		
		jp.add(ok);
		
		Container contentPane = this.getContentPane();
		contentPane.add(jp, BorderLayout.CENTER);
	}

}
