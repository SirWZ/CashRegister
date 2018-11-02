/*
 * Created by JFormDesigner on Wed Aug 22 16:50:01 CEST 2018
 */

package Models;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

/**
 * @author Yurii
 */
class CreateDelivery extends JFrame {
    private Connection cn;
    private int idOrder, idProvider;
    private  JComboBox box;
    private JDatePickerImpl dateOfCreatePicker, dateOfWishingPicker;
    private String currency;
    private ArrayList<String> listOfMeasurings;
    CreateDelivery(Connection cn) {
        initComponents();
        this.cn = cn;
        try {
            PreparedStatement pr = cn.prepareStatement("select name from \"Provider\"");
            ResultSet rs = pr.executeQuery();
            while (rs.next())deliveryBox.addItem(rs.getString(1));
            AutoCompleteDecorator.decorate(deliveryBox);
            pr = cn.prepareStatement("select max(\"idDelivery\") from \"Order\"");
            rs = pr.executeQuery();
            rs.next();
            idOrder = rs.getInt(1)+1;
            numbertextField.setText(String.valueOf(idOrder));
        } catch (SQLException e) {
            e.printStackTrace();
            this.dispose();
        }
        createMeasuringComboBox();

        Properties p = new Properties();
        p.put("text.today", "Сегодня");
        p.put("text.month", "Месяц");
        p.put("text.year", "Год");
        dateOfCreatePicker = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel(), p), new DateComponentFormatter());
        dateOfWishingPicker = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel(), p), new DateComponentFormatter());
        dateOfCreatePicker.getModel().setSelected(true);
        firstpanel.add(dateOfCreatePicker, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        panel4.add(dateOfWishingPicker, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
    }

    private void createMeasuringComboBox(){
        box = new JComboBox();
        TableColumn measuringColumn = table.getColumnModel().getColumn(3);
        try{
            PreparedStatement pr = cn.prepareStatement("select name from \"Provider_product_measuring_rate\"");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) box.addItem(rs.getString(1));
            AutoCompleteDecorator.decorate(box);
            measuringColumn.setCellEditor(new DefaultCellEditor(box));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addrowBtnActionPerformed() {((DefaultTableModel)prodtable.getModel()).setRowCount(0);
        try {
            PreparedStatement pr = cn.prepareStatement("select pp.\"idProviderProduct\", pp.name,p.price, p.currency, pp.\"VAT\" from \"Provider_Product\" pp, \"Provider_Connect_Product\" pcp, \"Provider_Price\" p where pp.\"idProviderProduct\" = pcp.\"idProviderProduct\" and pcp.\"idProvider\" =? and p.\"idProviderProduct\" = pp.\"idProviderProduct\"\n");
            pr.setInt(1,idProvider);
            ResultSet rs = pr.executeQuery();
            int i=0;
            while (rs.next()){
                ((DefaultTableModel)prodtable.getModel()).addRow(new Object[]{});
                prodtable.getModel().setValueAt(rs.getInt(1),i,0);
                prodtable.getModel().setValueAt(rs.getString(2),i,1);
                prodtable.getModel().setValueAt(rs.getDouble(3),i,2);
                prodtable.getModel().setValueAt(rs.getString(4),i,3);
                prodtable.getModel().setValueAt(rs.getDouble(5),i,4);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        addProdDialog.setVisible(true);
    }

    private void deleteBtnActionPerformed() {
            if (table.getSelectedRow()!=-1){
                ((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
                createListOfMeasuringRattes();
                if (table.getRowCount()==0)((DefaultTableModel)table.getModel()).addRow(new Object[]{});
            }
    }

    private void payBtnActionPerformed()
    {
        onDeliveryTF.setText(summlbl.getText());
        paydialog.setVisible(true);
    }

    private void deliveryBoxActionPerformed() {
        try {
            PreparedStatement pr = cn.prepareStatement("select \"idProvider\", e_mail from \"Provider\" where name like ?");
            pr.setString(1,Objects.requireNonNull(deliveryBox.getSelectedItem()).toString());
            ResultSet rs = pr.executeQuery();
            rs.next();
            idProvider = rs.getInt(1);
            contacttextField.setText(rs.getString(2));

            pr = cn.prepareStatement("select currency from \"Provider_Price\" where \"idProviderProduct\" in (select \"idProviderProduct\" from \"Provider_Connect_Product\" where \"idProvider\" = ?)");
            pr.setInt(1,idProvider);
            rs = pr.executeQuery();
            rs.next();
            currency = rs.getString(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,e.getLocalizedMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exitBtnActionPerformed() {

        this.dispose();
    }

    private void button1ActionPerformed() {
        addProdDialog.dispose();
        ((DefaultTableModel)prodtable.getModel()).setRowCount(0);
    }

    private void addProdActionPerformed() {
        for (int i=0; i<prodtable.getSelectedRows().length;i++){
            int id = Integer.parseInt(prodtable.getValueAt(prodtable.getSelectedRows()[i],0).toString());
            String name = prodtable.getValueAt(prodtable.getSelectedRows()[i],1).toString();
            double price = Double.parseDouble(prodtable.getValueAt(prodtable.getSelectedRows()[i],2).toString());
            String currency = prodtable.getValueAt(prodtable.getSelectedRows()[i],3).toString();
            double vat = Double.parseDouble(prodtable.getValueAt(prodtable.getSelectedRows()[i],4).toString());

            String mesuringRate;
            try {
                PreparedStatement pr;
                ResultSet rs;
                pr = cn.prepareStatement("select p.name from \"Provider_product_measuring_rate\" p, \"Provider_Product\" where \"Id_Provider_product_measuring_rate\" = \"BaseMeasuringRate\" and \"idProviderProduct\" = ?");
                pr.setInt(1,id);
                rs = pr.executeQuery();
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
        createListOfMeasuringRattes();
    }

    private void upBtnActionPerformed() {
        if (table.getSelectedRow()>0)table.setRowSelectionInterval(table.getSelectedRow()-1,table.getSelectedRow()-1);
    }

    private void downbtnActionPerformed() {
        if (table.getSelectedRow()<table.getRowCount()-1 )table.setRowSelectionInterval(table.getSelectedRow()+1,table.getSelectedRow()+1);
    }

    private void findBtnActionPerformed() {
        String name = findProdTF.getText();
        if (!name.equals("")) {
            findProdTF.setText("");
            ListSelectionModel model = prodtable.getSelectionModel();
            model.clearSelection();
            for (int i = 0; i < prodtable.getRowCount(); i++) {
                String prod = prodtable.getModel().getValueAt(i, 1).toString();
                if (prod.lastIndexOf(name) != -1) model.addSelectionInterval(i, i);
            }
        }
    }

    private void exitbtn2ActionPerformed() {
        komentdialog.dispose();
        komentTextArea.setText("");
    }

    private void okKomentBtnActionPerformed() {
        komentdialog.dispose();
    }

    private void addComentBtnActionPerformed() {
        komentdialog.setVisible(true);
    }

    private void findProdTFKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) findBtn.doClick();
    }

    private void addProdDialogKeyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    private void okbtnActionPerformed() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            // tablica order
            PreparedStatement pr = cn.prepareStatement("insert into \"Order\" (\"idDelivery\", date_of_wishing_delivery, status, \"Place\", \"Date_of_create\", \"Description\", \"Price\", amout_of_delivery) values (default ,?,?,?,?,?,?,?)");
            pr.setString(2,"StatusOk");
            pr.setString(3,deliveryPlacetextField.getText());
            pr.setTimestamp(4,Timestamp.valueOf(df.format(dateOfCreatePicker.getModel().getValue())));
            pr.setString(5,komentTextArea.getText());
            pr.setBigDecimal(6,BigDecimal.valueOf(Double.parseDouble(summlbl.getText())));
            if (checkBox.isSelected()){
                pr.setTimestamp(1,Timestamp.valueOf(df.format(dateOfWishingPicker.getModel().getValue())));
                pr.setString(7,"Mnogo");
            }
            else{
                pr.setTimestamp(1,null);
                pr.setString(7,"1");
            }
            pr.executeUpdate();
            //tablica order bucket
            for (int i = 0; i < table.getRowCount()-1; i++) {
                String idprod = table.getModel().getValueAt(i, 0).toString();
                pr = cn.prepareStatement("insert into order_bucket(\"ID_Delivery_Bucket\",amount,\"Delivery\",\"Product\",\"Price_per_unit\",measuring_rate,currency) values (default ,?,?,?,?,?,?)");
                pr.setDouble(1,Double.parseDouble(table.getModel().getValueAt(i,2).toString()));
                pr.setInt(2,idOrder);
                pr.setInt(3,Integer.parseInt(idprod));
                pr.setBigDecimal(4,BigDecimal.valueOf(Double.parseDouble(table.getModel().getValueAt(i,4).toString())));
                pr.setString(5,table.getModel().getValueAt(i,3).toString());
                pr.setString(6,table.getModel().getValueAt(i,5).toString());
                pr.executeUpdate();
            }
            //orderPayments
            if (!avansTF.getText().equals("")){
                makeOrderPayments("Аванс",Double.parseDouble(avansTF.getText()));
            }
            if (!onDeliveryTF.getText().equals("")){
                makeOrderPayments("Во время доставки",Double.parseDouble(onDeliveryTF.getText()));
            }
            if (!creditTF.getText().equals("")){
                makeOrderPayments("Кредит",Double.parseDouble(creditTF.getText()));
            }
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void checkBoxActionPerformed() {
        dateOfWishingPicker.getModel().setSelected(true);
    }

    private void tablePropertyChange() {
        if (table.getSelectedColumn()==3){//measuring rates and coeff.
            for (int i=0; i<table.getRowCount()-1;i++){
                String oldMeas = listOfMeasurings.get(i);
                String newMeas = table.getValueAt(i,3).toString();
                if (!oldMeas.equals(newMeas)){
                    listOfMeasurings.set(i,newMeas);
                    try {
                        PreparedStatement pr = cn.prepareStatement("select c.coefficient, p.price from \"Measuring_rate_connect_provider_product\" c, \"Provider_Price\" p where provider_product = ? and p.\"idProviderProduct\"=c.provider_product and measuring_rate = (select \"Id_Provider_product_measuring_rate\" from \"Provider_product_measuring_rate\" where name like ?)");
                        pr.setInt(1,Integer.parseInt(table.getValueAt(i,0).toString()));
                        pr.setString(2,newMeas);
                        ResultSet rs = pr.executeQuery();
                        rs.next();
                        double oldprice = rs.getDouble(2);
                        double newprice = rs.getDouble(1)*oldprice;
                        table.getModel().setValueAt(newprice,i,4);
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(this,"Measuring rate error","Error",JOptionPane.ERROR_MESSAGE);
                        table.getModel().setValueAt(oldMeas,i,3);
                    }
                }
            }
        }
        double summ=0;//calk summ
        double summNDS=0;
        if (table.getSelectedColumn()==3){

        }
        for (int i =0; i< table.getRowCount();i++){
            if (table.getModel().getValueAt(i, 0)!=null && table.getModel().getValueAt(i, 2)!=null) {
                double count = (double) table.getModel().getValueAt(i, 2);
                double price = (double) table.getModel().getValueAt(i, 4);
                double nds = (double) table.getModel().getValueAt(i, 6);
                summ += new BigDecimal(count * price).setScale(2, RoundingMode.UP).doubleValue();
                summNDS+=new BigDecimal(price*nds*count/100).setScale(2, RoundingMode.UP).doubleValue();
                table.getModel().setValueAt(new BigDecimal(count * price).setScale(2, RoundingMode.UP).doubleValue() ,i,7);
            }
        }
        summlbl.setText(summ + "");
        ndslbl.setText(summNDS +"");
    }


    private void createListOfMeasuringRattes(){
        listOfMeasurings = new ArrayList<>();
        for (int i=0; i<table.getRowCount()-1;i++) {
            listOfMeasurings.add(table.getValueAt(i, 3).toString());
        }
    }

    private void avansTFActionPerformed() {
        double sum ,avans =0 , credit =0;
        if (!avansTF.getText().equals(""))avans = Double.parseDouble(avansTF.getText());
        if (!creditTF.getText().equals(""))credit = Double.parseDouble(creditTF.getText());
        sum = Double.parseDouble(summlbl.getText())- avans - credit;
        if (sum<0){
            onDeliveryTF.setText("");
            if (!creditTF.getText().equals("")){
                double val = Double.parseDouble(creditTF.getText()) + sum;
                if (val>0){
                    creditTF.setText(String.valueOf(val));
                }
                else {
                    creditTF.setText("");
                    avansTF.setText(summlbl.getText());
                }
            }
            else avansTF.setText(summlbl.getText());
        }else onDeliveryTF.setText(String.valueOf(sum));

    }

    private void avansTFKeyTyped(KeyEvent e) {
    char c = e.getKeyChar();
        if (!(((c >= '0') && (c <= '9')) ||
                (c == '.') ||
                (c == KeyEvent.VK_BACK_SPACE) ||
                (c == KeyEvent.VK_DELETE))) {
            e.setKeyChar((char) 0);
        }
        if (c == ',')e.setKeyChar('.');
    }

    private void creditTFKeyTyped(KeyEvent e) {
        avansTFKeyTyped(e);
    }

    private void creditTFActionPerformed() {
        avansTFActionPerformed();
    }

        private void okPayBtnActionPerformed() {
            paydialog.dispose();
        }

    private void makeOrderPayments(String type, double summ){
        try {
            PreparedStatement pr = cn.prepareStatement("insert into \"Order_payments\" (id_order_payments, \"order\", type, sum, \"percent \", currency) values (default ,?,?,?,?,?)");
            pr.setInt(1, idOrder);
                    pr.setString(2,type);
                    pr.setDouble(3,summ);
                    double percent = new BigDecimal(summ/Double.parseDouble(summlbl.getText())*100).setScale(2, RoundingMode.UP).doubleValue();
                    pr.setDouble(4,percent);
                    pr.setString(5,currency);
                    pr.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.ERROR_MESSAGE);
        }

    }

    private void exitPayBtnActionPerformed() {
        paydialog.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - hhh
        var vSpacer1 = new JPanel(null);
        firstpanel = new JPanel();
        exitBtn = new JButton();
        var numlabel = new JLabel();
        numbertextField = new JTextField();
        datelbl = new JLabel();
        noBtn = new JButton();
        printBtn = new JButton();
        var deliverylbl = new JLabel();
        deliveryBox = new JComboBox();
        var numdelLbl = new JLabel();
        deliveryPlacetextField = new JTextField();
        var contactlbl = new JLabel();
        contacttextField = new JTextField();
        var secondpanel = new JPanel();
        addrowBtn = new JButton();
        deleteBtn = new JButton();
        upBtn = new JButton();
        downbtn = new JButton();
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
        var creditinfo = new JLabel();
        creditlbl = new JLabel();
        var panel7 = new JPanel();
        okbtn = new JButton();
        var vSpacer2 = new JPanel(null);
        addProdDialog = new JDialog();
        panel2 = new JPanel();
        exitbtn = new JButton();
        findProdTF = new JTextField();
        findBtn = new JButton();
        scrollPane2 = new JScrollPane();
        prodtable = new JTable();
        panel1 = new JPanel();
        addProd = new JButton();
        komentdialog = new JDialog();
        panel9 = new JPanel();
        exitbtn2 = new JButton();
        panel10 = new JPanel();
        scrollPane3 = new JScrollPane();
        komentTextArea = new JTextArea();
        panel11 = new JPanel();
        okKomentBtn = new JButton();
        paydialog = new JDialog();
        panel3 = new JPanel();
        exitPayBtn = new JButton();
        panel6 = new JPanel();
        label1 = new JLabel();
        avansTF = new JTextField();
        label2 = new JLabel();
        onDeliveryTF = new JTextField();
        label3 = new JLabel();
        creditTF = new JTextField();
        panel8 = new JPanel();
        okPayBtn = new JButton();

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
            ((GridBagLayout)firstpanel.getLayout()).columnWidths = new int[] {70, 66, 193, 0, 159, 72, 150, 0};
            ((GridBagLayout)firstpanel.getLayout()).rowHeights = new int[] {0, 0, 0};
            ((GridBagLayout)firstpanel.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};
            ((GridBagLayout)firstpanel.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

            //---- exitBtn ----
            exitBtn.setIcon(new ImageIcon("E:\\CashRegister\\resources\\exit.png"));
            exitBtn.addActionListener(e -> exitBtnActionPerformed());
            firstpanel.add(exitBtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- numlabel ----
            numlabel.setText("\u041d\u043e\u043c\u0435\u0440");
            numlabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
            firstpanel.add(numlabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- numbertextField ----
            numbertextField.setEditable(false);
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

            //---- deliveryBox ----
            deliveryBox.setMaximumRowCount(40);
            deliveryBox.addActionListener(e -> deliveryBoxActionPerformed());
            firstpanel.add(deliveryBox, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- numdelLbl ----
            numdelLbl.setText("\u041c\u0435\u0441\u0442\u043e \u0434\u043e\u0441\u0442\u0430\u0432\u043a\u0438");
            numdelLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
            firstpanel.add(numdelLbl, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));
            firstpanel.add(deliveryPlacetextField, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
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
            checkBox.addActionListener(e -> checkBoxActionPerformed());
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
                ndsinfolbl.setText("\u0412 \u043d\u0435\u043c \u041d\u0414\u0421 :");
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
                okbtn.addActionListener(e -> okbtnActionPerformed());
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
        setSize(925, 585);
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

            //======== scrollPane2 ========
            {

                //---- prodtable ----
                prodtable.setModel(new DefaultTableModel(
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
                    TableColumnModel cm = prodtable.getColumnModel();
                    cm.getColumn(1).setPreferredWidth(265);
                }
                scrollPane2.setViewportView(prodtable);
            }
            addProdDialogContentPane.add(scrollPane2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
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

            //======== panel9 ========
            {

                // JFormDesigner evaluation mark
                panel9.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel9.getBorder())); panel9.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel9.setLayout(new GridBagLayout());
                ((GridBagLayout)panel9.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)panel9.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel9.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel9.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- exitbtn2 ----
                exitbtn2.setText("\u0412\u044b\u0445\u043e\u0434");
                exitbtn2.addActionListener(e -> exitbtn2ActionPerformed());
                panel9.add(exitbtn2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));
            }
            komentdialogContentPane.add(panel9, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== panel10 ========
            {
                panel10.setLayout(new GridBagLayout());
                ((GridBagLayout)panel10.getLayout()).columnWidths = new int[] {403, 0};
                ((GridBagLayout)panel10.getLayout()).rowHeights = new int[] {119, 0};
                ((GridBagLayout)panel10.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)panel10.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //======== scrollPane3 ========
                {
                    scrollPane3.setViewportView(komentTextArea);
                }
                panel10.add(scrollPane3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            komentdialogContentPane.add(panel10, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== panel11 ========
            {
                panel11.setLayout(new GridBagLayout());
                ((GridBagLayout)panel11.getLayout()).columnWidths = new int[] {289, 0, 0};
                ((GridBagLayout)panel11.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel11.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel11.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- okKomentBtn ----
                okKomentBtn.setText("\u041e\u043a");
                okKomentBtn.addActionListener(e -> okKomentBtnActionPerformed());
                panel11.add(okKomentBtn, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            komentdialogContentPane.add(panel11, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
            komentdialog.setSize(410, 230);
            komentdialog.setLocationRelativeTo(komentdialog.getOwner());
        }

        //======== paydialog ========
        {
            paydialog.setAlwaysOnTop(true);
            paydialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            paydialog.setTitle("\u041e\u043f\u043b\u0430\u0442\u0430");
            paydialog.setResizable(false);
            var paydialogContentPane = paydialog.getContentPane();
            paydialogContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)paydialogContentPane.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)paydialogContentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
            ((GridBagLayout)paydialogContentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)paydialogContentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

            //======== panel3 ========
            {

                // JFormDesigner evaluation mark
                panel3.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel3.getBorder())); panel3.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel3.setLayout(new GridBagLayout());
                ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0, 0};
                ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
                ((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- exitPayBtn ----
                exitPayBtn.setText("\u041d\u0430\u0437\u0430\u0434");
                exitPayBtn.addActionListener(e -> exitPayBtnActionPerformed());
                panel3.add(exitPayBtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            paydialogContentPane.add(panel3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //======== panel6 ========
            {
                panel6.setLayout(new GridBagLayout());
                ((GridBagLayout)panel6.getLayout()).columnWidths = new int[] {153, 62, 0};
                ((GridBagLayout)panel6.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                ((GridBagLayout)panel6.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel6.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

                //---- label1 ----
                label1.setText("\u0410\u0432\u0430\u043d\u0441");
                panel6.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- avansTF ----
                avansTF.addActionListener(e -> avansTFActionPerformed());
                avansTF.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        avansTFKeyTyped(e);
                    }
                });
                panel6.add(avansTF, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label2 ----
                label2.setText("\u0412 \u043c\u043e\u043c\u0435\u043d\u0442 \u0434\u043e\u0441\u0442\u0430\u0432\u043a\u0438");
                panel6.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- onDeliveryTF ----
                onDeliveryTF.setEditable(false);
                panel6.add(onDeliveryTF, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label3 ----
                label3.setText("\u041a\u0440\u0435\u0434\u0438\u0442/\u043e\u0442\u0441\u0440\u043e\u0447\u043a\u0430");
                panel6.add(label3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- creditTF ----
                creditTF.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        creditTFKeyTyped(e);
                    }
                });
                creditTF.addActionListener(e -> creditTFActionPerformed());
                panel6.add(creditTF, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            paydialogContentPane.add(panel6, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //======== panel8 ========
            {
                panel8.setLayout(new GridBagLayout());
                ((GridBagLayout)panel8.getLayout()).columnWidths = new int[] {157, 0, 0};
                ((GridBagLayout)panel8.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel8.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel8.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- okPayBtn ----
                okPayBtn.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c");
                okPayBtn.addActionListener(e -> okPayBtnActionPerformed());
                panel8.add(okPayBtn, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            paydialogContentPane.add(panel8, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            paydialog.setSize(335, 215);
            paydialog.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - hhh
    private JPanel firstpanel;
    private JButton exitBtn;
    private JTextField numbertextField;
    private JLabel datelbl;
    private JButton noBtn;
    private JButton printBtn;
    private JComboBox deliveryBox;
    private JTextField deliveryPlacetextField;
    private JTextField contacttextField;
    private JButton addrowBtn;
    private JButton deleteBtn;
    private JButton upBtn;
    private JButton downbtn;
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
    private JLabel creditlbl;
    private JButton okbtn;
    private JDialog addProdDialog;
    private JPanel panel2;
    private JButton exitbtn;
    private JTextField findProdTF;
    private JButton findBtn;
    private JScrollPane scrollPane2;
    private JTable prodtable;
    private JPanel panel1;
    private JButton addProd;
    private JDialog komentdialog;
    private JPanel panel9;
    private JButton exitbtn2;
    private JPanel panel10;
    private JScrollPane scrollPane3;
    private JTextArea komentTextArea;
    private JPanel panel11;
    private JButton okKomentBtn;
    private JDialog paydialog;
    private JPanel panel3;
    private JButton exitPayBtn;
    private JPanel panel6;
    private JLabel label1;
    private JTextField avansTF;
    private JLabel label2;
    private JTextField onDeliveryTF;
    private JLabel label3;
    private JTextField creditTF;
    private JPanel panel8;
    private JButton okPayBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
