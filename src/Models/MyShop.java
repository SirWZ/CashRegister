/*
 * Created by JFormDesigner on Wed Aug 08 16:58:14 CEST 2018
 */

package Models;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.*;

/**
 * @author Yurii
 */
class MyShop extends JFrame {
    private Connection cn;
    MyShop(Connection cn) {
        initComponents();
        this.cn=cn;
        try {

            PreparedStatement pr = cn.prepareStatement("select surname from \"Worker\" where idwor in (select idwor from \"shift_worker\" where logouttime is null) ");
            ResultSet rs = pr.executeQuery();
            rs.next();
            String name = rs.getString(1);
            namelbl.setText(name + " " + LocalDate.now());
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,e.getLocalizedMessage(),"",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void backbtnActionPerformed() {
        this.dispose();
        new CashierViewWindow(cn);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yurii
        JPanel panel1 = new JPanel();
        JButton backbtn = new JButton();
        JTextField textField1 = new JTextField();
        JPanel panel2 = new JPanel();
        JButton productManagmentBtn = new JButton();
        JButton selsBtn = new JButton();
        JButton button4 = new JButton();
        JButton staffBtn = new JButton();
        JButton shiftsBtn = new JButton();
        JButton promoBtn = new JButton();
        JButton inventoryBtn = new JButton();
        JButton stockBtn = new JButton();
        JButton providerBtn = new JButton();
        JPanel panel3 = new JPanel();
        JButton messageBtn = new JButton();
        namelbl = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {718, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

        //======== panel1 ========
        {
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {104, 0, 217, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {19, 50, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

            //---- backbtn ----
            backbtn.setText("\u041d\u0430\u0437\u0430\u0434");
            backbtn.addActionListener(e -> backbtnActionPerformed());
            panel1.add(backbtn, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));
            panel1.add(textField1, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== panel2 ========
        {
            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 68, 0, 167, 0, 154, 0, 0};
            ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
            ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};
            ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};

            //---- productManagmentBtn ----
            productManagmentBtn.setText("\u0423\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u0442\u043e\u0432\u0430\u0440\u0430\u043c\u0438");
            panel2.add(productManagmentBtn, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- selsBtn ----
            selsBtn.setText("\u041f\u0440\u043e\u0434\u0430\u0436\u0438");
            panel2.add(selsBtn, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- button4 ----
            button4.setText("\u0414\u043e\u0441\u0442\u0430\u0432\u043a\u0438");
            panel2.add(button4, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- staffBtn ----
            staffBtn.setText("\u0421\u043e\u0442\u0440\u0443\u0434\u043d\u0438\u043a\u0438");
            panel2.add(staffBtn, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- shiftsBtn ----
            shiftsBtn.setText("\u0421\u043c\u0435\u043d\u044b");
            panel2.add(shiftsBtn, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- promoBtn ----
            promoBtn.setText("\u0410\u043a\u0446\u0438\u0438");
            panel2.add(promoBtn, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- inventoryBtn ----
            inventoryBtn.setText("\u0418\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u0438\u0437\u0430\u0446\u0438\u044f");
            panel2.add(inventoryBtn, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- stockBtn ----
            stockBtn.setText("\u0421\u043a\u043b\u0430\u0434");
            panel2.add(stockBtn, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- providerBtn ----
            providerBtn.setText("\u041f\u043e\u0441\u0442\u0430\u0432\u0449\u0438\u043a\u0438");
            panel2.add(providerBtn, new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        }
        contentPane.add(panel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== panel3 ========
        {
            panel3.setLayout(new GridBagLayout());
            ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {233, 0, 171, 0};
            ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {51, 20, 0};
            ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};
            ((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

            //---- messageBtn ----
            messageBtn.setText("\u0421\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435");
            panel3.add(messageBtn, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- namelbl ----
            namelbl.setText("text");
            panel3.add(namelbl, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 5), 0, 0));
        }
        contentPane.add(panel3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0));
        setSize(720, 415);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yurii
    private JLabel namelbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
