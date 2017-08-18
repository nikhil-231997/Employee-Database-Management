import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class DeleteFrame extends JFrame
{
	Container c;
	JLabel lblId;
	JTextField txtId;
	JButton btnSave,btnBack;
	JPanel p1,p2;


	DeleteFrame()
	{
		/*Gives Content Area of jframe*/


		c=getContentPane();		

		/*Creating Panel 1*/

		p1=new JPanel();
		lblId=new JLabel("ID");
		txtId=new JTextField(5);

		p1.add(lblId);
		p1.add(txtId);
		c.add(p1);

		/*Creating Panel 2*/

		p2=new JPanel();
		btnSave=new JButton("Delete");
		btnBack=new JButton("Back");
		p2.add(btnSave);
		p2.add(btnBack);

		c.add("South",p2);

		//Connecting with database

		btnSave.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent ae)
			{
				String i=txtId.getText();
				
				//Validation

				if(i.length()==0)
				{
					JOptionPane.showMessageDialog(new JDialog(),"id is empty");
					txtId.requestFocus();
					return;
				}

				DatabaseHandler d=new DatabaseHandler();
				d.deleteEmployee(Integer.parseInt(i));
				txtId.setText("");
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
		setTitle("Delete Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	
}