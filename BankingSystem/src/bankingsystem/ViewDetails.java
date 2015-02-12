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

class ViewDetails extends JInternalFrame implements ActionListener
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	JPanel p_button,p_center,p_personalDetails,p_accountDetails,p_north;
	JButton b_clear,b_close;
	JLabel l_personal,l_account,l_name,l_mname,l_lname,l_father,l_gender,l_address,l_nationality,l_age,l_phone,l_accountNo,l_accountType,l_minimumAmt,l_panNo,l_id,l_balance;
	JTextField tf_name,tf_mname,tf_lname,tf_father,tf_nationality,tf_age,tf_phone,tf_accountNo,tf_minimumAmt,tf_panNo,tf_balance,tf_gender,tf_id,tf_accountType;
	JTextArea ta_address;
	JScrollPane address;
	GridBagConstraints gc;
	Color background,foreground,buttonForeground,buttonBackground;
	Font labelFont,headingFont,buttonFont;
	
	public ViewDetails(Connection c)
	{
		
		super("View Details",true,true,true,true);
		con = c;
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		setSize(1000,650);
		setMinimumSize(new Dimension(1000,650));
		setLayout(new BorderLayout());
		
		background = new Color(240,247,245);
		foreground = new Color(56,107,101);
		buttonBackground = new Color(170,210,205);
		buttonForeground = Color.DARK_GRAY;
		buttonFont = new Font("Harrington",Font.BOLD,18);
		labelFont = new Font("Andalus",Font.BOLD,16);
		headingFont = new Font("Andalus",Font.BOLD,20);
		
		p_center = new JPanel(new GridLayout(1,2));
		addComponents();
		
		p_button = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		p_button.setBackground(background);
		addButton();
		
		p_north = new JPanel();
		p_north.setBackground(background);
		l_accountNo = new JLabel("Account Number");
		l_accountNo.setFont(headingFont);
		l_accountNo.setBackground(background);
		l_accountNo.setForeground(foreground);
		tf_accountNo = new JTextField(20);
		tf_accountNo.addActionListener(this);
		p_north.add(l_accountNo);
		p_north.add(tf_accountNo);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center, BorderLayout.CENTER);
		add(p_button, BorderLayout.SOUTH);
	}
	
	public void addComponents()
	{
		p_personalDetails = new JPanel(new GridBagLayout());
		p_personalDetails.setBackground(background);
		
		l_personal = new JLabel("- - - - - Personal Details - - - - -");
		l_personal.setFont(headingFont);
		l_personal.setBackground(background);
		l_personal.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 3;
		p_personalDetails.add(l_personal,gc);
		
		l_name = new JLabel("First Name");
		l_name.setFont(labelFont);
		l_name.setBackground(background);
		l_name.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_personalDetails.add(l_name,gc);
		
		tf_name = new JTextField(20);
		tf_name.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_personalDetails.add(tf_name,gc);
		
		l_mname = new JLabel("Middle Name");
		l_mname.setFont(labelFont);
		l_mname.setBackground(background);
		l_mname.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_personalDetails.add(l_mname,gc);
		
		tf_mname = new JTextField(20);
		tf_mname.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_personalDetails.add(tf_mname,gc);
		
		l_lname = new JLabel("Last Name");
		l_lname.setFont(labelFont);
		l_lname.setBackground(background);
		l_lname.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 3;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_personalDetails.add(l_lname,gc);
		
		tf_lname = new JTextField(20);
		tf_lname.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 3;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_personalDetails.add(tf_lname,gc);
		
		l_gender = new JLabel("Gender");
		l_gender.setFont(labelFont);
		l_gender.setBackground(background);
		l_gender.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 4;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_personalDetails.add(l_gender,gc);
		
		tf_gender = new JTextField(20);
		tf_gender.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 4;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_personalDetails.add(tf_gender,gc);
		
		l_father = new JLabel("Father's Name");
		l_father.setFont(labelFont);
		l_father.setBackground(background);
		l_father.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 5;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_personalDetails.add(l_father,gc);
		
		tf_father = new JTextField(20);
		tf_father.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 5;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_personalDetails.add(tf_father,gc);
		
		l_address = new JLabel("Address");
		l_address.setFont(labelFont);
		l_address.setBackground(background);
		l_address.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 6;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_personalDetails.add(l_address,gc);
		
		ta_address = new JTextArea(3,20);
		ta_address.setEditable(false);
		address = new JScrollPane(ta_address);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 6;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_personalDetails.add(address,gc);
		
		l_nationality = new JLabel("Nationality");
		l_nationality.setFont(labelFont);
		l_nationality.setBackground(background);
		l_nationality.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 7;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_personalDetails.add(l_nationality,gc);
		
		tf_nationality = new JTextField(20);
		tf_nationality.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 7;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_personalDetails.add(tf_nationality,gc);
		
		l_age = new JLabel("Age");
		l_age.setFont(labelFont);
		l_age.setBackground(background);
		l_age.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 8;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_personalDetails.add(l_age,gc);
		
		tf_age = new JTextField(20);
		tf_age.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 8;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_personalDetails.add(tf_age,gc);
		
		l_phone = new JLabel("Phone Number");
		l_phone.setFont(labelFont);
		l_phone.setBackground(background);
		l_phone.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 9;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_personalDetails.add(l_phone,gc);
		
		tf_phone = new JTextField(20);
		tf_phone.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 9;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_personalDetails.add(tf_phone,gc);
		
		
		
		p_accountDetails = new JPanel(new GridBagLayout());
		p_accountDetails.setBackground(background);
		
		l_account = new JLabel("- - - - - Account Details - - - - -");
		l_account.setFont(headingFont);
		l_account.setBackground(background);
		l_account.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_accountDetails.add(l_account,gc);
		
		l_accountType = new JLabel("Account Type");
		l_accountType.setFont(labelFont);
		l_accountType.setBackground(background);
		l_accountType.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(l_accountType,gc);
		
		tf_accountType = new JTextField(20);
		tf_accountType.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_accountDetails.add(tf_accountType,gc);
		
		l_minimumAmt = new JLabel("Minimum Ammount");
		l_minimumAmt.setFont(labelFont);
		l_minimumAmt.setBackground(background);
		l_minimumAmt.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(l_minimumAmt,gc);
		
		tf_minimumAmt = new JTextField(20);
		tf_minimumAmt.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(tf_minimumAmt,gc);
		
		l_panNo = new JLabel("Pan Number");
		l_panNo.setFont(labelFont);
		l_panNo.setBackground(background);
		l_panNo.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 3;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(l_panNo,gc);
		
		tf_panNo = new JTextField(20);
		tf_panNo.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 3;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(tf_panNo,gc);
		
		l_id = new JLabel("ID Provided");
		l_id.setFont(labelFont);
		l_id.setBackground(background);
		l_id.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 4;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(l_id,gc);
		
		tf_id = new JTextField(20);
		tf_id.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 4;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_accountDetails.add(tf_id,gc);
		
		l_balance = new JLabel("Balance");
		l_balance.setFont(labelFont);
		l_balance.setBackground(background);
		l_balance.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 5;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(l_balance,gc);
		
		tf_balance = new JTextField(20);
		tf_balance.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 5;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(tf_balance,gc);
		
		p_center.add(p_personalDetails);
		p_center.add(p_accountDetails);
	}
	
	public void addButton()
	{
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
		
		else if(e.getSource()==b_clear)
		{
			tf_accountNo.setEditable(true);
			tf_accountType.setText("");
			tf_minimumAmt.setText("");
			tf_panNo.setText("");
			tf_id.setText("");
			tf_balance.setText("");
			
			tf_name.setText("");
			tf_mname.setText("");
			tf_lname.setText("");
			tf_gender.setText("");
			tf_father.setText("");
			ta_address.setText("");
			tf_nationality.setText("");
			tf_age.setText("");
			tf_phone.setText("");
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
					tf_panNo.setText(rs.getString(3));
					tf_id.setText(rs.getString(4));
					tf_balance.setText(rs.getInt(5)+"");
					
					String s1 = "SELECT * from personal_details WHERE accno="+accno+"";
					stmt = con.createStatement();
					rs = stmt.executeQuery(s1);
					rs.next();
					tf_name.setText(rs.getString(2));
					tf_mname.setText(rs.getString(3));
					tf_lname.setText(rs.getString(4));
					tf_gender.setText(rs.getString(5));
					tf_father.setText(rs.getString(6));
					ta_address.setText(rs.getString(7));
					tf_nationality.setText(rs.getString(8));
					tf_age.setText(rs.getString(9));
					tf_phone.setText(rs.getString(10));
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
	
}