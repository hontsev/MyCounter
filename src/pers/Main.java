package pers;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.math.*;

import javax.swing.JCheckBoxMenuItem;

import java.awt.Color;

import javax.swing.UIManager;

public class Main {
	private String tempnumstr;
	private BigDecimal countnum1;
	private BigDecimal countnum2;
	private BigDecimal resultnum;
	private BigDecimal memnum;
	private boolean memstate;
	private boolean pointstate;
	private boolean paintanswer;
	private int countstate;
	private boolean szfz;
	
	private JFrame frmMycounter;
	private JTextField answerText;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField memoryState;
	private JButton num2;
	private JButton MC;
	private JButton num7;
	private JButton num4;
	private JButton num9;
	private JButton num1;
	private JButton num5;
	private JButton num3;
	private JButton num8;
	private JButton MS;
	private JButton multi;
	private JButton division;
	private JButton minus;
	private JButton num6;
	private JButton Madd;
	private JButton num0;
	private JButton point;
	private JButton MR;
	private JButton equal;
	private JButton add;
	private JMenuBar menuBar;
	private JMenu mne;
	private JMenuItem mntmccrtlc;
	private JMenuItem mntmvCtrlv;
	private JMenu mnv;
	private JMenuItem mntmt;
	private JMenu mnh;
	private JMenuItem mntma;
	private JCheckBoxMenuItem checkBoxMenuItem;
	private JDialog dialog;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnx;
	private JButton btnNewButton_5;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmMycounter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Main() {
		initialize();
	}
	private void display(char str)
	{
		switch(str)
		{
		case '0':if(tempnumstr.equals("0")||paintanswer);else tempnumstr+="0";paintanswer = false;break;
		case '1':if(tempnumstr.equals("0")||paintanswer)tempnumstr = "1";else tempnumstr+="1";paintanswer = false;break;
		case '2':if(tempnumstr.equals("0")||paintanswer)tempnumstr = "2";else tempnumstr+="2";paintanswer = false;break;
		case '3':if(tempnumstr.equals("0")||paintanswer)tempnumstr = "3";else tempnumstr+="3";paintanswer = false;break;
		case '4':if(tempnumstr.equals("0")||paintanswer)tempnumstr = "4";else tempnumstr+="4";paintanswer = false;break;
		case '5':if(tempnumstr.equals("0")||paintanswer)tempnumstr = "5";else tempnumstr+="5";paintanswer = false;break;
		case '6':if(tempnumstr.equals("0")||paintanswer)tempnumstr = "6";else tempnumstr+="6";paintanswer = false;break;
		case '7':if(tempnumstr.equals("0")||paintanswer)tempnumstr = "7";else tempnumstr+="7";paintanswer = false;break;
		case '8':if(tempnumstr.equals("0")||paintanswer)tempnumstr = "8";else tempnumstr+="8";paintanswer = false;break;
		case '9':if(tempnumstr.equals("0")||paintanswer)tempnumstr = "9";else tempnumstr+="9";paintanswer = false;break;
		case '.':
			if(!pointstate)
			{
				if(tempnumstr.equals("0")||paintanswer)
				{
					tempnumstr="0.";
				}
				else
				{
					tempnumstr+=".";
				}
				pointstate = true;
			}
			paintanswer = false;
			break;
		case '<':
			if(tempnumstr!= null && paintanswer ==false)
			{
				if(tempnumstr.length()>=2)
				{
					char[] temps = tempnumstr.substring(tempnumstr.length()-1,tempnumstr.length()).toCharArray();
					if(temps[temps.length-1] == '.')	//clean the 'point'
						pointstate=false;
					tempnumstr= tempnumstr.substring(0, tempnumstr.length()-1);
				}
				else
				{
					tempnumstr = "0";
				}
			}
			break;
		case '+':
			if(countstate == 0)
			{
				countstate = 1;
				countnum1 = new BigDecimal(tempnumstr);
				paintanswer = true;
				pointstate = false;
			}
			break;
		case '-':
			if(countstate == 0)
			{
				countstate = 2;
				countnum1 = new BigDecimal(tempnumstr);
				paintanswer = true;
				pointstate = false;
			}
			break;
		case '*':
			if(countstate == 0)
			{
				countstate = 3;
				countnum1 = new BigDecimal(tempnumstr);
				paintanswer = true;
				pointstate = false;
			}
			break;
		case '/':
			if(countstate == 0)
			{
				countstate = 4;
				countnum1 = new BigDecimal(tempnumstr);
				paintanswer = true;
				pointstate = false;
			}
			break;
		case 'f':
			if(tempnumstr.equals("0"))break;
			else
			{
				if(tempnumstr.substring(0,1).equals("-"))tempnumstr = tempnumstr.substring(1);
				else tempnumstr = "-"+tempnumstr;
			}
			break;
		case 'd':
			if(tempnumstr.equals("0"))break;
			countnum1 = new BigDecimal("1");
			countnum2 = new BigDecimal(tempnumstr);
			if(countnum2.intValue()==0 || countnum1.toString().equals("0"))
			{
				tempnumstr = "0";
			}
			else
			{
				resultnum = countnum1.divide(countnum2,8,BigDecimal.ROUND_HALF_EVEN);
				tempnumstr = resultnum.toString();
			}
			paintanswer = true;
			pointstate = false;
			break;
		case 's':
			countnum1 = new BigDecimal(tempnumstr);
			if(countnum1.intValue() > 0)
			{
				//MathContext mc = new MathContext(10,RoundingMode.HALF_DOWN);
				resultnum = new BigDecimal(String.valueOf(Math.sqrt(countnum1.doubleValue())));
				tempnumstr = resultnum.toString();
				java.text.DecimalFormat myformat=new java.text.DecimalFormat("0.00000000");
				tempnumstr = myformat.format(Double.valueOf(tempnumstr));    
				paintanswer = true;
				pointstate = false;
			}			
			break;
		case 'p':
			countnum1 = new BigDecimal(tempnumstr);
			resultnum = countnum1.divide(new BigDecimal(100),8,BigDecimal.ROUND_HALF_EVEN);
			tempnumstr = resultnum.toString();
			break;
		case '=':
			if(countnum1==null || paintanswer == true)
			{
				countstate = 0;
				paintanswer = true;
				pointstate = false;
				break;
			}
			if(countstate == 1)		//+
			{
				countnum2 = new BigDecimal(tempnumstr);
				resultnum = countnum1.add(countnum2);
				tempnumstr = resultnum.toString();
			}
			else if(countstate == 2)		//-
			{
				countnum2 = new BigDecimal(tempnumstr);
				resultnum = countnum1.subtract(countnum2);
				tempnumstr = resultnum.toString();
			}
			else if(countstate == 3)		//*
			{
				countnum2 = new BigDecimal(tempnumstr);
				resultnum = countnum1.multiply(countnum2);
				tempnumstr = resultnum.toString();
			}
			else if(countstate == 4)		// /
			{
				countnum2 = new BigDecimal(tempnumstr);
				if(countnum2.toString().equals("0") || countnum1.toString().equals("0"))
				{
					tempnumstr = "0";
				}
				else
				{
					resultnum = countnum1.divide(countnum2,8,BigDecimal.ROUND_HALF_EVEN);
					tempnumstr = resultnum.toString();
				}
			}
			else
			{
				countnum1 = new BigDecimal(tempnumstr);
			}
			countstate = 0;
			paintanswer = true;
			pointstate = false;
			break;
		case 'E':
			tempnumstr = "0";
			answerText.setText("0");
			countstate = 0;
			paintanswer = true;
			pointstate = false;
			break;
		case 'C':
			memstate = false;
			memnum = null;
			countnum1 = null;
			countnum2 = null;
			tempnumstr = "0";
			answerText.setText("0");
			countstate = 0;
			paintanswer = true;
			pointstate = false;
			break;
		case 'S':
			memnum = new BigDecimal(tempnumstr);
			memstate = true;
			break;
		case 'R':
			if(memstate && memnum!=null)
			tempnumstr = memnum.toString();
			break;
		case 'A':
			BigDecimal a = new BigDecimal(tempnumstr);
			if(memnum!=null)memnum = memnum.add(a);
			else memnum = a;
			memstate = true;
			break;
		case 'M':
			memstate = false;
			memnum = null;
			break;
		default :break;
		}
		if(memnum!=null && memnum.toString().equals("0")){memnum =null;memstate = false;}
		if(memstate)memoryState.setText("M");
		else memoryState.setText("");
		String resultstr="";
		if(szfz)
		{
			int a=tempnumstr.indexOf(".");
			if(a==-1)a=tempnumstr.length();
			resultstr = tempnumstr.substring(a);
			while(a-3>=0)
			{
				a-=3;
				resultstr =","+tempnumstr.substring(a,a+3)+resultstr;
			}
			resultstr = ","+tempnumstr.substring(0,a)+resultstr;
			if(resultstr.substring(0,1).equals(","))resultstr=resultstr.substring(1,resultstr.length());
			if(resultstr.substring(0,1).equals(","))resultstr=resultstr.substring(1,resultstr.length());
		}
		else
		{
			resultstr = tempnumstr;
		}
		answerText.setText(resultstr);
	}
	private void initialize() {
		tempnumstr = "0";
		memstate = false;
		paintanswer = false;
		pointstate = false;
		szfz = false;
		countstate = 0;
		frmMycounter = new JFrame();
		frmMycounter.setBackground(Color.LIGHT_GRAY);
		frmMycounter.setTitle("MyCounter");
		frmMycounter.setBounds(100, 100, 270, 250);
		frmMycounter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMycounter.setResizable(false);
		JPanel panel = new JPanel();
		frmMycounter.getContentPane().add(panel, BorderLayout.NORTH);
		
		answerText = new JTextField();
		answerText.setText("0");
		answerText.setEditable(false);
		panel.add(answerText);
		answerText.setColumns(22);
		answerText.setHorizontalAlignment(JTextField.RIGHT);
		
		panel_3 = new JPanel();
		frmMycounter.getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(4, 6, 0, 0));
		
		MC = new JButton("MC");
		MC.setMargin(new Insets(0, 0, 0, 0));
		MC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('M');
			}
		});
		panel_3.add(MC);
		
		num7 = new JButton("7");
		num7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('7');
			}
		});
		panel_3.add(num7);
		
		num8 = new JButton("8");
		num8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('8');
			}
		});
		panel_3.add(num8);
		
		num9 = new JButton("9");
		num9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('9');
			}
		});
		panel_3.add(num9);
		
		division = new JButton("/");
		division.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('/');
			}
		});
		panel_3.add(division);
		
		MR = new JButton("MR");
		MR.setMargin(new Insets(0, 0, 0, 0));
		MR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('R');
			}
		});
		
		btnNewButton_3 = new JButton("sqrt");
		btnNewButton_3.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('s');
			}
		});
		panel_3.add(btnNewButton_3);
		panel_3.add(MR);
		
		num4 = new JButton("4");
		num4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('4');
			}
		});
		panel_3.add(num4);
		
		num5 = new JButton("5");
		num5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('5');
			}
		});
		panel_3.add(num5);
		
		num6 = new JButton("6");
		num6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('6');
			}
		});
		panel_3.add(num6);
		
		multi = new JButton("*");
		multi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('*');
			}
		});
		panel_3.add(multi);
		
		MS = new JButton("MS");
		MS.setMargin(new Insets(0, 0, 0, 0));
		MS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('S');
			}
		});
		
		btnNewButton_4 = new JButton("%");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('p');
			}
		});
		panel_3.add(btnNewButton_4);
		panel_3.add(MS);
		
		num1 = new JButton("1");
		num1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('1');
			}
		});
		panel_3.add(num1);
		
		num2 = new JButton("2");
		num2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('2');
			}
		});
		panel_3.add(num2);
		
		num3 = new JButton("3");
		num3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('3');
			}
		});
		panel_3.add(num3);
		
		minus = new JButton("-");
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('-');
			}
		});
		panel_3.add(minus);
		
		Madd = new JButton("M+");
		Madd.setMargin(new Insets(0, 0, 0, 0));
		Madd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('A');
			}
		});
		
		btnx = new JButton("1/x");
		btnx.setMargin(new Insets(0, 0, 0, 0));
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('d');
			}
		});
		panel_3.add(btnx);
		panel_3.add(Madd);
		
		num0 = new JButton("0");
		num0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('0');
			}
		});
		panel_3.add(num0);
		
		point = new JButton(".");
		point.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('.');
			}
		});
		
		btnNewButton_5 = new JButton("+/-");
		btnNewButton_5.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('f');
			}
		});
		panel_3.add(btnNewButton_5);
		panel_3.add(point);
		
		equal = new JButton("=");
		equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('=');
			}
		});
		
		add = new JButton("+");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('+');
			}
		});
		panel_3.add(add);
		panel_3.add(equal);
		
		panel_4 = new JPanel();
		frmMycounter.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		memoryState = new JTextField();
		memoryState.setEditable(false);
		panel_4.add(memoryState);
		memoryState.setColumns(2);
		
		btnNewButton = new JButton("BackSpace");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('<');
			}
		});
		panel_4.add(btnNewButton);
		
		btnNewButton_1 = new JButton("CE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('E');
			}
		});
		panel_4.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display('C');
			}
		});
		panel_4.add(btnNewButton_2);
		
		menuBar = new JMenuBar();
		frmMycounter.setJMenuBar(menuBar);
		
		mne = new JMenu("\u7F16\u8F91(E)");
		menuBar.add(mne);
		mne.setMnemonic(KeyEvent.VK_E);
		mntmccrtlc = new JMenuItem("\u590D\u5236(C)");
		mntmccrtlc.setMnemonic(KeyEvent.VK_E);
		mntmccrtlc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringSelection str = new StringSelection(answerText.getText());
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, str);
			}
		});
		mntmccrtlc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		mne.add(mntmccrtlc);
		
		mntmvCtrlv = new JMenuItem("\u7C98\u8D34(P)");
		mntmvCtrlv.setMnemonic(KeyEvent.VK_P);
		mntmvCtrlv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
				Transferable  contents=clipboard.getContents(this);   
                DataFlavor  flavor=DataFlavor.stringFlavor;   
                 if(contents.isDataFlavorSupported(flavor))    
                 {
                	 try{
	                	 String str;   
	                     str=(String)contents.getTransferData(flavor);   
	                     tempnumstr=String.valueOf(Double.parseDouble(str));
	                     answerText.setText(tempnumstr);                  
                	 }catch(Exception e){}
                 }
			}
		});
		mntmvCtrlv.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
		mne.add(mntmvCtrlv);
		
		mnv = new JMenu("\u67E5\u770B(V)");
		mnv.setMnemonic(KeyEvent.VK_V);
		menuBar.add(mnv);
		
		mntmt = new JMenuItem("\u6807\u51C6\u578B(T)");
		mntmt.setMnemonic(KeyEvent.VK_T);
		mnv.add(mntmt);
		
		checkBoxMenuItem = new JCheckBoxMenuItem("\u6570\u5B57\u5206\u7EC4");
		checkBoxMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				szfz=checkBoxMenuItem.isSelected();
				display(' ');
			}
		});
		mnv.add(checkBoxMenuItem);
		
		mnh = new JMenu("\u5E2E\u52A9(H)");
		mnh.setMnemonic(KeyEvent.VK_H);
		menuBar.add(mnh);
		dialog= new JDialog(frmMycounter,"关于计算器",true);  
		dialog.setResizable(false);
	    dialog.setSize(170, 200);  
	    dialog.setLocation(frmMycounter.getLocation().x+30,frmMycounter.getLocation().y+30);
	    JPanel dialogpanel=new JPanel();
	    dialog.getContentPane().add(dialogpanel);
	    dialogpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
	    JButton jButton1=new JButton("关闭");
	    jButton1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dialog.setVisible(false);
	    	}
	    });
	    JLabel dialoginfo = new JLabel("<html><body>小计算器<br>作者：Hontsev<body></html>");
	    dialoginfo.setFont(new Font("Dialog",0,18));
	    dialogpanel.add(dialoginfo);
	    dialogpanel.add(jButton1);
		mntma = new JMenuItem("\u5173\u4E8E\u8BA1\u7B97\u5668(A)");
		mntma.setMnemonic(KeyEvent.VK_A);
		mntma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            dialog.setVisible(true);  
			}
		});
		mnh.add(mntma);
	}
}
