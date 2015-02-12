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

class NewAccount extends JInternalFrame implements ActionListener
{
	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	JPanel p_button,p_center,p_personalDetails,p_accountDetails;
	JButton b_create,b_clear,b_close,b_generate;
	JLabel l_personal,l_account,l_name,l_mname,l_lname,l_father,l_gender,l_address,l_nationality,l_age,l_phone,l_accountNo,l_accountType,l_minimumAmt,l_panNo,l_id,l_balance;
	JTextField tf_name,tf_mname,tf_lname,tf_father,tf_nationality,tf_age,tf_phone,tf_accountNo,tf_minimumAmt,tf_panNo,tf_balance;
	JTextArea ta_address;
	JScrollPane address;
	JRadioButton rb_male,rb_female;
	JComboBox cb_id,cb_accountType;
	ButtonGroup bg;
	GridBagConstraints gc;
	Color background,foreground,buttonForeground,buttonBackground;
	Font buttonFont,labelFont,headingFont;
	
	public NewAccount(Connection c)
	{
		super("Create New Account",true,true,true,true);
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
		
		l_name = new JLabel("First Name *");
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
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_personalDetails.add(tf_mname,gc);
		
		l_lname = new JLabel("Last Name  *");
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
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 3;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_personalDetails.add(tf_lname,gc);
		
		l_gender = new JLabel("Gender  *");
		l_gender.setFont(labelFont);
		l_gender.setBackground(background);
		l_gender.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 4;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_personalDetails.add(l_gender,gc);
		
		rb_male = new JRadioButton("Male");
		rb_male.setFont(labelFont);
		rb_male.setBackground(background);
		rb_male.setForeground(foreground);
		rb_female = new JRadioButton("Female");
		rb_female.setFont(labelFont);
		rb_female.setBackground(background);
		rb_female.setForeground(foreground);
		bg = new ButtonGroup();
		bg.add(rb_male);
		bg.add(rb_female);
		
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 4;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_personalDetails.add(rb_male,gc);
		
		gc = new GridBagConstraints();
		gc.gridx = 2;
		gc.gridy = 4;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_personalDetails.add(rb_female,gc);
		
		l_father = new JLabel("Father's Name  *");
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
		address = new JScrollPane(ta_address);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 6;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_personalDetails.add(address,gc);
		
		l_nationality = new JLabel("Nationality  *");
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
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 8;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 2;
		p_personalDetails.add(tf_age,gc);
		
		l_phone = new JLabel("Phone Number  *");
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
		
		l_accountNo = new JLabel("Account Number");
		l_accountNo.setFont(labelFont);
		l_accountNo.setBackground(background);
		l_accountNo.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(l_accountNo,gc);
		
		tf_accountNo = new JTextField(20);
		tf_accountNo.setText(""+accountNo());
		tf_accountNo.setEditable(false);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(tf_accountNo,gc);
		
		l_accountType = new JLabel("Account Type  *");
		l_accountType.setFont(labelFont);
		l_accountType.setBackground(background);
		l_accountType.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(l_accountType,gc);
		
		String s1[] = {"Saving","Current"};
		cb_accountType = new JComboBox(s1);
		cb_accountType.setFont(labelFont);
		cb_accountType.setBackground(background);
		cb_accountType.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(cb_accountType,gc);
		
		l_minimumAmt = new JLabel("Minimum Ammount");
		l_minimumAmt.setFont(labelFont);
		l_minimumAmt.setBackground(background);
		l_minimumAmt.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 3;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(l_minimumAmt,gc);
		
		tf_minimumAmt = new JTextField(20);
		tf_minimumAmt.setEditable(false);
		tf_minimumAmt.setText("1000");
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 3;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(tf_minimumAmt,gc);
		
		l_panNo = new JLabel("Pan Number  *");
		l_panNo.setFont(labelFont);
		l_panNo.setBackground(background);
		l_panNo.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 4;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(l_panNo,gc);
		
		tf_panNo = new JTextField(20);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 4;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(tf_panNo,gc);
		
		l_id = new JLabel("ID Provided  *");
		l_id.setFont(labelFont);
		l_id.setBackground(background);
		l_id.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 5;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(l_id,gc);
		
		String s[] = {"Driving Licence","Passport"};
		cb_id = new JComboBox(s);
		cb_id.setFont(labelFont);
		cb_id.setBackground(background);
		cb_id.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 5;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(cb_id,gc);
		
		l_balance = new JLabel("Balance  *");
		l_balance.setFont(labelFont);
		l_balance.setBackground(background);
		l_balance.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 6;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(l_balance,gc);
		
		tf_balance = new JTextField(20);
		gc = new GridBagConstraints();
		gc.gridx = 1;
		gc.gridy = 6;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		p_accountDetails.add(tf_balance,gc);
		
		JLabel l_man = new JLabel(" *   Mandatory Fields");
		l_man.setFont(headingFont);
		l_man.setBackground(background);
		l_man.setForeground(foreground);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 7;
		gc.weightx = 0.5;
		gc.gridwidth = 2;
		gc.weighty = 0.5;
		p_accountDetails.add(l_man,gc);
		
		b_generate = new JButton("Generate Account");
		b_generate.setFont(buttonFont);
		b_generate.setBackground(background);
		b_generate.setForeground(foreground);
		b_generate.addActionListener(this);
		gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 8;
		gc.weightx = 0.5;
		gc.gridwidth = 2;
		gc.weighty = 0.5;
		p_accountDetails.add(b_generate,gc);
		
		p_center.add(p_personalDetails);
		p_center.add(p_accountDetails);
	}
	
	public void addButton()
	{
		b_create = new JButton("Create",new ImageIcon("Images/new.png"));
		b_create.setFont(buttonFont);
		b_create.setBackground(buttonBackground);
		b_create.setForeground(buttonForeground);
		b_create.setEnabled(false);
		b_create.addActionListener(this);
		
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
		
		p_button.add(b_create);
		p_button.add(b_clear);
		p_button.add(b_close);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b_generate)
		{
			actionGenerate();
		}
		
		else if(e.getSource()==b_create)
		{
			createAccount();
		}
		
		if(e.getSource()==b_close)
		{
			setVisible(false);
		}
		
		else if(e.getSource()==b_clear)
		{
			tf_name.setEditable(true);
			tf_mname.setEditable(true);
			tf_lname.setEditable(true);
			tf_father.setEditable(true);
			tf_nationality.setEditable(true);
			tf_age.setEditable(true);
			tf_phone.setEditable(true);
			tf_panNo.setEditable(true);
			tf_balance.setEditable(true);
			ta_address.setEditable(true);
			rb_male.setEnabled(true);
			rb_female.setEnabled(true);
			cb_id.setEnabled(true);
			cb_accountType.setEnabled(true);
			b_create.setEnabled(false);
			b_generate.setEnabled(true);
		}
	}
	
	public int accountNo()
	{
		int accno=0;
		try
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT MAX(accno) FROM account_details");
			
			if(rs.next())
			{
				accno = rs.getInt(1);
				if(accno==0)
				{
					accno=1001;
				}
				else
				{
					accno+=1;
				}
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		return accno;
	}
	
	public void actionGenerate()
	{
		tf_accountNo.setText(""+accountNo());
		
		boolean flag=false;
		String name,age,lname,gender,fname,nation,phone,acctype,pan,id,bal;
		
		name = tf_name.getText().trim();
		lname = tf_lname.getText().trim();
		fname = tf_father.getText().trim();
		nation = tf_nationality.getText().trim();
		age = tf_age.getText().trim();
		phone = tf_phone.getText().trim();
		acctype = cb_accountType.getSelectedItem().toString().trim();
		pan = tf_panNo.getText().trim();
		id = cb_id.getSelectedItem().toString().trim();
		bal = tf_balance.getText().trim();
		
		gender = ""; 
			
		if(rb_male.isSelected())
			gender = "M"; 	
		else if(rb_female.isSelected())
			gender = "F";
		
		if(name.equals("")||lname.equals("")||gender.equals("")||fname.equals("")||nation.equals("")||phone.equals("")||acctype.equals("")||pan.equals("")||id.equals("")||bal.equals(""))
		{
			JOptionPane.showMessageDialog(this,"Fill all the mendatory fields","Please",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			boolean flag1=false;
			boolean flag2=false;
			boolean flag3=false;
			
			int a=0;
			int b=0;
			
			try
			{
				long p = Long.parseLong(phone);
			}
			catch(NumberFormatException ne)
			{
				flag1 = true;
			}
			
			try
			{
				b = Integer.parseInt(bal);
			}
			catch(NumberFormatException ne)
			{
				flag2 = true;
			}
			
			if(!age.equals(""))
			{
				try
				{
					a = Integer.parseInt(age);
				}
				catch(NumberFormatException ne)
				{
					flag3 = true;
				}
			}
			
			if(flag1)
			{
				JOptionPane.showMessageDialog(this,"Invalid Phone no. ","Error",JOptionPane.ERROR_MESSAGE);
			}
			
			else if(flag2)
			{
				JOptionPane.showMessageDialog(this,"Invalid Balance ","Error",JOptionPane.ERROR_MESSAGE);
			}
			
			else if(flag3)
			{
				JOptionPane.showMessageDialog(this,"Invalid Age","Error",JOptionPane.ERROR_MESSAGE);
			}
			
			else if(b<1000)
			{
				JOptionPane.showMessageDialog(this,"Balance should be greater then 1000 rs.","Error",JOptionPane.ERROR_MESSAGE);
			}
			
			else 
			{
				flag = true;
			}
		}
		
		if(flag)
		{
			tf_name.setEditable(false);
			tf_mname.setEditable(false);
			tf_lname.setEditable(false);
			tf_father.setEditable(false);
			tf_nationality.setEditable(false);
			tf_age.setEditable(false);
			tf_phone.setEditable(false);
			tf_panNo.setEditable(false);
			tf_balance.setEditable(false);
			ta_address.setEditable(false);
			rb_male.setEnabled(false);
			rb_female.setEnabled(false);
			cb_id.setEnabled(false);
			cb_accountType.setEnabled(false);
			b_create.setEnabled(true);
			b_generate.setEnabled(false);
		}
	}
	
	public void createAccount()
	{
		long phoneNo=0l;
		int	balance=0;
		int	age=0;
		int	accn=0;
		int	i=0;
		int	j=0;
		String name,mname,lname,gender,fname,add,nation,ag,phone,accno,acctype,pan,id,bal,query,query1;
		name = tf_name.getText().trim();
		mname = tf_mname.getText().trim();
		lname = tf_lname.getText().trim();
		fname = tf_father.getText().trim();
		add = ta_address.getText().trim();
		nation = tf_nationality.getText().trim();
		ag = tf_age.getText().trim();
		phone = tf_phone.getText().trim();
		accno = tf_accountNo.getText().trim();
		acctype = cb_accountType.getSelectedItem().toString().trim();
		pan = tf_panNo.getText().trim();
		id = cb_id.getSelectedItem().toString().trim();
		bal = tf_balance.getText().trim();
		gender = "";
		if(rb_male.isSelected())
			gender = "M"; 	
		else if(rb_female.isSelected())
			gender = "F";
		
		try
		{
			phoneNo = Long.parseLong(phone);
			balance = Integer.parseInt(bal);
			accn = Integer.parseInt(accno);
			age = Integer.parseInt(ag);
			
			query = "INSERT INTO personal_details VALUES(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,accn);
			pstmt.setString(2,name);
			pstmt.setString(3,mname);
			pstmt.setString(4,lname);
			pstmt.setString(5,gender);
			pstmt.setString(6,fname);
			pstmt.setString(7,add);
			pstmt.setString(8,nation);
			pstmt.setInt(9,age);
			pstmt.setLong(10,phoneNo);
			i = pstmt.executeUpdate();
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(NumberFormatException ne)
		{
			try
			{
				query = "INSERT INTO personal_details VALUES(?,?,?,?,?,?,?,?,NULL,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1,accn);
				pstmt.setString(2,name);
				pstmt.setString(3,mname);
				pstmt.setString(4,lname);
				pstmt.setString(5,gender);
				pstmt.setString(6,fname);
				pstmt.setString(7,add);
				pstmt.setString(8,nation);
				pstmt.setLong(9,phoneNo);
				i = pstmt.executeUpdate();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		
		try
		{
			query1 = "INSERT INTO account_details VALUES(?,?,?,?,?)";
			
			pstmt = con.prepareStatement(query1);
			pstmt.setInt(1,accn);
			pstmt.setString(2,acctype);
			pstmt.setString(3,pan);
			pstmt.setString(4,id);
			pstmt.setInt(5,balance);
			j = pstmt.executeUpdate();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		if(i>0&&j>0)
		{
			JOptionPane.showMessageDialog(this,"Account Created","Success",JOptionPane.PLAIN_MESSAGE);
			
			tf_name.setEditable(true);
			tf_name.setText("");
			
			tf_mname.setEditable(true);
			tf_mname.setText("");
			
			tf_lname.setEditable(true);
			tf_lname.setText("");
			
			tf_father.setEditable(true);
			tf_father.setText("");
			
			tf_nationality.setEditable(true);
			tf_nationality.setText("");
			
			tf_age.setEditable(true);
			tf_age.setText("");
			
			tf_phone.setEditable(true);
			tf_phone.setText("");
			
			tf_accountNo.setText(""+accountNo());
			
			tf_panNo.setEditable(true);
			tf_panNo.setText("");
			
			tf_balance.setEditable(true);
			tf_balance.setText("");
			
			ta_address.setEditable(true);
			ta_address.setText("");
			
			rb_male.setEnabled(true);
			rb_female.setEnabled(true);
			cb_id.setEnabled(true);
			cb_accountType.setEnabled(true);
			b_create.setEnabled(false);
			b_generate.setEnabled(true);
		}
	}
}
