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
    	
    	 jb1=new JButton("��¼");  
         jb2=new JButton("����");  
         jb3=new JButton("�˳�");  
         
         //���ü��� 
         jb1.addActionListener(this);  
         jb2.addActionListener(this);  
         jb3.addActionListener(this);          
         
         jp1=new JPanel();  
         jp2=new JPanel();  
         jp3=new JPanel();                 
           
         jlb1=new JLabel("�û�����");  
         jlb2=new JLabel("��    �룺");   
           
         jtf=new JTextField(10);  
         jpf=new JPasswordField(10);  
         //���뵽JPanel��  
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
      
         //���ò��ֹ�����  
         this.setLayout(new GridLayout(3,1));  
         //���������ñ���  
         this.setTitle("QG�����ҹ���ϵͳ");  
         //���ô����С  
         this.setSize(300,250);  
         //���ô����ʼλ��  
         this.setLocation(200, 150);  
         //���õ��رմ���ʱ����֤JVMҲ�˳�  
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
         //��ʾ����  
         this.setVisible(true);  
         this.setResizable(true);  
    }
	@Override
	public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand()=="�˳�")
    	{
    		System.exit(0);
    	}
    	else if(e.getActionCommand()=="��¼")
        {
    			System.out.println("�����ɹ�~");
	    		if(!jtf.getText().isEmpty() && !jpf.getText().isEmpty())
	    		{
	    			dispose();
	    			Check.isright(jtf.getText(),jpf.getText(),Permission.getFlag());//��¼�ɹ�����ʧ��		
	    		}
	    		else if(jtf.getText().isEmpty())  //Ԥ���쳣���� ��ͬ
	            {  
	                JOptionPane.showMessageDialog(null,"�������û���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
	                this.clear();  
	            }else if(jpf.getText().isEmpty())     
	            {  
	                JOptionPane.showMessageDialog(null,"����������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
	                this.clear();  
	            }  
        }
	    else if(e.getActionCommand()=="����")  
	            {  
	    	       this.clear();  
	            }
	    	
         	
    }
	private void clear() {
		jtf.setText("");
		jpf.setText("");
	}		
}
