package com.br.lp3.prova.principal;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * Exemplo aplica��o MDI
 * @arquivo ExemploMdi.java
 * @author 30/11/2004 15:35:00 - Rodrigo G. Tavares de Souza [black_fire]
 */
public class Main extends JFrame {
    /**
     * M�todo que ser� executado quando o menu 
     * for clicado, que neste caso ser� gerado
     * um novo frame MDI e ser� exibido no 
     * JDesktopPane.
     * @param e Recebe o evento
     */
    private void mnNovoPerformed(ActionEvent e) {
        /* Veja que aki estou usando a classe base
         * por�m poderia ser por exemplo um tela sua
         * que estivesse extendendo JInternalFrame,
         * algo tipo: 
         * JInternalFrame mdiFrame = new MeuFrameCadastroCliente();
         */
        JInternalFrame mdiFrame = new JInternalFrame(
                "Novo Frame MDI #"+ String.valueOf(nrForm++), 
                true, //resizable
                true, //closable
                true, //maximizable
                true  //iconifiable
        );
        // Tamanho do Frame
        mdiFrame.setSize(new Dimension(300, 250));
        // Qual procedimento ser� executado ao fechar o frame
        mdiFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        // Deixa o frame visivel
        mdiFrame.setVisible(true);
        // Adiciona o frame no DesktopPane
        getMdiPane().add(mdiFrame);
        // Posiciona o frame
        mdiFrame.setLocation(fx,fy);
        // Incrementa as v�riaveis para posicionar os frames em cascata
        fx += 10;
        fy += 10;
        // Tenta enviar o foco para o frame criado 
        try {
            mdiFrame.setSelected(true);
        } catch (PropertyVetoException ex) {}
    }
    /**
     * Adiciona os eventos na aplica��o
     */
    private void addEvent() {
        mnNovo.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    mnNovoPerformed(e);
                }
            }
        );
    }
    /** 
     * Este componente � um container respos�vel 
     * por exibir os formul�rios
     * @return Painel que exibe os formul�rios MDI
     */
    private JDesktopPane getMdiPane() {
        if (mdiPane == null) {
            mdiPane = new JDesktopPane();
        }
        return mdiPane;
    }
    /**
     * Inicaliza��o do menu superior da aplica��o.
     * @return Barra de menu Superior
     */
    private JMenuBar getMainMenu() {
        if (mainMenu == null) {
            mainMenu = new JMenuBar();
            mnPrinc = new JMenu("Principal");
            mnPrinc.setMnemonic(KeyEvent.VK_P);
            mnNovo  = new JMenuItem("Novo");
            mnNovo.setMnemonic(KeyEvent.VK_N);
            mnPrinc.add(mnNovo);
            mainMenu.add(mnPrinc);            
        }
        return mainMenu;
    }
    /**
     * Inicializa componentes do formul�rios
     */
    private void initialize() {
        // Seta o layout para BorderLayout
        this.getContentPane().setLayout(new BorderLayout());
        // Adiciona compomentes no formul�rio
        this.getContentPane().add(getMainMenu(), BorderLayout.NORTH);
        this.getContentPane().add(getMdiPane(), BorderLayout.CENTER);
        // Adiciona evento que ir� criar um novo formul�rio
        addEvent();
        // Configura o Frame principal para exibi-lo
        this.setSize(new Dimension(640, 480));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Exemplo Aplica��o MDI");
        this.show();
    }
    /**
     * Construtor b�sico, chama m�todos para inicializa��o 
     * do componentes do formul�rio
     */
    public Main() {
        initialize();
    }
    public static void main(String[] args) {
        Main app = new Main();
    }
    private JMenuBar       mainMenu = null;
    private JMenu          mnPrinc  = null;
    private JMenuItem      mnNovo   = null;
    private JDesktopPane   mdiPane  = null;
    public static int nrForm = 1;
    public static int fy = 0;
    public static int fx = 0;
}