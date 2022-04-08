package edu.wpi.cs3733.D22.teamF.controllers.general;

import edu.wpi.cs3733.D22.teamF.entities.database.*;
import edu.wpi.cs3733.D22.teamF.entities.location.LocationsDAOImpl;
import edu.wpi.cs3733.D22.teamF.entities.medicalEquipment.MedEquipDAOImpl;
import edu.wpi.cs3733.D22.teamF.entities.request.deliveryRequest.equipmentDeliveryRequest.*;
import java.io.IOException;
import java.sql.*;

/**
 * Class for managing instances of the various DAO implementations for the different tables To Use
 * access a DAO call DatabaseManager.getWantedDAO() Uses Singleton Design pattern to ensure only one
 * connection is made to the database
 *
 * @see LocationsDAOImpl
 * @see edu.wpi.cs3733.D22.teamF.entities.database.DatabaseInitializer
 */
public class DatabaseManager {

  private static final Connection conn = DatabaseInitializer.getConnection().getDbConnection();
  private static final LocationsDAOImpl locationsDAO = new LocationsDAOImpl();
  private static final MedDelReqDAOImpl medicalEquipmentDeliveryRequestDAO = new MedDelReqDAOImpl();
  private static final MedEquipDAOImpl medicalEquipmentDAO = new MedEquipDAOImpl();
  private static final labDAOImpl labRequestDAO = new labDAOImpl();
  private static final scanDAOImpl scanRequestDAO = new scanDAOImpl();
  private static final floralDAOImpl floralDAO = new floralDAOImpl();
  private static final giftDAOImpl giftDAO = new giftDAOImpl();
  private static final mealDAOImpl mealDAO = new mealDAOImpl();
  private static final patientDAOImpl patientDAO = new patientDAOImpl();
  private static final medicineDAOImpl medicineDAO = new medicineDAOImpl();

  private static DatabaseManager DatabaseManager;

  private DatabaseManager() {}

  /**
   * inits the dao objects
   *
   * @return DatabaseManager
   * @throws SQLException
   * @throws IOException
   */
  public static DatabaseManager initalizeDatabaseManager() throws SQLException, IOException {
    locationsDAO.initTable("/edu/wpi/cs3733/D22/teamF/csv/TowerLocations.csv");
    medicalEquipmentDeliveryRequestDAO.initTable();
    medicalEquipmentDAO.initTable();
    labRequestDAO.initTable();
    scanRequestDAO.initTable();
    floralDAO.initTable();
    giftDAO.initTable();
    mealDAO.initTable();
    patientDAO.initTable();
    medicineDAO.initTable();
    return Helper.dbMan;
  }

  /**
   * gets the connection object
   *
   * @return Connection
   */
  public static Connection getConn() {
    return conn;
  }
  /**
   * Runs SQL statement
   *
   * @param statement statement to run
   * @throws SQLException if there is an error with the statement (santax, etc)
   */
  public static void runStatement(String statement) throws SQLException {
    Statement stm = conn.createStatement();
    System.out.println("SQL: " + statement);
    try {
      stm.execute(statement);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    stm.close();
  }
  /**
   * Executes query to the apache derby database
   *
   * @param query String to be executed
   * @return return the rset containing the query
   * @throws SQLException when there is a sql problem
   */
  public static ResultSet runQuery(String query) throws SQLException {
    Statement stm = conn.createStatement();
    System.out.println("SQL: " + query);
    try {
      return stm.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    stm.close();
    return null;
  }

  public static void dropTableIfExist(String droppingTable) throws SQLException {
    if (conn.getMetaData().getTables(null, null, droppingTable.toUpperCase(), null).next()) {
      runStatement("DROP TABLE " + droppingTable);
      //      System.out.println("Dropping " + droppingTable + " table!");
    } else {
      //      System.out.println(droppingTable + " table does not Exist!");
    }
  }

  /**
   * Functions to run before exiting the program
   *
   * @throws SQLException
   * @throws IOException
   */
  public static void backUpDatabaseToCSV() throws SQLException, IOException {
    locationsDAO.backUpToCSV("src/main/resources/edu/wpi/cs3733/D22/teamF/csv/TowerLocations.csv");
    medicalEquipmentDAO.saveMedEquipToCSV();
    medicalEquipmentDeliveryRequestDAO.saveRequestToCSV();
    System.out.println("Locations table updated to csv :)");
    System.out.println("MedEquip table updated to csv :)");
    System.out.println("MedicalEquipmentDeliveryRequest table updated to csv :)");
  }

  /**
   * gets the LocatationDAOImpl object Use to use the addLocation, update, delete, etc
   *
   * @return LocationsDAOImpl
   */
  public static LocationsDAOImpl getLocationDAO() {
    return locationsDAO;
  }
  /**
   * gets the MedDelReqDAOImpl object Use to use the addLocation, update, delete, etc
   *
   * @return MedDelReqDAOImpl
   */
  public static MedDelReqDAOImpl getMedEquipDelReqDAO() {
    return medicalEquipmentDeliveryRequestDAO;
  }
  /**
   * Return med equipment DAO object to ad
   *
   * @return medEquipImpl DAO object
   */
  public static MedEquipDAOImpl getMedEquipDAO() {
    return medicalEquipmentDAO;
  }
  /** gets the LabRequestDAO */
  public static labDAOImpl getLabRequestDAO() {
    return labRequestDAO;
  }
  /** gets the scanRequestDAO */
  public static scanDAOImpl getScanRequestDAO() {
    return scanRequestDAO;
  }

  public static mealDAOImpl getMealDAO() {
    return mealDAO;
  }

  public static floralDAOImpl getFloralDAO() {
    return floralDAO;
  }

  public static giftDAOImpl getGiftDAO() {
    return giftDAO;
  }

  public static medicineDAOImpl getMedicineDAO() {
    return medicineDAO;
  }

  public static patientDAOImpl getPatientDAO() {
    return patientDAO;
  }

  /** helper */
  private static class Helper {
    private static final DatabaseManager dbMan = new DatabaseManager();
  }
  /** helper but singleton */
  private static class SingletonHelper {
    private static final DatabaseManager DatabaseManager = new DatabaseManager();
  }
}
