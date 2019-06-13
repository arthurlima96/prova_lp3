package com.br.lp3.prova.principal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.br.lp3.prova.banco.CrudBD;
import com.br.lp3.prova.modelo.Aluno;
import com.br.lp3.prova.modelo.ComboItem;
import com.br.lp3.prova.modelo.Curso;

import net.miginfocom.swing.MigLayout;

public class FormAluno extends JInternalFrame{

    private JPanel panel;

    public void build() {
    	
    	panel = getPanel("Alunos");
		panel.setLayout(new MigLayout("wrap 4","[] 16 [grow] []"));
			
		panel.add(new JLabel("Código:"),"right");
		JTextField txtCod = new JTextField();
		panel.add(txtCod,"span, growx");
		
		panel.add(new JLabel("Nome:"),"right");
		JTextField txtNome = new JTextField();
		panel.add(txtNome,"span, growx");
		
		panel.add(new JLabel("Endereço:"),"right");
		JTextArea txtAreaEndereco = new JTextArea(10, 20);
		panel.add(txtAreaEndereco,"span, growx");
		
		panel.add(new JLabel("Telefone:"),"right");
		JTextField txtTelefone = new JTextField();
		panel.add(txtTelefone,"span, growx");
		
		panel.add(new JLabel("RG:"),"right");
		JTextField txtRG = new JTextField(20);
		panel.add(txtRG);
		
		panel.add(new JLabel("CPF:"),"right");
		JTextField txtCPF = new JTextField(30);
		panel.add(txtCPF,"span, growx");
		
		panel.add(new JLabel("Curso:"),"right");
		JComboBox cmbCurso = new JComboBox();
	    cmbCurso.setPreferredSize(new Dimension(200,10));
	    cmbCurso.removeAllItems();	    
	    CrudBD cp = new CrudBD();
		cp.mysqlConnect();
		try {
			List<Curso> cursos =  cp.query(Curso.class, "curso", "");
				cmbCurso.addItem(new ComboItem("Selecione", 0));
			for (Curso curso : cursos) {
				cmbCurso.addItem(curso);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			cp.closeConnection();
		}
		panel.add(cmbCurso,"span, growx");
				           
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
					aluno.setRG(Integer.valueOf(txtRG.getText()));
					aluno.setCPF(Integer.valueOf(txtCPF.getText()));
					Object item = cmbCurso.getSelectedItem();
					Integer id = ((ComboItem)item).getId();
					aluno.setCurso(id);
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
				CrudBD cp = new CrudBD();
				cp.mysqlConnect();
				try {
					List<Aluno> alunos =  cp.query(Aluno.class, "aluno", "");
					for (Aluno aluno : alunos) {
						System.out.println("Aluno: "+aluno.getNome());
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					cp.closeConnection();
				}
				txtCod.setText("");
				txtNome.setText("");
				txtAreaEndereco.setText("");
				txtTelefone.setText("");
				txtRG.setText("");
				txtCPF.setText("");
				cmbCurso.setSelectedIndex(0);
			}
		});
        
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
    private JPanel getPanel(String title) {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(title));
		return panel;
	}

	public FormAluno(String titulo, boolean b, boolean c, boolean d, boolean e) {
		super(titulo, b, c, d, e);
		this.build();
	}

}