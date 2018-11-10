package com.QG.handle;

import com.QG.handle.broLink.broNode;;

public class findlinkbro {

	public static boolean find(broNode head,String data) {
		if(head == null) return false;
		if(head.data.equals(data)) return true;
		else if(head.next != null) 	return find(head.next,data);		
		return false;
	}
}
