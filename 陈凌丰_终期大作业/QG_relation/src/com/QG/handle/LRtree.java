package com.QG.handle;

import com.QG.*;

public class LRtree {
	
	public class Node {
		public String data;
		public Node parent;
		public Node left;
		public Node right;
		
		public Node(String data) {
			this.data = data;
			parent = null;
			left = null;
			right = null;
		}
	}
	public static Node root = null;
	
	public Node getRoot() {
		return root;
	}
	
	public void SteRoot(Node root) {
		this.root = root;
	}
	
	public LRtree() {
	//	root = null;
	}
	
	//����ͷ���
	public Node creat(Node head ,String data) {	
		Node newNode = new Node(data);
		head = newNode;
		return head;
	}
	
	//��������� �Ǻϲ����߼�ҵ��
	public void insertleft(Node head ,String data) {
	
       if(head.left == null ) { //��һ�����ӻ�û����
			Node newNode = new Node(data);//�������
			Node current = head;			 
			current.left = newNode;
			newNode.parent = current;//��������
			root = newNode;//��ê�㷵����	
		}else if(head.left != null && head.left.data == "δ֪��") { //�е�һ�����ӵ���δ֪�� ��ʱ�滻
    	   head.left.data = data;
    	   root = head.left;
        }else if(head.left != null && head.left.data != "δ֪��") { //�ڶ������� ���ڵ�һ�����ӵ��ұ�
        	 Node newNode = new Node(data);//����һ�����		
			 Node current = head.left; //�Ѿ����ڵĶ���
			 while(true) {
					if(current.right == null) {//��λ�Һ���
						current.right = newNode;
						newNode.parent = current;//��������
						root = current;
						break;
			       }
				   current = current.right;//���ֵܷ�����
			}
        }
	}
	

	
	public void insertleft(Node head1 ,Node head2) { //head2�ϲ���head1;
		//�Ƚ������������ȱ���
		int flag1 = 2;
		int flag2 = 1;//��Ϊhead1��head2�İְ� ���Ա�����Ȼ��һ��
		Node newNode1 = head1;
		while(true) {
			//�ж�parent���ֵܻ��Ǹ�ĸ
			if(newNode1.parent != null) {
				
				if(newNode1 == newNode1.parent.left) { //��ĸ
					flag1++;//����++
					newNode1 = newNode1.parent;
				}else if(newNode1 == newNode1.parent.right) { //�ֵ�
					newNode1 = newNode1.parent;
				}
			}else break;		
		}
		Node newNode2 = head2;
		while(true) {
			//�ж�parent���ֵܻ��Ǹ�ĸ
			if(newNode2.parent != null) {
				
				if(newNode2 == newNode2.parent.left) { //��ĸ
					flag2++;//����++
					newNode2 = newNode2.parent;
				}else if(newNode2 == newNode2.parent.right) { //�ֵ�
					newNode2 = newNode2.parent;
				}
			}else break;		
		}
		/**
		 * ��������ѭ����newNode1��newNode2����������������
		 */
		//�ж��齨����
		if(flag1>=flag2) { //head1���Ǳ��ִ�
			int count = flag1-flag2;
			while(count!= 0) {
				if(newNode1.left == null) {
					insertleft(newNode1,"δ֪��");
					newNode1 = newNode1.left;
				}else newNode1 = newNode1.left;
				count--;
			}
			//�ֵܺϲ�
			while(true)
			{
				if(newNode1.right == null) {
					newNode1.right = newNode2;
					newNode2.parent = newNode1;
					break;
				}
				newNode1 = newNode1.right;
			}
		}else { // head2�ı��ִ�
			int count = flag2-flag1;
			while(count!=0) {
				newNode2 = newNode2.left;
				count--;
			}
			//�ֵܺϲ�
			while(true)
			{
				if(newNode2.right == null) {
					newNode2.right = newNode1;
					newNode1.parent = newNode2;
					break;
				}
				newNode2 = newNode2.right;
			}		
		}  	
	}
	
	//�����Ҷ���
	public void insertright(Node head,String data) {
		Node newNode = new Node(data);//����һ�����
		//���ǿյ�
		Node current = head;
		while(true) {
			if(current.right == null) {//��λ
				current.right = newNode;
				newNode.parent = newNode;
				root  = newNode;
				break;
			}
			    current = current.right;
		}
	}
	
	public void insertparent(Node head,String data) {
		if(data == "δ֪��") {//��ʱ���һ��δ֪�� ���濪ʼ�߼��ж� 
			if(head.parent == null) { //��ĸλΪnull
				Node newNode = new Node(data);//����һ�����
				Node current = head;//����һ��δ֪��	
				current.parent = newNode;
				newNode.left = current;
				root = newNode;
			}else if(head.parent != null) { root = head.parent; } //�����κ���	��������ê��
		}else { // ���������ĸ���
			    
			      if(head.parent == null)
			      {
					Node newNode = new Node(data);//����һ�����				
					Node current = head;
					while(true) {
						if(current.parent == null) {//��λ
							current.parent = newNode;
							newNode.left = current;
							root = newNode;
							break;
						}
						  current = current.parent;
					}
			     }else if(head.parent != null && head.parent.data == "δ֪��") { //�滻
						head.parent.data = data;
					    root = head.parent;
				 }
		}
	}
	
	public void update(Node head) {
		if(head != null) {
			if(head.data.equals("δ֪��")) { // �Ƿ�Ϊδ֪��
				if(head.parent==null ||(head.parent != null && head == head.parent.left)) { //���۵㣨��һ�����ӣ�
					if(head.right != null) { // ���ֵ� ���濪ʼɾ��δ֪�߽��					
						if(head.parent == null) {
							head.right.parent=null;			
						}
						if(head.parent != null) {
							head.parent.left = head.right;
							head.right.parent = head.parent;
						}	//��������		
						
						if(head.right.left == null) { //ת��
							head.right.left = head.left;
							head.left.parent = head.right;
						}else {
							Node current = head.right.left;
							while(true) {
								if(current.right == null) { //����				
									current.right = head.left;
									if(head.left != null) {
									head.left.parent = current;
									}else {};
									break;
								}
								current = current.right;
							}
						}//�������
				
					}else {}//û�ֵ� �����κ�����						
				}else { // �����ڵ� ���ж���û���ֵ�
					if(head == head.parent.right)//���ֵ�
					{
						head.parent.right = head.right;//ת���ֵ� ���濪ʼת�ƺ���
						if( head.parent.left ==null   ) { //ת��
							head.parent.left = head.left;
							head.left.parent = head.parent;
						}else {
							Node current = head.parent.left;
							while(true) {
								if(current.right == null) { //����
									System.out.println(head.data);
									current.right = head.left;
									head.left.parent = current;
									break;
								}
								current = current.right;
							}	
					   }//ת�����
					}else {}//û���ֵ� �����κ���
				}//���
			}else {	}//����δ֪�� �����κ���
			update(head.left);
			update(head.right);
		}else {
			return ;
		}
	}
	//�����������ڲ����������
	/**
	 * ѧϰ����㷨 ̫���ˣ�
	 */
	public boolean preOrder(Node head,String data) {	
	   if(head == null) return false;
	   if(head.data.equals(data)) return true; 
	   if( preOrder(head.left,data) || preOrder(head.right,data)) return true;  
	   return false;
	}
	//�ҽ��
	public Node find(Node head,String data) {
		if(head ==null) return null;
		if(head.data.equals(data)) return head;
		else if	(head.left != null)	return find(head.left,data);
		else if (head.right != null)	return find(head.right,data);
		return head;			
	}

}
