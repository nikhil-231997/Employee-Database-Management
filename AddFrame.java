import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddFrame extends JFrame
{
	Container c;
	JLabel lblId,lblName;
	JTextField txtId,txtName;
	JButton btnSave,btnBack;
	JPanel p1,p2;


	AddFrame()
	{
		/*Gives Content Area of jframe*/


		c=getContentPane();		

		/*Creating Panel 1*/

		p1=new JPanel();
		lblId=new JLabel("ID");
		txtId=new JTextField(5);
		lblName=new JLabel("Name");
		txtName=new JTextField(10);

		p1.add(lblId);
		p1.add(txtId);
		p1.add(lblName);
		p1.add(txtName);
		c.add(p1);

		/*Creating Panel 2*/

		p2=new JPanel();
		btnSave=new JButton("SAVE");
		btnBack=new JButton("Back");
		p2.add(btnSave);
		p2.add(btnBack);

		c.add("South",p2);

		//Connecting with database

		btnSave.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent ae)
			{
				String i=txtId.getText();
				String n=txtName.getText();
				
				//Validation

				if(i.length()==0)
				{
					JOptionPane.showMessageDialog(new JDialog(),"id is empty");
					txtId.requestFocus();
					return;
				}

				if(n.length()==0)
				{
					JOptionPane.showMessageDialog(new JDialog(),"Name is empty");
					txtName.requestFocus();
					return;	
				}

				DatabaseHandler d=new DatabaseHandler();
				d.addEmployee(Integer.parseInt(i),n);
				txtId.setText("");
				txtName.setText("");
				txtId.requestFocus();
				

			}

		});

		/*Connecting with MainFrame*/

		btnBack.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent ae)
		{
			MainFrame a=new MainFrame();
			dispose();										//disposes the current frame
		}


		});

		/*Display settings*/

		setSize(500,150);
		setLocationRelativeTo(null);
		setTitle("Add Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	
}