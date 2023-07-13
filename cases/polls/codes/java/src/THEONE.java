//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

import java.util.Scanner;

public class THEONE { //진행할 프로젝트 이름 
    public static void main(String[] args){  
/*     
        final String USER = "root";
        final String PASS = "tbrs00002b";
        final String DB_URL = "jdbc:mysql://localhost/theone";

        try{
            //MySql과 연동시킴
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
            Statement stmt = conn.createStatement();
            
            //select 할 때 executeQuery & insert, update, delete할 때는 executeUpdate
            
           //String Query = "Name, unique_Name, Age, unique_Age, Sex, unique_Sex "
            //            + "from information ";
            //ResultSet rs = stmt.executeQuery(Query);

        } catch(SQLException e){
            e.printStackTrace();

        }
*/
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        while(run){
            System.out.println("P: 설문 | S: 통계 | Q: 종료");
            System.out.print("선택> ");
            //int Num = Integer.parseInt(sc.nextLine());
            String choice = sc.next();

            switch(choice){
                case "P":
                TheOnePolls polls =new TheOnePolls();
                int val =  polls.PollFunction();            
                break;

                case "S":
                TheOneStatics statics =new TheOneStatics();
                val =  statics.StaticFunction(); //1-2-1-3
                break;

                case "Q":
                run = false;
                System.out.println("종료되었습니다.");
                break;

                default:
                System.out.println("다시 입력하세요.");
                break;

            }
        }    

        return; // return 시켜주면 에러표시(빨간줄) 안남

    }
    
}