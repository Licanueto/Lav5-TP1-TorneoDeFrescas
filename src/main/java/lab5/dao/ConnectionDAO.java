package lab5.dao;
import lab5.model.Human;
import java.sql.*;

public class ConnectionDAO {

    private Connection conn;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3307/birraTournament";
    static final String DB_USER = "root";
    static final String DB_PASS = "1234";

    public ConnectionDAO() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("There was a problem connecting with the database.\n" +
                    " Please contact your IT people and give them a really vague and distorted reproduction of what actually went on.");
            ex.printStackTrace();
        }
    }

    public void persist(Human h) {
        if(!(h == null)){// se que la sintaxis es rara pero por alguna razón si no lo escribo así lo subraya. isNull tampoco funca...io que sé
            try {
                PreparedStatement prepSt;
                String st = "INSERT INTO winners (name,amount_ingested) values (?,?);";
                prepSt = conn.prepareStatement(st);
                prepSt.setString(1, h.getName());
                prepSt.setDouble(2, h.getAmountIngested());
                prepSt.execute();
            } catch (SQLException ex) {
                System.out.println("There was a problem writing to the database.\n" +
                        " Please contact your IT people and give them a really vague and distorted reproduction of what actually went on.");
                ex.printStackTrace();
            }
        }
    }
}
