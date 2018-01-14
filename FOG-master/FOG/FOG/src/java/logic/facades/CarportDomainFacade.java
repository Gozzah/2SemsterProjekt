/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.facades;

import logic.Interfaces.CarportDomainFacadeIF;
import data.facades.CarportDataFacade;
import java.util.List;
import logic.Exceptions.CarportException;
import logic.entities.carport.Carport;

/**
 *
 * @author Runej
 */
public class CarportDomainFacade implements CarportDomainFacadeIF {
    
    CarportDataFacade cdf = new CarportDataFacade();
    
     @Override
    public void storeCarport(Carport c) throws CarportException {
        cdf.storeCarport(c);
    }
    
    @Override
    public void deleteCarport(int ID) throws CarportException {
        cdf.deleteCarport(ID);
    }

    @Override
    public void editCarport(int ID, Carport c) throws CarportException {
        cdf.updateCarport(ID, c);
    }

    @Override
    public List getCarports() throws CarportException {
        List<Carport> carports = cdf.getCarports();
        return carports;
    }
    
     @Override
     public List<Carport> getCarportByID(int carportID) throws CarportException {
        List<Carport> carport = cdf.getCarportByID(carportID);
        return carport;
     }   
}
