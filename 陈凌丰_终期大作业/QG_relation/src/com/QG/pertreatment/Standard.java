package com.QG.pertreatment;
import com.QG.GUI.*;
import com.QG.handle.*;
import com.QG.model.*;
import com.QG.util.*;

import service.control;
import service.controlNotFamily;
import service.controlbro;
/**
 * ����������о�ʽת���ɣ�XX��XX��XX ����ν�����ṹ���ѽ�������߼��㡣
 * @author Administrator
 *
 */

public class Standard {
	
	static String[] newbuff1 = new String[3];
	static String[] newbuff2 =new String[3];//Ϊ�����־�ʽ��׼��
	public static void Standrda (String[] buff) {
		newbuff1 = buff;
		if(buff[2].equals("��ʦ") || buff[2].equals("ѧ��") || buff[2].equals("ͬѧ")) {
			controlNotFamily.receive(newbuff1);
		}//��������
		else { 
			if(buff[2].equals("���") || buff[2].equals("�ܵ�")) {
				controlbro.receive(newbuff1);
			}
			control.receive(newbuff1); //�����߼���
		}//������
		
	}
	
	public static void Standrdb (String[] buff) {

		newbuff1[0] = buff[2];
		newbuff1[1] = buff[0];
		newbuff1[2] = buff[1];
		if(newbuff1[2].equals("��ʦ") || newbuff1[2].equals("ѧ��") || newbuff1[2].equals("ͬѧ")) {
			
			controlNotFamily.receive(newbuff1);
		}//��������
		else {
			if(newbuff1[2].equals("���") || newbuff1[2].equals("�ܵ�")) {
				controlbro.receive(newbuff1);
			}
			control.receive(newbuff1);//�߼���
		}//������	
	}
	
	public static void Standrdc (String[] buff) {
		newbuff1[0] = "δ֪��";
		newbuff1[1] = buff[0];
		newbuff1[2] = buff[1];	
		
		newbuff2[0] = "δ֪��";
		newbuff2[1] = buff[2];
		newbuff2[2] = buff[3];
        if(newbuff1[2].equals("��ʦ") || newbuff1[2].equals("ѧ��") || newbuff1[2].equals("ͬѧ")) {
			
			controlNotFamily.receive(newbuff1,newbuff2);
		}//��������
        else {
        	if(  (newbuff1[2].equals("���") && newbuff2[2].equals("�ܵ�")) ||   (newbuff1[2].equals("�ܵ�") && newbuff2[2].equals("���"))){
        		controlbro.receive(newbuff1,newbuff2);
        	}
        	control.receive(newbuff1,newbuff2);//�߼���	
        }//������
	}
}
