package Models;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class ButtonsPanelForBigPay extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ButtonsPanelForBigPay() {
		setLayout(new BorderLayout(0, 0));

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setSize(buttonsPanel.getPreferredSize());
		add(buttonsPanel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 113, 113, 113, 113, 0 };
		gbl_panel.rowHeights = new int[] { 75, 75, 75, 75, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		buttonsPanel.setLayout(gbl_panel);

		JButton buttonOne = new JButton("1");
		buttonOne.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_buttonOne = new GridBagConstraints();
		gbc_buttonOne.fill = GridBagConstraints.BOTH;
		gbc_buttonOne.insets = new Insets(0, 0, 5, 5);
		gbc_buttonOne.gridx = 0;
		gbc_buttonOne.gridy = 0;
		buttonsPanel.add(buttonOne, gbc_buttonOne);

		JButton buttonTwo = new JButton("2");
		buttonTwo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_buttonTwo = new GridBagConstraints();
		gbc_buttonTwo.fill = GridBagConstraints.BOTH;
		gbc_buttonTwo.insets = new Insets(0, 0, 5, 5);
		gbc_buttonTwo.gridx = 1;
		gbc_buttonTwo.gridy = 0;
		buttonsPanel.add(buttonTwo, gbc_buttonTwo);

		JButton buttonThree = new JButton("3");
		buttonThree.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_buttonThree = new GridBagConstraints();
		gbc_buttonThree.fill = GridBagConstraints.BOTH;
		gbc_buttonThree.insets = new Insets(0, 0, 5, 5);
		gbc_buttonThree.gridx = 2;
		gbc_buttonThree.gridy = 0;
		buttonsPanel.add(buttonThree, gbc_buttonThree);

		JButton buttonClear = new JButton("Стереть");
		buttonClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_buttonClear = new GridBagConstraints();
		gbc_buttonClear.fill = GridBagConstraints.BOTH;
		gbc_buttonClear.insets = new Insets(0, 0, 5, 0);
		gbc_buttonClear.gridx = 3;
		gbc_buttonClear.gridy = 0;
		buttonsPanel.add(buttonClear, gbc_buttonClear);

		JButton buttonFour = new JButton("4");
		buttonFour.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_buttonFour = new GridBagConstraints();
		gbc_buttonFour.fill = GridBagConstraints.BOTH;
		gbc_buttonFour.insets = new Insets(0, 0, 5, 5);
		gbc_buttonFour.gridx = 0;
		gbc_buttonFour.gridy = 1;
		buttonsPanel.add(buttonFour, gbc_buttonFour);

		JButton buttonFive = new JButton("5");
		buttonFive.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_buttonFive = new GridBagConstraints();
		gbc_buttonFive.fill = GridBagConstraints.BOTH;
		gbc_buttonFive.insets = new Insets(0, 0, 5, 5);
		gbc_buttonFive.gridx = 1;
		gbc_buttonFive.gridy = 1;
		buttonsPanel.add(buttonFive, gbc_buttonFive);

		JButton buttonSix = new JButton("6");
		buttonSix.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_buttonSix = new GridBagConstraints();
		gbc_buttonSix.fill = GridBagConstraints.BOTH;
		gbc_buttonSix.insets = new Insets(0, 0, 5, 5);
		gbc_buttonSix.gridx = 2;
		gbc_buttonSix.gridy = 1;
		buttonsPanel.add(buttonSix, gbc_buttonSix);

		JButton buttonCancel = new JButton("Отмена");
		buttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_buttonCancel = new GridBagConstraints();
		gbc_buttonCancel.fill = GridBagConstraints.BOTH;
		gbc_buttonCancel.insets = new Insets(0, 0, 5, 0);
		gbc_buttonCancel.gridx = 3;
		gbc_buttonCancel.gridy = 1;
		buttonsPanel.add(buttonCancel, gbc_buttonCancel);

		JButton buttonSeven = new JButton("7");
		buttonSeven.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_buttonSeven = new GridBagConstraints();
		gbc_buttonSeven.fill = GridBagConstraints.BOTH;
		gbc_buttonSeven.insets = new Insets(0, 0, 5, 5);
		gbc_buttonSeven.gridx = 0;
		gbc_buttonSeven.gridy = 2;
		buttonsPanel.add(buttonSeven, gbc_buttonSeven);

		JButton buttonEight = new JButton("8");
		buttonEight.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_buttonEight = new GridBagConstraints();
		gbc_buttonEight.fill = GridBagConstraints.BOTH;
		gbc_buttonEight.insets = new Insets(0, 0, 5, 5);
		gbc_buttonEight.gridx = 1;
		gbc_buttonEight.gridy = 2;
		buttonsPanel.add(buttonEight, gbc_buttonEight);

		JButton buttonNine = new JButton("9");
		buttonNine.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_buttonNine = new GridBagConstraints();
		gbc_buttonNine.fill = GridBagConstraints.BOTH;
		gbc_buttonNine.insets = new Insets(0, 0, 5, 5);
		gbc_buttonNine.gridx = 2;
		gbc_buttonNine.gridy = 2;
		buttonsPanel.add(buttonNine, gbc_buttonNine);

		JButton btnNewButton_12 = new JButton("Колличество");
		btnNewButton_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton_12 = new GridBagConstraints();
		gbc_btnNewButton_12.gridheight = 2;
		gbc_btnNewButton_12.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_12.gridx = 3;
		gbc_btnNewButton_12.gridy = 2;
		buttonsPanel.add(btnNewButton_12, gbc_btnNewButton_12);

		JButton buttonZerro = new JButton("0");
		buttonZerro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_buttonZero = new GridBagConstraints();
		gbc_buttonZero.fill = GridBagConstraints.BOTH;
		gbc_buttonZero.insets = new Insets(0, 0, 0, 5);
		gbc_buttonZero.gridx = 0;
		gbc_buttonZero.gridy = 3;
		buttonsPanel.add(buttonZerro, gbc_buttonZero);

		JButton buttonDoubleZerro = new JButton("00");
		buttonDoubleZerro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_buttonDoubleZerro = new GridBagConstraints();
		gbc_buttonDoubleZerro.fill = GridBagConstraints.BOTH;
		gbc_buttonDoubleZerro.insets = new Insets(0, 0, 0, 5);
		gbc_buttonDoubleZerro.gridx = 1;
		gbc_buttonDoubleZerro.gridy = 3;
		buttonsPanel.add(buttonDoubleZerro, gbc_buttonDoubleZerro);

		JButton buttonTod = new JButton(".");
		buttonTod.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_buttonTod = new GridBagConstraints();
		gbc_buttonTod.fill = GridBagConstraints.BOTH;
		gbc_buttonTod.insets = new Insets(0, 0, 0, 5);
		gbc_buttonTod.gridx = 2;
		gbc_buttonTod.gridy = 3;
		buttonsPanel.add(buttonTod, gbc_buttonTod);

		addTextByButton(buttonOne);
		addTextByButton(buttonTwo);
		addTextByButton(buttonThree);
		addTextByButton(buttonFour);
		addTextByButton(buttonFive);
		addTextByButton(buttonSix);
		addTextByButton(buttonSeven);
		addTextByButton(buttonEight);
		addTextByButton(buttonNine);
		addTextByButton(buttonZerro);
		addTextByButton(buttonDoubleZerro);
		addTextByButton(buttonTod);
		clearTextByButton(buttonClear);

		JPanel textFieldPanel = new JPanel();
		add(textFieldPanel, BorderLayout.NORTH);
		textFieldPanel.setLayout(new BorderLayout(0, 0));
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setBackground(Color.WHITE);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textFieldPanel.add(textField);

	}

	private void clearTextByButton(JButton button) {
		button.addActionListener(e -> {
			if(textField.getText().length() > 0)
			textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
		});
	}

	private void addTextByButton(JButton button) {
		button.addActionListener(e -> {
			textField.setText(textField.getText() + button.getText());
		});
	}

	public String getTextFieldText() {
		return textField.getText();
	}

}
