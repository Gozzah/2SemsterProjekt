/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.Exceptions.CarportException;
import logic.entities.carport.Carport;

/**
 *
 * @author Runej
 */
public class CarportMapper {

    public static List<Carport> getCarports() throws CarportException {
        List<Carport> carports = new ArrayList();

        try {
            PreparedStatement stmt = DBC.preparedStatement(
                                "SELECT "
                    +"         carportID,carportname, carportWidth,carportLength,carportHeight,roofSlope, "
                    +"         p1.productName as woodType, "
                    +"         p1.productPrice as woodPrice,"
                    +"         p1.productHeight as plankHeight,"
                    +"	       p1.productLength as plankLength,"
                    +"         p3.productName as woodColor,"
                    +"         totalPlankAmount,"
                    +"         plankScrewAmount,"
                    +"         p2.productName as eaveType,"
                    +"         p2.productPrice as eavePrice,"
                    +"         p2.productHeight as eaveWidth,"
                    +"         p2.productLength as eaveLength,"
                    +"         p4.productName as eaveColor,"
                    +"         eaveAmount,"
                    +"         eaveScrewAmount,"
                    +"         totalScrewAmount,"
                    +"         totalPrice "
                    +"                    "
                    +"         FROM Carport"
                    +"                    "
                    +"         JOIN Products as p1 on woodID = p1.productID "
                    +"         JOIN Products as p2 on eaveID =  p2.productID "
                    +"         JOIN Products as p3 on woodColorID = p3.productID "
                    +"         JOIN Products as p4 on eaveColorID = p4.productID;");
            
            
                ResultSet rs = stmt.executeQuery(
                    );

            while (rs.next()) {

                int id = rs.getInt("carportID");
                String carportName = rs.getString("carportName");
                int carportWidth = rs.getInt("carportWidth");
                int carportLength = rs.getInt("carportLength");
                int carportHeight = rs.getInt("carportHeight");
                int roofSlope = rs.getInt("roofSlope");
                String woodType = rs.getString("woodType");
                int woodPrice = rs.getInt("woodPrice");
                int plankHeight = rs.getInt("plankHeight");
                int plankLength = rs.getInt("plankLength");
                String woodColor = rs.getString("woodColor");
                int totalPlankAmount = rs.getInt("totalPlankAmount");
                int plankScrewAmount = rs.getInt("plankScrewAmount");
                String eaveType = rs.getString("eaveType");
                int eavePrice = rs.getInt("eavePrice");
                int eaveWidth = rs.getInt("eaveWidth");
                int eaveLength = rs.getInt("eaveLength");
                String eaveColor = rs.getString("eaveColor");
                int eaveAmount = rs.getInt("eaveAmount");
                int eaveScrewAmount = rs.getInt("eaveScrewAmount");
                int totalScrewAmount = rs.getInt("totalScrewAmount");
                int totalPrice = rs.getInt("totalPrice");

                carports.add(new Carport(id, carportName, carportWidth, carportLength, carportHeight, roofSlope, woodType, woodPrice, plankHeight, plankLength, woodColor, totalPlankAmount, plankScrewAmount, eaveType, eavePrice, eaveWidth, eaveLength, eaveColor, eaveAmount, eaveScrewAmount, totalScrewAmount, totalPrice));

            }

        } catch (SQLException | ClassNotFoundException ex) {

            throw new CarportException(ex.getMessage());

        }
        return carports;
    }
    
      public static List<Carport> getCarportByID(int carportID) throws CarportException {
        List<Carport> carport = new ArrayList();

        try {
            PreparedStatement stmt = DBC.preparedStatement(
                                 "SELECT "
                    +"         carportID,carportname, carportWidth,carportLength,carportHeight,roofSlope, "
                    +"         p1.productName as woodType, "
                    +"         p1.productPrice as woodPrice,"
                    +"         p1.productHeight as plankHeight,"
                    +"	       p1.productLength as plankLength,"
                    +"         p3.productName as woodColor,"
                    +"         totalPlankAmount,"
                    +"         plankScrewAmount,"
                    +"         p2.productName as eaveType,"
                    +"         p2.productPrice as eavePrice,"
                    +"         p2.productHeight as eaveWidth,"
                    +"         p2.productLength as eaveLength,"
                    +"         p4.productName as eaveColor,"
                    +"         eaveAmount,"
                    +"         eaveScrewAmount,"
                    +"         totalScrewAmount,"
                    +"         totalPrice "
                    +"                    "
                    +"         FROM Carport "
                    +"                    "
                    +"         JOIN Products as p1 on woodID = p1.productID "
                    +"         JOIN Products as p2 on eaveID =  p2.productID "
                    +"         JOIN Products as p3 on woodColorID = p3.productID "
                    +"         JOIN Products as p4 on eaveColorID = p4.productID "
                    +"         WHERE carportID = '" + carportID + "';");
            
            
                ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("carportID");
                String carportName = rs.getString("carportName");
                int carportWidth = rs.getInt("carportWidth");
                int carportLength = rs.getInt("carportLength");
                int carportHeight = rs.getInt("carportHeight");
                int roofSlope = rs.getInt("roofSlope");
                String woodType = rs.getString("woodType");
                int woodPrice = rs.getInt("woodPrice");
                int plankHeight = rs.getInt("plankHeight");
                int plankLength = rs.getInt("plankLength");
                String woodColor = rs.getString("woodColor");
                int totalPlankAmount = rs.getInt("totalPlankAmount");
                int plankScrewAmount = rs.getInt("plankScrewAmount");
                String eaveType = rs.getString("eaveType");
                int eavePrice = rs.getInt("eavePrice");
                int eaveWidth = rs.getInt("eaveWidth");
                int eaveLength = rs.getInt("eaveLength");
                String eaveColor = rs.getString("eaveColor");
                int eaveAmount = rs.getInt("eaveAmount");
                int eaveScrewAmount = rs.getInt("eaveScrewAmount");
                int totalScrewAmount = rs.getInt("totalScrewAmount");
                int totalPrice = rs.getInt("totalPrice");

                carport.add(new Carport(id, carportName, carportWidth, carportLength, carportHeight, roofSlope, woodType, woodPrice, plankHeight, plankLength, woodColor, totalPlankAmount, plankScrewAmount, eaveType, eavePrice, eaveWidth, eaveLength, eaveColor, eaveAmount, eaveScrewAmount, totalScrewAmount, totalPrice));

            }

        } catch (SQLException | ClassNotFoundException ex) {

            throw new CarportException(ex.getMessage());

        }
        return carport;
    }

    public static void storeCarport(Carport cp) throws CarportException {
        
        
        String carportName = cp.getCarportName();
        int carportWidth = cp.getCarportWidth();
        int carportLength = cp.getCarportLength();
        int carportHeight = cp.getCarportHeight();
        int roofSlope = cp.getRoofSlope();
        int woodID = cp.getWoodID();
        int woodPrice = cp.getWoodPrice();
        int plankHeight = cp.getPlankHeight();
        int plankLength = cp.getPlankLength();
        int woodColorID = cp.getWoodColorID();
        int totalPlankAmount = cp.getTotalPlankAmount();
        int plankScrewAmount = cp.getPlankScrewAmount();
        int eaveID = cp.getEaveID();
        int eavePrice = cp.getEavePrice();
        int eaveWidth = cp.getEaveWidth();
        int eaveLength = cp.getEaveLength();
        int eaveColorID = cp.getEaveColorID();
        int eaveAmount = cp.getEaveAmount();
        int eaveScrewAmount = cp.getEaveScrewAmount();
        int totalScrewAmount = cp.getTotalScrewAmount();
        int totalPrice = cp.getTotalPrice();

        try {

            PreparedStatement stmt = DBC.preparedStatement("INSERT INTO Carport "
                    + "(carportName,carportWidth,carportLength,carportHeight,roofSLope,woodID, woodPrice,plankHeight,plankLength,woodColorID,totalPlankAmount,plankScrewAmount,"
                    + "eaveID, eavePrice,eaveWidth, eaveLength, eaveColorID,eaveAmount, eaveScrewAmount, totalScrewAmount,totalPrice) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, carportName);
            stmt.setInt(2, carportWidth);
            stmt.setInt(3, carportLength);
            stmt.setInt(4, carportHeight);
            stmt.setInt(5, roofSlope);
            stmt.setInt(6, woodID);
            stmt.setInt(7, woodPrice);
            stmt.setInt(8, plankHeight);
            stmt.setInt(9, plankLength);
            stmt.setInt(10, woodColorID);
            stmt.setInt(11, totalPlankAmount);
            stmt.setInt(12, plankScrewAmount);
            stmt.setInt(13, eaveID);
            stmt.setInt(14, eavePrice);
            stmt.setInt(15, eaveWidth);
            stmt.setInt(16, eaveLength);
            stmt.setInt(17, eaveColorID);
            stmt.setInt(18, eaveAmount);
            stmt.setInt(19, eaveScrewAmount);
            stmt.setInt(20, totalScrewAmount);
            stmt.setInt(21, totalPrice);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Carport succesfully added");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException();
        }
    }

    public static void deleteCarport(int ID) throws CarportException {
        try {

            PreparedStatement stmt = DBC.preparedStatement("DELETE FROM Carport WHERE carportID = '" + ID + "';");

            stmt.execute();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException();
        }
    }

    public static void updateCarport(int ID, Carport c) throws CarportException {

        int roofSlope = c.getRoofSlope();
        int carportWidth = c.getCarportWidth();
        int carportLength = c.getCarportLength();
        int carportHeight = c.getCarportHeight();
        int woodID = c.getWoodID();
        String woodColor = c.getWoodColor();
        int eaveID = c.getEaveID();
        String eaveColor = c.getEaveColor();
        int totalPrice = c.getTotalPrice();

        try {
            PreparedStatement stmt = DBC.preparedStatement("UPDATE Carport SET "
                    + " roofSLope =?,carportWidth=?,carportLength=?,carportHeight=?,woodID=?,woodColor=?,"
                    + "eaveID=?,eaveColor=?,totalPrice=? "
                    + "WHERE carportID = '" + ID + "';");

            stmt.setInt(1, roofSlope);
            stmt.setInt(2, carportWidth);
            stmt.setInt(3, carportLength);
            stmt.setInt(4, carportHeight);
            stmt.setInt(5, woodID);
            stmt.setString(6, woodColor);
            stmt.setInt(7, eaveID);
            stmt.setString(8, eaveColor);
            stmt.setInt(9, totalPrice);
            stmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException();

        }

    }

}
