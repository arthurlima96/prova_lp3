package com.br.lp3.prova.principal;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import com.br.lp3.prova.banco.CrudBD;
import com.br.lp3.prova.banco.CrudBDProfessor;
import com.br.lp3.prova.modelo.Aluno;
import com.br.lp3.prova.modelo.Curso;
import com.br.lp3.prova.modelo.Professor;

public class FormAluno extends JInternalFrame{

    private JPanel pnlMain;

    public void build() {
        pnlMain = new JPanel();
        pnlMain.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lbCod = new JLabel("Codigo");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.weightx = 1;
        pnlMain.add(lbCod, gbc);

        JTextField txtCod = new JTextField();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.weightx = 1;
        pnlMain.add(txtCod, gbc);

        JLabel lbNome = new JLabel("Nome");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.weightx = 1;
        pnlMain.add(lbNome, gbc);

        JTextField txtNome = new JTextField();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.weightx = 1;
        pnlMain.add(txtNome, gbc);

        JLabel lbEndereco = new JLabel("Endereco");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 10, 0, 10);
        gbc.weightx = 1;
        pnlMain.add(lbEndereco, gbc);

        JTextArea txtAreaEndereco = new JTextArea(10, 20);
        JScrollPane pane = new JScrollPane(txtAreaEndereco);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.weightx = 1;
        pnlMain.add(pane, gbc);
        
        JLabel lbTelefone = new JLabel("Telefone");
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridwidth = 1;
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.insets = new Insets(0, 10, 0, 0);
	    gbc.weightx = 1;
	    pnlMain.add(lbTelefone, gbc);

	    JTextField txtEmail = new JTextField();
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridwidth = 4;
	    gbc.gridx = 1;
	    gbc.gridy = 4;
	    gbc.weightx = 1;
	    gbc.insets = new Insets(5, 0, 0, 10);
	    pnlMain.add(txtEmail, gbc);
	    
	    JLabel lbRg = new JLabel("RG");
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridwidth = 1;
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    gbc.insets = new Insets(0, 10, 0, 0);
	    gbc.weightx = 1;
	    pnlMain.add(lbRg, gbc);

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
        
        JToolBar toolbar = new JToolBar();  
        toolbar.setRollover(true);  
       
        JButton adicionar = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-adicionar-arquivo-32.png")));  
        toolbar.add(adicionar);  
        JButton editar = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-editar-arquivo-32.png")));  
        toolbar.add(editar);  
        JButton salvar = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-salvar-arquivo-32.png")));  
        toolbar.add(salvar);  
        JButton apagar = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-apagar-arquivo-32.png")));  
        toolbar.add(apagar);  
        
        add(toolbar, BorderLayout.NORTH);
        
        this.getContentPane().add(pnlMain);
        
        this.getContentPane().add(pnlMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        
        salvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {					
					Aluno aluno = new Aluno();
					aluno.setCodigo(txtCod.getText());
					aluno.setNome(txtNome.getText());
					aluno.setEndereco(txtAreaEndereco.getText());
					aluno.setCurso(1);
					CrudBD cp = new CrudBD();
					cp.mysqlConnect();
					cp.createInsertPreparedStatement(aluno,"aluno");
					cp.closeConnection();
					JOptionPane.showMessageDialog(null, "Salvou com sucesso !");
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error ao salvar !");
				}
			}
		});
        
        apagar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtCod.setText("");
				txtNome.setText("");
			}
		});

    }

	public FormAluno(String titulo, boolean b, boolean c, boolean d, boolean e) {
		super(titulo, b, c, d, e);
		this.build();
	}

}