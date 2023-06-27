import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class menu extends JFrame implements ActionListener  
{
JMenuBar mb;
JMenu m1,m2;
JMenuItem i1,i2,i3,i4,i5,i6,i7,i8;
JLabel l1;
Color col=null;
Color col1=null;
Color col2=null;

public menu()
{
Container d=getContentPane();
mb=new JMenuBar();
m1=new JMenu("Form ");
m2=new JMenu(" Report");
i1=new JMenuItem("  Book Entry");
i2=new JMenuItem("  Member Entry");
i3=new JMenuItem("  Issue");
i4=new JMenuItem("  Return");
i5=new JMenuItem("  Fine Payment");
i6=new JMenuItem("     Member List");
i7=new JMenuItem("     Book List");
i8=new JMenuItem("     FineAmt List");
l1=new JLabel(new ImageIcon("menu12.png")); 

Font f= new Font ("Times New Roman",Font.BOLD,22);
m1.setFont(f);
m2.setFont(f);

f=new Font("Times New Roman",Font.PLAIN,16);
i1.setFont(f);
i2.setFont(f);
i3.setFont(f);
i4.setFont(f);
i5.setFont(f);
i6.setFont(f);
i7.setFont(f);
i8.setFont(f);

l1.setBounds(0,0,1000,700);

m1.add(i1);
m1.add(i2);
m1.add(i3);
m1.add(i4);
m1.add(i5);
m2.add(i6);
m2.add(i7);
m2.add(i8);
mb.add(m1);
mb.add(m2);
d.add(l1);

i1.addActionListener(this);
i2.addActionListener(this);
i3.addActionListener(this);
i4.addActionListener(this);
i5.addActionListener(this);
i6.addActionListener(this);
i7.addActionListener(this);
i8.addActionListener(this);


col=new Color(177,54,91);
mb.setBackground(col);

col1=new Color(5,126,230);
i1.setBackground(col1);
i2.setBackground(col1);
i3.setBackground(col1);
i4.setBackground(col1);
i5.setBackground(col1);
i6.setBackground(col1);
i7.setBackground(col1);
i8.setBackground(col1);

col2=new Color(255,255,255);
m1.setForeground(col2);
m2.setForeground(col2);
i1.setForeground(col2);
i2.setForeground(col2);
i3.setForeground(col2);
i4.setForeground(col2);
i5.setForeground(col2);
i6.setForeground(col2);
i7.setForeground(col2);
i8.setForeground(col2);

setJMenuBar(mb);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(1000,700);
setVisible(true);
}
public void actionPerformed(ActionEvent tt)
{
if(tt.getSource()==i1)
{
book page= new book();
}
else
if(tt.getSource()==i2)
{
member page= new member();
}
else
if(tt.getSource()==i3)
{
issue page= new issue();
}
else
if(tt.getSource()==i4)
{
rtrn page= new rtrn();
}
else
if(tt.getSource()==i5)
{
finepymnt page= new finepymnt();
}
else
if(tt.getSource()==i6)
{
membertb page= new membertb();
}
else
if(tt.getSource()==i7)
{
booktb page= new booktb();
}
else
if(tt.getSource()==i8)
{
fineamt page= new fineamt();
}
}
public static void main(String[] args)
{
new menu();
}
}