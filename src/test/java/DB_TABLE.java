import java.sql.*;
public class DB_TABLE {
    private static final String USER = "K07L0Xp5Ry";
    private static final String PW = "ltq1hrLajX";
    private static final String DB = "K07L0Xp5Ry";
    private static final String PORT = "3306";
    private static final String SERVER = "remotemysql.com";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + SERVER + ":" + PORT, USER, PW);
        //creating_db_table(connection);
        //insert_data(connection,"dog1",1,"breed-1");
        //insert_data(connection,"dog2",2,"breed-2");
        //insert_data(connection,"dog3",1,"breed-3");
        // updateDogByName(connection,"dog3",4);
        //deleteDogByName(connection, "dog2");
        displayDogTable(connection);


        connection.close();

    }

    private static void creating_db_table(Connection c) throws SQLException {
        String s = "CREATE TABLE " + DB + ".`dogs`(`name` VARCHAR(40) NOT NULL, `age` INT NOT NULL,`breed` VARCHAR(30) NOT NULL);";
        c.createStatement().execute(s);
    }

  private static void insert_data(Connection c, String name, int age, String breed) throws SQLException {
        String s = "Insert into " + DB + ".`dogs`(`name`, `age`, `breed`) VALUES ('" + name + "','" + age + "', '" + breed + "');";
        c.createStatement().execute((s));
    }

   private static void updateDogByName(Connection c, String name, int age) throws SQLException {
        String s = "UPDATE `" + DB + "`.`dogs` SET `age`='" + age + "' WHERE `name`='" + name + "';";
        c.createStatement().executeUpdate(s);

    }

    private static void deleteDogByName(Connection con, String name) throws SQLException {
        String s = "DELETE FROM `" + DB + "`.`dogs` WHERE `name`='" + name + "';";
        con.createStatement().execute(s);
    }
   private static void displayDogTable(Connection c) throws SQLException {
        String s="SELECT *FROM "+DB+".dogs;";
      Statement st=c.createStatement();
       ResultSet rs=st.executeQuery(s);
       while(rs.next()){
           String n=rs.getNString("name");
           int a=rs.getInt("age");
           String b=rs.getString("breed");
           System.out.println("name: "+n+" "+"age: "+a+" "+"breed: "+b);

       }
   }
}