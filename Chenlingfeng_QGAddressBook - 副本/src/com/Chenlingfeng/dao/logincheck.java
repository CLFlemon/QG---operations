package com.Chenlingfeng.dao;

import com.Chenlingfeng.model.*;
import com.Chenlingfeng.service.*;
import com.Chenlingfeng.util.*;
import com.Chenlingfeng.view.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
public class logincheck extends JFrame{
	
	
	public static String _id = null;
	public static String _name = null;
	public static String _group = null;
	public static String _grade = null;
	public static String _clas = null;
	public static String _phone = null;
	public static String _email = null;
	public static String _dormitory = null;
	public static String _address = null;

	static Connection ct = PrimeMover.getConnection();
	static Statement ps = null;
	static ResultSet rs = null;
	static int rss = 0;
	
	public static String userword;
	public static String pwd;
	private static Boolean flase;
	
	public static void sqlquery(int flag) {
		try {
			ps = ct.createStatement();
			if(flag==0) {
				rs = ps.executeQuery("select *from admins");	
			}else {
				rs = ps.executeQuery("select *from user");
			}
			while(rs.next())
			{
				userword = rs.getString(1);
				pwd = rs.getString(2);
			}
		}catch(Exception e1) {
			e1.printStackTrace();
		}	
	}
	public static Boolean delete(String s) {
		try
		{
			ps = ct.createStatement();
			rss = ps.executeUpdate("delete from info where id = '"+s+"'");
			if(rss>=1)
			{
				return true;
			}else return false;
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		return false;
	}
	public static Boolean add(String id,String name,String group,String grade,String clas,String phone,String email,String dormitory,String address) {
		try
		{
			String sql = "insert into info " + "values('" + id
					+ "','" + name + "','" + group + "','" + grade + "','" + clas+"','" + phone+"','" + email+"','" + dormitory + "','" + address +  "')";
			System.out.println(id);
			ps = ct.createStatement();
			System.out.println(sql);
			rss = ps.executeUpdate(sql);
			if(rss>=1)
			{
				return true;
			}else return false;
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		return false;	
	}
	
	public static Boolean query(String id) {
		try
		{
			ps = ct.createStatement();
			rs = ps.executeQuery("select *from info where id = '"+id+"'");
			if(rs.first())
			{
				_id = rs.getString(1);
				_name = rs.getString(2);
				_group = rs.getString(3);
				_grade = rs.getString(4);
				_clas = rs.getString(5);			
	     		_phone = rs.getString(6);
				_email = rs.getString(7);
				_dormitory = rs.getString(8);
				_address = rs.getString(9);
				return true;		
			}else return false;
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		return false;	
	}
	
	public static Boolean edit(String id,String name,String group,String grade,String clas,String phone,String email,String dormitory,String address) {
		try
		{
			String sql = "update info set id='" + id + "'," + "name='" + name + "'," + "`group`='" + group + "',"
					+ "grade='" + grade + "'," + "clas='" + clas + "'," + "phone='" + phone + "'," + "email='"
					+ email + "'," + "dormitory='" + dormitory + "'," + "address='" +address+ "' where id='" + id + "'"; 
			System.out.println(id);
			ps = ct.createStatement();
			System.out.println(sql);
			rss = ps.executeUpdate(sql);
			if(rss>=1)
			{
				return true;
			}else return false;
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		return false;	
	}
}
