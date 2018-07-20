
package Models;

import Models.PayInterfaceModel.BigPayInterface;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.SystemColor;
import java.awt.Font;

class CashierViewWindow {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	CashierViewWindow() {
		initialize();
		this.frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame("Интерфейс касира");
		frame.setBounds(100, 100, 581, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 2, 0, 0));
		JButton[][] arrayOfButtons = new JButton[2][5];

		// Кнопка Продажи
		JButton sellingButton = new JButton("Продажа");
		sellingButton.addActionListener(e -> new BigPayInterface());
		arrayOfButtons[0][0] = sellingButton;

		// Кнопка Вплаты
		JButton payInButton = new JButton("Вплата");
		payInButton.addActionListener(e -> new CashInOut("Вплата").setVisible(true));
		arrayOfButtons[0][1] = payInButton;

		// Кнопка выплаты
		JButton payOffButton = new JButton("Выплата");
		payOffButton.addActionListener(e -> new CashInOut("Выплата").setVisible(true));
		arrayOfButtons[0][2] = payOffButton;

		// Кнопка Закончить смену
		JButton endSessionButton = new JButton("Закончить смену");
		endSessionButton.addActionListener(e -> new FinishWork(frame).setVisible(true));
		arrayOfButtons[0][3] = endSessionButton;

		// Кнопка Мой магазин
		JButton myShopButton = new JButton("Мой магазин");
		myShopButton.addActionListener(e -> {

		});
		arrayOfButtons[0][4] = myShopButton;

		// Кнопка Возврат товара
		JButton retrieveGoodsButton = new JButton("Возврат товара");
		retrieveGoodsButton.addActionListener(e -> new ReturnProduct());
		arrayOfButtons[1][0] = retrieveGoodsButton;

		// Кнопка принять доставку
		JButton acceptDeliveryButton = new JButton("Принять доставку");
		acceptDeliveryButton.addActionListener(e -> {

		});
		arrayOfButtons[1][1] = acceptDeliveryButton;

		// Кнопка списать товар
		JButton deleteGoodsButton = new JButton("Списать товар");
		deleteGoodsButton.addActionListener(e -> new WriteOffProd().setVisible(true));
		arrayOfButtons[1][2] = deleteGoodsButton;

		// Кнопка напечатать отчёт
		JButton printDeclarationButton = new JButton("Напечатать отчёт");
		printDeclarationButton.addActionListener(e -> new PrintReport().setVisible(true));
		arrayOfButtons[1][3] = printDeclarationButton;

		// Конпка Выход
		JButton exitButton = new JButton("Выход");
		exitButton.addActionListener(e -> {

		});
		arrayOfButtons[1][4] = exitButton;

		setFocusEvent(arrayOfButtons);

		// Добавление кнопок попарно (одна слева - одна справа)
		panel.add(sellingButton);
		panel.add(retrieveGoodsButton);

		panel.add(payInButton);
		panel.add(acceptDeliveryButton);

		panel.add(payOffButton);
		panel.add(deleteGoodsButton);

		panel.add(endSessionButton);
		panel.add(printDeclarationButton);

		panel.add(myShopButton);
		panel.add(exitButton);
	}

	/*
	 * Метод для переключения кнопок с помощью стрелок а так же для изменения цвета
	 * кнопки на более тёмный если кнопка выбрана, так же добавление реакции на
	 * ENTER. Передается сюда массив кнопок 2 на 4.
	 * 
	 * P.S. Хз, может этот варик можно изменить т.к. при добавлении только одной
	 * кнопки в Грид Вью будет баг, и чтобы ничего не херилось кнопки прийдется
	 * добавлять парами.
	 * 
	 * P.S.S. Хотя насчёт бага я хуй знает, может его и не будет)
	 */

	
	private void setFocusEvent(JButton[][] buttons) {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				final int curColumn = i;
				final int curRow = j;

				// Установка одинакового размера текста в зависимости от buttonSize
				int buttonSize = 22;
				buttons[i][j].setFont(new Font("Tahoma", Font.PLAIN, buttonSize));

				// Добавление активации при нажатии Enter
				buttons[i][j].addKeyListener(enter);

				// Добавление того самого затемнения при фокусе
				buttons[i][j].addFocusListener(new FocusListener() {

					@Override
					public void focusLost(FocusEvent event) {
						buttons[curColumn][curRow].setBackground(null);

					}

					@Override
					public void focusGained(FocusEvent event) {

						buttons[curColumn][curRow].setBackground(SystemColor.activeCaption);

					}

				});

				// Добавление переключения с помощью стрелок
				buttons[i][j].addKeyListener(new KeyAdapter() {

					@Override
					public void keyPressed(KeyEvent e) {
						switch (e.getKeyCode()) {
						case KeyEvent.VK_RIGHT:
							if ((curColumn + 1) >= buttons.length) {
								buttons[0][curRow].requestFocus();
							} else {
								buttons[curColumn + 1][curRow].requestFocus();
							}

							break;

						case KeyEvent.VK_LEFT:
							if ((curColumn - 1) < 0) {
								buttons[buttons.length - 1][curRow].requestFocus();
							} else {
								buttons[curColumn - 1][curRow].requestFocus();
							}

							break;

						case KeyEvent.VK_DOWN:
							if ((curRow + 1) >= buttons[curColumn].length) {
								buttons[curColumn][0].requestFocus();
							} else {
								buttons[curColumn][curRow + 1].requestFocus();
							}

							break;

						case KeyEvent.VK_UP:
							if ((curRow - 1) < 0) {
								buttons[curColumn][buttons[curColumn].length - 1].requestFocus();
							} else {
								buttons[curColumn][curRow - 1].requestFocus();
							}
							break;
						}
					}
				});

			}
		}

	}

	// KeyListener реагирующий на ENTER
	private KeyListener enter = new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				((JButton) e.getComponent()).doClick();
			}
		}
	};

}
