package com.Chenlingfeng.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import com.Chenlingfeng.dao.*;
import com.Chenlingfeng.model.*;
import com.Chenlingfeng.service.*;
import com.Chenlingfeng.view.*;

/**
 * �������ݿ��Ҫ���ߡ�
 * @author Administrator
 *
 */
public class PrimeMover {
	private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/qg";
    private static String UserName = "root";
    private static String Password = "123456";
    static Connection ct = null; 
    
    public static Connection getConnection() {
    	try {
    		Class.forName(driver);
    		System.out.println("�����ɹ�");
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	try {
    		System.out.println("�������ݳɹ�");
    		return DriverManager.getConnection(url, UserName,Password);
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
}
