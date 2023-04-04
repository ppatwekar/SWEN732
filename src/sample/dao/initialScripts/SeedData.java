package sample.dao.initialScripts;

import java.sql.*;

public class SeedData {
    public static void main(String[] args) throws SQLException {
        //enter username and password as command line arguments
        String database_username = args[0];
        String database_password = args[1];
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/password_manager",database_username,database_password);

        script(connection);
    }

    /**
     * Creates users table, passwords table and inserts data into users table and passwords table
     * @param connection Connection to the database
     */
    public static void script(Connection connection){
        createUsersTable(connection);
        createPasswordsTable(connection);
        addSeedDataUsersTable(connection);
        addSeedDataPasswordsTable(connection);
    }

    /**
     * Creates users table
     * @param connection Connection to the database
     */
    public static void createUsersTable(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String createTableStatement = "CREATE TABLE users " +
                    "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "email VARCHAR(255) NOT NULL, " +
                    "master_password VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY (id))";

            statement.executeUpdate(createTableStatement);
            System.out.println("Created table users in given database");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds seed data into users table
     * @param connection Connection to the database
     */
    public static void addSeedDataUsersTable(Connection connection){
        try {
            Statement statement = connection.createStatement();

            String insertData = "INSERT INTO users(email, master_password) " +
                    "VALUES (\"p@p.com\", \"passwordify\"), " +
                    "(\"check@mate.com\", \"matecheck\"), " +
                    "(\"swen@732.com\", \"golisano\");";

            statement.executeUpdate(insertData);
            System.out.println("Initial data to user table added");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Creates passwords table
     * @param connection Connection to the database
     */
    public static void createPasswordsTable(Connection connection){
        try {
            Statement s = connection.createStatement();

            String createPasswordsTableStatement = "CREATE TABLE passwords " +
                    "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "user_id INTEGER NOT NULL, " +
                    "label VARCHAR(255) NOT NULL, " +
                    "username VARCHAR(255), " +
                    "password VARCHAR(255) NOT NULL, " +
                    "notes VARCHAR(255), " +
                    "PRIMARY KEY (id), " +
                    "FOREIGN KEY (user_id) REFERENCES users(id));";

            s.executeUpdate(createPasswordsTableStatement);
            System.out.println("Created passwords table in database");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Adds seed data into passwords table
     * @param connection Connection to the database
     */
    public static void addSeedDataPasswordsTable(Connection connection){
        try {
            String sql = "INSERT INTO passwords(user_id, label, username, password, notes) VALUES(?,?,?,?,?)";

            String[][] data = {
                    {"2","test label",null,"testpassword","test notes"},
                    {"1","insta","gram","software",null},
                    {"3","snap","castle","geology",null},
                    {"1","beach",null,"waves",null},
                    {"2","monster","energy","Alfa","romeo"}
            };

            for(String[] d : data){
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setInt(1,Integer.parseInt(d[0]));

                preparedStatement.setString(2,d[1]);

                insertNullHelper(preparedStatement, 3, d, 2);

                preparedStatement.setString(4,d[3]);

                insertNullHelper(preparedStatement, 5, d,4);

                preparedStatement.executeUpdate();
            }


            System.out.println("Inserted password data");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method allows inserting either null or String values into a prepared sql statement
     * @param preparedStatement prepare sql statement that defines a structure for insert
     * @param parameterIndex index at which you want to insert value into sql statement
     * @param tuple data in String array
     * @param dataIndex index of data in String that is to be inserted
     * @throws SQLException yes
     */
    private static void insertNullHelper(PreparedStatement preparedStatement,  int parameterIndex, String[] tuple, int dataIndex) throws SQLException {
        if(tuple[dataIndex] == null){
            preparedStatement.setNull(parameterIndex,Types.NULL);
        }
        else{
            preparedStatement.setString(parameterIndex, tuple[dataIndex]);

        }
    }

}
