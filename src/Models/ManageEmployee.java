/*
 * Created by JFormDesigner on Sun Nov 11 18:02:18 CET 2018
 */

package Models;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;

/**
 * @author Yaroslav
 */
public class ManageEmployee extends JFrame {
    private Connection cn;

    public ManageEmployee(Connection cn) {
        this.cn = cn;
        initComponents();
        this.setVisible(true);
    }

    private void addEmpButtonActionPerformed(ActionEvent e) {
        new AddEmployee(cn);
        this.dispose();
    }

    private void backButtonActionPerformed(ActionEvent e) {
        new MyShop(cn);
        this.dispose();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yaroslav
        panel2 = new JPanel();
        backButton = new JButton();
        panel1 = new JPanel();
        addEmpButton = new JButton();
        contractButton = new JButton();
        empButton = new JButton();
        empPosButton = new JButton();

        //======== this ========
        setTitle("\u0423\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u0441\u043e\u0442\u0440\u0443\u0434\u043d\u0438\u043a\u0430\u043c\u0438");
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());

        //======== panel2 ========
        {

            // JFormDesigner evaluation mark
            panel2.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 60, 0};
            ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 60, 0};
            ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

            //---- backButton ----
            backButton.setText("\u041d\u0430\u0437\u0430\u0434");
            backButton.addActionListener(e -> {
			backButtonActionPerformed(e);
			backButtonActionPerformed(e);
		});
            panel2.add(backButton, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //======== panel1 ========
        {
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {185, 180, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {79, 74, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

            //---- addEmpButton ----
            addEmpButton.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0441\u043e\u0442\u0440\u0443\u0434\u043d\u0438\u043a\u0430");
            addEmpButton.addActionListener(e -> addEmpButtonActionPerformed(e));
            panel1.add(addEmpButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- contractButton ----
            contractButton.setText("\u041a\u043e\u043d\u0442\u0440\u0430\u043a\u0442\u044b");
            panel1.add(contractButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- empButton ----
            empButton.setText("\u041c\u043e\u0438 \u0441\u043e\u0442\u0440\u0443\u0434\u043d\u0438\u043a\u0438");
            panel1.add(empButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- empPosButton ----
            empPosButton.setText("\u0414\u043e\u043b\u0436\u043d\u043e\u0441\u0442\u0438");
            panel1.add(empPosButton, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        setSize(495, 300);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yaroslav
    private JPanel panel2;
    private JButton backButton;
    private JPanel panel1;
    private JButton addEmpButton;
    private JButton contractButton;
    private JButton empButton;
    private JButton empPosButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
