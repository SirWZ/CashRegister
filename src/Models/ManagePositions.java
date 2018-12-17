/*
 * Created by JFormDesigner on Mon Nov 26 13:02:30 CET 2018
 */

package Models;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Yaroslav Kohun
 */
public class ManagePositions extends JFrame {
    public ManagePositions() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yaroslav Kohun
        panel1 = new JPanel();
        button1 = new JButton();
        panel2 = new JPanel();
        button2 = new JButton();
        comboBox1 = new JComboBox<>();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel3 = new JPanel();
        button3 = new JButton();

        //======== this ========
        setTitle("\u0414\u043e\u043b\u0436\u043d\u043e\u0441\u0442\u0438");
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {30, 0, 25, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {30, 0, 25, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {95, 377, 25, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {44, 0, 107, 0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- button1 ----
            button1.setText("\u041d\u0430\u0437\u0430\u0434");
            panel1.add(button1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== panel2 ========
            {
                panel2.setLayout(new GridBagLayout());
                ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {95, 139, 197, 0};
                ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {40, 0};
                ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- button2 ----
                button2.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0434\u043e\u043b\u0436\u043d\u043e\u0441\u0442\u044c");
                panel2.add(button2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- comboBox1 ----
                comboBox1.setToolTipText("\u0421\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u043a\u0430");
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                    "\u041f\u043e \u0434\u043e\u043b\u0436\u043d\u043e\u0441\u0442\u0438 (\u0432\u043e\u0437\u0440.)",
                    "\u041f\u043e \u0434\u043e\u043b\u0436\u043d\u043e\u0441\u0442\u0438 (\u0443\u0431\u044b\u0432.)",
                    "\u041f\u043e \u0441\u043e\u0442\u0440\u0443\u0434\u043d\u0438\u043a\u0443 (\u0432\u043e\u0440\u0437.)",
                    "\u041f\u043e \u0441\u043e\u0442\u0440\u0443\u0434\u043d\u0438\u043a\u0443 (\u0443\u0431\u044b\u0432.)"
                }));
                panel2.add(comboBox1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            panel1.add(panel2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null},
                        {null, null},
                    },
                    new String[] {
                        "\u0414\u043e\u043b\u0436\u043d\u043e\u0441\u0442\u0438", "\u0421\u043e\u0442\u0440\u0443\u0434\u043d\u0438\u043a\u0438"
                    }
                ));
                scrollPane1.setViewportView(table1);
            }
            panel1.add(scrollPane1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== panel3 ========
            {
                panel3.setLayout(new GridBagLayout());
                ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {29, 30, 31, 34, 217, 151, 0};
                ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {40, 0};
                ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- button3 ----
                button3.setText("\u0418\u0437\u043c\u0435\u043d\u0438\u0442\u044c");
                panel3.add(button3, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            panel1.add(panel3, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        }
        contentPane.add(panel1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yaroslav Kohun
    private JPanel panel1;
    private JButton button1;
    private JPanel panel2;
    private JButton button2;
    private JComboBox<String> comboBox1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel3;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
