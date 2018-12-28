/*
 * Created by JFormDesigner on Fri Sep 07 17:08:30 EEST 2018
 */

package Models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

/**
 * @author Yurii
 */
public class ProductManagment extends JFrame {
    Connection cn;

    public ProductManagment(Connection cn) {
        initComponents();
        this.cn = cn;
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitBtnActionPerformed();
            }
        });
    }

    private void addProdBtnActionPerformed() {
        this.dispose();
        new AddProduct(cn).setVisible(true);
    }

    private void exitBtnActionPerformed() {
        this.dispose();
        new MyShop(cn).setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - k
        panel1 = new JPanel();
        exitBtn = new JButton();
        findtextField = new JTextField();
        panel2 = new JPanel();
        myProdBtn = new JButton();
        addProdBtn = new JButton();
        promotionBtn = new JButton();
        addCatalogBtn = new JButton();
        downLoadBtn = new JButton();
        priceListBtn = new JButton();

        //======== this ========
        setTitle("\u0423\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u043f\u0440\u043e\u0434\u0443\u043a\u0442\u0430\u043c\u0438");
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {21, 512, 16, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 196, 21, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 1.0, 0.0, 1.0E-4};

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 383, 32, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {70, 16, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

            //---- exitBtn ----
            exitBtn.setText("\u0412\u044b\u0445\u043e\u0434");
            exitBtn.addActionListener(e -> exitBtnActionPerformed());
            panel1.add(exitBtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(findtextField, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 5), 0, 0));
        }
        contentPane.add(panel1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //======== panel2 ========
        {
            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {255, 30, 254, 30, 250, 0};
            ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 30, 0, 0};
            ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 0.0, 1.0, 0.0, 1.0, 1.0E-4};
            ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0, 1.0E-4};

            //---- myProdBtn ----
            myProdBtn.setText("\u041c\u041e\u0418 \u0442\u043e\u0432\u0430\u0440\u044b");
            panel2.add(myProdBtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- addProdBtn ----
            addProdBtn.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0442\u043e\u0432\u0430\u0440");
            addProdBtn.addActionListener(e -> addProdBtnActionPerformed());
            panel2.add(addProdBtn, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- promotionBtn ----
            promotionBtn.setText("\u0410\u043a\u0446\u0438\u0438");
            panel2.add(promotionBtn, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- addCatalogBtn ----
            addCatalogBtn.setText("\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c \u043a\u0430\u0442\u0430\u043b\u043e\u0433");
            panel2.add(addCatalogBtn, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- downLoadBtn ----
            downLoadBtn.setText("\u0421\u043a\u0430\u0447\u0430\u0442\u044c");
            panel2.add(downLoadBtn, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- priceListBtn ----
            priceListBtn.setText("\u0426\u0435\u043d\u043d\u0438\u043a\u0438");
            panel2.add(priceListBtn, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        setSize(820, 505);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - k
    private JPanel panel1;
    private JButton exitBtn;
    private JTextField findtextField;
    private JPanel panel2;
    private JButton myProdBtn;
    private JButton addProdBtn;
    private JButton promotionBtn;
    private JButton addCatalogBtn;
    private JButton downLoadBtn;
    private JButton priceListBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
