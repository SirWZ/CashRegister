package Models;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class CombinedPanelForBigPay extends JPanel {

	/**
	 * Create the panel.
	 */
	public CombinedPanelForBigPay() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		panel.add(new RightPanelForBigPay(), BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(new TablePanelForBigPay(), BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(new ButtonsPanelForBigPay(), BorderLayout.CENTER);
		
		
		//add(new TablePanelForBigPay(), BorderLayout.CENTER);
		
		
		//add(new ButtonsPanelForBigPay(), BorderLayout.SOUTH);
		
		//add(new RightPanelForBigPay(),BorderLayout.EAST);
		
		
	
		
	}

}
