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

public class UIlogin extends JFrame implements ActionListener{
	static JButton jb1,jb2,jb3=null;  
	static JPanel jp1,jp2,jp3=null;  
    static JTextField jtf=null;  
    static JLabel jlb1,jlb2=null;  
    static JPasswordField jpf=null;  
      
    public UIlogin()
    {
    	
    	 jb1=new JButton("登录");  
         jb2=new JButton("重置");  
         jb3=new JButton("退出");  
         
         //设置监听 
         jb1.addActionListener(this);  
         jb2.addActionListener(this);  
         jb3.addActionListener(this);          
         
         jp1=new JPanel();  
         jp2=new JPanel();  
         jp3=new JPanel();                 
           
         jlb1=new JLabel("用户名：");  
         jlb2=new JLabel("密    码：");   
           
         jtf=new JTextField(10);  
         jpf=new JPasswordField(10);  
         //加入到JPanel中  
         jp1.add(jlb1);  
         jp1.add(jtf);  
           
         jp2.add(jlb2);  
         jp2.add(jpf);  
           
         jp3.add(jb1);  
         jp3.add(jb2);  
         jp3.add(jb3);  
     
         this.add(jp1);  
         this.add(jp2);  
         this.add(jp3);  
      
         //设置布局管理器  
         this.setLayout(new GridLayout(3,1));  
         //给窗口设置标题  
         this.setTitle("QG工作室管理系统");  
         //设置窗体大小  
         this.setSize(300,250);  
         //设置窗体初始位置  
         this.setLocation(200, 150);  
         //设置当关闭窗口时，保证JVM也退出  
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
         //显示窗体  
         this.setVisible(true);  
         this.setResizable(true);  
    }
	@Override
	public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand()=="退出")
    	{
    		System.exit(0);
    	}
    	else if(e.getActionCommand()=="登录")
        {
    			System.out.println("监听成功~");
	    		if(!jtf.getText().isEmpty() && !jpf.getText().isEmpty())
	    		{
	    			dispose();
	    			Check.isright(jtf.getText(),jpf.getText(),Permission.getFlag());//登录成功或者失败		
	    		}
	    		else if(jtf.getText().isEmpty())  //预防异常输入 下同
	            {  
	                JOptionPane.showMessageDialog(null,"请输入用户名","提示消息",JOptionPane.WARNING_MESSAGE);  
	                this.clear();  
	            }else if(jpf.getText().isEmpty())     
	            {  
	                JOptionPane.showMessageDialog(null,"请输入密码","提示消息",JOptionPane.WARNING_MESSAGE);  
	                this.clear();  
	            }  
        }
	    else if(e.getActionCommand()=="重置")  
	            {  
	    	       this.clear();  
	            }
	    	
         	
    }
	private void clear() {
		jtf.setText("");
		jpf.setText("");
	}		
}
