package test1;

import java.awt.Dimension;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Smoker1Dialog {
	String message = null;
	private int secends = 0;
	private JTextArea jta = new JTextArea();
	JDialog dialog = null;

	public void showDialog(JFrame father, String message, int sec) {

		this.message = message;
		secends = sec;
		jta.setText(message);
		jta.setBounds(6, 6, 200, 20);
		ScheduledExecutorService s = Executors
				.newSingleThreadScheduledExecutor();

		dialog = new JDialog(father, true);
		dialog.setTitle("Smoker: I need matches");
		dialog.setModal(false);
		dialog.setLayout(null);
		dialog.add(jta);

		s.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				Smoker1Dialog.this.secends--;
				if (Smoker1Dialog.this.secends == 0) {
					Smoker1Dialog.this.dialog.dispose();
				} else {
					dialog.setTitle("Smoker: I need matches");
				}
			}
		}, 1, 1, TimeUnit.SECONDS);
		dialog.pack();
		dialog.setSize(new Dimension(250, 100));
		dialog.setLocationRelativeTo(father);
		dialog.setLocation(father.getWidth() / 7, father.getHeight() / 2
				+ dialog.getHeight());
		dialog.setVisible(true);
	}
}