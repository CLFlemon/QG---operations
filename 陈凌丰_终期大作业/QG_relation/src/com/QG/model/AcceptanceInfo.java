package com.QG.model;

import com.QG.pertreatment.Split;
import com.QG.util.*;
/**
 * ��һ�����ӷ�װ��һ����
 * @author Administrator
 * Ȼ����÷����и�
 */
public class AcceptanceInfo {
	private static String sentence;
	public static void SetString(String Sentence) { 
		sentence = Sentence;
		Split.SplitInfo(GetString());//�����Ӵ��ݵ��и��
	}
	public static String GetString() {
		return sentence;
	}
}
