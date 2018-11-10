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
	 * ������
	 * ��ÿ���ڵ���� ���ҵ�λ��
	 * Ȼ����ͬ�� �±� ȷ����ϵ
	 * @param s1
	 * @param s2
	 */
	public static void relatives(String s1,String s2) {
		System.out.println("���ܳɹ�!");
		LRtree.Node root[] = control.getroot();
		LRtree tree = new LRtree();//��ʼ��
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

		LRtree.Node root[] = controlNotFamily.getroot();//��������
		LRtree tree = new LRtree();//��ʼ��
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
			return null;//����
		}else {
		    if(flag1 == 0 && flag2 == 0) {
		    	return "�ֵ�";
		    }
			if(flag1 == 1 && flag2 == 1) {
			
				return (checkbro(root[i],buff));
			}else {
				return null;//���������� ����
			}
		}	   
		
		
	}


	public static String checkRelatives(Node head,String[] buff) {
		LRtree.Node oldhead = head;
		System.out.println("�����߼��ж�");
		boolean r1 =false ,r2 = false,r3 = false ,t1= false,t2 =false,t3 = false;
		LRtree tree = new LRtree();
		head = tree.find(oldhead, buff[0]);//��λ
		System.out.println("��һ�ζ�λ"+head.data);
		//ͬ����
		 r1 = finetreebro.find(head,buff[1]);//�ֵ�
		if(head.left != null ) {
			 r2 = finetreebro.find(head.left,buff[1]);//�ְ�
			if(head.left.left != null) {			
		       r3 = finetreebro.find(head.left.left, buff[1]);//үү
			}
		}
		
		head = tree.find(oldhead, buff[1]);
		System.out.println("�ڶ��ζ�λ"+head.data);
		 t1 = finetreebro.find(head,buff[0]);//�ֵ�
		 if(head.left != null ) {
			  t2 = finetreebro.find(head.left,buff[0]);//�ְ�
			if(head.left.left != null) {			
		        t3 = finetreebro.find(head.left.left, buff[0]);//үү
			}
		}
		
		if(r1 == true || t1 == true) { //��һ�������ǲ��Ǹ����ߵܵ�	
			getresult.getrelatives(bro(buff));
		}else if(r2 == true) {
			getresult.getrelatives("�ְ�");
		}else if(r3 == true) {
			getresult.getrelatives("үү");
		}else if(t2 == true) {
			getresult.getrelatives("����");
		}else if(t3 == true) {
			getresult.getrelatives("����");
		}else {
			return null;
		}
		return null;
	}
	

	private static String checkNotRelatives(Node head, String[] buff) {
		boolean r1 = false,r2 = false,t1 = false,t2 = false;
		LRtree tree = new LRtree();
		Node oldhead = head;
		head = tree.find(oldhead, buff[0]);//��λ
		//ͬ����
		 r1 = finetreebro.find(head,buff[1]);//ͬѧ
		if(head.left != null ) {
			 r2 = finetreebro.find(head.left,buff[1]);//��ʦ			
		}		
		head = tree.find(oldhead, buff[1]);	
		System.out.println(head.data);
		 	t1 = finetreebro.find(head,buff[0]);//ͬѧ
		if(head.left != null ) {
			 t2 = finetreebro.find(head.left,buff[0]);//ѧ��
		}
		System.out.println("r2"+r2);
		if(r1 == true || t1 == true) {
			getresult.getnotrelatives("ͬѧ");
		}else if(r2 == true) {
			getresult.getnotrelatives("��ʦ");
		}else if(t2 == true) {
			getresult.getnotrelatives("ѧ��");
		}
		return null;
	}
	

	private static String checkbro(broNode head, String[] buff) {
		// TODO Auto-generated method stub
		broLink link = new broLink();
		broNode oldhead = head; 
		head = link.find(oldhead, buff[0]);		
		boolean r1 = findlinkbro.find(head, buff[1]);//0��1�ĸ��		
		head = link.find(oldhead, buff[1]);	
		boolean r2 = findlinkbro.find(head,buff[0]);//1��0�ĸ��
		System.out.println("�����жϸ��/�ܵ�");
		System.out.println("r1"+r1);
		System.out.println("r2"+r2);
		if(r1 == true) {
			return "���";
		}else if(r2 == true) {
			return "�ܵ�";
		}else {
			return "�ֵ�";
		}
	}
	
	
}
