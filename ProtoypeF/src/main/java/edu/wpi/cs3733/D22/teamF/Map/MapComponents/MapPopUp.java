package edu.wpi.cs3733.D22.teamF.Map.MapComponents;

import edu.wpi.cs3733.D22.teamF.Map.*;
import edu.wpi.cs3733.D22.teamF.controllers.fxml.StageManager;
import edu.wpi.cs3733.D22.teamF.entities.location.Location;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MapPopUp {
  /**
   * open a fullscreen view of the locations table on the right side of the page
   *
   * @throws IOException
   */
  @FXML
  public static void openFullTable() throws IOException {
    Parent root = FXMLLoader.load(mapPageController.class.getResource("fullLocationPage.fxml"));
    Stage popupwindow = new Stage();
    popupwindow.initModality(Modality.APPLICATION_MODAL);
    Scene scene1 = new Scene(root);
    popupwindow.setScene(scene1);
    popupwindow.showAndWait();
  }

  @FXML
  public static void openHistory() throws IOException, SQLException {
    Parent root = FXMLLoader.load(mapPageController.class.getResource("mapHistoryPage.fxml"));
    Stage popupwindow = new Stage();
    popupwindow.initModality(Modality.APPLICATION_MODAL);
    Scene scene1 = new Scene(root);
    popupwindow.setScene(scene1);
    popupwindow.showAndWait();
  }

  /**
   * Pop up window to add a location to the map After adding a location the table, wipe all icons
   * off the map and redisplay to update with new location
   *
   * @throws IOException
   * @throws SQLException
   */
  public static void popUpAdd() throws IOException, SQLException {
    Parent root = FXMLLoader.load(mapPageController.class.getResource("mapAddPage.fxml"));
    Stage popupwindow = new Stage();
    popupwindow.initModality(Modality.APPLICATION_MODAL);
    Scene scene1 = new Scene(root);
    popupwindow.setScene(scene1);
    popupwindow.initModality(Modality.APPLICATION_MODAL);
    popupwindow.showAndWait();
  }

  /**
   * pop up window to delete a location node After deletion from Locations table, wipe all icons and
   * redisplay to update
   *
   * @throws IOException
   * @throws SQLException
   */
  public static void popUpDelete() throws IOException, SQLException {
    Parent root = FXMLLoader.load(mapPageController.class.getResource("mapDeletePage.fxml"));
    Stage popupwindow = new Stage();
    popupwindow.initModality(Modality.APPLICATION_MODAL);
    Scene scene1 = new Scene(root);
    popupwindow.setScene(scene1);
    popupwindow.showAndWait();
  }

  /**
   * popup window to save location table to external csv file
   *
   * @throws IOException
   */
  public static void popUpSave() throws IOException {
    StageManager.getInstance().setDisplayAndWait("mapBackUpPage.fxml");
  }

  /**
   * popup window to reset the map from an external csv, after upating table, wipe all icons off map
   * and redisplay to update view
   *
   * @throws IOException
   */
  public static void popUpReset(TableView<Location> table, AnchorPane iconPane) throws IOException {
    locTempHolder.setLocationTable(table);
    locTempHolder.setPassIconPane(iconPane);
    Parent root = FXMLLoader.load(mapPageController.class.getResource("mapResetPage.fxml"));
    Stage popupwindow = new Stage();
    popupwindow.initModality(Modality.APPLICATION_MODAL);
    Scene scene1 = new Scene(root);
    popupwindow.setScene(scene1);
    popupwindow.showAndWait();
  }

  public static void popUpLocModify(
      TableView<Location> table, AnchorPane iconPane, Location location)
      throws IOException, SQLException {
    locTempHolder.setLocation(location);
    locTempHolder.setLocationTable(table);
    locTempHolder.setPassIconPane(iconPane);
    Parent root = FXMLLoader.load(mapPageController.class.getResource("mapLocModifyPage.fxml"));
    Stage popupwindow = new Stage();
    popupwindow.initModality(Modality.APPLICATION_MODAL);
    Scene scene1 = new Scene(root);
    popupwindow.setScene(scene1);
    popupwindow.initModality(Modality.APPLICATION_MODAL);
    popupwindow.showAndWait();
  }

  public static void popUpDone(TableView<Location> table, AnchorPane iconPane, Location location)
      throws IOException, SQLException {
    locTempHolder.setLocation(location);
    locTempHolder.setLocationTable(table);
    locTempHolder.setPassIconPane(iconPane);
    Parent root = FXMLLoader.load(mapPageController.class.getResource("mapServiceModifyPage.fxml"));
    Stage popupwindow = new Stage();
    popupwindow.initModality(Modality.APPLICATION_MODAL);
    Scene scene1 = new Scene(root);
    popupwindow.setScene(scene1);
    popupwindow.initModality(Modality.APPLICATION_MODAL);
    popupwindow.showAndWait();
  }

  public static void popUpEquipModify(
      TableView<Location> table, AnchorPane iconPane, Location location)
      throws IOException, SQLException {
    locTempHolder.setLocation(location);
    locTempHolder.setLocationTable(table);
    locTempHolder.setPassIconPane(iconPane);
    Parent root = FXMLLoader.load(mapPageController.class.getResource("mapEquipModifyPage.fxml"));
    Stage popupwindow = new Stage();
    popupwindow.initModality(Modality.APPLICATION_MODAL);
    Scene scene1 = new Scene(root);
    popupwindow.setScene(scene1);
    popupwindow.initModality(Modality.APPLICATION_MODAL);
    popupwindow.showAndWait();
  }
}
