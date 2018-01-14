/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces;

import java.util.List;
import logic.Exceptions.ProductsException;
import logic.entities.products.Products;

/**
 *
 * @author Runej
 */
public interface ProductsDataFacadeIF {

    List<Products> eaves() throws ProductsException;

    List<Products> paint() throws ProductsException;

    List<Products> wood() throws ProductsException;
    
}
