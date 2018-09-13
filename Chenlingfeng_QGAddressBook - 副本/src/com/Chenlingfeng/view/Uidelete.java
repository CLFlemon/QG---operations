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

public class Uidelete extends JFrame implements ActionListener {
		JButton jb = null;
		JTextField jtf = null;
		JPanel jp = null;
		Boolean result = false;
	
	public Uidelete()
	{
		jb = new JButton("删除");
		jtf = new JTextField(10);
		jp = new JPanel();
		
		jp.add(jb);
		jp.add(jtf);
		jb.addActionListener(this);
		
		this.add(jp);
		this.setTitle("请输入学号");
		this.setSize(300,150);
		this.setLocation(200,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
	}

	@Override
	public void actionPerformed (ActionEvent e) {
		if(e.getActionCommand().equals("删除") && !jtf.getText().isEmpty())
		{
			result = logincheck.delete(jtf.getText());
			if(result)JOptionPane.showMessageDialog(null, "删除成功","提示信息",JOptionPane.WARNING_MESSAGE);
			else JOptionPane.showMessageDialog(null, "删除失败","提示信息",JOptionPane.WARNING_MESSAGE);
			dispose();
			ControlUi.nextTo("ToUiFourChoose");	
		}else JOptionPane.showMessageDialog(null, "学号不能为空","提示信息",JOptionPane.WARNING_MESSAGE);	
	}

}
