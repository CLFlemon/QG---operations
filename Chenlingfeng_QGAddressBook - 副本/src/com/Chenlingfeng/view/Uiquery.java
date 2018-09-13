package com.Chenlingfeng.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import com.Chenlingfeng.dao.*;
import com.Chenlingfeng.model.*;
import com.Chenlingfeng.util.*;
import com.Chenlingfeng.service.*;

public class Uiquery extends JFrame implements ActionListener{
	
	JButton jb1 = null;
	JTextField jtf = null;
	DefaultTableModel model = null;
    JTable table = null;
    JScrollPane jsp = null;
    JPanel jp1,jp2 = null;
    
    boolean result = false;
    
    
    public  Uiquery() {
    	jb1 = new JButton("查询");
    	jtf = new JTextField(10);
    	jb1.addActionListener(this);
    	
    	String[] clo = {"id","name","group","grade","class","phone","email","dormitory","address"};
    	model = new DefaultTableModel(clo,1);
    	table = new JTable(model);
    	jsp = new JScrollPane(table);
    	
    	jp1 = new JPanel();
    	jp2 = new JPanel();
    	
    	jp1.add(jb1);
    	jp1.add(jtf);
    	
    	jp2.add(jsp);
    	
    	this.add(jp1);
    	this.add(jp2);
    	this.setLayout(new GridLayout(2,1));  	
    	this.setTitle("请输入id");
    	this.setSize(600,250);
    	this.setLocation(150, 150);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    	this.setResizable(false);
    }



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("查询") && !jtf.getText().isEmpty())
		{
			result = logincheck.query(jtf.getText());
			if(result) {
				table.setValueAt(logincheck._id, 0, 0);
				table.setValueAt(logincheck._name, 0, 1);
				table.setValueAt(logincheck._group, 0, 2);
				table.setValueAt(logincheck._grade, 0, 3);
				table.setValueAt(logincheck._clas, 0, 4);
				table.setValueAt(logincheck._phone, 0, 5);
				table.setValueAt(logincheck._email, 0, 6);
				table.setValueAt(logincheck._dormitory, 0, 7);
				table.setValueAt(logincheck._address, 0, 8);
			}else JOptionPane.showMessageDialog(null,"查询失败","提示消息",JOptionPane.WARNING_MESSAGE);
		}else JOptionPane.showMessageDialog(null,"学号不能为空","提示消息",JOptionPane.WARNING_MESSAGE);
		dispose();
		ControlUi.nextTo("ToUiFourChoose");	  	
	}
}
