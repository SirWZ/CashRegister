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
        if (e.getKeyCode()==27)deliverydialog.dispose();
        if (e.getKeyCode()==10){
            if (deliveryCodetextField.getText().isEmpty())skipbtnActionPerformed();
            else{
                okbtnActionPerformed();
            }

        }
    }

    private void skipbtnActionPerformed() {
        deliverydialog.dispose();
        numdeliverytextField.setEditable(true);
        producentField.setEditable(true);
        this.setVisible(true);
        System.out.println(this.getHeight() + " " + this.getWidth());
    }

    private void okbtnActionPerformed() {
        try{
            if (parseInt(deliveryCodetextField.getText())>0){
                deliverydialog.dispose();
                numdeliverytextField.setText(deliveryCodetextField.getText());
                this.setVisible(true);
            }else JOptionPane.showMessageDialog(this,"Неверный формат2","Ошибка",JOptionPane.ERROR_MESSAGE);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this,"Неверный формат","Ошибка",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void nobtnMouseClicked() {
        this.dispose();
    }

    private void registerbtnMouseClicked() {
        this.dispose();
        JOptionPane.showMessageDialog(this,"Доставка зарегистрирована и подтверждена.","",JOptionPane.INFORMATION_MESSAGE);
    }

    private void paybtnMouseClicked() {
        this.dispose();
        JOptionPane.showMessageDialog(this,"Доставка зарегистрирована без подтверждения.","",JOptionPane.INFORMATION_MESSAGE);
        new CashInOut("Выплата").setVisible(true);
    }

    private void registerandpaybtnMouseClicked() {
        this.dispose();
        JOptionPane.showMessageDialog(this,"Доставка зарегистрирована и подтверждена.","",JOptionPane.INFORMATION_MESSAGE);
        new CashInOut("Выплата").setVisible(true);    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
        panel1 = new JPanel();
        numdeliverylabel = new JLabel();
        numdeliverytextField = new JTextField();
        producentlabel = new JLabel();
        producentField = new JTextField();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        deliverytable = new JTable();
        panel3 = new JPanel();
        nobtn = new JButton();
        registerbtn = new JButton();
        registerandpaybtn = new JButton();
        paybtn = new JButton();
        deliverydialog = new JDialog();
        label1 = new JLabel();
        deliveryCodetextField = new JTextField();
        skipbtn = new JButton();
        okbtn = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(1000, 435));
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {115, 149, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 1.0, 0.0, 0.0, 1.0E-4};

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {69, 247, 288, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {56, 60, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

            //---- numdeliverylabel ----
            numdeliverylabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            numdeliverylabel.setText("\u041d\u043e\u043c\u0435\u0440 \u0434\u043e\u0441\u0442\u0430\u0432\u043a\u0438");
            panel1.add(numdeliverylabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 5, 3), 0, 0));

            //---- numdeliverytextField ----
            numdeliverytextField.setEditable(false);
            panel1.add(numdeliverytextField, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- producentlabel ----
            producentlabel.setText("\u041f\u043e\u0441\u0442\u0430\u0432\u0449\u0438\u043a");
            producentlabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            panel1.add(producentlabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 3), 0, 0));

            //---- producentField ----
            producentField.setEditable(false);
            panel1.add(producentField, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== panel2 ========
        {
            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {81, 597, 86, 0};
            ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

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
                deliverytable.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                scrollPane1.setViewportView(deliverytable);
            }
            panel2.add(scrollPane1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        }
        contentPane.add(panel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== panel3 ========
        {
            panel3.setLayout(new GridBagLayout());
            ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0, 0, 32, 195, 38, 0, 35, 0, 0, 0};
            ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

            //---- nobtn ----
            nobtn.setText("\u041e\u0442\u043c\u0435\u043d\u0430");
            nobtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    nobtnMouseClicked();
                }
            });
            panel3.add(nobtn, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- registerbtn ----
            registerbtn.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u0435 \u0431\u0435\u0437 \u043e\u043f\u043b\u0430\u0442\u044b");
            registerbtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    registerbtnMouseClicked();
                }
            });
            panel3.add(registerbtn, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- registerandpaybtn ----
            registerandpaybtn.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u0435 \u0438 \u043e\u043f\u043b\u0430\u0442\u0430");
            registerandpaybtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    registerandpaybtnMouseClicked();
                }
            });
            panel3.add(registerandpaybtn, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- paybtn ----
            paybtn.setText("\u041e\u043f\u043b\u0430\u0442\u0430 \u0431\u0435\u0437 \u043f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u044f");
            paybtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    paybtnMouseClicked();
                }
            });
            panel3.add(paybtn, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        }
        contentPane.add(panel3, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        setSize(815, 435);
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
            skipbtn.addActionListener(e -> skipbtnActionPerformed());
            deliverydialogContentPane.add(skipbtn, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- okbtn ----
            okbtn.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c");
            okbtn.addActionListener(e -> okbtnActionPerformed());
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
    private JLabel numdeliverylabel;
    private JTextField numdeliverytextField;
    private JLabel producentlabel;
    private JTextField producentField;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTable deliverytable;
    private JPanel panel3;
    private JButton nobtn;
    private JButton registerbtn;
    private JButton registerandpaybtn;
    private JButton paybtn;
    private JDialog deliverydialog;
    private JLabel label1;
    private JTextField deliveryCodetextField;
    private JButton skipbtn;
    private JButton okbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
