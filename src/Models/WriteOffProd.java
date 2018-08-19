/*
 * Created by JFormDesigner on Thu Jul 19 16:06:54 CEST 2018
 */

package Models;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Gevtsi Yurii
 */
class WriteOffProd extends JFrame {

	Connection cn;
	PreparedStatement pr;

	WriteOffProd(Connection cn) {
		this.cn = cn;
		initComponents();
	}

	private void okbtnActionPerformed() {
		masseglabel.setText(nametextField.getText());
		writeoffdialog.setVisible(true);
	}

	private void okbtn2ActionPerformed() {
		try {
			pr = cn.prepareStatement(
					"Select \"idWrittenOffProduct\" From \"Writen_Off_Product\" Order by \"idWrittenOffProduct\" desc");
			ResultSet res = pr.executeQuery();
			res.next();
			int id = res.getInt("idWrittenOffProduct")+1;
			pr = cn.prepareStatement(
					"UPDATE \"Product\" SET \"count\" = ((Select \"count\" From \"Product\" where \"idProduct\" = "
							+ codetextField.getText() + " )-" + counttextField.getText() + ")   WHERE \"idProduct\" = \'"
							+ codetextField.getText() + "\'");
			pr.execute();
			pr = cn.prepareStatement("insert into \"Writen_Off_Product\" (\"idWrittenOffProduct\", date, reason, amount, \"idProduct\") values (?,?,?,?,?)");
			pr.setInt(1,id);
			pr.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			pr.setString(3,reasontextArea.getText());
			pr.setInt(4,Integer.parseInt(counttextField.getText()));
			pr.setInt(5,Integer.parseInt(codetextField.getText()));
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		nobtn2ActionPerformed();
		this.dispose();
	}

	private void nobtn2ActionPerformed() {
		writeoffdialog.dispose();
	}

    private void exitbtnActionPerformed() {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yurii
        namelabel = new JLabel();
        nametextField = new JTextField();
        codelabel = new JLabel();
        codetextField = new JTextField();
        countlabel = new JLabel();
        counttextField = new JTextField();
        reasonlabel = new JLabel();
        scrollPane1 = new JScrollPane();
        reasontextArea = new JTextArea();
        panel1 = new JPanel();
        okbtn = new JButton();
        var exitbtn = new JButton();
        writeoffdialog = new JDialog();
        panel2 = new JPanel();
        label4 = new JLabel();
        masseglabel = new JLabel();
        panel3 = new JPanel();
        okbtn2 = new JButton();
        nobtn2 = new JButton();

        //======== this ========
        setTitle("\u0421\u043f\u0438\u0441\u0430\u0442\u044c \u0442\u043e\u0432\u0430\u0440");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {14, 118, 206, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 59, 62, 67, 128, 49, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};

        //---- namelabel ----
        namelabel.setText("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435");
        contentPane.add(namelabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 9, 9), 0, 0));
        contentPane.add(nametextField, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 9, 0), 0, 0));

        //---- codelabel ----
        codelabel.setText("\u041a\u043e\u0434 \u0442\u043e\u0432\u0430\u0440\u0430");
        contentPane.add(codelabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 9, 9), 0, 0));
        contentPane.add(codetextField, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 9, 0), 0, 0));

        //---- countlabel ----
        countlabel.setText("\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e");
        contentPane.add(countlabel, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 9, 9), 0, 0));
        contentPane.add(counttextField, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 9, 0), 0, 0));

        //---- reasonlabel ----
        reasonlabel.setText("\u041f\u0440\u0438\u0447\u0438\u043d\u0430");
        contentPane.add(reasonlabel, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 9, 9), 0, 0));

        //======== scrollPane1 ========
        {
            scrollPane1.setMinimumSize(new Dimension(16, 76));

            //---- reasontextArea ----
            reasontextArea.setLineWrap(true);
            scrollPane1.setViewportView(reasontextArea);
        }
        contentPane.add(scrollPane1, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 9, 0), 0, 0));

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[grow,fill]" +
                "[fill]" +
                "[52,fill]" +
                "[fill]" +
                "[grow,fill]",
                // rows
                "[42,grow,fill]" +
                "[grow,fill]" +
                "[]" +
                "[]"));

            //---- okbtn ----
            okbtn.setText("\u0421\u043f\u0438\u0441\u0430\u0442\u044c");
            okbtn.setHorizontalAlignment(SwingConstants.LEFT);
            okbtn.addActionListener(e -> okbtnActionPerformed());
            panel1.add(okbtn, "cell 1 0");

            //---- exitbtn ----
            exitbtn.setText("\u0412\u044b\u0445\u043e\u0434");
            exitbtn.addActionListener(e -> exitbtnActionPerformed());
            panel1.add(exitbtn, "cell 5 0");
        }
        contentPane.add(panel1, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        setSize(570, 375);
        setLocationRelativeTo(getOwner());

        //======== writeoffdialog ========
        {
            writeoffdialog.setAlwaysOnTop(true);
            writeoffdialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            writeoffdialog.setResizable(false);
            var writeoffdialogContentPane = writeoffdialog.getContentPane();
            writeoffdialogContentPane.setLayout(new GridLayout(2, 1));

            //======== panel2 ========
            {
                panel2.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- label4 ----
                label4.setText("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c \u0441\u043f\u0438\u0441\u0430\u043d\u0438\u0435 \u0442\u043e\u0432\u0430\u0440\u043e\u0432 :");
                panel2.add(label4, "cell 2 1");

                //---- masseglabel ----
                masseglabel.setText("text");
                panel2.add(masseglabel, "cell 2 2");
            }
            writeoffdialogContentPane.add(panel2);

            //======== panel3 ========
            {
                panel3.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[22,fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[34,fill]" +
                    "[37,fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]"));

                //---- okbtn2 ----
                okbtn2.setText("\u0414\u0430");
                okbtn2.addActionListener(e -> okbtn2ActionPerformed());
                panel3.add(okbtn2, "cell 2 1");

                //---- nobtn2 ----
                nobtn2.setText("\u041d\u0435\u0442");
                nobtn2.addActionListener(e -> nobtn2ActionPerformed());
                panel3.add(nobtn2, "cell 4 1");
            }
            writeoffdialogContentPane.add(panel3);
            writeoffdialog.setSize(280, 160);
            writeoffdialog.setLocationRelativeTo(writeoffdialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yurii
    private JLabel namelabel;
    private JTextField nametextField;
    private JLabel codelabel;
    private JTextField codetextField;
    private JLabel countlabel;
    private JTextField counttextField;
    private JLabel reasonlabel;
    private JScrollPane scrollPane1;
    private JTextArea reasontextArea;
    private JPanel panel1;
    private JButton okbtn;
    private JDialog writeoffdialog;
    private JPanel panel2;
    private JLabel label4;
    private JLabel masseglabel;
    private JPanel panel3;
    private JButton okbtn2;
    private JButton nobtn2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
