package com.br.lp3.prova.principal;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

public class FormMatricula extends JInternalFrame{

    private JPanel pnlForm,pnlTable,pnlMain;
    private String[] listaCombo = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
    private  DefaultTableModel model;
  
    public void buildform() {
        pnlForm = new JPanel();
        pnlMain = new JPanel(new BorderLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblName = new JLabel("Aluno");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 0, 10);
        pnlForm.add(lblName, gbc);

        
        JComboBox<Object> cmbAlunos = new JComboBox<Object>(listaCombo);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        pnlForm.add(cmbAlunos, gbc);

        JLabel lblPhone = new JLabel("Curso");
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;        
        gbc.insets = new Insets(0, 10, 0, 10);
        pnlForm.add(lblPhone, gbc);

        JComboBox<Object> cmbCursos = new JComboBox<Object>(listaCombo);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 0, 10);
        pnlForm.add(cmbCursos, gbc);
        
        pnlTable = new JPanel();
        JTable table = new JTable();
        //Object [][] dados = {["dado", "dados"],["dado", "dados"]};
        JScrollPane tableContainer = new JScrollPane(table);
        
		pnlTable.add(tableContainer);

		model = (DefaultTableModel)table.getModel();
		model.addColumn("Codigo");
		model.addColumn("Aluno");
        
				
        JToolBar toolbar = new JToolBar();  
        toolbar.setRollover(true);  
       
        JButton btnAluno = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-adicionar-arquivo-32.png")));  
        toolbar.add(btnAluno);  
        JButton btnProfessor = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-editar-arquivo-32.png")));  
        toolbar.add(btnProfessor);  
        JButton btnCurso = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-salvar-arquivo-32.png")));  
        toolbar.add(btnCurso);  
        JButton btnDisciplina = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-apagar-arquivo-32.png")));  
        toolbar.add(btnDisciplina);  

        
        add(toolbar, BorderLayout.NORTH);   
        pnlMain.add(pnlForm,BorderLayout.NORTH);
        pnlMain.add(pnlTable,BorderLayout.SOUTH);
        this.getContentPane().add(pnlMain,BorderLayout.CENTER);
        
        //this.getContentPane().add(pnlTable,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }
    
    private void buildTable() {
    	
	}

	public FormMatricula(String titulo, boolean b, boolean c, boolean d, boolean e) {
		super(titulo, b, c, d, e);
		this.buildform();
		this.buildTable();
	}

}