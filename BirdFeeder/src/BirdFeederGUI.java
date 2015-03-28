import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BirdFeederGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblBird;
	public JLabel lblBird_1;
	public JLabel lblBird_2;
	public JLabel lblBird_3;
	public JLabel lblBird_4;
	public JLabel lblBird_5;
	public JLabel label;
	public JLabel label_1;
	public JLabel label_2;
	public JLabel label_3;
	public JLabel label_4;
	public JLabel label_5;
	private JLabel lblDoor;
	private JLabel label_6;
	private JLabel label_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BirdFeederGUI frame = new BirdFeederGUI();
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
	public BirdFeederGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblBird = new JLabel("Bird1");
		lblBird.setIcon(new ImageIcon(BirdFeederGUI.class
				.getResource("/images/bird1.jpg")));
		lblBird.setBounds(46, 97, 60, 64);
		contentPane.add(lblBird);

		lblBird_1 = new JLabel("Bird2");
		lblBird_1.setIcon(new ImageIcon(BirdFeederGUI.class
				.getResource("/images/bird2.jpg")));
		lblBird_1.setBounds(46, 198, 60, 60);
		contentPane.add(lblBird_1);

		lblBird_2 = new JLabel("Bird3");
		lblBird_2.setIcon(new ImageIcon(BirdFeederGUI.class
				.getResource("/images/bird3.jpg")));
		lblBird_2.setBounds(46, 290, 60, 60);
		contentPane.add(lblBird_2);

		lblBird_3 = new JLabel("Bird4");
		lblBird_3.setIcon(new ImageIcon(BirdFeederGUI.class
				.getResource("/images/bird4.jpg")));
		lblBird_3.setBounds(539, 97, 60, 64);
		contentPane.add(lblBird_3);

		lblBird_4 = new JLabel("Bird5");
		lblBird_4.setIcon(new ImageIcon(BirdFeederGUI.class
				.getResource("/images/bird5.jpg")));
		lblBird_4.setBounds(539, 201, 60, 54);
		contentPane.add(lblBird_4);

		lblBird_5 = new JLabel("Bird6");
		lblBird_5.setIcon(new ImageIcon(BirdFeederGUI.class
				.getResource("/images/bird6.jpg")));
		lblBird_5.setBounds(539, 290, 60, 60);
		contentPane.add(lblBird_5);

		label = new JLabel("Bird1");
		label.setIcon(new ImageIcon(BirdFeederGUI.class
				.getResource("/images/bird1.jpg")));
		label.setBounds(227, 183, 60, 64);
		contentPane.add(label);

		label_1 = new JLabel("Bird2");
		label_1.setIcon(new ImageIcon(BirdFeederGUI.class
				.getResource("/images/bird2.jpg")));
		label_1.setBounds(227, 258, 60, 60);
		contentPane.add(label_1);

		label_2 = new JLabel("Bird3");
		label_2.setIcon(new ImageIcon(BirdFeederGUI.class
				.getResource("/images/bird3.jpg")));
		label_2.setBounds(297, 302, 60, 60);
		contentPane.add(label_2);

		label_3 = new JLabel("Bird4");
		label_3.setIcon(new ImageIcon(BirdFeederGUI.class
				.getResource("/images/bird4.jpg")));
		label_3.setBounds(297, 157, 60, 64);
		contentPane.add(label_3);

		label_4 = new JLabel("Bird5");
		label_4.setIcon(new ImageIcon(BirdFeederGUI.class
				.getResource("/images/bird5.jpg")));
		label_4.setBounds(367, 183, 60, 54);
		contentPane.add(label_4);

		label_5 = new JLabel("Bird6");
		label_5.setIcon(new ImageIcon(BirdFeederGUI.class
				.getResource("/images/bird6.jpg")));
		label_5.setBounds(367, 253, 60, 60);
		contentPane.add(label_5);

		label.setVisible(false);
		label_1.setVisible(false);
		label_2.setVisible(false);
		label_3.setVisible(false);
		label_4.setVisible(false);
		label_5.setVisible(false);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				BirdFeeder A = new BirdFeeder("1", BirdFeederGUI.this);
				BirdFeeder B = new BirdFeeder("2", BirdFeederGUI.this);
				BirdFeeder C = new BirdFeeder("3", BirdFeederGUI.this);
				BirdFeeder D = new BirdFeeder("4", BirdFeederGUI.this);
				BirdFeeder E = new BirdFeeder("5", BirdFeederGUI.this);
				BirdFeeder F = new BirdFeeder("6", BirdFeederGUI.this);

				A.start();
				B.start();
				C.start();
				D.start();
				E.start();
				F.start();

			}
		});
		btnStart.setBounds(227, 102, 89, 23);
		contentPane.add(btnStart);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				System.exit(0);

			}
		});
		btnStop.setBounds(326, 102, 89, 23);
		contentPane.add(btnStop);

		JLabel lblBird_6 = new JLabel("Feeding Shed Problem");
		lblBird_6.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblBird_6.setBounds(93, 11, 463, 49);
		contentPane.add(lblBird_6);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(210, 151, 243, 227);
		contentPane.add(panel);

		lblDoor = new JLabel("Door1");
		lblDoor.setIcon(new ImageIcon(BirdFeederGUI.class
				.getResource("/images/door.jpg")));
		lblDoor.setBounds(164, 220, 46, 64);
		contentPane.add(lblDoor);

		label_6 = new JLabel("Door1");
		label_6.setIcon(new ImageIcon(BirdFeederGUI.class
				.getResource("/images/door.jpg")));
		label_6.setBounds(307, 381, 46, 64);
		contentPane.add(label_6);

		label_7 = new JLabel("Door1");
		label_7.setIcon(new ImageIcon(BirdFeederGUI.class
				.getResource("/images/door.jpg")));
		label_7.setBounds(455, 221, 46, 64);
		contentPane.add(label_7);

		lblDoor.setVisible(false);
		label_6.setVisible(false);
		label_7.setVisible(false);

	}

	public void enterBird(String number) {

		switch (number) {
		case "1":
			label.setVisible(true);
			lblBird.setVisible(false);
			break;
		case "2":
			label_1.setVisible(true);
			lblBird_1.setVisible(false);

			break;
		case "3":
			label_2.setVisible(true);
			lblBird_2.setVisible(false);

			break;
		case "4":
			label_3.setVisible(true);
			lblBird_3.setVisible(false);

			break;
		case "5":
			label_4.setVisible(true);
			lblBird_4.setVisible(false);

			break;
		case "6":
			label_5.setVisible(true);
			lblBird_5.setVisible(false);

			break;

		}

	}

	public void leaveBird(String number) {

		switch (number) {
		case "1":
			label.setVisible(false);
			lblBird.setVisible(true);
			break;
		case "2":
			label_1.setVisible(false);
			lblBird_1.setVisible(true);

			break;
		case "3":
			label_2.setVisible(false);
			lblBird_2.setVisible(true);

			break;
		case "4":
			label_3.setVisible(false);
			lblBird_3.setVisible(true);

			break;
		case "5":
			label_4.setVisible(false);
			lblBird_4.setVisible(true);

			break;
		case "6":
			label_5.setVisible(false);
			lblBird_5.setVisible(true);

			break;

		}

	}

	public void openDoor(int count) {

		switch (count) {

		case 1:
			lblDoor.setVisible(true);
			label_6.setVisible(false);
			label_7.setVisible(false);
			break;

		case 2:
			lblDoor.setVisible(false);
			label_6.setVisible(true);
			label_7.setVisible(false);
			break;
		case 3:
			lblDoor.setVisible(false);
			label_6.setVisible(false);
			label_7.setVisible(true);
			break;

		}

	}
}
