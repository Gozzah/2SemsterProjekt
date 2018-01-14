/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.facades;

import data.facades.ProductsDataFacade;
import logic.Interfaces.ProductsDomainFacadeIF;
import java.util.List;
import logic.Exceptions.ProductsException;
import logic.entities.products.Products;

/**
 *
 * @author Runej
 */
public class ProductsDomainFacade implements ProductsDomainFacadeIF {
    
    ProductsDataFacade pdf = new ProductsDataFacade();
    
     @Override
     public List<Products> wood() throws ProductsException {
         List<Products> wood = pdf.wood();
         return wood;
     }
    @Override
      public List<Products> paint() throws ProductsException {
         List<Products> paint = pdf.paint();
         return paint;
     }
    @Override
       public List<Products> eaves() throws ProductsException {
         List<Products> eaves = pdf.eaves();
         return eaves;
     }
    
}
