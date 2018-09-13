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
		 jb1 = new JButton("查询");
		 jb2 = new JButton("删除");
		 jb3 = new JButton("增加");
		 jb4 = new JButton("更改");
		 
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
		 this.setTitle("选择");
		 this.setSize(300,250);
		 this.setLocation(200,150);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setVisible(true);
		 this.setResizable(true);
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("删除")) {
			dispose();
			ControlUi.nextTo("ToDelete");
		}
		else if(e.getActionCommand().equals("增加")) {
			dispose();
			ControlUi.nextTo("ToAdd");
		}
		else if(e.getActionCommand().equals("查询")) {
			dispose();
			ControlUi.nextTo("ToQuery");
		}else if(e.getActionCommand().equals("更改")) {
			dispose();
			ControlUi.nextTo("ToEdit");
		}
		// TODO Auto-generated method stub
		
	}
	

}
