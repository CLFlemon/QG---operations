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
		LRtree tree = new LRtree();//初始化
		LRtree.Node head1 = null;//代表第一个人物接受每一个root[i]
		LRtree.Node head2 = null;//代表第二个人接受每一个root[i];
		int flag1 = 0;
		int flag2 = 0;//标记
		int i;
		int j;
		for(i = 0; i<NFroot.length && NFroot[i] != null;i++) {
			head1 = NFroot[i];
			 if(buff[0] != "未知者" && tree.preOrder(head1, buff[0]) ) { //一号人物为锚点
				  flag1 = 1;
				  break;
			  }	
		}
		for(j = 0; j<NFroot.length && NFroot[j] != null;j++) {
			head2 = NFroot[j];
			 if(buff[1] != "未知者" && tree.preOrder(head2, buff[1]) ) { //二号人物为锚点
				  flag2 = 1;
				  break;
			  }	
		}//遍历完成 下面开始逻辑判断
		if(flag1 == 1 && flag2 == 0) {  //一号锚点
			old(head1,buff);
		}else if(flag1 == 0 && flag2 == 1) { //二号锚点 先做处理
	       //先换位置
			String temp = "";
			temp = buff[0];
			buff[0] = buff[1];
			buff[1] = temp;//换位置完成 下面开始换关系
			if(buff[2] == "老师") buff[2] = "学生";
			else if(buff[2] == "学生") buff[2] = "老师";//师生关系互换	  	
			old(head2,buff);
		}else if(flag1 == 0 && flag2 == 0) { //创立新树
			notold(i,head1,buff,NFroot);
		}else if(flag1 == 1 && flag2 == 1) { // 合并树 
			combine(i,j,head1,head2,buff,0);
		}
	}
	
	private static void check(Node[] nFroot2, String[] buff1, String[] buff2) {
		LRtree tree = new LRtree();//初始化
		LRtree.Node head = null;//接受每一个root[i]
		int flag1 = 0;
		int flag2 = 0;//两个标志位看一下两个人物 哪一个存在
		int i ;
		int j;
		for(i = 0; i<NFroot.length && NFroot[i] != null;i++) {
			  head = NFroot[i];	
			  if(buff1[1] != "未知者" && tree.preOrder(head, buff1[1]) ) {
				  flag1 = 1;
				  break;
			  }	
		}
		for(j = 0; j<NFroot.length && NFroot[j] != null;j++) {
			  head = NFroot[j];	
			  if(buff2[1] != "未知者" && tree.preOrder(head, buff2[1]) ) {
				  flag2 = 1;
				  break;
			  }	
		}	//遍历完成 下面开始逻辑判断
		if(flag1 == 1 && flag2 == 0) { //第一个人物以前存在 做锚点
			//第一步先把锚点位置互换
			String temp = "";
			temp = buff1[0];
			buff1[0] = buff1[1];
			buff1[1] = temp;
			//第二部把位置换好
			if(buff1[2].equals("老师")) buff1[2] = "学生";
			else if(buff1[2].equals("学生")) buff1[2] = "老师";
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
			if(buff2[2].equals("老师")) buff2[2] = "学生";
			else if(buff2[2].equals("学生")) buff2[2] = "老师";
			old(head,buff2,buff1);		
		}else if(flag1 == 0 && flag2 == 0 ) { //两个人都不存在 创立新树
			head = null;
			notold(head,buff1,buff2,NFroot);
		}else if(flag1 == 1 && flag2 ==1 ) { //合并数
			String temp = "";
			temp = buff1[0];
			buff1[0] = buff1[1];
			buff1[1] = temp;
			//第二部把位置换好
			if(buff1[2].equals("老师")) buff1[2] = "学生";
			else if(buff1[2].equals("学生")) buff1[2] = "老师";	
			combine(i,j,NFroot[i],NFroot[j],buff1,buff2);
		}
		
	}


	private static void notold(Node head, String[] buff1, String[] buff2, Node[] nFroot2) {
		LRtree tree = new LRtree();//初始化对象
		head = tree.creat(head,buff1[0]);//头结点 下面开始分关系讨论问题
		if(buff1[2].equals("老师")) {
			tree.insertleft(head,buff1[1]);//插入 
		}else if(buff1[2].equals("同学") ) {
		 	tree.insertright(head,buff1[1]);	 	
	    }else if(buff1[2].equals("学生")) {
            tree.insertparent(head, buff1[1]);
        }//这样第一句已经搞掂下面开始处理第二句
		

		if(buff2[2].equals("老师")) {
			tree.insertleft(head,buff2[1]);//插入 
		}else if(buff2[2].equals("同学")) {
		 	tree.insertright(head,buff2[1]);	 	
	    }else if(buff2[2].equals("学生")) {
            tree.insertparent(head, buff2[1]);
        }
		
		while(head.parent != null) {
			head = head.parent;
		}//处理一下头结点
		

		int i;
		for( i = 0;i<NFroot.length && NFroot[i] != null ; i++) {}
		NFroot[i] = head;//存结点
		
	}

	private static void notold(int i, Node head, String[] buff, Node[] nFroot2) {
		// TODO Auto-generated method stub
		LRtree tree = new LRtree();
		head = tree.creat(head,buff[0]);//创立结点
		if(buff[2].equals("老师")) {
	 	tree.insertleft(head,buff[1]); 
	 	
	    }else if(buff[2].equals("同学")) {
		 	tree.insertright(head,buff[1]);
		 	
	    }else if(buff[2].equals("学生")) {
        	tree.insertparent(head, buff[1]);
        }
		
		while(head.parent != null) {
			head = head.parent;
		}
		
		NFroot[i++] = head;//存储结点
	}

	private static void old(Node head, String[] buff) {
		// TODO Auto-generated method stub
		LRtree tree = new LRtree();
		head = tree.find(head, buff[0]);
		if(buff[2].equals("学生")) {
			tree.insertleft(head,buff[1]);
		}else if(buff[2].equals("同学")) {
			tree.insertright(head,buff[1]);
		}else if(buff[2].equals("老师")) {
			tree.insertparent(head, buff[1]);
		}
		while(head.parent != null) {
			head = head.parent;
		}
		
	}	
	
	private static void old(Node head, String[] buff1, String[] buff2) {
		LRtree tree = new LRtree();
		head = tree.find(head, buff1[0]);
		if(buff1[2].equals("老师")) { // 调试成功
			tree.insertleft(head,buff1[1]);
			head  = tree.getRoot();//转移锚点
		}else if(buff1[2].equals("同学")) {
			tree.insertright(head,buff1[1]);//
			head  = tree.getRoot();
		}else if(buff1[2].equals("学生")) {
			tree.insertparent(head, buff1[1]);
			head = tree.getRoot();
		}//解决完第一句 下面开始解决第二句	
		
		if(buff2[2].equals("老师")) {
			tree.insertleft(head,buff2[1]);
		}else if(buff2[2].equals("同学")) {
			tree.insertright(head,buff2[1]);
		}else if(buff2[2].equals("学生")) {
			tree.insertparent(head, buff2[1]);
		}// 处理完第二句		
		while(head.parent != null) {
			head = head.parent;
		}//处理一下找到最近的祖先	
		
	}
	
	private static void combine(int i, int j, Node head1, Node head2, String[] buff, int flag) {
		// TODO Auto-generated method stub
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
		
		
		
		if(buff[2].equals("老师")) {
			tree.insertleft(head1, head2);
		}else if(buff[2].equals("同学")) {
			if(head1.parent == null) {
				tree.insertparent(head1, "未知者");
			}
			tree.insertleft(head1.parent,head2);		
			
		}else if(buff[2].equals("学生")) { //head1是head2的学生等价于head2是head1的老师
			tree.insertleft(head2, head1);
		}
		
		
		//下面开始更新  先判断是更新哪一个结点
		if(buff[2].equals("学生") ) { //更新head2
			while(head2.parent != null) {
				head2 = head2.parent;
			}//处理一下头结点
			tree.update(head2);
			if(head2.data.equals("未知者") && head2.right != null) {
				head2 = head2.right;
			}
			//下面开始改变结点数组 改变i 
			NFroot[min] = head2;
			int m ;
			for( m = max ; m<NFroot.length-1 && NFroot[m] != null ;m++) {
				NFroot[m] = NFroot[m+1];
			}
			NFroot[m] = null;
			
		}else { //更新head1
			while(head1.parent != null) {
				head1 = head1.parent;
			}//处理一下头结点
				tree.update(head1);
			if(head1.data.equals("未知者") && head1.right != null) {
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
		if(buff1[2].equals("老师")) { // 调试成功
			tree.insertleft(head1,buff1[1]);
			head1  = tree.getRoot();//转移锚点
		}else if(buff1[2].equals("同学") ) {
			tree.insertright(head1,buff1[1]);//
			head1  = tree.getRoot();
		}else if(buff1[2].equals("学生")) {
			tree.insertparent(head1, buff1[1]);
			head1 = tree.getRoot();
		}//解决完第一句
		// 下面开始合并树
		combine(i,j,head1,head2,buff2,1);//转化成第一种
		
	}
	
	
	
	
}
