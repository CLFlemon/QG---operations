package service;

import javax.swing.JOptionPane;

import com.QG.*;
import com.QG.util.GetInfo;
import com.QG.handle.*;
import com.QG.handle.LRtree.Node;
public class control {
	
	static LRtree.Node root[] = new LRtree.Node[50];//��ʼ��root���� ������head���� 
	public static Node[] getroot() {	
     	return root;
	}
	/**
	 * �ж�ab����
	 * @param buff
	 */
	public static void receive(String buff[]) { // �����и������String����
		check(root,buff);//����ȥ����
	}
	/**
	 * �ж�c����
	 * @param buff1
	 * @param buff2
	 */
	public static void receive(String buff1[],String buff2[]) {
		check(root,buff1,buff2);	
	}
	/**
	 * ���ܣ��Ե�һ�͵ڶ����Ͷ�����ҵ�������ж�
	 * 1��������������һ���˴������� && ��һ����Ϊ�½�� ��ʱ��һ����Ϊê�����
	 * 2�������˶����½�� ��ʱ��������
	 * 3�������˶��Ǿɽ�� && ����ͬһ�����ϡ���ʱ���������ϲ�
	 * @param root
	 * @param buff
	 */
	public static void check(LRtree.Node root[],String buff[]) {
		LRtree tree = new LRtree();//��ʼ��
		LRtree.Node head1 = null;//�����һ���������ÿһ��root[i]
		LRtree.Node head2 = null;//����ڶ����˽���ÿһ��root[i];
		int flag1 = 0;
		int flag2 = 0;//���
		int i;
		int j;
		for(i = 0; i<root.length && root[i] != null;i++) {
			head1 = root[i];
			 if(buff[0] != "δ֪��" && tree.preOrder(head1, buff[0]) ) { //һ������Ϊê��
				  flag1 = 1;
				  break;
			  }	
		}
		for(j = 0; j<root.length && root[j] != null;j++) {
			head2 = root[j];
			 if(buff[1] != "δ֪��" && tree.preOrder(head2, buff[1]) ) { //��������Ϊê��
				  flag2 = 1;
				  break;
			  }	
		}//������� ���濪ʼ�߼��ж�
		System.out.println("flag1"+flag1 + "\n"+"flag2"+flag2);
		
		if(flag1 == 1 && flag2 == 0) {  //һ��ê��
			old(head1,buff);
		}else if(flag1 == 0 && flag2 == 1) { //����ê�� ��������
		       //�Ȼ�λ��
			String temp = "";
			temp = buff[0];
			buff[0] = buff[1];
			buff[1] = temp;//��λ����� ���濪ʼ����ϵ
			System.out.println("δ�任ǰ"+buff[2]);
			if(buff[2].equals("�ְ�")) buff[2] = "����";
			else if(buff[2].equals("����")) buff[2] = "�ְ�";
			else if(buff[2].equals("үү")) buff[2] = "����";
			else if(buff[2].equals("����")) buff[2] = "үү";
			else if(buff[2].equals("���")) buff[2] = "�ܵ�";
			else if(buff[2].equals("�ܵ�")) buff[2] = "���"; //��ϵ����	
			System.out.println("�任��"+buff[2]);
			old(head2,buff);
		}else if(flag1 == 0 && flag2 == 0) { //��������
					notold(i,head1,buff,root);
		}else if(flag1 == 1 && flag2 == 1) { // �ϲ��� 
			 if(i == j) {
				JOptionPane.showMessageDialog(null, "����","�������",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			 }else {
				combine(i,j,head1,head2,buff,0);
			}
		}	
	}
	
	/**
	 * �ú�����Ҫ�ǶԵ�������������ж�
	 1��������������һ���˴������� && ��һ����Ϊ�½�� ��ʱ��һ����Ϊê�����
	 * 2�������˶����½�� ��ʱ��������
	 * 3�������˶��Ǿɽ�� && ����ͬһ�����ϡ���ʱ���������ϲ�
	 * @param root
	 * @param buff1
	 * @param buff2
	 */
	
	public static void check(LRtree.Node root[],String buff1[],String buff2[]) {
		LRtree tree = new LRtree();//��ʼ��
		LRtree.Node head = null;//����ÿһ��root[i]
		int flag1 = 0;
		int flag2 = 0;//������־λ��һ���������� ��һ������
		int i ;
		int j;
		for(i = 0; i<root.length && root[i] != null;i++) {
			  head = root[i];	
			  if(buff1[1] != "δ֪��" && tree.preOrder(head, buff1[1]) ) {
				  flag1 = 1;
				  break;
			  }	
		}
		for(j = 0; j<root.length && root[j] != null;j++) {
			  head = root[j];	
			  if(buff2[1] != "δ֪��" && tree.preOrder(head, buff2[1]) ) {
				  flag2 = 1;
				  break;
			  }	
		}		
		if(flag1 == 1 && flag2 == 0) { //��һ��������ǰ���� ��ê��
			//��һ���Ȱ�ê��λ�û���
			String temp = "";
			temp = buff1[0];
			buff1[0] = buff1[1];
			buff1[1] = temp;
			//�ڶ�����λ�û���
			if(buff1[2].equals("�ְ�")) buff1[2] = "����";
			else if(buff1[2].equals("����")) buff1[2] = "�ְ�";
			else if(buff1[2].equals("үү")) buff1[2] = "����";
			else if(buff1[2].equals("����")) buff1[2] = "үү";
			else if(buff1[2].equals("���")) buff1[2] = "�ܵ�";
			else if(buff1[2].equals("�ܵ�")) buff1[2] = "���";
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
			if(buff2[2].equals("�ְ�")) buff2[2] = "����";
			else if(buff2[2].equals("����")) buff2[2] = "�ְ�";
			else if(buff2[2].equals("үү")) buff2[2] = "����";
			else if(buff2[2].equals("����")) buff2[2] = "үү";
			else if(buff2[2].equals("���")) buff2[2] = "�ܵ�";
			else if(buff2[2].equals("�ܵ�")) buff2[2] = "���";
			old(head,buff2,buff1);		
		}else if(flag1 == 0 && flag2 == 0 ) { //�����˶������� ��������
			head = null;
			notold(head,buff1,buff2,root);	
		}else if(flag1 == 1 && flag2 ==1 ) { //�ϲ���
			if(i == j) {
				JOptionPane.showMessageDialog(null, "����","�������",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}else {
				String temp = "";
				temp = buff1[0];
				buff1[0] = buff1[1];
				buff1[1] = temp;
				//�ڶ�����λ�û���
				if(buff1[2].equals("�ְ�")) buff1[2] = "����";
				else if(buff1[2].equals("����")) buff1[2] = "�ְ�";
				else if(buff1[2].equals("үү")) buff1[2] = "����";
				else if(buff1[2].equals("����")) buff1[2] = "үү";
				else if(buff1[2].equals("���")) buff1[2] = "�ܵ�";
				else if(buff1[2].equals("�ܵ�")) buff1[2] = "���";
				combine(i,j,root[i],root[j],buff1,buff2);
		   }
		}
	}
	
	
	public static void old(LRtree.Node head,String buff[]) {
		System.out.println("�ڶ���");
		System.out.println(buff[2]);
		LRtree tree = new LRtree();
		head = tree.find(head, buff[0]);
		if(buff[2].equals("�ְ�")) {
			tree.insertleft(head,buff[1]);
		}else if(buff[2].equals("�ֵ�") || buff[2].equals("���")|| buff[2].equals("�ܵ�")) {
			tree.insertright(head,buff[1]);
		}else if(buff[2].equals("үү")) {
			if(head.left == null) {
				tree.insertleft(head, "δ֪��");
			}
			tree.insertleft(head.left, buff[1]);			
		}else if(buff[2].equals("����")) {
			if(head.parent == null) {
				tree.insertparent(head, buff[1]);
			}else if(head.parent.data.equals("δ֪��")) {
				tree.insertparent(head, buff[1]);
			}else {
				JOptionPane.showMessageDialog(null, "����","�������",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
		//	tree.insertparent(head, buff[1]);
		}else if(buff[2].equals("����")) {
			if(head.parent == null) {
				tree.insertparent(head, "δ֪��");
			}
			if(head.parent.parent == null) {
				tree.insertparent(head.parent, buff[1]);
			}else if(head.parent.parent.data.equals("δ֪��")) {
				tree.insertparent(head.parent, buff[1]);
			}else {
				JOptionPane.showMessageDialog(null, "����","�������",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
		}
		while(head.parent != null) {
			head = head.parent;
		}
	}
	
	public static void old(LRtree.Node head,String buff1[],String buff2[]) { //buff[1]��ê��
		LRtree tree = new LRtree();
		head = tree.find(head, buff1[0]);
		if(buff1[2].equals("�ְ�")) { // ���Գɹ�
			tree.insertleft(head,buff1[1]);
			head  = tree.getRoot();//ת��ê��
		}else if(buff1[2].equals("�ֵ�") || buff1[2].equals("���")|| buff1[2].equals("�ܵ�")) {
			tree.insertright(head,buff1[1]);//
			head  = tree.getRoot();
		}else if(buff1[2].equals("үү")) {
			if(head.left == null) {
				tree.insertleft(head, "δ֪��");
			}
			tree.insertleft(head.left, buff1[1]);
			head = tree.getRoot();		
		}else if(buff1[2].equals("����")) {	
			tree.insertparent(head, buff1[1]);
			head = tree.getRoot();
		}else if(buff1[2].equals("����")) {
			if(head.parent == null) {
				tree.insertparent(head, "δ֪��");
			}
			tree.insertparent(head.parent, buff1[1]);
			head = tree.getRoot();
		}//������һ�� ���濪ʼ����ڶ���		
		if(buff2[2].equals("�ְ�")) {
			tree.insertleft(head,buff2[1]);
		}else if(buff2[2].equals("�ֵ�") || buff2[2].equals("���")|| buff2[2].equals("�ܵ�")) {
			tree.insertright(head,buff2[1]);
		}else if(buff2[2].equals("үү")) {
			if(head.left == null) {
				tree.insertleft(head, "δ֪��");
			}
			tree.insertleft(head.left, buff2[1]);	
		}else if(buff2[2].equals("����")) {
			tree.insertparent(head, buff2[1]);
		}else if(buff2[2].equals("����")) {
			if(head.parent == null) {
				tree.insertparent(head, "δ֪��");
			}
			tree.insertparent(head.parent, buff2[1]);
		}// ������ڶ���		
		while(head.parent != null) {
			head = head.parent;
		}//����һ���ҵ����������		
	}
	
	public static void notold(int i,LRtree.Node head,String buff[],LRtree.Node root[]) {
		LRtree tree = new LRtree();
		head = tree.creat(head,buff[0]);//�������
		if(buff[2].equals("�ְ�")) {
	 	tree.insertleft(head,buff[1]); 
	 	
	    }else if(buff[2].equals("�ֵ�") || buff[2].equals("���") || buff[2].equals("�ܵ�")) {
		 	tree.insertright(head,buff[1]);
		 	
	    }else if(buff[2].equals("үү")) {
	    	if(head.left == null ) {
	    		tree.insertleft(head,"δ֪��");
	    	}	
	    	tree.insertleft(head.left,buff[1]);	
	    	
        }else if(buff[2].equals("����")) {
        	tree.insertparent(head, buff[1]);
        }else if(buff[2].equals("����")) {
        	if(head.parent == null) {
        		tree.insertparent(head, "δ֪��");
        	}
        	tree.insertparent(head.parent, buff[1]);
        }
		//����ͷ��� ����ͷ��㲻�䡣
		while(head.parent != null) {
			head = head.parent;
		}
		root[i++] = head;//�洢���
	//	System.out.println("2"+head.data);
	}
	
	public static void notold(LRtree.Node head,String buff1[],String buff2[],LRtree.Node root[]) {
		
		LRtree tree = new LRtree();//��ʼ������
		head = tree.creat(head,buff1[0]);//ͷ��� ���濪ʼ�ֹ�ϵ��������
		if(buff1[2].equals("�ְ�")) {
			tree.insertleft(head,buff1[1]);//���� 
		}else if(buff1[2].equals("�ֵ�") || buff1[2].equals("���") || buff1[2].equals("�ܵ�")) {
		 	tree.insertright(head,buff1[1]);	 	
	    }else if(buff1[2].equals("үү")) {
	    	if(head.left == null) {
	    		tree.insertleft(head,"δ֪��");  
	    	}
	    	tree.insertleft(head.left,buff1[1]);	  	
        }else if(buff1[2].equals("����")) {
            tree.insertparent(head, buff1[1]);
        }else if(buff1[2].equals("����")) {
        	if(head.left == null) {
        		tree.insertparent(head, "δ֪��");
        	}
        	tree.insertparent(head.parent, buff1[1]);
        }//������һ���Ѿ�������濪ʼ����ڶ���
		

		if(buff2[2].equals("�ְ�")) {
			tree.insertleft(head,buff2[1]);//���� 
		}else if(buff2[2].equals("�ֵ�") || buff2[2].equals("���") || buff2[2].equals("�ܵ�")) {
		 	tree.insertright(head,buff2[1]);	 	
	    }else if(buff2[2].equals("үү")) {
	    	if(head.left == null) {
	    		tree.insertleft(head,"δ֪��"); 
	    	}
	    	tree.insertleft(head.left,buff2[1]);	  	
        }else if(buff2[2].equals("����")) {
            tree.insertparent(head, buff2[1]);
        }else if(buff2[2].equals("����")) {
        	if(head.parent == null) {
        	tree.insertparent(head, "δ֪��");
        	}
        	tree.insertparent(head.parent, buff2[1]);
        }
		
		while(head.parent != null) {
			head = head.parent;
		}//����һ��ͷ���
		
		int i;
		for( i = 0;i<root.length && root[i] != null ; i++) {}
		root[i] = head;//����
	}
	
	private static void combine(int i, int j, Node head1, Node head2, String[] buff,int flag) {
		
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
		
		
		
		if(buff[2].equals("�ְ�")) {
			tree.insertleft(head1, head2);
		}else if(buff[2].equals("үү")) { // ���ж϶����Ƿ���� �����ھͲ���һ��δ֪��
			if(head1.left == null) {
				tree.insertleft(head1, "δ֪��");
			}
			tree.insertleft(head1.left, head2); // �൱��ת���ɵ�һ��
		
		}else if(buff[2].equals("�ֵ�") || buff[2].equals("���") || buff[2].equals("�ܵ�")) {
			if(head1.parent == null) {
				tree.insertparent(head1, "δ֪��");
			}
			tree.insertleft(head1.parent,head2);		
			
		}else if(buff[2].equals("����")) { //head1��head2�Ķ��ӵȼ���head2��head1�İְ�
			tree.insertleft(head2, head1);
	
		}else if(buff[2].equals("����")) { //head1��head2�����ӵȼ���head2��head1��үү
			if(head2.left == null) {
				tree.insertleft(head2, "δ֪��");
			}
			tree.insertleft(head2.left, head1);	
		}
		
		
		//���濪ʼ����  ���ж��Ǹ�����һ�����
		if(buff[2].equals("����") || buff[2].equals("����")) { //����head2
			while(head2.parent != null) {
				head2 = head2.parent;
			}//����һ��ͷ���
			tree.update(head2);
			if(head2.data.equals("δ֪��") && head2.right != null) {
				head2 = head2.right;
			}
			//���濪ʼ�ı������� �ı�i 
			root[min] = head2;
			int m ;
			for( m = max ; m<root.length-1 && root[m] != null ;m++) {
				root[m] = root[m+1];
			}
			root[m] = null;
			
		}else { //����head1
			while(head1.parent != null) {
				head1 = head1.parent;
			}//����һ��ͷ���
				tree.update(head1);
			if(head1.data.equals("δ֪��") && head1.right != null) {
				head1 = head1.right;
			}	
			root[min] = head1;
			int m ;
			for( m = max ; m<root.length-1 && root[m] != null ;m++) {
				root[m] = root[m+1];
			}
			root[m] = null;
		}
		System.out.println(root[0].data);
		
	}
	
	private static void combine(int i, int j, Node head1, Node head2, String[] buff1, String[] buff2) {
		
		LRtree tree = new LRtree();
		head1 = tree.find(head1, buff1[0]);
		if(buff1[2].equals("�ְ�")) { // ���Գɹ�
			tree.insertleft(head1,buff1[1]);
			head1  = tree.getRoot();//ת��ê��
		}else if(buff1[2].equals("�ֵ�") || buff1[2].equals("���")|| buff1[2].equals("�ܵ�")) {
			tree.insertright(head1,buff1[1]);//
			head1  = tree.getRoot();
		}else if(buff1[2].equals("үү")) {
			if(head1.left == null) {
				tree.insertleft(head1, "δ֪��");
			}
			tree.insertleft(head1.left, buff1[1]);
			head1 = tree.getRoot();		
		}else if(buff1[2].equals("����")) {
			tree.insertparent(head1, buff1[1]);
			head1 = tree.getRoot();
		}else if(buff1[2].equals("����")) {
			if(head1.parent == null) {
				tree.insertparent(head1, "δ֪��");
			}
			tree.insertparent(head1.parent, buff1[1]);
			head1 = tree.getRoot();
		}//������һ��
		// ���濪ʼ�ϲ���
	//	System.out.println(head1.data);
		
		combine(i,j,head1,head2,buff2,1);//ת���ɵ�һ��
	}
	
}
