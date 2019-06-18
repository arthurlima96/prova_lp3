package com.br.lp3.prova.principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import com.br.lp3.prova.banco.CrudBD;
import com.br.lp3.prova.modelo.ComboItem;
import com.br.lp3.prova.modelo.Disciplina;
import com.br.lp3.prova.modelo.Professor;

import net.miginfocom.swing.MigLayout;


public class FormProfDisciplina extends JInternalFrame{

	private JPanel pnlForm;
    private CrudBD db ;
    private List<Professor> professores;
    private List<Disciplina> disciplinas;
    private TableModel model ;
    private JTable table;
    private JScrollPane scrollPane;

    public FormProfDisciplina(String titulo, boolean b, boolean c, boolean d, boolean e) {
		super(titulo, b, c, d, e);
		db = new CrudBD();
		this.build();
	}
    
    public void build() {

        pnlForm = new JPanel(new MigLayout("debug","[][grow, fill][]",""));
        JLabel lblName = new JLabel("Professor");        
        pnlForm.add(lblName,"width 50:150:150");
        JComboBox cmbAlunos = new JComboBox();
        cmbAlunos.removeAllItems();	    
	   
		db.mysqlConnect();
		try {
			professores =  db.query(Professor.class, "professor", "");
				cmbAlunos.addItem(new ComboItem("Selecione", 0));
			for (Professor professor : professores) {
				cmbAlunos.addItem(new ComboItem(professor.getNome(), professor.getId()));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			db.closeConnection();
		}
        pnlForm.add(cmbAlunos,"wrap");

        JLabel lblPhone = new JLabel("Disciplina");        
        pnlForm.add(lblPhone,"width 50:150:150");

        JComboBox cmbCursos = new JComboBox();  
        cmbCursos.removeAllItems();	    
		db.mysqlConnect();
		try {
				disciplinas =  db.query(Disciplina.class, "disciplina", "");
				cmbCursos.addItem(new ComboItem("Selecione", 0));
			for (Disciplina disciplina : disciplinas) {
				cmbCursos.addItem(new ComboItem(disciplina.getDescricao(), disciplina.getId()));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			db.closeConnection();
		}
        pnlForm.add(cmbCursos,"wrap");
        
        DefaultTableModel dtm = new DefaultTableModel() {
            // make first cell uneditable
            public boolean isCellEditable(int row, int column)
            {
               return !(column == 0);
            }
         };
      
         final MyListModel dlm1 = new MyListModel(new Object[] { "value1", "value2", "value3",
                                                                 "value4", "value5", "value6" });
         final MyListModel dlm2 = new MyListModel(new Object[] { "value7", "value8", "value9",
                                                                 "value10", "value11", "value12" });
         
         MyListModel[] dlm = new MyListModel[professores.size()];
      
         dtm.setDataVector(carragarTable(dlm),
                           new Object[]{ "Professor","Disciplina"});
                           
         JTable table = new JTable(dtm);
         table.getColumn("Professor").setCellRenderer(new JListRenderer());
         table.getColumn("Disciplina").setCellEditor(new JListEditor());
         table.setRowHeight(80);
         JScrollPane scroll = new JScrollPane(table);
      
         pnlForm.add(scroll," growx, push, span, wrap");
        
        JToolBar toolbar = new JToolBar();  
        toolbar.setRollover(true);  
              
        JButton btnAdicionar = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-adicionar-arquivo-32.png")));  
        toolbar.add(btnAdicionar);  
        JButton btnEditar = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-editar-arquivo-32.png")));  
        toolbar.add(btnEditar);  
        JButton btnSalvar = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-salvar-arquivo-32.png")));  
        toolbar.add(btnSalvar);  
        JButton btnApagar = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-apagar-arquivo-32.png")));  
        toolbar.add(btnApagar);
        
        add(toolbar, BorderLayout.NORTH);   
        this.getContentPane().add(pnlForm);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        
        btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {					
					
					Object itemCurso = cmbCursos.getSelectedItem();
					Integer codCurso = ((ComboItem)itemCurso).getId();
					
					Object itemAluno = cmbAlunos.getSelectedItem();
					Integer codAluno = ((ComboItem)itemAluno).getId();
					
//					Aluno aluno = pegarAluno(codAluno);					
//					aluno.setCurso(codCurso);
					
					CrudBD cp = new CrudBD();
					cp.mysqlConnect();
//					cp.createUpdatePreparedStatement(aluno,"aluno","id");
					cp.closeConnection();
					JOptionPane.showMessageDialog(null, "Salvou com sucesso !");
//					table.setModel(carregarTable());
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error ao salvar !");
				}
			}
		});

    }

	private Object[][] carragarTable(MyListModel[] dlm) {
		Vector<Object> v = new Vector<Object>(); 
		Object[][] dados = new Object[2][2];
		
		for (Professor professor : professores) {
			 MyListModel dlm1 = new MyListModel(disciplinas.toArray());
		}
		for (int i = 0; i < 2; i++) {
		  for (int j = 0; j < 2; j++) {
			  if (j == 1){
				  dados[i][j] = new MyListModel(new Object[] { "value1", "value2", "value3",
	                      "value4", "value5", "value6" });
			  }else{
				  dados[i][j] = "Liste "+i;
			  }
			
		  }	                
		}
		new MyListModel(disciplinas.toArray());
		
		return dados;
	}

	private Object[][] carragarTable(final MyListModel dlm1) {
		List<Disciplina> d = disciplinas.stream().filter(p -> p.getProfessor().getCodigo() == "").collect(Collectors.toList());
		return new Object[][]{ { "JList1", d.toArray()}};
	}

}

class JListRenderer extends JScrollPane implements TableCellRenderer
{
   JList list;
  
   public JListRenderer() {
      list = new JList();
      list.setSelectionBackground(Color.red);
      getViewport().add(list);
   }
  
   public Component getTableCellRendererComponent(JTable table, Object value,
                                  boolean isSelected, boolean hasFocus,
                                  int row, int column)
   {
      if (isSelected) {
         setForeground(table.getSelectionForeground());
         setBackground(table.getSelectionBackground());
         list.setForeground(table.getSelectionForeground());
         list.setBackground(table.getSelectionBackground());
      } else {
         setForeground(table.getForeground());
         setBackground(table.getBackground());
         list.setForeground(table.getForeground());
         list.setBackground(table.getBackground());
      }
  
      list.setModel((MyListModel) value) ;
      list.setSelectedIndices(((MyListModel) value).getSelectedIndices());
 
      return this;
   }
}
 
class JListEditor extends DefaultCellEditor {
   protected JScrollPane scrollpane;
   protected JList list;
   protected MyListModel mlm;
  
   public JListEditor() {
      super(new JCheckBox());
      scrollpane = new JScrollPane();
      list = new JList(); 
//      list.setSelectionForeground(Color.red);
      list.setSelectionBackground(Color.red);
      scrollpane.getViewport().add(list);
   }
  
   public Component getTableCellEditorComponent(JTable table, Object value,
                                   boolean isSelected, int row, int column) {
      list.setModel((MyListModel) value);
 
      mlm = (MyListModel) value;
 
      return scrollpane;
   }
  
   public Object getCellEditorValue() {
      mlm.setSelectedIndices(list.getSelectedIndices());
      return mlm;
   }
}
 
 
class MyListModel extends DefaultListModel
{
   private int[] selectedIndices;
 
   public MyListModel(Object[] data) {
      for (int i=0; i<data.length; i++) {
         addElement(data[i]);
      }
   }
 
   public void setSelectedIndices(int[] selectedIndices) {
      this.selectedIndices = selectedIndices;
   }
 
   public int[] getSelectedIndices() {
      if (selectedIndices == null) return new int[]{};
      return selectedIndices;
   }
  
   public String toString() {
      StringBuffer sb = new StringBuffer();
      sb.append(super.toString());
      if (selectedIndices != null) {
         sb.append("nSelected:n");
         for (int i=0; i<selectedIndices.length; i++) {
            sb.append(get(selectedIndices[i]) + "n");
         }
      }
      return sb.toString();
   }
}