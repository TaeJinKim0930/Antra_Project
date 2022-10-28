package orm;


import com.example.university.repository.domain.entity.Student;

import java.sql.*;

public class connection  {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/MyORM";

    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "Oh167044!!";

    public static void main(String[] args) {
        // testing out the connection.
        // if want to test out connection only, extends ormDBconnection in connection class
        // ormDBConnection dbconn = new ormDBConnection();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            //STEP 2: Register JDBC driver -> DriverManager
            Class.forName("org.postgresql.Driver"); //static block
            System.out.println("hh");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + "MyORM",USER,PASS);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");

            conn.setAutoCommit(false);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            // Meaning Used to implement simple SQL statements with no parameters.

            String username = "";
            String password = "****";
            System.out.println("try");
//            String sql1 = "select * from student"; connection with DB confirmed.
            String sql1 = "SELECT * FROM student ";

            // String sql2 = "SELECT * FROM Employees WHERE val1 = not null AND val2 = col2 OR val5 = col5.....";
            /*
             */
            // with prepareStatement, we can set values
            // convert all inputs into a String
            stmt = conn.prepareStatement(sql1);

            ResultSet rs = stmt.executeQuery();

            //STEP 5: Extract data from result set
            //30 columns -> new instance , Student / List<Student> / Set<Student>
            //List<Student> studentList = executeQuery(query);
            while(rs.next()){
                //Retrieve by column name
                String id  = rs.getString("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);

                // have to create new student
                Student std = new Student(id,age,first,last);
                System.out.println(std);
            }

            conn.commit();
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }//end main

}
