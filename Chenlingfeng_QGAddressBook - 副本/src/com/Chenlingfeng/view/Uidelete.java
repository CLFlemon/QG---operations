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
		jb = new JButton("ɾ��");
		jtf = new JTextField(10);
		jp = new JPanel();
		
		jp.add(jb);
		jp.add(jtf);
		jb.addActionListener(this);
		
		this.add(jp);
		this.setTitle("������ѧ��");
		this.setSize(300,150);
		this.setLocation(200,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
	}

	@Override
	public void actionPerformed (ActionEvent e) {
		if(e.getActionCommand().equals("ɾ��") && !jtf.getText().isEmpty())
		{
			result = logincheck.delete(jtf.getText());
			if(result)JOptionPane.showMessageDialog(null, "ɾ���ɹ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			else JOptionPane.showMessageDialog(null, "ɾ��ʧ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			dispose();
			ControlUi.nextTo("ToUiFourChoose");	
		}else JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);	
	}

}
