package com.Chenlingfeng.service;

import com.Chenlingfeng.view.UIedit;
import com.Chenlingfeng.view.UIlogin;
import com.Chenlingfeng.view.UiAuthority;
import com.Chenlingfeng.view.Uiadd;
import com.Chenlingfeng.view.Uidelete;
import com.Chenlingfeng.view.Uifourchoose;
import com.Chenlingfeng.view.Uiquery;

public class ControlUi {
	
	public static void nextTo(String s) {
		if(s.equals("ToUiAuthority")) {
			UiAuthority next = new UiAuthority();
		}else if(s.equals("administrator_ToUiLogin")) {
			Permission.setFlag(0);
			UIlogin next = new UIlogin();
		}else if(s.equals("user_ToUiLogin")) {
			Permission.setFlag(1);
			UIlogin next = new UIlogin();	
		}else if(s.equals("ToUiFourChoose")) {
			Uifourchoose next = new Uifourchoose();
		}else if(s.equals("ToDelete")) {
			Uidelete next = new Uidelete();
		}else if(s.equals("ToAdd")) {
			Uiadd next = new Uiadd();
		}else if(s.equals("ToQuery")) {
			Uiquery next = new Uiquery();
		}else if(s.equals("ToEdit")) {
			UIedit next = new UIedit();
		}
	}
}
