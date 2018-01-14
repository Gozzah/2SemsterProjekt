/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.facades;

import data.CarportMapper;
import data.interfaces.CarportDataFacadeIF;
import java.util.List;
import logic.Exceptions.CarportException;
import logic.entities.carport.Carport;

/**
 *
 * @author Runej
 */
public class CarportDataFacade implements CarportDataFacadeIF {
    
    CarportMapper cm = new CarportMapper();
    
    @Override
    public List<Carport> getCarports() throws CarportException {
        List<Carport> carports = cm.getCarports();
        return carports;
    }
    
    @Override
     public void storeCarport(Carport c) throws CarportException {
         cm.storeCarport(c);
     }

    @Override
     public boolean deleteCarport(int ID) throws CarportException {
         cm.deleteCarport(ID);
         return true;
     }
     
    @Override
     public void updateCarport(int ID, Carport c) throws CarportException {
         cm.updateCarport(ID,c);
     }
     @Override
     public List<Carport> getCarportByID(int carportID) throws CarportException {
        List<Carport> carport = cm.getCarportByID(carportID);
        return carport;
     }   
       
     
}
