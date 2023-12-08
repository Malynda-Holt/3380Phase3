import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;

public class dbConnect {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/holt_company";
        String username = "root";
        String password = "electricblue7";

        try {

            //Establishing connection with DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            //Printing user interface
            String menuTitle = ("===========================================================\n" +
                    "\t\t\t\tMAHNKC Company Database\n" +
                    "===========================================================\n");
            String tableList = ("------------------------TABLES------------------------------" +
                    "\n\t[1] employee\t\t[2] client\t\t[3] projects\t\t[4] team\n");
            String userPrompt = ("");

            Scanner keyboard = new Scanner(System.in);
            int userInput;
            String repeat = "True";

            useDatabase userNav = new useDatabase();

            //Loop will repeat until user no longer wishes to operate on database. Typing "quit" terminates loop.
            while (!repeat.equals("quit")) {

                System.out.print(menuTitle + tableList + userPrompt);
                userInput = keyboard.nextInt();

                //User chooses which table to view
                switch (userInput) {

                    case 1:
                        userNav.navEmployee(connection);
                        break;

                    case 2:
                        userNav.navClient(connection);
                        break;

                    case 3:
                        userNav.navProject(connection);

                    case 4:
                        userNav.navTeam(connection);

                    default:
                        System.out.println("Invalid command.\n");


                }

                //User is prompted to choose to continue
                System.out.println("Do you want to continue: ");
                repeat = keyboard.nextLine();


            }

            //Close connection
            connection.close();
            System.out.println("Success!");


        } catch (Exception e) {
            System.out.println(e);
        }


    }
}