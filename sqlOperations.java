import java.sql.*;
import java.util.Scanner;
public class sqlOperations {


    public void printEmployee(Connection sqlConn){

        try{
            Statement statement = sqlConn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employee");

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+ " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }
        }

        catch(Exception e){
            System.out.println(e);
        }

    }

    public void printClient(Connection sqlConn){

        try{
            Statement statement = sqlConn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from client");

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+ " " + resultSet.getString(2));
            }
        }

        catch(Exception e){
            System.out.println(e);
        }

    }


    public void printProject(Connection sqlConn){

        try{
            Statement statement = sqlConn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from project");

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+ " " + resultSet.getString(2) + " " + resultSet.getInt(3));
            }
        }

        catch(Exception e){
            System.out.println(e);
        }

    }

    public void printTeam(Connection sqlConn){

        try{
            Statement statement = sqlConn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from team");

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+ " " + resultSet.getString(2) + " " + resultSet.getInt(3));
            }
        }

        catch(Exception e){
            System.out.println(e);
        }

    }





    //ADD RECORD FUNCTIONS
    // addEmployee(Connection)
    //addClient(Connection)
    //addProject(Connection)
    //addTeam(Connection)
    public void addEmployee(Connection sqlConn){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Employee ID: ");
        int empID = Integer.parseInt(keyboard.nextLine());
        System.out.print("\nEmployee Name: ");
        String Name = keyboard.nextLine();
        System.out.print("\nEmployee Job Title: ");
        String Job_Title = keyboard.nextLine();
        System.out.print("\nEmployee Salary: ");
        int Salary = keyboard.nextInt();

        try {
            Statement statement = sqlConn.createStatement();

            statement.executeUpdate("INSERT INTO employee (idEMPLOYEE, Name, Job_title, Salary)" +
                    "\nVALUES(" + empID + ", '" + Name + "', '" + Job_Title + "', " + Salary + ");");
            System.out.println("Employee: " + empID + " successfully added.");

        }

        catch(Exception e){
            System.out.println(e);
        }

    }

    public void addClient(Connection sqlConn){

        Scanner keyboard = new Scanner(System.in);
        advancedOp cmAssign = new advancedOp();

        System.out.print("Client ID: ");
        int clientID = Integer.parseInt(keyboard.nextLine());
        System.out.print("Client Name: ");
        String cName = keyboard.nextLine();

        try {
            Statement statement = sqlConn.createStatement();
            String sqlStatement = ("INSERT INTO client (idCLIENT, Name)" +
                    "\nVALUES(" + clientID + ", " + cName + ");");
            statement.executeUpdate(sqlStatement);
            System.out.println("Client " + clientID + " successfully added.");

            cmAssign.clientManager(sqlConn);
        }

        catch(Exception e){
            System.out.println(e);
        }

    }

    public void addProject(Connection sqlConn){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Project ID: ");
        int idProj = Integer.parseInt(keyboard.nextLine());

        System.out.print("Project Name: ");
        String Name = keyboard.nextLine();

        System.out.print("Project Status: ");
        int status = Integer.parseInt(keyboard.nextLine());


        try {
            Statement statement = sqlConn.createStatement();
            String sqlStatement = ("INSERT INTO project (idPROJECT, Name, status)" +
                    "\nVALUES(" + idProj + ", '" + Name + "', " + status +");");
            statement.executeUpdate(sqlStatement);
        }

        catch(Exception e){
            System.out.println(e);
        }

    }

    public void addTeam(Connection sqlConn){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Team ID: ");
        int idTeam = Integer.parseInt(keyboard.nextLine());

        System.out.print("Team Name: ");
        String Name = keyboard.nextLine();

        System.out.print("Active Projects: ");
        int actives = Integer.parseInt(keyboard.nextLine());


        try {
            Statement statement = sqlConn.createStatement();
            String sqlStatement = ("INSERT INTO team (idTeam, Name, Active_projects)" +
                    "\nVALUES(" + idTeam + ", '" + Name + "', " + actives +");");
            statement.executeUpdate(sqlStatement);

            System.out.println("Team " + idTeam + " successfully added.\n");
        }

        catch(Exception e){
            System.out.println(e);
        }

    }






    //RECORD DELETION FUNCTIONS
    public void deleteEmployee(Connection sqlConn){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the id of the Employee you want to delete.\nEmployee ID: ");
        int empID = Integer.parseInt(keyboard.nextLine());

        try {
            Statement statement = sqlConn.createStatement();

            statement.executeUpdate("DELETE FROM employee WHERE idEMPLOYEE = " + empID);
            System.out.println("Employee: " + empID + " deleted successfully.");

        }

        catch(Exception e){
            System.out.println(e);
        }

    }


    public void deleteClient(Connection sqlConn){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the id of the client you want to delete.\nClient ID: ");
        int clientID = Integer.parseInt(keyboard.nextLine());

        try {
            Statement statement = sqlConn.createStatement();

            statement.executeUpdate("DELETE FROM client WHERE idCLIENT = " + clientID);
            System.out.println("Client: " + clientID + " deleted successfully.");

        }

        catch(Exception e){
            System.out.println(e);
        }

    }

    public void deleteProject(Connection sqlConn){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the id of the Project you want to delete.\nProject ID: ");
        int projID = Integer.parseInt(keyboard.nextLine());

        try {
            Statement statement = sqlConn.createStatement();

            statement.executeUpdate("DELETE FROM project WHERE idPROJECT = " + projID);
            System.out.println("Project: " + projID + " deleted successfully.");

        }

        catch(Exception e){
            System.out.println(e);
        }

    }

    public void deleteTeam(Connection sqlConn){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the id of the Team you want to delete.\nTeam ID: ");
        int teamID = Integer.parseInt(keyboard.nextLine());

        try {
            Statement statement = sqlConn.createStatement();

            statement.executeUpdate("DELETE FROM team WHERE idTEAM = " + teamID);
            System.out.println("Project: " + teamID + " deleted successfully.");

        }

        catch(Exception e){
            System.out.println(e);
        }

    }


}
