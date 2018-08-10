/*
 * Created by JFormDesigner on Fri Jul 13 13:46:50 CEST 2018
 */

package Models;

import java.awt.*;
import java.math.BigDecimal;
import java.sql.*;
import javax.swing.*;

import static java.lang.Double.parseDouble;

/**
 * @author Gevtsi Yurii
 */
class CashInOut extends JFrame {
    Connection cn;
    BigDecimal summ;
    CashInOut(String name, Connection cn) {
        this.cn = cn;
        initComponents();
        this.setTitle(name);
    }

    private void okbtnActionPerformed() {
        try{summ = new BigDecimal(parseDouble(inOuttextField.getText()));
            if (summ.signum()>=0){
                InOutdialog.setVisible(true);
                infolabel.setText(this.getTitle() + " : ");
                masegelable.setText( inOuttextField.getText());
                komentlableright.setText(komenttextField.getText());
            }else JOptionPane.showMessageDialog(this,"Отрицательное значение","Ошибка",JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception k){
            JOptionPane.showMessageDialog(this,"Неверный формат","Ошибка",JOptionPane.ERROR_MESSAGE);
        }


    }

    private void nobtnActionPerformed() {
        InOutdialog.dispose();
    }

    private void yesbtnActionPerformed() {
        PreparedStatement pr;
        try {
            int idshift = UserInterface.idshift;
            pr = cn.prepareStatement("insert into financial_Operations(idshift,time,type,comment,summ) values (?,?,?,?,?)");
            pr.setInt(1,idshift);
            pr.setTimestamp(2,new Timestamp(System.currentTimeMillis()));
            pr.setString(3,this.getTitle());
            pr.setString(4,komentlableright.getText());
            if (this.getTitle().equals("Вплата")){
                pr.setBigDecimal(5,summ);
                pr.executeUpdate();
                pr.clearBatch();
                InOutdialog.dispose();
                dispose();
            }else if (countcash(summ,cn)){
                pr.setBigDecimal(5,summ.negate());
                pr.executeUpdate();
                pr.clearBatch();
                InOutdialog.dispose();
                dispose();
            }else {
                InOutdialog.dispose();
                inOuttextField.setText("");
                JOptionPane.showMessageDialog(this,"Недостаточно средств в кассе","Error",JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.ERROR_MESSAGE);
        }

    }

    public static boolean countcash(BigDecimal summ, Connection cn) throws SQLException {
        PreparedStatement pr;
        ResultSet rs;
        pr = cn.prepareStatement("select sum(summ) from financial_operations where idshift = ?");
        pr.setInt(1,UserInterface.idshift);
        rs=pr.executeQuery();
        rs.next();
        if (rs.getBigDecimal(1).compareTo(summ)>=0) return true;
        else return false;
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yurii
        inoutlabel = new JLabel();
        inOuttextField = new JTextField();
        komentlabel = new JLabel();
        komenttextField = new JTextField();
        okbtn = new JButton();
        InOutdialog = new JDialog();
        infolabel = new JLabel();
        masegelable = new JLabel();
        komentlableleft = new JLabel();
        komentlableright = new JLabel();
        yesbtn = new JButton();
        nobtn = new JButton();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3, 2));

        //---- inoutlabel ----
        inoutlabel.setText("\u0421\u0443\u043c\u043c\u0430");
        contentPane.add(inoutlabel);
        contentPane.add(inOuttextField);

        //---- komentlabel ----
        komentlabel.setText("\u041a\u043e\u043c\u0435\u043d\u0442\u0430\u0440\u0438\u0439");
        contentPane.add(komentlabel);
        contentPane.add(komenttextField);

        //---- okbtn ----
        okbtn.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c");
        okbtn.addActionListener(e -> okbtnActionPerformed());
        contentPane.add(okbtn);
        setSize(580, 235);
        setLocationRelativeTo(null);

        //======== InOutdialog ========
        {
            InOutdialog.setTitle("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435");
            InOutdialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            InOutdialog.setResizable(false);
            Container InOutdialogContentPane = InOutdialog.getContentPane();
            InOutdialogContentPane.setLayout(new GridLayout(3, 2));
            InOutdialogContentPane.add(infolabel);
            InOutdialogContentPane.add(masegelable);

            //---- komentlableleft ----
            komentlableleft.setText("\u041a\u043e\u043c\u0435\u043d\u0442\u0430\u0440\u0438\u0439");
            InOutdialogContentPane.add(komentlableleft);
            InOutdialogContentPane.add(komentlableright);

            //---- yesbtn ----
            yesbtn.setText("\u0414\u0430");
            yesbtn.addActionListener(e -> yesbtnActionPerformed());
            InOutdialogContentPane.add(yesbtn);

            //---- nobtn ----
            nobtn.setText("\u041d\u0435\u0442");
            nobtn.addActionListener(e -> nobtnActionPerformed());
            InOutdialogContentPane.add(nobtn);
            InOutdialog.setSize(270, 230);
            InOutdialog.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yurii
    private JLabel inoutlabel;
    private JTextField inOuttextField;
    private JLabel komentlabel;
    private JTextField komenttextField;
    private JButton okbtn;
    private JDialog InOutdialog;
    private JLabel infolabel;
    private JLabel masegelable;
    private JLabel komentlableleft;
    private JLabel komentlableright;
    private JButton yesbtn;
    private JButton nobtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
