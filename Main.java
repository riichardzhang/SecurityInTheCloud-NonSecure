import java.sql.*;

public class Main {
    
    public static void main(String[] args) {
        
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                .getConnection("jdbc:postgresql://db-something-awesome-nonsecure.cfxcvhekhi6q.ap-southeast-2.rds.amazonaws.com:5432/nonsecure",
                "postgres", "password123");
            
            while (true) {
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery("SELECT * from customer_data;");
            
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
            
                while (rs.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
                    }
                    System.out.println("");
            }
            
            rs.close();
            st.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
