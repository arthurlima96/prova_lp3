package com.br.lp3.prova.principal;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Icon;
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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.br.lp3.prova.banco.CrudBD;
import com.br.lp3.prova.modelo.Aluno;
import com.br.lp3.prova.modelo.ComboItem;
import com.br.lp3.prova.modelo.Curso;

import net.miginfocom.swing.MigLayout;

public class FormMatricula extends JInternalFrame{

    private JPanel pnlForm;
    private String[] listaCombo = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
    private DefaultTableModel model;
    private CrudBD db ;
    private List<Aluno> alunos;
    private List<Curso> cursos;
    
    public void buildform() {
        pnlForm = new JPanel(new MigLayout("debug","[][grow, fill][]",""));
        JLabel lblName = new JLabel("Aluno");        
        pnlForm.add(lblName,"width 50:150:150");
        JComboBox cmbAlunos = new JComboBox();
        cmbAlunos.removeAllItems();	    
	   
		db.mysqlConnect();
		try {
			    alunos =  db.query(Aluno.class, "aluno", "");
				cmbAlunos.addItem(new ComboItem("Selecione", 0));
			for (Aluno aluno : alunos) {
				cmbAlunos.addItem(aluno);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			db.closeConnection();
		}
        pnlForm.add(cmbAlunos,"wrap");

        JLabel lblPhone = new JLabel("Curso");        
        pnlForm.add(lblPhone,"width 50:150:150");

        JComboBox cmbCursos = new JComboBox();  
        cmbCursos.removeAllItems();	    
		db.mysqlConnect();
		try {
			cursos =  db.query(Curso.class, "curso", "");
				cmbCursos.addItem(new ComboItem("Selecione", 0));
			for (Curso curso : cursos) {
				cmbCursos.addItem(curso);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			db.closeConnection();
		}
        pnlForm.add(cmbCursos,"wrap");
        pnlForm.add(exibirTable()," growx, push, span, wrap");
        
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

	private JScrollPane exibirTable() {
		TableModel model = carregarTable();
	    JTable table = new JTable(model);
	    JScrollPane scrollPane = new JScrollPane(table);
		return scrollPane;
	}

	private TableModel carregarTable() {
		TableModel model = new AbstractTableModel() {

            List<Aluno> alunos = FormMatricula.this.alunos;
            
            String columnNames[] = { "Aluno", "Curso"};

            public int getColumnCount() {
              return columnNames.length;
            }

			public String getColumnName(int column) {
              return columnNames[column];
            }

            public int getRowCount() {
              return alunos.size();
            }

            public Object getValueAt(int row, int column) {
            	 switch (column) {
                 case 0:
                     return this.alunos.get(row).getNome();
                 case 1:
                     return pegarCurso(this.alunos.get(row).getCurso());
                 default:
                     return "-";
             }
            }

            
            private Object pegarCurso(Integer curso_id) {
				for (Curso curso : cursos) {
					if(curso.getId().equals(curso_id)){
						return curso.getDescricao();
					}
				}
				return "Não Matriculado";
			}

			private List<Aluno> getAlunos() {
            	db.mysqlConnect();
        		try {
        			List<Aluno> alunos =  db.query(Aluno.class, "aluno","");
        		} catch (SQLException e1) {
        			e1.printStackTrace();
        		}finally {
        			db.closeConnection();
        		}
				return alunos;
			}
          };
		return model;
	}
	
	public FormMatricula(String titulo, boolean b, boolean c, boolean d, boolean e) {
		super(titulo, b, c, d, e);
		db = new CrudBD();
		this.buildform();
		
	}

}