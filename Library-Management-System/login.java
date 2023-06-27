import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class login extends JFrame implements ActionListener  
{
JLabel l1,l2,l3,l4,l5;
JTextField t1;
JPasswordField t2;
JButton b1;
ResultSet rs;
int p;
Color col=null;
Color col1=null;
Color col2=null;
public login()
{
Container d=getContentPane();
d.setLayout(null);

l2=new JLabel("USERNAME");
l3=new JLabel("PASSWORD");
l4=new JLabel(new ImageIcon("loginbg.png"),JLabel.CENTER);


t1=new JTextField(28);
t2 = new JPasswordField();

b1=new JButton("LOGIN");

Font f=new Font("Times New Roman",Font.PLAIN,29);
l2.setFont(f);
l3.setFont(f);
t1.setFont(f);
t2.setFont(f);
b1.setFont(f);
l4.setBounds(0,0,800,600);


l2.setBounds(150,250,800,30);
t1.setBounds(350,250,300,30);

l3.setBounds(150,320,200,30);
t2.setBounds(350,320,300,30);

b1.setBounds(300,420,200,30);


d.add(l2);
d.add(l3);
d.add(t1);
d.add(t2);
d.add(b1);
d.add(l4);
col=new Color(177,54,91);
d.setBackground(col);
col1=new Color(223,202,202);
b1.setBackground(col1);
col2=new Color(255,255,255);
l2.setForeground(col2);
l3.setForeground(col2);
t1.setBackground(col2);
t2.setBackground(col2);



b1.addActionListener(this);

try
 {
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  Connection con=DriverManager.getConnection("Jdbc:Odbc:mydsn","","");
  Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
  rs=st.executeQuery("Select * from Login");
 }catch(Exception ee){}

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(800,600);
setVisible(true);
}

		
public void actionPerformed(ActionEvent tt) 
{
String x = t1.getText().trim();
String y = t2.getText().trim();
if(tt.getSource()==b1)
{	
boolean flag=false;
	try
	{
	rs.first();
	do
	{
	if(rs.getString("UserName").equalsIgnoreCase(x) && rs.getString("Password").equals(y))
	{
	flag=true;	
	menu page=new menu();

t2.addKeyListener(new KeyAdapter(){
	public void keyPressed(KeyEvent tt)
	{
		p=tt.getKeyCode();
		if(p==13)
		{
menu page=new menu();	
	dispose();	
	}}});
	
	dispose();
	}
	}while(rs.next());
	}catch(Exception ef){}	
if(flag==false)
       {
        JOptionPane.showMessageDialog(null,"Invalid Username and Password");	
        t1.setText("");
        t2.setText("");
        }
}
}
public static  void main(String[]args)
{
new login(); 
}
}