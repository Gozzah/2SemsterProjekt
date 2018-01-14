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
import logic.Exceptions.ProductsException;
import logic.entities.products.Products;

/**
 *
 * @author Runej
 */
public class ProductsMapper {

    
    public static List<Products> wood() throws ProductsException {
        List<Products> wood = new ArrayList<>();
        try {
        PreparedStatement stmt = DBC.preparedStatement( "SELECT * FROM Products WHERE subCategory = 'Træsort/planker'");
          
          
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("productID");
                String category = rs.getString("category");
                String subCategory = rs.getString("subCategory");
                String name = rs.getString("productName");
                int productHeight = rs.getInt("productHeight");
                int productLength = rs.getInt("productLength");
                int price = rs.getInt("productPrice");

                wood.add(new Products(productID, category, subCategory, name,productHeight, productLength, price));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ProductsException();
        }
        return wood;
    }

    public static List<Products> paint() throws ProductsException {
        List<Products> paint = new ArrayList<>();
        try {
        PreparedStatement stmt = DBC.preparedStatement("SELECT * FROM Products WHERE subCategory = 'Maling'");
          
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("productID");
                String category = rs.getString("category");
                String subCategory = rs.getString("subCategory");
                String name = rs.getString("productName");
                int productHeight = rs.getInt("productHeight");
                int productLength = rs.getInt("productLength");
                int price = rs.getInt("productPrice");

                paint.add(new Products(productID, category, subCategory, name,productHeight, productLength, price));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ProductsException();
        }
        return paint;
    }


        public static List<Products> eaves() throws ProductsException {
        List<Products> eaves = new ArrayList<>();
        try {
        PreparedStatement stmt = DBC.preparedStatement( "SELECT * FROM Products WHERE subCategory = 'Tagplade type'");
    
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("productID");
                String category = rs.getString("category");
                String subCategory = rs.getString("subCategory");
                String name = rs.getString("productName");
                  int productHeight = rs.getInt("productHeight");
                int productLength = rs.getInt("productLength");
                int price = rs.getInt("productPrice");

                eaves.add(new Products(productID, category, subCategory, name,productHeight, productLength, price));

            }
        } catch (SQLException  | ClassNotFoundException ex) {
            throw new ProductsException();
        }
        return eaves;
    }
             
}


