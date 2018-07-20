package Models;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Font;

public class BigPayInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BigPayInterface window = new BigPayInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BigPayInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Bying field");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 22));
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		tabbedPane.addTab("Чек 1", null, new CombinedPanelForBigPay(), null);
		tabbedPane.addTab("Чек 2", null, new CombinedPanelForBigPay(), null);
		tabbedPane.addTab("Чек 3", null, new CombinedPanelForBigPay(), null);

		JPanel bottomPanel = new JPanel();
		frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout(0, 0));

		JLabel nameLabel = new JLabel(" Ебобо В.М.");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		bottomPanel.add(nameLabel, BorderLayout.WEST);

		JLabel dateLabel = new JLabel();
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		setLabelAsTimer(dateLabel);
		bottomPanel.add(dateLabel, BorderLayout.EAST);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		//frame.setUndecorated(true);
	}

	private void setLabelAsTimer(JLabel label) {
		new Thread(() -> {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm ");
			label.setText(dateFormat.format(Calendar.getInstance().getTime()));
			while (true) {
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {
				}
				label.setText(dateFormat.format(Calendar.getInstance().getTime()));
			}

		}).start();

	}

}
