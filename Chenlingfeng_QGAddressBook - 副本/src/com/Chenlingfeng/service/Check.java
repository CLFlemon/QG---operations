package com.Chenlingfeng.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import com.Chenlingfeng.dao.*;
import com.Chenlingfeng.model.*;
import com.Chenlingfeng.util.*;
import com.Chenlingfeng.view.*;

/**
 * flag == 0 Ϊ����Ա
 * flag == 1 Ϊ�û�
 * @author Administrator
 *
 */
public class Check extends JFrame{
	public static void isright(String name,String pwd,int flag) {
		logincheck.sqlquery(flag);
		if( logincheck.userword.equals(name) && logincheck.pwd.equals(pwd) ){
				JOptionPane.showMessageDialog(null, "��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				if(flag == 1) ControlUi.nextTo("ToQuery");
				else ControlUi.nextTo("ToUiFourChoose");
		}else{
				JOptionPane.showMessageDialog(null, "�û��������������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
		}
	}
}
