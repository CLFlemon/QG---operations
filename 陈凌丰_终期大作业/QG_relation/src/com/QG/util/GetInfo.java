package com.QG.util;

import com.QG.model.*;
import java.io.*;

import javax.swing.JOptionPane;

public class GetInfo {
	public static void startUp () throws IOException{
		String pathname = "D:\\����.txt";
		File filename = new File(pathname);
		InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(reader); // �����Ƕ�ȥһ���ļ��Ļ���������
		String line = "";
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(line != null) {
			AcceptanceInfo.SetString(line); //�����Ӵ���ȥmodel�����з�װ
			try {
				line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		br.close();//
		System.out.println("�رճɹ���");
		JOptionPane.showMessageDialog(null, "�����ɹ�","�������",JOptionPane.WARNING_MESSAGE);
	}

}
