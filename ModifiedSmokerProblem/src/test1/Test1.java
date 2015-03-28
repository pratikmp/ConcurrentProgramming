package test1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test1 frame = new Test1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Test1.class.getResource("/images/matches.jpg")));
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Test1.class.getResource("/images/paper.jpg")));
		panel.add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Test1.class.getResource("/images/tobacco.jpg")));
		panel.add(label_2);
		
		JButton btnStart = new JButton("start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Smokers s = new Smokers();
				
				for (int i = 0; i <= 6; i++) {
					s.startThreadOneGet();
					s.startThreadTwoGet();
					s.startThreadThreeGet();
				}
				for (int i = 0; i <= 6; i++) {
					s.startThreadOneRelease();
					s.startThreadTwoRelease();
					s.startThreadThreeRelease();
				}
			}
		});
		panel.add(btnStart);
		
		JButton btnStop = new JButton("stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				System.exit(0);
			}
		});
		panel.add(btnStop);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JLabel lblTabacco = new JLabel("matches?");
		lblTabacco.setIcon(new ImageIcon(Test1.class.getResource("/images/smokers.jpg")));
		panel_1.add(lblTabacco);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		
		JLabel lblMatches = new JLabel("tobacco?");
		lblMatches.setIcon(new ImageIcon(Test1.class.getResource("/images/smokers.jpg")));
		panel_2.add(lblMatches);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JLabel lblPaper = new JLabel("paper?");
		lblPaper.setIcon(new ImageIcon(Test1.class.getResource("/images/smokers.jpg")));
		panel_3.add(lblPaper);
	}

}
