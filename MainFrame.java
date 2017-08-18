import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class MainFrame extends JFrame
{
	Container c;
	JButton btnAdd,btnView,btnUpdate,btnDelete;
	MainFrame()
	{

		c=getContentPane();			//Gets Content area of JFrame
		c.setLayout(new FlowLayout());
		

		btnAdd=new JButton("Add");
		btnView=new JButton("View");
		btnUpdate=new JButton("Update");
		btnDelete=new JButton("Delete");


		c.add(btnAdd);
		c.add(btnView);
		c.add(btnUpdate);
		c.add(btnDelete);

		/*Connecting with AddFrame*/

		btnAdd.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent ae)
		{
			AddFrame a=new AddFrame();
			dispose();		//disposes the current frame
		}


		});

		/*Connecting with ViewFrame*/

		btnView.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent ae)
		{
			ViewFrame a=new ViewFrame();
			dispose();		//disposes the current frame
		}


		});

		/*Connecting with UpdateFrame*/

		btnUpdate.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent ae)
		{
			UpdateFrame a=new UpdateFrame();
			dispose();		//disposes the current frame
		}


		});


		/*Connecting with DeleteFrame*/

		btnDelete.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent ae)
		{
			DeleteFrame a=new DeleteFrame();
			dispose();		//disposes the current frame
		}


		});


		/*Display Settings*/

		setSize(500,150);
		setLocationRelativeTo(null);
		setTitle("Employee Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[])
	{
		MainFrame m=new MainFrame(); 
	}
}

//Database Connectivity

class DatabaseHandler
{
	static Connection con;
	
	//Creating Connection

	static void getCon()
	{
		try
		{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","");
		}

		catch(SQLException e)
		{
			System.out.println(e);
		}

	}

	//Creating addEmployee function

	public void addEmployee(int id,String name)
	{
		getCon();
		try
		{
			//Dynamic Insertion
			String sql="insert into employee values(?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,id);
			pst.setString(2,name);
			int r=pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),r+" records inserted");
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog()," inserte issue");	
		}
	}

	//Creating ViewEmployee

	public String viewEmployee()
	{
		getCon();
		StringBuffer sb=new StringBuffer();
		try
		{
			Statement s1=con.createStatement();
			String s2="select * from employee";
			ResultSet rs=s1.executeQuery(s2);
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				sb.append("Id: "+id+" Name: "+name+"\n");
			}
		}
		catch(SQLException e)
		{

		}
		return sb.toString();

	}

	//Creating UpdateEmployee function

	public void updateEmployee(int id,String name)
	{
		getCon();
		try
		{
			//Dynamic Updation
			String sql="UPDATE employee SET name=?"+ "where eid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setInt(2,id);
			
			int r=ps.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),r+" records updated");
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog()," update issue");	
		}
	}

	//Creating DeleteEmployee function

	public void deleteEmployee(int id)
	{
		getCon();
		try
		{
			//Dynamic deletion 
			String sql="Delete from employee where eid= ?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,id);
			
			int r=pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),r+" records deleted");
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog()," delete issue");	
		}
	}
}













