package com.QG.GUI;

import java.awt.event.ActionListener;

import javax.swing.*;

import service.controlInquiry;

import java.awt.*;
import java.awt.event.ActionEvent;

public class inquiry extends JFrame implements ActionListener{

		JButton jb1 = null;
		JPanel jp1,jp2,jp3=null;
		JTextField jtf1,jtf2=null;
		JLabel jlb1,jlb2=null; 
		
		public inquiry() {
			jb1 = new JButton ("查询");
			jp1 = new JPanel();
			jp2 = new JPanel();
			jp3 = new JPanel();
			jtf1 = new JTextField(15);
			jtf2 = new JTextField(15);
			jlb1 = new JLabel("名字");
			jlb2 = new JLabel("名字");
			
			jb1.addActionListener(this);
			jp1.add(jlb1);
			jp1.add(jtf1);
			
			jp2.add(jlb2);
			jp2.add(jtf2);
			
			jp3.add(jb1);
			
			this.add(jp1);
			this.add(jp2);
			this.add(jp3);
			
			this.setLayout(new GridLayout(3,1));
			this.setTitle("查询");
			this.setSize(300,250);
			this.setLocation(200,150);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			this.setResizable(true);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("查询")) {
				controlInquiry.entry(jtf1.getText(),jtf2.getText());//得到信息
				dispose();
				result next = new result();	
			}
			
		}
		
}
