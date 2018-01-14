/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces;

import java.util.List;
import logic.Exceptions.CarportException;
import logic.entities.carport.Carport;

/**
 *
 * @author Runej
 */
public interface CarportDataFacadeIF {

    boolean deleteCarport(int ID) throws CarportException;

    List<Carport> getCarports() throws CarportException;
    
    List<Carport> getCarportByID(int carportID) throws CarportException;

    void storeCarport(Carport c) throws CarportException;

    void updateCarport(int ID, Carport c) throws CarportException;

    
}
