/*
 * Created by JFormDesigner on Wed Aug 22 16:50:01 CEST 2018
 */

package Models;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Properties;

/**
 * @author Yurii
 */
public class CreateDelivery extends JFrame {
    public CreateDelivery() {
        initComponents();
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Сегодня");
        p.put("text.month", "Месяц");
        p.put("text.year", "Год");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel, new DateComponentFormatter());

        firstpanel.add(datePicker, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        panel4.add(datePicker2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
    }

    private void addrowBtnActionPerformed() {
        ((DefaultTableModel)table.getModel()).addRow(new Object[]{});
    }

    private void deleteBtnActionPerformed() {
            ((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
    }

    private void payBtnActionPerformed() {
        double summ=0;
        double summNDS=0;
        for (int i =0; i< table.getRowCount();i++){
            if (table.getModel().getValueAt(i, 2)!=null && table.getModel().getValueAt(i, 4)!=null && table.getModel().getValueAt(i, 5)!=null) {
                double count = (double) table.getModel().getValueAt(i, 2);
                double price = (double) table.getModel().getValueAt(i, 4);
                double nds = (double) table.getModel().getValueAt(i, 5);
                summ += count * price;
                summNDS+=nds*count;
                table.getModel().setValueAt(count * price,i,6);
                table.getModel().setValueAt(nds*count,i,7);
            }
        }

        summlbl.setText(summ + "");
        ndslbl.setText(summNDS +"");
        countlbl.setText(summ+ summNDS+"");
    }

    private void tableKeyPressed(KeyEvent e) {
        if (e.getKeyCode()==10) System.out.println("jjjjjjjj");

        if (table.getSelectedRow()==4){ System.out.println("ooooooo");

            }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yurii
        var vSpacer1 = new JPanel(null);
        firstpanel = new JPanel();
        exitBtn = new JButton();
        var numlabel = new JLabel();
        numbertextField = new JTextField();
        datelbl = new JLabel();
        noBtn = new JButton();
        printBtn = new JButton();
        var deliverylbl = new JLabel();
        deliverytextField = new JTextField();
        var numdelLbl = new JLabel();
        deliveryNumtextField = new JTextField();
        var contactlbl = new JLabel();
        contacttextField = new JTextField();
        var secondpanel = new JPanel();
        addrowBtn = new JButton();
        deleteBtn = new JButton();
        upBtn = new JButton();
        downbtn = new JButton();
        writepricebtn = new JButton();
        addComentBtn = new JButton();
        payBtn = new JButton();
        anotherBtn = new JButton();
        var tablepanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        panel4 = new JPanel();
        checkBox = new JCheckBox();
        var lastpanel = new JPanel();
        var panel5 = new JPanel();
        var itogolbl = new JLabel();
        var etapslbl = new JLabel();
        var suminfolbl = new JLabel();
        summlbl = new JLabel();
        var avansinfolbl = new JLabel();
        avanslbl = new JLabel();
        var ndsinfolbl = new JLabel();
        ndslbl = new JLabel();
        var nextinfolbl = new JLabel();
        ondeliverlbl = new JLabel();
        var countinfolbl = new JLabel();
        countlbl = new JLabel();
        var creditinfo = new JLabel();
        creditlbl = new JLabel();
        var panel7 = new JPanel();
        okbtn = new JButton();
        var vSpacer2 = new JPanel(null);

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {29, 0, 0, 113, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0E-4};
        contentPane.add(vSpacer1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== firstpanel ========
        {

            // JFormDesigner evaluation mark
            firstpanel.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), firstpanel.getBorder())); firstpanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            firstpanel.setLayout(new GridBagLayout());
            ((GridBagLayout)firstpanel.getLayout()).columnWidths = new int[] {70, 66, 193, 0, 159, 0, 0, 0};
            ((GridBagLayout)firstpanel.getLayout()).rowHeights = new int[] {0, 0, 0};
            ((GridBagLayout)firstpanel.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};
            ((GridBagLayout)firstpanel.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

            //---- exitBtn ----
            exitBtn.setText("\u041a\u0440\u0435\u0441\u0442\u0438\u043a");
            firstpanel.add(exitBtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- numlabel ----
            numlabel.setText("\u041d\u043e\u043c\u0435\u0440");
            numlabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
            firstpanel.add(numlabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 5, 5), 0, 0));
            firstpanel.add(numbertextField, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- datelbl ----
            datelbl.setText("\u041e\u0442");
            datelbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
            firstpanel.add(datelbl, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- noBtn ----
            noBtn.setText("\u041e\u0442\u043b\u043e\u0436\u0438\u0442\u044c");
            firstpanel.add(noBtn, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- printBtn ----
            printBtn.setText("\u041f\u0440\u0438\u043d\u0442\u0435\u0440");
            firstpanel.add(printBtn, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- deliverylbl ----
            deliverylbl.setText("\u041f\u043e\u0441\u0442\u0430\u0432\u0449\u0438\u043a");
            deliverylbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
            firstpanel.add(deliverylbl, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));
            firstpanel.add(deliverytextField, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- numdelLbl ----
            numdelLbl.setText("\u041d\u043e\u043c\u0435\u0440 \u0434\u043e\u0441\u0442\u0430\u0432\u043a\u0438");
            numdelLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
            firstpanel.add(numdelLbl, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));
            firstpanel.add(deliveryNumtextField, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- contactlbl ----
            contactlbl.setText("\u041a\u043e\u043d\u0442\u0430\u043a\u0442\u044b");
            contactlbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
            firstpanel.add(contactlbl, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));
            firstpanel.add(contacttextField, new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(firstpanel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== secondpanel ========
        {
            secondpanel.setLayout(new GridBagLayout());
            ((GridBagLayout)secondpanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
            ((GridBagLayout)secondpanel.getLayout()).rowHeights = new int[] {0, 0, 0};
            ((GridBagLayout)secondpanel.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};
            ((GridBagLayout)secondpanel.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

            //---- addrowBtn ----
            addrowBtn.setText("\u041f\u043b\u044e\u0441");
            addrowBtn.addActionListener(e -> addrowBtnActionPerformed());
            secondpanel.add(addrowBtn, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- deleteBtn ----
            deleteBtn.setText("\u041a\u0440\u0435\u0441\u0442\u0438\u043a");
            deleteBtn.addActionListener(e -> deleteBtnActionPerformed());
            secondpanel.add(deleteBtn, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- upBtn ----
            upBtn.setText("\u0412\u0432\u0435\u0440\u0445");
            secondpanel.add(upBtn, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- downbtn ----
            downbtn.setText("\u0412\u043d\u0438\u0437");
            secondpanel.add(downbtn, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- writepricebtn ----
            writepricebtn.setText("\u0417\u0430\u043f\u043e\u043b\u043d\u0438\u0442\u044c \u043f\u0443\u0441\u0442\u043e\u0442\u0443 \u0432\u043d\u0443\u0442\u0440\u0438 \u043c\u0435\u043d\u044f");
            secondpanel.add(writepricebtn, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- addComentBtn ----
            addComentBtn.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u043a\u043e\u043c\u0435\u043d\u0442\u0430\u0440\u0438\u0439");
            secondpanel.add(addComentBtn, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- payBtn ----
            payBtn.setText("\u041e\u043f\u043b\u0430\u0442\u0430");
            payBtn.addActionListener(e -> payBtnActionPerformed());
            secondpanel.add(payBtn, new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- anotherBtn ----
            anotherBtn.setText("\u0414\u043e\u043f\u043e\u043b\u043d\u0438\u0442\u0435\u043b\u044c\u043d\u043e");
            secondpanel.add(anotherBtn, new GridBagConstraints(7, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(secondpanel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== tablepanel ========
        {
            tablepanel.setLayout(new GridBagLayout());
            ((GridBagLayout)tablepanel.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)tablepanel.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)tablepanel.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)tablepanel.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

            //======== scrollPane1 ========
            {

                //---- table ----
                table.setModel(new DefaultTableModel(
                    new Object[][] {
                        {1, "Cocaine", 1.0, "gramm", 200.0, 20.0, null, null},
                        {2, "Slut", 2.0, "girl", 400.0, 1.0, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                    },
                    new String[] {
                        "\u041d\u043e\u043c\u0435\u0440", "\u0422\u043e\u0432\u0430\u0440", "\u041a\u043e\u043b-\u0432\u043e", "\u0415\u0434.\u0438\u0437.", "\u0426\u0435\u043d\u0430\\\u0448\u0442.", "\u0421\u0442\u0430\u0432\u043a\u0430 \u041d\u0414\u0421", "\u0421\u0443\u043c\u043c\u0430", "\u041d\u0414\u0421"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        Integer.class, Object.class, Double.class, String.class, Double.class, Double.class, Double.class, Double.class
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = table.getColumnModel();
                    cm.getColumn(0).setResizable(false);
                    cm.getColumn(1).setResizable(false);
                    cm.getColumn(1).setPreferredWidth(265);
                    cm.getColumn(2).setResizable(false);
                    cm.getColumn(2).setPreferredWidth(55);
                    cm.getColumn(3).setResizable(false);
                    cm.getColumn(3).setPreferredWidth(45);
                    cm.getColumn(4).setResizable(false);
                    cm.getColumn(5).setResizable(false);
                    cm.getColumn(5).setPreferredWidth(70);
                    cm.getColumn(6).setResizable(false);
                    cm.getColumn(6).setPreferredWidth(50);
                    cm.getColumn(7).setResizable(false);
                    cm.getColumn(7).setPreferredWidth(35);
                }
                table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                table.setAutoCreateRowSorter(true);
                table.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        tableKeyPressed(e);
                    }
                });
                scrollPane1.setViewportView(table);
            }
            tablepanel.add(scrollPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(tablepanel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== panel4 ========
        {
            panel4.setLayout(new GridBagLayout());
            ((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {252, 82, 0};
            ((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

            //---- checkBox ----
            checkBox.setText("\u041f\u043e\u0441\u0442\u0443\u043f\u043b\u0435\u043d\u0438\u044f \u043e\u0434\u043d\u043e\u0439 \u0434\u0430\u0442\u043e\u0439");
            checkBox.setFont(new Font("Segoe UI", Font.BOLD, 16));
            panel4.add(checkBox, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        }
        contentPane.add(panel4, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== lastpanel ========
        {
            lastpanel.setLayout(new GridBagLayout());
            ((GridBagLayout)lastpanel.getLayout()).columnWidths = new int[] {0, 0, 0};
            ((GridBagLayout)lastpanel.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)lastpanel.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
            ((GridBagLayout)lastpanel.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

            //======== panel5 ========
            {
                panel5.setLayout(new GridBagLayout());
                ((GridBagLayout)panel5.getLayout()).columnWidths = new int[] {0, 0, 74, 59, 0, 0, 0};
                ((GridBagLayout)panel5.getLayout()).rowHeights = new int[] {42, 0, 0, 0, 0};
                ((GridBagLayout)panel5.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel5.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0E-4};

                //---- itogolbl ----
                itogolbl.setText("\u0418\u0442\u043e\u0433\u043e");
                itogolbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
                panel5.add(itogolbl, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- etapslbl ----
                etapslbl.setText("\u042d\u0442\u0430\u043f\u044b \u043e\u043f\u043b\u0430\u0442\u044b");
                etapslbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
                panel5.add(etapslbl, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- suminfolbl ----
                suminfolbl.setText("\u0421\u0443\u043c\u043c\u0430 :");
                suminfolbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
                panel5.add(suminfolbl, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- summlbl ----
                summlbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
                panel5.add(summlbl, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- avansinfolbl ----
                avansinfolbl.setText("\u0410\u0432\u0430\u043d\u0441");
                avansinfolbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
                panel5.add(avansinfolbl, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                panel5.add(avanslbl, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- ndsinfolbl ----
                ndsinfolbl.setText("\u041d\u0414\u0421 :");
                ndsinfolbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
                panel5.add(ndsinfolbl, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- ndslbl ----
                ndslbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
                panel5.add(ndslbl, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- nextinfolbl ----
                nextinfolbl.setText("\u0412 \u043c\u043e\u043c\u0435\u043d\u0442 \u0434\u043e\u0441\u0442\u0430\u0432\u043a\u0438");
                nextinfolbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
                panel5.add(nextinfolbl, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                panel5.add(ondeliverlbl, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- countinfolbl ----
                countinfolbl.setText("\u0421\u0443\u043c\u043c\u0430 \u0441 \u041d\u0414\u0421 :");
                countinfolbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
                panel5.add(countinfolbl, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- countlbl ----
                countlbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
                panel5.add(countlbl, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- creditinfo ----
                creditinfo.setText("\u041a\u0440\u0435\u0434\u0438\u0442");
                creditinfo.setFont(new Font("Segoe UI", Font.BOLD, 16));
                panel5.add(creditinfo, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));
                panel5.add(creditlbl, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            lastpanel.add(panel5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //======== panel7 ========
            {
                panel7.setLayout(new GridBagLayout());
                ((GridBagLayout)panel7.getLayout()).columnWidths = new int[] {216, 0};
                ((GridBagLayout)panel7.getLayout()).rowHeights = new int[] {85, 0};
                ((GridBagLayout)panel7.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)panel7.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

                //---- okbtn ----
                okbtn.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c \u0437\u0430\u043a\u0430\u0437");
                okbtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
                panel7.add(okbtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            lastpanel.add(panel7, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(lastpanel, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));
        contentPane.add(vSpacer2, new GridBagConstraints(0, 5, 1, 2, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        setSize(945, 600);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yurii
    private JPanel firstpanel;
    private JButton exitBtn;
    private JTextField numbertextField;
    private JLabel datelbl;
    private JButton noBtn;
    private JButton printBtn;
    private JTextField deliverytextField;
    private JTextField deliveryNumtextField;
    private JTextField contacttextField;
    private JButton addrowBtn;
    private JButton deleteBtn;
    private JButton upBtn;
    private JButton downbtn;
    private JButton writepricebtn;
    private JButton addComentBtn;
    private JButton payBtn;
    private JButton anotherBtn;
    private JScrollPane scrollPane1;
    private JTable table;
    private JPanel panel4;
    private JCheckBox checkBox;
    private JLabel summlbl;
    private JLabel avanslbl;
    private JLabel ndslbl;
    private JLabel ondeliverlbl;
    private JLabel countlbl;
    private JLabel creditlbl;
    private JButton okbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
