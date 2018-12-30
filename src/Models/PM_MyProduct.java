/*
 * Created by JFormDesigner on Sun Dec 30 16:29:19 CET 2018
 */

package Models;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.Date;

/**
 * @author k
 */
public class PM_MyProduct extends JFrame {
    Connection cn;
    public PM_MyProduct(Connection cn) {
        this.cn = cn;
        this.setVisible(false);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                extBtnActionPerformed();
            }
        });
        initComponents();
        categoryFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {exitFromCategoryListBttnActionPerformed();}
        });
        categoryOrListDialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {exitToPMBtnActionPerformed();}
        });
        categoryOrListDialog.setVisible(true);
    }

    private void listOfProductsBtnActionPerformed() {
        categoryOrListDialog.dispose();
        this.setVisible(true);
    }

    private void exitFromCategoryListBttnActionPerformed() {
        categoryFrame.dispose();
        categoryOrListDialog.setVisible(true);
    }

    private void extBtnActionPerformed() {
        this.dispose();
        categoryOrListDialog.setVisible(true);
    }

    private void exitToPMBtnActionPerformed() {
        categoryOrListDialog.dispose();
        new ProductManagment(cn).setVisible(true);
    }

    private void listOfCategoryBttnActionPerformed() {
        categoryOrListDialog.dispose();
        categoryFrame.setVisible(true);
    }

    private void exitFromAddingCategoryDialogBtnActionPerformed() {
        addNewCattegoryDialog.dispose();

    }

    private void addNewCategoryDialogBtnActionPerformed() {
        addNewCattegoryDialog.setVisible(true);
    }

    private void addNewCategoryBtnActionPerformed() {
        addNewCattegoryDialog.dispose();
        JOptionPane.showMessageDialog(addNewCattegoryDialog,"Категория успешно добавлена.","",JOptionPane.INFORMATION_MESSAGE);
    }

    private void showAddProdDialogBtnActionPerformed() {
        this.dispose();
        new AddProduct(cn).setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - k
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        extBtn = new JButton();
        showAddProdDialogBtn = new JButton();
        textField2 = new JTextField();
        textField1 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        findBtn = new JButton();
        sortingCB = new JComboBox();
        scrollPane1 = new JScrollPane();
        ptodTable = new JTable();
        panel3 = new JPanel();
        label1 = new JLabel();
        summaryCountOfProductsLBL = new JLabel();
        button8 = new JButton();
        categoryOrListDialog = new JDialog();
        exitToPMBtn = new JButton();
        showListOfCategoryBttn = new JButton();
        showListOfProductsBtn = new JButton();
        categoryFrame = new JFrame();
        panel4 = new JPanel();
        exitFromCategoryListBttn = new JButton();
        showaddNewCategoryDialogBtn = new JButton();
        sortngCategoryCB = new JComboBox();
        panel6 = new JPanel();
        scrollPane2 = new JScrollPane();
        categoryTable = new JTable();
        addNewCattegoryDialog = new JDialog();
        exitFromAddingCategoryDialogBtn = new JButton();
        label2 = new JLabel();
        idCategoryTF = new JTextField();
        label3 = new JLabel();
        nameCategoryTF = new JTextField();
        addNewCategoryBtn = new JButton();

        //======== this ========
        setTitle("\u041c\u043e\u0438 \u0442\u043e\u0432\u0430\u0440\u044b");
        setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(800, 300));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new MigLayout(
                    "insets dialog,hidemode 3",
                    // columns
                    "[grow,fill]",
                    // rows
                    "[]" +
                    "[grow]" +
                    "[]"));

                //======== panel1 ========
                {
                    panel1.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[fill]para" +
                        "[122,grow,fill]" +
                        "[175,grow,fill]" +
                        "[119,grow,fill]" +
                        "[162,grow,fill]rel" +
                        "[101,grow,fill]para" +
                        "[132,grow,fill]",
                        // rows
                        "[]" +
                        "[grow]" +
                        "[]0" +
                        "[]0" +
                        "[grow,fill]0" +
                        "[]"));

                    //---- extBtn ----
                    extBtn.setText("\u0412\u044b\u0445\u043e\u0434");
                    extBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    extBtn.addActionListener(e -> extBtnActionPerformed());
                    panel1.add(extBtn, "cell 0 1");

                    //---- showAddProdDialogBtn ----
                    showAddProdDialogBtn.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c");
                    showAddProdDialogBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    showAddProdDialogBtn.addActionListener(e -> showAddProdDialogBtnActionPerformed());
                    panel1.add(showAddProdDialogBtn, "cell 0 4");

                    //---- textField2 ----
                    textField2.setText("\u0428\u0442\u0440\u0438\u0445-\u043a\u043e\u0434");
                    textField2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    panel1.add(textField2, "cell 1 4");

                    //---- textField1 ----
                    textField1.setText("\u041d\u0430\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u043d\u0438\u0435");
                    textField1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    panel1.add(textField1, "cell 2 4");

                    //---- textField3 ----
                    textField3.setText("\u041a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u044f");
                    textField3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    panel1.add(textField3, "cell 3 4");

                    //---- textField4 ----
                    textField4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    textField4.setText("\u041f\u0440\u043e\u0438\u0437\u0432\u043e\u0434\u0438\u0442\u0435\u043b\u044c");
                    panel1.add(textField4, "cell 4 4");

                    //---- findBtn ----
                    findBtn.setText("\u041f\u043e\u0438\u0441\u043a");
                    findBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    panel1.add(findBtn, "cell 5 4");

                    //---- sortingCB ----
                    sortingCB.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    panel1.add(sortingCB, "cell 6 4");
                }
                contentPanel.add(panel1, "cell 0 0");

                //======== scrollPane1 ========
                {

                    //---- ptodTable ----
                    ptodTable.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null},
                        },
                        new String[] {
                            "\u041a\u043e\u0434 \u0442\u043e\u0432\u0430\u0440\u0430", "\u0418\u043c\u044f", "\u0411\u0430\u0437\u043e\u0432\u0430\u044f \u0435\u0434. \u0438\u0437.", "\u041f\u0440\u043e\u0438\u0437\u0432\u043e\u0434\u0438\u0442\u0435\u043b\u044c", "\u0414\u0430\u0442\u0430 \u0434\u043e\u0431./\u0440\u0435\u0434.", "\u041d\u0414\u0421", "\u0426\u0435\u043d\u0430 \u043f\u0440\u043e\u0434\u0430\u0436\u0438", "\u041a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u044f (\u0433\u043b\u0430\u0432\u043d\u0430\u044f)"
                        }
                    ) {
                        Class<?>[] columnTypes = new Class<?>[] {
                            Integer.class, String.class, String.class, String.class, Date.class, Integer.class, Double.class, String.class
                        };
                        boolean[] columnEditable = new boolean[] {
                            false, false, false, false, false, false, false, false
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
                        TableColumnModel cm = ptodTable.getColumnModel();
                        cm.getColumn(0).setResizable(false);
                        cm.getColumn(1).setResizable(false);
                        cm.getColumn(1).setPreferredWidth(180);
                        cm.getColumn(2).setResizable(false);
                        cm.getColumn(2).setPreferredWidth(115);
                        cm.getColumn(3).setResizable(false);
                        cm.getColumn(3).setPreferredWidth(150);
                        cm.getColumn(4).setResizable(false);
                        cm.getColumn(4).setPreferredWidth(110);
                        cm.getColumn(5).setResizable(false);
                        cm.getColumn(6).setResizable(false);
                        cm.getColumn(6).setPreferredWidth(95);
                        cm.getColumn(7).setResizable(false);
                        cm.getColumn(7).setPreferredWidth(115);
                    }
                    ptodTable.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    scrollPane1.setViewportView(ptodTable);
                }
                contentPanel.add(scrollPane1, "cell 0 1");

                //======== panel3 ========
                {
                    panel3.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[fill]" +
                        "[fill]" +
                        "[575,fill]" +
                        "[fill]",
                        // rows
                        "[]"));

                    //---- label1 ----
                    label1.setText("\u0412\u0441\u0435\u0433\u043e (\u043a\u043e\u043b-\u0432\u043e) \u0422\u043e\u0432\u0430\u0440\u043e\u0432 ");
                    label1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    panel3.add(label1, "cell 0 0");

                    //---- summaryCountOfProductsLBL ----
                    summaryCountOfProductsLBL.setText("xx");
                    summaryCountOfProductsLBL.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    panel3.add(summaryCountOfProductsLBL, "cell 1 0");

                    //---- button8 ----
                    button8.setText("\u041f\u0435\u0447\u0430\u0442\u044c");
                    button8.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    panel3.add(button8, "cell 3 0");
                }
                contentPanel.add(panel3, "cell 0 2");
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(955, 475);
        setLocationRelativeTo(null);

        //======== categoryOrListDialog ========
        {
            categoryOrListDialog.setAlwaysOnTop(true);
            categoryOrListDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            categoryOrListDialog.setResizable(false);
            var categoryOrListDialogContentPane = categoryOrListDialog.getContentPane();
            categoryOrListDialogContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]0" +
                "[grow,fill]para" +
                "[grow,fill]para" +
                "[grow,fill]",
                // rows
                "[]para" +
                "[grow,fill]"));

            //---- exitToPMBtn ----
            exitToPMBtn.setText("\u0412\u044b\u0445\u043e\u0434");
            exitToPMBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            exitToPMBtn.addActionListener(e -> exitToPMBtnActionPerformed());
            categoryOrListDialogContentPane.add(exitToPMBtn, "cell 0 0");

            //---- showListOfCategoryBttn ----
            showListOfCategoryBttn.setText("\u041a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u0438");
            showListOfCategoryBttn.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            showListOfCategoryBttn.addActionListener(e -> listOfCategoryBttnActionPerformed());
            categoryOrListDialogContentPane.add(showListOfCategoryBttn, "cell 1 1");

            //---- showListOfProductsBtn ----
            showListOfProductsBtn.setText("\u0421\u043f\u0438\u0441\u043e\u043a");
            showListOfProductsBtn.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            showListOfProductsBtn.addActionListener(e -> listOfProductsBtnActionPerformed());
            categoryOrListDialogContentPane.add(showListOfProductsBtn, "cell 2 1");
            categoryOrListDialog.setSize(485, 200);
            categoryOrListDialog.setLocationRelativeTo(categoryOrListDialog.getOwner());
        }

        //======== categoryFrame ========
        {
            categoryFrame.setTitle("\u041a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u0438");
            var categoryFrameContentPane = categoryFrame.getContentPane();
            categoryFrameContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[grow,fill]",
                // rows
                "[]0" +
                "[]0" +
                "[]0" +
                "[]"));

            //======== panel4 ========
            {

                // JFormDesigner evaluation mark
                panel4.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel4.getBorder())); panel4.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel4.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[193,grow,fill]" +
                    "[150,grow,fill]",
                    // rows
                    "[0]0" +
                    "[fill]0" +
                    "[]0" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- exitFromCategoryListBttn ----
                exitFromCategoryListBttn.setText("\u0412\u044b\u0445\u043e\u0434");
                exitFromCategoryListBttn.addActionListener(e -> exitFromCategoryListBttnActionPerformed());
                panel4.add(exitFromCategoryListBttn, "cell 0 1,growy");

                //---- showaddNewCategoryDialogBtn ----
                showaddNewCategoryDialogBtn.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u043a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u044e");
                showaddNewCategoryDialogBtn.addActionListener(e -> addNewCategoryDialogBtnActionPerformed());
                panel4.add(showaddNewCategoryDialogBtn, "cell 1 4");
                panel4.add(sortngCategoryCB, "cell 3 4");
            }
            categoryFrameContentPane.add(panel4, "cell 0 0");

            //======== panel6 ========
            {
                panel6.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[grow,fill]",
                    // rows
                    "[grow,fill]0" +
                    "[]0" +
                    "[]"));

                //======== scrollPane2 ========
                {

                    //---- categoryTable ----
                    categoryTable.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, "", null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                        },
                        new String[] {
                            "Id \u041a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u0438", "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u0438", "\u041a\u043e\u043b-\u0432\u043e \u0448\u0442\u0443\u043a \u0432 \u043a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u0438", "\u0414\u0430\u0442\u0430 \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f"
                        }
                    ) {
                        Class<?>[] columnTypes = new Class<?>[] {
                            Integer.class, String.class, Integer.class, Date.class
                        };
                        boolean[] columnEditable = new boolean[] {
                            false, false, false, false
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
                        TableColumnModel cm = categoryTable.getColumnModel();
                        cm.getColumn(0).setResizable(false);
                        cm.getColumn(1).setResizable(false);
                        cm.getColumn(1).setPreferredWidth(145);
                        cm.getColumn(2).setResizable(false);
                        cm.getColumn(2).setPreferredWidth(155);
                        cm.getColumn(3).setResizable(false);
                        cm.getColumn(3).setPreferredWidth(135);
                    }
                    scrollPane2.setViewportView(categoryTable);
                }
                panel6.add(scrollPane2, "cell 0 0");
            }
            categoryFrameContentPane.add(panel6, "cell 0 2");
            categoryFrame.pack();
            categoryFrame.setLocationRelativeTo(categoryFrame.getOwner());
        }

        //======== addNewCattegoryDialog ========
        {
            addNewCattegoryDialog.setAlwaysOnTop(true);
            var addNewCattegoryDialogContentPane = addNewCattegoryDialog.getContentPane();
            addNewCattegoryDialogContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]0" +
                "[90,fill]para" +
                "[271,fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- exitFromAddingCategoryDialogBtn ----
            exitFromAddingCategoryDialogBtn.setText("\u0412\u044b\u0445\u043e\u0434");
            exitFromAddingCategoryDialogBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            exitFromAddingCategoryDialogBtn.addActionListener(e -> exitFromAddingCategoryDialogBtnActionPerformed());
            addNewCattegoryDialogContentPane.add(exitFromAddingCategoryDialogBtn, "cell 0 0");

            //---- label2 ----
            label2.setText("\u041d\u0435\u0457\u0431\u0443 \u043d\u0430\u0445\u0435\u0440\u0430 \u0446\u0435 \u043f\u043e\u043b\u0435 \u043d\u0430\u0434\u0430");
            label2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            addNewCattegoryDialogContentPane.add(label2, "cell 1 1");

            //---- idCategoryTF ----
            idCategoryTF.setText("\u044f\u043a\u0448\u043e \u0432 \u043d\u044c\u043e\u0433\u043e \u043c\u0438 \u043d\u0456\u0447\u043e\u0433\u043e \u0432\u043f\u0438\u0441\u0430\u0442\u044c \u043d\u0435 \u043c\u043e\u0436\u0435\u043c");
            idCategoryTF.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            idCategoryTF.setEditable(false);
            addNewCattegoryDialogContentPane.add(idCategoryTF, "cell 2 1");

            //---- label3 ----
            label3.setText("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u0438");
            label3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            addNewCattegoryDialogContentPane.add(label3, "cell 1 2");

            //---- nameCategoryTF ----
            nameCategoryTF.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            addNewCattegoryDialogContentPane.add(nameCategoryTF, "cell 2 2");

            //---- addNewCategoryBtn ----
            addNewCategoryBtn.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c");
            addNewCategoryBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            addNewCategoryBtn.addActionListener(e -> addNewCategoryBtnActionPerformed());
            addNewCattegoryDialogContentPane.add(addNewCategoryBtn, "cell 2 3,alignx trailing,growx 0");
            addNewCattegoryDialog.pack();
            addNewCattegoryDialog.setLocationRelativeTo(addNewCattegoryDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - k
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JButton extBtn;
    private JButton showAddProdDialogBtn;
    private JTextField textField2;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField4;
    private JButton findBtn;
    private JComboBox sortingCB;
    private JScrollPane scrollPane1;
    private JTable ptodTable;
    private JPanel panel3;
    private JLabel label1;
    private JLabel summaryCountOfProductsLBL;
    private JButton button8;
    private JDialog categoryOrListDialog;
    private JButton exitToPMBtn;
    private JButton showListOfCategoryBttn;
    private JButton showListOfProductsBtn;
    private JFrame categoryFrame;
    private JPanel panel4;
    private JButton exitFromCategoryListBttn;
    private JButton showaddNewCategoryDialogBtn;
    private JComboBox sortngCategoryCB;
    private JPanel panel6;
    private JScrollPane scrollPane2;
    private JTable categoryTable;
    private JDialog addNewCattegoryDialog;
    private JButton exitFromAddingCategoryDialogBtn;
    private JLabel label2;
    private JTextField idCategoryTF;
    private JLabel label3;
    private JTextField nameCategoryTF;
    private JButton addNewCategoryBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
