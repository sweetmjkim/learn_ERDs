package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TheOneStatics {
    public int StaticFunction(){
        final String USER = "root";
        final String PASS = "tbrs00002b";
        final String DB_URL = "jdbc:mysql://localhost/theone";

        System.out.println("통계를 시작합니다."); 

        try{
            //MySql과 연동시킴
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
            Statement stmt = conn.createStatement();

            String Query = "select * from information ";
               
            stmt.executeUpdate(Query);
            ResultSet rs = stmt.executeQuery(Query);

            //결과값 확인d
            while(rs.next()){
                System.out.print("Name: " + rs.getString("Name"));
                System.out.print("unique_Name: " + rs.getString("unique_Name"));
            }

        } catch(SQLException e){
            e.printStackTrace();

        }   

        return 2;
    }
}
