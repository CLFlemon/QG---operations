package service;

import com.QG.*;
import com.QG.util.GetInfo;
import com.QG.handle.*;
import com.QG.handle.LRtree.Node;

public class controlNotFamily {
	static LRtree.Node NFroot[] = new LRtree.Node[50];
	
	public static void receive(String buff[]) {
		check(NFroot,buff);
	}
	
	public static void receive(String buff1[],String buff2[]) {
		check(NFroot,buff1,buff2);
	}

    public static Node[] getroot() {
    	return NFroot;
    }

	private static void check(Node[] nFroot2, String[] buff) {
		LRtree tree = new LRtree();//��ʼ��
		LRtree.Node head1 = null;//�����һ���������ÿһ��root[i]
		LRtree.Node head2 = null;//����ڶ����˽���ÿһ��root[i];
		int flag1 = 0;
		int flag2 = 0;//���
		int i;
		int j;
		for(i = 0; i<NFroot.length && NFroot[i] != null;i++) {
			head1 = NFroot[i];
			 if(buff[0] != "δ֪��" && tree.preOrder(head1, buff[0]) ) { //һ������Ϊê��
				  flag1 = 1;
				  break;
			  }	
		}
		for(j = 0; j<NFroot.length && NFroot[j] != null;j++) {
			head2 = NFroot[j];
			 if(buff[1] != "δ֪��" && tree.preOrder(head2, buff[1]) ) { //��������Ϊê��
				  flag2 = 1;
				  break;
			  }	
		}//������� ���濪ʼ�߼��ж�
		if(flag1 == 1 && flag2 == 0) {  //һ��ê��
			old(head1,buff);
		}else if(flag1 == 0 && flag2 == 1) { //����ê�� ��������
	       //�Ȼ�λ��
			String temp = "";
			temp = buff[0];
			buff[0] = buff[1];
			buff[1] = temp;//��λ����� ���濪ʼ����ϵ
			if(buff[2] == "��ʦ") buff[2] = "ѧ��";
			else if(buff[2] == "ѧ��") buff[2] = "��ʦ";//ʦ����ϵ����	  	
			old(head2,buff);
		}else if(flag1 == 0 && flag2 == 0) { //��������
			notold(i,head1,buff,NFroot);
		}else if(flag1 == 1 && flag2 == 1) { // �ϲ��� 
			combine(i,j,head1,head2,buff,0);
		}
	}
	
	private static void check(Node[] nFroot2, String[] buff1, String[] buff2) {
		LRtree tree = new LRtree();//��ʼ��
		LRtree.Node head = null;//����ÿһ��root[i]
		int flag1 = 0;
		int flag2 = 0;//������־λ��һ���������� ��һ������
		int i ;
		int j;
		for(i = 0; i<NFroot.length && NFroot[i] != null;i++) {
			  head = NFroot[i];	
			  if(buff1[1] != "δ֪��" && tree.preOrder(head, buff1[1]) ) {
				  flag1 = 1;
				  break;
			  }	
		}
		for(j = 0; j<NFroot.length && NFroot[j] != null;j++) {
			  head = NFroot[j];	
			  if(buff2[1] != "δ֪��" && tree.preOrder(head, buff2[1]) ) {
				  flag2 = 1;
				  break;
			  }	
		}	//������� ���濪ʼ�߼��ж�
		if(flag1 == 1 && flag2 == 0) { //��һ��������ǰ���� ��ê��
			//��һ���Ȱ�ê��λ�û���
			String temp = "";
			temp = buff1[0];
			buff1[0] = buff1[1];
			buff1[1] = temp;
			//�ڶ�����λ�û���
			if(buff1[2].equals("��ʦ")) buff1[2] = "ѧ��";
			else if(buff1[2].equals("ѧ��")) buff1[2] = "��ʦ";
			//��������ʼ�Ѵ�����  �ȴ���buff1 ������buff2;
			old(head,buff1,buff2);
		}else if(flag1 == 0 && flag2 ==1) { // �ڶ�������ǰ����
			
		//	System.out.println(flag2);
			//��һ���Ȱ�ê��λ�û���
			String temp = "";
			temp = buff2[0];
			buff2[0] = buff2[1];
			buff2[1] = temp;
			//�ڶ�����λ�û���
			if(buff2[2].equals("��ʦ")) buff2[2] = "ѧ��";
			else if(buff2[2].equals("ѧ��")) buff2[2] = "��ʦ";
			old(head,buff2,buff1);		
		}else if(flag1 == 0 && flag2 == 0 ) { //�����˶������� ��������
			head = null;
			notold(head,buff1,buff2,NFroot);
		}else if(flag1 == 1 && flag2 ==1 ) { //�ϲ���
			String temp = "";
			temp = buff1[0];
			buff1[0] = buff1[1];
			buff1[1] = temp;
			//�ڶ�����λ�û���
			if(buff1[2].equals("��ʦ")) buff1[2] = "ѧ��";
			else if(buff1[2].equals("ѧ��")) buff1[2] = "��ʦ";	
			combine(i,j,NFroot[i],NFroot[j],buff1,buff2);
		}
		
	}


	private static void notold(Node head, String[] buff1, String[] buff2, Node[] nFroot2) {
		LRtree tree = new LRtree();//��ʼ������
		head = tree.creat(head,buff1[0]);//ͷ��� ���濪ʼ�ֹ�ϵ��������
		if(buff1[2].equals("��ʦ")) {
			tree.insertleft(head,buff1[1]);//���� 
		}else if(buff1[2].equals("ͬѧ") ) {
		 	tree.insertright(head,buff1[1]);	 	
	    }else if(buff1[2].equals("ѧ��")) {
            tree.insertparent(head, buff1[1]);
        }//������һ���Ѿ�������濪ʼ����ڶ���
		

		if(buff2[2].equals("��ʦ")) {
			tree.insertleft(head,buff2[1]);//���� 
		}else if(buff2[2].equals("ͬѧ")) {
		 	tree.insertright(head,buff2[1]);	 	
	    }else if(buff2[2].equals("ѧ��")) {
            tree.insertparent(head, buff2[1]);
        }
		
		while(head.parent != null) {
			head = head.parent;
		}//����һ��ͷ���
		

		int i;
		for( i = 0;i<NFroot.length && NFroot[i] != null ; i++) {}
		NFroot[i] = head;//����
		
	}

	private static void notold(int i, Node head, String[] buff, Node[] nFroot2) {
		// TODO Auto-generated method stub
		LRtree tree = new LRtree();
		head = tree.creat(head,buff[0]);//�������
		if(buff[2].equals("��ʦ")) {
	 	tree.insertleft(head,buff[1]); 
	 	
	    }else if(buff[2].equals("ͬѧ")) {
		 	tree.insertright(head,buff[1]);
		 	
	    }else if(buff[2].equals("ѧ��")) {
        	tree.insertparent(head, buff[1]);
        }
		
		while(head.parent != null) {
			head = head.parent;
		}
		
		NFroot[i++] = head;//�洢���
	}

	private static void old(Node head, String[] buff) {
		// TODO Auto-generated method stub
		LRtree tree = new LRtree();
		head = tree.find(head, buff[0]);
		if(buff[2].equals("ѧ��")) {
			tree.insertleft(head,buff[1]);
		}else if(buff[2].equals("ͬѧ")) {
			tree.insertright(head,buff[1]);
		}else if(buff[2].equals("��ʦ")) {
			tree.insertparent(head, buff[1]);
		}
		while(head.parent != null) {
			head = head.parent;
		}
		
	}	
	
	private static void old(Node head, String[] buff1, String[] buff2) {
		LRtree tree = new LRtree();
		head = tree.find(head, buff1[0]);
		if(buff1[2].equals("��ʦ")) { // ���Գɹ�
			tree.insertleft(head,buff1[1]);
			head  = tree.getRoot();//ת��ê��
		}else if(buff1[2].equals("ͬѧ")) {
			tree.insertright(head,buff1[1]);//
			head  = tree.getRoot();
		}else if(buff1[2].equals("ѧ��")) {
			tree.insertparent(head, buff1[1]);
			head = tree.getRoot();
		}//������һ�� ���濪ʼ����ڶ���	
		
		if(buff2[2].equals("��ʦ")) {
			tree.insertleft(head,buff2[1]);
		}else if(buff2[2].equals("ͬѧ")) {
			tree.insertright(head,buff2[1]);
		}else if(buff2[2].equals("ѧ��")) {
			tree.insertparent(head, buff2[1]);
		}// ������ڶ���		
		while(head.parent != null) {
			head = head.parent;
		}//����һ���ҵ����������	
		
	}
	
	private static void combine(int i, int j, Node head1, Node head2, String[] buff, int flag) {
		// TODO Auto-generated method stub
		int max = i>j ? i:j ;
		int min = i>j ? j:i ; //�ı�������
		LRtree tree = new LRtree();//��ʼ������
		if(flag == 0) {
			head1 = tree.find(head1,buff[0]);//�ҵ�����ר���Ľ��
		    head2 = tree.find(head2,buff[1]);//�ҵ�����ר���Ľ��
		}else if(flag == 1) {
			head2 = tree.find(head2, buff[1]);
		}
		//�жϹ�ϵ
		
		
		
		if(buff[2].equals("��ʦ")) {
			tree.insertleft(head1, head2);
		}else if(buff[2].equals("ͬѧ")) {
			if(head1.parent == null) {
				tree.insertparent(head1, "δ֪��");
			}
			tree.insertleft(head1.parent,head2);		
			
		}else if(buff[2].equals("ѧ��")) { //head1��head2��ѧ���ȼ���head2��head1����ʦ
			tree.insertleft(head2, head1);
		}
		
		
		//���濪ʼ����  ���ж��Ǹ�����һ�����
		if(buff[2].equals("ѧ��") ) { //����head2
			while(head2.parent != null) {
				head2 = head2.parent;
			}//����һ��ͷ���
			tree.update(head2);
			if(head2.data.equals("δ֪��") && head2.right != null) {
				head2 = head2.right;
			}
			//���濪ʼ�ı������� �ı�i 
			NFroot[min] = head2;
			int m ;
			for( m = max ; m<NFroot.length-1 && NFroot[m] != null ;m++) {
				NFroot[m] = NFroot[m+1];
			}
			NFroot[m] = null;
			
		}else { //����head1
			while(head1.parent != null) {
				head1 = head1.parent;
			}//����һ��ͷ���
				tree.update(head1);
			if(head1.data.equals("δ֪��") && head1.right != null) {
				head1 = head1.right;
			}	
			NFroot[min] = head1;
			int m ;
			for( m = max ; m<NFroot.length-1 && NFroot[m] != null ;m++) {
				NFroot[m] = NFroot[m+1];
			}
			NFroot[m] = null;
		}
		
	}
	
	private static void combine(int i, int j, Node head1, Node head2, String[] buff1, String[] buff2) {
		LRtree tree = new LRtree();
		head1 = tree.find(head1, buff1[0]);
		if(buff1[2].equals("��ʦ")) { // ���Գɹ�
			tree.insertleft(head1,buff1[1]);
			head1  = tree.getRoot();//ת��ê��
		}else if(buff1[2].equals("ͬѧ") ) {
			tree.insertright(head1,buff1[1]);//
			head1  = tree.getRoot();
		}else if(buff1[2].equals("ѧ��")) {
			tree.insertparent(head1, buff1[1]);
			head1 = tree.getRoot();
		}//������һ��
		// ���濪ʼ�ϲ���
		combine(i,j,head1,head2,buff2,1);//ת���ɵ�һ��
		
	}
	
	
	
	
}
