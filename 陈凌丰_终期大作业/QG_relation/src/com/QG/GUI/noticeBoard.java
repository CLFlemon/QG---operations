package com.QG.GUI;

import java.awt.Frame;
import java.applet.*;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public  class noticeBoard extends JFrame implements ActionListener {

		 String filename = null;
	     JButton jb1 = null;
		 JPanel  jp1 = null;
	  
	    public  noticeBoard(String filename) {    
	   	 JButton jb1 = new JButton("�õ���֪����");
	  	     jp1 = new JPanel();
	  	     jp1.add(jb1);
			 this.add(jp1);
			 jb1.addActionListener(this);//���ü���
	         setSize(850, 350);
	         setVisible(true);
	         this.setResizable(true);
	         this.filename = filename;	 
			 this.setLayout(new GridLayout(1,1));
			 this.setResizable(true);     
	    }
	     public void paint(Graphics g) {
	        //ȡ��ͼƬ����
	        Image image = getToolkit().getImage(filename);
	        //��ͼ
	        g.drawImage(image, 0, 0, this);
	    }
	     public static void main(String args[]) {
	        new noticeBoard("D:/������.png");
	    }
	    
	
	
	@Override
	  public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("�õ���֪����")) {
			dispose();
			startUp next = new startUp();
		}
		
	 }
	

}
