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

public class FormAluno extends JInternalFrame{

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
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.weightx = 1;
        pnlMain.add(txtName, gbc);

        JLabel lblPhone = new JLabel("Nome");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.weightx = 1;
        pnlMain.add(lblPhone, gbc);

        JTextField txtPhone = new JTextField();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.weightx = 1;
        pnlMain.add(txtPhone, gbc);

        JLabel lblAddress = new JLabel("Endereco");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 10, 0, 10);
        gbc.weightx = 1;
        pnlMain.add(lblAddress, gbc);

        JTextArea txtAreaAddress = new JTextArea(10, 20);
        JScrollPane pane = new JScrollPane(txtAreaAddress);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.weightx = 1;
        pnlMain.add(pane, gbc);
        
        JLabel lblEmail = new JLabel("Telefone");
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridwidth = 1;
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.insets = new Insets(0, 10, 0, 0);
	    gbc.weightx = 1;
	    pnlMain.add(lblEmail, gbc);

	    JTextField txtEmail = new JTextField();
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridwidth = 4;
	    gbc.gridx = 1;
	    gbc.gridy = 4;
	    gbc.weightx = 1;
	    gbc.insets = new Insets(5, 0, 0, 10);
	    pnlMain.add(txtEmail, gbc);
	    
	    JLabel lblRg = new JLabel("RG");
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridwidth = 1;
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    gbc.insets = new Insets(0, 10, 0, 0);
	    gbc.weightx = 1;
	    pnlMain.add(lblRg, gbc);

	    JTextField txtRg = new JTextField(100);
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridwidth = 1;
	    gbc.gridx = 1;
	    gbc.gridy = 5;
	    gbc.insets = new Insets(5, 0, 0, 10);
	    pnlMain.add(txtRg, gbc);
	    
	    JLabel lblCpf = new JLabel("CPF");
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridwidth = 1;
	    gbc.gridx = 2;
	    gbc.gridy = 5;
	    gbc.insets = new Insets(0, 10, 0, 0);
	    pnlMain.add(lblCpf, gbc);

	    JTextField txtCpf = new JTextField(100);
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridwidth = 1;
	    gbc.gridx = 3;
	    gbc.gridy = 5;
	    gbc.insets = new Insets(5, 0, 0, 10);
	    pnlMain.add(txtCpf, gbc);

        JButton btnSave = new JButton("Salvar");
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.insets = new Insets(10, 10, 10, 0);
        gbc.weightx = 1;
        pnlMain.add(btnSave, gbc);

        JButton btnCancelar = new JButton("Cancelar");
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1;
        pnlMain.add(btnCancelar, gbc);
        
        JToolBar toolbar = ToolBarBuilder.iniciaToolBar()
 				.comActionAbrir(null)
 				.comActionArquivo(null)
 				.comActionCancelar(null)
 				.comActionSalvar(null)
 				.constroi();
        
        add(toolbar, BorderLayout.NORTH);
        
        this.getContentPane().add(pnlMain);
        
        this.getContentPane().add(pnlMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

	public FormAluno(String titulo, boolean b, boolean c, boolean d, boolean e) {
		super(titulo, b, c, d, e);
		this.build();
	}

}