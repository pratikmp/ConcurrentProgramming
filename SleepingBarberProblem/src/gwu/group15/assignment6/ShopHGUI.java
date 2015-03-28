package gwu.group15.assignment6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;

public class ShopHGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel totalWaiting;
	public JTextPane barberStatus;
	public JTextPane exitStatus;
	public JLabel barber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopHGUI frame = new ShopHGUI();
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
	public ShopHGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTotalWaitingCapacity = new JLabel("Total Waiting=");
		lblTotalWaitingCapacity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotalWaitingCapacity.setBounds(5, 73, 145, 41);
		contentPane.add(lblTotalWaitingCapacity);
		
		totalWaiting = new JLabel("Total");
		totalWaiting.setFont(new Font("Tahoma", Font.BOLD, 18));
		totalWaiting.setBounds(147, 78, 58, 33);
		contentPane.add(totalWaiting);
		
		JLabel barberChair = new JLabel("");
		barberChair.setIcon(new ImageIcon(ShopHGUI.class.getResource("/images/chair.jpg")));
		barberChair.setBounds(471, 125, 297, 292);
		contentPane.add(barberChair);
		
		JLabel waitingChair = new JLabel("");
		waitingChair.setIcon(new ImageIcon(ShopHGUI.class.getResource("/images/sofa.jpg")));
		waitingChair.setBounds(62, 115, 111, 114);
		contentPane.add(waitingChair);
		
		JLabel Exit = new JLabel("New label");
		Exit.setIcon(new ImageIcon(ShopHGUI.class.getResource("/images/1.jpg")));
		Exit.setBounds(5, 331, 157, 114);
		contentPane.add(Exit);
		
		JLabel lblBarberStatus = new JLabel("Barber Status");
		lblBarberStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBarberStatus.setBounds(336, 73, 131, 23);
		contentPane.add(lblBarberStatus);
		
		JLabel lblExit = new JLabel("Exit:= ");
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblExit.setBounds(92, 437, 58, 41);
		contentPane.add(lblExit);
		
		JButton btnOpenShop = new JButton("Open Shop");
		btnOpenShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Barbershop bs = new Barbershop(ShopHGUI.this);
				bs.start();
			
			}
		});
		btnOpenShop.setBounds(23, 11, 127, 41);
		contentPane.add(btnOpenShop);
		
		JButton btnCloseShop = new JButton("Close Shop");
		btnCloseShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				dispose();
				System.exit(0);
			}
		});
		btnCloseShop.setBounds(170, 15, 122, 37);
		contentPane.add(btnCloseShop);
		
		barberStatus = new JTextPane();
		barberStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		barberStatus.setBounds(471, 56, 297, 69);
		contentPane.add(barberStatus);
		
		exitStatus = new JTextPane();
		exitStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		exitStatus.setBounds(149, 437, 246, 91);
		contentPane.add(exitStatus);
		
		barber = new JLabel("");
		barber.setFont(new Font("Tahoma", Font.ITALIC, 15));
		barber.setBounds(308, 107, 153, 33);
		contentPane.add(barber);
	}
	
	public void setTotalCapacity(int totalCapacity){
		
		totalWaiting.setText(totalCapacity+"");
			
	}
	
public void setBarberStatus(String bStatus){
		
	barberStatus.setText(bStatus);
			
	}
public void setExitStatus(String eStatus){
		
	exitStatus.setText(eStatus);
			
	}

public void setBarber(String eStatus){
	
	barber.setText(eStatus);
			
	}
}


