/*
 * Created by JFormDesigner on Tue Jul 10 17:28:52 CEST 2018
 */

package Models;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;
import javax.swing.*;

/**
 * @author Gevtsi Yurii
 */
public class UserInterface extends JFrame {

    Connection cn;
    PreparedStatement pr;

    public UserInterface(Connection cn) {this.cn=cn;
        initComponents();
    }

    private void loggBtnActionPerformed()  {
        try {
            pr = cn.prepareStatement("select password from worker_password where idwor="+logintextField.getText());
            ResultSet rs =  pr.executeQuery();
            if (rs.next() ){
                if (Arrays.equals(rs.getString("password").toCharArray(),passwordField.getPassword())){
                    this.dispose();
                    newworkdialog.setVisible(true);
                }else  {
                    passwordField.setText("");
                    JOptionPane.showMessageDialog(this,"Неверный пароль","Error",JOptionPane.ERROR_MESSAGE);
                }
            }else {
                logintextField.setText("");
                JOptionPane.showMessageDialog(this,"Неверный логин","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this,"Hеверный формат данных","Error",JOptionPane.ERROR_MESSAGE);
            logintextField.setText("");
            passwordField.setText("");
        }
        finally {

            if (pr!=null) {
                try {
                    pr.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }

    private void passwordFieldKeyPressed(KeyEvent e) {
        if (e.getKeyCode()==10)loggBtn.doClick();
    }

    private void okBtnActionPerformed() {
        moneydialog.setVisible(true);
        newworkdialog.dispose();
    }

    private void noBtnActionPerformed() {
        new CashierViewWindow(cn);
        newworkdialog.dispose();
    }

    private void thisWindowClosing() {
        try {
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,e.getLocalizedMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void okbtnActionPerformed() {
        moneydialog.dispose();printreptdialog.setVisible(true);
       CashInOut cio = new CashInOut("Вплата");
       cio.setVisible(true);


    }

    private void nobtnActionPerformed() {
        moneydialog.dispose();
        printreptdialog.setVisible(true);
    }

    private void noreptbtnActionPerformed() {
        printreptdialog.dispose();
        new CashierViewWindow(cn);
    }

    private void okreptbtnActionPerformed() {
        noreptbtnActionPerformed();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yurii
        JLabel loginLable = new JLabel();
        logintextField = new JTextField();
        JLabel passwordLabel = new JLabel();
        passwordField = new JPasswordField();
        JPanel spacepanel = new JPanel();
        JPanel loggpanel = new JPanel();
        loggBtn = new JButton();
        newworkdialog = new JDialog();
        JPanel panellbl = new JPanel();
        JLabel label1 = new JLabel();
        JPanel panelbtn = new JPanel();
        JButton okBtn = new JButton();
        JButton noBtn = new JButton();
        moneydialog = new JDialog();
        panel1 = new JPanel();
        moneylbl = new JLabel();
        panel2 = new JPanel();
        JButton okbtn = new JButton();
        JButton nobtn = new JButton();
        printreptdialog = new JDialog();
        panel3 = new JPanel();
        reportlbl = new JLabel();
        panel4 = new JPanel();
        JButton okreptbtn = new JButton();
        JButton noreptbtn = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Logg in");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing();
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3, 2));

        //---- loginLable ----
        loginLable.setText("Login");
        contentPane.add(loginLable);
        contentPane.add(logintextField);

        //---- passwordLabel ----
        passwordLabel.setText("Password");
        contentPane.add(passwordLabel);

        //---- passwordField ----
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                passwordFieldKeyPressed(e);
            }
        });
        contentPane.add(passwordField);

        //======== spacepanel ========
        {
            spacepanel.setVisible(false);
            spacepanel.setLayout(new FlowLayout());
        }
        contentPane.add(spacepanel);

        //======== loggpanel ========
        {
            loggpanel.setLayout(new FlowLayout());

            //---- loggBtn ----
            loggBtn.setText("Logg  in");
            loggBtn.addActionListener(e -> loggBtnActionPerformed());
            loggpanel.add(loggBtn);
        }
        contentPane.add(loggpanel);
        setSize(405, 160);
        setLocationRelativeTo(getOwner());

        //======== newworkdialog ========
        {
            newworkdialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            newworkdialog.setResizable(false);
            Container newworkdialogContentPane = newworkdialog.getContentPane();
            newworkdialogContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)newworkdialogContentPane.getLayout()).columnWidths = new int[] {192, 0};
            ((GridBagLayout)newworkdialogContentPane.getLayout()).rowHeights = new int[] {0, 0, 0};
            ((GridBagLayout)newworkdialogContentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)newworkdialogContentPane.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

            //======== panellbl ========
            {
                panellbl.setLayout(new GridBagLayout());
                ((GridBagLayout)panellbl.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)panellbl.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panellbl.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
                ((GridBagLayout)panellbl.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

                //---- label1 ----
                label1.setText("\u041d\u0430\u0447\u0430\u0442\u044c \u0441\u043c\u0435\u043d\u0443?");
                label1.setFont(new Font("Segoe UI", Font.PLAIN, 30));
                panellbl.add(label1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            newworkdialogContentPane.add(panellbl, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //======== panelbtn ========
            {
                panelbtn.setLayout(new GridBagLayout());
                ((GridBagLayout)panelbtn.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)panelbtn.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panelbtn.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
                ((GridBagLayout)panelbtn.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

                //---- okBtn ----
                okBtn.setText("\u0414\u0430");
                okBtn.addActionListener(e -> okBtnActionPerformed());
                panelbtn.add(okBtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- noBtn ----
                noBtn.setText("\u041d\u0435\u0442");
                noBtn.addActionListener(e -> noBtnActionPerformed());
                panelbtn.add(noBtn, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            newworkdialogContentPane.add(panelbtn, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            newworkdialog.setSize(255, 145);
            newworkdialog.setLocationRelativeTo(newworkdialog.getOwner());
        }

        //======== moneydialog ========
        {
            moneydialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            moneydialog.setResizable(false);
            Container moneydialogContentPane = moneydialog.getContentPane();
            moneydialogContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)moneydialogContentPane.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)moneydialogContentPane.getLayout()).rowHeights = new int[] {0, 0, 0};
            ((GridBagLayout)moneydialogContentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)moneydialogContentPane.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

            //======== panel1 ========
            {
                panel1.setLayout(new GridBagLayout());
                ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {14, 0, 0};
                ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
                ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

                //---- moneylbl ----
                moneylbl.setText("\u0412\u043d\u0435\u0441\u0442\u0438 \u0434\u0435\u043d\u044c\u0433\u0438?");
                moneylbl.setFont(new Font("Segoe UI", Font.PLAIN, 30));
                panel1.add(moneylbl, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            moneydialogContentPane.add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //======== panel2 ========
            {
                panel2.setLayout(new GridBagLayout());
                ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
                ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- okbtn ----
                okbtn.setText("\u0414\u0430");
                okbtn.addActionListener(e -> okbtnActionPerformed());
                panel2.add(okbtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- nobtn ----
                nobtn.setText("\u041d\u0435\u0442");
                nobtn.addActionListener(e -> nobtnActionPerformed());
                panel2.add(nobtn, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            moneydialogContentPane.add(panel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            moneydialog.setSize(255, 135);
            moneydialog.setLocationRelativeTo(moneydialog.getOwner());
        }

        //======== printreptdialog ========
        {
            printreptdialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            printreptdialog.setResizable(false);
            printreptdialog.setAutoRequestFocus(false);
            Container printreptdialogContentPane = printreptdialog.getContentPane();
            printreptdialogContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)printreptdialogContentPane.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)printreptdialogContentPane.getLayout()).rowHeights = new int[] {0, 0, 0};
            ((GridBagLayout)printreptdialogContentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)printreptdialogContentPane.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

            //======== panel3 ========
            {
                panel3.setLayout(new GridBagLayout());
                ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0, 0};
                ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

                //---- reportlbl ----
                reportlbl.setText("\u041d\u0430\u043f\u0435\u0447\u0430\u0442\u0430\u0442\u044c \u043e\u0442\u0447\u0435\u0442?");
                reportlbl.setFont(new Font("Segoe UI", Font.PLAIN, 30));
                panel3.add(reportlbl, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            printreptdialogContentPane.add(panel3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //======== panel4 ========
            {
                panel4.setLayout(new GridBagLayout());
                ((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
                ((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- okreptbtn ----
                okreptbtn.setText("\u0414\u0430");
                okreptbtn.addActionListener(e -> okreptbtnActionPerformed());
                panel4.add(okreptbtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- noreptbtn ----
                noreptbtn.setText("\u041d\u0435\u0442");
                noreptbtn.addActionListener(e -> noreptbtnActionPerformed());
                panel4.add(noreptbtn, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            printreptdialogContentPane.add(panel4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            printreptdialog.setSize(325, 135);
            printreptdialog.setLocationRelativeTo(printreptdialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yurii
    private JTextField logintextField;
    private JPasswordField passwordField;
    private JButton loggBtn;
    private JDialog newworkdialog;
    private JDialog moneydialog;
    private JPanel panel1;
    private JLabel moneylbl;
    private JPanel panel2;
    private JDialog printreptdialog;
    private JPanel panel3;
    private JLabel reportlbl;
    private JPanel panel4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
