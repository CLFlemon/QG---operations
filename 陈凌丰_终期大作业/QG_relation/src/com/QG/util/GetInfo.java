package com.QG.util;

import com.QG.model.*;
import java.io.*;

import javax.swing.JOptionPane;

public class GetInfo {
	public static void startUp () throws IOException{
		String pathname = "D:\\测试.txt";
		File filename = new File(pathname);
		InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(reader); // 以上是读去一个文件的基本操作。
		String line = "";
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(line != null) {
			AcceptanceInfo.SetString(line); //讲句子传过去model包进行封装
			try {
				line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		br.close();//
		System.out.println("关闭成功！");
		JOptionPane.showMessageDialog(null, "启动成功","操作结果",JOptionPane.WARNING_MESSAGE);
	}

}
