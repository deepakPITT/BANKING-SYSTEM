/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem ;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

class BankingSystem extends JFrame implements ActionListener
{
	JMenuBar jmb;
	JMenu m_system,m_account,m_transaction,m_information;
	JMenuItem mi_new,mi_close,mi_exit,mi_deposit,mi_withdrawal,mi_about,mi_help,mi_view;
	JDesktopPane dp;
	private JDialog DIALOG_ABOUT;
	private JDialog DIALOG_HELP;
	Connection con;
	ViewDetails viewDetails;
	NewAccount newAccount;
	CloseAccount closeAccount;
	Deposit deposit;
	Withdrawal withdrawal;
	
	public BankingSystem()
	{
		
		
		super("Banking System");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:8889/bank","root","root");
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1200,700));
		setIconImage(new ImageIcon("Images/bank.png").getImage());
		
		DIALOG_ABOUT=new JDialog(this,"ABOUT - Banking System",true,null);
		ABOUT();
		DIALOG_HELP=new JDialog(this,"HELP - Banking System",true,null);
		HELP();
		
		jmb=new JMenuBar();
		createMenubar();
		setJMenuBar(jmb);
		
		dp = new JDesktopPane()
		{
 		   ImageIcon icon = new ImageIcon("Images/BankImage.jpg");
 		   Image image = icon.getImage();
		
	       Image newimage = image.getScaledInstance(1500, 1000, Image.SCALE_SMOOTH);

    		protected void paintComponent(Graphics g)
    		{
    		    super.paintComponent(g);
    		    g.drawImage(newimage, 0, 0, this);
   			 }
		};
		
		addInternalFrames();
		dp.setBackground(Color.lightGray);
		getContentPane().add(dp,BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void createMenubar()
	{
		Color background = new Color(240,247,245);
		Color foreground = new Color(56,107,101);
		Font f = new Font("Harrington",Font.BOLD,18);
		Font f1 = new Font("Andalus",Font.BOLD,16);
		jmb.setBackground(background);
		
		
		m_system = new JMenu("System");
		m_system.setFont(f);
		m_system.setForeground(foreground);
		
		mi_view = new JMenuItem("View Details",new ImageIcon("Images/view.png"));
		mi_view.setFont(f1);
		mi_view.setForeground(foreground);
		mi_view.setBackground(background);
		mi_view.addActionListener(this);
		
		mi_exit=new JMenuItem("Exit",new ImageIcon("Images/close.png"));
		mi_exit.setFont(f1);
		mi_exit.setForeground(foreground);
		mi_exit.setBackground(background);
		mi_exit.addActionListener(this); 
			
		m_system.add(mi_view);
		m_system.addSeparator();
		m_system.add(mi_exit);
		
		
		m_account = new JMenu("Account");
		m_account.setFont(f);
		m_account.setForeground(foreground);
		
		mi_new = new JMenuItem("New",new ImageIcon("Images/new.png"));
		mi_new.setFont(f1);
		mi_new.setForeground(foreground);
		mi_new.setBackground(background);
		mi_new.addActionListener(this);
		
		mi_close=new JMenuItem("Close",new ImageIcon("Images/closeAccount.png"));
		mi_close.setFont(f1);
		mi_close.setForeground(foreground);
		mi_close.setBackground(background);
		mi_close.addActionListener(this);
		
		m_account.add(mi_new);
		m_account.add(mi_close);
		
		
		m_transaction=new JMenu("Transection");
		m_transaction.setFont(f);
		m_transaction.setForeground(foreground);
		
		mi_deposit=new JMenuItem("Deposit",new ImageIcon("Images/deposit.png"));
		mi_deposit.setFont(f1);
		mi_deposit.setBackground(background);
		mi_deposit.setForeground(foreground);
		mi_deposit.addActionListener(this);
		
		mi_withdrawal=new JMenuItem("Withdrawal",new ImageIcon("Images/withdraw.png"));
		mi_withdrawal.setFont(f1);
		mi_withdrawal.setBackground(background);
		mi_withdrawal.setForeground(foreground);
		mi_withdrawal.addActionListener(this);
		
		m_transaction.add(mi_deposit);
		m_transaction.add(mi_withdrawal);
		
		
		m_information=new JMenu("Information");
		m_information.setFont(f);
		m_information.setForeground(foreground);
		
		mi_about=new JMenuItem("About",new ImageIcon("Images/about.png"));
		mi_about.setFont(f1);
		mi_about.setForeground(foreground);
		mi_about.setBackground(background);
		mi_about.addActionListener(this);
		
		mi_help=new JMenuItem("Help",new ImageIcon("Images/help.png"));
		mi_help.setFont(f1);
		mi_help.setForeground(foreground);
		mi_help.setBackground(background);
		mi_help.addActionListener(this);
		
		m_information.add(mi_about);
		m_information.add(mi_help);
		
		
		jmb.add(m_system);
		jmb.add(m_account);
		jmb.add(m_transaction);
		jmb.add(m_information);
	}
	
	public void addInternalFrames()
	{
		viewDetails = new ViewDetails(con);
		dp.add(viewDetails);
		
		newAccount = new NewAccount(con);
		dp.add(newAccount);
		
		closeAccount = new CloseAccount(con);
		dp.add(closeAccount);
		
		deposit = new Deposit(con);
		dp.add(deposit);
		
		withdrawal = new Withdrawal(con);
		dp.add(withdrawal);
	}
	
	private void ABOUT()
	{
		DIALOG_ABOUT.setSize(400,450);
		DIALOG_ABOUT.setLocation(300,100);
		DIALOG_ABOUT.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		DIALOG_ABOUT.getContentPane().setLayout(null);
		DIALOG_ABOUT.getContentPane().setBackground(new Color(227,114,58));
		DIALOG_ABOUT.setResizable(false);
		DIALOG_ABOUT.setIconImage(new ImageIcon("Images/About.png").getImage());
		
		Font FONT_LABEL = new Font("Calibri (Body)",Font.BOLD,15);
		Font FONT_TEXT = new Font("Times New Roman (Body)",Font.PLAIN,18);
		
		JTextArea DIALOG_ABOUT_DEVELOPER=new JTextArea("\n Developed By Deepak Mathur   ");
		DIALOG_ABOUT_DEVELOPER.append("  Banking  System  is  developed   in  JAVA. It   can   maintain  Account    holder's  details   and  their deposited  ammount    details. In this application we can also close an account,   we   can   deposit   and   withdrawal ammount from any account.");
		DIALOG_ABOUT_DEVELOPER.setLineWrap(true);
		DIALOG_ABOUT_DEVELOPER.setForeground(Color.white);
		DIALOG_ABOUT_DEVELOPER.setBackground(new Color(227,114,58));
		DIALOG_ABOUT_DEVELOPER.setEditable(false);
		DIALOG_ABOUT_DEVELOPER.setFont(FONT_TEXT);
		DIALOG_ABOUT.getContentPane().add(DIALOG_ABOUT_DEVELOPER);
		DIALOG_ABOUT_DEVELOPER.setBounds(0,0,400,290);
		
		JLabel DIALOG_ABOUT_LOGO=new JLabel(new ImageIcon("Images/GrrasLogoMini.png"));
		DIALOG_ABOUT.getContentPane().add(DIALOG_ABOUT_LOGO);
		DIALOG_ABOUT_LOGO.setBounds(0,300,100,100);
		
		JTextArea DIALOG_ABOUT_GRRAS=new JTextArea("");
		DIALOG_ABOUT_GRRAS.setLineWrap(true);
		DIALOG_ABOUT_GRRAS.setForeground(Color.CYAN);
		DIALOG_ABOUT_GRRAS.setBackground(new Color(227,114,58));
		DIALOG_ABOUT_GRRAS.setEditable(false);
		DIALOG_ABOUT_GRRAS.setFont(FONT_LABEL);
		DIALOG_ABOUT.getContentPane().add(DIALOG_ABOUT_GRRAS);
		DIALOG_ABOUT_GRRAS.setBounds(110,300,280,100);
		
	}
	
	private void HELP()
	{
		DIALOG_HELP.setSize(400,150);
		DIALOG_HELP.setLocation(300,100);
		DIALOG_HELP.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		DIALOG_HELP.getContentPane().setLayout(null);
		DIALOG_HELP.getContentPane().setBackground(new Color(227,114,58));
		DIALOG_HELP.setResizable(false);
		DIALOG_HELP.setIconImage(new ImageIcon("Images/help.png").getImage());
		
		Font FONT_LABEL = new Font("Calibri (Body)",Font.BOLD,13);
		
		JLabel DIALOG_HELP_LOGO=new JLabel(new ImageIcon("Images/GrrasLogoMini.png"));
		DIALOG_HELP.getContentPane().add(DIALOG_HELP_LOGO);
		DIALOG_HELP_LOGO.setBounds(0,0,100,150);
		
		JTextArea DIALOG_HELP_GRRAS=new JTextArea("");
		DIALOG_HELP_GRRAS.setLineWrap(true);
		DIALOG_HELP_GRRAS.setForeground(Color.green);
		DIALOG_HELP_GRRAS.setBackground(new Color(227,114,58));
		DIALOG_HELP_GRRAS.setEditable(false);
		DIALOG_HELP_GRRAS.setFont(FONT_LABEL);
		DIALOG_HELP.getContentPane().add(DIALOG_HELP_GRRAS);
		DIALOG_HELP_GRRAS.setBounds(120,0,280,150);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==mi_view)
		{
			viewDetails.setVisible(true);
		}
		
		else if(e.getSource()==mi_new)
		{
			newAccount.setVisible(true);
		}
		
		else if(e.getSource()==mi_close)
		{
			closeAccount.setVisible(true);
		}
		
		else if(e.getSource()==mi_deposit)
		{
			deposit.setVisible(true);
		}
		
		else if(e.getSource()==mi_withdrawal)
		{
			withdrawal.setVisible(true);
		}
		
		else if(e.getSource()==mi_about)
		{
			DIALOG_ABOUT.setVisible(true);
		}
		
		else if(e.getSource()==mi_help)
		{
			DIALOG_HELP.setVisible(true);
		}
		
		else if(e.getSource()==mi_exit)
		{
			int a = JOptionPane.showConfirmDialog(this,"Do you want to exit","Confirm",JOptionPane.YES_NO_OPTION);
			if(a==JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}
	}
	
	public static void main (String[] args) 
	{
		BankingSystem bs = new BankingSystem();
	}
}