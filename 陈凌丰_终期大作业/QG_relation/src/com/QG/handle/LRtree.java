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
	
	//创立头结点
	public Node creat(Node head ,String data) {	
		Node newNode = new Node(data);
		head = newNode;
		return head;
	}
	
	//插入左儿子 非合并数逻辑业务
	public void insertleft(Node head ,String data) {
	
       if(head.left == null ) { //第一个儿子还没出现
			Node newNode = new Node(data);//建立结点
			Node current = head;			 
			current.left = newNode;
			newNode.parent = current;//三叉链表
			root = newNode;//做锚点返回用	
		}else if(head.left != null && head.left.data == "未知者") { //有第一个儿子但是未知者 此时替换
    	   head.left.data = data;
    	   root = head.left;
        }else if(head.left != null && head.left.data != "未知者") { //第二个儿子 放在第一个儿子的右边
        	 Node newNode = new Node(data);//建立一个结点		
			 Node current = head.left; //已经存在的儿子
			 while(true) {
					if(current.right == null) {//空位且合适
						current.right = newNode;
						newNode.parent = current;//三叉链表
						root = current;
						break;
			       }
				   current = current.right;//往兄弟方向走
			}
        }
	}
	

	
	public void insertleft(Node head1 ,Node head2) { //head2合并到head1;
		//比较两棵树的祖先辈分
		int flag1 = 2;
		int flag2 = 1;//因为head1是head2的爸爸 所以辈分天然大一辈
		Node newNode1 = head1;
		while(true) {
			//判断parent是兄弟还是父母
			if(newNode1.parent != null) {
				
				if(newNode1 == newNode1.parent.left) { //父母
					flag1++;//辈分++
					newNode1 = newNode1.parent;
				}else if(newNode1 == newNode1.parent.right) { //兄弟
					newNode1 = newNode1.parent;
				}
			}else break;		
		}
		Node newNode2 = head2;
		while(true) {
			//判断parent是兄弟还是父母
			if(newNode2.parent != null) {
				
				if(newNode2 == newNode2.parent.left) { //父母
					flag2++;//辈分++
					newNode2 = newNode2.parent;
				}else if(newNode2 == newNode2.parent.right) { //兄弟
					newNode2 = newNode2.parent;
				}
			}else break;		
		}
		/**
		 * 以上两个循环令newNode1和newNode2代表两棵树的祖先
		 */
		//判断组建辈分
		if(flag1>=flag2) { //head1树是辈分大
			int count = flag1-flag2;
			while(count!= 0) {
				if(newNode1.left == null) {
					insertleft(newNode1,"未知者");
					newNode1 = newNode1.left;
				}else newNode1 = newNode1.left;
				count--;
			}
			//兄弟合并
			while(true)
			{
				if(newNode1.right == null) {
					newNode1.right = newNode2;
					newNode2.parent = newNode1;
					break;
				}
				newNode1 = newNode1.right;
			}
		}else { // head2的辈分大
			int count = flag2-flag1;
			while(count!=0) {
				newNode2 = newNode2.left;
				count--;
			}
			//兄弟合并
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
	
	//插入右儿子
	public void insertright(Node head,String data) {
		Node newNode = new Node(data);//建立一个结点
		//树是空的
		Node current = head;
		while(true) {
			if(current.right == null) {//空位
				current.right = newNode;
				newNode.parent = newNode;
				root  = newNode;
				break;
			}
			    current = current.right;
		}
	}
	
	public void insertparent(Node head,String data) {
		if(data == "未知者") {//此时想插一个未知者 下面开始逻辑判断 
			if(head.parent == null) { //父母位为null
				Node newNode = new Node(data);//建立一个结点
				Node current = head;//插入一个未知者	
				current.parent = newNode;
				newNode.left = current;
				root = newNode;
			}else if(head.parent != null) { root = head.parent; } //不做任何事	仅仅返回锚点
		}else { // 插入正常的父亲
			    
			      if(head.parent == null)
			      {
					Node newNode = new Node(data);//建立一个结点				
					Node current = head;
					while(true) {
						if(current.parent == null) {//空位
							current.parent = newNode;
							newNode.left = current;
							root = newNode;
							break;
						}
						  current = current.parent;
					}
			     }else if(head.parent != null && head.parent.data == "未知者") { //替换
						head.parent.data = data;
					    root = head.parent;
				 }
		}
	}
	
	public void update(Node head) {
		if(head != null) {
			if(head.data.equals("未知者")) { // 是否为未知者
				if(head.parent==null ||(head.parent != null && head == head.parent.left)) { //主折点（第一个儿子）
					if(head.right != null) { // 有兄弟 下面开始删除未知者结点					
						if(head.parent == null) {
							head.right.parent=null;			
						}
						if(head.parent != null) {
							head.parent.left = head.right;
							head.right.parent = head.parent;
						}	//下面插儿子		
						
						if(head.right.left == null) { //转移
							head.right.left = head.left;
							head.left.parent = head.right;
						}else {
							Node current = head.right.left;
							while(true) {
								if(current.right == null) { //插入				
									current.right = head.left;
									if(head.left != null) {
									head.left.parent = current;
									}else {};
									break;
								}
								current = current.right;
							}
						}//过继完成
				
					}else {}//没兄弟 不做任何事情						
				}else { // 非主节点 先判断有没有兄弟
					if(head == head.parent.right)//有兄弟
					{
						head.parent.right = head.right;//转移兄弟 下面开始转移孩子
						if( head.parent.left ==null   ) { //转移
							head.parent.left = head.left;
							head.left.parent = head.parent;
						}else {
							Node current = head.parent.left;
							while(true) {
								if(current.right == null) { //插入
									System.out.println(head.data);
									current.right = head.left;
									head.left.parent = current;
									break;
								}
								current = current.right;
							}	
					   }//转移完成
					}else {}//没有兄弟 不做任何事
				}//解决
			}else {	}//不是未知者 不做任何事
			update(head.left);
			update(head.right);
		}else {
			return ;
		}
	}
	//先序遍历检查在不在这颗数上
	/**
	 * 学习这个算法 太妙了！
	 */
	public boolean preOrder(Node head,String data) {	
	   if(head == null) return false;
	   if(head.data.equals(data)) return true; 
	   if( preOrder(head.left,data) || preOrder(head.right,data)) return true;  
	   return false;
	}
	//找结点
	public Node find(Node head,String data) {
		if(head ==null) return null;
		if(head.data.equals(data)) return head;
		else if	(head.left != null)	return find(head.left,data);
		else if (head.right != null)	return find(head.right,data);
		return head;			
	}

}
