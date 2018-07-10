/*
 * Created by JFormDesigner on Tue Jul 10 17:28:52 CEST 2018
 */

package Models;

import java.awt.*;
import java.awt.event.*;
import java.security.Key;
import javax.swing.*;

/**
 * @author Gevtsi Yurii
 */
public class UserInterface extends JFrame {
    public UserInterface() {
        initComponents();
    }

    private void loggBtnActionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    private void passwordFieldKeyPressed(KeyEvent e) {
        if (e.getKeyCode()==10)loggBtn.doClick();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
        loginLable = new JLabel();
        logintextField = new JTextField();
        passwordLabel = new JLabel();
        passwordField = new JPasswordField();
        spacepanel = new JPanel();
        loggpanel = new JPanel();
        loggBtn = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Logg in");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3, 2));

        //---- loginLable ----
        loginLable.setText("Login");
        contentPane.add(loginLable);
        contentPane.add(logintextField);

        //---- passwordLabel ----
        passwordLabel.setText("Password");
        contentPane.add(passwordLabel);

        //---- passwordField ----
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                passwordFieldKeyPressed(e);
            }
        });
        contentPane.add(passwordField);

        //======== spacepanel ========
        {
            spacepanel.setVisible(false);

            // JFormDesigner evaluation mark
            spacepanel.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), spacepanel.getBorder())); spacepanel.addPropertyChangeListener(e -> {if("border".equals(e.getPropertyName()))throw new RuntimeException();});

            spacepanel.setLayout(new FlowLayout());
        }
        contentPane.add(spacepanel);

        //======== loggpanel ========
        {
            loggpanel.setLayout(new FlowLayout());

            //---- loggBtn ----
            loggBtn.setText("Logg  in");
            loggBtn.addActionListener(this::loggBtnActionPerformed);
            loggpanel.add(loggBtn);
        }
        contentPane.add(loggpanel);
        setSize(405, 160);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
    private JLabel loginLable;
    private JTextField logintextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JPanel spacepanel;
    private JPanel loggpanel;
    private JButton loggBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
