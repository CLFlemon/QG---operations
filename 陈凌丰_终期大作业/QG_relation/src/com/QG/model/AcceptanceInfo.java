package com.QG.model;

import com.QG.pertreatment.Split;
import com.QG.util.*;
/**
 * 将一个句子封装成一个类
 * @author Administrator
 * 然后调用方法切割
 */
public class AcceptanceInfo {
	private static String sentence;
	public static void SetString(String Sentence) { 
		sentence = Sentence;
		Split.SplitInfo(GetString());//将句子传递到切割函数
	}
	public static String GetString() {
		return sentence;
	}
}
