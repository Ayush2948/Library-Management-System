import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
public class finepymnt extends JFrame implements ActionListener
{
  JLabel l1,l2,l3,l4,l5,l6,l7;
  JTextField t1,t2,t3,t4,t5;
  JButton b1,b2,b3,b4,b5;
  Statement st;
Connection con=null;
ResultSet rs1,rs2,rs3;
Color col=null;
Color col1=null;
Color col2=null;
 
  public finepymnt()
{
Container d=getContentPane();
d.setLayout(null);
l1=new JLabel("Fine Payment");
l2=new JLabel("Mem Id");
l3=new JLabel("Mem Name");
l4=new JLabel("Fine Amt");
l5=new JLabel("Pay Amt");
l6=new JLabel("Pay Date");
l7=new JLabel(new ImageIcon("finepymntbg.png"),JLabel.CENTER);
t1=new JTextField(28);
t2=new JTextField(28);
t3=new JTextField(28);
t4=new JTextField(28);
t5=new JTextField(28);

b1=new JButton("Clear");
b2=new JButton("Get Info");
b3=new JButton("Pay");
b4=new JButton("Exit");
b5=new JButton(new ImageIcon("home.png"));


Font f= new Font("Times New Roman",Font.BOLD,26);
l1.setFont(f);
f= new Font("Times New Roman",Font.BOLD,22);
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
try
 {
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  con=DriverManager.getConnection("Jdbc:Odbc:mydsn","","");
  st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
  rs1=st.executeQuery("Select * from payment");
  
  GregorianCalendar gg=new GregorianCalendar();
t5.setText(gg.get(Calendar.YEAR)+"-"+(gg.get(Calendar.MONTH)+1)+"-"+gg.get(Calendar.DAY_OF_MONTH));
 }catch(Exception ee){}
l1.setBounds(400,30,200,30);

l2.setBounds(30,110,100,30);
t1.setBounds(200,110,200,30);
l3.setBounds(450,110,150,30);
t2.setBounds(650,110,300,30);

l4.setBounds(30,190,120,30);
t3.setBounds(200,190,200,30);
l5.setBounds(450,190,150,30);
t4.setBounds(650,190,300,30);

l6.setBounds(30,270,120,30);
t5.setBounds(200,270,200,30);

b1.setBounds(50,350,150,30);
b2.setBounds(300,350,150,30);
b3.setBounds(550,350,150,30);
b4.setBounds(800,350,150,30);
b5.setBounds(10,480,50,30);

l7.setBounds(0,0,1000,600);


col1=new Color(223,202,202);
b1.setBackground(col1);
b2.setBackground(col1);
b3.setBackground(col1);
b4.setBackground(col1);
b5.setBackground(col1);
 col2=new Color(255,255,255);
l1.setForeground(col2);
l2.setForeground(col2);
l3.setForeground(col2);
l4.setForeground(col2);
l5.setForeground(col2);
l6.setForeground(col2);



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
d.add(l7);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);


setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(1000,600);
setVisible (true);
}

public void actionPerformed(ActionEvent tt)
{
	if(tt.getSource()==b1)
{
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");

}
else
	if(tt.getSource()==b2)
{
	int kkk=Integer.parseInt(JOptionPane.showInputDialog("Enter MemberID"));	
    boolean flag=false;
	try
	{
		rs2=st.executeQuery("Select * from member");
  
	rs2.first();
	do
	{
if(rs2.getInt("memberid")==kkk)
	{
	 flag=true;	
     t1.setText(kkk+"");
	 t2.setText(rs2.getString("membername"));
	 t3.setText(rs2.getString("memberfineamt"));
	 t5.setText(rs2.getString("issuedate"));
	 
	 break;
	}
	}while(rs2.next());
	}catch(Exception ef){}	
    if(flag==false)
    JOptionPane.showMessageDialog(null,"Member Id provided is not associated with any member","Member",1); 				
}
else	
	if(tt.getSource()==b3)
{
try
{
rs1=st.executeQuery("Select * from payment");
rs1.moveToInsertRow();
rs1.updateInt("MemberId",Integer.parseInt(t1.getText()));
rs1.updateFloat("PayAmt",Float.parseFloat(t4.getText()));
java.sql.Date dt11=java.sql.Date.valueOf(t5.getText());
rs1.updateDate("PayDate",dt11);
rs1.insertRow();
PreparedStatement pst=con.prepareStatement("update member set MemberFineAmt=MemberFineAmt-? where MemberId=?");
pst.setFloat(1,Float.parseFloat(t4.getText()));
pst.setInt(2,Integer.parseInt(t1.getText()));
int kk=pst.executeUpdate();
  JOptionPane.showMessageDialog(null,"Paid","MyProj",2);
}catch(Exception eeueu){}
  }
else
	if(tt.getSource()==b4)
{
dispose();
}
else
	if(tt.getSource()==b5)
		{ 
	menu page= new menu();
	dispose();
	}
}	

public static  void main(String[]args)
{
new finepymnt ();
}
}