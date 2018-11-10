package service;
import com.QG.*;
import com.QG.util.GetInfo;
import com.QG.handle.*;
import com.QG.handle.LRtree.Node;
import com.QG.handle.broLink.broNode;

public class controlbro {
	
	static broNode root[] = new broNode[50];//存结点 
	static String newbuff[] = new String[3];
	
	public static void receive(String buff[]) {
		  unify(buff);
	}
	

	public static void receive(String buff1[],String buff2[]) {
          unify(buff1,buff2);
	}
	
	public static broNode[] getroot() {
		return root;
	}
	private static void unify(String[] buff) {
		if(buff[2].equals("哥哥")) {
			//不做任何事
		}else if(buff[2].equals("弟弟")) {
			String temp = "";
			temp = buff[0];
			buff[0] = buff[1];
			buff[1] = temp;
			buff[2] = "哥哥";
		}//结果：统一了 XX是XX的哥哥	
		check(buff);
	}
	
	private static void unify( String[] buff1,String[] buff2) {
		
		if(buff1[2].equals("哥哥") && buff2[2].equals("弟弟")) {
			newbuff[0] = buff2[1];
			newbuff[1] = buff1[1];
			newbuff[2] = "哥哥";	
		}else if(buff1[2].equals("弟弟") && buff2[2].equals("哥哥")) {
			newbuff[0] = buff1[1];
			newbuff[1] = buff2[1];
			newbuff[2] = "哥哥";
		}
		//结果：统一了 XX是XX的哥哥	
		check(newbuff);
	}


	private static void check(String[] buff) {
		broLink link  = new broLink();
		int flag = 0;
		int i ;
		for(i = 0;i<buff.length && root[i] != null  ; i++) {
			if(link.traversal(root[i],buff[1])) {
				flag = 1; //弟弟在链表上
				break;
			}
		}
		if(flag == 1) { //去旧
			old(i,root[i],buff);
		}else if(flag == 0) {
			notold(i,buff);
		}	
	}



	private static void old(int i,broNode broNode, String[] buff) {
		// TODO Auto-generated method stub
		broLink link  = new broLink();
		broNode head = link.find(broNode, buff[1]);//定位 下面开始插入
		head = link.insert(head, buff[0]);//插入 更新头结点
		root[i] = head; //更新头结点
	}
	
	private static void notold(int i, String[] buff) {
		broLink link  = new broLink();
		broNode head  = null;
		head =   link.creat(head  ,buff[1]);//以弟弟建立节点
		head =  link.insert(head, buff[0]);
		root[i] = head;	
	}

}
