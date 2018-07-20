/*
 * Created by JFormDesigner on Thu Jul 19 16:06:54 CEST 2018
 */

package Models;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Gevtsi Yurii
 */
class WriteOffProd extends JFrame {
    WriteOffProd() {
        initComponents();
    }

    private void okbtnActionPerformed() {
        masseglabel.setText(nametextField.getText());
        writeoffdialog.setVisible(true);
    }

    private void okbtn2ActionPerformed() {
        nobtn2ActionPerformed();
        this.dispose();
    }

    private void nobtn2ActionPerformed() {
        writeoffdialog.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
        JLabel namelabel = new JLabel();
        nametextField = new JTextField();
        JLabel codelabel = new JLabel();
        JTextField codetextField = new JTextField();
        JLabel countlabel = new JLabel();
        JTextField counttextField = new JTextField();
        JLabel reasonlabel = new JLabel();
        JScrollPane scrollPane1 = new JScrollPane();
        JTextArea reasontextArea = new JTextArea();
        JPanel panel1 = new JPanel();
        JButton okbtn = new JButton();
        writeoffdialog = new JDialog();
        JPanel panel2 = new JPanel();
        JLabel label4 = new JLabel();
        masseglabel = new JLabel();
        JPanel panel3 = new JPanel();
        JButton okbtn2 = new JButton();
        JButton nobtn2 = new JButton();

        //======== this ========
        setTitle("\u0421\u043f\u0438\u0441\u0430\u0442\u044c \u0442\u043e\u0432\u0430\u0440");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[4,fill]" +
            "[87,grow,fill]" +
            "[165,grow,fill]",
            // rows
            "[]" +
            "[40,grow,fill]" +
            "[42,grow,fill]" +
            "[46,grow,fill]" +
            "[95,grow,fill]" +
            "[39,grow,fill]"));

        //---- namelabel ----
        namelabel.setText("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435");
        contentPane.add(namelabel, "cell 1 1,alignx center,growx 0");
        contentPane.add(nametextField, "");

        //---- codelabel ----
        codelabel.setText("\u041a\u043e\u0434 \u0442\u043e\u0432\u0430\u0440\u0430");
        contentPane.add(codelabel, "cell 1 2,alignx center,growx 0");
        contentPane.add(codetextField, "cell 2 2");

        //---- countlabel ----
        countlabel.setText("\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e");
        contentPane.add(countlabel, "cell 1 3,alignx center,growx 0");
        contentPane.add(counttextField, "cell 2 3");

        //---- reasonlabel ----
        reasonlabel.setText("\u041f\u0440\u0438\u0447\u0438\u043d\u0430");
        contentPane.add(reasonlabel, "cell 1 4,alignx center,growx 0");

        //======== scrollPane1 ========
        {
            scrollPane1.setMinimumSize(new Dimension(16, 76));

            //---- reasontextArea ----
            reasontextArea.setLineWrap(true);
            scrollPane1.setViewportView(reasontextArea);
        }
        contentPane.add(scrollPane1, "cell 2 4");

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(e -> {if("border".equals(e.getPropertyName()))throw new RuntimeException();});

            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[52,fill]",
                // rows
                "[fill]" +
                "[grow,fill]" +
                "[]" +
                "[]"));

            //---- okbtn ----
            okbtn.setText("\u0421\u043f\u0438\u0441\u0430\u0442\u044c");
            okbtn.setHorizontalAlignment(SwingConstants.LEFT);
            okbtn.addActionListener(e -> okbtnActionPerformed());
            panel1.add(okbtn, "cell 1 0 2 2");
        }
        contentPane.add(panel1, "cell 2 5");
        setSize(570, 375);
        setLocationRelativeTo(getOwner());

        //======== writeoffdialog ========
        {
            writeoffdialog.setAlwaysOnTop(true);
            writeoffdialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            writeoffdialog.setResizable(false);
            Container writeoffdialogContentPane = writeoffdialog.getContentPane();
            writeoffdialogContentPane.setLayout(new GridLayout(2, 1));

            //======== panel2 ========
            {

                // JFormDesigner evaluation mark
                panel2.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(e -> {if("border".equals(e.getPropertyName()))throw new RuntimeException();});

                panel2.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- label4 ----
                label4.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c \u0441\u043f\u0438\u0441\u0430\u043d\u0438\u0435 \u0442\u043e\u0432\u0430\u0440\u043e\u0432 :");
                panel2.add(label4, "cell 2 1");

                //---- masseglabel ----
                masseglabel.setText("text");
                panel2.add(masseglabel, "cell 2 2");
            }
            writeoffdialogContentPane.add(panel2);

            //======== panel3 ========
            {
                panel3.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[22,fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[34,fill]" +
                    "[37,fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]"));

                //---- okbtn2 ----
                okbtn2.setText("\u0414\u0430");
                okbtn2.addActionListener(e -> okbtn2ActionPerformed());
                panel3.add(okbtn2, "cell 2 1");

                //---- nobtn2 ----
                nobtn2.setText("\u041d\u0435\u0442");
                nobtn2.addActionListener(e -> nobtn2ActionPerformed());
                panel3.add(nobtn2, "cell 4 1");
            }
            writeoffdialogContentPane.add(panel3);
            writeoffdialog.setSize(280, 160);
            writeoffdialog.setLocationRelativeTo(writeoffdialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private JTextField nametextField;
    private JDialog writeoffdialog;
    private JLabel masseglabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
