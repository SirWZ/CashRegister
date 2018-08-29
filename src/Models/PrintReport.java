/*
 * Created by JFormDesigner on Wed Jul 18 15:41:44 CEST 2018
 */

package Models;

import javax.swing.*;
import java.awt.*;

/**
 * @author Gevtsi Yurii
 */
class PrintReport extends JFrame {
    PrintReport() {
        initComponents();
        this.setTitle("Выбор отчета");
    }


    private void reptbtn1ActionPerformed() {
        this.dispose();
        printdialog.setVisible(true);
        printlbl.setText(printlbl.getText() +" : "+ reptbtn1.getText());
    }

    private void reptbtn2ActionPerformed() {
        this.dispose();
        printdialog.setVisible(true);
        printlbl.setText(printlbl.getText() +" : "+ reptbtn2.getText());
    }

    private void reptbtn3ActionPerformed() {
        this.dispose();
        printdialog.setVisible(true);
        printlbl.setText(printlbl.getText() +" : "+ reptbtn3.getText());
    }

    private void reptbtn4ActionPerformed() {
        this.dispose();
        printdialog.setVisible(true);
        printlbl.setText(printlbl.getText() +" : "+ reptbtn4.getText());
    }

    private void noprintbtnActionPerformed() {
        printdialog.dispose();
    }

    private void okprintbtnActionPerformed() {
        noprintbtnActionPerformed();
    }

    private void exitbtnActionPerformed() {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yurii
        panel2 = new JPanel();
        panel3 = new JPanel();
        exitbtn = new JButton();
        label1 = new JLabel();
        panel1 = new JPanel();
        reptbtn1 = new JButton();
        reptbtn2 = new JButton();
        reptbtn3 = new JButton();
        reptbtn4 = new JButton();
        printdialog = new JDialog();
        printlbl = new JLabel();
        okprintbtn = new JButton();
        noprintbtn = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2, 0));

        //======== panel2 ========
        {

            // JFormDesigner evaluation mark
            panel2.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {142, 0};
            ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 68, 0, 0};
            ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {1.0, 1.0, 0.0, 1.0E-4};

            //======== panel3 ========
            {
                panel3.setLayout(new GridBagLayout());
                ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {97, 265, 0};
                ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
                ((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

                //---- exitbtn ----
                exitbtn.setText("\u0412\u044b\u0445\u043e\u0434");
                exitbtn.addActionListener(e -> {
			exitbtnActionPerformed();
			exitbtnActionPerformed();
		});
                panel3.add(exitbtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));
            }
            panel2.add(panel3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label1 ----
            label1.setText("\u0412\u044b\u0431\u043e\u0440 \u043e\u0442\u0447\u0435\u0442\u0430");
            label1.setFont(new Font("Segoe UI", Font.PLAIN, 30));
            panel2.add(label1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 5, 0), 0, 0));
        }
        contentPane.add(panel2);

        //======== panel1 ========
        {
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 132, 0, 129, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {79, 73, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

            //---- reptbtn1 ----
            reptbtn1.setText("\u041e\u0442\u0447\u0435\u0442 1");
            reptbtn1.addActionListener(e -> reptbtn1ActionPerformed());
            panel1.add(reptbtn1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- reptbtn2 ----
            reptbtn2.setText("\u041e\u0442\u0447\u0435\u0442 2");
            reptbtn2.addActionListener(e -> reptbtn2ActionPerformed());
            panel1.add(reptbtn2, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- reptbtn3 ----
            reptbtn3.setText("\u041e\u0442\u0447\u0435\u0442 3");
            reptbtn3.addActionListener(e -> reptbtn3ActionPerformed());
            panel1.add(reptbtn3, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- reptbtn4 ----
            reptbtn4.setText("\u041e\u0442\u0447\u0435\u0442 4");
            reptbtn4.addActionListener(e -> reptbtn4ActionPerformed());
            panel1.add(reptbtn4, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        }
        contentPane.add(panel1);
        setSize(405, 405);
        setLocationRelativeTo(getOwner());

        //======== printdialog ========
        {
            var printdialogContentPane = printdialog.getContentPane();
            printdialogContentPane.setLayout(null);

            //---- printlbl ----
            printlbl.setText("\u041d\u0430\u043f\u0435\u0447\u0430\u0442\u0430\u0442\u044c");
            printlbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            printlbl.setHorizontalAlignment(SwingConstants.CENTER);
            printdialogContentPane.add(printlbl);
            printlbl.setBounds(25, 30, 190, 35);

            //---- okprintbtn ----
            okprintbtn.setText("\u0414\u0430");
            okprintbtn.addActionListener(e -> okprintbtnActionPerformed());
            printdialogContentPane.add(okprintbtn);
            okprintbtn.setBounds(25, 90, 95, okprintbtn.getPreferredSize().height);

            //---- noprintbtn ----
            noprintbtn.setText("\u041d\u0435\u0442");
            noprintbtn.addActionListener(e -> noprintbtnActionPerformed());
            printdialogContentPane.add(noprintbtn);
            noprintbtn.setBounds(150, 90, 88, noprintbtn.getPreferredSize().height);

            printdialogContentPane.setPreferredSize(new Dimension(270, 150));
            printdialog.pack();
            printdialog.setLocationRelativeTo(printdialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yurii
    private JPanel panel2;
    private JPanel panel3;
    private JButton exitbtn;
    private JLabel label1;
    private JPanel panel1;
    private JButton reptbtn1;
    private JButton reptbtn2;
    private JButton reptbtn3;
    private JButton reptbtn4;
    private JDialog printdialog;
    private JLabel printlbl;
    private JButton okprintbtn;
    private JButton noprintbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
