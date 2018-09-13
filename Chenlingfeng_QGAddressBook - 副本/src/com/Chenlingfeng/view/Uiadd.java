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


public class Uiadd extends JFrame implements ActionListener {
	
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9 = null;
	JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9,jp10 = null;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9 =null;
	JButton jb = null;
	boolean result = false;
	
	
	
	public Uiadd()
	{
		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);
		jtf3 = new JTextField(10);
		jtf4 = new JTextField(10);
		jtf5 = new JTextField(10);
		jtf6 = new JTextField(10);
		jtf7 = new JTextField(10);
		jtf8 = new JTextField(10);
		jtf9 = new JTextField(10);
		
		jb = new JButton("确定");
		jb.addActionListener(this);
		jl1 = new JLabel("id");
		jl2 = new JLabel("name");
		jl3 = new JLabel("group");
		jl4 = new JLabel("grade");
		jl5 = new JLabel("clas");
		jl6 = new JLabel("phone");
		jl7 = new JLabel("email");
		jl8 = new JLabel("dormitory");
		jl9 = new JLabel("address");
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		jp7 = new JPanel();
		jp8 = new JPanel();
		jp9 = new JPanel();
		jp10 = new JPanel();
		
		jp1.add(jl1);
		jp1.add(jtf1);
		
		jp2.add(jl2);
		jp2.add(jtf2);
		
		jp3.add(jl3);
		jp3.add(jtf3);
		
		jp4.add(jl4);
		jp4.add(jtf4);
		
		jp5.add(jl5);
		jp5.add(jtf5);
		
		jp6.add(jl6);
		jp6.add(jtf6);
		
		jp7.add(jl7);
		jp7.add(jtf7);
		
		jp8.add(jl8);
		jp8.add(jtf8);
		
		jp9.add(jl9);
		jp9.add(jtf9);
		jp10.add(jb);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		this.add(jp6);	
		this.add(jp7);
		this.add(jp8);
		this.add(jp9);
		this.add(jp10);
		
		
		this.setLayout(new GridLayout(10,1));  	
    	this.setTitle("请输入信息");
    	this.setSize(500,500);
    	this.setLocation(150, 150);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    	this.setResizable(false);	
	    
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("确定") && !jtf1.getText().isEmpty()  ) {
			result = logincheck.add(jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText(),jtf8.getText(),jtf9.getText());
			if(result)JOptionPane.showMessageDialog(null, "添加成功","提示信息",JOptionPane.WARNING_MESSAGE);
			else JOptionPane.showMessageDialog(null, "添加失败","提示信息",JOptionPane.WARNING_MESSAGE);
			dispose();
			ControlUi.nextTo("ToUiFourChoose");	
		}else JOptionPane.showMessageDialog(null, "id不能为空","提示信息",JOptionPane.WARNING_MESSAGE);
		// TODO Auto-generated method stub
		
	}

}
