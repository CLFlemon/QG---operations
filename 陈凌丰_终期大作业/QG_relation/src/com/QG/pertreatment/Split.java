package com.QG.pertreatment;
import javax.swing.JOptionPane;

import com.QG.GUI.*;
import com.QG.handle.*;
import com.QG.model.*;
import com.QG.util.*;
/**
 * 结果：讲句子切割成一份一份语速
 * @author Administrator
 *
 */

public class Split {
	static String str = null;
	static String[] buff = null;
	
	public static void SplitInfo(String sentence) {
		str = sentence;
		buff = str.split("是|的");
		if(buff.length == 3) { // 前两种句式
			if(str.indexOf("是")<str.indexOf("的")) {
				Standard.Standrda(buff);//第一种句式 将它传递到 ‘统一’类上。
			}else {
				Standard.Standrdb(buff);//第二种句式。
			}
		}
		else if(buff.length == 4) {
			Standard.Standrdc(buff);//第三种句式。
		}else {//出错
			JOptionPane.showMessageDialog(null, "错误！","操作结果",JOptionPane.WARNING_MESSAGE);
			System.exit(0);
			
		}
	}
}
