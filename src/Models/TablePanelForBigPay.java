package Models;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

public class TablePanelForBigPay extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TablePanelForBigPay() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Search");
		panel_1.add(btnNewButton, BorderLayout.EAST);
		
		JButton btnNewButton_1 = new JButton("Down");
		panel_1.add(btnNewButton_1, BorderLayout.CENTER);
		
		JButton btnNewButton_2 = new JButton("UP");
		panel_1.add(btnNewButton_2, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("Общая сумма ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_2.add(label, BorderLayout.NORTH);
		
		JLabel label_1 = new JLabel("23");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_2.add(label_1, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane, BorderLayout.CENTER);
		String[] columnNames = { "Товар", "Штрих-код", "ед. измерения", "Количество", "Цена/шт", "Сумма" };
		Object[][] data = {{"Молоко",2222,"шт",3,10,30},
						   {"Хлеб",3333,"шт",2,12,24}};

		table = new JTable(data, columnNames);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(table);

	}

}
