import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
public class rtrn extends JFrame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JTextField t1,t2,t3,t4,t5,t6,t7;
JButton b1,b2,b3,b4,b5,b6;
int a;
String x,y;
Statement st;
Connection con=null;
Color col=null;
Color col1=null;
Color col2=null;
ResultSet rs1,rs2,rs3;
public rtrn()
{
Container d=getContentPane();
d.setLayout(null);

l1=new JLabel("Book Return",JLabel.CENTER);
Font f=new Font("Times New Roman",Font.BOLD,30);
l1.setFont(f);


l2=new JLabel("Book ID");
t1=new JTextField(20);

l3=new JLabel("Title");
t2=new JTextField(20);

l4=new JLabel("Mem ID");
t3=new JTextField(20);

l5=new JLabel("Mem Name");
t4=new JTextField(20);

l6=new JLabel("Issue Date");
t5=new JTextField(20);

l7=new JLabel("Return Date");
t6=new JTextField(20);

l8=new JLabel("Fine Amount");
t7=new JTextField(20);
 l9=new JLabel(new ImageIcon("returnbg.png"));

b1=new JButton("Clear");
b2=new JButton("GetInfo");
b3=new JButton("Save");
b4=new JButton("Exit");
b5=new JButton("Pay Fine");
b6=new JButton(new ImageIcon("home.png"));


f=new Font("Times New Roman",Font.BOLD,22);
t1.setFont(f);
t2.setFont(f);
t3.setFont(f);
t4.setFont(f);
t5.setFont(f);
t6.setFont(f);
t7.setFont(f);


l2.setFont(f);
l3.setFont(f);
l4.setFont(f);
l5.setFont(f);
l6.setFont(f);
l7.setFont(f);
l8.setFont(f);

b1.setFont(f);
b2.setFont(f);
b3.setFont(f);
b4.setFont(f);
b5.setFont(f);
b6.setFont(f);
try
 {
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  con=DriverManager.getConnection("Jdbc:Odbc:mydsn","","");
  st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
  rs1=st.executeQuery("Select * from Bookissret");
rs1.first();
do
{

}while(rs1.next());
 }catch(Exception ee){}
GregorianCalendar gg=new GregorianCalendar();
t6.setText(gg.get(Calendar.YEAR)+"-"+(gg.get(Calendar.MONTH)+1)+"-"+gg.get(Calendar.DAY_OF_MONTH));



l1.setBounds(400,30,200,30);

l2.setBounds(50,110,100,30);
t1.setBounds(200,110,200,30);
l3.setBounds(500,110,100,30);
t2.setBounds(650,110,300,30);

l4.setBounds(50,190,100,30);
t3.setBounds(200,190,200,30);
l5.setBounds(500,190,150,30);
t4.setBounds(650,190,300,30);

l6.setBounds(50,270,150,30);
t5.setBounds(200,270,200,30);
l7.setBounds(500,270,150,30);
t6.setBounds(650,270,300,30);

l8.setBounds(50,350,150,30);
t7.setBounds(200,350,200,30);

b5.setBounds(500,350,200,30);

b1.setBounds(50,430,150,30);
b2.setBounds(300,430,150,30);
b3.setBounds(550,430,150,30);
b4.setBounds(800,430,150,30);

b6.setBounds(50,480,50,30);
d.add(l1);
d.add(l2);
d.add(l3);
d.add(l4);
d.add(l5);
d.add(l6);
d.add(l7);
d.add(l8);


d.add(t1);
d.add(t2);
d.add(t3);
d.add(t4);
d.add(t5);
d.add(t6);
d.add(t7);


d.add(b1);
d.add(b2);
d.add(b3);
d.add(b4);
d.add(b5);
d.add(b6);
d.add(l9);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
l9.setBounds(0,0,1000,600);
 col=new Color(177,54,91);
d.setBackground(col);

col1=new Color(223,202,202);
b1.setBackground(col1);
b2.setBackground(col1);
b3.setBackground(col1);
b4.setBackground(col1);
b5.setBackground(col1);
b6.setBackground(col1);





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
	t7.setText("");
	}
	else
		if(tt.getSource()==b2)
		{
		int kkk=Integer.parseInt(JOptionPane.showInputDialog("Enter Book ID"));	
    boolean flag=false;
	try
	{
rs1=st.executeQuery("Select * from Bookissret where ReturnDate is null");
	rs1.first();
	do
	{
	if(rs1.getInt("bookid")==kkk)
	{
	 flag=true;	
     t1.setText(kkk+"");
	 t2.setText(rs1.getString("booktitle"));
	 t3.setText(rs1.getString("memberid"));
	 t4.setText(rs1.getString("membername"));
	 t5.setText(rs1.getDate("issuedate")+"");
		
	java.sql.Date dt1=java.sql.Date.valueOf(t5.getText());
	java.sql.Date dt2=java.sql.Date.valueOf(t6.getText());
long diff = dt2.getTime() - dt1.getTime();
int days=(int)(diff / (1000 * 60 * 60 * 24));
float fine=0;
if(days>7)
fine=(days-7)*1.25f;
t7.setText(fine+"");
System.out.println(fine);
	 break;
	}
	}while(rs1.next());
	}catch(Exception ef){System.out.println(ef);}	
    if(flag==false)
    JOptionPane.showMessageDialog(null,"Book Id provided is not associated with any member","Member",1); 				
		}
	else
		if(tt.getSource()==b3)
	{

String str11="select * from bookissret where returndate is null and bookid="+Integer.parseInt(t1.getText());
rs1=st.executeQuery(str11);
rs1.first();
	rs1.updateFloat("FineAmt",Float.parseFloat(t7.getText()));
	java.sql.Date dt=java.sql.Date.valueOf(t6.getText());
    rs1.updateDate("returndate",dt);
	rs1.updateRow();
	String str1="update book set status='Library' where bookid=" + Integer.parseInt(t1.getText());
	PreparedStatement pst1=con.prepareStatement(str1);
	pst1.executeUpdate();
	str1="update member set MemberTotalBook=MemberTotalBook-1 where MemberId="+Integer.parseInt(t3.getText());
	pst1=con.prepareStatement(str1);
		pst1.executeUpdate();
		
		
	JOptionPane.showMessageDialog(null,"Saved","MYproj",3);
	}
	else
		if(tt.getSource()==b4)
	{
	dispose();
	}
	else
		if(tt.getSource()==b5)
		{
			pymnt p=new pymnt();
		}
		else
			if(tt.getSource()==b6)
			{
				menu page= new menu();
	dispose();
			}
 }catch(Exception ee){}
}
public static void main(String[]args)
{
rtrn p=new rtrn();
}
}
