package com.QG.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.QG.util.*;



public class chooce extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	JButton jb1,jb2,jb3,jb4;
	JPanel  jp1,jp2;
	public chooce() {
		jb1 = new JButton("查询");
		jb2 = new JButton("删除");
		jb3 = new JButton("添加");
		jb4 = new JButton("修改");
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		this.add(jp1);
		this.add(jp2);
		
		this.setLayout(new GridLayout(2,2));
		this.setTitle("请选择你要的操作");
		this.setSize(250,250);
		this.setLocation(200,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("查询")) {
			dispose();
			inquiry next = new inquiry();	
		}
		
	}
	
}
