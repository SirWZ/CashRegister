/*
 * Created by JFormDesigner on Wed Jul 18 15:41:44 CEST 2018
 */

package Models;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

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


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
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
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets 0,hidemode 3,gap 0 0",
            // columns
            "[grow,fill]" +
            "[grow,fill]" +
            "[grow,fill]" +
            "[grow,fill]" +
            "[grow,fill]",
            // rows
            "[]" +
            "[47,grow,fill]" +
            "[]" +
            "[31]" +
            "[16]" +
            "[42,grow,fill]" +
            "[12]"));

        //---- reptbtn1 ----
        reptbtn1.setText("\u041e\u0442\u0447\u0435\u0442 1");
        reptbtn1.addActionListener(e -> reptbtn1ActionPerformed());
        contentPane.add(reptbtn1, "cell 1 1");

        //---- reptbtn2 ----
        reptbtn2.setText("\u041e\u0442\u0447\u0435\u0442 2");
        reptbtn2.addActionListener(e -> reptbtn2ActionPerformed());
        contentPane.add(reptbtn2, "cell 3 1");

        //---- reptbtn3 ----
        reptbtn3.setText("\u041e\u0442\u0447\u0435\u0442 3");
        reptbtn3.addActionListener(e -> reptbtn3ActionPerformed());
        contentPane.add(reptbtn3, "cell 1 5");

        //---- reptbtn4 ----
        reptbtn4.setText("\u041e\u0442\u0447\u0435\u0442 4");
        reptbtn4.addActionListener(e -> reptbtn4ActionPerformed());
        contentPane.add(reptbtn4, "cell 3 5");
        setSize(400, 300);
        setLocationRelativeTo(getOwner());

        //======== printdialog ========
        {
            Container printdialogContentPane = printdialog.getContentPane();
            printdialogContentPane.setLayout(null);

            //---- printlbl ----
            printlbl.setText("\u041d\u0430\u043f\u0435\u0447\u0430\u0442\u0430\u0442\u044c");
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
    // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
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
