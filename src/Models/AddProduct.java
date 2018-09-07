/*
 * Created by JFormDesigner on Fri Sep 07 15:14:24 EEST 2018
 */

package Models;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

/**
 * @author Yurii
 */
public class AddProduct extends JFrame {
    public AddProduct(Connection cn) {
        initComponents();
    }

    private void exitBtnActionPerformed() {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yurii
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
        manufacttextField = new JTextField();
        panel2 = new JPanel();
        fotopanel = new JPanel();
        fotolbl = new JLabel();
        addFotoBtn = new JButton();
        panel4 = new JPanel();
        var lblMeasuring = new JLabel();
        measuringtextField = new JTextField();
        addMeasuringBtn = new JButton();
        var lblProducent = new JLabel();
        producenttextField = new JTextField();
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
            panel1.add(manufacttextField, new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0,
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
                panel4.add(measuringtextField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- addMeasuringBtn ----
                addMeasuringBtn.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0435\u0434. \u0438\u0437.");
                addMeasuringBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                panel4.add(addMeasuringBtn, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- lblProducent ----
                lblProducent.setText("\u041f\u043e\u0441\u0442\u0430\u0432\u0449\u0438\u043a");
                lblProducent.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                panel4.add(lblProducent, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));
                panel4.add(producenttextField, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- addProducentBtn ----
                addProducentBtn.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0435\u0449\u0435");
                addProducentBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
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
            panel5.add(addProduct, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel5, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        setSize(1175, 585);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yurii
    private JPanel panel1;
    private JButton exitBtn;
    private JTextField prodCodetextField;
    private JTextField nametextField;
    private JButton printBtn;
    private JComboBox categorycomboBox;
    private JTextField manufacttextField;
    private JPanel panel2;
    private JPanel fotopanel;
    private JLabel fotolbl;
    private JButton addFotoBtn;
    private JPanel panel4;
    private JTextField measuringtextField;
    private JButton addMeasuringBtn;
    private JTextField producenttextField;
    private JButton addProducentBtn;
    private JTextField barCodetextField;
    private JTextField vattextField;
    private JPanel panel5;
    private JScrollPane scrollPane1;
    private JTextArea descripttextArea;
    private JButton addProduct;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
