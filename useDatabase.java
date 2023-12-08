import java.sql.*;
import java.util.Scanner;
public class useDatabase {

    public void navEmployee(Connection sqlConn){

        sqlOperations empOperations = new sqlOperations();
        empOperations.printEmployee(sqlConn);

        String basicOperations = ("\n[1] addRecord\t[2] deleteRecord\t[3] viewRecords\n" +
                "------------------------------------------------------------\n\n");
        System.out.println(basicOperations + "\nWhat do you want to do?: ");

        Scanner keyboard = new Scanner(System.in);
        int userChoice = keyboard.nextInt();



        switch(userChoice){

            case 1: empOperations.addEmployee(sqlConn);
            break;

            case 2: empOperations.deleteEmployee(sqlConn);
            break;

            default: return;

        }

        return;

    }

    public void navClient(Connection sqlConn){

        sqlOperations clientOperations = new sqlOperations();
        advancedOp clientConnections = new advancedOp();

        clientOperations.printClient(sqlConn);
        String basicOperations = ("\n[1] addRecord\t[2] deleteRecord\t[3] assignManagers\n" +
                "------------------------------------------------------------\n\n");
        System.out.println(basicOperations + "\nWhat do you want to do?: ");

        Scanner keyboard = new Scanner(System.in);
        int userChoice = keyboard.nextInt();


        switch(userChoice){

            case 1: clientOperations.addClient(sqlConn);
                break;

            case 2: clientOperations.deleteClient(sqlConn);
                break;

            case 3: clientConnections.clientManager(sqlConn);

            default: return;

        }

        return;
    }


    public void navProject(Connection sqlConn){

        sqlOperations projOperations = new sqlOperations();
        advancedOp projConnections = new advancedOp();

        projOperations.printProject(sqlConn);

        String basicOperations = ("\n[1] addRecord\t[2] deleteRecord\t[3] assignProject\n" +
                "------------------------------------------------------------\n\n");
        System.out.println(basicOperations + "\nWhat do you want to do?: ");

        Scanner keyboard = new Scanner(System.in);
        int userChoice = keyboard.nextInt();


        switch(userChoice){

            case 1: projOperations.addProject(sqlConn);
                break;

            case 2: projOperations.deleteProject(sqlConn);
                break;

            case 3: projConnections.assignProj(sqlConn);
                break;

            default: return;

        }

        return;

    }


    public void navTeam(Connection sqlConn){

        sqlOperations tOperations = new sqlOperations();
        advancedOp tConnections = new advancedOp();

        tOperations.printTeam(sqlConn);

        String basicOperations = ("\n[1] addRecord\t[2] deleteRecord\t[3] Assign Reports\t[4] Assign Team Lead\n" +
                "------------------------------------------------------------\n\n");
        System.out.println(basicOperations + "\nWhat do you want to do?: ");

        Scanner keyboard = new Scanner(System.in);
        int userChoice = keyboard.nextInt();


        switch(userChoice){

            case 1: tOperations.addTeam(sqlConn);
                break;

            case 2: tOperations.deleteTeam(sqlConn);
                break;

            case 3: tConnections.reports(sqlConn);
                break;

            case 4: tConnections.teamLead(sqlConn);
                break;

            default: return;

        }

        return;
    }




}
