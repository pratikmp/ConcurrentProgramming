package gwu.group15.assignment6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RPriorityGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2941112204957781109L;
	private JPanel contentPane;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;
	public JLabel lblNewLabel_5;
	public JLabel Rtag;
	public JLabel Wtag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RPriorityGUI frame = new RPriorityGUI();
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
	public RPriorityGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNoOfReader = new JLabel("No. of Reader");
		lblNoOfReader.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNoOfReader.setBounds(10, 214, 130, 49);
		contentPane.add(lblNoOfReader);

		JLabel lblNewLabel_1 = new JLabel("Reading");
		lblNewLabel_1.setBounds(26, 274, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblWaiting = new JLabel("Waiting");
		lblWaiting.setBounds(26, 361, 46, 14);
		contentPane.add(lblWaiting);

		JLabel lblNoOfWriter = new JLabel("No. of Writer");
		lblNoOfWriter.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNoOfWriter.setBounds(518, 224, 144, 39);
		contentPane.add(lblNoOfWriter);

		JLabel lblWriting = new JLabel("Writing");
		lblWriting.setBounds(494, 274, 46, 14);
		contentPane.add(lblWriting);

		JLabel lblWaiting_1 = new JLabel("Waiting");
		lblWaiting_1.setBounds(494, 349, 46, 14);
		contentPane.add(lblWaiting_1);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(82, 274, 46, 14);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(82, 361, 234, 14);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(550, 274, 46, 14);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(550, 349, 291, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblReaderPriority = new JLabel("Reader Priority");
		lblReaderPriority.setFont(new Font("Tempus Sans ITC", Font.BOLD
				| Font.ITALIC, 25));
		lblReaderPriority.setBounds(253, 29, 187, 39);
		contentPane.add(lblReaderPriority);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(RPriorityGUI.class
				.getResource("/images/readerWriter.jpg")));
		lblNewLabel.setBounds(162, 11, 346, 305);
		contentPane.add(lblNewLabel);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ReaderPriority RWEx = new ReaderPriority(RPriorityGUI.this);
				for (int i = 0; i < 15; i++)

				{

					RWEx.startRequestWrite();

					RWEx.startRequestRead();

					RWEx.startReleaseWrite();

					RWEx.startReleaseRead();

				}

			}
		});
		btnStart.setBounds(227, 315, 89, 23);
		contentPane.add(btnStart);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				System.exit(0);

			}
		});
		btnStop.setBounds(328, 315, 89, 23);
		contentPane.add(btnStop);

		Rtag = new JLabel("R");
		Rtag.setFont(new Font("Tahoma", Font.BOLD, 50));
		Rtag.setBounds(65, 67, 46, 76);
		Rtag.setVisible(false);
		contentPane.add(Rtag);

		Wtag = new JLabel("W");
		Wtag.setFont(new Font("Tahoma", Font.BOLD, 50));
		Wtag.setBounds(563, 73, 74, 65);
		Wtag.setVisible(false);
		contentPane.add(Wtag);
	}

	public void setRReading(int count) {

		lblNewLabel_2.setText(count + "");

	}

	public void setRWaiting(String count) {

		lblNewLabel_3.setText(count + "");
	}

	public void setWWriting(int count) {

		lblNewLabel_4.setText(count + "");

	}

	public void setWWaiting(String count) {

		lblNewLabel_5.setText(count + "");

	}

	public void setRtag(Boolean flag) {

		Rtag.setVisible(flag);

	}

	public void setWtag(Boolean flag) {

		Wtag.setVisible(flag);

	}

}
