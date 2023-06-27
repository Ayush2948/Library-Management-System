import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
public class book extends JFrame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6,l7;
JTextField t1,t2,t3,t4,t5;
JButton b1,b2,b3,b4,b5,b6,b7;
ResultSet rs;
Color col=null;
Color col1=null;
Color col2=null;
public book()
{
Container d=getContentPane();
d.setLayout (null);

l1=new JLabel("Book Entry");
l2=new JLabel("Bookid");
l3=new JLabel("Title");
l4=new JLabel("Author");
l5=new JLabel("Public");
l6=new JLabel("Price");

t1=new JTextField(20);
t2=new JTextField(20);
t3=new JTextField(20);
t4=new JTextField(20);
t5=new JTextField(20);

b1=new JButton("Clear");
b2=new JButton("Save");
b3=new JButton("Upd");
b4=new JButton("Sear");
b5=new JButton("Del");
b6=new JButton("Exit");
b7=new JButton(new ImageIcon("home.png"));

Font f=new Font("Times New Roman",Font.BOLD,30);
l1.setFont(f);
f=new Font("Times New Roman",Font.BOLD,22);
l2.setFont(f);
l3.setFont(f);
l4.setFont(f);
l5.setFont(f);
l6.setFont(f);

t1.setFont(f);
t2.setFont(f);
t3.setFont(f);
t4.setFont(f);
t5.setFont(f);

b1.setFont(f);
b2.setFont(f);
b3.setFont(f);
b4.setFont(f);
b5.setFont(f);
b6.setFont(f);


b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);

col=new Color(177,54,91);
d.setBackground(col);

col1=new Color(223,202,202);
b1.setBackground(col1);
b2.setBackground(col1);
b3.setBackground(col1);
b4.setBackground(col1);
b5.setBackground(col1);
b6.setBackground(col1);
b7.setBackground(col1);

col2=new Color(255,255,255);
l1.setForeground(col2);
l2.setForeground(col2);
l3.setForeground(col2);
l4.setForeground(col2);
l5.setForeground(col2);
l6.setForeground(col2);
 


 try
 {
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  Connection con=DriverManager.getConnection("Jdbc:Odbc:mydsn","","");
  Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
 rs=st.executeQuery("Select * from book");
 }catch(Exception ee){}

 
l1.setBounds(400,30,200,30);

l2.setBounds(20,120,150,30);
t1.setBounds(180,120,200,30);
l3.setBounds(410,120,150,30);
t2.setBounds(570,120,330,30);

l4.setBounds(20,180,150,30);
t3.setBounds(180,180,200,30);
l5.setBounds(410,180,150,30);
t4.setBounds(570,180,330,30);

l6.setBounds(20,240,150,30);
t5.setBounds(180,240,200,30);

b1.setBounds(2,350,166,30);
b2.setBounds(168,350,166,30);
b3.setBounds(334,350,166,30);
b4.setBounds(500,350,166,30);
b5.setBounds(666,350,166,30);
b6.setBounds(832,350,166,30);


l7=new JLabel(new ImageIcon("bookbg.png"),JLabel.CENTER);
b7.setBounds(10,480,50,30);


d.add(l1);
d.add(l2);
d.add(l3);
d.add(l4);
d.add(l5);
d.add(l6);

d.add(t1);
d.add(t2);
d.add(t3);
d.add(t4);
d.add(t5);
d.add(b1);
d.add(b2);
d.add(b3);
d.add(b4);
d.add(b5);
d.add(b6);
d.add(b7);
d.add(l7);

l7.setBounds(0,0,1000,600);


setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(1000,600);
setVisible(true);
}
public void actionPerformed(ActionEvent tt)
{
	try
	{
	if(tt.getSource()==b1)
	{
	t1.setText("");
	t2.setText("");
	t3.setText("");
	t4.setText("");
	t5.setText("");
	}
	 else
	if(tt.getSource()==b2)
	{
	rs.moveToInsertRow();
    rs.updateInt("bookid",Integer.parseInt(t1.getText()));
    rs.updateString("booktitle",t2.getText().trim());
	rs.updateString("bookauthor",t3.getText().trim());
	rs.updateString("bookpub",t4.getText().trim());
	rs.updateInt("bookprice",Integer.parseInt(t5.getText()));
	rs.updateString("status","Library");
    rs.insertRow();
	JOptionPane.showMessageDialog(null,"Saved","Book",1);
	}
	else
	if(tt.getSource()==b3)
	{
	rs.updateInt("bookid",Integer.parseInt(t1.getText()));
    rs.updateString("booktitle",t2.getText().trim());
	rs.updateString("bookauthor",t3.getText().trim());
	rs.updateString("bookpub",t4.getText().trim());
	rs.updateInt("bookprice",Integer.parseInt(t5.getText()));
	rs.updateString("status","Library");
    JOptionPane.showMessageDialog(null,"Updated","Book",1);
	}
	else
    if(tt.getSource()==b4)
	{
	int kkk=Integer.parseInt(JOptionPane.showInputDialog("Enter BookID"));	
    boolean flag=false;
	try
	{
	rs.first();
	do
	{
	if(rs.getInt("bookid")==kkk)
	{
	 flag=true;	
     t1.setText(kkk+"");
	 t2.setText(rs.getString("booktitle"));
	 t3.setText(rs.getString("bookauthor"));
	 t4.setText(rs.getString("bookpub"));
	 t5.setText(rs.getString("bookprice"));
	 
	 break;
	}
	}while(rs.next());
	}catch(Exception ef){System.out.println(ef);}	
    if(flag==false)
    JOptionPane.showMessageDialog(null,"BookId provided is not associated with any book from Library","Member",1); 			
    }
	else
	if(tt.getSource()==b5)
	{	
	rs.deleteRow();
	JOptionPane.showMessageDialog(null,"Deleted","Member",1);	
	}
	else
	if(tt.getSource()==b6)
	{
	dispose();
	}
                if(tt.getSource()==b7)
	{ 
	menu page= new menu();
	dispose();
	}
      	}catch(Exception ee){System.out.println(ee);}
	
}
public static void main(String[]args)
{
new book();
}
}


































