/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.Interfaces;

import java.util.List;
import logic.Exceptions.CarportException;
import logic.entities.carport.Carport;

/**
 *
 * @author Runej
 */
public interface CarportDomainFacadeIF {

    void deleteCarport(int ID) throws CarportException;

    void editCarport(int ID, Carport c) throws CarportException;

    List getCarports() throws CarportException;
    
    List<Carport> getCarportByID(int carportID) throws CarportException;

    void storeCarport(Carport c) throws CarportException;
    
}
