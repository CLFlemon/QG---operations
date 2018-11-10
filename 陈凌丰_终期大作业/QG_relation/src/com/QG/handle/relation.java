package com.QG.handle;

import com.QG.*;

import service.control;
import service.controlNotFamily;
import service.controlbro;
import service.getresult;

import com.QG.handle.LRtree.Node;
import com.QG.handle.broLink.broNode;

public class relation {
	/**
	 * 亲属树
	 * 对每个节点遍历 先找到位置
	 * 然后找同辈 下辈 确定关系
	 * @param s1
	 * @param s2
	 */
	public static void relatives(String s1,String s2) {
		System.out.println("接受成功!");
		LRtree.Node root[] = control.getroot();
		LRtree tree = new LRtree();//初始化
		String buff[] = new String[2];
		buff[0] = s1;
		buff[1] = s2;
		int flag1 = 0;
		int flag2 = 0;
		int i;
		int j;
		for(i = 0;i<root.length && root[i] != null;i++) {
			 if(tree.preOrder(root[i],s1)) {
				 flag1 = 1;
				 break;
			 }
		}
		for(j = 0;j<root.length && root[j]!=null;j++) {
			if(tree.preOrder(root[j],s2)){
				 flag2 = 1;
				 break;
			 }
		}
		if(i!=j) {
			getresult.getrelatives(null);
		}else {
		
			if(flag1 == 1 && flag2 == 1) {
				checkRelatives(root[i],buff);
			}else {
				getresult.getrelatives(null);
			}
		}
	}
	
	public static void notrelatives(String s1,String s2) {

		LRtree.Node root[] = controlNotFamily.getroot();//非亲属树
		LRtree tree = new LRtree();//初始化
		String buff[] = new String[2];
		buff[0] = s1;
		buff[1] = s2;
		int flag1 = 0;
		int flag2 = 0;
		int i;
		int j;
		for(i = 0;i<root.length && root[i] != null;i++) {
			 if(tree.preOrder(root[i],s1)) {
				 flag1 = 1;
				 break;
			 }
		}
		for(j = 0;j<root.length && root[j]!=null;j++) {
			if(tree.preOrder(root[j],s2)){
				 flag2 = 1;
				 break;
			 }
		}
		if(i!=j) {
			 getresult.getnotrelatives(null);
		}else {
		
			if(flag1 == 1 && flag2 == 1) {
				checkNotRelatives(root[i],buff);
			}else{
				 getresult.getnotrelatives(null);
			}
		}	   
	}
	
	private static String bro(String[] buff) {
		broLink.broNode root[] = controlbro.getroot();
		broLink link = new broLink();
		int flag1 = 0;
		int flag2 = 0;
		int i;
		int j;
		for(i = 0;i<root.length && root[i] != null;i++) {
			 if(link.traversal(root[i], buff[0])) {
				 flag1 = 1;
				 break;
			 }
		}
		for(j = 0;j<root.length && root[j]!=null;j++) {
			if(link.traversal(root[j], buff[1])){
				 flag2 = 1;
				 break;
			 }
		}
	
		if(i!=j) {
			return null;//报错
		}else {
		    if(flag1 == 0 && flag2 == 0) {
		    	return "兄弟";
		    }
			if(flag1 == 1 && flag2 == 1) {
			
				return (checkbro(root[i],buff));
			}else {
				return null;//不存在树上 报错
			}
		}	   
		
		
	}


	public static String checkRelatives(Node head,String[] buff) {
		LRtree.Node oldhead = head;
		System.out.println("进入逻辑判断");
		boolean r1 =false ,r2 = false,r3 = false ,t1= false,t2 =false,t3 = false;
		LRtree tree = new LRtree();
		head = tree.find(oldhead, buff[0]);//定位
		System.out.println("第一次定位"+head.data);
		//同辈：
		 r1 = finetreebro.find(head,buff[1]);//兄弟
		if(head.left != null ) {
			 r2 = finetreebro.find(head.left,buff[1]);//爸爸
			if(head.left.left != null) {			
		       r3 = finetreebro.find(head.left.left, buff[1]);//爷爷
			}
		}
		
		head = tree.find(oldhead, buff[1]);
		System.out.println("第二次定位"+head.data);
		 t1 = finetreebro.find(head,buff[0]);//兄弟
		 if(head.left != null ) {
			  t2 = finetreebro.find(head.left,buff[0]);//爸爸
			if(head.left.left != null) {			
		        t3 = finetreebro.find(head.left.left, buff[0]);//爷爷
			}
		}
		
		if(r1 == true || t1 == true) { //进一步看他是不是哥哥或者弟弟	
			getresult.getrelatives(bro(buff));
		}else if(r2 == true) {
			getresult.getrelatives("爸爸");
		}else if(r3 == true) {
			getresult.getrelatives("爷爷");
		}else if(t2 == true) {
			getresult.getrelatives("儿子");
		}else if(t3 == true) {
			getresult.getrelatives("孙子");
		}else {
			return null;
		}
		return null;
	}
	

	private static String checkNotRelatives(Node head, String[] buff) {
		boolean r1 = false,r2 = false,t1 = false,t2 = false;
		LRtree tree = new LRtree();
		Node oldhead = head;
		head = tree.find(oldhead, buff[0]);//定位
		//同辈：
		 r1 = finetreebro.find(head,buff[1]);//同学
		if(head.left != null ) {
			 r2 = finetreebro.find(head.left,buff[1]);//老师			
		}		
		head = tree.find(oldhead, buff[1]);	
		System.out.println(head.data);
		 	t1 = finetreebro.find(head,buff[0]);//同学
		if(head.left != null ) {
			 t2 = finetreebro.find(head.left,buff[0]);//学生
		}
		System.out.println("r2"+r2);
		if(r1 == true || t1 == true) {
			getresult.getnotrelatives("同学");
		}else if(r2 == true) {
			getresult.getnotrelatives("老师");
		}else if(t2 == true) {
			getresult.getnotrelatives("学生");
		}
		return null;
	}
	

	private static String checkbro(broNode head, String[] buff) {
		// TODO Auto-generated method stub
		broLink link = new broLink();
		broNode oldhead = head; 
		head = link.find(oldhead, buff[0]);		
		boolean r1 = findlinkbro.find(head, buff[1]);//0是1的哥哥		
		head = link.find(oldhead, buff[1]);	
		boolean r2 = findlinkbro.find(head,buff[0]);//1是0的哥哥
		System.out.println("进入判断哥哥/弟弟");
		System.out.println("r1"+r1);
		System.out.println("r2"+r2);
		if(r1 == true) {
			return "哥哥";
		}else if(r2 == true) {
			return "弟弟";
		}else {
			return "兄弟";
		}
	}
	
	
}
