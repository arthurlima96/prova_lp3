package com.br.lp3.prova.principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Home extends JFrame{

	 private JMenu menuArq, menuAjuda, menuTable, menuSPF;  
     private JMenuItem iSair, iSobre, iAluno, iCurso, iDisciplina, iProfessor,iMatricula,iGrade,iProfDisciplina;  
     private JDesktopPane   mdiPane  = null;
     public static int fy = 0;
     public static int fx = 0;
     
     public Home(){  
	     super("Home");  
	     
	     JMenuBar mb=new JMenuBar();  
	     
	     menuArq=new JMenu("Arquivo");  
	     menuTable=new JMenu("Tabela"); 
	     menuSPF=new JMenu("SPF"); 
	     menuAjuda=new JMenu("Ajuda");  
	     
	     iSair=new JMenuItem("Sair");  
	     iSobre=new JMenuItem("Sobre");  
	     iAluno = new JMenuItem("Aluno");
	     iCurso = new JMenuItem("Curso");
	     iDisciplina = new JMenuItem("Disciplina");
	     iProfessor = new JMenuItem("Professor");
	     iMatricula = new JMenuItem("Matrícula");
	     iGrade = new JMenuItem("Grade");
	     iProfDisciplina = new JMenuItem("Prof. Disciplina");
	     
	     menuArq.add(iSair); 
	     menuTable.add(iAluno);
	     menuTable.add(iCurso);
	     menuTable.add(iDisciplina);
	     menuTable.add(iProfessor);
	     menuSPF.add(iMatricula);
	     menuSPF.add(iGrade);
	     menuSPF.add(iProfDisciplina);
	     menuAjuda.add(iSobre); 
	     
	     mb.add(menuArq);
	     mb.add(menuTable);
	     mb.add(menuSPF);
	     mb.add(menuAjuda);
	     setJMenuBar(mb);  
	     
	     JToolBar toolbar = ToolBarBuilder.iniciaToolBar()
	    		 				.comActionAbrir(null)
	    		 				.comActionArquivo(null)
	    		 				.comActionCancelar(null)
	    		 				.comActionSalvar(null)
	    		 				.constroi();//new JToolBar();  
         //toolbar.setRollover(true);  
        
         /*JButton btnAluno = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-mulher-estudante-32.png")));  
         toolbar.add(btnAluno);  
         JButton btnProfessor = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-treinamento-32.png")));  
         toolbar.add(btnProfessor);  
         JButton btnCurso = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-livro-32.png")));  
         toolbar.add(btnCurso);  
         JButton btnDisciplina = new JButton(new ImageIcon(getClass().getResource("/imgs/icons8-cursos-32.png")));  
         toolbar.add(btnDisciplina);  */
         
         add(toolbar, BorderLayout.SOUTH);
	     
	     this.getContentPane().add(getMdiPane(), BorderLayout.CENTER);
	     setSize(new Dimension(900, 850)); 
	     setLocationRelativeTo(null);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setVisible(true);  
	     
	     	iSair.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent evt) {		                
			        	
			        	 int input = JOptionPane.showConfirmDialog(null, "Deseja Sair", "Sair do Sistema",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		        		 if(input==0)
							 System.exit(0); 
			        }
		    });
	     	
	     	iSobre.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent evt) {
		        	
		        	JInternalFrame mdiFrame = new JInternalFrame("Aplicação Prova",true,true,true,true);
	                
		        	JPanel panel = new JPanel();
		    		panel.setBackground(new Color(102, 205, 170));
		    		panel.setSize(new Dimension(200, 96));
		    		panel.setLayout(null);

		    		JLabel label1 = new JLabel("Aplicação Prova 2");
		    		label1.setVerticalAlignment(SwingConstants.BOTTOM);
		    		label1.setBounds(0, 0, 200, 32);
		    		label1.setFont(new Font("Arial", Font.BOLD, 10));
		    		label1.setHorizontalAlignment(SwingConstants.CENTER);
		    		panel.add(label1);

		    		JLabel label2 = new JLabel("Versão: 1.0 ");
		    		label2.setVerticalAlignment(SwingConstants.TOP);
		    		label2.setHorizontalAlignment(SwingConstants.CENTER);
		    		label2.setFont(new Font("Arial", Font.BOLD, 10));
		    		label2.setBounds(0, 32, 200, 32);
		    		panel.add(label2);
		    		
		    		JLabel label3 = new JLabel("Ano: 2019 ");
		    		label3.setVerticalAlignment(SwingConstants.TOP);
		    		label3.setHorizontalAlignment(SwingConstants.CENTER);
		    		label3.setFont(new Font("Arial", Font.BOLD, 10));
		    		label3.setBounds(0, 44, 200, 32);
		    		panel.add(label3);

		    		Dimension d = mdiPane.getSize();
		    		mdiFrame.setLocation((d.width - getSize().width) / 2, (d.height - getSize().height) / 2); 
		    		mdiFrame.add(panel);
	                mdiFrame.setSize(new Dimension(200, 96));
	                mdiFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
	                mdiFrame.setVisible(true);
	                getMdiPane().add(mdiFrame);
	                mdiFrame.setLocation(fx,fy);
	                fx += 10;
	                fy += 10;
	                try {
	                    mdiFrame.setSelected(true);
	                } catch (PropertyVetoException ex) {}
		        }
	    });
	     	
     	iAluno.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	abrirForm(new FormAluno("Aluno Form",true,true,true,true));
	        }
     	});
     	
     	iCurso.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	abrirForm(new FormCurso("Curso Form",true,true,true,true));
	        }
     	});
     	
     	iDisciplina.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	abrirForm(new FormDisciplina("Disciplina Form",true,true,true,true));
	        }
     	});
     	
     	iProfessor.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	abrirForm(new FormProfessor("Professor Form",true,true,true,true));
	        }
     	});
     	
     	iMatricula.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	abrirForm(new FormMatricula("Mat. Aluno",true,true,true,true));
	        }
     	});
	    iGrade.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	abrirForm(new FormGrade("Grade",true,true,true,true));
	        }
	    });
	    iProfDisciplina.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	abrirForm(new FormProfDisciplina("Prof. Disciplina",true,true,true,true));
	        }
	    });
     }
     
    public void abrirForm(JInternalFrame internaFram){
    	internaFram.setLocation(20,20); 
    	internaFram.setSize(new Dimension(750, 706));
    	internaFram.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    	internaFram.setVisible(true);
        getMdiPane().add(internaFram);
    	try {internaFram.setSelected(true);
        } catch (PropertyVetoException ex) {}
    }    
     
	private JDesktopPane getMdiPane() {
	    if (mdiPane == null) {
	        mdiPane = new JDesktopPane();
	    }
	    return mdiPane;
	}
}