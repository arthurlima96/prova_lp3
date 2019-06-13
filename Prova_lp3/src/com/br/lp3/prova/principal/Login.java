package com.br.lp3.prova.principal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class Login extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tentativas = 0;
	public Login() throws ParseException {
		JPanel form = new JPanel();
		PlainDocument d;
	    this.getContentPane().setLayout(new BorderLayout());
	    this.getContentPane().add(form, BorderLayout.NORTH);
	
	    form.setLayout(new GridBagLayout());
	    FormUtility formUtility = new FormUtility();
	
	    formUtility.addLabel("Usuario: ", form);
	    JTextField usuarioTxtField = new JTextField();
	    formUtility.addLastField(usuarioTxtField, form);
	    d=(PlainDocument) usuarioTxtField.getDocument();
	    d.setDocumentFilter(new DocumentFilter(){
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String string =fb.getDocument().getText(0, fb.getDocument().getLength())+text;

                if(string.length() <= 15)
                super.replace(fb, offset, length, text, attrs); 
            }
        });
	
	    formUtility.addLabel("Senha: ", form);
	    JPasswordField passwordTxtField = new JPasswordField();
	    formUtility.addLastField(passwordTxtField, form);
	    d=(PlainDocument) passwordTxtField.getDocument();
	    d.setDocumentFilter(new DocumentFilter(){
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String string =fb.getDocument().getText(0, fb.getDocument().getLength())+text;

                if(string.length() <= 4)
                super.replace(fb, offset, length, text, attrs); 
            }
        });
	    formUtility.addLabel(" ", form);
        JButton btnEntrar = new JButton("Entrar");
        Dimension phoneSize = btnEntrar.getPreferredSize();
        phoneSize.width = 200;
        btnEntrar.setPreferredSize(phoneSize);
        JPanel phonePanel = new JPanel();
        phonePanel.setLayout(new BorderLayout());
        phonePanel.add(btnEntrar, BorderLayout.EAST);
        formUtility.addLastField(phonePanel, form);
		
	    form.setBorder(new EmptyBorder(2, 2, 2, 2));
	    
	    passwordTxtField.addKeyListener(new KeyAdapter() {

	        @Override
	        public void keyPressed(KeyEvent arg0) {
	        	if (arg0.getKeyCode()==10) {
		        	if(tentativas == 3 ){
						 int input = JOptionPane.showConfirmDialog(null,"Você atingiu o numero máximo de tentativas !","Aviso", JOptionPane.DEFAULT_OPTION);
						 
						 if(input==0)
							 System.exit(0); 
					}
						
					char[] input = passwordTxtField.getPassword();
					if(usuarioTxtField.getText().equals("admin") && isPasswordCorrect(input)){
						JOptionPane.showMessageDialog(null, "Logado com sucesso !");
						new Home();
						dispose();
					}else{
						tentativas++;
						JOptionPane.showMessageDialog(null, "Falhou");
						usuarioTxtField.setText("");
						passwordTxtField.setText("");
					}
	        	}

	        }

	    });
	    
	    btnEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(tentativas == 3 ){
					 int input = JOptionPane.showConfirmDialog(null,"Você atingiu o numero máximo de tentativas !","Aviso", JOptionPane.DEFAULT_OPTION);
					 
					 if(input==0)
						 System.exit(0); 
				}
					
				char[] input = passwordTxtField.getPassword();
				if(usuarioTxtField.getText().equals("admin") && isPasswordCorrect(input)){
					JOptionPane.showMessageDialog(null, "Logado com sucesso !");
					new Home();
					dispose();
				}else{
					tentativas++;
					JOptionPane.showMessageDialog(null, "Falhou");
					usuarioTxtField.setText("");
					passwordTxtField.setText("");
				}
			}
		});
	
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.pack();
	    this.setLocationRelativeTo(null);
	    this.setSize(400, 140);
	    this.setVisible(true);
	}
	
	private boolean isPasswordCorrect(char[] input) {
		boolean isCorrect = true;
	    char[] correctPassword = { 'r', 'o', 'o', 't'};

	    if (input.length != correctPassword.length) {
	        isCorrect = false;
	    } else {
	        isCorrect = Arrays.equals (input, correctPassword);
	    }

	    Arrays.fill(correctPassword,'0');

	    return isCorrect;
	}
	
	
}
