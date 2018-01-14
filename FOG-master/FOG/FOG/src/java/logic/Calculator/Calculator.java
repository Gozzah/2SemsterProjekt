/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.Calculator;

import data.CarportMapper;
import logic.Exceptions.CarportException;
import logic.entities.carport.Carport;

/**
 *
 * @author Runej
 */
public class Calculator {
    
    public void calculator(Carport c) throws CarportException{
 
                  String carportName = c.getCarportName();
                  int carportWidth = c.getCarportWidth();
                  
                  int carportLength =  c.getCarportLength();
             
                  int carportHeight = c.getCarportHeight();
                
                  int roofSlope = c.getRoofSlope();
                  int woodID =  c.getWoodID();
                  int woodPrice = c.getWoodPrice();
                  int plankHeight = c.getPlankHeight();
                  int plankLength = c.getPlankLength();
                  int woodColorID = c.getWoodColorID();
                  int eaveID = c.getEaveID();
                  int eavePrice = c.getEavePrice();
                  int eaveWidth = c.getEaveWidth();
                  int eaveLength = c.getEaveLength();
                  int eaveColorID = c.getEaveColorID();
                  
                  int plankAmountLength = ((carportWidth + carportLength)*2) /plankLength;
                  int plankAmountHeight = ((carportHeight *4))/plankHeight;
                  int totalPlankAmount = plankAmountHeight + plankAmountLength;
                  int eaveAmount = (carportLength *carportWidth) / (eaveWidth * eaveLength);
                  int plankScrewAmount = totalPlankAmount * 4;
                  int eaveScrewAmount = eaveAmount * 4;
                  int totalScrewAmount = (totalPlankAmount * 4) + (eaveAmount * 4);
                  int totalPrice = (plankAmountHeight + plankAmountLength) * woodPrice;

                  
                  Carport cp = new Carport(carportName,carportWidth,carportLength,carportHeight,roofSlope,woodID, woodPrice,plankHeight, plankLength, woodColorID,totalPlankAmount, plankScrewAmount, eaveID, eavePrice,eaveWidth, eaveLength, eaveColorID,eaveAmount, eaveScrewAmount,totalScrewAmount,totalPrice);
                  CarportMapper.storeCarport(cp);
    }
}
