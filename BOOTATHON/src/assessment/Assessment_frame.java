/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assessment;

import admin.Admin_frame;
import dashboard.Dashboard_frame;
import forum.Forum_frame;
import java.awt.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.FileNameMap;
import java.sql.Connection;
//import java.sql.;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import login.Logins;
import login.Setting_frame;
import query.Query_frame;

/**
 *
 * @author kumar
 */

public class Assessment_frame extends JFrame implements ActionListener,MouseListener,Runnable{
    JFrame f=new JFrame();
    JPanel p1,p2,p3,p4,p5,p6,p7;
    JLabel l1,l2,l3;
    JButton b1,b2,b3,b4,b5,b6,b10,b11,b12,b13,b14,b15,b16;
    JTable t1;
    JTextArea tf1,tf3;
    JTextField tf2;
    JScrollPane sp1,sp2,sp3;
    JLabel lx=new JLabel("hello");
    Color c1=new Color(0,116,217);
    Color c2=new Color(255,102,0);
    Color c3=new Color(255, 255, 255);
    
    DefaultMutableTreeNode TestDocuments=new DefaultMutableTreeNode("TestDocuments");
    JTree jt=new JTree(TestDocuments);
    
    String main_user_name;  //rollno of the user
    String main_name;   //name of the user 
    
    String name;
    String user_name;
    String msg_user;
    String msg_send;
    
    Date start_date;
    Timestamp start_time;
    Date end_date;
    Timestamp end_time;
     
    String test_link;
    String testdetails;
    
    ArrayList<String> fileName=new ArrayList<String>();
    
    public Assessment_frame(String main_user_name, String main_name) throws HeadlessException {
        this.main_user_name = main_user_name;
        this.main_name = main_name;
        
        p1=new JPanel();    //notification panel
        p2=new JPanel();    //head panel
        p3=new JPanel();    //upcoming test panel
        p4=new JPanel();    //completed test panel
        p5=new JPanel();    //test Documents
        p6=new JPanel();    //QnA forum
        //p7=new JPanel();    //Result
        
        l1=new JLabel("Bootcamp");
        l2=new JLabel("Assessment");
        l3=new JLabel("QnA Forum :");
        
        tf1=new JTextArea();
        tf2=new JTextField();
        tf3=new JTextArea();
        
        b1=new JButton("Upcoming Test");
        b2=new JButton("Completed Test");
        b3=new JButton("Test Documents");
        b4=new JButton("QnA Forum");
        b5=new JButton("Results");
        b6=new JButton("Send");
        
        b10=new JButton("Dashboard");
        b11=new JButton("Forum");
        b12=new JButton("Assessment");
        b13=new JButton("Query");
        b14=new JButton("Admin");
        b15=new JButton("Setting");
        b16=new JButton("Logout");
        
        t1=new JTable();
        //t1.setFont(new Font("Verdana",Font.PLAIN,15));
        sp1 =new JScrollPane(t1);
        sp2 =new JScrollPane(tf1);
        sp3 =new JScrollPane(tf3);
                
        p1.setBounds(5,5,250,800);
        p2.setBounds(258,5,730,200);
        p3.setBounds(258, 240,  727, 660);
        p4.setBounds(258, 275,  727, 625);
        p5.setBounds(258, 275,  727, 625);
        p6.setBounds(258, 275,  727, 625);
       
        l1.setBounds(10, 20, 250, 40);
        l2.setBounds( 270, 50, 500, 30);
        l3.setBounds(50, 15, 300, 30);
        lx.setBounds(20, 20, 200, 200);
        
        sp1.setBounds(300, 300, 200, 300);
        
        jt.setBounds(20, 20, 300, 300);
        
        
        b1.setBounds(258, 205, 366, 30);
        b2.setBounds(624, 205, 365, 30);
        b3.setBounds(262, 240, 241, 30);
        b4.setBounds(505, 240, 241, 30);
        b5.setBounds(750, 240, 241, 30);
        b6.setBounds(592, 425, 100, 30);
        
        b10.setBounds(5,120,250 , 30);
        b11.setBounds(5,160,250 , 30);
        b12.setBounds(5,200,250 , 30);
        b13.setBounds(5,240,250 , 30);
        b14.setBounds(5,280,250 , 30);
        b15.setBounds(5,650,250,30);
        b16.setBounds(67,725,126,25);
        
        sp2.setBounds(50, 60, 627, 345);
        tf2.setBounds(50, 425, 500, 30);
        
        sp3.setBounds(10, 10, 705, 505);
        tf1.setLineWrap(true);
        tf1.setWrapStyleWord(true);
        tf3.setLineWrap(true);
        tf3.setWrapStyleWord(true);
        
        sp1.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        sp2.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        sp3.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        
        b1.setFocusPainted(false);
        b2.setFocusPainted(false);
        b3.setFocusPainted(false);
        b4.setFocusPainted(false);
        b5.setFocusPainted(false);
        b6.setFocusPainted(false);
        
        b10.setFocusPainted(false);
        b11.setFocusPainted(false);
        b12.setFocusPainted(false);
        b13.setFocusPainted(false);
        b14.setFocusPainted(false);
        b15.setFocusPainted(false);
        b16.setFocusPainted(false);
        b10.setBorderPainted(false);
        b11.setBorderPainted(false);
        b12.setBorderPainted(false);
        b13.setBorderPainted(false);
        b14.setBorderPainted(false);
        b15.setBorderPainted(false);
        b16.setBorderPainted(false);
        
        p1.setBackground(c1);
        p2.setBackground(c2);
        p3.setBackground(c3);
        p4.setBackground(c3);
        p5.setBackground(c3);
        p6.setBackground(c3);
        //p7.setBackground(c3);
        
        b1.setBackground(c3);
        b2.setBackground(c3);
        b3.setBackground(c3);
        b4.setBackground(c3);
        b5.setBackground(c3);
        
//        b1.setBorder(new RoundedBorder(20));
//        b2.setBorder(new RoundedBorder(20));
//        b3.setBorder(new RoundedBorder(20));
//        b4.setBorder(new RoundedBorder(20));
//        b5.setBorder(new RoundedBorder(20));
        b6.setBorder(new RoundedBorder(20));
        
        b10.setBackground(c1);
        b11.setBackground(c1);
        b12.setBackground(c2);
        b13.setBackground(c1);
        b14.setBackground(c1);
        b15.setBackground(c1);
        b16.setBackground(Color.BLACK);
        
        l1.setForeground(c3);
        l2.setForeground(c3);
        b10.setForeground(c3);
        b11.setForeground(c3);
        b12.setForeground(c3);
        b13.setForeground(c3);
        b14.setForeground(c3);
        b15.setForeground(c3);
        b16.setForeground(c3);
        
        l1.setFont(new Font("Verdana",Font.PLAIN,30));
        l2.setFont(new Font("Verdana",Font.BOLD,30));
        l3.setFont(new Font("Verdana",Font.BOLD,18));
        
        tf1.setFont(new Font("Verdana",Font.PLAIN,14));
        tf2.setFont(new Font("Verdana",Font.PLAIN,14));
        tf3.setFont(new Font("Verdana",Font.BOLD,12));
        
        b1.setFont(new Font("Verdana",Font.PLAIN,17));
        b2.setFont(new Font("Verdana",Font.PLAIN,17));
        b3.setFont(new Font("Verdana",Font.PLAIN,16));
        b4.setFont(new Font("Verdana",Font.PLAIN,16));
        b5.setFont(new Font("Verdana",Font.PLAIN,16));
        b6.setFont(new Font("Verdana",Font.PLAIN,16));
        
        b10.setFont(new Font("Verdana",Font.PLAIN,20));
        b11.setFont(new Font("Verdana",Font.PLAIN,20));
        b12.setFont(new Font("Verdana",Font.PLAIN,20));
        b13.setFont(new Font("Verdana",Font.PLAIN,20));
        b14.setFont(new Font("Verdana",Font.PLAIN,20));
        b15.setFont(new Font("Verdana",Font.PLAIN,20));
        b16.setFont(new Font("Verdana",Font.PLAIN,12));
        
        jt.setFont(new Font("Verdana",Font.PLAIN,16));
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        
        b10.addMouseListener(this);
        b11.addMouseListener(this);
        b12.addMouseListener(this);
        b13.addMouseListener(this);
        b14.addMouseListener(this);
        b15.addMouseListener(this);
        
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreeSelectionModel model=jt.getSelectionModel();
                int x=model.getSelectionRows()[0];
                //System.out.println(x);
                try {
                    Desktop.getDesktop().open(new java.io.File("F:\\BOOTCAMP\\Test cases\\"+ fileName.get(x)));
                } catch (Exception e2) {
                }
                    
            }
        });
        
        f.add(l1);
        f.add(l2);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b10);
        f.add(b11);
        f.add(b12);
        f.add(b13);
        f.add(b14);
        f.add(b15);
        f.add(b16);
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        f.add(p5);
        f.add(p6);
        
        b3.setVisible(false);
        b4.setVisible(false);
        b5.setVisible(false);
                       
        TestDetails_result();
        p3.add(sp3);
        
        //p4.add(lx);
        
        p4.add(jt);
        
        p5.add(l3);
        p5.add(sp2);
        p5.add(tf2);
        p5.add(b6);
        
        p6.add(sp1);
        p6.add(lx);
        
        p3.setVisible(true);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(false);
        //p7.setVisible(false);
        
        p3.setLayout(null);
        p4.setLayout(null);
        p5.setLayout(null);
        p6.setLayout(null);
        //p7.setLayout(null);
        
       
        //f.setResizable(false);
        f.setSize(1000, 800);
        f.setLocationRelativeTo(null);
        
        //f.setBounds(460, 140, 1000, 800);
        f.setBackground(Color.WHITE);
        f.setVisible(true);
        
        b16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            int a=JOptionPane.showConfirmDialog(f,"Are you sure?");  
            
            if(a==JOptionPane.YES_OPTION){  
                f.dispose();
                new Logins();
            } 
        }
        });
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {  
        int a=JOptionPane.showConfirmDialog(f,"Are you sure?");  
        if(a==JOptionPane.YES_OPTION){  
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        } 
        }
        });
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public void mouseClicked(MouseEvent e){
        if(e.getSource()==b10){
            b11.setBackground(c1);
            b12.setBackground(c1);
            b13.setBackground(c1);
            b14.setBackground(c1);
            b15.setBackground(c1);
            b10.setBackground(c2);
            f.dispose();
            new Dashboard_frame(main_user_name, main_name);
        }
        else if(e.getSource()==b11){
            b10.setBackground(c1);
            b12.setBackground(c1);
            b13.setBackground(c1);
            b14.setBackground(c1); 
            b15.setBackground(c1);
            b11.setBackground(c2);
            f.dispose();
            new Forum_frame(main_user_name, main_name).StartThread();
        }
        else if(e.getSource()==b12){
            b10.setBackground(c1);
            b11.setBackground(c1);
            b13.setBackground(c1);
            b14.setBackground(c1);
            b15.setBackground(c1);
            b12.setBackground(c2);
//            f.dispose();
//            new Assessment_frame(main_user_name, main_name);
        }
        else if(e.getSource()==b13){
            b10.setBackground(c1);
            b11.setBackground(c1);
            b12.setBackground(c1);
            b14.setBackground(c1);
            b15.setBackground(c1);
            b13.setBackground(c2);
            f.dispose();
            new Query_frame(main_user_name, main_name).StartThread();
            
        }
        else if(e.getSource()==b14){
            b10.setBackground(c1);
            b11.setBackground(c1);
            b12.setBackground(c1);
            b13.setBackground(c1);
            b15.setBackground(c1);
            b14.setBackground(c2);
            f.dispose();
            new Admin_frame(main_user_name, main_name);
            
        }
        else if(e.getSource()==b15){
            b10.setBackground(c1);
            b11.setBackground(c1);
            b12.setBackground(c1);
            b13.setBackground(c1);
            b14.setBackground(c1);
            b15.setBackground(c2);
            f.dispose();
            new Setting_frame(main_user_name, main_name);
        }
    }
     
    private static class RoundedBorder implements Border {
        private int radius;
        RoundedBorder(int radius) {
            this.radius = radius;
        }
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }
        public boolean isBorderOpaque() {
            return true;
        }
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }   
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1)
        {
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p3.setVisible(true);
            b3.setVisible(false);
            b4.setVisible(false);
            b5.setVisible(false);
            TestDetails_result();
            
        }
        else if(e.getSource()==b2)
        {
            TestDocumnets();
            b3.setVisible(true);
            b4.setVisible(true);
            b5.setVisible(true);
            p4.setVisible(true);
            p5.setVisible(false);
            p6.setVisible(false);
            p3.setVisible(false);
        }
        
        else if(e.getSource()==b3){
            TestDocumnets();
            p3.setVisible(false);
            p4.setVisible(true);
            p5.setVisible(false);
            p6.setVisible(false);
        }
        
        else if(e.getSource()==b4){
            QnAForum();
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(true);
            p6.setVisible(false);
        }
        else if(e.getSource()==b5){
            Results();
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(true);
        }
        else if(e.getSource()==b6){
            msg_send=tf2.getText();
            tf2.setText(null);
            sendMsg();
        }
    }
    
    
    void TestDetails_result(){
        int sno=1;
        testdetails="";
        final String Driver="oracle.jdbc.driver.OracleDriver";
        final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";
        try {
            Class.forName(Driver);
            Connection con=DriverManager.getConnection(connect,"bootathon","admin");
            Statement st=con.createStatement();
            String query="Select * from Test_Details";
            ResultSet rs=st.executeQuery(query);
            

            
            while(rs.next()){
                start_time=rs.getTimestamp("start_time");			     
                end_time=rs.getTimestamp("end_time");
                test_link=rs.getString("test_link");

                if(end_time.after(new Date())){
                    start_date=new Date(start_time.getTime());
                    end_date=new Date(end_time.getTime());
                    testdetails=testdetails+" "+sno+". Starts at: "+String.valueOf(start_date)+"\n" +
                                    "    Ends at: "+String.valueOf(end_date)+"\n" +
                                    "    Test Link: "+test_link+"\n\n";
                    //System.out.println(sno);
                    sno++;
                }
                tf3.setText(testdetails);
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e+" Error Displaying Table");
        }
    }
    
    int fileCount=0;
    
    
    void RecursivePrint(File[] arr,int index,int level)  
     { 
         // terminate condition 
         if(index == arr.length) 
             return; 
           
         // tabs for internal levels 
         for (int i = 0; i < level; i++) 
             System.out.print("\t"); 
           
         // for files 
         if(arr[index].isFile()) {
             //System.out.println(arr[index].getName());
                     fileName.add(arr[index].getName()); 
                     fileCount++;
         }
           
         // for sub-directories 
         else if(arr[index].isDirectory()) 
         { 
             //System.out.println("[" + arr[index].getName() + "]"); 
             
             fileName.add(arr[index].getName());
             fileCount++;
             
             // recursion for sub-directories 
             RecursivePrint(arr[index].listFiles(), 0, level + 1); 
         } 
            
         // recursion for main directory 
         RecursivePrint(arr,++index, level); 
    }
    
    void TestDocumnets(){
        String maindirpath = "F:\\BOOTCAMP\\Test cases"; 
                  
        File maindir = new File(maindirpath); 
           
        if(maindir.exists() && maindir.isDirectory()) 
        { 
            File arr[] = maindir.listFiles(); 
              
            RecursivePrint(arr,0,0);  
       }
        
        
        Iterator xyz=fileName.iterator();
        while(xyz.hasNext()){
            TestDocuments.add(new DefaultMutableTreeNode((String)xyz.next()));
        }
//        for (int i = 0; i <fileCount; i++) {
//            System.out.println(fileName[i]);
//            TestDocuments.add(new DefaultMutableTreeNode(fileName[i]));
//        }
        
        
        //JLabel lt=new JLabel();
        //lt.setBounds(20, 20, 300, 300);
        jt.expandRow(0);
        //p4.add(lt);
    }
       
    void QnAForum(){
        StartThread();
    }
    
    
    
    void Results(){
        System.out.println("dghdfvf");
        int column,average=0,rank=1;
        int test[]=new int[100];
        final String Driver="oracle.jdbc.driver.OracleDriver";
        final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";
        try {
            Class.forName(Driver);
            Connection con=DriverManager.getConnection(connect,"bootathon","admin");
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/complainsystem?","aravindha","admin@123");
            
            Statement st=con.createStatement();
            
            String query="Select * from Student_Results order by average desc";
            ResultSet rs=st.executeQuery(query);
            ResultSetMetaData rsmd=rs.getMetaData(); 
            column =rsmd.getColumnCount()-2;

            DefaultTableModel model=new DefaultTableModel();
            String s1[]={"Test","Mark"};
            model.setColumnIdentifiers(s1);
            t1.setModel(model);
            t1.setFillsViewportHeight(true);
            t1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            
            while(rs.next()){
                System.out.println(rs.getString("user_name"));
              if(rs.getString("user_name").equals(main_user_name)){
                  for (int i = 1; i <= column; i++) {
                      System.out.println(i);
                      test[i]=rs.getInt("test"+i);
                      model.addRow(new Object[] {"test"+i,test[i]});
                  }
                  average=rs.getInt("average");
                  break;
              }
              rank++;
            }
            System.out.println(rank+""+average);
        }
        catch(Exception e)
        {
            System.out.println(e+"Error Displaying Table");
        }    
    }
        
    public void run(){
        while(true){
            try {
                getMsg();
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
    
    void StartThread(){
        new Thread(this).start();
    }
    
    void sendMsg(){
        final String Driver="oracle.jdbc.driver.OracleDriver";
        final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";
        try {
            Class.forName(Driver);
            Connection con=DriverManager.getConnection(connect,"bootathon","admin");
            Statement st=con.createStatement();
            String query="insert into qna_forum values ('"+main_user_name+"','"+main_name+"','"+msg_send+"') ";
            st.executeUpdate(query);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e+" Error Insering msg");
        }
    }
    
    void getMsg(){
        String UserMsg="";
        final String Driver="oracle.jdbc.driver.OracleDriver";
        final String connect="jdbc:oracle:thin:@127.0.0.1:1521:XE";
        try {
            Class.forName(Driver);
            Connection con=DriverManager.getConnection(connect,"bootathon","admin");
            Statement st=con.createStatement();
            String query="Select * from qna_forum";
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next()){
                user_name=rs.getString("user_name");
                name=rs.getString("name");
                msg_user=rs.getString("msg_send");
                UserMsg=UserMsg +" "+ name+" ("+user_name+") : "+msg_user+".\n\n";
            }
            tf1.setText(UserMsg);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e+" Error Displaying Table");
        }
    }
        
        @Override
        public void mouseEntered(MouseEvent e) {  
        }  
        public void mouseExited(MouseEvent e) {  
        }  
        public void mousePressed(MouseEvent e) {  
        }  
        public void mouseReleased(MouseEvent e) {  
        }
    
    
    public static void main(String[] args) {
        new Assessment_frame("18eumc071","Kumaran S");
    }
}
