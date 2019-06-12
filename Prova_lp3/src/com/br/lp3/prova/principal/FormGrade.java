package com.br.lp3.prova.principal;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class FormGrade extends JInternalFrame{

    private JPanel pnlMain;

    public void build() {
        pnlMain = new JPanel();
        pnlMain.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblName = new JLabel("Codigo");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.weightx = 1;
        pnlMain.add(lblName, gbc);

        JTextField txtName = new JTextField();
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.weightx = 1;
        pnlMain.add(txtName, gbc);

        JLabel lblPhone = new JLabel("Curso");
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;        
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.weightx = 1;
        pnlMain.add(lblPhone, gbc);

        JTextField txtPhone = new JTextField();
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.weightx = 1;
        pnlMain.add(txtPhone, gbc);

//        JLabel lblEmail = new JLabel("Email");
//        gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridwidth = 1;
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        gbc.insets = new Insets(0, 10, 0, 0);
//        gbc.weightx = 1;
//        pnlMain.add(lblEmail, gbc);
//
//        JTextField txtEmail = new JTextField();
//        gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridwidth = 3;
//        gbc.gridx = 1;
//        gbc.gridy = 2;
//        gbc.weightx = 1;
//        gbc.insets = new Insets(5, 0, 0, 10);
//        pnlMain.add(txtEmail, gbc);
//
//        JLabel lblAddress = new JLabel("Address");
//        gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridwidth = 1;
//        gbc.gridx = 0;
//        gbc.gridy = 3;
//        gbc.insets = new Insets(0, 10, 0, 10);
//        gbc.weightx = 1;
//        pnlMain.add(lblAddress, gbc);
//
//        JTextArea txtAreaAddress = new JTextArea(10, 20);
//        JScrollPane pane = new JScrollPane(txtAreaAddress);
//        gbc = new GridBagConstraints();
//        gbc.anchor = GridBagConstraints.NORTH;
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.gridx = 1;
//        gbc.gridy = 3;
//        gbc.gridwidth = 4;
//        gbc.insets = new Insets(5, 0, 0, 10);
//        gbc.weightx = 1;
//        pnlMain.add(pane, gbc);

        JButton btnSave = new JButton("Salvar");
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 10, 10, 0);
        gbc.weightx = 1;
        pnlMain.add(btnSave, gbc);
       
        JButton btnCancel2 = new JButton("Cancelar");
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1;
        pnlMain.add(btnCancel2, gbc);
        
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
        
        this.getContentPane().add(pnlMain);
        
        this.getContentPane().add(pnlMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

	public FormGrade(String titulo, boolean b, boolean c, boolean d, boolean e) {
		super(titulo, b, c, d, e);
		this.build();
	}

}