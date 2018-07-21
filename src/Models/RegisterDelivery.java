/*
 * Created by JFormDesigner on Sat Jul 21 17:45:14 CEST 2018
 */

package Models;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import static java.lang.Integer.parseInt;

/**
 * @author Gevtsi Yurii
 */
public class RegisterDelivery extends JFrame {
    public RegisterDelivery() {
        initComponents();
        deliverydialog.setVisible(true);
    }


    private void deliveryCodetextFieldKeyPressed(KeyEvent e) {
        ActionEvent k = null;
        if (e.getKeyCode()==27)deliverydialog.dispose();
        if (e.getKeyCode()==10){
            if (deliveryCodetextField.getText().isEmpty())skipbtnActionPerformed(k);
            else{
                okbtnActionPerformed(k);
            }

        }
    }

    private void skipbtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void okbtnActionPerformed(ActionEvent e) {
        try{
            if (parseInt(deliveryCodetextField.getText())>0){
                deliverydialog.dispose();
                this.setVisible(true);
            }else JOptionPane.showMessageDialog(this,"Неверный формат2","Ошибка",JOptionPane.ERROR_MESSAGE);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this,"Неверный формат","Ошибка",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
        panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        deliverytable = new JTable();
        deliverydialog = new JDialog();
        label1 = new JLabel();
        deliveryCodetextField = new JTextField();
        skipbtn = new JButton();
        okbtn = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2, 0));

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {139, 244, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {97, 81, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

            //---- label2 ----
            label2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            label2.setText("\u041d\u043e\u043c\u0435\u0440 \u0434\u043e\u0441\u0442\u0430\u0432\u043a\u0438");
            panel1.add(label2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label3 ----
            label3.setText("\u041f\u043e\u0441\u0442\u0430\u0432\u0449\u0438\u043a");
            label3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            panel1.add(label3, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel1);

        //======== panel2 ========
        {
            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {139, 445, 0};
            ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
            ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {1.0, 0.0, 0.0, 1.0E-4};

            //======== scrollPane1 ========
            {

                //---- deliverytable ----
                deliverytable.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                    },
                    new String[] {
                        "\u0422\u043e\u0432\u0430\u0440", "\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e", "\u0426\u0435\u043d\u0430, \u0433\u0440\u043d", "\u0426\u0435\u043d\u0430 \u0441 \u041d\u0414\u0421, \u0433\u0440\u043d"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        String.class, Double.class, Double.class, Double.class
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = deliverytable.getColumnModel();
                    cm.getColumn(0).setPreferredWidth(200);
                    cm.getColumn(3).setPreferredWidth(100);
                }
                deliverytable.setMinimumSize(new Dimension(450, 128));
                deliverytable.setRowHeight(20);
                deliverytable.setFont(new Font("Segoe UI", Font.PLAIN, 20));
                scrollPane1.setViewportView(deliverytable);
            }
            panel2.add(scrollPane1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        }
        contentPane.add(panel2);
        setSize(700, 360);
        setLocationRelativeTo(getOwner());

        //======== deliverydialog ========
        {
            deliverydialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Container deliverydialogContentPane = deliverydialog.getContentPane();
            deliverydialogContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)deliverydialogContentPane.getLayout()).columnWidths = new int[] {0, 127, 146, 0};
            ((GridBagLayout)deliverydialogContentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
            ((GridBagLayout)deliverydialogContentPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0, 1.0E-4};
            ((GridBagLayout)deliverydialogContentPane.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0, 1.0E-4};

            //---- label1 ----
            label1.setText("\u041d\u043e\u043c\u0435\u0440 \u0434\u043e\u0441\u0442\u0430\u0432\u043a\u0438");
            label1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            deliverydialogContentPane.add(label1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- deliveryCodetextField ----
            deliveryCodetextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            deliveryCodetextField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    deliveryCodetextFieldKeyPressed(e);
                }
            });
            deliverydialogContentPane.add(deliveryCodetextField, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- skipbtn ----
            skipbtn.setText("\u041f\u0440\u043e\u043f\u0443\u0441\u0442\u0438\u0442\u044c");
            skipbtn.addActionListener(e -> skipbtnActionPerformed(e));
            deliverydialogContentPane.add(skipbtn, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- okbtn ----
            okbtn.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c");
            okbtn.addActionListener(e -> okbtnActionPerformed(e));
            deliverydialogContentPane.add(okbtn, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            deliverydialog.setSize(615, 230);
            deliverydialog.setLocationRelativeTo(deliverydialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
    private JPanel panel1;
    private JLabel label2;
    private JLabel label3;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTable deliverytable;
    private JDialog deliverydialog;
    private JLabel label1;
    private JTextField deliveryCodetextField;
    private JButton skipbtn;
    private JButton okbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
