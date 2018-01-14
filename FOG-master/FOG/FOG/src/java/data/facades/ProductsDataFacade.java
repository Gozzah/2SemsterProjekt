/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.facades;

import data.ProductsMapper;
import data.interfaces.ProductsDataFacadeIF;
import java.util.List;
import logic.Exceptions.ProductsException;
import logic.entities.products.Products;

/**
 *
 * @author Runej
 */
public class ProductsDataFacade implements ProductsDataFacadeIF {
    
ProductsMapper pm = new ProductsMapper();
    
     @Override
     public List<Products> wood() throws ProductsException{
         List<Products> wood = pm.wood();
         return wood;
     }
    @Override
      public List<Products> paint() throws ProductsException {
         List<Products> paint = pm.paint();
         return paint;
     }
    @Override
       public List<Products> eaves() throws ProductsException {
         List<Products> eaves = pm.eaves();
         return eaves;
     }
    
}
