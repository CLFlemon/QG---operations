package service;

import com.QG.*;
import com.QG.util.GetInfo;
import com.QG.handle.*;
import com.QG.handle.LRtree.Node;
import java.util.*;

public class controlInquiry {
	
	static String s1 = "";
	static String s2 = "";
	public static void entry(String str1,String str2) {
		s1 = str1;
		s2 = str2;
		relatives(str1,str2);
		notrelatives(str1,str2);	
	}
	
	public static String gets1() {
		return s1;
	}
	
	public static String gets2() {
		return s2;
	}
	public static void relatives(String str1,String str2) {
		System.out.println("·¢ËÍ³É¹¦£¡");
		relation.relatives(str1,str2);	
	}
	
	public static void notrelatives(String str1,String str2) {
		relation.notrelatives(str1,str2);	
	}
}
