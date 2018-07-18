/*
 * Created by JFormDesigner on Wed Jul 18 13:46:35 CEST 2018
 */

package Models;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Gevtsi Yurii
 */
public class FinishWork extends JDialog {
    public FinishWork(Frame owner) {
        super(owner);
        initComponents();
    }

    public FinishWork(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void okEndBtnActionPerformed(ActionEvent e) {
        this.dispose();
        countcashdialog.setVisible(true);
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void okButton2ActionPerformed(ActionEvent e) {
        countcashdialog.dispose();
        countcashdialog2.setVisible(true);
    }

    private void cancelButton2ActionPerformed(ActionEvent e) {
        countcashdialog.dispose();
        printdialog.setVisible(true);
    }

    private void okButton3ActionPerformed(ActionEvent e) {
        printdialog.dispose();
        JOptionPane.showMessageDialog(this,"Смена закончена","",JOptionPane.INFORMATION_MESSAGE);
    }

    private void cancelButton3ActionPerformed(ActionEvent e) {
        printdialog.dispose();
        JOptionPane.showMessageDialog(this,"Смена закончена","",JOptionPane.INFORMATION_MESSAGE);
    }

    private void okButton4ActionPerformed(ActionEvent e) {
        countcashdialog2.dispose();
        printdialog.setVisible(true);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        textlabel = new JLabel();
        buttonBar = new JPanel();
        okEndBtn = new JButton();
        noEndBtn = new JButton();
        countcashdialog = new JDialog();
        dialogPane2 = new JPanel();
        contentPanel2 = new JPanel();
        textlabel2 = new JLabel();
        buttonBar2 = new JPanel();
        okCountbtn = new JButton();
        noCountBtn = new JButton();
        printdialog = new JDialog();
        dialogPane3 = new JPanel();
        contentPanel3 = new JPanel();
        textlabel3 = new JLabel();
        buttonBar3 = new JPanel();
        okPrintBtn = new JButton();
        noPrintBtn = new JButton();
        countcashdialog2 = new JDialog();
        dialogPane4 = new JPanel();
        contentPanel4 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        buttonBar4 = new JPanel();
        okSummBtn = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

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
                okEndBtn.addActionListener(e -> {
			okButtonActionPerformed(e);
			okEndBtnActionPerformed(e);
			okEndBtnActionPerformed(e);
		});
                buttonBar.add(okEndBtn);

                //---- noEndBtn ----
                noEndBtn.setText("\u041d\u0435\u0442");
                noEndBtn.addActionListener(e -> cancelButtonActionPerformed(e));
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
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), dialogPane2.getBorder())); dialogPane2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

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
                    okCountbtn.addActionListener(e -> {
			okButtonActionPerformed(e);
			okButton2ActionPerformed(e);
		});
                    buttonBar2.add(okCountbtn);

                    //---- noCountBtn ----
                    noCountBtn.setText("\u041d\u0435\u0442");
                    noCountBtn.addActionListener(e -> {
			cancelButtonActionPerformed(e);
			cancelButton2ActionPerformed(e);
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
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), dialogPane3.getBorder())); dialogPane3.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

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
                    okPrintBtn.addActionListener(e -> {
			okButtonActionPerformed(e);
			okButton3ActionPerformed(e);
			okButton3ActionPerformed(e);
		});
                    buttonBar3.add(okPrintBtn);

                    //---- noPrintBtn ----
                    noPrintBtn.setText("\u041d\u0435\u0442");
                    noPrintBtn.addActionListener(e -> {
			cancelButtonActionPerformed(e);
			cancelButton2ActionPerformed(e);
			cancelButton3ActionPerformed(e);
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
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), dialogPane4.getBorder())); dialogPane4.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

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
			okButtonActionPerformed(e);
			okButton2ActionPerformed(e);
			okButton4ActionPerformed(e);
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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel textlabel;
    private JPanel buttonBar;
    private JButton okEndBtn;
    private JButton noEndBtn;
    private JDialog countcashdialog;
    private JPanel dialogPane2;
    private JPanel contentPanel2;
    private JLabel textlabel2;
    private JPanel buttonBar2;
    private JButton okCountbtn;
    private JButton noCountBtn;
    private JDialog printdialog;
    private JPanel dialogPane3;
    private JPanel contentPanel3;
    private JLabel textlabel3;
    private JPanel buttonBar3;
    private JButton okPrintBtn;
    private JButton noPrintBtn;
    private JDialog countcashdialog2;
    private JPanel dialogPane4;
    private JPanel contentPanel4;
    private JLabel label1;
    private JTextField textField1;
    private JPanel buttonBar4;
    private JButton okSummBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
