package com.Chenlingfeng.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import com.Chenlingfeng.dao.*;
import com.Chenlingfeng.model.*;
import com.Chenlingfeng.util.*;
import com.Chenlingfeng.service.*;

public class Uifourchoose extends JFrame implements ActionListener {

	 JButton jb1,jb2,jb3,jb4 = null;
	 JPanel jp1,jp2 = null;
	 ButtonGroup bg = null;
	 
	 public Uifourchoose()
	 {
		 jb1 = new JButton("��ѯ");
		 jb2 = new JButton("ɾ��");
		 jb3 = new JButton("����");
		 jb4 = new JButton("����");
		 
		 jb1.addActionListener(this);
		 jb2.addActionListener(this);
		 jb3.addActionListener(this);
		 jb4.addActionListener(this);
		 
		 jp1 = new JPanel();
		 jp2 = new JPanel();
		 
		 jp1.add(jb1);
		 jp1.add(jb2);
		 jp2.add(jb3);
		 jp2.add(jb4);
		 
		 this.add(jp1);
		 this.add(jp2);
		 
		 this.setLayout(new GridLayout(2,1));
		 this.setTitle("ѡ��");
		 this.setSize(300,250);
		 this.setLocation(200,150);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setVisible(true);
		 this.setResizable(true);
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ɾ��")) {
			dispose();
			ControlUi.nextTo("ToDelete");
		}
		else if(e.getActionCommand().equals("����")) {
			dispose();
			ControlUi.nextTo("ToAdd");
		}
		else if(e.getActionCommand().equals("��ѯ")) {
			dispose();
			ControlUi.nextTo("ToQuery");
		}else if(e.getActionCommand().equals("����")) {
			dispose();
			ControlUi.nextTo("ToEdit");
		}
		// TODO Auto-generated method stub
		
	}
	

}
