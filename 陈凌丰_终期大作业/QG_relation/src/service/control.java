package service;

import javax.swing.JOptionPane;

import com.QG.*;
import com.QG.util.GetInfo;
import com.QG.handle.*;
import com.QG.handle.LRtree.Node;
public class control {
	
	static LRtree.Node root[] = new LRtree.Node[50];//初始化root数组 拿来存head结点的 
	public static Node[] getroot() {	
     	return root;
	}
	/**
	 * 判断ab句型
	 * @param buff
	 */
	public static void receive(String buff[]) { // 接受切割回来的String数组
		check(root,buff);//传过去测试
	}
	/**
	 * 判断c句型
	 * @param buff1
	 * @param buff2
	 */
	public static void receive(String buff1[],String buff2[]) {
		check(root,buff1,buff2);	
	}
	/**
	 * 功能：对第一和第二句型对三种业务作出判断
	 * 1：两个人其中有一个人存在树上 && 另一个人为新结点 此时此一个人为锚点添加
	 * 2：两个人都是新结点 此时创立新树
	 * 3：两个人都是旧结点 && 不在同一棵树上。此时将两棵树合并
	 * @param root
	 * @param buff
	 */
	public static void check(LRtree.Node root[],String buff[]) {
		LRtree tree = new LRtree();//初始化
		LRtree.Node head1 = null;//代表第一个人物接受每一个root[i]
		LRtree.Node head2 = null;//代表第二个人接受每一个root[i];
		int flag1 = 0;
		int flag2 = 0;//标记
		int i;
		int j;
		for(i = 0; i<root.length && root[i] != null;i++) {
			head1 = root[i];
			 if(buff[0] != "未知者" && tree.preOrder(head1, buff[0]) ) { //一号人物为锚点
				  flag1 = 1;
				  break;
			  }	
		}
		for(j = 0; j<root.length && root[j] != null;j++) {
			head2 = root[j];
			 if(buff[1] != "未知者" && tree.preOrder(head2, buff[1]) ) { //二号人物为锚点
				  flag2 = 1;
				  break;
			  }	
		}//遍历完成 下面开始逻辑判断
		System.out.println("flag1"+flag1 + "\n"+"flag2"+flag2);
		
		if(flag1 == 1 && flag2 == 0) {  //一号锚点
			old(head1,buff);
		}else if(flag1 == 0 && flag2 == 1) { //二号锚点 先做处理
		       //先换位置
			String temp = "";
			temp = buff[0];
			buff[0] = buff[1];
			buff[1] = temp;//换位置完成 下面开始换关系
			System.out.println("未变换前"+buff[2]);
			if(buff[2].equals("爸爸")) buff[2] = "儿子";
			else if(buff[2].equals("儿子")) buff[2] = "爸爸";
			else if(buff[2].equals("爷爷")) buff[2] = "孙子";
			else if(buff[2].equals("孙子")) buff[2] = "爷爷";
			else if(buff[2].equals("哥哥")) buff[2] = "弟弟";
			else if(buff[2].equals("弟弟")) buff[2] = "哥哥"; //关系互换	
			System.out.println("变换后"+buff[2]);
			old(head2,buff);
		}else if(flag1 == 0 && flag2 == 0) { //创立新树
					notold(i,head1,buff,root);
		}else if(flag1 == 1 && flag2 == 1) { // 合并树 
			 if(i == j) {
				JOptionPane.showMessageDialog(null, "错误！","操作结果",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			 }else {
				combine(i,j,head1,head2,buff,0);
			}
		}	
	}
	
	/**
	 * 该函数主要是对第三句句型作出判断
	 1：两个人其中有一个人存在树上 && 另一个人为新结点 此时此一个人为锚点添加
	 * 2：两个人都是新结点 此时创立新树
	 * 3：两个人都是旧结点 && 不在同一棵树上。此时将两棵树合并
	 * @param root
	 * @param buff1
	 * @param buff2
	 */
	
	public static void check(LRtree.Node root[],String buff1[],String buff2[]) {
		LRtree tree = new LRtree();//初始化
		LRtree.Node head = null;//接受每一个root[i]
		int flag1 = 0;
		int flag2 = 0;//两个标志位看一下两个人物 哪一个存在
		int i ;
		int j;
		for(i = 0; i<root.length && root[i] != null;i++) {
			  head = root[i];	
			  if(buff1[1] != "未知者" && tree.preOrder(head, buff1[1]) ) {
				  flag1 = 1;
				  break;
			  }	
		}
		for(j = 0; j<root.length && root[j] != null;j++) {
			  head = root[j];	
			  if(buff2[1] != "未知者" && tree.preOrder(head, buff2[1]) ) {
				  flag2 = 1;
				  break;
			  }	
		}		
		if(flag1 == 1 && flag2 == 0) { //第一个人物以前存在 做锚点
			//第一步先把锚点位置互换
			String temp = "";
			temp = buff1[0];
			buff1[0] = buff1[1];
			buff1[1] = temp;
			//第二部把位置换好
			if(buff1[2].equals("爸爸")) buff1[2] = "儿子";
			else if(buff1[2].equals("儿子")) buff1[2] = "爸爸";
			else if(buff1[2].equals("爷爷")) buff1[2] = "孙子";
			else if(buff1[2].equals("孙子")) buff1[2] = "爷爷";
			else if(buff1[2].equals("哥哥")) buff1[2] = "弟弟";
			else if(buff1[2].equals("弟弟")) buff1[2] = "哥哥";
			//第三步开始把传数据  先处理buff1 后处理处理buff2;
			old(head,buff1,buff2);
			
		}else if(flag1 == 0 && flag2 ==1) { // 第二个人以前存在
			
		//	System.out.println(flag2);
			//第一步先把锚点位置互换
			String temp = "";
			temp = buff2[0];
			buff2[0] = buff2[1];
			buff2[1] = temp;
			//第二步把位置换好
			if(buff2[2].equals("爸爸")) buff2[2] = "儿子";
			else if(buff2[2].equals("儿子")) buff2[2] = "爸爸";
			else if(buff2[2].equals("爷爷")) buff2[2] = "孙子";
			else if(buff2[2].equals("孙子")) buff2[2] = "爷爷";
			else if(buff2[2].equals("哥哥")) buff2[2] = "弟弟";
			else if(buff2[2].equals("弟弟")) buff2[2] = "哥哥";
			old(head,buff2,buff1);		
		}else if(flag1 == 0 && flag2 == 0 ) { //两个人都不存在 创立新树
			head = null;
			notold(head,buff1,buff2,root);	
		}else if(flag1 == 1 && flag2 ==1 ) { //合并数
			if(i == j) {
				JOptionPane.showMessageDialog(null, "错误！","操作结果",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}else {
				String temp = "";
				temp = buff1[0];
				buff1[0] = buff1[1];
				buff1[1] = temp;
				//第二部把位置换好
				if(buff1[2].equals("爸爸")) buff1[2] = "儿子";
				else if(buff1[2].equals("儿子")) buff1[2] = "爸爸";
				else if(buff1[2].equals("爷爷")) buff1[2] = "孙子";
				else if(buff1[2].equals("孙子")) buff1[2] = "爷爷";
				else if(buff1[2].equals("哥哥")) buff1[2] = "弟弟";
				else if(buff1[2].equals("弟弟")) buff1[2] = "哥哥";
				combine(i,j,root[i],root[j],buff1,buff2);
		   }
		}
	}
	
	
	public static void old(LRtree.Node head,String buff[]) {
		System.out.println("第二句");
		System.out.println(buff[2]);
		LRtree tree = new LRtree();
		head = tree.find(head, buff[0]);
		if(buff[2].equals("爸爸")) {
			tree.insertleft(head,buff[1]);
		}else if(buff[2].equals("兄弟") || buff[2].equals("哥哥")|| buff[2].equals("弟弟")) {
			tree.insertright(head,buff[1]);
		}else if(buff[2].equals("爷爷")) {
			if(head.left == null) {
				tree.insertleft(head, "未知者");
			}
			tree.insertleft(head.left, buff[1]);			
		}else if(buff[2].equals("儿子")) {
			if(head.parent == null) {
				tree.insertparent(head, buff[1]);
			}else if(head.parent.data.equals("未知者")) {
				tree.insertparent(head, buff[1]);
			}else {
				JOptionPane.showMessageDialog(null, "错误！","操作结果",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
		//	tree.insertparent(head, buff[1]);
		}else if(buff[2].equals("孙子")) {
			if(head.parent == null) {
				tree.insertparent(head, "未知者");
			}
			if(head.parent.parent == null) {
				tree.insertparent(head.parent, buff[1]);
			}else if(head.parent.parent.data.equals("未知者")) {
				tree.insertparent(head.parent, buff[1]);
			}else {
				JOptionPane.showMessageDialog(null, "错误！","操作结果",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
		}
		while(head.parent != null) {
			head = head.parent;
		}
	}
	
	public static void old(LRtree.Node head,String buff1[],String buff2[]) { //buff[1]是锚点
		LRtree tree = new LRtree();
		head = tree.find(head, buff1[0]);
		if(buff1[2].equals("爸爸")) { // 调试成功
			tree.insertleft(head,buff1[1]);
			head  = tree.getRoot();//转移锚点
		}else if(buff1[2].equals("兄弟") || buff1[2].equals("哥哥")|| buff1[2].equals("弟弟")) {
			tree.insertright(head,buff1[1]);//
			head  = tree.getRoot();
		}else if(buff1[2].equals("爷爷")) {
			if(head.left == null) {
				tree.insertleft(head, "未知者");
			}
			tree.insertleft(head.left, buff1[1]);
			head = tree.getRoot();		
		}else if(buff1[2].equals("儿子")) {	
			tree.insertparent(head, buff1[1]);
			head = tree.getRoot();
		}else if(buff1[2].equals("孙子")) {
			if(head.parent == null) {
				tree.insertparent(head, "未知者");
			}
			tree.insertparent(head.parent, buff1[1]);
			head = tree.getRoot();
		}//解决完第一句 下面开始解决第二句		
		if(buff2[2].equals("爸爸")) {
			tree.insertleft(head,buff2[1]);
		}else if(buff2[2].equals("兄弟") || buff2[2].equals("哥哥")|| buff2[2].equals("弟弟")) {
			tree.insertright(head,buff2[1]);
		}else if(buff2[2].equals("爷爷")) {
			if(head.left == null) {
				tree.insertleft(head, "未知者");
			}
			tree.insertleft(head.left, buff2[1]);	
		}else if(buff2[2].equals("儿子")) {
			tree.insertparent(head, buff2[1]);
		}else if(buff2[2].equals("孙子")) {
			if(head.parent == null) {
				tree.insertparent(head, "未知者");
			}
			tree.insertparent(head.parent, buff2[1]);
		}// 处理完第二句		
		while(head.parent != null) {
			head = head.parent;
		}//处理一下找到最近的祖先		
	}
	
	public static void notold(int i,LRtree.Node head,String buff[],LRtree.Node root[]) {
		LRtree tree = new LRtree();
		head = tree.creat(head,buff[0]);//创立结点
		if(buff[2].equals("爸爸")) {
	 	tree.insertleft(head,buff[1]); 
	 	
	    }else if(buff[2].equals("兄弟") || buff[2].equals("哥哥") || buff[2].equals("弟弟")) {
		 	tree.insertright(head,buff[1]);
		 	
	    }else if(buff[2].equals("爷爷")) {
	    	if(head.left == null ) {
	    		tree.insertleft(head,"未知者");
	    	}	
	    	tree.insertleft(head.left,buff[1]);	
	    	
        }else if(buff[2].equals("儿子")) {
        	tree.insertparent(head, buff[1]);
        }else if(buff[2].equals("孙子")) {
        	if(head.parent == null) {
        		tree.insertparent(head, "未知者");
        	}
        	tree.insertparent(head.parent, buff[1]);
        }
		//返回头结点 保持头结点不变。
		while(head.parent != null) {
			head = head.parent;
		}
		root[i++] = head;//存储结点
	//	System.out.println("2"+head.data);
	}
	
	public static void notold(LRtree.Node head,String buff1[],String buff2[],LRtree.Node root[]) {
		
		LRtree tree = new LRtree();//初始化对象
		head = tree.creat(head,buff1[0]);//头结点 下面开始分关系讨论问题
		if(buff1[2].equals("爸爸")) {
			tree.insertleft(head,buff1[1]);//插入 
		}else if(buff1[2].equals("兄弟") || buff1[2].equals("哥哥") || buff1[2].equals("弟弟")) {
		 	tree.insertright(head,buff1[1]);	 	
	    }else if(buff1[2].equals("爷爷")) {
	    	if(head.left == null) {
	    		tree.insertleft(head,"未知者");  
	    	}
	    	tree.insertleft(head.left,buff1[1]);	  	
        }else if(buff1[2].equals("儿子")) {
            tree.insertparent(head, buff1[1]);
        }else if(buff1[2].equals("孙子")) {
        	if(head.left == null) {
        		tree.insertparent(head, "未知者");
        	}
        	tree.insertparent(head.parent, buff1[1]);
        }//这样第一句已经搞掂下面开始处理第二句
		

		if(buff2[2].equals("爸爸")) {
			tree.insertleft(head,buff2[1]);//插入 
		}else if(buff2[2].equals("兄弟") || buff2[2].equals("哥哥") || buff2[2].equals("弟弟")) {
		 	tree.insertright(head,buff2[1]);	 	
	    }else if(buff2[2].equals("爷爷")) {
	    	if(head.left == null) {
	    		tree.insertleft(head,"未知者"); 
	    	}
	    	tree.insertleft(head.left,buff2[1]);	  	
        }else if(buff2[2].equals("儿子")) {
            tree.insertparent(head, buff2[1]);
        }else if(buff2[2].equals("孙子")) {
        	if(head.parent == null) {
        	tree.insertparent(head, "未知者");
        	}
        	tree.insertparent(head.parent, buff2[1]);
        }
		
		while(head.parent != null) {
			head = head.parent;
		}//处理一下头结点
		
		int i;
		for( i = 0;i<root.length && root[i] != null ; i++) {}
		root[i] = head;//存结点
	}
	
	private static void combine(int i, int j, Node head1, Node head2, String[] buff,int flag) {
		
		int max = i>j ? i:j ;
		int min = i>j ? j:i ; //改变数组用
		LRtree tree = new LRtree();//初始化对象
		if(flag == 0) {
			head1 = tree.find(head1,buff[0]);//找到两个专属的结点
		    head2 = tree.find(head2,buff[1]);//找到两个专属的结点
		}else if(flag == 1) {
			head2 = tree.find(head2, buff[1]);
		}
		//判断关系
		
		
		
		if(buff[2].equals("爸爸")) {
			tree.insertleft(head1, head2);
		}else if(buff[2].equals("爷爷")) { // 先判断儿子是否存在 不存在就插入一个未知者
			if(head1.left == null) {
				tree.insertleft(head1, "未知者");
			}
			tree.insertleft(head1.left, head2); // 相当于转换成第一步
		
		}else if(buff[2].equals("兄弟") || buff[2].equals("哥哥") || buff[2].equals("弟弟")) {
			if(head1.parent == null) {
				tree.insertparent(head1, "未知者");
			}
			tree.insertleft(head1.parent,head2);		
			
		}else if(buff[2].equals("儿子")) { //head1是head2的儿子等价于head2是head1的爸爸
			tree.insertleft(head2, head1);
	
		}else if(buff[2].equals("孙子")) { //head1是head2的孙子等价于head2是head1的爷爷
			if(head2.left == null) {
				tree.insertleft(head2, "未知者");
			}
			tree.insertleft(head2.left, head1);	
		}
		
		
		//下面开始更新  先判断是更新哪一个结点
		if(buff[2].equals("儿子") || buff[2].equals("孙子")) { //更新head2
			while(head2.parent != null) {
				head2 = head2.parent;
			}//处理一下头结点
			tree.update(head2);
			if(head2.data.equals("未知者") && head2.right != null) {
				head2 = head2.right;
			}
			//下面开始改变结点数组 改变i 
			root[min] = head2;
			int m ;
			for( m = max ; m<root.length-1 && root[m] != null ;m++) {
				root[m] = root[m+1];
			}
			root[m] = null;
			
		}else { //更新head1
			while(head1.parent != null) {
				head1 = head1.parent;
			}//处理一下头结点
				tree.update(head1);
			if(head1.data.equals("未知者") && head1.right != null) {
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
		if(buff1[2].equals("爸爸")) { // 调试成功
			tree.insertleft(head1,buff1[1]);
			head1  = tree.getRoot();//转移锚点
		}else if(buff1[2].equals("兄弟") || buff1[2].equals("哥哥")|| buff1[2].equals("弟弟")) {
			tree.insertright(head1,buff1[1]);//
			head1  = tree.getRoot();
		}else if(buff1[2].equals("爷爷")) {
			if(head1.left == null) {
				tree.insertleft(head1, "未知者");
			}
			tree.insertleft(head1.left, buff1[1]);
			head1 = tree.getRoot();		
		}else if(buff1[2].equals("儿子")) {
			tree.insertparent(head1, buff1[1]);
			head1 = tree.getRoot();
		}else if(buff1[2].equals("孙子")) {
			if(head1.parent == null) {
				tree.insertparent(head1, "未知者");
			}
			tree.insertparent(head1.parent, buff1[1]);
			head1 = tree.getRoot();
		}//解决完第一句
		// 下面开始合并树
	//	System.out.println(head1.data);
		
		combine(i,j,head1,head2,buff2,1);//转化成第一种
	}
	
}
