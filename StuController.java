package Assignment2;

import java.sql.*; 

public class StuController {
	
	//Variable declaration
	private static StuModel model = new StuModel();
	private StuView view;
	
	//Constructor
	public StuController(StuModel model, StuView view){
		this.model = model;
		this.view = view;
	}
	
	//Read data from database
	public void readData(int studentId) throws SQLException{       
		
		
		
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?" +
			    	                                   "user=root&password=208229");
		// create a Statement from the connection
		Statement statement = conn.createStatement();
		
		// Retrieve results from the table
		ResultSet rs = statement.executeQuery ("Select * from studentmark"); 
		
		// Count columns
		ResultSetMetaData rsmd =rs.getMetaData(); 
		int i =rsmd.getColumnCount( );
				
		// Insert records to Model class
		while(rs.next( ) ) { 
			for(int j=1; j<=i; j++) 
			{ 
				if(Integer.valueOf(rs.getString( 1)) == studentId) {
					if(j == 1)
						model.setId(Integer.valueOf(rs.getString( j)));
					else if(j == 2)
						model.setName(rs.getString( j));
					else if(j == 3)
						model.setMath_mark(Integer.valueOf(rs.getString( j)));
					else if(j == 4)
						model.setSc_mark(Integer.valueOf(rs.getString( j)));
			}}
		}
		updateView();
	}
	
	//Send data to View class
	public void updateView(){                
        view.printStudentMarks(model.getId(), model.getName(), model.getMath_mark(), model.getSc_mark());
     }
	
	//Save data to database
	public void saveData(int id, String name,int math, int science) throws SQLException {
		
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?" +
			    	                                   "user=root&password=208229");
		
		// create a Statement from the connection
		Statement statement = conn.createStatement();
		
		// insert the data into database
		statement.executeUpdate("INSERT INTO studentmark VALUES (" + id + ", '"+ name + "', " + math + ", " + science + ")");
	}
}
