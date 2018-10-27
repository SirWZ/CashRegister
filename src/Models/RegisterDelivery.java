/*
 * Created by JFormDesigner on Sat Jul 21 17:45:14 CEST 2018
 */

package Models;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

/**
 * @author Gevtsi Yurii
 */
public class RegisterDelivery extends JFrame {
    Connection cn;
    int idProvider;
    public RegisterDelivery(Connection cn) {
        this.cn=cn;
        initComponents();
        typeDeliveryDialog.setVisible(true);

    }


    private void nobtnMouseClicked() {
        this.dispose();
    }

    private void registerandpaybtnMouseClicked() {
        this.dispose();
        firstdialog.setVisible(true);
    }

    private void firstokbtnActionPerformed() {
        JOptionPane.showMessageDialog(this,"Доставка подтверждена.","",JOptionPane.INFORMATION_MESSAGE);
        firstdialog.dispose();
        seconddialog.setVisible(true);
    }

    private void firstnobtnActionPerformed() {
        JOptionPane.showMessageDialog(this,"Доставка не подтверждена.","",JOptionPane.INFORMATION_MESSAGE);
        firstdialog.dispose();
        seconddialog.setVisible(true);
    }

    private void secondokbtnActionPerformed() {
        seconddialog.dispose();
        new CashInOut("Выплата", cn).setVisible(true);
    }

    private void secondnobtnActionPerformed() {
        seconddialog.dispose();
    }


    private void okDialobtnActionPerformed() {
        try{
            if (parseInt(numberTF.getText())>0){
                try{
                    idProvider=parseInt(numberTF.getText());
                    PreparedStatement pr = cn.prepareStatement("");
                }catch (Exception e){

                }
                typeDeliveryDialog.dispose();
                numdeliverytextField.setText(numberTF.getText());
                this.setVisible(true);
            }else JOptionPane.showMessageDialog(this,"Неверный формат2","Ошибка",JOptionPane.ERROR_MESSAGE);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this,"Неверный формат","Ошибка",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addrowBtnActionPerformed() {
        ((DefaultTableModel)table2.getModel()).setRowCount(0);
        try {
            PreparedStatement pr = cn.prepareStatement("select pp.\"idProviderProduct\", pp.name,p.price, p.currency, pp.\"VAT\" from \"Provider_Product\" pp, \"Provider_Connect_Product\" pcp, \"Provider_Price\" p where pp.\"idProviderProduct\" = pcp.\"idProviderProduct\" and pcp.\"idProvider\" =? and p.\"idProviderProduct\" = pp.\"idProviderProduct\"\n");
            pr.setInt(1,idProvider);
            ResultSet rs;
            rs = pr.executeQuery();
            int i=0;
            while (rs.next()){JOptionPane.showMessageDialog(this,"while","Ошибка",JOptionPane.ERROR_MESSAGE);
                ((DefaultTableModel)table2.getModel()).addRow(new Object[]{});
                table2.getModel().setValueAt(rs.getDouble(3),i,2);
                table2.getModel().setValueAt(rs.getString(4),i,3);
                table2.getModel().setValueAt(rs.getDouble(5),i,4);
                table2.getModel().setValueAt(rs.getInt(1),i,0);
                table2.getModel().setValueAt(rs.getString(2),i,1);
                i++;
            }addProdDialog.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void deleteBtnActionPerformed() {
        if (table.getSelectedRow()!=-1){
            ((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
            if (table.getRowCount()==0)((DefaultTableModel)table.getModel()).addRow(new Object[]{});
        }
    }

    private void upBtnActionPerformed() {
        if (table.getSelectedRow()>0)table.setRowSelectionInterval(table.getSelectedRow()-1,table.getSelectedRow()-1);
    }

    private void downbtnActionPerformed() {
        if (table.getSelectedRow()<table.getRowCount()-1 )table.setRowSelectionInterval(table.getSelectedRow()+1,table.getSelectedRow()+1);
    }

    private void addComentBtnActionPerformed() {
        komentdialog.setVisible(true);
    }

    private void tablePropertyChange() {
        // TODO add your code here
    }

    private void addProdDialogKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void button1ActionPerformed() {
        addProdDialog.dispose();
        ((DefaultTableModel)table2.getModel()).setRowCount(0);
    }

    private void findProdTFKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) findBtn.doClick();
    }

    private void findBtnActionPerformed() {
        String name = findProdTF.getText();
        if (!name.equals("")) {
            ListSelectionModel model;
            findProdTF.setText("");
            model= table2.getSelectionModel();
            model.clearSelection();
            for (int i = 0; i < table2.getRowCount(); i++) {
                String prod = table2.getModel().getValueAt(i, 1).toString();
                if (prod.lastIndexOf(name) != -1) model.addSelectionInterval(i, i);
            }
        }
    }

    private void addProdActionPerformed() {
        for (int i=0; i<table2.getSelectedRows().length;i++){
            int id;
            id = Integer.parseInt(table2.getValueAt(table2.getSelectedRows()[i],0).toString());
            String name = table2.getValueAt(table2.getSelectedRows()[i],1).toString();
            double price = Double.parseDouble(table2.getValueAt(table2.getSelectedRows()[i],2).toString());
            String currency = table2.getValueAt(table2.getSelectedRows()[i],3).toString();
            double vat = Double.parseDouble(table2.getValueAt(table2.getSelectedRows()[i],4).toString());

           JComboBox box = new JComboBox();

            box.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int id =0;
                    System.out.println(table.getEditingRow() + "//");
                    box.removeAllItems();
                    try {
                        PreparedStatement pr;
                        ResultSet rs;
                        pr = cn.prepareStatement("select name\n" +
                                "from \"Provider_product_measuring_rate\" pp,\"Measuring_rate_connect_provider_product\" mr\n" +
                                "where pp.\"Id_Provider_product_measuring_rate\" = mr.\"id_measuring_rate_connect_provider_product\"\n" +
                                "      and \"provider_product\" = ?");
                        pr.setInt(1, table.getEditingRow());
                        rs  = pr.executeQuery();
                        while (rs.next()) {
                            box.addItem(rs.getString(1));
                            //System.out.println(rs.getString(1));
                        }
                    }catch (Exception ex){

                    }
                }
            });
            String mesuringRate;
            try {
                PreparedStatement pr = cn.prepareStatement("select p.name from \"Provider_product_measuring_rate\" p, \"Provider_Product\" where \"Id_Provider_product_measuring_rate\" = \"BaseMeasuringRate\" and \"idProviderProduct\" = ?");
                pr.setInt(1,id);
                ResultSet rs = pr.executeQuery();
                rs.next();
                mesuringRate = rs.getString(1);
                table.getModel().setValueAt(id,table.getRowCount()-1,0);
                table.getModel().setValueAt(name,table.getRowCount()-1,1);

                table.getModel().setValueAt(mesuringRate,table.getRowCount()-1,3);
                table.getModel().setValueAt(price,table.getRowCount()-1,4);
                table.getModel().setValueAt(currency,table.getRowCount()-1,5);
                table.getModel().setValueAt(vat,table.getRowCount()-1,6);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ((DefaultTableModel)table.getModel()).addRow(new Object[]{});

        }
    }
    private void exitbtn2ActionPerformed() {
        komentdialog.dispose();
        komentTextArea.setText("");
    }

    private void okKomentBtnActionPerformed() {
        komentdialog.dispose();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - hhh
        firstdialog = new JDialog();
        label2 = new JLabel();
        panel4 = new JPanel();
        firstokbtn = new JButton();
        firstnobtn = new JButton();
        seconddialog = new JDialog();
        label3 = new JLabel();
        panel5 = new JPanel();
        secondokbtn = new JButton();
        secondnobtn = new JButton();
        typeDeliveryDialog = new JDialog();
        panel6 = new JPanel();
        numberLabel = new JLabel();
        numberTF = new JTextField();
        okDialobtn = new JButton();
        panel7 = new JPanel();
        samovvozBtn = new JButton();
        newDelBtn = new JButton();
        var vSpacer1 = new JPanel(null);
        firstpanel = new JPanel();
        nobtn = new JButton();
        var numlabel = new JLabel();
        numdeliverytextField = new JTextField();
        var deliverylbl = new JLabel();
        producentField = new JTextField();
        var secondpanel = new JPanel();
        addrowBtn = new JButton();
        deleteBtn = new JButton();
        upBtn = new JButton();
        downbtn = new JButton();
        addComentBtn = new JButton();
        anotherBtn = new JButton();
        var tablepanel = new JPanel();
        scrollPane2 = new JScrollPane();
        table = new JTable();
        panel8 = new JPanel();
        var lastpanel = new JPanel();
        var panel9 = new JPanel();
        var itogolbl = new JLabel();
        var suminfolbl = new JLabel();
        summlbl = new JLabel();
        var ndsinfolbl = new JLabel();
        ndslbl = new JLabel();
        var panel10 = new JPanel();
        registerandpaybtn = new JButton();
        var vSpacer2 = new JPanel(null);
        addProdDialog = new JDialog();
        panel2 = new JPanel();
        exitbtn = new JButton();
        findProdTF = new JTextField();
        findBtn = new JButton();
        scrollPane3 = new JScrollPane();
        table2 = new JTable();
        panel1 = new JPanel();
        addProd = new JButton();
        komentdialog = new JDialog();
        panel11 = new JPanel();
        exitbtn2 = new JButton();
        panel12 = new JPanel();
        scrollPane4 = new JScrollPane();
        komentTextArea = new JTextArea();
        panel13 = new JPanel();
        okKomentBtn = new JButton();

        //======== firstdialog ========
        {
            firstdialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            firstdialog.setResizable(false);
            var firstdialogContentPane = firstdialog.getContentPane();
            firstdialogContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)firstdialogContentPane.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)firstdialogContentPane.getLayout()).rowHeights = new int[] {0, 42, 44, 0};
            ((GridBagLayout)firstdialogContentPane.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
            ((GridBagLayout)firstdialogContentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

            //---- label2 ----
            label2.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u0435 \u0434\u043e\u0441\u0442\u0430\u0432\u043a\u0438.");
            label2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            firstdialogContentPane.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //======== panel4 ========
            {

                // JFormDesigner evaluation mark
                panel4.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel4.getBorder())); panel4.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel4.setLayout(new GridBagLayout());
                ((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {0, 110, 0};
                ((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
                ((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

                //---- firstokbtn ----
                firstokbtn.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c");
                firstokbtn.addActionListener(e -> firstokbtnActionPerformed());
                panel4.add(firstokbtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- firstnobtn ----
                firstnobtn.setText("\u041e\u0442\u043b\u043e\u0436\u0438\u0442\u044c");
                firstnobtn.addActionListener(e -> firstnobtnActionPerformed());
                panel4.add(firstnobtn, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            firstdialogContentPane.add(panel4, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            firstdialog.setSize(260, 130);
            firstdialog.setLocationRelativeTo(firstdialog.getOwner());
        }

        //======== seconddialog ========
        {
            seconddialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            seconddialog.setResizable(false);
            var seconddialogContentPane = seconddialog.getContentPane();
            seconddialogContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)seconddialogContentPane.getLayout()).columnWidths = new int[] {10, 144, 0};
            ((GridBagLayout)seconddialogContentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
            ((GridBagLayout)seconddialogContentPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
            ((GridBagLayout)seconddialogContentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0, 1.0E-4};

            //---- label3 ----
            label3.setText("\u041e\u043f\u043b\u0430\u0442\u0438\u0442\u044c?");
            label3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            seconddialogContentPane.add(label3, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 5, 0), 0, 0));

            //======== panel5 ========
            {

                // JFormDesigner evaluation mark
                panel5.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel5.getBorder())); panel5.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel5.setLayout(new GridBagLayout());
                ((GridBagLayout)panel5.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)panel5.getLayout()).rowHeights = new int[] {13, 0};
                ((GridBagLayout)panel5.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
                ((GridBagLayout)panel5.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

                //---- secondokbtn ----
                secondokbtn.setText("\u0414\u0430");
                secondokbtn.addActionListener(e -> secondokbtnActionPerformed());
                panel5.add(secondokbtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.BELOW_BASELINE, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- secondnobtn ----
                secondnobtn.setText("\u041d\u0435\u0442");
                secondnobtn.addActionListener(e -> secondnobtnActionPerformed());
                panel5.add(secondnobtn, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.BELOW_BASELINE, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            seconddialogContentPane.add(panel5, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            seconddialog.setSize(195, 145);
            seconddialog.setLocationRelativeTo(seconddialog.getOwner());
        }

        //======== typeDeliveryDialog ========
        {
            var typeDeliveryDialogContentPane = typeDeliveryDialog.getContentPane();
            typeDeliveryDialogContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[grow,fill]",
                // rows
                "[]" +
                "[78,grow]"));

            //======== panel6 ========
            {

                // JFormDesigner evaluation mark
                panel6.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel6.getBorder())); panel6.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel6.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[154,fill]" +
                    "[fill]",
                    // rows
                    "[grow]"));

                //---- numberLabel ----
                numberLabel.setText("\u041d\u043e\u043c\u0435\u0440 \u0434\u043e\u0441\u0442\u0430\u0432\u043a\u0438");
                numberLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                panel6.add(numberLabel, "cell 0 0");
                panel6.add(numberTF, "cell 1 0");

                //---- okDialobtn ----
                okDialobtn.setText("\u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c");
                okDialobtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                okDialobtn.addActionListener(e -> okDialobtnActionPerformed());
                panel6.add(okDialobtn, "cell 2 0,growy");
            }
            typeDeliveryDialogContentPane.add(panel6, "cell 0 0");

            //======== panel7 ========
            {
                panel7.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[50,fill]" +
                    "[grow,fill]" +
                    "[grow,fill]" +
                    "[44,fill]",
                    // rows
                    "[grow,fill]"));

                //---- samovvozBtn ----
                samovvozBtn.setText("\u0421\u0430\u043c\u043e\u0432\u0432\u043e\u0437");
                samovvozBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                panel7.add(samovvozBtn, "cell 1 0,grow");

                //---- newDelBtn ----
                newDelBtn.setText("\u0411\u0435\u0437 \u043d\u043e\u043c\u0435\u0440\u0430");
                newDelBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                panel7.add(newDelBtn, "cell 2 0,grow");
            }
            typeDeliveryDialogContentPane.add(panel7, "cell 0 1,growy");
            typeDeliveryDialog.pack();
            typeDeliveryDialog.setLocationRelativeTo(typeDeliveryDialog.getOwner());
        }

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
            ((GridBagLayout)firstpanel.getLayout()).columnWidths = new int[] {134, 66, 188, 0};
            ((GridBagLayout)firstpanel.getLayout()).rowHeights = new int[] {0, 0, 0};
            ((GridBagLayout)firstpanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)firstpanel.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

            //---- nobtn ----
            nobtn.setText("\u041e\u0442\u043c\u0435\u043d\u0430");
            nobtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    nobtnMouseClicked();
                }
            });
            firstpanel.add(nobtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- numlabel ----
            numlabel.setText("\u041d\u043e\u043c\u0435\u0440");
            numlabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
            firstpanel.add(numlabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- numdeliverytextField ----
            numdeliverytextField.setEditable(false);
            firstpanel.add(numdeliverytextField, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- deliverylbl ----
            deliverylbl.setText("\u041f\u043e\u0441\u0442\u0430\u0432\u0449\u0438\u043a");
            deliverylbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
            firstpanel.add(deliverylbl, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- producentField ----
            producentField.setEditable(false);
            firstpanel.add(producentField, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
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
            upBtn.addActionListener(e -> upBtnActionPerformed());
            secondpanel.add(upBtn, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- downbtn ----
            downbtn.setText("\u0412\u043d\u0438\u0437");
            downbtn.addActionListener(e -> downbtnActionPerformed());
            secondpanel.add(downbtn, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- addComentBtn ----
            addComentBtn.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u043a\u043e\u043c\u0435\u043d\u0442\u0430\u0440\u0438\u0439");
            addComentBtn.addActionListener(e -> addComentBtnActionPerformed());
            secondpanel.add(addComentBtn, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0,
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

            //======== scrollPane2 ========
            {

                //---- table ----
                table.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, null, null, null, null, null, null},
                    },
                    new String[] {
                        "\u041d\u043e\u043c\u0435\u0440", "\u0422\u043e\u0432\u0430\u0440", "\u041a\u043e\u043b-\u0432\u043e", "\u0415\u0434.\u0438\u0437.", "\u0426\u0435\u043d\u0430\\\u0448\u0442.", "\u0412\u0430\u043b\u044e\u0442\u0430", "\u0412 \u043d\u0435\u043c \u041d\u0414\u0421", "\u0421\u0443\u043c\u043c\u0430"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        Integer.class, Object.class, Double.class, String.class, Double.class, String.class, Double.class, Double.class
                    };
                    boolean[] columnEditable = new boolean[] {
                        false, false, true, true, false, true, false, false
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
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
                    cm.getColumn(6).setResizable(false);
                    cm.getColumn(6).setPreferredWidth(70);
                    cm.getColumn(7).setResizable(false);
                    cm.getColumn(7).setPreferredWidth(50);
                }
                table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                table.setAutoCreateRowSorter(true);
                table.setRowSelectionAllowed(false);
                table.setCellSelectionEnabled(true);
                table.addPropertyChangeListener(e -> tablePropertyChange());
                scrollPane2.setViewportView(table);
            }
            tablepanel.add(scrollPane2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(tablepanel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== panel8 ========
        {
            panel8.setLayout(new GridBagLayout());
            ((GridBagLayout)panel8.getLayout()).columnWidths = new int[] {252, 82, 0};
            ((GridBagLayout)panel8.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)panel8.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel8.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
        }
        contentPane.add(panel8, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== lastpanel ========
        {
            lastpanel.setLayout(new GridBagLayout());
            ((GridBagLayout)lastpanel.getLayout()).columnWidths = new int[] {0, 0, 0};
            ((GridBagLayout)lastpanel.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)lastpanel.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
            ((GridBagLayout)lastpanel.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

            //======== panel9 ========
            {
                panel9.setLayout(new GridBagLayout());
                ((GridBagLayout)panel9.getLayout()).columnWidths = new int[] {0, 0, 69, 0};
                ((GridBagLayout)panel9.getLayout()).rowHeights = new int[] {42, 0, 0, 0};
                ((GridBagLayout)panel9.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel9.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};

                //---- itogolbl ----
                itogolbl.setText("\u0418\u0442\u043e\u0433\u043e");
                itogolbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
                panel9.add(itogolbl, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- suminfolbl ----
                suminfolbl.setText("\u0421\u0443\u043c\u043c\u0430 :");
                suminfolbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
                panel9.add(suminfolbl, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- summlbl ----
                summlbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
                panel9.add(summlbl, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- ndsinfolbl ----
                ndsinfolbl.setText("\u0412 \u043d\u0435\u043c \u041d\u0414\u0421 :");
                ndsinfolbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
                panel9.add(ndsinfolbl, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- ndslbl ----
                ndslbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
                panel9.add(ndslbl, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            lastpanel.add(panel9, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //======== panel10 ========
            {
                panel10.setLayout(new GridBagLayout());
                ((GridBagLayout)panel10.getLayout()).columnWidths = new int[] {216, 0};
                ((GridBagLayout)panel10.getLayout()).rowHeights = new int[] {85, 0};
                ((GridBagLayout)panel10.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)panel10.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

                //---- registerandpaybtn ----
                registerandpaybtn.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u0435 \u0438 \u043e\u043f\u043b\u0430\u0442\u0430");
                registerandpaybtn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        registerandpaybtnMouseClicked();
                    }
                });
                panel10.add(registerandpaybtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            lastpanel.add(panel10, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
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

        //======== addProdDialog ========
        {
            addProdDialog.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    addProdDialogKeyPressed(e);
                }
            });
            var addProdDialogContentPane = addProdDialog.getContentPane();
            addProdDialogContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)addProdDialogContentPane.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)addProdDialogContentPane.getLayout()).rowHeights = new int[] {0, 218, 0, 0};
            ((GridBagLayout)addProdDialogContentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)addProdDialogContentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

            //======== panel2 ========
            {

                // JFormDesigner evaluation mark
                panel2.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel2.setLayout(new GridBagLayout());
                ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0, 78, 222, 26, 0};
                ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

                //---- exitbtn ----
                exitbtn.setText("\u0412\u044b\u0445\u043e\u0434");
                exitbtn.addActionListener(e -> button1ActionPerformed());
                panel2.add(exitbtn, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- findProdTF ----
                findProdTF.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        findProdTFKeyPressed(e);
                    }
                });
                panel2.add(findProdTF, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- findBtn ----
                findBtn.setIcon(UIManager.getIcon("TextField.darcula.search.icon"));
                findBtn.addActionListener(e -> findBtnActionPerformed());
                panel2.add(findBtn, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 0), 0, 0));
            }
            addProdDialogContentPane.add(panel2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //======== scrollPane3 ========
            {

                //---- table2 ----
                table2.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u041d\u043e\u043c\u0435\u0440", "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435", "\u0426\u0435\u043d\u0430", "\u0412\u0430\u043b\u044e\u0442\u0430", "\u041d\u0414\u0421"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        Integer.class, String.class, Double.class, String.class, Double.class
                    };
                    boolean[] columnEditable = new boolean[] {
                        false, false, false, true, false
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = table2.getColumnModel();
                    cm.getColumn(1).setPreferredWidth(265);
                }
                scrollPane3.setViewportView(table2);
            }
            addProdDialogContentPane.add(scrollPane3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //======== panel1 ========
            {
                panel1.setLayout(new GridBagLayout());
                ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {307, 0, 0};
                ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- addProd ----
                addProd.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u043f\u0440\u043e\u0434\u0443\u043a\u0442");
                addProd.addActionListener(e -> addProdActionPerformed());
                panel1.add(addProd, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            addProdDialogContentPane.add(panel1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            addProdDialog.setSize(485, 365);
            addProdDialog.setLocationRelativeTo(addProdDialog.getOwner());
        }

        //======== komentdialog ========
        {
            komentdialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var komentdialogContentPane = komentdialog.getContentPane();
            komentdialogContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)komentdialogContentPane.getLayout()).columnWidths = new int[] {0, 0, 0};
            ((GridBagLayout)komentdialogContentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
            ((GridBagLayout)komentdialogContentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)komentdialogContentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

            //======== panel11 ========
            {

                // JFormDesigner evaluation mark
                panel11.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel11.getBorder())); panel11.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel11.setLayout(new GridBagLayout());
                ((GridBagLayout)panel11.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)panel11.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel11.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel11.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- exitbtn2 ----
                exitbtn2.setText("\u0412\u044b\u0445\u043e\u0434");
                exitbtn2.addActionListener(e -> exitbtn2ActionPerformed());
                panel11.add(exitbtn2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));
            }
            komentdialogContentPane.add(panel11, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== panel12 ========
            {
                panel12.setLayout(new GridBagLayout());
                ((GridBagLayout)panel12.getLayout()).columnWidths = new int[] {403, 0};
                ((GridBagLayout)panel12.getLayout()).rowHeights = new int[] {119, 0};
                ((GridBagLayout)panel12.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)panel12.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //======== scrollPane4 ========
                {
                    scrollPane4.setViewportView(komentTextArea);
                }
                panel12.add(scrollPane4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            komentdialogContentPane.add(panel12, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== panel13 ========
            {
                panel13.setLayout(new GridBagLayout());
                ((GridBagLayout)panel13.getLayout()).columnWidths = new int[] {289, 0, 0};
                ((GridBagLayout)panel13.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel13.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel13.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- okKomentBtn ----
                okKomentBtn.setText("\u041e\u043a");
                okKomentBtn.addActionListener(e -> okKomentBtnActionPerformed());
                panel13.add(okKomentBtn, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            komentdialogContentPane.add(panel13, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
            komentdialog.setSize(410, 230);
            komentdialog.setLocationRelativeTo(komentdialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - hhh
    private JDialog firstdialog;
    private JLabel label2;
    private JPanel panel4;
    private JButton firstokbtn;
    private JButton firstnobtn;
    private JDialog seconddialog;
    private JLabel label3;
    private JPanel panel5;
    private JButton secondokbtn;
    private JButton secondnobtn;
    private JDialog typeDeliveryDialog;
    private JPanel panel6;
    private JLabel numberLabel;
    private JTextField numberTF;
    private JButton okDialobtn;
    private JPanel panel7;
    private JButton samovvozBtn;
    private JButton newDelBtn;
    private JPanel firstpanel;
    private JButton nobtn;
    private JTextField numdeliverytextField;
    private JTextField producentField;
    private JButton addrowBtn;
    private JButton deleteBtn;
    private JButton upBtn;
    private JButton downbtn;
    private JButton addComentBtn;
    private JButton anotherBtn;
    private JScrollPane scrollPane2;
    private JTable table;
    private JPanel panel8;
    private JLabel summlbl;
    private JLabel ndslbl;
    private JButton registerandpaybtn;
    private JDialog addProdDialog;
    private JPanel panel2;
    private JButton exitbtn;
    private JTextField findProdTF;
    private JButton findBtn;
    private JScrollPane scrollPane3;
    private JTable table2;
    private JPanel panel1;
    private JButton addProd;
    private JDialog komentdialog;
    private JPanel panel11;
    private JButton exitbtn2;
    private JPanel panel12;
    private JScrollPane scrollPane4;
    private JTextArea komentTextArea;
    private JPanel panel13;
    private JButton okKomentBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
