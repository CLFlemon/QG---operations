package com.QG.pertreatment;
import javax.swing.JOptionPane;

import com.QG.GUI.*;
import com.QG.handle.*;
import com.QG.model.*;
import com.QG.util.*;
/**
 * ������������и��һ��һ������
 * @author Administrator
 *
 */

public class Split {
	static String str = null;
	static String[] buff = null;
	
	public static void SplitInfo(String sentence) {
		str = sentence;
		buff = str.split("��|��");
		if(buff.length == 3) { // ǰ���־�ʽ
			if(str.indexOf("��")<str.indexOf("��")) {
				Standard.Standrda(buff);//��һ�־�ʽ �������ݵ� ��ͳһ�����ϡ�
			}else {
				Standard.Standrdb(buff);//�ڶ��־�ʽ��
			}
		}
		else if(buff.length == 4) {
			Standard.Standrdc(buff);//�����־�ʽ��
		}else {//����
			JOptionPane.showMessageDialog(null, "����","�������",JOptionPane.WARNING_MESSAGE);
			System.exit(0);
			
		}
	}
}
