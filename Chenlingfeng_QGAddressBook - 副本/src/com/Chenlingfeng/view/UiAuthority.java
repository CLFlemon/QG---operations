package com.Chenlingfeng.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.Chenlingfeng.service.ControlUi;

/**
 * 权限： 管理员 用户
 * @author Administrator
 *
 */
public class UiAuthority extends JFrame implements ActionListener{

	JButton jb1,jb2;
	JPanel jp1;
	JPanel jp2;
	public UiAuthority()
	{
		jb1 = new JButton("管理员");
		jb2 = new JButton("用户");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp1.add(jb1);
		jp2.add(jb2);
		this.add(jp1);
		this.add(jp2);
		
		this.setLayout(new GridLayout(2,1));
		this.setTitle("选择");
		this.setSize(250,250);
		this.setLocation(200,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
	}
	/**
	 * 将程序控制权交给ControlUi
	 */
	public void actionPerformed(ActionEvent e) {	
		if(e.getActionCommand().equals("管理员")) {
			dispose();
			ControlUi.nextTo("administrator_ToUiLogin");;
		}
		if(e.getActionCommand().equals("用户")) {
			dispose();
			ControlUi.nextTo("user_ToUiLogin");;
		}
	}
	

}
