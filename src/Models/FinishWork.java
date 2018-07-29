/*
 * Created by JFormDesigner on Wed Jul 18 13:46:35 CEST 2018
 */

package Models;

import java.awt.*;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Gevtsi Yurii
 */
 class FinishWork extends JDialog {
    Connection cn;
     private Frame frame;
    FinishWork(Frame owner,Connection cn) {
        super(owner);this.cn=cn;
        frame = owner;
        initComponents();
        this.setResizable(false);
    }

    private void okEndBtnActionPerformed() {
        frame.dispose();
        this.dispose();
        countcashdialog.setVisible(true);
    }

    private void cancelButtonActionPerformed() {
        this.dispose();
    }

    private void okButton2ActionPerformed() {

        countcashdialog.dispose();
        countcashdialog2.setVisible(true);
    }

    private void cancelButton2ActionPerformed() {
        countcashdialog.dispose();
        printdialog.setVisible(true);
    }

    private void okButton3ActionPerformed() {
        cancelButton3ActionPerformed();
    }

    private void cancelButton3ActionPerformed() {
        printdialog.dispose();
        JOptionPane.showMessageDialog(this,"Смена закончена","",JOptionPane.INFORMATION_MESSAGE);
        new UserInterface(cn).setVisible(true);
    }

    private void okButton4ActionPerformed() {
        countcashdialog2.dispose();
        printdialog.setVisible(true);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
        JPanel dialogPane = new JPanel();
        JPanel contentPanel = new JPanel();
        JLabel textlabel = new JLabel();
        JPanel buttonBar = new JPanel();
        JButton okEndBtn = new JButton();
        JButton noEndBtn = new JButton();
        countcashdialog = new JDialog();
        countcashdialog.setResizable(false);
        JPanel dialogPane2 = new JPanel();
        JPanel contentPanel2 = new JPanel();
        JLabel textlabel2 = new JLabel();
        JPanel buttonBar2 = new JPanel();
        JButton okCountbtn = new JButton();
        JButton noCountBtn = new JButton();
        printdialog = new JDialog();
        printdialog.setResizable(false);
        JPanel dialogPane3 = new JPanel();
        JPanel contentPanel3 = new JPanel();
        JLabel textlabel3 = new JLabel();
        JPanel buttonBar3 = new JPanel();
        JButton okPrintBtn = new JButton();
        JButton noPrintBtn = new JButton();
        countcashdialog2 = new JDialog();
        countcashdialog2.setResizable(false);

        JPanel dialogPane4 = new JPanel();
        JPanel contentPanel4 = new JPanel();
        JLabel label1 = new JLabel();
        JTextField textField1 = new JTextField();
        JPanel buttonBar4 = new JPanel();
        JButton okSummBtn = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(e -> {if("border".equals(e.getPropertyName()))throw new RuntimeException();});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- textlabel ----
                textlabel.setText("\u0417\u0430\u043a\u043e\u043d\u0447\u0438\u0442\u044c \u0441\u043c\u0435\u043d\u0443?");
                textlabel.setPreferredSize(new Dimension(303, 26));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(92, Short.MAX_VALUE)
                            .addComponent(textlabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                            .addGap(73, 73, 73))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(textlabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridLayout());

                //---- okEndBtn ----
                okEndBtn.setText("\u0414\u0430");
                okEndBtn.addActionListener(e ->okEndBtnActionPerformed());
                buttonBar.add(okEndBtn);

                //---- noEndBtn ----
                noEndBtn.setText("\u041d\u0435\u0442");
                noEndBtn.addActionListener(e -> cancelButtonActionPerformed());
                buttonBar.add(noEndBtn);
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //======== countcashdialog ========
        {
            Container countcashdialogContentPane = countcashdialog.getContentPane();
            countcashdialogContentPane.setLayout(new GridLayout());

            //======== dialogPane2 ========
            {
                dialogPane2.setBorder(new EmptyBorder(12, 12, 12, 12));

                // JFormDesigner evaluation mark
                dialogPane2.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), dialogPane2.getBorder())); dialogPane2.addPropertyChangeListener(e -> {if("border".equals(e.getPropertyName()))throw new RuntimeException();});

                dialogPane2.setLayout(new BorderLayout());

                //======== contentPanel2 ========
                {

                    //---- textlabel2 ----
                    textlabel2.setText("\u041f\u043e\u0434\u0441\u0447\u0438\u0442\u0430\u0442\u044c \u043a\u0430\u0441\u0441\u0443?");
                    textlabel2.setPreferredSize(new Dimension(303, 26));

                    GroupLayout contentPanel2Layout = new GroupLayout(contentPanel2);
                    contentPanel2.setLayout(contentPanel2Layout);
                    contentPanel2Layout.setHorizontalGroup(
                        contentPanel2Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, contentPanel2Layout.createSequentialGroup()
                                .addContainerGap(93, Short.MAX_VALUE)
                                .addComponent(textlabel2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87))
                    );
                    contentPanel2Layout.setVerticalGroup(
                        contentPanel2Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, contentPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(textlabel2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
                    );
                }
                dialogPane2.add(contentPanel2, BorderLayout.CENTER);

                //======== buttonBar2 ========
                {
                    buttonBar2.setBorder(new EmptyBorder(12, 0, 0, 0));
                    buttonBar2.setLayout(new GridLayout());

                    //---- okCountbtn ----
                    okCountbtn.setText("\u0414\u0430");
                    okCountbtn.addActionListener(e ->okButton2ActionPerformed());
                    buttonBar2.add(okCountbtn);

                    //---- noCountBtn ----
                    noCountBtn.setText("\u041d\u0435\u0442");
                    noCountBtn.addActionListener(e -> {
			cancelButtonActionPerformed();
			cancelButton2ActionPerformed();
		});
                    buttonBar2.add(noCountBtn);
                }
                dialogPane2.add(buttonBar2, BorderLayout.SOUTH);
            }
            countcashdialogContentPane.add(dialogPane2);
            countcashdialog.pack();
            countcashdialog.setLocationRelativeTo(countcashdialog.getOwner());
        }

        //======== printdialog ========
        {
            Container printdialogContentPane = printdialog.getContentPane();
            printdialogContentPane.setLayout(new GridLayout());

            //======== dialogPane3 ========
            {
                dialogPane3.setBorder(new EmptyBorder(12, 12, 12, 12));

                // JFormDesigner evaluation mark
                dialogPane3.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), dialogPane3.getBorder())); dialogPane3.addPropertyChangeListener(e -> {if("border".equals(e.getPropertyName()))throw new RuntimeException();});

                dialogPane3.setLayout(new BorderLayout());

                //======== contentPanel3 ========
                {

                    //---- textlabel3 ----
                    textlabel3.setText("\u041d\u0430\u043f\u0435\u0447\u0430\u0442\u0430\u0442\u044c \u043e\u0442\u0447\u0435\u0442?");
                    textlabel3.setPreferredSize(new Dimension(303, 26));

                    GroupLayout contentPanel3Layout = new GroupLayout(contentPanel3);
                    contentPanel3.setLayout(contentPanel3Layout);
                    contentPanel3Layout.setHorizontalGroup(
                        contentPanel3Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, contentPanel3Layout.createSequentialGroup()
                                .addContainerGap(107, Short.MAX_VALUE)
                                .addComponent(textlabel3, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))
                    );
                    contentPanel3Layout.setVerticalGroup(
                        contentPanel3Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, contentPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(textlabel3, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
                    );
                }
                dialogPane3.add(contentPanel3, BorderLayout.CENTER);

                //======== buttonBar3 ========
                {
                    buttonBar3.setBorder(new EmptyBorder(12, 0, 0, 0));
                    buttonBar3.setLayout(new GridLayout());

                    //---- okPrintBtn ----
                    okPrintBtn.setText("\u0414\u0430");
                    okPrintBtn.addActionListener(e ->okButton3ActionPerformed());
                    buttonBar3.add(okPrintBtn);

                    //---- noPrintBtn ----
                    noPrintBtn.setText("\u041d\u0435\u0442");
                    noPrintBtn.addActionListener(e -> {
			cancelButtonActionPerformed();
			cancelButton2ActionPerformed();
			cancelButton3ActionPerformed();
		});
                    buttonBar3.add(noPrintBtn);
                }
                dialogPane3.add(buttonBar3, BorderLayout.SOUTH);
            }
            printdialogContentPane.add(dialogPane3);
            printdialog.pack();
            printdialog.setLocationRelativeTo(printdialog.getOwner());
        }

        //======== countcashdialog2 ========
        {
            Container countcashdialog2ContentPane = countcashdialog2.getContentPane();
            countcashdialog2ContentPane.setLayout(new GridLayout());

            //======== dialogPane4 ========
            {
                dialogPane4.setBorder(new EmptyBorder(12, 12, 12, 12));

                // JFormDesigner evaluation mark
                dialogPane4.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), dialogPane4.getBorder())); dialogPane4.addPropertyChangeListener(e -> {if("border".equals(e.getPropertyName()))throw new RuntimeException();});

                dialogPane4.setLayout(new BorderLayout());

                //======== contentPanel4 ========
                {

                    //---- label1 ----
                    label1.setText("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0441\u0443\u043c\u043c\u0443 :");

                    GroupLayout contentPanel4Layout = new GroupLayout(contentPanel4);
                    contentPanel4.setLayout(contentPanel4Layout);
                    contentPanel4Layout.setHorizontalGroup(
                        contentPanel4Layout.createParallelGroup()
                            .addGroup(contentPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(27, Short.MAX_VALUE))
                    );
                    contentPanel4Layout.setVerticalGroup(
                        contentPanel4Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, contentPanel4Layout.createSequentialGroup()
                                .addContainerGap(11, Short.MAX_VALUE)
                                .addGroup(contentPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                    );
                }
                dialogPane4.add(contentPanel4, BorderLayout.CENTER);

                //======== buttonBar4 ========
                {
                    buttonBar4.setBorder(new EmptyBorder(12, 0, 0, 0));
                    buttonBar4.setLayout(new GridLayout());

                    //---- okSummBtn ----
                    okSummBtn.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c");
                    okSummBtn.addActionListener(e -> {

			okButton2ActionPerformed();
			okButton4ActionPerformed();
		});
                    buttonBar4.add(okSummBtn);
                }
                dialogPane4.add(buttonBar4, BorderLayout.SOUTH);
            }
            countcashdialog2ContentPane.add(dialogPane4);
            countcashdialog2.pack();
            countcashdialog2.setLocationRelativeTo(countcashdialog2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private JDialog countcashdialog;
    private JDialog printdialog;
    private JDialog countcashdialog2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
