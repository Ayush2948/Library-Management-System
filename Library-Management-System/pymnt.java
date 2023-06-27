import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
public class pymnt extends JFrame implements ActionListener
{
JLabel l1,l2,l3;
JTextField t1,t2;
JButton b1,b2,b3;
Statement st;
Connection con=null;
ResultSet rs1,rs2,rs3;
public pymnt()
{
Container d=getContentPane();
d.setLayout(null);

l1=new JLabel("Payment",JLabel.CENTER);
Font f=new Font("Times New Roman",Font.BOLD,30);
l1.setFont(f);

l2=new JLabel("Enter Amount");
l3=new JLabel("Fine remaining");

t1=new JTextField(20);
t2=new JTextField(20);

b1=new JButton("Pay");
b2=new JButton("Exit");
b3=new JButton(new ImageIcon("home.png"));
f=new Font("Times New Roman",Font.BOLD,22);
l2.setFont(f);
l3.setFont(f);
t1.setFont(f);
t2.setFont(f);

b1.setFont(f);
b2.setFont(f);
b3.setFont(f);
try
 {
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  con=DriverManager.getConnection("Jdbc:Odbc:mydsn","","");
  st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
  rs1=st.executeQuery("Select * from member");
  }catch(Exception ee){}
  l1.setBounds(0,30,700,30);
  
  l2.setBounds(50,120,300,30);
  t1.setBounds(400,120,200,30);
  
  l3.setBounds(50,210,300,30);
  t2.setBounds(400,210,200,30);
  
  b3.setBounds(50,300,50,30);
  b1.setBounds(250,300,150,30);
  b2.setBounds(450,300,150,30);
  
  d.add(l1);
  d.add(l2);
  d.add(l3);
  d.add(t1);
  d.add(t2);

  d.add(b1);
  d.add(b2);
  d.add(b3);

  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);


  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setSize(700,400);
  setVisible(true);
 }
 public void actionPerformed(ActionEvent tt)
 {
 if(tt.getSource()==b1)
 {
 }
 else
 if(tt.getSource()==b2)
 {
 dispose();
 }
 else
 if(tt.getSource()==b3)
{
 menu page= new menu();
	dispose();
 }
 }
 public static void main(String[]args)
 {
 new pymnt();
 }
 }