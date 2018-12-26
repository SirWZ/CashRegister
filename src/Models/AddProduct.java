/*
 * Created by JFormDesigner on Fri Sep 07 15:14:24 EEST 2018
 */

package Models;

import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Yurii
 */
public class AddProduct extends JFrame {
    Connection cn;
    ArrayList<String[]> listOfMeasurings = new ArrayList();
    ArrayList<Integer> listOfProviders = new ArrayList();
    int idProdvider_Prod,idProduct;

    public AddProduct(Connection cn) {
        initComponents();//kkk
        this.cn = cn;
        try {
            //providers
            PreparedStatement pr = cn.prepareStatement("select name from \"Provider\"");
            ResultSet rs = pr.executeQuery();
            nameProvidercomboBox.addItem(" ");
            producentcomboBox.addItem(" ");
            while (rs.next()){
                nameProvidercomboBox.addItem(rs.getString(1));
                producentcomboBox.addItem(rs.getString(1));
            }
            AutoCompleteDecorator.decorate(nameProvidercomboBox);
            AutoCompleteDecorator.decorate(producentcomboBox);
            //manufacturer
            pr = cn.prepareStatement("select \"Name\" from \"Manufacturer\"");
            rs = pr.executeQuery();
            manufacturercomboBox.addItem(" ");
            while (rs.next())manufacturercomboBox.addItem(rs.getString(1));
            AutoCompleteDecorator.decorate(manufacturercomboBox);
            //base measuring
            pr=cn.prepareStatement("select \"name\" from \"Measuring_Rate\"");
            rs = pr.executeQuery();
            measuringcomboBox.addItem(" ");
            while (rs.next())measuringcomboBox.addItem(rs.getString(1));
            AutoCompleteDecorator.decorate(measuringcomboBox);
            //category
            pr=cn.prepareStatement("select \"name\" from \"Product_Category\"");
            rs = pr.executeQuery();
            categorycomboBox.addItem(" ");
            while (rs.next())categorycomboBox.addItem(rs.getString(1));
            AutoCompleteDecorator.decorate(categorycomboBox);
        }catch(Exception e){e.printStackTrace();}

    }

    private void exitBtnActionPerformed() {
        this.dispose();
        new ProductManagment(cn).setVisible(true);
    }

    private void addMeasuringBtnActionPerformed() {
        try {
            nameMeasuringcomboBox.removeAllItems();
            PreparedStatement pr = cn.prepareStatement("select \"name\" from \"Provider_product_measuring_rate\"");
            ResultSet rs = pr.executeQuery();
            nameMeasuringcomboBox.addItem(" ");
            while (rs.next()) nameMeasuringcomboBox.addItem(rs.getString(1));
            AutoCompleteDecorator.decorate(nameMeasuringcomboBox);
        }catch (Exception e){e.printStackTrace();}
        addmeasuringdialog.setVisible(true);
    }

    private void exitMeasuringDialogBtnActionPerformed() {
        addmeasuringdialog.dispose();
    }

    private void addNewMeasuringBtnActionPerformed() {
        String name = nameMeasuringcomboBox.getSelectedItem().toString();
        try {
           Integer.parseInt(coefficient.getText());
        }catch (Exception e){
            JOptionPane.showMessageDialog(addmeasuringdialog,"Неверный формат","Ошибка",JOptionPane.ERROR_MESSAGE);
            coefficient.setText("");
            return;
        }
        String str[] = {name,coefficient.getText()};
        listOfMeasurings.add(str);
        newValueDialog.setVisible(true);
    }

    private void exitProviderDialogActionPerformed() {
        addProviderDialog.dispose();
    }

    private void addNewProviderBtnActionPerformed() {
        listOfProviders.add(Integer.parseInt(codeProvidertf.getText()));
        newValueDialog.setVisible(true);
    }

    private void addProducentBtnActionPerformed() {

        addProviderDialog.setVisible(true);
    }

    private void noNewValBtnActionPerformed() {
        if (addmeasuringdialog.isShowing())addmeasuringdialog.dispose();
        else addProviderDialog.dispose();
        newValueDialog.dispose();
    }

    private void yesNewValBtnActionPerformed() {
        if (addmeasuringdialog.isEnabled()){
            nameMeasuringcomboBox.getModel().setSelectedItem(" ");
            coefficient.setText("");
        }else nameProvidercomboBox.getModel().setSelectedItem(" ");
        newValueDialog.dispose();
    }

    private void nameProvidercomboBoxItemStateChanged() {
        // zamiana provider -> zmiana code provider
        String name = nameProvidercomboBox.getSelectedItem().toString();
        if (!name.equals(" ")) {
            try {
                PreparedStatement pr = cn.prepareStatement("select \"idProvider\" from \"Provider\" where name like ?");
                pr.setString(1, name);
                ResultSet rs = pr.executeQuery();
                rs.next();
                codeProvidertf.setText(String.valueOf(rs.getInt(1)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void addProductActionPerformed() {
        try{
            int idBMR=0,idManufacturer = 0, idMainProvider =0;
            PreparedStatement pr;
            ResultSet rs;
            try {
                pr = cn.prepareStatement("select \"idMeasuringRate\" from \"Measuring_Rate\" where name like ?");
                pr.setString(1, measuringcomboBox.getSelectedItem().toString());
                rs = pr.executeQuery();
                rs.next();
                idBMR = rs.getInt(1);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(this,"Неверное значение Базовой еденици измирения.","Error",JOptionPane.ERROR_MESSAGE);
            }
            try {
                pr = cn.prepareStatement("select \"idProvider\" from \"Provider\" where name like ?");
                pr.setString(1, producentcomboBox.getSelectedItem().toString());
                rs = pr.executeQuery();
                rs.next();
                idMainProvider = rs.getInt(1);
                listOfProviders.add(idMainProvider);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(this,"Неверное значение Поставщика.","Error",JOptionPane.ERROR_MESSAGE);
            }
            try {
                pr = cn.prepareStatement("select \"IdManufacturer\" from \"Manufacturer\" where \"Name\" like ?");
                pr.setString(1, manufacturercomboBox.getSelectedItem().toString());
                rs = pr.executeQuery();
                rs.next();
                idManufacturer = rs.getInt(1);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(this,"Неверное значение Производителя.","Error",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
            try {Integer.parseInt(barCodetextField.getText());}catch (Exception ex){JOptionPane.showMessageDialog(this,"Неверное значение Шрих-Кода.","Error",JOptionPane.ERROR_MESSAGE); }
            // dobavlenie v product
            pr = cn.prepareStatement("insert into \"Product\"(\"idProduct\",name,description,\"idBaseMeasuringRate\",vat,manufacturer)values (default, ?,?,?,?,?);");
            pr.setString(1,nametextField.getText());
            pr.setString(2,descripttextArea.getText());
            pr.setInt(3,idBMR);
            pr.setInt(4,Integer.parseInt(vattextField.getText()));
            pr.setInt(5,idManufacturer);
            pr.executeUpdate();
            // poluchenie id posle dobavlenie v Prod
            pr = cn.prepareStatement("select \"idProduct\" from \"Product\" where name like ?");
            pr.setString(1,nametextField.getText());
            rs = pr.executeQuery();
            rs.next();
            idProduct = rs.getInt(1);
            //dobavlenie v Provider_Product
            pr = cn.prepareStatement("insert into \"Provider_Product\"(\"idProviderProduct\",name,description,\"BaseMeasuringRate\",\"VAT\",\"Manufacturer\")values (default, ?,?,?,?,?)");
            pr.setString(1,nametextField.getText());
            pr.setString(2,descripttextArea.getText());
            pr.setInt(3,idBMR);
            pr.setInt(4,Integer.parseInt(vattextField.getText()));
            pr.setInt(5,idManufacturer);
            pr.executeUpdate();
            // poluchenie id posle dobavlenie v PP
            pr = cn.prepareStatement("select \"idProviderProduct\" from \"Provider_Product\" where name like ?");
            pr.setString(1,nametextField.getText());
            rs = pr.executeQuery();
            rs.next();
            idProdvider_Prod = rs.getInt(1);
            //dobavlenie vsech providerov k produktu
            for(int i : listOfProviders){
                pr = cn.prepareStatement("insert into \"Provider_Connect_Product\"(\"idProviderConnectProduct\",\"idProvider\",\"idProviderProduct\") values (default ,?,?)");
                pr.setInt(1,i);
                pr.setInt(2,idProdvider_Prod);
                pr.executeUpdate();
            }
            //dobavlenie vsech edenic izm
            for (String[] s : listOfMeasurings){
                pr = cn.prepareStatement("select \"Id_Provider_product_measuring_rate\" from \"Provider_product_measuring_rate\" where name like ?");
                System.out.println(s[0]);
                pr.setString(1,s[0]);
                rs = pr.executeQuery();
                rs.next();
                int id = rs.getInt(1);
                pr = cn.prepareStatement("insert into \"Product_connect_measuring_rate\"(id_product_connect_measuring_rate, product, measuring_rate, сoefficient, \"Name\") values (default, ?,?,?,?)");
                pr.setInt(1,idProduct);
                pr.setInt(2,id);
                pr.setInt(3,Integer.parseInt(s[1]));
                pr.setString(4,s[0] + " " +s[1] + "шт.");
                pr.executeUpdate();
            }
            //dobavlenie bazovoj e.i.
            pr = cn.prepareStatement("select \"idMeasuringRate\" from \"Measuring_Rate\" where name like ?");
            pr.setString(1,measuringcomboBox.getSelectedItem().toString());
            rs = pr.executeQuery();
            rs.next();
            int id = rs.getInt(1);
            pr = cn.prepareStatement("insert into \"Product_connect_measuring_rate\"(id_product_connect_measuring_rate, product, measuring_rate, сoefficient, \"Name\") values (default, ?,?,?,?)");
            pr.setInt(1,idProduct);
            pr.setInt(2,id);
            pr.setInt(3,1);
            pr.setString(4,"BASE");
            pr.executeUpdate();
            //dobavlenie darcode
            try {
                pr = cn.prepareStatement("insert into barcode(idbarcode, code, product, product_measuring_rate) values (default ,?,?,?)");
                pr.setInt(1, Integer.parseInt(barCodetextField.getText()));
                pr.setInt(2, idProduct);
                pr.setInt(3, idBMR);
                pr.executeUpdate();
            }catch (Exception ex){JOptionPane.showMessageDialog(this, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);}
        }catch (Exception e){e.printStackTrace();}
        JOptionPane.showMessageDialog(this,"good","Error",JOptionPane.ERROR_MESSAGE);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - k
        panel1 = new JPanel();
        exitBtn = new JButton();
        var lblProdCode = new JLabel();
        prodCodetextField = new JTextField();
        var lblName = new JLabel();
        nametextField = new JTextField();
        printBtn = new JButton();
        var lblCategory = new JLabel();
        categorycomboBox = new JComboBox();
        var lblmanufact = new JLabel();
        manufacturercomboBox = new JComboBox();
        panel2 = new JPanel();
        fotopanel = new JPanel();
        fotolbl = new JLabel();
        addFotoBtn = new JButton();
        panel4 = new JPanel();
        var lblMeasuring = new JLabel();
        measuringcomboBox = new JComboBox();
        addMeasuringBtn = new JButton();
        var lblProducent = new JLabel();
        producentcomboBox = new JComboBox();
        addProducentBtn = new JButton();
        var lblBarcode = new JLabel();
        barCodetextField = new JTextField();
        var lblVAT = new JLabel();
        vattextField = new JTextField();
        panel5 = new JPanel();
        var lbldescript = new JLabel();
        scrollPane1 = new JScrollPane();
        descripttextArea = new JTextArea();
        addProduct = new JButton();
        addmeasuringdialog = new JDialog();
        panel3 = new JPanel();
        exitMeasuringDialogBtn = new JButton();
        label1measuringDialog = new JLabel();
        panel6 = new JPanel();
        label2MeasuringDialog = new JLabel();
        nameMeasuringcomboBox = new JComboBox();
        label3MeasuringDialog = new JLabel();
        coefficient = new JTextField();
        panel7 = new JPanel();
        button2 = new JButton();
        addNewMeasuringBtn = new JButton();
        addProviderDialog = new JDialog();
        panel8 = new JPanel();
        exitProviderDialog = new JButton();
        lable1ProviderDialog = new JLabel();
        panel9 = new JPanel();
        label2ProviderDialog = new JLabel();
        codeProvidertf = new JTextField();
        label3ProviderDialog = new JLabel();
        nameProvidercomboBox = new JComboBox();
        panel10 = new JPanel();
        button3 = new JButton();
        addNewProviderBtn = new JButton();
        newValueDialog = new JDialog();
        label1 = new JLabel();
        panel11 = new JPanel();
        yesNewValBtn = new JButton();
        noNewValBtn = new JButton();

        //======== this ========
        setTitle("\u0414\u043e\u0431\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u043f\u0440\u043e\u0434\u0443\u043a\u0442\u0430");
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {31, 0, 25, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {29, 0, 0, 83, 24, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0, 1.0, 0.0, 1.0E-4};

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 113, 0, 0, 437, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {50, 19, 50, 24, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- exitBtn ----
            exitBtn.setText("\u0412\u044b\u0445\u043e\u0434");
            exitBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            exitBtn.addActionListener(e -> exitBtnActionPerformed());
            panel1.add(exitBtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- lblProdCode ----
            lblProdCode.setText("\u041a\u043e\u0434-\u0442\u043e\u0432\u0430\u0440\u0430");
            lblProdCode.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            panel1.add(lblProdCode, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- prodCodetextField ----
            prodCodetextField.setEnabled(false);
            panel1.add(prodCodetextField, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- lblName ----
            lblName.setText("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435");
            lblName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            panel1.add(lblName, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(nametextField, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- printBtn ----
            printBtn.setText("\u041f\u0435\u0447\u0430\u0442\u044c");
            printBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            panel1.add(printBtn, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- lblCategory ----
            lblCategory.setText("\u041a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u044f");
            lblCategory.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            panel1.add(lblCategory, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(categorycomboBox, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- lblmanufact ----
            lblmanufact.setText("\u041f\u0440\u043e\u0438\u0437\u0432\u043e\u0434\u0438\u0442\u0435\u043b\u044c");
            lblmanufact.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            panel1.add(lblmanufact, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(manufacturercomboBox, new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        }
        contentPane.add(panel1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //======== panel2 ========
        {
            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {314, 909, 0};
            ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {203, 0};
            ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
            ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

            //======== fotopanel ========
            {
                fotopanel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                fotopanel.setLayout(new GridBagLayout());
                ((GridBagLayout)fotopanel.getLayout()).columnWidths = new int[] {215, 0};
                ((GridBagLayout)fotopanel.getLayout()).rowHeights = new int[] {156, 42, 0};
                ((GridBagLayout)fotopanel.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)fotopanel.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

                //---- fotolbl ----
                fotolbl.setText("\u0424\u041e\u0422\u041e");
                fotopanel.add(fotolbl, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- addFotoBtn ----
                addFotoBtn.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0444\u043e\u0442\u043e");
                addFotoBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                fotopanel.add(addFotoBtn, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            panel2.add(fotopanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //======== panel4 ========
            {
                panel4.setLayout(new GridBagLayout());
                ((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {0, 205, 0, 0};
                ((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {50, 23, 50, 23, 50, 23, 50, 18, 0};
                ((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0E-4};

                //---- lblMeasuring ----
                lblMeasuring.setText("\u0411\u0430\u0437\u043e\u0432\u0430\u044f \u0435\u0434. \u0438\u0437.");
                lblMeasuring.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                panel4.add(lblMeasuring, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));
                panel4.add(measuringcomboBox, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- addMeasuringBtn ----
                addMeasuringBtn.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0435\u0434. \u0438\u0437.");
                addMeasuringBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                addMeasuringBtn.addActionListener(e -> addMeasuringBtnActionPerformed());
                panel4.add(addMeasuringBtn, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- lblProducent ----
                lblProducent.setText("\u041f\u043e\u0441\u0442\u0430\u0432\u0449\u0438\u043a");
                lblProducent.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                panel4.add(lblProducent, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));
                panel4.add(producentcomboBox, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- addProducentBtn ----
                addProducentBtn.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0435\u0449\u0435");
                addProducentBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                addProducentBtn.addActionListener(e -> addProducentBtnActionPerformed());
                panel4.add(addProducentBtn, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- lblBarcode ----
                lblBarcode.setText("\u0428\u0442\u0440\u0438\u0445-\u043a\u043e\u0434");
                lblBarcode.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                panel4.add(lblBarcode, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));
                panel4.add(barCodetextField, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- lblVAT ----
                lblVAT.setText("\u0421\u0442\u0430\u0432\u043a\u0430 \u041d\u0414\u0421");
                lblVAT.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                panel4.add(lblVAT, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));
                panel4.add(vattextField, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            }
            panel2.add(panel4, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //======== panel5 ========
        {
            panel5.setLayout(new GridBagLayout());
            ((GridBagLayout)panel5.getLayout()).columnWidths = new int[] {171, 0, 314, 121, 0};
            ((GridBagLayout)panel5.getLayout()).rowHeights = new int[] {60, 0};
            ((GridBagLayout)panel5.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel5.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

            //---- lbldescript ----
            lbldescript.setText("\u041e\u043f\u0438\u0441\u0430\u043d\u0438\u0435");
            lbldescript.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            panel5.add(lbldescript, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(descripttextArea);
            }
            panel5.add(scrollPane1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- addProduct ----
            addProduct.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0442\u043e\u0432\u0430\u0440");
            addProduct.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            addProduct.addActionListener(e -> addProductActionPerformed());
            panel5.add(addProduct, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel5, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        setSize(1175, 585);
        setLocationRelativeTo(null);

        //======== addmeasuringdialog ========
        {
            addmeasuringdialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            addmeasuringdialog.setAlwaysOnTop(true);
            addmeasuringdialog.setResizable(false);
            var addmeasuringdialogContentPane = addmeasuringdialog.getContentPane();
            addmeasuringdialogContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[grow,fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //======== panel3 ========
            {

                // JFormDesigner evaluation mark
                panel3.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel3.getBorder())); panel3.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel3.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[218,fill]",
                    // rows
                    "[]" +
                    "[]"));

                //---- exitMeasuringDialogBtn ----
                exitMeasuringDialogBtn.setText("\u0412\u044b\u0445\u043e\u0434");
                exitMeasuringDialogBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                exitMeasuringDialogBtn.addActionListener(e -> exitMeasuringDialogBtnActionPerformed());
                panel3.add(exitMeasuringDialogBtn, "cell 0 0");

                //---- label1measuringDialog ----
                label1measuringDialog.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0435\u0434\u0435\u043d\u0438\u0446\u0443 \u0438\u0437\u043c\u0438\u0440\u0435\u043d\u0438\u044f");
                label1measuringDialog.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                panel3.add(label1measuringDialog, "cell 1 1");
            }
            addmeasuringdialogContentPane.add(panel3, "cell 0 0");

            //======== panel6 ========
            {
                panel6.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[255,fill]",
                    // rows
                    "[]" +
                    "[]"));

                //---- label2MeasuringDialog ----
                label2MeasuringDialog.setText("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0435\u0434. \u0438\u0437.");
                label2MeasuringDialog.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                panel6.add(label2MeasuringDialog, "cell 0 0");
                panel6.add(nameMeasuringcomboBox, "cell 1 0");

                //---- label3MeasuringDialog ----
                label3MeasuringDialog.setText("\u041a\u043e\u043b\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0448\u0442.");
                label3MeasuringDialog.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                panel6.add(label3MeasuringDialog, "cell 0 1");

                //---- coefficient ----
                coefficient.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                panel6.add(coefficient, "cell 1 1");
            }
            addmeasuringdialogContentPane.add(panel6, "cell 0 1");

            //======== panel7 ========
            {
                panel7.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[116,fill]para" +
                    "[45,fill]para" +
                    "[fill]",
                    // rows
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]"));

                //---- button2 ----
                button2.setText("\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043d\u043e\u0432\u0443\u044e");
                panel7.add(button2, "cell 0 1");

                //---- addNewMeasuringBtn ----
                addNewMeasuringBtn.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c");
                addNewMeasuringBtn.addActionListener(e -> addNewMeasuringBtnActionPerformed());
                panel7.add(addNewMeasuringBtn, "cell 2 1");
            }
            addmeasuringdialogContentPane.add(panel7, "cell 0 2");
            addmeasuringdialog.setSize(425, 255);
            addmeasuringdialog.setLocationRelativeTo(null);
        }

        //======== addProviderDialog ========
        {
            addProviderDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            addProviderDialog.setAlwaysOnTop(true);
            var addProviderDialogContentPane = addProviderDialog.getContentPane();
            addProviderDialogContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[grow,fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //======== panel8 ========
            {

                // JFormDesigner evaluation mark
                panel8.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel8.getBorder())); panel8.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel8.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[218,fill]",
                    // rows
                    "[]" +
                    "[]"));

                //---- exitProviderDialog ----
                exitProviderDialog.setText("\u0412\u044b\u0445\u043e\u0434");
                exitProviderDialog.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                exitProviderDialog.addActionListener(e -> exitProviderDialogActionPerformed());
                panel8.add(exitProviderDialog, "cell 0 0");

                //---- lable1ProviderDialog ----
                lable1ProviderDialog.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u043f\u043e\u0441\u0442\u0430\u0432\u0449\u0438\u043a\u0430");
                lable1ProviderDialog.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                panel8.add(lable1ProviderDialog, "cell 1 1");
            }
            addProviderDialogContentPane.add(panel8, "cell 0 0");

            //======== panel9 ========
            {
                panel9.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[255,fill]",
                    // rows
                    "[]" +
                    "[]"));

                //---- label2ProviderDialog ----
                label2ProviderDialog.setText("\u041a\u043e\u0434 \u043f\u043e\u0441\u0442\u0430\u0432\u0449\u0438\u043a\u0430");
                label2ProviderDialog.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                panel9.add(label2ProviderDialog, "cell 0 0");

                //---- codeProvidertf ----
                codeProvidertf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                codeProvidertf.setEditable(false);
                panel9.add(codeProvidertf, "cell 1 0");

                //---- label3ProviderDialog ----
                label3ProviderDialog.setText("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435");
                label3ProviderDialog.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                panel9.add(label3ProviderDialog, "cell 0 1");

                //---- nameProvidercomboBox ----
                nameProvidercomboBox.addItemListener(e -> nameProvidercomboBoxItemStateChanged());
                panel9.add(nameProvidercomboBox, "cell 1 1");
            }
            addProviderDialogContentPane.add(panel9, "cell 0 1");

            //======== panel10 ========
            {
                panel10.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[113,fill]para" +
                    "[37,fill]para" +
                    "[fill]",
                    // rows
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]"));

                //---- button3 ----
                button3.setText("\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043d\u043e\u0432\u043e\u0433\u043e");
                panel10.add(button3, "cell 0 1");

                //---- addNewProviderBtn ----
                addNewProviderBtn.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c");
                addNewProviderBtn.addActionListener(e -> addNewProviderBtnActionPerformed());
                panel10.add(addNewProviderBtn, "cell 2 1");
            }
            addProviderDialogContentPane.add(panel10, "cell 0 2");
            addProviderDialog.setSize(425, 255);
            addProviderDialog.setLocationRelativeTo(null);
        }

        //======== newValueDialog ========
        {
            newValueDialog.setAlwaysOnTop(true);
            newValueDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            newValueDialog.setResizable(false);
            var newValueDialogContentPane = newValueDialog.getContentPane();
            newValueDialogContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]",
                // rows
                "[]0" +
                "[20]0" +
                "[10]"));

            //---- label1 ----
            label1.setText("\u0417\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u0434\u043e\u0431\u0430\u0432\u043b\u0435\u043d\u043e, \u0434\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0435\u0449\u0435?");
            label1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            newValueDialogContentPane.add(label1, "cell 0 0");

            //======== panel11 ========
            {

                // JFormDesigner evaluation mark
                panel11.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel11.getBorder())); panel11.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel11.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[24,fill]" +
                    "[101,fill]para" +
                    "[111,fill]",
                    // rows
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]"));

                //---- yesNewValBtn ----
                yesNewValBtn.setText("\u0414\u0430");
                yesNewValBtn.addActionListener(e -> yesNewValBtnActionPerformed());
                panel11.add(yesNewValBtn, "cell 1 1");

                //---- noNewValBtn ----
                noNewValBtn.setText("\u041d\u0435\u0442");
                noNewValBtn.addActionListener(e -> noNewValBtnActionPerformed());
                panel11.add(noNewValBtn, "cell 2 1");
            }
            newValueDialogContentPane.add(panel11, "cell 0 1");
            newValueDialog.pack();
            newValueDialog.setLocationRelativeTo(newValueDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - k
    private JPanel panel1;
    private JButton exitBtn;
    private JTextField prodCodetextField;
    private JTextField nametextField;
    private JButton printBtn;
    private JComboBox categorycomboBox;
    private JComboBox manufacturercomboBox;
    private JPanel panel2;
    private JPanel fotopanel;
    private JLabel fotolbl;
    private JButton addFotoBtn;
    private JPanel panel4;
    private JComboBox measuringcomboBox;
    private JButton addMeasuringBtn;
    private JComboBox producentcomboBox;
    private JButton addProducentBtn;
    private JTextField barCodetextField;
    private JTextField vattextField;
    private JPanel panel5;
    private JScrollPane scrollPane1;
    private JTextArea descripttextArea;
    private JButton addProduct;
    private JDialog addmeasuringdialog;
    private JPanel panel3;
    private JButton exitMeasuringDialogBtn;
    private JLabel label1measuringDialog;
    private JPanel panel6;
    private JLabel label2MeasuringDialog;
    private JComboBox nameMeasuringcomboBox;
    private JLabel label3MeasuringDialog;
    private JTextField coefficient;
    private JPanel panel7;
    private JButton button2;
    private JButton addNewMeasuringBtn;
    private JDialog addProviderDialog;
    private JPanel panel8;
    private JButton exitProviderDialog;
    private JLabel lable1ProviderDialog;
    private JPanel panel9;
    private JLabel label2ProviderDialog;
    private JTextField codeProvidertf;
    private JLabel label3ProviderDialog;
    private JComboBox nameProvidercomboBox;
    private JPanel panel10;
    private JButton button3;
    private JButton addNewProviderBtn;
    private JDialog newValueDialog;
    private JLabel label1;
    private JPanel panel11;
    private JButton yesNewValBtn;
    private JButton noNewValBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
