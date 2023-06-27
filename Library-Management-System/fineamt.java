import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
public class fineamt extends JFrame implements ActionListener
{
JLabel l,l7;
JTable tb;
JButton b1;
ResultSet rs;
Statement st=null;
Connection con=null;
Color col=null;
Color col1=null;
Color col2=null;
int r=0;
DefaultTableModel model=null;
public fineamt()
{
Container d=getContentPane();
d.setLayout(null);
l=new JLabel("FineAmt List",JLabel.CENTER);
l7=new JLabel(new ImageIcon("tablebg.png"));
 b1=new JButton(new ImageIcon("home.png"));
b1.addActionListener(this);
Font f=new Font("Times New Roman",Font.BOLD,40);
l.setFont(f);
String hd[]={"MemID","Name","Type","FineAmt"};
  model = new DefaultTableModel(hd, 0);
    tb = new JTable(model);
JScrollPane jsp=new JScrollPane(tb);
jsp.setBounds(100,100,700,250);
l.setBounds(200,20,400,60);
l7.setBounds(0,0,1000,600);
b1.setBounds(10,480,50,30);
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("Jdbc:Odbc:mydsn","","");
st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
rs=st.executeQuery("select * from member where MemberFineAmt>0");
int i=0;
while(rs.next())
{
 model.addRow(
                   new Object[]{
                         rs.getInt("Memberid")+"", 
                         rs.getString("MemberName")+"",
                         rs.getString("MemberType")+"",
		rs.getString("MemberFineAmt")+""
	                   }
              		);
}
}catch(Exception eee){}
 d.add(b1);
d.add(l);
d.add(jsp);
d.add(l7);
addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent tt){
dispose();
}});

addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent tt){
dispose();
}});
col=new Color(177,54,91);
tb.setBackground(col);

col1=new Color(223,202,202);
b1.setBackground(col1);

setSize(1000,600);
setVisible(true);
}
public void actionPerformed(ActionEvent tt)
{
	try
	{    if(tt.getSource()==b1)
	{ 
	menu page= new menu();
	dispose();
	}
      	}catch(Exception ee){}
}
public static void main(String[] args)
{
new fineamt();
}}