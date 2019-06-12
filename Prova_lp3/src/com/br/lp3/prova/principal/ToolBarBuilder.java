package com.br.lp3.prova.principal;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBarBuilder {
	
	private JToolBar jToolBar;
	
	private JButton bArquivo, bAbrir, bSalvar, bCancelar;
	private ToolBarBuilder() {}
	
	public static ToolBarBuilder iniciaToolBar() {
		
		ToolBarBuilder builder = new ToolBarBuilder();
		builder.jToolBar = new JToolBar();
		builder.jToolBar.setRollover(true);

		return builder;
	}
	
	public ToolBarBuilder comActionAbrir(ActionListener a) {
		adicionaButao(a, bAbrir, this.getClass().getResource("/imgs/icons8-editar-arquivo-32.png"));
		return this;
	}
	
	public ToolBarBuilder comActionArquivo(ActionListener a) {
		adicionaButao(a, bArquivo, this.getClass().getResource("/imgs/icons8-adicionar-arquivo-32.png"));
		return this;
	}
	
	public ToolBarBuilder comActionCancelar(ActionListener a) {
		adicionaButao(a, bCancelar, this.getClass().getResource("/imgs/icons8-apagar-arquivo-32.png"));
		return this;
	}
	
	public ToolBarBuilder comActionSalvar(ActionListener a) {
		adicionaButao(a, bSalvar, this.getClass().getResource("/imgs/icons8-salvar-arquivo-32.png"));
		return this;
	}
	
	public JToolBar constroi(){
		return this.jToolBar;
	}
	
	private void adicionaButao(ActionListener a, JButton button, URL url) {
		
		button = new JButton(new ImageIcon(url));
	    //button.setIcon(preparaImagem(url));
	    button.setPreferredSize(new Dimension(40, 40));
		if(a != null) button.addActionListener(a);
		jToolBar.addSeparator();
		jToolBar.add(button);
	}
	
	private ImageIcon preparaImagem(URL url) {
		ImageIcon icon = new ImageIcon(url);
		Image img = icon.getImage(); 
		BufferedImage bi = new BufferedImage (40, 40, BufferedImage.TYPE_INT_ARGB); 
		Graphics g = bi.createGraphics (); 
		g.drawImage(img, 0, 0, 40, 40, null);
		return new ImageIcon(bi);
	}
  
}