import Models.UserInterface;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static Connection cn;

    public static void main(String[] args) throws SQLException {
        UserInterface UI = new UserInterface();
        UI.setVisible(true);
    }
}
