package com.QG.pertreatment;
import com.QG.GUI.*;
import com.QG.handle.*;
import com.QG.model.*;
import com.QG.util.*;

import service.control;
import service.controlNotFamily;
import service.controlbro;
/**
 * 结果：讲所有句式转化成：XX是XX的XX （主谓宾）结构并把结果传回逻辑层。
 * @author Administrator
 *
 */

public class Standard {
	
	static String[] newbuff1 = new String[3];
	static String[] newbuff2 =new String[3];//为第三种句式做准备
	public static void Standrda (String[] buff) {
		newbuff1 = buff;
		if(buff[2].equals("老师") || buff[2].equals("学生") || buff[2].equals("同学")) {
			controlNotFamily.receive(newbuff1);
		}//非亲属树
		else { 
			if(buff[2].equals("哥哥") || buff[2].equals("弟弟")) {
				controlbro.receive(newbuff1);
			}
			control.receive(newbuff1); //传回逻辑层
		}//亲属树
		
	}
	
	public static void Standrdb (String[] buff) {

		newbuff1[0] = buff[2];
		newbuff1[1] = buff[0];
		newbuff1[2] = buff[1];
		if(newbuff1[2].equals("老师") || newbuff1[2].equals("学生") || newbuff1[2].equals("同学")) {
			
			controlNotFamily.receive(newbuff1);
		}//非亲属树
		else {
			if(newbuff1[2].equals("哥哥") || newbuff1[2].equals("弟弟")) {
				controlbro.receive(newbuff1);
			}
			control.receive(newbuff1);//逻辑层
		}//亲属树	
	}
	
	public static void Standrdc (String[] buff) {
		newbuff1[0] = "未知者";
		newbuff1[1] = buff[0];
		newbuff1[2] = buff[1];	
		
		newbuff2[0] = "未知者";
		newbuff2[1] = buff[2];
		newbuff2[2] = buff[3];
        if(newbuff1[2].equals("老师") || newbuff1[2].equals("学生") || newbuff1[2].equals("同学")) {
			
			controlNotFamily.receive(newbuff1,newbuff2);
		}//非亲属树
        else {
        	if(  (newbuff1[2].equals("哥哥") && newbuff2[2].equals("弟弟")) ||   (newbuff1[2].equals("弟弟") && newbuff2[2].equals("哥哥"))){
        		controlbro.receive(newbuff1,newbuff2);
        	}
        	control.receive(newbuff1,newbuff2);//逻辑层	
        }//亲属树
	}
}
