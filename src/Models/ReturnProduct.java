/*
 * Created by JFormDesigner on Sun Jul 15 10:58:39 CEST 2018
 */

package Models;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Gevtsi Yurii
 */
class ReturnProduct extends JFrame {
    ReturnProduct() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
        findbtn = new JTextField();
        scrollPane1 = new JScrollPane();
        producttable = new JTable();
        returnbtn = new JButton();
        exitbtn = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- findbtn ----
        findbtn.setText("\u041f\u043e\u0438\u0441\u043a \u0442\u043e\u0432\u0430\u0440\u0430 \u0432 \u0447\u0435\u043a\u0435");

        //======== scrollPane1 ========
        {

            //---- producttable ----
            producttable.setModel(new DefaultTableModel(
                new Object[][] {
                    {"", "", "", "", ""},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    "\u0422\u043e\u0432\u0430\u0440", "\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e", "\u0426\u0435\u043d\u0430", "\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0432\u043e\u0437\u0432\u0440\u0430\u0442\u0430", "\u041f\u0440\u0438\u0447\u0438\u043d\u0430(\u043e\u043f\u0446\u0438\u043e\u043d\u0430\u043b\u044c\u043d\u043e)"
                }
            ));
            {
                TableColumnModel cm = producttable.getColumnModel();
                cm.getColumn(3).setPreferredWidth(150);
                cm.getColumn(4).setPreferredWidth(155);
            }
            scrollPane1.setViewportView(producttable);
        }

        //---- returnbtn ----
        returnbtn.setText("\u0412\u0435\u0440\u043d\u0443\u0442\u044c \u0442\u043e\u0432\u0430\u0440\u044b");

        //---- exitbtn ----
        exitbtn.setText("\u0422\u0443\u0442 \u0431\u0443\u0434\u0435\u0442 \u0438\u043a\u043e\u043d\u043a\u0430");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(exitbtn, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
                    .addComponent(findbtn, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
                    .addGap(68, 68, 68))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(97, 97, 97)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(returnbtn, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 646, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(115, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(findbtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(exitbtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
                    .addGap(42, 42, 42)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                    .addGap(47, 47, 47)
                    .addComponent(returnbtn)
                    .addContainerGap(23, Short.MAX_VALUE))
        );
        setSize(860, 380);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
    private JTextField findbtn;
    private JScrollPane scrollPane1;
    private JTable producttable;
    private JButton returnbtn;
    private JButton exitbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
