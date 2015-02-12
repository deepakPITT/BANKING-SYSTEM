/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Withdrawal extends JInternalFrame implements ActionListener
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	JPanel p_button,p_center;
	JButton b_withdrawal,b_clear,b_close;
	JLabel l_accountNo,l_name,l_mname,l_lname,l_accountType,l_minimumAmt,l_balance,l_withdrawal;
	JTextField tf_accountNo,tf_name,tf_mname,tf_lname,tf_accountType,tf_minimumAmt,tf_balance,tf_withdrawal;
	GridBagConstraints gc;
	Color background,foreground,buttonForeground,buttonBackground;
	Font buttonFont,labelFont,headingFont;
	
	public Withdrawal(Connection c)
	{
		super("Withdrawal Ammount",true,true,true,true);
		con = c;
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		setSize(900,350);
		setMinimumSize(new Dimension(900,350));
		setLayout(new BorderLayout());
		
		background = new Color(240,247,245);
		foreground = new Color(56,107,101);
		buttonBackground = new Color(170,210,205);
		buttonForeground = Color.DARK_GRAY;
		buttonFont = new Font("Harrington",Font.BOLD,18);
		labelFont = new Font("Andalus",Font.BOLD,16);
		headingFont = new Font("Andalus",Font.BOLD,20);
		
		p_center = new JPanel(new GridBagLayout());
		p_center.setBackground(background);
		addComponents();
		
		p_button = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		p_button.setBackground(background);
		addButton();
		
		add(p_center, BorderLayout.CENTER);
		add(p_button, BorderLayout.SOUTH);
	}
	
	public void addComponents()
	{
		l_accountNo = new JLabel("Account Number");
		l_accountNo.setFont(headingFont);
		l_accountNo.setBackground(background);
		l_accountNo.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.anchor = GridBagConstraints.EAST;
		p_center.add(l_accountNo,gc);
		
		tf_accountNo = new JTextField(20);
		tf_accountNo.addActionListener(this);
		gc = new GridBagConstraints();
		gc.gridx = 2;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.anchor=GridBagConstraints.WEST;
		p_center.add(tf_accountNo);
		
		l_name = new JLabel("Name");
		l_name.setFont(labelFont);
		l_name.setBackground(background);
		l_name.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_name,gc);
		
		tf_name = new JTextField(20);
		tf_name.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(tf_name,gc);
		
		l_accountType = new JLabel("Account Type");
		l_accountType.setFont(labelFont);
		l_accountType.setBackground(background);
		l_accountType.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 2;
		gc.gridy = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_accountType,gc);
		
		tf_accountType = new JTextField(20);
		tf_accountType.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 3;
		gc.gridy = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(tf_accountType,gc);
		
		
		l_mname = new JLabel("Middle Name");
		l_mname.setFont(labelFont);
		l_mname.setBackground(background);
		l_mname.setForeground(foreground);
		gc=new GridBagConstraints();
		gc.gridx=0;
		gc.gridy=2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_mname,gc);
		
		tf_mname=new JTextField(20);
		tf_mname.setEditable(false);
		gc=new GridBagConstraints();
		gc.gridx=1;
		gc.gridy=2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(tf_mname,gc);
		
		l_minimumAmt=new JLabel("Minimum Amount");
		l_minimumAmt.setFont(labelFont);
		l_minimumAmt.setBackground(background);
		l_minimumAmt.setForeground(foreground);
		gc=new GridBagConstraints();
		gc.gridx=2;
		gc.gridy=2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_minimumAmt,gc);
		
		tf_minimumAmt=new JTextField(20);
		tf_minimumAmt.setEditable(false);
		gc=new GridBagConstraints();
		gc.gridx=3;
		gc.gridy=2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(tf_minimumAmt,gc);
		
		l_lname=new JLabel("Last Name");
		l_lname.setFont(labelFont);
		l_lname.setBackground(background);
		l_lname.setForeground(foreground);
		gc=new GridBagConstraints();
		gc.gridx=0;
		gc.gridy=3;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_lname,gc);
		
		
		tf_lname=new JTextField(20);
		tf_lname.setEditable(false);
		gc=new GridBagConstraints();
		gc.gridx=1;
		gc.gridy=3;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(tf_lname,gc);
		
		l_balance=new JLabel("Balance");
		l_balance.setFont(labelFont);
		l_balance.setBackground(background);
		l_balance.setForeground(foreground);
		gc=new GridBagConstraints();
		gc.gridx=2;
		gc.gridy=3;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_balance,gc);
		
		tf_balance=new JTextField(20);
		tf_balance.setEditable(false);
		gc=new GridBagConstraints();
		gc.gridx=3;
		gc.gridy=3;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(tf_balance,gc);
		
		
		l_withdrawal=new JLabel("Amount To Be Withdrawal");
		l_withdrawal.setFont(labelFont);
		l_withdrawal.setBackground(background);
		l_withdrawal.setForeground(foreground);
		gc=new GridBagConstraints();
		gc.gridx=0;
		gc.gridy=4;
		gc.gridwidth=2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.anchor=GridBagConstraints.EAST;
		p_center.add(l_withdrawal,gc);
	
		
		tf_withdrawal=new JTextField(20);
		tf_withdrawal.setEditable(false);
		gc=new GridBagConstraints();
		gc.gridx=2;
		gc.gridy=4;
		gc.gridwidth=2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.anchor=GridBagConstraints.WEST;
		p_center.add(tf_withdrawal,gc);
	}
	
	public void addButton()
	{
		b_withdrawal = new JButton("Withdrawal Ammount",new ImageIcon("Images/withdraw.png"));
		b_withdrawal.setFont(buttonFont);
		b_withdrawal.setBackground(buttonBackground);
		b_withdrawal.setForeground(buttonForeground);
		b_withdrawal.setEnabled(false);
		b_withdrawal.addActionListener(this);
		
		b_clear = new JButton("Clear",new ImageIcon("Images/clear.png"));
		b_clear.setFont(buttonFont);
		b_clear.setBackground(buttonBackground);
		b_clear.setForeground(buttonForeground);
		b_clear.addActionListener(this);
		
		b_close = new JButton("Close",new ImageIcon("Images/close.png"));
		b_close.setFont(buttonFont);
		b_close.setBackground(buttonBackground);
		b_close.setForeground(buttonForeground);
		b_close.addActionListener(this);
		p_button.add(b_withdrawal);
		p_button.add(b_clear);
		p_button.add(b_close);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b_close)
		{
			setVisible(false);
		}
		
		else if(e.getSource()==tf_accountNo)
		{
			actionAccount();
		}
		
		else if(e.getSource()==b_withdrawal)
		{
			actionWithdrawal();
		}
		
		else if(e.getSource()==b_clear)
		{
			b_withdrawal.setEnabled(false);
			tf_withdrawal.setEditable(false);
			tf_withdrawal.setText("");
			
			tf_accountNo.setEditable(true);
			tf_accountType.setText("");
			tf_minimumAmt.setText(1000+"");
			tf_balance.setText("");
			
			tf_name.setText("");
			tf_mname.setText("");
			tf_lname.setText("");
		}
	}
	
	public void actionAccount()
	{
		int accno;
		String acc;
		
		acc = tf_accountNo.getText().trim();
		
		if(!acc.equals(""))
		{
			try
			{
				accno = Integer.parseInt(acc);
				
				String s = "SELECT * from account_details WHERE accno="+accno+"";
				stmt = con.createStatement();
				rs = stmt.executeQuery(s);
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(this,"Account number does not exist","Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					tf_accountNo.setEditable(false);
					tf_accountType.setText(rs.getString(2));
					tf_minimumAmt.setText(1000+"");
					tf_balance.setText(rs.getInt(5)+"");
					
					String s1 = "SELECT * from personal_details WHERE accno="+accno+"";
					stmt = con.createStatement();
					rs = stmt.executeQuery(s1);
					rs.next();
					
					tf_name.setText(rs.getString(2));
					tf_mname.setText(rs.getString(3));
					tf_lname.setText(rs.getString(4));
					tf_withdrawal.setText("");
					tf_withdrawal.setEditable(true);
					b_withdrawal.setEnabled(true);
				}
			}
			catch(NumberFormatException ne)
			{
				JOptionPane.showMessageDialog(this,"Invalid Account Number","Error",JOptionPane.ERROR_MESSAGE);
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
		}
		
	}
	
	public void actionWithdrawal()
	{
		int accno,balance;
		int a=0;
		balance = 0;
		accno=0;
		
		String acc,bal;
		acc = tf_accountNo.getText().trim();
		bal = tf_withdrawal.getText().trim();
		try
		{
			accno = Integer.parseInt(acc);
			balance = Integer.parseInt(bal);
			
			String str = "SELECT balance FROM account_details WHERE accno="+accno;
			stmt = con.createStatement();
			rs = stmt.executeQuery(str);
			rs.next();
			
			if(balance<0)
			{
				JOptionPane.showMessageDialog(this,"Ammount can't be negetive","Error",JOptionPane.ERROR_MESSAGE);
			}
			else if((rs.getInt(1)-balance)<1000)
			{
				JOptionPane.showMessageDialog(this,"Not enough Balance","Error",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				try
				{
					String s = "UPDATE account_details SET balance = balance-"+balance;
			
					stmt = con.createStatement();
					a = stmt.executeUpdate(s);
			
					if(a>0)
					{
						JOptionPane.showMessageDialog(this,"Withdrawal Successfully","Success",JOptionPane.PLAIN_MESSAGE);
						b_withdrawal.setEnabled(false);
						tf_accountNo.setEditable(true);
						tf_accountType.setText("");
						tf_balance.setText("");
				
						tf_name.setText("");
						tf_mname.setText("");
						tf_lname.setText("");
						tf_withdrawal.setText("");
						tf_withdrawal.setEditable(false);
					}
				}
				catch(SQLException se)
				{	
					se.printStackTrace();
				}
			}
			
		}
		catch(NumberFormatException ne)
		{
			JOptionPane.showMessageDialog(this,"Invalid Ammount","Error",JOptionPane.ERROR_MESSAGE);
		}
		catch(SQLException se)
		{	
			se.printStackTrace();
		}
	}
}