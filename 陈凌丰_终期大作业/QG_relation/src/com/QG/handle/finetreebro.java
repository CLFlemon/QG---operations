package com.QG.handle;

import com.QG.handle.LRtree.Node;

public class finetreebro {
	
	public static boolean find(Node head,String data) {
		if(head == null) return false;
		if(head.data.equals(data)) return true;
		else if(head.right != null) 	return find(head.right,data);		
		return false;
	}

}