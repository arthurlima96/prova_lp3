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

import com.br.lp3.prova.banco.CrudBDProfessor;
import com.br.lp3.prova.modelo.Professor;

public class FormProfessor extends JInternalFrame{

    private JPanel pnlMain;
    public FormProfessor(String titulo, boolean b, boolean c, boolean d, boolean e) {
		super(titulo, b, c, d, e);
		this.build();
	}
    
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

        JTextField txtCod = new JTextField();
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.weightx = 1;
        pnlMain.add(txtCod, gbc);

        JLabel lblPhone = new JLabel("Professor");
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.weightx = 1;
        pnlMain.add(lblPhone, gbc);

        JTextField txtNome = new JTextField();
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.weightx = 1;
        pnlMain.add(txtNome, gbc);

/*      JButton btnSave = new JButton("Salvar");
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
        pnlMain.add(btnCancel2, gbc);*/
        
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
					Professor professor = new Professor(txtCod.getText(), txtNome.getText());
					CrudBDProfessor cp = new CrudBDProfessor();
					cp.mysqlConnect();
					cp.createInsertPreparedStatement(professor,"professor");
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
}