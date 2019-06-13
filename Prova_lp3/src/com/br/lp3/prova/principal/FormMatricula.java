package com.br.lp3.prova.principal;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;

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

import com.br.lp3.prova.banco.CrudBD;
import com.br.lp3.prova.modelo.Aluno;
import com.br.lp3.prova.modelo.ComboItem;
import com.br.lp3.prova.modelo.Curso;

import net.miginfocom.swing.MigLayout;

public class FormMatricula extends JInternalFrame{

    private JPanel pnlForm;
    private String[] listaCombo = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
    private  DefaultTableModel model;
  
    public void buildform() {
        pnlForm = new JPanel(new MigLayout("debug","[][grow, fill][]",""));
        
      
        JLabel lblName = new JLabel("Aluno");        
        pnlForm.add(lblName,"width 50:150:150");
        
        
        JComboBox cmbAlunos = new JComboBox();
        cmbAlunos.removeAllItems();	    
	    CrudBD cp = new CrudBD();
		cp.mysqlConnect();
		try {
			List<Aluno> alunos =  cp.query(Aluno.class, "aluno", "");
				cmbAlunos.addItem(new ComboItem("Selecione", 0));
			for (Aluno aluno : alunos) {
				cmbAlunos.addItem(aluno);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			cp.closeConnection();
		}
        pnlForm.add(cmbAlunos,"wrap");

        JLabel lblPhone = new JLabel("Curso");        
        pnlForm.add(lblPhone,"width 50:150:150");

        JComboBox cmbCursos = new JComboBox();  
        cmbCursos.removeAllItems();	    
		cp.mysqlConnect();
		try {
			List<Curso> cursos =  cp.query(Curso.class, "curso", "");
				cmbCursos.addItem(new ComboItem("Selecione", 0));
			for (Curso curso : cursos) {
				cmbCursos.addItem(curso);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			cp.closeConnection();
		}
        pnlForm.add(cmbCursos,"wrap");
        
        JTable table = new JTable();
        JScrollPane tableContainer = new JScrollPane(table);
        
        pnlForm.add(tableContainer," growx, push, span, wrap");

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
        this.getContentPane().add(pnlForm);
        
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