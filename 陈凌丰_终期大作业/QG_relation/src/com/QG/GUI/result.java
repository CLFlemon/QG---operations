package com.QG.GUI;
import java.awt.event.ActionListener;
import javax.swing.*;
import service.controlInquiry;
import service.getresult;
import java.awt.*;
import java.awt.event.ActionEvent;

public class result extends JFrame implements ActionListener {


	JLabel jlb1,jlb2=null; 
	JTextField jtf1=null,jtf2=null;
	JPanel jp1 = null ,jp2 = null,jp3 = null;
	JButton jb1 =  null;
	
	
	public result() {
		String s1 = null;
		String s2 = null;
		if(getresult.getdata1() != null ) {
			 s1 = controlInquiry.gets1()+"��"+controlInquiry.gets2()+"��"+getresult.getdata1();
		}
		if(getresult.getdata2() != null ) {
			 System.out.println(getresult.getdata2());
			 s2 = controlInquiry.gets1()+"��"+controlInquiry.gets2()+"��"+getresult.getdata2();
		}
		System.out.println(s1);
		System.out.println(s2);
		JLabel jlb1 =  new JLabel("������ϵ");
		JLabel jlb2 =  new JLabel("��������ϵ");
		JButton jb1 =  new JButton("ȷ��");
		JTextField jtf1 = new JTextField(15);
		if(s1 != null ) {
			jtf1.setText(s1);
		}
		JTextField jtf2 = new JTextField(15);
		if(s2 != null ) {
			jtf2.setText(s2);
		}
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		jp1.add(jlb1);
		jp1.add(jtf1);
		
		jp2.add(jlb2);
		jp2.add(jtf2);
		
		jp3.add(jb1);
		jb1.addActionListener(this);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setLayout(new GridLayout(3,1));
		this.setTitle("���");
		this.setSize(300,250);
		this.setLocation(200,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ȷ��")) {
			
			dispose();
			chooce back = new chooce();	
		}
       
		
	}
	


	

}
