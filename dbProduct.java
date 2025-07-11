import java.sql.*;

public class dbProduct {
    public static void main(String[] args) {
        String url = "jdbc:ucanaccess://D:\\Data Base\\dbProduct1.accdb"; // choose your own directory
        String sql = "SELECT * FROM dbProduct";

        try (
            Connection con = DriverManager.getConnection(url);
            Statement stmt = con.createStatement();
            ResultSet rss = stmt.executeQuery(sql);
        ) {
            while (rss.next()) {
                int id = rss.getInt(1);
                String name = rss.getString(2);
                long price = rss.getLong(3);
                System.out.println(id + "\t" + name + "\t" + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
