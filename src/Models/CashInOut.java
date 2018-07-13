/*
 * Created by JFormDesigner on Fri Jul 13 13:46:50 CEST 2018
 */

package Models;

import java.awt.*;
import javax.swing.*;

/**
 * @author Gevtsi Yurii
 */
public class CashInOut extends JFrame {
    public CashInOut(String name) {
        initComponents(name);
    }

    private void initComponents(String name) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
        inoutlabel = new JLabel();
        inOuttextField = new JTextField();
        komentlabel = new JLabel();
        komenttextField = new JTextField();
        okbtn = new JButton();

        //======== this ========
        setTitle("\u0412\u043f\u043b\u0430\u0442\u0430/\u0412\u044b\u043f\u043b\u0430\u0442\u0430");
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3, 2));

        //---- inoutlabel ----
        inoutlabel.setText("inout");
        contentPane.add(inoutlabel);
        contentPane.add(inOuttextField);

        //---- komentlabel ----
        komentlabel.setText("\u041a\u043e\u043c\u0435\u043d\u0442\u0430\u0440\u0438\u0439");
        contentPane.add(komentlabel);
        contentPane.add(komenttextField);

        //---- okbtn ----
        okbtn.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c");
        contentPane.add(okbtn);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Gevtsi Yurii
    private JLabel inoutlabel;
    private JTextField inOuttextField;
    private JLabel komentlabel;
    private JTextField komenttextField;
    private JButton okbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
