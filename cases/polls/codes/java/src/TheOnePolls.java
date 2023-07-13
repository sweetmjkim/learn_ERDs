package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TheOnePolls {

    public int PollFunction(){
        final String USER = "root";
        final String PASS = "tbrs00002b";
        final String DB_URL = "jdbc:mysql://localhost/theone";
        
        
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("설문조사를 시작합니다."); 
   
                try{
                    //MySql과 연동시킴
                    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement();

                    //table information의 col인 Name과 unique_Name 입력받기
                    System.out.print("이름을 입력하세요> ");
                    String Name=scan.next();

                    System.out.print("unique_Name 값을 설정해 주세요> ");
                    String unique_Name = scan.next();
                    System.out.println("------------------------------------------------------------------");

                    String Query =  "insert into information values(' " + Name + "', '" + unique_Name + "') ";   
                    stmt.executeUpdate(Query);               
                    //select
                    Query = "select Name, unique_Name "
                           + "from information ";
                    ResultSet rs = stmt.executeQuery(Query);   

                    
                   //결과값 확인d
                    while(rs.next()){
                       System.out.println("Name: " + rs.getString("Name"));
                       System.out.println("unique_Name: " + rs.getString("unique_Name"));
                   }
                   //------------------------------------------INFORMATION 완료

                    Query = "insert into question(unique_Q, QUESTION) " 
                                     + "values ('1', 'Q.스마트인재개발원의 위치에 대해서 만족하는가?')"; 
                    stmt.executeUpdate(Query); 

                

                    Query = "insert into question(unique_Q, QUESTION) " 
                                     + "values ('2', 'Q.스마트인재개발원에서 제공하는 복지(간식 등)에 대해서 만족하는가?')"; 
                                     
                     stmt.executeUpdate(Query); 

                     Query = "insert into question(unique_Q, QUESTION) " 
                                     + "values ('3', 'Q.스마트인재개발원은 방역시스템이 잘 이루어져 있다고 생각하는가?')"; 
   
                     stmt.executeUpdate(Query); 

                     Query = "insert into question(unique_Q, QUESTION) " 
                                     + "values ('4', 'Q.스마트인재개발원에서 진행하는 교육과정에 대해서 만족하는가?')"; 
   
                     stmt.executeUpdate(Query);
   
                    Query = "select unique_Q, QUESTION " 
                            + "from question " ;
                            
                    ResultSet rs2 = stmt.executeQuery(Query); //

   
                    while (rs2.next()){ //반복이 안됨
                    System.out.println("QUESTION: " + rs2.getString("QUESTION"));
                    //System.out.println("unique_Q: " + rs2.getString("unique_Q"));

                    String str = String.format("%s%s%s%s", "1.그렇다 ", "2.그저그렇다 ", "3.그렇지않다 ", "4.잘 모르겠다");
                    System.out.println(str);


                    System.out.print("답변> ");
                    String unique_A = scan.next(); 
                    System.out.println(unique_A + "번을 선택하셨습니다.");

                    //System.out.println("unique_Q: " + rs2.getString("unique_Q"));
                    }
/* 
                    Query = "insert into final(unique_Name, unique_Q, unique_A) "  
                    + "values (' " + unique_Name + "', " + '1' + ", '"  +  "' ) ";
                    val = stmt.executeUpdate(Query);
*/
                    Query = "select unique_Name, unique_Q, unique_A " + "from final ";
                    ResultSet rs3 = stmt.executeQuery(Query); 
                    while (rs3.next()) {
                    System.out.print("unique_Name: " + rs3.getString("unique_Name"));
                    System.out.print(", unique_Q: " + rs3.getString("unique_Q"));
                    System.out.print(", unique_A: " + rs3.getString("unique_A"));
                   
                    }
                    





//--------------------------------------------------------------------------------------------
                   
                //}
                //--------------------------------------------------------question insert 완료
/* 
                Query = "select unique_Name, unique_Q, unique_A " + "from final ";
            
                Query = "insert into final(unique_Name, unique_Q, unique_A) " + 
                "values ( " + unique_Name + ", " + unique_Q + ", " + unique_A +  " ) ";
                int val2 = stmt.executeUpdate(Query); 

                Query = "select unique_Name, unique_Q, unique_A " + "from final ";
                 ResultSet rs3 = stmt.executeQuery(Query); 
                 while (rs3.next()) {
                 System.out.print("unique_Name: " + rs3.getInt("unique_Name"));
                 System.out.print(", unique_Q: " + rs3.getString("unique_Q"));
                 System.out.print(", unique_A: " + rs3.getInt("unique_A"));
*/

/* 
                     //information
                    //입력받은 table information의 col인 Name과 unique_Name 저장
                    String Query =  "insert into information values(' " + Name + "', '" + unique_Name + "') ";   
                    int val = stmt.executeUpdate(Query);               
                    //select
                    Query = "Name, unique_Name "
                           + "from information ";
                    ResultSet rs = stmt.executeQuery(Query);   
                   //결과값 확인d
                    while(rs.next()){
                       System.out.print("Name: " + rs.getString("Name"));
                       System.out.print("unique_Name: " + rs.getString("unique_Name"));
                   }
                   //------------------------------------------------------------------------------------INFORMATION TABLE 

                     String str = String.format("%s%s%s%s", "1.그렇다 ", "2.그저그렇다 ", "3.그렇지않다 ", "4.잘 모르겠다");
                   
                     System.out.println("Q1.스마트인재개발원의 위치에 대해서 만족하는가?"); 
                     System.out.println(str);
                     System.out.print("답변> ");
                     String unique_A = scan.next(); //unique_A

                     String QUERY = "insert into final(unique_Name, unique_Q, unique_A) " + 
                    "values ( " + unique_Name + ", " + '1' + ", " + unique_A +  " ) ";
                    int val2 = stmt.executeUpdate(QUERY);

                    QUERY = "select unique_Name, unique_Q, unique_A " + "from final ";
                    ResultSet rs2 = stmt.executeQuery(QUERY); 
                    while (rs2.next()) {
                    System.out.print("unique_Name: " + rs2.getInt("unique_Name"));
                    System.out.print(", unique_Q: " + rs2.getString("unique_Q"));
                    System.out.print(", unique_A: " + rs2.getInt("unique_A"));
                    }
                    //------------------------------------------------------------------------FINAL Q.1
                     System.out.println("Q2.스마트인재개발원에서 제공하는 복지(간식 등)에 대해서 만족하는가?");

                     System.out.println(str);
                     System.out.print("답변> ");
                     unique_A = scan.next();

                     System.out.println("Q3.스마트인재개발원은 방역시스템이 잘 이루어져 있다고 생각하는가?");
                     System.out.println(str);
                     System.out.print("답변> ");
                     unique_A = scan.next();

                     System.out.println("Q4.스마트인재개발원에서 진행하는 교육과정에 대해서 만족하는가?");
                     System.out.println(str);
                     System.out.print("답변> ");
                     unique_A = scan.next();
                   */
                     
/* 
                    String Query2 = "select unique_Q, QUESTION " + "from question ";
                    ResultSet rs3 = stmt.executeQuery(Query);
                    while(rs3.next()){
                        System.out.print("unique_Q: " + rs.getString("unique_Q"));
                        System.out.print("QUESTION: " + rs.getString("QUESTION"));
                    }
*/
                    /* 

                    //final
                    String QUERY = "select unique_Name, unique_Q, unique_A " + "from final ";
            
                    QUERY = "insert into final(unique_Name, unique_Q, unique_A) " + 
                    "values ( " + unique_Name + ", " + unique_Q + ", " + unique_A +  " ) ";
                    int val2 = stmt.executeUpdate(QUERY); 

                    QUERY = "select unique_Name, unique_Q, unique_A " + "from final ";
                     ResultSet rs2 = stmt.executeQuery(QUERY); 
                     while (rs2.next()) {
                     System.out.print("unique_Name: " + rs2.getInt("unique_Name"));
                     System.out.print(", unique_Q: " + rs2.getString("unique_Q"));
                     System.out.print(", unique_A: " + rs2.getInt("unique_A"));
            }
   */             
    }
     catch(SQLException e){
                    e.printStackTrace();
   
                }
        }

        return 1;
    }
}