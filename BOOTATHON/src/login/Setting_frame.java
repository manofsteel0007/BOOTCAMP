package login;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.Border;
public class Setting_frame extends JFrame implements MouseListener,ActionListener {
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JLabel l1=new JLabel("Setting");
	JLabel l2=new JLabel("Bootcamp");
	JLabel l3=new JLabel("Name");
	JLabel l4=new JLabel("Roll No");
	JLabel l5=new JLabel("Mobile No");
	JLabel l6=new JLabel("Password");
	JLabel l7=new JLabel("Confirm Password");
	JLabel l8=new JLabel("Invalid mobile no");
	JLabel l9=new JLabel("Invalid password");
	JLabel l10=new JLabel("Password match failed");
	JButton b1=new JButton("edit");
	JButton b2=new JButton("edit");
	JButton b3=new JButton("submit");
	JButton b7=new JButton("Dashboard");
	JButton b8=new JButton("Forum");
	JButton b9=new JButton("Assessment");
	JButton b10=new JButton("Admin");
	JButton b11=new JButton("Setting");
	JButton b12=new JButton("Log out");
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JPasswordField password1=new JPasswordField();
	JPasswordField password2=new JPasswordField();
	Border border=BorderFactory.createLineBorder(Color.black);
	Color c1=new Color(0,116,217);
	Color c2=new Color(255,102,0);
        
        String main_user_name;
        String main_name;
        
	public Setting_frame(String main_user_name,String main_name)
	{
            this.main_user_name=main_user_name;
            this.main_name=main_name;
            
            t1.setText(main_name);
            t2.setText(main_user_name);
            
            t1.setEditable(false);
            t2.setEditable(false);
            
		p1.setBounds(5, 5, 250, 800);
		p2.setBounds(258, 5, 727, 205);
		p3.setBounds(258, 205, 727, 590);
		l1.setBounds(270, 50, 100, 30);
		l2.setBounds(10, 20, 250, 30);
		l3.setBounds(10, 30, 250, 30);
		l4.setBounds(10, 115, 250, 30);
		l5.setBounds(10, 220, 250, 20);
		l6.setBounds(10, 300, 250, 40);
		l7.setBounds(10, 390, 250, 40);
		l8.setBounds(10, 270, 300, 30);
		l9.setBounds(10, 370, 300, 30);
		l10.setBounds(10, 460, 300, 30);
		b1.setBounds(340, 245, 70, 30);
		b2.setBounds(340, 342, 70, 30);
		b3.setBounds(320, 475, 100, 30);
		b7.setBounds(5, 120, 250, 30);
		b8.setBounds(5, 160, 250, 30);
		b9.setBounds(5, 200, 250, 30);
		b10.setBounds(5, 240, 250, 30);
		b11.setBounds(5, 650, 250, 30);
		b12.setBounds(5, 700, 250, 30);
		t1.setBounds(10, 70, 300, 30);
		t2.setBounds(10, 155, 300, 30);
		t3.setBounds(10, 245, 300, 30);
		password1.setBounds(10, 342, 300, 30);
		password2.setBounds(10, 430, 300, 30);
		p1.setBackground(c1);
	    p2.setBackground(c2);
	    l1.setFont(new Font("Verdana",Font.PLAIN,25));
		l2.setFont(new Font("Verdana",Font.PLAIN,30));
		l3.setFont(new Font("Verdana",Font.PLAIN,15));
		l4.setFont(new Font("Verdana",Font.PLAIN,15));
		l5.setFont(new Font("Verdana",Font.PLAIN,15));
		l6.setFont(new Font("Verdana",Font.PLAIN,15));
		l7.setFont(new Font("Verdana",Font.PLAIN,15));
		//l7.setFont(new Font("Verdana",Font.PLAIN,15));
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l8.setForeground(Color.red);
		l9.setForeground(Color.red);
		l10.setForeground(Color.red);
		t1.setBorder(border);
		t2.setBorder(border);
		t3.setBorder(border);
		password1.setBorder(border);
		password2.setBorder(border);
		b1.setFont(new Font("Verdana",Font.PLAIN,15));
		b2.setFont(new Font("Verdana",Font.PLAIN,15));
		b3.setFont(new Font("Verdana",Font.PLAIN,15));
		b7.setFont(new Font("Verdana",Font.PLAIN,20));
		b8.setFont(new Font("Verdana",Font.PLAIN,20));
		b9.setFont(new Font("Verdana",Font.PLAIN,20));
		b10.setFont(new Font("Verdana",Font.PLAIN,20));
		b11.setFont(new Font("Verdana",Font.PLAIN,20));
		b12.setFont(new Font("Verdana",Font.PLAIN,20));
		b1.setBorderPainted(false);
		b2.setBorderPainted(false);
		b3.setBorderPainted(false);
		b7.setBorderPainted(false);
		b8.setBorderPainted(false);
		b9.setBorderPainted(false);
		b10.setBorderPainted(false);
		b11.setBorderPainted(false);
		b12.setBorderPainted(false);
		b1.setFocusPainted(false);
		b2.setFocusPainted(false);
		b3.setFocusPainted(false);
		b7.setFocusPainted(false);
		b8.setFocusPainted(false);
		b9.setFocusPainted(false);
		b10.setFocusPainted(false);
		b11.setFocusPainted(false);
		b12.setFocusPainted(false);
		b1.setForeground(Color.white);
		b2.setForeground(Color.white);
		b3.setForeground(Color.white);
		b7.setForeground(Color.white);
		b8.setForeground(Color.white);
		b9.setForeground(Color.white);
		b10.setForeground(Color.white);
		b11.setForeground(Color.white);
		b12.setForeground(Color.white);
	    p3.setBackground(Color.white);
	    b1.setBackground(c1);
	    b2.setBackground(c1);
	    b3.setBackground(c1);
	    b7.setBackground(c1);
		b8.setBackground(c1);
		b9.setBackground(c1);
		b10.setBackground(c1);
		b11.setBackground(c1);
		b12.setBackground(c1);
		add(l1);
	    add(l2);
		add(b7);
		add(b8);
		add(b9);
		add(b10);
		add(b11);
		add(b12);
	    add(p1);
	    add(p2);
	    add(p3);
	    p3.add(l3);
	    p3.add(l4);
	    p3.add(l5);
	    p3.add(l6);
	    p3.add(l7);
	    p3.add(l8);
	    p3.add(l9);
	    p3.add(l10);
	    p3.add(t1);
	    p3.add(t2);
	    p3.add(t3);
	    p3.add(b1);
	    p3.add(b2);
	    p3.add(b3);
	    p3.add(password1);
	    p3.add(password2);
	    password1.setText("1234567890");
	    password2.setText("1234567890");
	    p3.setLayout(null);
	    l8.setVisible(false);
	    l9.setVisible(false);
	    l10.setVisible(false);
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    b7.addMouseListener(this);
	    b8.addMouseListener(this);
	    b9.addMouseListener(this);
	    b10.addMouseListener(this);
	    b11.addMouseListener(this);
	    b12.addMouseListener(this);
	    this.getContentPane().setBackground(Color.white);
	    setSize(1000,800);
	    setLocationRelativeTo(null);
	    setLayout(null);
            
	    addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {  
                        int a=JOptionPane.showConfirmDialog(new JFrame(),"Are you sure?");  
                        if(a==JOptionPane.YES_OPTION){  
                            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                        } 
                    }
                });
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    
                setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Setting_frame("18eumc071","Kumaran S");

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			t1.setText(main_name);
                        t2.setText(main_user_name);
		}
		if(e.getSource()==b2)
		{
			password1.setText("");
			password2.setText("");
		}
		if(e.getSource()==b3)
		{
			String mobileno=t3.getText();
			String password=new String(password1.getPassword());
			String repassword=new String(password2.getPassword());
			
			if(validation.isValidPhno(mobileno)==true && validation.isValidPassword(password)==true && password.equals(repassword))
			{
                            l8.setVisible(false);
			    l9.setVisible(false);
			    l10.setVisible(false);
                            final String Driver="oracle.jdbc.driver.OracleDriver";
                            final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";
                            try {
                                Class.forName(Driver);
                            Connection con2=DriverManager.getConnection(connect,"bootathon","admin");
		        Statement st2=con2.createStatement();
		        String sql="update registers set password='"+password+"' mobileno='"+mobileno+"'where rollno='"+main_user_name+"'";
		        st2.executeUpdate(sql);
                            } catch (Exception e1) {
                            }
			}
                        
                        else{
                            if(validation.isValidPhno(mobileno)==false)
                            {
				l8.setVisible(true);
//                                l9.setVisible(false);
//                                l10.setVisible(false);
                            }
                            if(validation.isValidPassword(password)==false )
                            {
//				l8.setVisible(false);
                                l9.setVisible(true);
//                                l10.setVisible(false);
                            }
                            else if(!password.equals(repassword))
                            {
//				  l8.setVisible(false);
//                                l9.setVisible(false);
                                l10.setVisible(true);
                            }
                        }
			
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		

		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b7)
		{
	    b7.setBackground(c2);
	    b8.setBackground(c1);
	    b9.setBackground(c1);
	    b10.setBackground(c1);
	    b11.setBackground(c1);
	    b12.setBackground(c1);
	    }
		if(e.getSource()==b8)
		{
	    b7.setBackground(c1);
	    b8.setBackground(c2);
	    b9.setBackground(c1);
	    b10.setBackground(c1);
	    b11.setBackground(c1);
	    b12.setBackground(c1);
	    }

		if(e.getSource()==b9)
		{
	    b7.setBackground(c1);
	    b8.setBackground(c1);
	    b9.setBackground(c2);
	    b10.setBackground(c1);
	    b11.setBackground(c1);
	    b12.setBackground(c1);
	    }

		if(e.getSource()==b10)
		{
	    b7.setBackground(c1);
	    b8.setBackground(c1);
	    b9.setBackground(c1);
	    b10.setBackground(c2);
	    b11.setBackground(c1);
	    b12.setBackground(c1);
	    }

		if(e.getSource()==b11)
		{
	    b7.setBackground(c1);
	    b8.setBackground(c1);
	    b9.setBackground(c1);
	    b10.setBackground(c1);
	    b11.setBackground(c2);
	    b12.setBackground(c1);
	    }
		if(e.getSource()==b12)
		{
	    b7.setBackground(c1);
	    b8.setBackground(c1);
	    b9.setBackground(c1);
	    b10.setBackground(c1);
	    b11.setBackground(c1);
	    b12.setBackground(c2);
	    }
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	


}
