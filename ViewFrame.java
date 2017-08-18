import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class ViewFrame extends JFrame
{
	Container c;
	JTextArea taData;
	JScrollPane spData;
	JButton btnBack;
	JPanel p1,p2;

	ViewFrame()
	{
		c=getContentPane();

		/*Creating first panel*/

		p1=new JPanel();
		taData=new JTextArea(3,20);
		taData.setEditable(false);				//USer cannot change the data
		spData=new JScrollPane(taData);
		spData.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spData.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		p1.add(spData);
		c.add(p1);

		/*Creating second panel*/

		p2=new JPanel();
		btnBack=new JButton("Back");
		p2.add(btnBack);
		c.add("South",p2);

		//Connecting with database

		DatabaseHandler d=new DatabaseHandler();
		String data=d.viewEmployee();
		taData.setText(data);

		/*Connecting with MainFrame*/

		btnBack.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent ae)
		{
			MainFrame m=new MainFrame();
			dispose();
		}

		});



		/*Display settings*/

		setSize(500,200);
		setLocationRelativeTo(null);
		setTitle("View Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}




}