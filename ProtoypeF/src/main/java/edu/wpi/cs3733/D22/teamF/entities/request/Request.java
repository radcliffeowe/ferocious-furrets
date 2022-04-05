package edu.wpi.cs3733.D22.teamF.entities.request;

public abstract class Request {

  private String reqID; // id of request
  private String assignedEmpID; // Employee that is assigned the task (First name, Last name)
  private String requesterEmpID; // ID of the employee that requested the task (5 Digit int)
  private String
      nodeID; // nodeID is the key for the location in which the request is directed to (Check
  // Locations.csv for examples)
  private String status; // Status of the request (In Progress or Done)
  // TODO enum
  private String reqType; // Type of request made

  /**
   * @param reqID reqID
   * @param nodeID location node ID
   * @param assignedEmpID requester name
   * @param requesterEmpID requester id
   * @param status request status processing/done
   * @param reqType request tpye Medical/Delivery
   */
  public Request(
      String reqID,
      String nodeID,
      String assignedEmpID,
      String requesterEmpID,
      String status,
      String reqType) {
    this.reqID = reqID;
    this.nodeID = nodeID;
    this.assignedEmpID = assignedEmpID;
    this.requesterEmpID = requesterEmpID;
    this.status = status;
    this.reqType = reqType;
  }

  public String getAssignedEmpID() {
    return assignedEmpID;
  }

  public void setAssignedEmpID(String assignedEmpID) {
    this.assignedEmpID = assignedEmpID;
  }

  public String getRequesterEmpID() {
    return requesterEmpID;
  }

  public void setRequesterEmpID(String requesterEmpID) {
    this.requesterEmpID = requesterEmpID;
  }

  public String getNodeID() {
    return nodeID;
  }

  public void setNodeID(String NodeID) {
    this.nodeID = nodeID;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getReqType() {
    return reqType;
  }

  public void setReqType(String reqType) {
    this.reqType = reqType;
  }

  public String getReqID() {
    return reqID;
  }

  public void setReqID(String reqID) {
    this.reqID = reqID;
  }
}
