package com.QG.handle;

import com.QG.*;
import com.QG.handle.LRtree.Node;

public class broLink {
	
	
	public class broNode {
		public String data;
		public broNode next;
		
		public broNode(String data) {
			this.data = data;
			next = null;
		}
	}
	
	public broLink() {
	}
	
	public broNode creat(broNode head , String data) {	
		broNode newNode = new broNode(data);
		head = newNode;
		return head;
	}//创立头结点
	
	/**
	 * 判断这个节点在不在这条链表上
	 * @param head
	 * @param data
	 * @return
	 */
	public boolean traversal(broNode head,String data) {	
		   if(head == null) return false;
		   if(head.data.equals(data)) return true; 
		   if( traversal(head.next,data)) return true;  
		   return false;
		}
	/**
	 * 定位函数
	 * @param head
	 * @param data
	 * @return
	 */
	public broNode find(broNode head,String data) {
		if(head ==null) return null;
		if(head.data.equals(data)) return head;
		else if	(head.next != null)	return find(head.next,data);
		return head;			
	}
	/**
	 * 插入函数
	 * @param head
	 * @param data
	 */
	public broNode insert(broNode head,String data) {
		broNode newNode = new broNode(data);
		newNode.next = head;
		return newNode;
	}
	

}
