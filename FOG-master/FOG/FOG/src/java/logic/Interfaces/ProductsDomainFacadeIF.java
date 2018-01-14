/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.Interfaces;

import java.util.List;
import logic.Exceptions.ProductsException;
import logic.entities.products.Products;

/**
 *
 * @author Runej
 */
public interface ProductsDomainFacadeIF {

    List<Products> eaves() throws ProductsException;

    List<Products> paint() throws ProductsException;

    List<Products> wood() throws ProductsException;
    
}
