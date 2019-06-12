package com.br.lp3.prova.principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class SplashScreen extends JWindow  {

	private int duration;
    
    public SplashScreen(int d) {
        duration = d;
    }
    
    public void showSplash() {        
        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.white);
        
        int width = 450;
        int height = 415;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);
        
        JLabel title = new JLabel("Prova LP3", JLabel.CENTER);
        title.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        JLabel label = new JLabel(new ImageIcon(getClass().getResource("/imgs/7YUz.gif")));
        JLabel copyrt = new JLabel("Copyright 2019, IFMA", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        
        content.add(title, BorderLayout.NORTH);
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color oraRed = new Color(46, 204, 113);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 10));        
        setVisible(true);
        
        try { Thread.sleep(duration); } catch (Exception e) {}        
        setVisible(false);        
    }
    
    public void showSplashAndExit() {        
        showSplash();
        System.exit(0);        
    }
}
