package com.Chenlingfeng.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import com.Chenlingfeng.dao.*;
import com.Chenlingfeng.model.*;
import com.Chenlingfeng.util.*;
import com.Chenlingfeng.view.*;

/**
 * 整个系统入口。
 * @author Administrator
 *
 */
public class login {
	public static void main(String[] args) {
		ControlUi.nextTo("ToUiAuthority"); // 选权限
	}
}
