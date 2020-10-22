

import java.sql.*;

public class SQLiteDatabaseConnectivityforProject {

    public static void main( String args[] ) {

        Connection c = null;
        Statement stmt = null;

//   CREATING TABLE - PROJECTS
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");


            stmt = c.createStatement();
//       Creating a sql string for create table 
            String sql = "CREATE TABLE PROJECTS " +
                    "(PROJECT_ID       TEXT PRIMARY KEY   NOT NULL," +
                    " TITLE            TEXT    			NOT NULL, " +
                    " DESCRIP          TEXT     			NOT NULL, " +
                    " OWNER            TEXT     			NOT NULL, " +
                    " SKILL_RANKING    TEXT     			NOT NULL)";
//       execute the string
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("PROJECTS Table created successfully");

//    CREATING TABLE - STUDENTS
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
//      Creating a sql string for create table 

            String sql = "CREATE TABLE STUDENTS " +
                    "(STUDENT_ID     TEXT PRIMARY KEY    NOT NULL," +
                    " PROGRAMMING    INT    			NOT NULL, " +
                    " NETWORKING     INT     			NOT NULL, " +
                    " ANALYTICS      INT     			NOT NULL, " +
                    " WEB         	INT     			NOT NULL) ";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("STUDENTS Table created successfully");

//     CREATING TABLE - TEAM
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
//       Creating a sql string for create table 

            String sql = "CREATE TABLE TEAMS " +
                    "(PROJECT_ID 			TEXT PRIMARY KEY    NOT NULL," +
                    " TEAM_MEMBER_1         TEXT    			NOT NULL, " +
                    " TEAM_MEMBER_2         TEXT     			NOT NULL, " +
                    " TEAM_MEMBER_3         TEXT     			NOT NULL, " +
                    " TEAM_MEMBER_4         TEXT     			NOT NULL) ";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("TEAMS Table created successfully");

//      CREATING TABLE - PREFERENCES
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
//        Creating a sql string for create table 

            String sql = "CREATE TABLE PREFERENCES " +
                    "(STUDENT_ID 			TEXT PRIMARY KEY    NOT NULL," +
                    " PREFERENCE_1         TEXT    			NOT NULL, " +
                    " PREFERENCE_2         TEXT     			NOT NULL, " +
                    " PREFERENCE_3         TEXT     			NOT NULL, " +
                    " PREFERENCE_4         TEXT     			NOT NULL) ";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("PREFERENCES Table created successfully");

//      Print contents of PROJECTS
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PROJECTS;" );

//    	      print results for each row 
            while ( rs.next() ) {
                String id = rs.getString("project_id");
                String  title = rs.getString("title");
                String descrip  = rs.getString("descrip");
                String  owner = rs.getString("owner");
                String skill = rs.getString("salary");

                System.out.println( "PROJECT_ID = " + id );
                System.out.println( "TITLE = " + title );
                System.out.println( "DESCRIP = " + descrip );
                System.out.println( "OWNER = " + owner );
                System.out.println( "SKILL_RANKING = " + skill );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully - PROJECTS");


//         Print contents of STUDENTS
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM STUDENTS;" );
//    	      print results for each row 

            while ( rs.next() ) {
                String id = rs.getString("student_id");
                int  p = rs.getInt("programming");
                int n  = rs.getInt("networking");
                int  a = rs.getInt("analytics");
                int w = rs.getInt("web");

                System.out.println( "STUDENT_ID = " + id );
                System.out.println( "PROGRAMMING = " + p );
                System.out.println( "NETWORKING = " + n );
                System.out.println( "ANALYTICS = " + a );
                System.out.println( "WEB = " + w );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully - STUDENT");


//       Print contents of preferences
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PREFENCES;" );
//    	      print results for each row 

            while ( rs.next() ) {
                String id = rs.getString("student_id");
                String  preference_1 = rs.getString("preference_1");
                String preference_2  = rs.getString("preference_2");
                String  preference_3 = rs.getString("preference_3");
                String preference_4 = rs.getString("preference_4");

                System.out.println( "STUDENT_ID = " + id );
                System.out.println( "PREFERENCE_1 = " + preference_1 );
                System.out.println( "PREFERENCE_2 = " + preference_2 );
                System.out.println( "PREFERENCE_3 = " + preference_3 );
                System.out.println( "PREFERENCE_4 = " + preference_4 );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully - PREFERENCES");



//         Print contents of teams
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PREFERENCES;" );
//    	      print results for each row 

            while ( rs.next() ) {
                String id = rs.getString("project_id");
                String  team_member_1 = rs.getString("team_member_1");
                String team_member_2  = rs.getString("team_member_2");
                String  team_member_3 = rs.getString("team_member_3");
                String team_member_4 = rs.getString("team_member_4");

                System.out.println( "PROJECT_ID = " + id );
                System.out.println( "TEAM_MEMBER_1 = " + team_member_1 );
                System.out.println( "TEAM_MEMBER_2 = " + team_member_2 );
                System.out.println( "TEAM_MEMBER_3 = " + team_member_3 );
                System.out.println( "TEAM_MEMBER_4 = " + team_member_4 );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully - TEAMS");


//        Print contents of SHORTLISTPROJECTS
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM SHORTLISTPROJECTS;" );
//    	      print results for each row 

            while ( rs.next() ) {
                String id = rs.getString("project_id");
                String  title = rs.getString("title");
                String descrip  = rs.getString("descrip");
                String  owner = rs.getString("owner");
                String skill = rs.getString("salary");

                System.out.println( "ID = " + id );
                System.out.println( "TITLE = " + title );
                System.out.println( "DESCRIP = " + descrip );
                System.out.println( "OWNER = " + owner );
                System.out.println( "SKILL_RANKING = " + skill );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully - SHORTLISTPROJECTS");


    }
}


