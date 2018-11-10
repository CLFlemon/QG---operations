package com.QG.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.QG.util.*;

public class startUp extends JFrame implements ActionListener{
	
	JButton jb1;
	JPanel  jp1;
	public startUp() {
		jb1 = new JButton("启动");
		jp1 = new JPanel();	
		jp1.add(jb1);
		this.add(jp1);
		jb1.addActionListener(this);
		this.setLayout(new GridLayout(1,1));
		this.setTitle("将文本数据转换成人物关系图");
		this.setSize(300,100);
		this.setLocation(200,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("启动")) {
			try {
				GetInfo.startUp();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			dispose();
			chooce next = new chooce();
		}
		
	}

}
