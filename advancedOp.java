import java.sql.*;
import java.util.Scanner;

public class advancedOp {


    public void assignProj(Connection sqlConn){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Project ID: ");
        int idProject = Integer.parseInt(keyboard.nextLine());
        System.out.print("Team ID: ");
        int idTeam = Integer.parseInt(keyboard.nextLine());

        try {
            Statement statement = sqlConn.createStatement();
            String sqlStatement = ("INSERT INTO assign_project (projectID, teamID)" +
                    "\nVALUES(" + idProject + ", " + idTeam + ");");
            statement.executeUpdate(sqlStatement);
            System.out.println("Project assigned.");
        }

        catch(Exception e){
            System.out.println(e);
        }

    }

    public void clientManager(Connection sqlConn){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Client ID: ");
        int c = Integer.parseInt(keyboard.nextLine());

        System.out.print("Client Manager ID: ");
        int cm = Integer.parseInt(keyboard.nextLine());

        try {
            Statement statement = sqlConn.createStatement();
            String sqlStatement = ("INSERT INTO client_manager (idCLIENTMANAGER, idCLIENT)" +
                    "\nVALUES(" + cm + ", " + c + ");");
            statement.executeUpdate(sqlStatement);
            System.out.println("Manager assigned.");
        }

        catch(Exception e){
            System.out.println(e);
        }

    }

    public void Propose(Connection sqlConn, int projectID){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Client ID: ");
        int c = Integer.parseInt(keyboard.nextLine());


        try {
            Statement statement = sqlConn.createStatement();
            String sqlStatement = ("INSERT INTO propose (client, projectID)" +
                    "\nVALUES(" + c + ", " + projectID + ");");
            statement.executeUpdate(sqlStatement);
            System.out.println("Project assigned.");
        }

        catch(Exception e){
            System.out.println(e);
        }

    }

    public void reports(Connection sqlConn){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Emp ID: ");
        int empID = Integer.parseInt(keyboard.nextLine());

        System.out.print("Team ID: ");
        int teamID = Integer.parseInt(keyboard.nextLine());


        try {
            Statement statement = sqlConn.createStatement();
            String sqlStatement = ("INSERT INTO report_to (emp_ID, team_ID)" +
                    "\nVALUES(" + empID + ", " + teamID+ ");");
            statement.executeUpdate(sqlStatement);
            System.out.println("Employee assigned.");
        }

        catch(Exception e){
            System.out.println(e);
        }

    }

    public void teamLead(Connection sqlConn){

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Team ID: ");
        int teamID = Integer.parseInt(keyboard.nextLine());
        System.out.print("Team Lead ID: ");
        int leadID = Integer.parseInt(keyboard.nextLine());


        try {
            Statement statement = sqlConn.createStatement();
            String sqlStatement = ("INSERT INTO report_to (idTEAM_LEAD, idTeam)" +
                    "\nVALUES(" + leadID + ", " + teamID+ ");");
            statement.executeUpdate(sqlStatement);
            System.out.println("Team assigned.");
        }

        catch(Exception e){
            System.out.println(e);
        }

    }


}
