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

class CloseAccount extends JInternalFrame implements ActionListener
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	JPanel p_button,p_center;
	JButton b_closeAccount,b_clear,b_close;
	JLabel l_accountNo,l_personalDetails,l_accountDetails,l_name,l_mname,l_lname,l_address,l_phoneNo,l_accountType,l_panNo,l_balance;
	JTextField tf_accountNo,tf_name,tf_mname,tf_lname,tf_address,tf_phoneNo,tf_accountType,tf_panNo,tf_balance;
	JTextArea ta_address;
	JScrollPane address;
	GridBagConstraints gc;
	Color background,foreground,buttonForeground,buttonBackground;
	Font labelFont,headingFont,buttonFont;
	
	public CloseAccount(Connection c)
	{
		super("Close Account",true,true,true,true);
		con = c;
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		setSize(900,600);
		setMinimumSize(new Dimension(900,600));
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
		
		l_accountNo = new JLabel("Account number");
		l_accountNo.setFont(headingFont);
		l_accountNo.setBackground(background);
		l_accountNo.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.EAST;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_accountNo,gc);
		
		tf_accountNo = new JTextField(20);
		tf_accountNo.addActionListener(this);
		gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.WEST;
		gc.gridx = 2;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(tf_accountNo,gc);
		
		l_personalDetails = new JLabel("- - - - - Personal Details - - - - -");
		l_personalDetails.setFont(headingFont);
		l_personalDetails.setBackground(background);
		l_personalDetails.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_personalDetails,gc);
		
		l_accountDetails = new JLabel("- - - - - Account Details - - - - -");
		l_accountDetails.setFont(headingFont);
		l_accountDetails.setBackground(background);
		l_accountDetails.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 2;
		gc.gridy = 1;
		gc.gridwidth = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_accountDetails,gc);
		
		l_name = new JLabel("Name");
		l_name.setFont(labelFont);
		l_name.setBackground(background);
		l_name.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_name,gc);
		
		tf_name = new JTextField(20);
		tf_name.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(tf_name,gc);
		
		l_accountType = new JLabel("Account Type");
		l_accountType.setFont(labelFont);
		l_accountType.setBackground(background);
		l_accountType.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 2;
		gc.gridy = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_accountType,gc);
	
		
		tf_accountType = new JTextField(20);
		tf_accountType.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 3;
		gc.gridy = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(tf_accountType,gc);
		
		l_mname = new JLabel("Middle Name");
		l_mname.setFont(labelFont);
		l_mname.setBackground(background);
		l_mname.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 3;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_mname,gc);
	
		tf_mname = new JTextField(20);
		tf_mname.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 3;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(tf_mname,gc);
		
		l_panNo = new JLabel("Pan Number");
		l_panNo.setFont(labelFont);
		l_panNo.setBackground(background);
		l_panNo.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 2;
		gc.gridy = 3;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_panNo,gc);
		
		tf_panNo = new JTextField(20);
		tf_panNo.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 3;
		gc.gridy = 3;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(tf_panNo,gc);
		
		l_lname = new JLabel("Last Name");
		l_lname.setFont(labelFont);
		l_lname.setBackground(background);
		l_lname.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 4;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_lname,gc);
		
		tf_lname = new JTextField(20);
		tf_lname.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 4;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(tf_lname,gc);
		
		l_balance = new JLabel("Balance");
		l_balance.setFont(labelFont);
		l_balance.setBackground(background);
		l_balance.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 2;
		gc.gridy = 4;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_balance,gc);
		
		tf_balance = new JTextField(20);
		tf_balance.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 3;
		gc.gridy = 4;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(tf_balance,gc);
		
		l_address = new JLabel("Address");
		l_address.setFont(labelFont);
		l_address.setBackground(background);
		l_address.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 5;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_address,gc);
		
		
		ta_address = new JTextArea(3,20);
		ta_address.setEditable(false);
		address = new JScrollPane(ta_address);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 5;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(address,gc);
		
		l_phoneNo = new JLabel("Phone Number");
		l_phoneNo.setFont(labelFont);
		l_phoneNo.setBackground(background);
		l_phoneNo.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 6;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(l_phoneNo,gc);
		
		tf_phoneNo = new JTextField(20);
		tf_phoneNo.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 6;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_center.add(tf_phoneNo,gc);
		
	}
	
	public void addButton()
	{
		b_closeAccount = new JButton("Close Account",new ImageIcon("Images/closeAccount.png"));
		b_closeAccount.setFont(buttonFont);
		b_closeAccount.setBackground(buttonBackground);
		b_closeAccount.setForeground(buttonForeground);
		b_closeAccount.setEnabled(false);
		b_closeAccount.addActionListener(this);
		
		b_clear = new JButton("Clear",new ImageIcon("Images/clear.png"));
		b_clear.setFont(buttonFont);
		b_clear.setBackground(buttonBackground);
		b_clear.setForeground(buttonForeground);
		b_clear.addActionListener(this);
		
		b_close = new JButton("Close",new ImageIcon("Images/close.png"));
		b_close.addActionListener(this);
		
		p_button.add(b_closeAccount);
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
		
		else if(e.getSource()==b_closeAccount)
		{
			actionCloseAccount();
		}
		
		else if(e.getSource()==b_clear)
		{
			b_closeAccount.setEnabled(false);
			tf_accountNo.setEditable(true);
			tf_accountType.setText("");
			tf_panNo.setText("");
			tf_balance.setText("");
			
			tf_name.setText("");
			tf_mname.setText("");
			tf_lname.setText("");
			ta_address.setText("");
			tf_phoneNo.setText("");
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
					tf_panNo.setText(rs.getString(3));
					tf_balance.setText(rs.getInt(5)+"");
					
					String s1 = "SELECT * from personal_details WHERE accno="+accno+"";
					stmt = con.createStatement();
					rs = stmt.executeQuery(s1);
					rs.next();
					tf_name.setText(rs.getString(2));
					tf_mname.setText(rs.getString(3));
					tf_lname.setText(rs.getString(4));
					ta_address.setText(rs.getString(7));
					tf_phoneNo.setText(rs.getString(10));
					b_closeAccount.setEnabled(true);
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
	
	public void actionCloseAccount()
	{
		int accno;
		int a=0;
		int b=0;
		String acc;
		
		acc = tf_accountNo.getText().trim();
		accno = Integer.parseInt(acc);
		
		try
		{
			String s = "DELETE FROM personal_details WHERE accno = "+accno;
			String s1 = "DELETE FROM account_details WHERE accno = "+accno;
			
			stmt = con.createStatement();
			a = stmt.executeUpdate(s);
			b = stmt.executeUpdate(s1);
			
			if(a>0&&b>0)
			{
				JOptionPane.showMessageDialog(this,"Account Deleted","Success",JOptionPane.PLAIN_MESSAGE);
				b_closeAccount.setEnabled(false);
				tf_accountNo.setEditable(true);
				tf_accountType.setText("");
				tf_panNo.setText("");
				tf_balance.setText("");
				
				tf_name.setText("");
				tf_mname.setText("");
				tf_lname.setText("");
				ta_address.setText("");
				tf_phoneNo.setText("");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
}
