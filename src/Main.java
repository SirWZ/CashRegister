import Models.UserInterface;


import java.sql.*;

public class Main {
    public static Connection cn;

    public static void main(String[] args) throws SQLException {
        UserInterface UI = null;
        try {
            Class.forName("org.postgresql.Driver");
            cn= DriverManager.getConnection("jdbc:postgresql://25.90.246.178:5432/postgres","postgres","shift");
            UI = new UserInterface(cn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        UI.setVisible(true);


    }
}
