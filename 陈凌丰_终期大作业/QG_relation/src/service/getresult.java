package service;

import com.QG.*;
import com.QG.util.GetInfo;
import com.QG.handle.*;
import com.QG.handle.LRtree.Node;

public class getresult {
	 
		 static  String data1 = null;//Ç×Êô
	     static  String data2 = null;//·ÇÇ×Êô
		public static void getrelatives(String data) {
			System.out.println(data);
				data1 = data;
		}
		
		public static String getdata1() {
			return data1;
		}
		
		public static void getnotrelatives(String data) {	
			System.out.println(data);
				data2 = data;
			
		}
		
		public static String getdata2() {
			return data2;
		}
		
}
