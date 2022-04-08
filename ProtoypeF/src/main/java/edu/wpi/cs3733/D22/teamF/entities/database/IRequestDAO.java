package edu.wpi.cs3733.D22.teamF.entities.database;

import edu.wpi.cs3733.D22.teamF.entities.request.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * IRequestDAO is an interface implemented by every service request DAO This allows for the use of
 * the Facade design pattern by the Repository class as well as maintaining the DAO pattern for the
 * individual service requests
 */
public interface IRequestDAO {

  public void initTable() throws SQLException;

  public void add(String assignedID, String requestedID, String nodeID, String status);

  public void delete(String reqID);

  public void update(
      IRequest req,
      String reqID,
      String assignedID,
      String requestedID,
      String nodeID,
      String status);

  public ArrayList<IRequest> get();
}
