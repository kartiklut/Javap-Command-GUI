import java.lang.reflect.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
class Javap implements ActionListener
{
	JFrame fr;
	JTextArea ta,ta1;
	JComboBox c1; 
	JButton b1,b2;
	String s1[];
	Class c;
	JScrollPane sp;
	Javap()
	{
		try
		{
			fr=new JFrame("JavaPGui");
			fr.setSize(1000,1000);
			fr.setLayout(null);
			ta=new JTextArea();
			ta.setBounds(10,10,200,30);
			fr.add(ta);
			b1=new JButton("Show");
			b1.setBounds(440,10,70,30);
			fr.add(b1);
			b2=new JButton("Clear");
			b2.setBounds(520,10,70,30);
			fr.add(b2);
			String s1[] = { "Methods", "Constructors", "Fields", "Interfaces", "SuperClass" };
			c1 = new JComboBox(s1); 
			c1.setBounds(230,10,200,30);
			fr.add(c1);
			ta1=new JTextArea();
			sp=new JScrollPane(ta1);
			sp.setBounds(10,50,800,800);
			fr.add(sp);
			fr.setVisible(true);
			b1.addActionListener(this);
			b2.addActionListener(this);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		new Javap();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			try
			{
				c=Class.forName(ta.getText());
				System.out.println("Meta object of Class "+c+" Obtained");
				if(c1.getItemAt(c1.getSelectedIndex())=="Methods")
				{
					Method m[]=c.getMethods();
					for(Method m1:m)
					{
						ta1.setText(ta1.getText()+"\n"+m1);
					}
				}
				if(c1.getItemAt(c1.getSelectedIndex())=="Constructors")
				{	
					Constructor cns[]=c.getDeclaredConstructors();
					for(Constructor cns1:cns)
					{
						ta1.setText(""+cns1);
					}
				}
				if(c1.getItemAt(c1.getSelectedIndex())=="Fields")
				{
					Field f[]=c.getFields();
					for(Field f1:f)
					{
						ta1.setText(""+f1);
					}
				}
				if(c1.getItemAt(c1.getSelectedIndex())=="Interfaces")
				{
					Class inter[]=c.getInterfaces();
					for(Class inter1:inter)
					{
						ta1.setText(""+inter1);
					}
				}
				if(c1.getItemAt(c1.getSelectedIndex())=="SuperClass")
				{
					Class sc=c.getSuperclass();
					ta1.setText(""+sc);
				}
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
		if(e.getSource()==b2)
		{
			ta.setText("");
			ta1.setText("");
		}
	}
}