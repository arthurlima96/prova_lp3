package com.br.lp3.prova.principal;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.br.lp3.prova.modelo.ComboItem;

import net.miginfocom.swing.MigLayout;

public class ProductPanel2 extends JPanel {

private JLabel lblProd;
private JButton butAdd;
private JButton butRemove;
private JButton butEdit;
private JScrollPane scroll;
private JTable table;
private static final long serialVersionUID = 1L;
public JList<String> lst_Options;
private JScrollPane scr_Data;
private JComboBox<ComboItem> cmb_Suppliers;


//Generar de inmediato
private JButton btn_NewUpdate;
private JButton btn_Delete;
private JButton btn_Copy;
private JTable tbl_Settings;
private JLabel lbl_SelectedOption;
private JPanel filterPanel;
private JLabel lbl_cmb_supplier;
private JButton btn_search;

public ProductPanel2() {
    initComponents();
}

private void initComponents() {

    lblProd = new JLabel("Product List: ");
    lbl_cmb_supplier = new JLabel("Proveedor");
    btn_NewUpdate = new JButton("Add");
    btn_Delete = new JButton("Remove");
    lbl_SelectedOption = new JLabel("Tipo de datos");
    JLabel lbl_Opciones = new JLabel("Opciones");
    cmb_Suppliers = new JComboBox<ComboItem>();     

    btn_Delete = new JButton("Eliminar");
    btn_search = new JButton("Search");
    btn_NewUpdate = new JButton("Nuevo");
    scr_Data = new JScrollPane();
    JComboBox<String> cmb_Suppliers = new JComboBox<String>();
    
    tbl_Settings = createTable();
    tbl_Settings.setFillsViewportHeight(true);
    scr_Data = new JScrollPane(tbl_Settings);
    tbl_Settings.setPreferredScrollableViewportSize(tbl_Settings.getPreferredSize());
    filterPanel = new JPanel();

    setLayout(new MigLayout("debug"));
    filterPanel.add(lbl_cmb_supplier);
    filterPanel.add(cmb_Suppliers);     
    filterPanel.add(lbl_cmb_supplier);
    filterPanel.add(cmb_Suppliers);  
    filterPanel.add(btn_search, "grow, spany, wrap");
    add(filterPanel, "wrap");
    add(scr_Data, " growx, push, span, wrap");
    refreshCombo(cmb_Suppliers);
}
private void refreshCombo(JComboBox<String> combo) {
    combo.removeAllItems();
    try {

    } catch (Exception e) {
        //log.logToFile("refreshCombo: " + e.getClass().getName() + ": " + e.getMessage(), 1);
        e.printStackTrace();
    }       
}
private JTable createTable() {

    String[] columnNames = "Name 1,Name 2,Name 3,Name 4,Name 5".split(",");

    int rows = 30;
    int cols = columnNames.length;
    String[][] data = new String[rows][cols];

    for(int i=0; i<rows; i++) {
        for(int j=0; j<cols; j++) {
            data[i][j] = "R"+i+" C"+j;
        }
    }
    JTable table = new JTable(data, columnNames);

    return table;
}
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            JFrame frame = new JFrame();
            ProductPanel2 pane = new ProductPanel2();
            frame.setContentPane(pane);
            frame.setSize(1000,1000);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    });        

}
}