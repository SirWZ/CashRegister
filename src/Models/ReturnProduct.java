/*
 * Created by JFormDesigner on Sun Jul 15 10:58:39 CEST 2018
 */

package Models;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Gevtsi Yurii
 */
class ReturnProduct extends JFrame {

    Connection cn;
    int pargon;
    ReturnProduct(Connection cn) {
        this.cn = cn;
        initComponents();
        firstdialog.setVisible(true);
        this.dispose();
    }

    private void returnbtnActionPerformed() {
        String name, reson;
        double price, count, returned;

        for (int i = 0; i<producttable.getModel().getRowCount(); i++){
           if(producttable.getModel().getValueAt(i,3)!=null){
               try {
                   returned = Double.parseDouble(producttable.getModel().getValueAt(i, 4).toString());
                   name = producttable.getModel().getValueAt(i, 0).toString();
                   price = Double.parseDouble(producttable.getModel().getValueAt(i, 3).toString());
               }catch (Exception e){
                   JOptionPane.showMessageDialog(this,"Неверное значение","Ошибка",JOptionPane.ERROR_MESSAGE);
               }

           }
        }
        System.out.println(producttable.getModel().getValueAt(1,3));
        this.dispose();
    }

    private void exitbtn2ActionPerformed() {
        firstdialog.dispose();
    }

    private void nextbtn2ActionPerformed() {
        try {
            pargon = Integer.parseInt(pargonnumtextfield.getText());
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"Неверное значение","Ошибка",JOptionPane.ERROR_MESSAGE);
            pargonnumtextfield.setText("");
            return;
        }
        try{
            PreparedStatement pr;
            ResultSet rs;
            pr = cn.prepareStatement("select idselling from \"Selling_Operation\" where idselling = ?");
            pr.setInt(1,pargon);
            rs = pr.executeQuery();
            pr.clearBatch();
            if (rs.next()){
                pr = cn.prepareStatement("select  pr.name, b.\"Count\" , p.price from \"Product\" pr,\"Bucket\" b, \"Price\" p where b.\"idSelling\" = ? and p.\"idProduct\" = b.\"idProduct\" and  pr.\"idProduct\" = b.\"idProduct\" group by pr.name,b.\"Count\", p.price");
                pr.setInt(1,pargon);
                rs = pr.executeQuery();
                while (rs.next()){
                    double price = rs.getDouble(3);
                    double count = rs.getDouble(2);
                    ((DefaultTableModel)producttable.getModel()).addRow( new Object[]{rs.getString(1), count,price, count*price} );
                }

                firstdialog.dispose();
                this.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(this,"Чек не найден","Ошибка",JOptionPane.ERROR_MESSAGE);
                pargonnumtextfield.setText("");
                return;
            }

        }catch (Exception e){

        }

    }

    private void exitbtnActionPerformed() {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yurii
        findbtn = new JTextField();
        scrollPane1 = new JScrollPane();
        producttable = new JTable();
        returnbtn = new JButton();
        exitbtn = new JButton();
        firstdialog = new JDialog();
        label1 = new JLabel();
        pargonnumtextfield = new JTextField();
        exitbtn2 = new JButton();
        nextbtn2 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        //---- findbtn ----
        findbtn.setText("\u041f\u043e\u0438\u0441\u043a \u0442\u043e\u0432\u0430\u0440\u0430 \u0432 \u0447\u0435\u043a\u0435");

        //======== scrollPane1 ========
        {

            //---- producttable ----
            producttable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435", "\u041a\u043e\u043b\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e", "\u0426\u0435\u043d\u0430", "\u0421\u0443\u043c\u043c\u0430", "\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0432\u043e\u0437\u0440\u0430\u0442\u0430", "\u041f\u0440\u0438\u0447\u0438\u043d\u0430(\u043e\u043f\u0446\u0438\u043e\u043d\u0430\u043b\u044c\u043d\u043e)"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    String.class, Double.class, Double.class, Double.class, Double.class, String.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            {
                TableColumnModel cm = producttable.getColumnModel();
                cm.getColumn(0).setPreferredWidth(265);
                cm.getColumn(4).setPreferredWidth(120);
                cm.getColumn(5).setPreferredWidth(150);
            }
            scrollPane1.setViewportView(producttable);
        }

        //---- returnbtn ----
        returnbtn.setText("\u0412\u0435\u0440\u043d\u0443\u0442\u044c \u0442\u043e\u0432\u0430\u0440\u044b");
        returnbtn.addActionListener(e -> returnbtnActionPerformed());

        //---- exitbtn ----
        exitbtn.setText("\u0412\u044b\u0445\u043e\u0434");
        exitbtn.addActionListener(e -> exitbtnActionPerformed());

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(560, 560, 560)
                            .addComponent(returnbtn, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(115, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(exitbtn, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
                                    .addComponent(findbtn, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)))
                            .addGap(68, 68, 68))))
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

        //======== firstdialog ========
        {
            var firstdialogContentPane = firstdialog.getContentPane();

            //---- label1 ----
            label1.setText("\u041d\u043e\u043c\u0435\u0440 \u0447\u0435\u043a\u0430");

            //---- exitbtn2 ----
            exitbtn2.setText("\u0412\u044b\u0445\u043e\u0434");
            exitbtn2.addActionListener(e -> exitbtn2ActionPerformed());

            //---- nextbtn2 ----
            nextbtn2.setText("\u0414\u0430\u043b\u0435");
            nextbtn2.addActionListener(e -> nextbtn2ActionPerformed());

            GroupLayout firstdialogContentPaneLayout = new GroupLayout(firstdialogContentPane);
            firstdialogContentPane.setLayout(firstdialogContentPaneLayout);
            firstdialogContentPaneLayout.setHorizontalGroup(
                firstdialogContentPaneLayout.createParallelGroup()
                    .addGroup(firstdialogContentPaneLayout.createSequentialGroup()
                        .addGroup(firstdialogContentPaneLayout.createParallelGroup()
                            .addGroup(firstdialogContentPaneLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pargonnumtextfield, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
                            .addGroup(firstdialogContentPaneLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(exitbtn2)))
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, firstdialogContentPaneLayout.createSequentialGroup()
                        .addGap(0, 372, Short.MAX_VALUE)
                        .addComponent(nextbtn2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
            );
            firstdialogContentPaneLayout.setVerticalGroup(
                firstdialogContentPaneLayout.createParallelGroup()
                    .addGroup(firstdialogContentPaneLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(exitbtn2)
                        .addGap(18, 18, 18)
                        .addGroup(firstdialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addComponent(pargonnumtextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(nextbtn2)
                        .addContainerGap(23, Short.MAX_VALUE))
            );
            firstdialog.pack();
            firstdialog.setLocationRelativeTo(firstdialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yurii
    private JTextField findbtn;
    private JScrollPane scrollPane1;
    private JTable producttable;
    private JButton returnbtn;
    private JButton exitbtn;
    private JDialog firstdialog;
    private JLabel label1;
    private JTextField pargonnumtextfield;
    private JButton exitbtn2;
    private JButton nextbtn2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
