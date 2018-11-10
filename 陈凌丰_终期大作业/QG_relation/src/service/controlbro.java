package service;
import com.QG.*;
import com.QG.util.GetInfo;
import com.QG.handle.*;
import com.QG.handle.LRtree.Node;
import com.QG.handle.broLink.broNode;

public class controlbro {
	
	static broNode root[] = new broNode[50];//���� 
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
		if(buff[2].equals("���")) {
			//�����κ���
		}else if(buff[2].equals("�ܵ�")) {
			String temp = "";
			temp = buff[0];
			buff[0] = buff[1];
			buff[1] = temp;
			buff[2] = "���";
		}//�����ͳһ�� XX��XX�ĸ��	
		check(buff);
	}
	
	private static void unify( String[] buff1,String[] buff2) {
		
		if(buff1[2].equals("���") && buff2[2].equals("�ܵ�")) {
			newbuff[0] = buff2[1];
			newbuff[1] = buff1[1];
			newbuff[2] = "���";	
		}else if(buff1[2].equals("�ܵ�") && buff2[2].equals("���")) {
			newbuff[0] = buff1[1];
			newbuff[1] = buff2[1];
			newbuff[2] = "���";
		}
		//�����ͳһ�� XX��XX�ĸ��	
		check(newbuff);
	}


	private static void check(String[] buff) {
		broLink link  = new broLink();
		int flag = 0;
		int i ;
		for(i = 0;i<buff.length && root[i] != null  ; i++) {
			if(link.traversal(root[i],buff[1])) {
				flag = 1; //�ܵ���������
				break;
			}
		}
		if(flag == 1) { //ȥ��
			old(i,root[i],buff);
		}else if(flag == 0) {
			notold(i,buff);
		}	
	}



	private static void old(int i,broNode broNode, String[] buff) {
		// TODO Auto-generated method stub
		broLink link  = new broLink();
		broNode head = link.find(broNode, buff[1]);//��λ ���濪ʼ����
		head = link.insert(head, buff[0]);//���� ����ͷ���
		root[i] = head; //����ͷ���
	}
	
	private static void notold(int i, String[] buff) {
		broLink link  = new broLink();
		broNode head  = null;
		head =   link.creat(head  ,buff[1]);//�Եܵܽ����ڵ�
		head =  link.insert(head, buff[0]);
		root[i] = head;	
	}

}
