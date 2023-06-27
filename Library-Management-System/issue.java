import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
public class issue extends JFrame implements ActionListener
{
JLabel l1,l3,l4,l5,l7;
JTextField t2;
JButton b1,b2,b3,b4,b5,b6;
JComboBox c1,c2,c3,c4;
Statement st;
Connection con=null;
Color col=null;
Color col1=null;
Color col2=null;

ResultSet rs1,rs2,rs3;
public issue()
{
Container d=getContentPane();
d.setLayout(null);

l1=new JLabel("Issue",JLabel.CENTER);
Font f=new Font("Times New Roman",Font.BOLD,30);
l1.setFont(f);


l3=new JLabel("IssueDate");
l4=new JLabel("MemID");
l5=new JLabel("BookID");
l7=new JLabel(new ImageIcon("issuebg.png"),JLabel.CENTER);

t2=new JTextField(20);
c1=new JComboBox();
c2=new JComboBox();
c3=new JComboBox();
c4=new JComboBox();
b1=new JButton("Clear");
b2=new JButton("Save");
b3=new JButton("Exit");
b5=new JButton(new ImageIcon("home.png"));
f=new Font("Times New Roman",Font.BOLD,22);
t2.setFont(f);
l3.setFont(f);
l4.setFont(f);
l5.setFont(f);
c1.setFont(f);
c2.setFont(f);
c3.setFont(f);
c4.setFont(f);

b1.setFont(f);
b2.setFont(f);
b3.setFont(f);

try
 {
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  con=DriverManager.getConnection("Jdbc:Odbc:mydsn","","");
  st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
  rs1=st.executeQuery("Select * from Book where status='Library'");
rs1.first();
do
{
c3.addItem(rs1.getInt("bookid")+"");
c4.addItem(rs1.getString("BookTitle"));
}while(rs1.next());

  rs3=st.executeQuery("Select * from member");

rs3.first();
do
{
c1.addItem(rs3.getInt("memberid")+"");
c2.addItem(rs3.getString("membername"));
}while(rs3.next());

GregorianCalendar gg=new GregorianCalendar();
t2.setText(gg.get(Calendar.YEAR)+"-"+(gg.get(Calendar.MONTH)+1)+"-"+gg.get(Calendar.DAY_OF_MONTH));


c1.addItemListener(new ItemListener(){
public void itemStateChanged(ItemEvent tt){
c2.setSelectedIndex(c1.getSelectedIndex());
}});
c2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
c1.setSelectedIndex(c2.getSelectedIndex());
}});

c3.addItemListener(new ItemListener(){
public void itemStateChanged(ItemEvent tt){
c4.setSelectedIndex(c3.getSelectedIndex());
}});

c4.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent tt){
c3.setSelectedIndex(c4.getSelectedIndex());
}});

 }catch(Exception ee){}
l7.setBounds(0,0,1000,600);
 
l1.setBounds(0,30,1000,30);

l4.setBounds(50,150,120,30);
c1.setBounds(170,150,60,30);
c2.setBounds(230,150,220,30);

l5.setBounds(550,150,120,30);
c3.setBounds(670,150,60,30);
c4.setBounds(730,150,220,30);

l3.setBounds(50,250,200,30);
t2.setBounds(250,250,200,30);

b1.setBounds(50,400,233,30);
b2.setBounds(334,400,233,30);
b3.setBounds(667,400,233,30);
b5.setBounds(10,480,50,30);

d.add(l1);
d.add(l3);
d.add(l4);
d.add(l5);
d.add(t2);
d.add(c1);
d.add(c2);
d.add(c3);
d.add(c4);

d.add(b1);
d.add(b2);
d.add(b3);
d.add(b5);
d.add(l7);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b5.addActionListener(this);

 col=new Color(177,54,91);
d.setBackground(col);

col1=new Color(223,202,202);
b1.setBackground(col1);
b2.setBackground(col1);
b3.setBackground(col1);

b5.setBackground(col1);


col2=new Color(255,255,255);
l1.setForeground(col2);

l3.setForeground(col2);
l4.setForeground(col2);
l5.setForeground(col2);


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
	t2.setText("");
	}
	else
	if(tt.getSource()==b2)
	{
try
{
  rs1=st.executeQuery("Select * from BookIssRet");
	rs1.moveToInsertRow();
	rs1.updateInt("BookId",Integer.parseInt((String) c3.getSelectedItem()));
	rs1.updateInt("MemberId",Integer.parseInt((String) c1.getSelectedItem()));
	rs1.updateString("booktitle",((String)c4.getSelectedItem()));
	rs1.updateString("membername",((String)c2.getSelectedItem()));
	java.sql.Date dt=java.sql.Date.valueOf(t2.getText());
    rs1.updateDate("issuedate",dt);
	rs1.insertRow();
	String str1="update book set status='Issue' where bookid=" + Integer.parseInt((String) c3.getSelectedItem());
	PreparedStatement pst1=con.prepareStatement(str1);
	pst1.executeUpdate();
	str1="update member set MemberTotalBook=MemberTotalBook+1 where MemberId="+Integer.parseInt((String) c1.getSelectedItem());
	pst1=con.prepareStatement(str1);
		pst1.executeUpdate();
		
		
	JOptionPane.showMessageDialog(null,"Saved","MYproj",3);
}catch(Exception ee){System.out.println(ee);}
	}
	else
 if(tt.getSource()==b3)
	{
	dispose();
	}
                 else
 if(tt.getSource()==b5)
	{ 
	menu page= new menu();
	dispose();
	}
 }catch(Exception ee){}
}
public static void main(String[]args)
{
issue p=new issue();
}
}
