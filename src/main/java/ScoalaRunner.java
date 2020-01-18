import java.sql.*;

public class ScoalaRunner {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/scoala";
        String user = "root";
        String pass = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from elevi");
            while (rs.next()) {
                int idElev = rs.getInt("idElev");
                String name = rs.getString("numeElev");
                String idClass = rs.getString("idClasa");
                System.out.println(idElev + ", " + name + ", " + idClass);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
