package Models.PayInterfaceModel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class RightPanelForBigPay extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public RightPanelForBigPay() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("Поиск по коду");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Орехи");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 0;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("Булки");
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_6.gridx = 2;
		gbc_btnNewButton_6.gridy = 0;
		panel.add(btnNewButton_6, gbc_btnNewButton_6);
		
		JButton btnNewButton_1 = new JButton("Проверить цену");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("Ещё одна");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 1;
		panel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_7 = new JButton("Овощи");
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_7.gridx = 2;
		gbc_btnNewButton_7.gridy = 1;
		panel.add(btnNewButton_7, gbc_btnNewButton_7);
		
		JButton btnNewButton_5 = new JButton("Оплата");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel label = new JLabel(" Всего:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		panel.add(label, gbc_label);
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.gridwidth = 2;
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 2;
		panel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setText("Поиск товара");
		panel_2.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		list.setMaximumSize(new Dimension(0, 200));
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(list);

	}

}
