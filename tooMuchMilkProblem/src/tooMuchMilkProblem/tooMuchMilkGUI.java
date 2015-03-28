package tooMuchMilkProblem;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tooMuchMilkGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextPane roomate2Note;
	public JTextPane roomate1Note;
	public JLabel milk;
	public JLabel noMilk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tooMuchMilkGUI frame = new tooMuchMilkGUI();
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
	public tooMuchMilkGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		roomate2Note = new JTextPane();
		roomate2Note.setFont(new Font("Tahoma", Font.BOLD, 20));
		roomate2Note.setBounds(487, 178, 135, 79);
		contentPane.add(roomate2Note);
		
		roomate1Note = new JTextPane();
		roomate1Note.setFont(new Font("Tahoma", Font.BOLD, 20));
		roomate1Note.setBackground(UIManager.getColor("Button.background"));
		roomate1Note.setBounds(67, 113, 122, 72);
		contentPane.add(roomate1Note);
		
		JLabel roomate1 = new JLabel("");
		roomate1.setIcon(new ImageIcon(tooMuchMilkGUI.class.getResource("/images/roomate1.jpg")));
		roomate1.setBounds(10, 81, 220, 242);
		contentPane.add(roomate1);
		
		JLabel roomate2 = new JLabel("New label");
		roomate2.setIcon(new ImageIcon(tooMuchMilkGUI.class.getResource("/images/roomate2.jpg")));
		roomate2.setBounds(434, 81, 208, 242);
		contentPane.add(roomate2);
		
		milk = new JLabel("New label");
		milk.setIcon(new ImageIcon(tooMuchMilkGUI.class.getResource("/images/milk.jpg")));
		milk.setBounds(294, 230, 89, 93);
		milk.setVisible(false);
		contentPane.add(milk);
		
		noMilk = new JLabel("New label");
		noMilk.setIcon(new ImageIcon(tooMuchMilkGUI.class.getResource("/images/nomilk.jpg")));
		noMilk.setBounds(280, 210, 115, 113);
		noMilk.setVisible(false);
		contentPane.add(noMilk);
		
		JLabel lblTooMuchMilk = new JLabel("Too Much Milk Problem");
		lblTooMuchMilk.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTooMuchMilk.setBounds(160, 25, 366, 44);
		contentPane.add(lblTooMuchMilk);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				 tooMuchMilk sharedRoomLife = new tooMuchMilk(tooMuchMilkGUI.this);
				 sharedRoomLife.start();   
			
			}
		});
		btnStart.setBounds(204, 378, 89, 23);
		contentPane.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				dispose();
				System.exit(0);
			}
		});
		btnStop.setBounds(352, 378, 89, 23);
		contentPane.add(btnStop);
	}
	
	public void setNoMilk(Boolean flag){
		noMilk.setVisible(flag);
		
	}
	
	public void setMilk(Boolean flag){
		milk.setVisible(flag);
		
	}
	
	public void setRoomate1Note(String note){
		roomate1Note.setText(note);
		
	}
	
	public void setRoomate2Note(String note){
		roomate2Note.setText(note);
		
		
	}
}
