import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifiedSleepingBarberGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextPane barber1Note;
	public JTextPane sofaCount;
	public JTextPane barber2Note;
	public JTextPane barber3Note;
	public JTextPane queueCount;
	public JLabel barber1Status;
	public JLabel barber2Status;
	public JLabel barber3Status;
	public JLabel casher1;
	public JLabel cashier2;
	public JLabel cashier3;
	public JTextPane textPane;
	public JLabel customerIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifiedSleepingBarberGUI frame = new ModifiedSleepingBarberGUI();
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
	public ModifiedSleepingBarberGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblModifiedSleepingBarber = new JLabel(
				"Modified Sleeping Barber Problem");
		lblModifiedSleepingBarber.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblModifiedSleepingBarber.setBounds(234, 11, 441, 31);
		contentPane.add(lblModifiedSleepingBarber);

		JLabel chair1 = new JLabel("New label");
		chair1.setIcon(new ImageIcon(ModifiedSleepingBarberGUI.class
				.getResource("/image/barber1.jpg")));
		chair1.setBounds(119, 73, 73, 108);
		contentPane.add(chair1);

		JLabel chair2 = new JLabel("New label");
		chair2.setIcon(new ImageIcon(ModifiedSleepingBarberGUI.class
				.getResource("/image/barber1.jpg")));
		chair2.setBounds(307, 73, 73, 108);
		contentPane.add(chair2);

		JLabel chair3 = new JLabel("New label");
		chair3.setIcon(new ImageIcon(ModifiedSleepingBarberGUI.class
				.getResource("/image/barber1.jpg")));
		chair3.setBounds(500, 73, 73, 108);
		contentPane.add(chair3);

		JLabel sofa = new JLabel("New label");
		sofa.setIcon(new ImageIcon(ModifiedSleepingBarberGUI.class
				.getResource("/image/sofa.jpg")));
		sofa.setBounds(10, 341, 370, 55);
		contentPane.add(sofa);

		JLabel exit = new JLabel("New label");
		exit.setIcon(new ImageIcon(ModifiedSleepingBarberGUI.class
				.getResource("/image/exit.jpg")));
		exit.setBounds(754, 308, 73, 88);
		contentPane.add(exit);

		JLabel queue = new JLabel("New label");
		queue.setIcon(new ImageIcon(ModifiedSleepingBarberGUI.class
				.getResource("/image/queue.png")));
		queue.setBounds(500, 308, 73, 77);
		contentPane.add(queue);

		barber1Note = new JTextPane();
		barber1Note.setFont(new Font("Tahoma", Font.PLAIN, 17));
		barber1Note.setBounds(95, 175, 112, 48);
		contentPane.add(barber1Note);

		sofaCount = new JTextPane();
		sofaCount.setFont(new Font("Tahoma", Font.BOLD, 20));
		sofaCount.setBounds(136, 289, 56, 41);
		contentPane.add(sofaCount);

		barber2Note = new JTextPane();
		barber2Note.setFont(new Font("Tahoma", Font.PLAIN, 17));
		barber2Note.setBounds(282, 175, 112, 48);
		contentPane.add(barber2Note);

		barber3Note = new JTextPane();
		barber3Note.setFont(new Font("Tahoma", Font.PLAIN, 17));
		barber3Note.setBounds(472, 175, 112, 48);
		contentPane.add(barber3Note);

		queueCount = new JTextPane();
		queueCount.setFont(new Font("Tahoma", Font.BOLD, 20));
		queueCount.setBounds(581, 326, 56, 41);
		contentPane.add(queueCount);

		barber1Status = new JLabel("Sleeping");
		barber1Status.setBounds(129, 58, 46, 14);
		contentPane.add(barber1Status);

		barber2Status = new JLabel("Sleeping");
		barber2Status.setBounds(318, 58, 46, 14);
		contentPane.add(barber2Status);

		barber3Status = new JLabel("Sleeping");
		barber3Status.setBounds(514, 58, 46, 14);
		contentPane.add(barber3Status);

		casher1 = new JLabel("New label");
		casher1.setIcon(new ImageIcon(ModifiedSleepingBarberGUI.class
				.getResource("/image/cash.jpg")));
		casher1.setBounds(60, 116, 56, 48);
		contentPane.add(casher1);

		cashier2 = new JLabel("New label");
		cashier2.setIcon(new ImageIcon(ModifiedSleepingBarberGUI.class
				.getResource("/image/cash.jpg")));
		cashier2.setBounds(251, 120, 56, 48);
		contentPane.add(cashier2);

		cashier3 = new JLabel("New label");
		cashier3.setIcon(new ImageIcon(ModifiedSleepingBarberGUI.class
				.getResource("/image/cash.jpg")));
		cashier3.setBounds(447, 120, 56, 48);
		contentPane.add(cashier3);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ModifiedBarbershop shop = new ModifiedBarbershop(
						ModifiedSleepingBarberGUI.this);

				shop.start();

			}
		});
		btnStart.setBounds(705, 83, 89, 23);
		contentPane.add(btnStart);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				System.exit(0);

			}
		});
		btnClose.setBounds(705, 116, 89, 23);
		contentPane.add(btnClose);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		textPane.setBounds(691, 236, 126, 61);
		contentPane.add(textPane);
		
		customerIn = new JLabel("New label");
		customerIn.setIcon(new ImageIcon(ModifiedSleepingBarberGUI.class.getResource("/image/customer.png")));
		customerIn.setBounds(667, 316, 77, 51);
		contentPane.add(customerIn);

		barber1Status.setVisible(true);
		barber2Status.setVisible(true);
		barber3Status.setVisible(true);

		casher1.setVisible(false);
		cashier2.setVisible(false);
		cashier3.setVisible(false);
		
		customerIn.setVisible(false);

	}

	public void payment(int number) {

		switch (number) {

		case 1:
			casher1.setVisible(true);
			break;

		case 2:
			cashier2.setVisible(true);
			break;

		case 3:
			cashier3.setVisible(true);
			break;

		}

	}

	public void paymentDone(int number) {

		switch (number) {

		case 1:
			casher1.setVisible(false);

			break;

		case 2:
			cashier2.setVisible(false);

			break;

		case 3:
			cashier3.setVisible(false);

			break;

		}

	}

	public void setBaberNote(int number, String note) {

		switch (number) {

		case 1:
			barber1Note.setText(note);
			break;
		case 2:
			barber2Note.setText(note);

			break;
		case 3:
			barber3Note.setText(note);

			break;

		}

	}

	public void setBarberStatus(int number, Boolean flag) {

		switch (number) {

		case 1:
			barber1Status.setVisible(flag);
			break;
		case 2:
			barber2Status.setVisible(flag);

			break;
		case 3:
			barber3Status.setVisible(flag);

			break;

		}

	}
	
	public void setSofaCount(int count){
		
		sofaCount.setText(count+"");
		
	}

	public void setQueueCount(int count){
		
		queueCount.setText(count+"");
		
	}
	
	public void setRoomFull(String msg){
		
		textPane.setText(msg);
	}
	
	public void setCustomerIn(Boolean flag){
		customerIn.setVisible(flag);
		
	}
}
